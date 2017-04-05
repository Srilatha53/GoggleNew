package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.XmapPS_Dao;
import com.niit.model.XMAP_Product_Supplier;
@Service
public class XmapPSServiceImpl implements XmapPSService {

	@Autowired
	private XmapPS_Dao xmappsdao;

	public void addXmapPs(XMAP_Product_Supplier xps) {
		xmappsdao.addXmapPs(xps);

	}


	public List<XMAP_Product_Supplier> displayXmapPS() {
			return xmappsdao.displayXmapPS();
	}

	public void deleteProdSupp(String prosupid) {
		xmappsdao.deleteProdSupp(prosupid);
		
	}


	public XMAP_Product_Supplier getProdSuppById(String prsuid) {
		
		return xmappsdao.getProdSuppById(prsuid);
	}


	public void editProdSupp(XMAP_Product_Supplier prosup) {
		xmappsdao.editProdSupp(prosup);
		
	}



}
