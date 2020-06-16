package com.store.service;

import com.store.model.Venta;

public interface IVentaService extends ICRUD<Venta, Integer> {

    Venta registrarTransaccional(Venta venta) throws Exception;

}
