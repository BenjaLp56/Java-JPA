package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import libreria1.entidades.Editorial;

public class EditorialDAO implements DAO<Editorial> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Libreria1PU");
    protected EntityManager em = EMF.createEntityManager();

    @Override
    public Editorial crear(Editorial entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Editorial entity) {

        entity.setAlta(false);
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

    }

    public Editorial consularId(Integer id) {
        Editorial editorial = em.find(Editorial.class, id);

        return editorial;
    }
    
    public void cambio(){
        
    }

    @Override
    public Editorial modificar(Editorial entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;

    }

    @Override
    public List<Editorial> consulta() {
        
        
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.alta = true")
                .getResultList();
        
        for (Editorial i : editoriales) {
            System.out.println("Nombre del autor: " + i.getNombre());

        }
        return editoriales;

    }

}
