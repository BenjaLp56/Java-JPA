package DAO;

import java.util.List;
import javax.persistence.*;
import libreria1.entidades.Autor;

public class AutorDAO implements DAO<Autor> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Libreria1PU");
    protected EntityManager em = EMF.createEntityManager();

    @Override
    public Autor crear(Autor entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Autor entity) {
        entity.setAlta(false);
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public Autor consularId(Integer id) {
        Autor autor = em.find(Autor.class, id);

        return autor;
    }

    @Override
    public Autor modificar(Autor entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Autor> consulta() {

        List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.alta = true")
                .getResultList();

        for (Autor i : autores) {
            System.out.println("Nombre del autor: " + i.getNombre());

        }
        return autores;
    }

    public List<Autor> consultaPorBaja() {

        List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.alta = false")
                .getResultList();

        for (Autor i : autores) {
            System.out.println("Nombre del autor: " + i.getNombre());
        }
        return autores;
    }

    public Autor buscarXNombre(String nombre) {
        
        
        return (Autor)  em.createQuery("SELEC a FROM Autor a WHERE nombre = ?1 ")
                .setParameter(1, nombre).getSingleResult();

    }
    
    


}
