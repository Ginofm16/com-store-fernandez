package com.store.service.impl;

import com.store.repo.IGenericRepo;
import com.store.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T registrar(T obj) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(obj);
	}

	@Override
	public T modificar(T obj) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(obj);
	}

	@Override
	public List<T> listar() throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
		
	}
	
	
	
}
