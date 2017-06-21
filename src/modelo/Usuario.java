package modelo;

import assets.values.Constant;
import dao.BasicDao;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * Clase Usuario, representa los datos del usuario actual
 *
 * @author Carlos Chavez Laguna
 *
 */
public class Usuario {

    private String idUser;
    private String usuarioUser;
    private String passUser;
    private Rol rolUser;
    /**
     * Singleton que mantiene sesión por un solo usuario a nivel global.
     */
    
    private static Usuario mCurrentUser;
    
    /**
     * @return retorna el usuario global que representa al usuario 
     * actualmente logeado
     */        
    public static Usuario getInstance(){
        if(mCurrentUser==null)
            mCurrentUser=new Usuario();
        return mCurrentUser;
    }
    
    
    
    
    //constructores
    public Usuario() {
        this.idUser="0";
    }

    public Usuario(String username, String password) {
        this();
        this.usuarioUser = username;
        this.passUser = password;
    }
    
    /**
     * Constructor especial que acepta mapas para convertirlo en el objeto User
     *  @param args ,el mapa que contiene los valores del objeto
     */
    public Usuario(Map<String,String> args) {
        this();
        this.idUser = args.get("idUser");
        this.usuarioUser = args.get("UsuarioUser");
        this.passUser = args.get("PassUser");
    }
    
    //setters and getters
    public String getPassword() {
        return passUser;
    }

    public void setPassword(String password) {
        this.passUser = password;
    }

    public String getUsuario() {
        return usuarioUser;
    }

    public void setUsuario(String usuario) {
        this.usuarioUser = usuario;
    }

    public Rol getRolUser() {
        return rolUser;
    }

    public void setRolUser(Rol rolUser) {
        this.rolUser = rolUser;
    }
   
    
    
    /**
     * verifica la existencia del usuario,
     * de forma implícita crea al objeto usuario
     * que se va a conectar al sistema.
     * 
     * @param username ,nombre de usuario
     * @param password ,contraseña de usuario
     * 
     * @return retorna verdadero o falso según la existencia 
     * del usuario en la base de datos
     */
    public static boolean userExists(String username,String password){        
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_USUARIO,new String[]{"*"},"UsuarioUse='"+username+"' AND PassUse='"+password+"'");
        boolean exists= result.size()>0;
        //si existe el usuario, de forma implícita, crear al usuario   
        if(exists){
            Map<String,String> row=result.get(0);
            mCurrentUser= new Usuario(row);
            mCurrentUser.setRolUser(Rol.getRol(row.get("Roles_idRoles")));
        }
        return exists;
    }
    
    /**
     * Save <br>
     * Guardar datos en la base de datos
     */
    public void save(){
        //si el usuario existe
        if(BasicDao.rowExists(Constant.DB_TABLE_USUARIO, "idUser="+idUser)) //actualizar sus datos
            BasicDao.update(Constant.DB_TABLE_USUARIO, new String []{"UsuarioUse","PassUse"}, new String []{this.usuarioUser,this.passUser}, "idUser="+this.idUser);
        else //crear al usuario con los datos actuales
            BasicDao.insert(Constant.DB_TABLE_USUARIO, new String []{"UsuarioUse","PassUse","Roles_idRoles"}, new String []{this.usuarioUser,this.passUser,this.rolUser.getIdRoles()});
    }        
    
    /**
     * obtener toda la lista de usuarios existentes
     * en la base de datos.
     * 
     * @return retorna una arraylist de roles
     */
    public static ArrayList<Usuario> getUsuarioList(){
        ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_USUARIO, new String[]{"*"}, null);
        ArrayList<Usuario> userList=new ArrayList();
        for(Map<String,String> row:result){ 
            userList.add(new Usuario(row));
            userList.get(userList.size()-1).setRolUser(Rol.getRol(row.get("Roles_idRoles")));
        }
        return userList;
    }
   
}
