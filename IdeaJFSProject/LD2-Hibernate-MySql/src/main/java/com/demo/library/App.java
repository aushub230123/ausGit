package com.demo.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "HIBERNATE" );
        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("demo.PersistenceUnit1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Library library1 = new Library(1,"Library1");
//        Library library1 = new Library(2,"Library2");
        entityManager.persist(library1);
        entityTransaction.commit();
        entityManagerFactory.close();
    }
}
