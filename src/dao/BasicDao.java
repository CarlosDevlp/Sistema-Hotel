package dao;
import assets.values.Constant;
import java.util.*;
import java.sql.*;
/**
 * BasicDao, permite de manera automática conectarse a la base datos, además,
 * de obtener los datos de las tablas y su posterior manipulación
 * 
 * conexión: para modificar la conexión, cambie las constantes en assets.values.Constant
 * 
 *  
 * Github:
 * @author carlos chavez laguna
 * @version 0.0.1
 */
abstract public class BasicDao {

    private static final String LOG_TAG="BasicDao",LOG_TAG_ERROR="BasicDao";
    private interface DBConnection{
            public void init(String _database,String usr,String pass);
            public ResultSet query(String Qry,String command) throws Exception;
            public void setDB(String _database);
            public String getDB();
            
    }
                //Clase anonima para conectarse con la base de datos
    private final static  DBConnection DB=new DBConnection(){
                                        private String _database;
                                        private Statement _query;                            
                                        //inicializar la conexion con la base de datos
                                        public void  init(String _database,String usr,String pass){                                
                                            
                                            try{
                                                //setear el nombre de la base de datos que voy a usar
                                               this._database=_database;                                   
                                               Connection con = DriverManager.getConnection("jdbc:mysql://"+Constant.DB_SERVER,usr, pass);
                                               this._query=con.createStatement();                              

                                            }catch(Exception err){};

                                        }

                                        //Ejecutar un código SQL en la base de datos
                                        public ResultSet query(String Qry,String command) throws Exception{                                                                                                    
                                            ResultSet result=null;                                             
                                            if(command==null)
                                                command="SELECT";
                                            switch(command){                                                                                                                                                
                                                case "INSERT":
                                                case "UPDATE":
                                                case "DELETE":
                                                    this._query.executeUpdate(Qry);
                                                 break;
                                                default:
                                                    result=this._query.executeQuery(Qry);
                                            }
                                            
                                            return result;
                                        }
                                        
                                        //setear y obtener el nombre de la base de ddatos con la que estoy trabajando
                                        public void setDB(String _database){
                                            this._database=_database;
                                        }
                                        public String getDB(){
                                            return this._database;
                                        }
                                                                                
                                };  
    /**
     INIT, permite inicializar la conexión de BasicDao con la base de datos.     
    */    
    public static void init(){
        BasicDao.DB.init(Constant.DB_NAME,Constant.DB_USER_NAME,Constant.DB_USER_PASSWORD);
        try{
            BasicDao.DB.query("USE "+Constant.DB_NAME,"USE");
            
        }catch(Exception err){};//implementar con sistema de errores
        
    }
    

//recolector de resultados (arma un arreglo a partir de los resultados obtenidos de una query ejecutada)
    private static void result(ArrayList<ArrayList<String>> cols,ResultSet r,String col) throws Exception{
                String []columnas=new String[0];      
                int tam;
                    if(col.compareTo("*")==0)//todas las columnas                 
                        tam= r.getMetaData().getColumnCount();
                    else{//n columnas 
                        columnas=col.split(",");
                        tam=columnas.length;                
                    }           
                int row=0;

                //iteración para obtener cada elemento del resultado
                while(r.next()){                     
                    cols.add(new ArrayList<String>());
                    for(int i=1;i<=tam;i++){                    
                        if(columnas.length==0)
                           cols.get(row).add( r.getString( i ) ); 
                        else{
                           cols.get(row).add( r.getString( columnas[i-1]) );
                        }
                    }
                    row++;
                }
    }
    
    
//recolector de resultados (arma un arreglo CON MAPAS a partir de los resultados obtenidos de una query ejecutada)
    private static void mapResult(ArrayList<Map<String,String>> cols,ResultSet r,String []col) throws SQLException {
                ArrayList<String> columns=new ArrayList();      
                int tam;
                if(col[0].compareTo("*")==0){//todas las columnas                 
                    ResultSetMetaData meta=r.getMetaData();                    
                    tam= meta.getColumnCount();                    
                    for(int i=1;i<=tam;i++)
                           columns.add(meta.getColumnName(i));
                    
                }else{//n columnas 
                    columns=new ArrayList(Arrays.asList(col));
                    tam=columns.size();
                }

                System.out.println();
                //iteración para obtener cada elemento del resultado
                int row=0;
                String columnName;
                //System.out.println("size: "+tam);
                if(tam>0)
                    while(r.next()){                     
                        cols.add(new HashMap<String,String>());
                        for(int i=0;i<tam;i++){
                           columnName=columns.get(i);
                           cols.get(row).put(columnName,r.getString(columnName)); 
                        }
                        row++;
                    }
    }


    
    
    
//DOC-------------------------------------------------------------------------------------------------

