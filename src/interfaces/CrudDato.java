/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
/**
 *
 * @author Luis Fernando
 */
public interface CrudDato <dato> {
    
    public boolean create(dato c);
    public boolean delete (Object key);
    public boolean update(dato c);
    public dato read(Object key);
    public List<dato> readALL(); 
    
}
