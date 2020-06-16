package com.store.service.impl;

import com.store.model.Producto;
import com.store.repo.IGenericRepo;
import com.store.repo.IProductoRepo;
import com.store.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {
    
    @Autowired
    IProductoRepo productoRepo;

    @Override
    protected IGenericRepo getRepo() {
        return productoRepo;
    }
}