    //Seleccionar datos de una base de datos
    /**
     *SELECT <br>
     *Selección  básica <br>
     *Permite seleccionar los datos de una tabla 
     *@param table nombre de la tabla  
     *@param col nombres de las columnas en un array de strings: new String {'col1','col2'} 
     *@param where condición que debe cumplir los datos que se están opteniendo
     * 
     * @return retorna una matriz de resultado.
    */
    public static ArrayList<Map<String,String>> select(String table,String []col,String where){
        ResultSet r;                
        ArrayList<Map<String,String>> result=new ArrayList();                
        try{ 
            String colSeq="";
            for(int i=0;i<col.length;i++){
                if(i>0) colSeq+=",";
                colSeq+=col[0];  
            }
        
            //ejecución  del código sql
            r=BasicDao.DB.query("SELECT "+colSeq+" FROM "+table+((where==null)?"":" WHERE "+where),"SELECT");
            //proceso de conversión de datos a array
            BasicDao.mapResult(result,r,col);
            
        }catch(Exception err){                        
            System.err.println(LOG_TAG_ERROR+" On select: ");
            err.printStackTrace(System.err);            
        }   
        return result;
        
    }
    
    
    //selección  con Joins
    /**
     * SELECT JOIN <br>
     *Selección  con joins <br>
     *Permite seleccionar los datos de varias tablas al mismo tiempo con Joins 
     *@param table arreglo con las tablas que harán join
     *@param col nombres de las columnas en un array de strings: new String {'col1','col2'} 
     *@param match columnas que hacen el match (llave foranea)
     *@param where condición que debe cumplir los datos que se están opteniendo
     * 
     * @return retorna una matriz de resultado.
    */    
    public static ArrayList<Map<String,String>> select(String table[],String []col,String match[],String where){
        ResultSet r;                
        ArrayList<Map<String,String>> cols=new ArrayList();                
        try{ 
            String colSeq="";
            for(int i=0;i<col.length;i++){
                if(i>0) colSeq+=",";
                colSeq+=col[i];  
            }
            
            String join="";
            //ejecución  del código sql                        
            if(match==null || table==null)
                throw new Exception("Error en la query ingresada");  
            
            //nJoins
            for(int i=1;i<table.length;i++)
                join+=" INNER JOIN "+table[i]+" ON "+match[i-1]+"="+match[i]; 
            
            //System.out.print("SELECT "+colSeq+" FROM "+table[0]+join+((where==null)?"":" WHERE "+where));
            r=BasicDao.DB.query("SELECT "+colSeq+" FROM "+table[0]+join+((where==null)?"":" WHERE "+where),"SELECT");            
            //proceso de conversión de datos a array
            BasicDao.mapResult(cols,r,col);
        }catch(Exception err){            
            System.err.println(LOG_TAG_ERROR+" On select join: "+err);            
            err.printStackTrace(System.err);
        }finally{ 
            return cols;
        }  
    }
    
    
    //inserción
    /**
     * INSERT <br>
     *Inserción de datos <br>
     *Permite insertar datos nuevos a una tabla
     *@param table nombre de la tabla
     *@param cols nombres de las columnas en un array de strings: new String {'col1','col2'} 
     *@param values valores a insertar, tienen que ser el mismo número que las cols
     * 
    */    
    public static void insert(String table,String []cols,String []values) {
        try{
            String colSeq="";
            for(int i=0;i<cols.length;i++){
                if(i>0) colSeq+=",";
                colSeq+=cols[i];  
            }
            
            
            String vls="";            
            for(int i=0;i<values.length;i++){
                  vls+=" '"+values[i]+"' ";
                  if(i<values.length-1)
                      vls+=",";
            }
            
          BasicDao.DB.query("INSERT INTO "+table+" ("+colSeq+") VALUES ("+vls+")","INSERT");                 
        }catch(Exception err){
          System.err.println(LOG_TAG_ERROR+" On insert: "+err);
        }
    }    
    
    
    
