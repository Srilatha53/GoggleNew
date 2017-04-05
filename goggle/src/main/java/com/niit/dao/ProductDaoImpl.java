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

import com.niit.model.Product;


@Repository
public class ProductDaoImpl implements ProductDao {
@Autowired
private SessionFactory sessionF;

@Transactional
public void addProducts(Product p) {
	Session ses = sessionF.openSession();
	Transaction tr = ses.beginTransaction();
	p.setProductid(generateProductId());
	ses.save(p);
	saveProductImage(p);
	tr.commit();
	ses.close();
}

@Transactional
public List<Product> getProducts() {
	Session ses = sessionF.openSession();
	Query qr = ses.createQuery("from Product");
	List<Product> data = qr.list();
	ses.close();
	return data;
}

private void saveProductImage(Product prd){
	
	System.out.print("\nprd img : " + prd.getImagefile());	
		
	try{				    	
		if (prd.getImagefile() != null ) {				
           	Path path=Paths.get("C://Project//goggle//src//main//webapp//resources//images//products//"+prd.getProductid()+".jpg");	
           	prd.getImagefile().transferTo(new File(path.toString()));                       	
            System.out.print("\nProduct Image saved");	            
        }				
	}
	catch(Exception ex){
		System.out.print("\nProduct Image not saved...");
	}				
}

@Transactional
private String generateProductId(){
	
	String newPid="";
	
	Session s = sessionF.openSession();
	Query qr = s.createQuery("from Product");
	List<Product> data = qr.list();
	s.close();
	if(data.size()==0){
		newPid="PRD00001";
	}
	else{
		Session ss = sessionF.openSession();		
		Query q = ss.createQuery("select max(productid) from Product");
		String prevId = q.list().get(0).toString();
		System.out.print("\nExisting : "+prevId);
		int id = Integer.parseInt(prevId.substring(3));
		System.out.print("\nExisting id : "+id);		
		id=id+1;
		if(id<=9)
			newPid="PRD0000"+id;
		else if(id<=99)
			newPid="PRD000"+id;
		else if(id<=999)
			newPid="PRD00"+id;
		else if(id<=9999)
			newPid="PRD0"+id;
		else
			newPid="PRD"+id;		
		System.out.print("\nGenerated : "+newPid);		
		ss.close();		
	}
		return newPid;
}
@Transactional
public void deleteProduct(String proid) {
	/*Session ses = sessionF.openSession();
	Transaction tr = ses.beginTransaction();
	Product temp = ses.get(Product.class, proid);
	ses.delete(temp);
	tr.commit();
	ses.close();*/
	Session ses = sessionF.openSession();
	Transaction tr = ses.beginTransaction();
	Product temp = ses.get(Product.class, proid);
	ses.delete(temp);
	tr.commit();
	ses.close();	
}
/*public Product editProducts(String productid) {
	Session session=sessionF.openSession();
	//select * from product where id=34
	Product prd=(Product)session.get(Product.class,productid);
	session.close();
	return prd;
}*/


@Transactional
public Product getProductById(String pid) {
	Session ses = sessionF.openSession();
	Product temp = ses.get(Product.class, pid);
	ses.close();		
	return temp;
}


@Transactional
public void editProduct(Product prd) {
	Session ses = sessionF.openSession();
	Transaction tr = ses.beginTransaction();
	ses.update(prd);
	tr.commit();
	ses.close();
	
}


}
