package com.niit.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Vw_Xmap_Ps;

@Repository
public class ViewProductDaoImpl implements ViewProductDao {



@Autowired
private SessionFactory s;
@Transactional
public List<Vw_Xmap_Ps> getVwPs() {
		Session ses=s.openSession();
		Query qr = ses.createQuery("from Vw_Xmap_Ps");
		List<Vw_Xmap_Ps> data = qr.list();
		ses.close();
		return data;
	}

@Transactional
	public List<Vw_Xmap_Ps> getBestVwPs() {
		Session ses = s.openSession();
		int n=randomNumforThumbnails();
		String qry = "from Vw_Xmap_Ps x1 where psprice=(select min(psprice) from Vw_Xmap_Ps x2 where x1.productid=x2.productid)";
		//String qry = "from Vw_Xmap_Ps x1 where psprice=(select min(psprice) from Vw_Xmap_Ps x2 where x1.productid=x2.productid) order by " +n ;
		Query qr = ses.createQuery(qry);
		List<Vw_Xmap_Ps> data = qr.list();
		ses.close();
		return data;
	}
	@Transactional
	public  int randomNumforThumbnails(){
		 int min,max;
		 min=1;
		 max=6;
		 Random random=new Random();
		 int num=random.nextInt((max-min)+1)+min;
		 return num;
	 }

	public List<Vw_Xmap_Ps> getAllSuppProducts(String pid) {
		Session ses = s.openSession();
		String qry = "from Vw_Xmap_Ps where productid=?";		
		Query qr = ses.createQuery(qry);
		qr.setParameter(0, pid);
		List<Vw_Xmap_Ps> data = qr.list();
		ses.close();		
		return data;
	}

/*	public void deleteProdSupp(String prosupid) {
		Session ses = s.openSession();
		Transaction tr = ses.beginTransaction();
		Vw_Xmap_Ps temp = ses.get(Vw_Xmap_Ps.class, prosupid);
		ses.delete(temp);
		tr.commit();
		ses.close();
		
	}



	public Vw_Xmap_Ps getProdSuppById(String prsuid) {
		Session ses = s.openSession();
		Vw_Xmap_Ps temp = ses.get(Vw_Xmap_Ps.class, prsuid);
		ses.close();		
		return temp;
	}


	public void editProdSupp(Vw_Xmap_Ps prosup) {
		Session ses = s.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(prosup);
		tr.commit();
		ses.close();
	}
*/

	

}
