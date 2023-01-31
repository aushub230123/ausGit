package com.demo.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        SessionFactory sessionFactory;
        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("demo.PersistenceUnit1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = null;
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
//        Transaction transaction =  session.getTransaction();
//        session.beginTransaction();
//        Library library1 = new Library(1,"Library1");
        Library library1 = new Library(2,"Library2");
        entityManager.persist(library1);
//        session.save(library1);
        entityTransaction.commit();
//       transaction.commit();
//       session.close();
        entityManagerFactory.close();
    }
}
