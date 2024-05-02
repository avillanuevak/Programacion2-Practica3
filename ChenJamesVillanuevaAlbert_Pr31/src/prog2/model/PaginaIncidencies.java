/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.ArrayList;

/**
 *
 * @author James Chen
 */
public class PaginaIncidencies extends PaginaBitacola{
    int dia;
    ArrayList<String> llistaIncidencies;

    public PaginaIncidencies(int dia){
    this.llistaIncidencies = new ArrayList<>(); 
    this.dia = dia;
    }
        
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public ArrayList<String> getLlistaIncidencies() {
        return llistaIncidencies;
    }

    public void setLlistaIncidencies(ArrayList<String> llistaIncidencies) {
        this.llistaIncidencies = llistaIncidencies;
    }
    
    public PaginaIncidencies(int dia, ArrayList<String> llistaIncidencies){
        this.dia = dia;
        this.llistaIncidencies = llistaIncidencies;
    }
    
    public void afegeixIncidencia(String descIncidencia){
        llistaIncidencies.add(descIncidencia);
    }
    @Override
    public String toString(){
        String mensaje = "";
        for(String it: llistaIncidencies){
            mensaje += "- Descripcio Incidencia: " + it + "\n";
        }
        return "# Pagina Incidencies\n- Dia: " + getDia() + "\n" + mensaje;
    }
}
