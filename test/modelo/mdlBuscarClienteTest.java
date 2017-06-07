/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JUAN
 */
public class mdlBuscarClienteTest {
    
    public mdlBuscarClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTablaCliente method, of class mdlBuscarCliente.
     */
    @Test
    public void testGetTablaCliente() throws Exception {
        System.out.println("getTablaCliente");
        String documento = "";
        mdlBuscarCliente instance = new mdlBuscarCliente();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getTablaCliente(documento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaCliente2 method, of class mdlBuscarCliente.
     */
    @Test
    public void testGetTablaCliente2() throws Exception {
        System.out.println("getTablaCliente2");
        mdlBuscarCliente instance = new mdlBuscarCliente();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getTablaCliente2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
