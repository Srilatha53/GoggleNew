package com.niit.dao;

import java.util.List;


import com.niit.model.XMAP_Product_Supplier;

public interface XmapPS_Dao {
	public abstract void addXmapPs(XMAP_Product_Supplier xps);
	public abstract List<XMAP_Product_Supplier> displayXmapPS();
	public abstract void deleteProdSupp(String prosupid);
	public abstract XMAP_Product_Supplier getProdSuppById(String prsuid);
	public abstract void editProdSupp(XMAP_Product_Supplier prosup);

}
