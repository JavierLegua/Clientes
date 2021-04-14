/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.FileObject;

/**
 *
 * @author alumnodaw
 */
public class IODatos {
    
    public static ArrayList<Cliente> cargarDatos(){
        
        ArrayList<Cliente> vector = new ArrayList();
        
        File f = new File("clientes.dat");
        
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try (FileInputStream fi = new FileInputStream(f);
                ObjectInputStream leer = new ObjectInputStream(fi)){
            
            vector = (ArrayList<Cliente>) leer.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public static void guardarDatos(ArrayList<Cliente> vector){
        
        File f = new File("clientes.dat");
        
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try (FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream escribir = new ObjectOutputStream(fo)){
            
            escribir.writeObject(vector);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
