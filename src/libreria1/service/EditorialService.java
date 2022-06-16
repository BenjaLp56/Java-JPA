
package libreria1.service;

import DAO.EditorialDAO;
import java.util.Scanner;
import libreria1.entidades.Editorial;


public class EditorialService {
    
    Scanner read = new Scanner(System.in).useDelimiter("\n");
    
    private final EditorialDAO dao;
    
    public EditorialService(){
        this.dao = new EditorialDAO();
    }
    
        public Editorial crearEditorial(String nombre, Boolean alta) throws Exception {
        try {
            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
//            autor.setId(1);
            dao.crear(editorial);
            return editorial;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
        
         public void eliminarEditorial(Integer id) throws Exception {
        try {
            Editorial editorial = dao.consularId(id);

            dao.delete(editorial);

        } catch (Exception e) {
            throw e;
        }
    }
         public void modificarEditorial(String nombre, Integer id) throws Exception {
        try {
            Editorial editorial = dao.consularId(id);
            editorial.setNombre(nombre);

            dao.modificar(editorial);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