    //eliminación    
    /**
     * DELETE <br>
     *eliminar datos <br>
     *Permite insertar datos nuevos a una tabla
     *@param table nombre de la tabla
     *@param where condición para identificar las filas que se van a eliminar
     *      
    */    
    public static void delete(String table,String where){
        try{
            BasicDao.DB.query("DELETE FROM "+table+" WHERE "+where,"DELETE");        
        }catch(Exception err){
            System.err.println(LOG_TAG_ERROR+" On delete: "+err);            
        }
        
    }
    
    
    
    
    //actualización
    /**
     * UPDATE <br>
     *actualización de datos. <br>
     *Permite actualizar los datos en la base de datos.
     *@param table arreglo con las tablas que harán join
     *@param cols columnas que se van a actualizar
     *@param values valores con las que se van a actualizar
     *@param where condición para identificar las filas que se van a actualizar
     * 
    */    
    public static void update(String table,String []cols,String []values,String where){
        try{
            
            String vls="";
            String []cls= cols;      
            
            if(cls.length!=values.length)
                throw new Exception("Numero de columnas diferente al numero de filas");
            
            for(int i=0;i<values.length;i++){
                  vls+=cls[i]+" = '"+values[i]+"' ";
                  if(i<values.length-1)
                      vls+=" , ";
            }            
            
            String q="UPDATE  "+table+" SET "+vls+" WHERE "+where;
            //System.out.println(q);
            BasicDao.DB.query(q,"UPDATE");         
        }catch(Exception err){
            //LOG_TAG_ERROR            
            System.err.println(LOG_TAG_ERROR+"- Update: "+err);
            
        }
    }
    
    
    
    //otros métodos útiles
            
    /**     
     *verificación de tabla vacía <br>
     *Permite verificar si la tabla está vacía 
     *@param table nombre de la tabla a evaluar
     * 
     *@return verdadero o falso si la tabla está vacía
    */    
    public static boolean isTableEmpty(String table){
        ResultSet r;                
        ArrayList<ArrayList<String>> cols=new ArrayList();                
        try{ 
            //ejecución  del código sql
            r=BasicDao.DB.query("SELECT count(*) FROM "+table,"SELECT");
            //proceso de conversión de datos a array
            BasicDao.result(cols,r,"count(*)");  
            
            return cols.get(0).get(0).equals("0");
            
        }catch(Exception err){
            System.err.println(LOG_TAG_ERROR+" on isEmptyTable method: "+err);
        }
        
        return true;                
    }
    
    
    
    
    //seleccionar última fila
    /**     
     *seleccionar última fila <br>
     *Permite seleccionar la última fila de la tabla <br>
     *@param table nombre de la tabla a evaluar
     *@param col nombre de las columnas a seleccionar de esa fila
     *@param columnToOrderBy nombre de la columna por la que se ordenará
     * 
     *@return arreglo con los datos de la fila
    */ 
    public static Map<String,String> selectLastRow(String table,String []col,String columnToOrderBy){
        ResultSet r;                
        ArrayList<Map<String,String>> cols=new ArrayList();        
        try{ 
            
            String colSeq="";
            for(int i=0;i<col.length;i++){
                if(i>0) colSeq+=",";
                colSeq+=col[i];  
            }
            
            //ejecución  del código sql                                    
            r=BasicDao.DB.query("SELECT "+colSeq+" FROM "+table+" ORDER BY "+columnToOrderBy+" DESC LIMIT 1","SELECT");
            //proceso de conversión de datos a array
            BasicDao.mapResult(cols,r,col);
        }catch(Exception err){
              System.err.println(LOG_TAG_ERROR+" on selectLastRow method: "+err);              
        }
        
        return cols.get(0);
                
    }
 
    
    /**
     * CALL <br>
     * permite llamar a procedimientos 
     * ya definidos a nivel de SQL
     * 
     * @param name es el nombre del procedimiento a llamar
     * @param params son los parámetros (sus valores) en el orden que el procedimiento requiere.
     * 
     * @return si el procedimiento a llamar retorna un valor o conjunto de valores, 
     * recepcionarlo.
     */
    public static ArrayList<Map<String,String>> call(String name,String []params){
        ResultSet r;                
        ArrayList<Map<String,String>> result=new ArrayList();                
        try{ 
            String paramsSeq="";
            
            if(params!=null){
                paramsSeq="(";
                for(int i=0;i<params.length;i++){
                    if(i>0) paramsSeq+=",";
                    paramsSeq+=params[i];  
                }
                paramsSeq+=")";
            }
            
            //System.out.println("CALL "+name+paramsSeq);
            
            //ejecución  del código sql
            r=BasicDao.DB.query("CALL "+name+paramsSeq,"PROCEDURE");
            //proceso de conversión de datos a array de mapas
            BasicDao.mapResult(result,r,new String[]{"*"});
            
        }catch(Exception err){                        
            System.err.println(LOG_TAG_ERROR+" On call: ");
            err.printStackTrace(System.err);            
        }        
        return result;        
    }
    
    /**
     * Row Exists <br>
     * permite saber si existe una fila en una tabla 
     * para una serie de condiciones
     * 
     * @param table nombre de la tabla
     * @param cond  condición que debe cumplir la fila
     * 
     * @return verdadero o falso si existe o no la fila
     */
    public static boolean rowExists(String table,String cond){
        ArrayList<Map<String,String>> result=select(table,new String[]{"*"},cond);
        return result.size()>0;
    }
}