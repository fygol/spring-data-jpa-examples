package com.example.spring.data.jpa.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class ProductDaoImpl2 implements ProductDao2 {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection loadProductsByCategory(String category) {
        return null;
    }
}
