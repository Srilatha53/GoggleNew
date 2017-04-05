package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.XMAP_Product_Supplier;

@Repository
public class XmapPS_DaoImpl implements XmapPS_Dao {

	@Autowired
	private SessionFactory sf;
	
	@Transactional
	public void addXmapPs(XMAP_Product_Supplier xps) {
	Session ses=sf.openSession();	
	Transaction t=ses.beginTransaction();
	xps.setPsid(generatepsid());
	ses.save(xps);
	t.commit();
	ses.close();

	}

	@Transactional
	public List<XMAP_Product_Supplier> displayXmapPS() {
		Session s=sf.openSession();
		Query q=s.createQuery("from XMAP_Product_Supplier");
		List<XMAP_Product_Supplier> data=q.list();
				return data;
	}
	
	
	@Transactional
	public String generatepsid()
	{
		String newPSid="";
		Session ses=sf.openSession();
		Query qr = ses.createQuery("from XMAP_Product_Supplier");
		List<XMAP_Product_Supplier> data = qr.list();
		ses.close();
		if(data.size()==0){
			newPSid="XPS00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(psid) from XMAP_Product_Supplier");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newPSid="XPS0000"+id;
			else if(id<=99)
				newPSid="XPS000"+id;
			else if(id<=999)
				newPSid="XPS00"+id;
			else if(id<=9999)
				newPSid="XPS0"+id;
			else
				newPSid="XPS"+id;		
			System.out.print("\nGenerated : "+newPSid);		
			ss.close();		
		}
		return newPSid;
	}


	public void deleteProdSupp(String prosupid) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		XMAP_Product_Supplier temp = ses.get(XMAP_Product_Supplier.class, prosupid);
		ses.delete(temp);
		tr.commit();
		ses.close();	
		
	}

	public XMAP_Product_Supplier getProdSuppById(String prsuid) {
		Session ses = sf.openSession();
		XMAP_Product_Supplier temp = ses.get(XMAP_Product_Supplier.class, prsuid);
		ses.close();		
		return temp;
	}

	
	public void editProdSupp(XMAP_Product_Supplier prosup) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(prosup);
		tr.commit();
		ses.close();	
		
	}
	

}
