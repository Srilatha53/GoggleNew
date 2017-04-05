package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ViewProductDao;
import com.niit.model.Vw_Xmap_Ps;
@Service
public class ViewProductsServiceImpl implements ViewProductsService {

	

	@Autowired 
	private ViewProductDao vpd;

	public List<Vw_Xmap_Ps> getVwPs() {
		return vpd.getVwPs();
	}

	public List<Vw_Xmap_Ps> getBestVwPs() {
		// TODO Auto-generated method stub
		return vpd.getBestVwPs();
	}
	
	public List<Vw_Xmap_Ps> getAllSuppProducts(String pid) {
		return vpd.getAllSuppProducts(pid);
	}

/*	public void deleteProdSupp(String prosupid) {
		vpd.deleteProdSupp(prosupid);
	}

	public Vw_Xmap_Ps getProdSuppById(String prsuid) {
		
		return vpd.getProdSuppById(prsuid);
	}

	public void editProdSupp(Vw_Xmap_Ps prosup) {
		vpd.editProdSupp(prosup);		
	}
	*/

}
