
package DAO;

import java.util.List;


public interface DAO <T> {
    
      public T crear(T entity);
    
    public void delete(T entity);
    
    public T modificar(T entity);
        
    public List<T> consulta();
        
}
