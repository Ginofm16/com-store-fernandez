package com.store.service.impl;

import com.store.model.Persona;
import com.store.repo.IGenericRepo;
import com.store.repo.IPersonaRepo;
import com.store.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    @Autowired
    IPersonaRepo personaRepo;

    @Override
    protected IGenericRepo getRepo() {
        return personaRepo;
    }
}
