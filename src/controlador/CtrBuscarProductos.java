/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BasicDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import modelo.Callback;
import vista.FrmBuscarProducto;

/**
 *
 * @author ChristianHC
 */
public class CtrBuscarProductos implements ActionListener {
    
    private FrmBuscarProducto mFrmBuscarProductos;
    private Callback mOnCompletedSearch;
    private DefaultTableModel mBuscarProductosModel;
    private final String []PRODUCT_TABLE_COLUMN_NAMES={"NUM","Nompre Prod","P. Unitario"};
    
    public CtrBuscarProductos(){
        this(new FrmBuscarProducto());
    }
    
    public CtrBuscarProductos(FrmBuscarProducto mFrmBuscarProductos){
        //System.out.println("CONTROLADOR BUSCAR PRODUCTOS");
        this.mFrmBuscarProductos = mFrmBuscarProductos;
        this.mFrmBuscarProductos.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hizo Click");
            }
        });
        
    }
    
    public void loadData(){
        
    }
    
    public void clearTable(){
        mBuscarProductosModel = new DefaultTableModel(null,PRODUCT_TABLE_COLUMN_NAMES);
        this.mFrmBuscarProductos.tablaListaProd.setModel(mBuscarProductosModel);
    }
    
    public void showFrmBuscarProductos(){
        this.mFrmBuscarProductos.setVisible(true);
    }
    
    public Callback getOnCompletedSearch(){
        return mOnCompletedSearch;
    }
    
    public void setOnCompletedSearch(Callback onCompletedSearch) {
        this.mOnCompletedSearch = onCompletedSearch;
    } 
    
    void buscar(){
        
            DefaultTableModel modelo = (DefaultTableModel) this.mFrmBuscarProductos.tablaListaProd.getModel();
            
          try{
            ArrayList<Map<String,String>> resultadoProductos = BasicDao.select("Producto", new String[]{"*"}, "NombrePro like '%"+this.mFrmBuscarProductos.txtTermProd1.getText().toString()+"%'");        
              for(int i = 0; i<resultadoProductos.size() ; i++){
                Object datos[]=new Object[3];
                Map<String,String> Producto = resultadoProductos.get(i);
                modelo.addRow(new Object[]{
                    Producto.get("idProducto"),
                    Producto.get("NombrePro"),
                    Producto.get("PrecioPro")
                });
            }}catch (Exception e){
                ArrayList<Map<String,String>> resultadoProductos = BasicDao.select("Producto", new String[]{"*"}, "NombrePro like '%"+this.mFrmBuscarProductos.txtcati.getText().toString()+"%'");        
              for(int i = 0; i<resultadoProductos.size() ; i++){
                Object datos[]=new Object[3];
                Map<String,String> Producto = resultadoProductos.get(i);
                modelo.addRow(new Object[]{
                    Producto.get("idProducto"),
                    Producto.get("NombrePro"),
                    Producto.get("PrecioPro")
                });
            
                
            }
              }
           }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent obj=(JComponent) e.getSource();
        switch(obj.getName()){
            case "btnBuscar":
                System.out.println("Click");
                buscar();
            break;
        }
    }
    
}
