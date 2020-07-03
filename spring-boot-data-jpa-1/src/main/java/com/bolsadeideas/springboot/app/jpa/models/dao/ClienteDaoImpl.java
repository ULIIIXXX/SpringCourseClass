package com.bolsadeideas.springboot.app.jpa.models.dao;

import com.bolsadeideas.springboot.app.jpa.models.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClienteDaoImpl implements ICliente{

    @PersistenceContext
    private EntityManager entityManager;  //Permite la amdinistracion de querys es el que se encarga de las operaciones de la DB

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("from cliente").getResultList();
    }
}
