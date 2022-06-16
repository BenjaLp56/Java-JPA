package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import libreria1.entidades.Libro;

public class LibroDAO implements DAO<Libro> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Libreria1PU");
    protected EntityManager em = EMF.createEntityManager();

    @Override
    public Libro crear(Libro entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Libro entity) {
        entity.setAlta(false);
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
     public Libro consularId(Integer isbn) {
        Libro libro = em.find(Libro.class, isbn);

        return libro;
    }

    @Override
    public Libro modificar(Libro entity) {
       em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Libro> consulta() {

           List<Libro> libros = em.createQuery("SELECT l FROM Libro WHERE l.alta = true")
                .getResultList();

        for (Libro i : libros) {
            System.out.println("Nombre del autor: " + i.getTitulo());

        }
        return libros;

    }
    
     public List<Libro> consultaPorBaja() {

        List<Libro> libros = em.createQuery("SELECT a FROM Autor a WHERE a.alta = false")
                .getResultList();

        for (Libro i : libros) {
            System.out.println("Nombre del autor: " + i.getTitulo());
        }
        return libros;
    }
     
        public void buscarXEditorial(){
            
    
}
        
        
        public Libro buscarXIsbn(){
            int isbn = 23;
            
            Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn ")
                    .setParameter("isbn", isbn).getSingleResult();
            
            return libro;
        }

}
