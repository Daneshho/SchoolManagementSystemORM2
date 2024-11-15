package ir.maktabsharif.database;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public final class DbManager {

    private static EntityManager em;
    private static EntityManagerFactory factory;

    public static void close() {
        em.close();
        factory.close();
    }

    public static EntityManager getFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("jdbc-postgres");
            em = factory.createEntityManager();
            return em;
        } else return em;
    }
}