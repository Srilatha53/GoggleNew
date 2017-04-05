package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Product;
import com.niit.model.ProductSurvey;
import com.niit.model.UserOrder;
import com.niit.model.UserOrderHistory;
import com.niit.model.XMAP_Product_Supplier;

@Repository
public class UserOrderDaoImpl implements UserOrderDao {

	
	@Autowired
	private SessionFactory sf;
	
	public void addUserOrder(Cart cart) {
		UserOrder uo=new UserOrder();
		uo.setOrderid(generateOrderId());
		uo.setCart(cart);
		uo.setCustomer(cart.getCustomer());
		uo.setBillAdd(cart.getCustomer().getBillingAddress());
		uo.setShiAdd(cart.getCustomer().getShippingAddress());
		
		// to insert data in UserOrder table
		
		Session ses=sf.openSession();
		ses.save(uo);
		
		// to update grandtotal in cart table
		
		List<CartItem> cartitems=cart.getCartItems();
		for(CartItem cartItem:cartitems){
			UserOrderHistory orderHistory = new UserOrderHistory();
			orderHistory.setOdrhistoryid(generateOrderHistoryId());
			orderHistory.setUserOrder(uo);
			orderHistory.setPrice(cartItem.getxPS().getPsprice());
			orderHistory.setProductid(cartItem.getxPS().getProductid());
			orderHistory.setSupplierid(cartItem.getxPS().getSupplierid());
			orderHistory.setQuantity(cartItem.getQuantity());
			orderHistory.setTotal(cartItem.getItemwisetotal());
			orderHistory.setReviewgiven(false);
			ses.save(orderHistory);			
			ses.flush();
			XMAP_Product_Supplier xps = cartItem.getxPS();
			xps.setPsstock(xps.getPsstock()-cartItem.getQuantity());
			ses.update(xps);
			ses.flush();		
		}
			ses.close();		
		
		Session s = sf.openSession();
		cart.setGrandtotal(0.0);
		s.update(cart);
		s.flush();
		s.close();
		
		/*double grandTotal=0.0;
		for(CartItem cartItem:cartItems){
			grandTotal = grandTotal + cartItem.getItemwisetotal();
		}
		
		cart.setGrandtotal(grandTotal);
		
		//update cart set grandTotal=? where cartid=?
		
		ses.update(cart);
		ses.flush();
		ses.close();*/
	}
	
	public List<UserOrder> custOrders(String custmerid) {
		String hq = "from UserOrder where custmerid='"+custmerid+"'";
		Session ses = sf.openSession();
		Query qr = ses.createQuery(hq);		
		List<UserOrder> orders = qr.list();
		ses.close();
		return orders;
	}

	public void addProductReview(ProductSurvey psur) {
		Session ses = sf.openSession();
		psur.setSurveyid(generateProductSurveyId());
		ses.save(psur);
		ses.flush();
		ses.close();
	}

	
private String generateProductSurveyId() {
	String newPRid="";
	
	Session s = sf.openSession();
	Query qr = s.createQuery("from ProductSurvey");
	List<Product> data = qr.list();
	s.close();
	if(data.size()==0){
		newPRid="SUR00001";
	}
	else{
		Session ss = sf.openSession();		
		Query q = ss.createQuery("select max(surveyid) from ProductSurvey");
		String prevId = q.list().get(0).toString();
		System.out.print("\nExisting : "+prevId);
		int id = Integer.parseInt(prevId.substring(4));
		System.out.print("\nExisting id : "+id);		
		id=id+1;
		if(id<=9)
			newPRid="SUR0000"+id;
		else if(id<=99)
			newPRid="SUR000"+id;
		else if(id<=999)
			newPRid="SUR00"+id;
		else if(id<=9999)
			newPRid="SUR0"+id;
		else
			newPRid="SUR"+id;		
		System.out.print("\nGenerated : "+newPRid);		
		ss.close();		
	}
		return newPRid;
}



private String generateOrderId(){
		
		String newOid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from UserOrder");
		List<Product> data = qr.list();
		s.close();
		if(data.size()==0){
			newOid="ORD00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(orderid) from UserOrder");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newOid="ORD0000"+id;
			else if(id<=99)
				newOid="ORD000"+id;
			else if(id<=999)
				newOid="ORD00"+id;
			else if(id<=9999)
				newOid="ORD0"+id;
			else
				newOid="ORD"+id;		
			System.out.print("\nGenerated : "+newOid);		
			ss.close();		
		}
			return newOid;
	}
	
	private String generateOrderHistoryId(){
		
		String newOHid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from UserOrderHistory");
		List<Product> data = qr.list();
		s.close();
		if(data.size()==0){
			newOHid="ORDH00001";
		}
		else{
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(odrhistoryid) from UserOrderHistory");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(4));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newOHid="ORDH0000"+id;
			else if(id<=99)
				newOHid="ORDH000"+id;
			else if(id<=999)
				newOHid="ORDH00"+id;
			else if(id<=9999)
				newOHid="ORDH0"+id;
			else
				newOHid="ORDH"+id;		
			System.out.print("\nGenerated : "+newOHid);		
			ss.close();		
		}
			return newOHid;
	}

	
}
