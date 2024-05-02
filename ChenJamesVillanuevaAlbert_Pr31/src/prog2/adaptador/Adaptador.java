/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.adaptador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import prog2.model.Dades;
import java.io.Serializable;
import prog2.vista.CentralUBException;
/**
 *
 * @author Albert
 */
public class Adaptador implements Serializable{
    private Dades dades;
    
    public Adaptador(){}
    
    /**
     * Mètodes de persistència de dades
     */
    
    /**
     * Mètode per guardar la classe EstacioTren
     * @param camiDesti
     * @throws prog2.vista.CentralUBException
     */
    public void guardaDades(String camiDesti) throws CentralUBException{
        try{
            File fitxer = new File(camiDesti);
            try (FileOutputStream fout = new FileOutputStream(fitxer); 
                    ObjectOutputStream oos = new ObjectOutputStream(fout)) {
                oos.writeObject(this);
                
            }
        }
        catch(IOException e){
            System.out.println("Error: No s'ha pogut guardar l'arxiu.");
        }
    }
    
    /**
     * Mètode per carregar la classe EstacioTren
     * @param camiOrigen
     * @throws prog2.vista.CentralUBException
     * @throws IOException 
     */
    public void carregaDades(String camiOrigen) throws CentralUBException, IOException{
        try{
            File fitxer = new File(camiOrigen);
            try (FileInputStream fin = new FileInputStream(fitxer); 
                    ObjectInputStream ois = new ObjectInputStream(fin)) {
                dades =  (Dades) ois.readObject();
                
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Error: No s'ha pogut carregar");
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Arxiu no trobat.");
        }
    }
    
    public String finalitzaDia(float demandaPotencia){
        return dades.finalitzaDia(demandaPotencia).toString();
    }
}
