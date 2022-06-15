
package libreria1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria1.service.AutorService;


public class Libreria1 {

  
    public static void main(String[] args) throws Exception {
        
         EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Libreria1PU");
        EntityManager EM = EMF.createEntityManager();
    
        AutorService as = new AutorService();
        
        try{
           // as.crearAutor("Stephen King", Boolean.TRUE);
          //  as.eliminarAutor(2);
          //  as.modificarAutor("García Marquez", 1);
         // as.consultas();
         as.consultarPorNombre();
        }catch(Exception e){
            throw e;
        }
        
        
        
    }
    
}
