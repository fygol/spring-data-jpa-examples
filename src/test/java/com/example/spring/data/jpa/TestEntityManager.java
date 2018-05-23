package com.example.spring.data.jpa;

import com.example.spring.data.jpa.dao.ProductDao;
import com.example.spring.data.jpa.dao.ProductDao2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEntityManager {
//    @Autowired ProductDao repo1;
//
//    @Autowired ProductDao2 repo2;

    @PersistenceContext
    EntityManager em1;

    @PersistenceContext
    EntityManager em2;

    @Test
    public void simpleTest() {
        em1.clear();
        System.out.println("DONE");
    }
}
