package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {
	
@Autowired
private SupplierDao sd;
public void addSuppliers(Supplier s) {
		sd.addSuppliers(s);
	}

	public List<Supplier> getSuppliers() {
		return sd.getSuppliers();
	}


	public void deleteSupplier(String supid) {
		sd.deleteSupplier(supid);
	}

	public Supplier getSupplierById(String sid) {
		return sd.getSupplierById(sid);
	}


	public void editSupplier(Supplier sup) {
		sd.editSupplier(sup);
		
	}
	
	
}
