package com.niit.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Customer;
import com.niit.model.UserDetails;

@Repository
class UserDetailsDaoImpl implements UserDetailsDao {
	public Customer getCustomerById(String cid) {
		Session ses = sf.openSession();
		Customer temp = ses.get(Customer.class, cid);
		ses.close();		
		return temp;
	}

	@Autowired
	private SessionFactory sf;
	@Transactional
	public String addUser(UserDetails ud) {
			System.out.println("before dao");
			
			Session ses=sf.openSession();
			Transaction tr= ses.beginTransaction();
			ud.setUserid(generateUserId());
			ud.setRole("ROLE_USER");
			ud.setEnabled(true);
			ses.save(ud);
		/*	saveUserImage(ud);*/
			tr.commit();
			ses.close();
			System.out.println("after dao");
			return ud.getUserid();	
			}

		@Transactional
	public UserDetails loginCheck(UserDetails ud) {
		Session ses= sf.openSession();
		Query qr=ses.createQuery("from UserDetails where userid=? and password=? and enabled=true");
		qr.setParameter(0,ud.getUserid());
		qr.setParameter(1,ud.getPassword());
		//qr.list(); //returns multiple records
		UserDetails t=(UserDetails)qr.uniqueResult();//returns single record
		
		return t;

	}
		
		
		
		
	public void editPassword(UserDetails us) {
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.update(us);
		tr.commit();
		ses.close();
			
		}

	@Transactional
		private String generateUserId(){	
			
			String newUid="";
			
			Session s = sf.openSession();
			Query qr = s.createQuery("from UserDetails");
			List<UserDetails> data = qr.list();
			s.close();
			if(data.size()==0){
				newUid="USR00001";
			}
			else {			
				Session ss = sf.openSession();		
				Query q = ss.createQuery("select max(userid) from UserDetails");
				String prevId = q.list().get(0).toString();
				System.out.println(prevId);
				System.out.print("\nExisting : "+prevId);
				int id = Integer.parseInt(prevId.substring(3));
				System.out.print("\nExisting id : "+id);		
				id=id+1;
				if(id<=9)
					newUid="USR0000"+id;
				else if(id<=99)
					newUid="USR000"+id;
				else if(id<=999)
					newUid="USR00"+id;
				else if(id<=9999)
					newUid="USR0"+id;
				else
					newUid="USR"+id;		
				System.out.print("\nGenerated : "+newUid);
				
				ss.close();
			}
			return newUid;
		}
		/*private void saveUserImage(Customer usr){
			
			System.out.print("\nprd img : " + usr.getImagefile());	
				
			try{				    	
				if (usr.getImagefile() != null ) {				
		           	Path path=Paths.get("C://Project//goggle//src//main//webapp//resources//images//users//"+usr.getCustomerid()+".jpg");	
		           	usr.getImagefile().transferTo(new File(path.toString()));                       	
		            System.out.print("\nUser Image saved");	            
		        }				
			}
			catch(Exception ex){
				System.out.print("\nUser Image not saved...");
			}				
		}
*/
		@Transactional
		public UserDetails getUserDetailsById(String uid) {
			Session ses = sf.openSession();
			UserDetails temp = ses.get(UserDetails.class, uid);
			ses.close();		
			return temp;
		}

	@Transactional
		public void editUserDetails(UserDetails usr) {
			Session ses = sf.openSession();
			Transaction tr = ses.beginTransaction();
			usr.getUserid();
			Customer t=new Customer();
			usr.setCustomer(t);
			usr.setEnabled(true);
			usr.setRole("ROLE_USER");
			ses.update(usr);
			tr.commit();
			ses.close();
			
		}
		
		
		@Transactional
		public void enableUser(String uid) {
			Session ses = sf.openSession();
			UserDetails user = ses.get(UserDetails.class, uid);
			user.setEnabled(true);
			ses.update(user);
			ses.flush();
			ses.close();
		}
		
		
		

		public void disableUser(String uid) {
			Session ses = sf.openSession();
			UserDetails user = ses.get(UserDetails.class, uid);
			user.setEnabled(false);
			ses.update(user);
			ses.flush();
			ses.close();
			
		}

		public List<UserDetails> getAllUsers() {
			Session ses = sf.openSession();
			Query qr = ses.createQuery("from UserDetails where userid like 'USR%'");
			List <UserDetails> userdata = qr.list();
			ses.flush();
			ses.close();
			return userdata;
		}
}

