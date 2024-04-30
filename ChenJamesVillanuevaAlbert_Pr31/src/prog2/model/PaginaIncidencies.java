/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.ArrayList;

/**
 *
 * @author Albert
 */
public class PaginaIncidencies extends PaginaBritacola{
    int nDia;
    ArrayList<String> llistaIncidencies;

    public int getnDia() {
        return nDia;
    }

    public void setnDia(int nDia) {
        this.nDia = nDia;
    }

    public ArrayList<String> getLlistaIncidencies() {
        return llistaIncidencies;
    }

    public void setLlistaIncidencies(ArrayList<String> llistaIncidencies) {
        this.llistaIncidencies = llistaIncidencies;
    }
    
    public PaginaIncidencies(){
        llistaIncidencies = new ArrayList<>(); 
        nDia = 0;
    }
    
    public PaginaIncidencies(int nDia, ArrayList<String> llistaIncidencies){
        this.nDia = nDia;
        this.llistaIncidencies = llistaIncidencies;
    }
    
    public void afegeixIncidencia(String descIncidencia){
        llistaIncidencies.add(descIncidencia);
    }
    @Override
    public String toString(){
        String mensaje = "";
        for(String it: llistaIncidencies){
            mensaje += "Descripcio Incidencia: " + it + "\n";
        }
        return "# Pagina Incidencies\n- Dia: " + getnDia() + "\n" + mensaje;
    }
    
    

}
