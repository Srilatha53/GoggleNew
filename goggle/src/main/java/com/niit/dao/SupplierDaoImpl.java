package com.niit.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;
@Repository	
public class SupplierDaoImpl implements SupplierDao {

@Autowired
private SessionFactory sf;

	@Transactional
	public void addSuppliers(Supplier s) {
		Session sess=sf.openSession();
		Transaction t =sess.beginTransaction();
		s.setSupplierid(generateSupplierid());
		sess.save(s);
		saveSupplierImage(s);
		t.commit();
		sess.close();
	}

	private void saveSupplierImage(Supplier s) {
		System.out.print("\nprd img : " + s.getSupimagefile());	
		
		try{				    	
			if (s.getSupimagefile() != null ) {			
	           	Path path=Paths.get("C://Project//goggle//src//main//webapp//resources//images//suppliers//"+s.getSupplierid()+".jpg");	
	           	s.getSupimagefile().transferTo(new File(path.toString()));                       	
	            System.out.print("\nSupplier Image saved");	            
	        }				
		}
		catch(Exception ex){
			System.out.print("\nSupplier Image not saved...");
		}	
		
	}
	@Transactional
	public void deleteSupplier(String supid) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Supplier temp = ses.get(Supplier.class, supid);
		ses.delete(temp);
		tr.commit();
		ses.close();
	}

	@Transactional
	private String generateSupplierid() {
		String newSid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from Supplier");
		List<Supplier> data = qr.list();
		s.close();
		if(data.size()==0){
			newSid="SUP00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(supplierid) from Supplier");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newSid="SUP0000"+id;
			else if(id<=99)
				newSid="SUP000"+id;
			else if(id<=999)
				newSid="SUP00"+id;
			else if(id<=9999)
				newSid="SUP0"+id;
			else
				newSid="SUP"+id;		
			System.out.print("\nGenerated : "+newSid);		
			ss.close();		
		}
			return newSid;
	}
	@Transactional
	public List<Supplier> getSuppliers() {
		Session ses = sf.openSession();
		Query qr = ses.createQuery("from Supplier");
		List<Supplier> data = qr.list();
		ses.close();
		return data;
	}

	
	@Transactional
	public Supplier getSupplierById(String sid) {
		Session ses = sf.openSession();
		Supplier temp = ses.get(Supplier.class, sid);
		ses.close();		
		return temp;
	}

	
	@Transactional
	public void editSupplier(Supplier sup) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(sup);
		tr.commit();
		ses.close();	
	}
	
	

}
