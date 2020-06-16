package com.store.repo;

import com.store.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepo extends IGenericRepo<Persona, Integer> {
}
