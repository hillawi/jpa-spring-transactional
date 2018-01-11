package org.hill.tx.service;

import org.hill.tx.entity.Customer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class CustomerService implements InitializingBean {
    @Autowired
    private EntityManagerFactory emf;

    @Transactional(transactionManager = "jpaTransactionManager")
    public void save(Customer customer) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(customer);
        entityManager.flush();
    }

    public Customer find(long id) {
        EntityManager entityManager = emf.createEntityManager();
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Initialization done.");
    }
}
