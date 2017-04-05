package com.niit.dao;

import java.util.List;


import com.niit.model.Vw_Xmap_Ps;

public interface ViewProductDao {
	public abstract List<Vw_Xmap_Ps> getVwPs();
	public abstract List<Vw_Xmap_Ps> getBestVwPs();
	public abstract List<Vw_Xmap_Ps> getAllSuppProducts(String pid);
/*	public abstract void deleteProdSupp(String prosupid);
	public abstract Vw_Xmap_Ps getProdSuppById(String prsuid);
	public abstract void editProdSupp(Vw_Xmap_Ps prosup);*/

}
