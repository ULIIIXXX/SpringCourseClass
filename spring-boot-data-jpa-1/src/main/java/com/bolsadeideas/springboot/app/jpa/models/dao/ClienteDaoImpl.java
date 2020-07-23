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
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Transactional    //Esta anotaciones miuy importante para pasar la peticion ya que presisa se runa transaccion
    @Override
    public void save(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId()> 0){
            entityManager.merge(cliente);      //Merge actualiza el registro existente
        }else{
            entityManager.persist(cliente);   //Persist crea un nuevo registro
        }

    }

    @Override
    public Cliente findOne(Long id) {
        return entityManager.find(Cliente.class, id);   //Se necesita buscar un elemento de tipo Cliente mediante el id proveido
    }
}
