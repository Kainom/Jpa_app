package infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Dao<E> {
    private static EntityManagerFactory emf;
    private final EntityManager em;
    private final Class<E> classe;
    static {
        try{
            emf = Persistence.createEntityManagerFactory("jpa");
        } catch (Exception e){
            System.out.println(String.valueOf(e));
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
    public E getById(Long id){
        return em.find(this.classe,id);
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
        return this.getAll(10,0);
    }

    public List<E> consultar(String nomeConsulta,Object... params){
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, this.classe);
        for(int i=0; i<params.length; i+=2){
            query.setParameter(params[i].toString(),params[i +1]);
        }
        return query.getResultList();
    }

    public void close(){
        em.close();
    }

}
