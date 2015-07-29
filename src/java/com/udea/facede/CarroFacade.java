/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.facede;

import com.udea.persistencia.Carro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Manuel Ochoa Loaiza
 */
@Stateless
public class CarroFacade extends AbstractFacade<Carro> {
    @PersistenceContext(unitName = "ConcesionarioCRUDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroFacade() {
        super(Carro.class);
    }
    
}
