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
    
    public Adaptador() throws CentralUBException{
        dades = new Dades();
    }
    
    /**
     * Mètodes de persistència de dades
     * @param b
     * @throws prog2.vista.CentralUBException
     */
    public void insertarBarres(float b) throws CentralUBException{
        dades.setInsercioBarres(b);
    }
    public float getBarres(){ 
        return dades.getInsercioBarres();
    }
    public void activarReactor() throws CentralUBException{
        dades.activaReactor();
    }
    public void desactivarReactor() throws CentralUBException{
        dades.desactivaReactor();
    }
    public String mostrarEstatReactor() throws CentralUBException{
        return dades.mostraReactor().toString();
    }
    public void activarBomba(int id) throws CentralUBException{
        dades.activaBomba(id);
    }
    public void desactivarBomba(int id) throws CentralUBException{
        dades.desactivaBomba(id);
    }
    public String mostrarEstatBombes() throws CentralUBException{
        return dades.mostraSistemaRefrigeracio().toString();
    }
    
    /*
    "Mostrar Estat Central",
                                               "Mostrar Bitàcola", 
                                               "Mostrar Incidències", 
                                               "Finalitzar Dia", 
                                               "Guardar Dades", 
                                               "Carrega Dades", 
    */
    
    public String mostrarEstatCentral(int potencia) throws CentralUBException{
        return dades.mostraEstat(potencia).toString();
    }

    
    public String mostrarBitacola () throws CentralUBException{
        return dades.mostraBitacola().toString();
    }
    
    public String mostrarIncidencias () throws CentralUBException{
        return dades.mostraIncidencies().toString();
    }
    public 
    
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
