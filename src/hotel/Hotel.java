/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author Luis Fernando
 */

import dao.BasicDao;
import java.util.*;

public class Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       

        //EJEMPLO DE COMO USAR BASICDAO EN EL PROYECTO
       
       BasicDao.init();  // BasicDao.init() solo se llama 1 vez en todo el programa, podría ser en el formulario principal
                                  
       //ejemplo de insert
       /*
       System.out.println("insertando los datos de una base de datos en cloud");
       BasicDao.insert("testtable2", new String[]{"column1","table1_id"}, new String[]{"holi :)","1"});
       */

       //ejemplo de update       
       /*
       System.out.println("actualizando los datos de una base de datos en cloud");
       BasicDao.update("testtable", new String[]{"column1"}, new String[]{"eliminame"}, "table_id=2");       
       */ 
       
       
       //ejemplo de eliminar una fila
       /*
       System.out.println("eliminando los datos de una base de datos en cloud");
       BasicDao.delete("testtable", "column1='eliminame'");
       */ 
       
       
       //ejemplo de ver si la tabla está vacía
       /**/
       System.out.println("verificando si la tabla está vacía de una base de datos en cloud");
       if(BasicDao.isTableEmpty("testtable"))
            System.out.println("la tabla está vacía");
       else System.out.println("la tabla NO está vacía");           
       /**/ 
       
       
        
       /**/
       
       {
           //ejemplo de select 
            /*
            System.out.println("obteniendo los datos de una base de datos en cloud");
            ArrayList<Map<String,String>> result=BasicDao.select("testtable",new String[]{"*"}, "table_id=1");
            //obtenemos la primera fila            
            Set<String> colsNameSet;
            for(Map<String,String> row :result){
                colsNameSet=row.keySet();
                for(String colName: colsNameSet)
                    System.out.println(colName+" - "+row.get(colName));       
                System.out.println("_____________________________________");
            }                        
            */           
       }
       
       

        {  
            //ejemplo de select join
            /*
           System.out.println("JOIN - obteniendo los datos de una base de datos en cloud");
                                                                    //nombre de las tablas para hacer join
           ArrayList<Map<String,String>> result=BasicDao.select(new String[]{"testtable2","testtable"},new String[]{"*"},new String[]{"table1_id","table_id"}, null);
           Set<String> colsNameSet;

           for(Map<String,String> row :result){
                colsNameSet=row.keySet();
                for(String colName: colsNameSet)
                    System.out.println(colName+" - "+row.get(colName));            
           }
            */
        }
               
        {
           //ejemplo de select last row
            //permite seleccionar la última fila
            /**/
            System.out.println("obteniendo la última fila de una tabla de una base de datos en cloud");
            Map<String,String> lastRow=BasicDao.selectLastRow("testtable",new String[]{"*"}, "table_id");
            //obtenemos la última fila
            System.out.println("table_id - "+lastRow.get("table_id"));
            System.out.println("columna1 - "+lastRow.get("column1"));
            System.out.println("columna2 - "+lastRow.get("column2"));
            System.out.println("_______________________________________________________");
            /**/           
       }
        
        
        
                
        {
           //ejemplo de call (procedimientos)
            /*            
            El método call ,de BasicDao, puede llamar a cualquier procedimiento de cualquier complejidad
            que se crea en la base de datos.
            */
            
            
            
            /*
            1)Si el método no tiene parámetros, proporcionar null o un arreglo vacío su lugar
            ArrayList<Map<String,String>> result=BasicDao.call("getFirstRow", null);
            
            _________________________________________________________
            2)si el método no devuelve nada, no recepcionar los datos
            BasicDao.call("getFirstRow", null);            
            procedimiento a llamar
            CREATE PROCEDURE addNewTesttable(IN descp VARCHAR(50))
            BEGIN
               INSERT INTO testtable (column1,column2) VALUES(descp,NOW());
            END;
            //
            */            
            BasicDao.call("addNewTesttable", new String []{"'holi XDDDDD :P'"});
            
            
            /*
            __________________________________________________________
            3)si el método requiere de parámetros y devuelve datos. Como el siguiente caso.            
            Procedimiento a llamar:
            CREATE PROCEDURE getNRows(IN amount INT, IN tableNumber INT)
            BEGIN    
                IF tableNumber=1 THEN 
                   SELECT * FROM  testtable LIMIT amount;   
                ELSE 
                   SELECT * FROM  testtable2 LIMIT amount;   
                 END IF;
            END;
            //            
             */
            ArrayList<Map<String,String>> result=BasicDao.call("getNRows", new String[]{"2","1"});
            System.out.println("realizando un llamado a un procedimiento en base de datos en cloud");
            Map<String,String> row= result.get(1);    
            
            System.out.println("tam -> "+result.size());
            System.out.println("id - "+row.get("table_id"));
            System.out.println("columna1 - "+row.get("column1"));
            System.out.println("columna2 - "+row.get("column2"));
            /**/
       }
        
        /*ejemplo extra de procedimientos xd
            CREATE PROCEDURE getSizeTesttable()
            BEGIN 
              SELECT COUNT(*) FROM testtable;
            END;
            //        
        {                        
            ArrayList<Map<String,String>> result=BasicDao.call("getSizeTesttable", null);
            Set<String> colsNameSet;
            Map<String,String> row=result.get(0);
            System.out.println("el tamaño de la table testtable es-> "+row.get("COUNT(*)"));            
           
        } 
        */
       
    }
    
    
    private static void select(){
    //ejemplo de select 
       /**/
       System.out.println("obteniendo los datos de una base de datos en cloud");
       ArrayList<Map<String,String>> result=BasicDao.select("testtable",new String[]{"column1"}, null);
       Set<String> colsNameSet;
       
       for(Map<String,String> row :result){
            colsNameSet=row.keySet();
            for(String colName: colsNameSet)
                System.out.println(colName+" - "+row.get(colName));
            System.out.println("____________________________-");
       }       
       /**/       
    }
    
    
    
    private static void selectJoin(){
        //ejemplo de select join
       /**/
       System.out.println("JOIN - obteniendo los datos de una base de datos en cloud");
                                                                //nombre de las tablas para hacer join
       ArrayList<Map<String,String>> result=BasicDao.select(new String[]{"testtable2","testtable"},new String[]{"*"},new String[]{"table1_id","table_id"}, null);
       Set<String> colsNameSet;
       
       for(Map<String,String> row :result){
            colsNameSet=row.keySet();
            for(String colName: colsNameSet)
                System.out.println(colName+" - "+row.get(colName));            
       }       
       /**/
    }
}
