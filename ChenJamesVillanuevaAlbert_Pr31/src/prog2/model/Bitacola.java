/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Albert Villanueva
 */
public class Bitacola implements InBitacola{
    
    public ArrayList<PaginaBitacola> llistaPaginaBitacola;
    
    public Bitacola(){
        this.llistaPaginaBitacola = new ArrayList<>();
    }

    public ArrayList<PaginaBitacola> getLlistaPaginaBitacola() {
        return llistaPaginaBitacola;
    }

    public void setLlistaPaginaBitacola(ArrayList<PaginaBitacola> llistaPaginaBitacola) {
        this.llistaPaginaBitacola = llistaPaginaBitacola;
    }
    
    
    /**
     * Afegeix una pagina a la bitàcola.
     * @param p Objecte de tipus PaginaBitacola
     */
    @Override
    public void afegeixPagina(PaginaBitacola p){
        getLlistaPaginaBitacola().add(p);
    }
    
    /**
     * Obté una llista amb totes les pàgines d'incidències contingudes dins 
     * de la bitàcola
     * @return 
     */
    @Override
    public List<PaginaIncidencies> getIncidencies(){
        List<PaginaIncidencies> llistaIncidencies;
        
    }
    
    @Override
    public String toString(){
        String bitacolaString = "";
        for(PaginaBitacola it : llistaPaginaBitacola) bitacolaString += it.toString() + "\n";
        
        return bitacolaString;
    }
}
