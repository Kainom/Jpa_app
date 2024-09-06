package infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Dao<E> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;
    static {
        try{
            emf = Persistence.createEntityManagerFactory("jpa");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Dao(){
        this(null);
    }
    public Dao(Class<E> classe){
        this.classe = classe;
        this.em = emf.createEntityManager();
    }


    public Dao<E> openTransaction(){
        em.getTransaction().begin();
            return this;

    }

    public Dao<E> closeTransaction(){
        em.getTransaction().commit();
        return this;
    }

    public Dao<E> include(E entity){
        em.persist(entity);
        return this;
    }

    public Dao<E> includeAtomic(E entity){
        return  this.openTransaction().include(entity).closeTransaction();
    }

    public List<E> getAll(int qtd, int  displ){
        if(classe == null){
            throw new UnsupportedOperationException("Class is null");

        }
        String jpql = "SELECT e FROM " + this.classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql,this.classe);
        query.setMaxResults(qtd);
        query.setFirstResult(displ);
        return query.getResultList();
    }

    public List<E> getAll(){
        return this.getAll(0,0);
    }

    public void close(){
        em.close();
    }

}
