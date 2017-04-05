package com.niit.dao;

import java.util.List;
import com.niit.model.Supplier;

public interface SupplierDao {
	public abstract void addSuppliers(Supplier s);
	public abstract List<Supplier> getSuppliers();
	public abstract void deleteSupplier(String supid);
	public abstract Supplier getSupplierById(String sid);
	public abstract void editSupplier(Supplier sup);
}
