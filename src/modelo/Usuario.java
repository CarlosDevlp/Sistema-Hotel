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
     * sesión actual del usuario sobre el sistema
     */
    private Sesion mCurrentSesion;
    
    /**
     * solo si el usuario que se ingresado está relacionado con algún 
     * empleado
     */        
    private Empleado mEmpleado;
    
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
        this.usuarioUser = args.get("UsuarioUse");
        this.passUser = args.get("PassUse");
    }
    
    //setters and getters

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }        
    
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

    public Sesion getCurrentSesion() {
        return mCurrentSesion;
    }

    public void setCurrentSesion(Sesion mCurrentSesion) {
        this.mCurrentSesion = mCurrentSesion;
        this.mCurrentSesion.setIdUser(idUser);
        this.mCurrentSesion.setDescripcionSes(usuarioUser+" accesando para trabajo ");
    }

    public Empleado getEmpleado() {
        return mEmpleado;
    }

    public void setEmpleado(Empleado mEmpleado) {
        this.mEmpleado = mEmpleado;
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
                    
            //obtener empleado ligado al usuario
            ArrayList<Empleado> empleadoList=Empleado.getEmpleadoList("User_idUser="+mCurrentUser.getIdUser());
            if(!empleadoList.isEmpty()) mCurrentUser.setEmpleado(empleadoList.get(0));
        }
        return exists;
    }
    
    /**
     * Save <br>
     * Guardar datos en la base de datos
     */
    public void save(){
        Sesion currentSesion= Usuario.getInstance().getCurrentSesion();
        BasicDao.call("guardarUsuario", new String[]{currentSesion.getIdSesion(),this.idUser,"'"+this.usuarioUser+"'","'"+this.passUser+"'",this.rolUser.getIdRoles()});
        
        /*
        //si el usuario existe
        if(BasicDao.rowExists(Constant.DB_TABLE_USUARIO, "idUser="+idUser)) //actualizar sus datos
            BasicDao.update(Constant.DB_TABLE_USUARIO, new String []{"UsuarioUse","PassUse","Roles_idRoles"}, new String []{this.usuarioUser,this.passUser,this.rolUser.getIdRoles()}, "idUser="+this.idUser);
        else //crear al usuario con los datos actuales
            BasicDao.insert(Constant.DB_TABLE_USUARIO, new String []{"UsuarioUse","PassUse","Roles_idRoles"}, new String []{this.usuarioUser,this.passUser,this.rolUser.getIdRoles()});*/
    }

    /**
     * 
     * actualizar id del usuario si es que 
     * aun no tiene el id real generado en la bd.
     *         
    */
    public void updateId(){
        if(this.idUser.equals("0")){            
           ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_USUARIO, new String[]{"idUser"}, "UsuarioUse='"+this.usuarioUser+"'");
           this.idUser=result.get(0).get("idUser");           
        }
    }
    
    /**
     * obtener toda la lista de usuarios existentes
     * en la base de datos con condición
     * 
     * @param where condición
     * @return retorna una arraylist de usuarios
     */
    public static ArrayList<Usuario> getUsuarioList(String where){
        
        //ArrayList<Map<String,String>> result=BasicDao.select(Constant.DB_TABLE_USUARIO, new String[]{"*"}, where);
        //inner join
        ArrayList<Map<String,String>> result = BasicDao.select(new String[] {Constant.DB_TABLE_USUARIO,Constant.DB_TABLE_ROLES},
                                                               new String[] {"*"},new String[] {"Roles_idRoles","idRoles"}, where);
        
        ArrayList<Usuario> userList=new ArrayList();
        
        for(Map<String,String> row:result){ 
            userList.add(new Usuario(row));
            userList.get(userList.size()-1).setRolUser(new Rol(row));
        }
        return userList;
    }
    
    
    
    /**
     * obtener toda la lista de usuarios existentes
     * en la base de datos.
     * 
     * @return retorna una arraylist de usuarios
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
    
    
    /**
     * 
     * remover usuario de la base de datos
     */
    public void remove(){
        Sesion currentSesion= Usuario.getInstance().getCurrentSesion();
        BasicDao.call("removerUsuario", new String[]{currentSesion.getIdSesion(),this.idUser});
        //BasicDao.delete(Constant.DB_TABLE_USUARIO, "idUser="+this.idUser);
    }
   
}
