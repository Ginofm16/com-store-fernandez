package com.store.repo;

import com.store.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepo extends IGenericRepo<Producto, Integer> {
}
