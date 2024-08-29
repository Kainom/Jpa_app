package br.com.kainom.app.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
            private final static EntityManagerFactory APPJPA;
      static {
         APPJPA = Persistence.createEntityManagerFactory("appJpa");

      }

    public  static EntityManager getEntityManagerAPPjpa(){
            return APPJPA.createEntityManager();
    }



}
