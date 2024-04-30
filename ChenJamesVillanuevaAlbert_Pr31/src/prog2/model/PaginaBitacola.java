/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Albert
 */
public class PaginaBitacola {
    
    private int dia;
    
    public PaginaBitacola(){
        this.dia = 1;
    }
    
    @Override
    public String toString(){
        return "Pagina bitacola\n\n" + new PaginaEconomica().toString() + new PaginaEstat().toString() + new PaginaIncidencies().toString();
    }
}
