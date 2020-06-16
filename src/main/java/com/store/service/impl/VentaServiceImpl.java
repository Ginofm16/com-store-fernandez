package com.store.service.impl;

import com.store.model.Venta;
import com.store.repo.IGenericRepo;
import com.store.repo.IVentaRepo;
import com.store.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {
    
    @Autowired
    IVentaRepo ventaRepo;

    @Override
    protected IGenericRepo getRepo() {
        return ventaRepo;
    }

    @Transactional
    @Override
    public Venta registrarTransaccional(Venta venta) throws Exception {

        venta.getDetalleVenta().forEach(dv -> dv.setVenta(venta));
        ventaRepo.save(venta);
        return venta;
    }
}
