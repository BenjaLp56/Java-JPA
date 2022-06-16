package libreria1.service;

import DAO.AutorDAO;
import java.util.List;
import java.util.Scanner;
import libreria1.entidades.Autor;

public class AutorService {

    Scanner read = new Scanner(System.in).useDelimiter("\\n");

    private final AutorDAO dao;

    public AutorService() {
        this.dao = new AutorDAO();
    }

    public Autor crearAutor(String nombre, Boolean alta) throws Exception {
        try {
            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(alta);
//            autor.setId(1);
            dao.crear(autor);
            return autor;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void eliminarAutor(Integer id) throws Exception {
        try {
            Autor autor = dao.consularId(id);

            dao.delete(autor);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarAutor(String nombre, Integer id) throws Exception {
        try {
            Autor autor = dao.consularId(id);
            autor.setNombre(nombre);

            dao.modificar(autor);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void consultas() throws Exception {
        try {
            System.out.println("Indiquie que autores quiere ver si los que estan de baja o alta");
            String filtro = read.next();

            if (filtro.equalsIgnoreCase("alta")) {
                List<Autor> autoresAlta = dao.consulta();
            } else if (filtro.equalsIgnoreCase("baja")) {
                List<Autor> autoresBaja = dao.consultaPorBaja();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void consultarPorNombre() throws Exception {
        try {

            System.out.println("Indiquie el nombre del autor que desea mostrar");
            String nom = read.next();

            dao.buscarXNombre(nom);

        } catch (Exception e) {
            throw e;
        }
    }
}
