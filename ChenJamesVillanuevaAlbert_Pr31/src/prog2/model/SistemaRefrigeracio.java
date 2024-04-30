/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.CentralUBException;

/**
 *
 * @author Albert
 */
public class SistemaRefrigeracio implements InComponent{
    
    private ArrayList sistemaRefrigeracio;
    
    public SistemaRefrigeracio(){
        this.sistemaRefrigeracio = new ArrayList<BombaRefrigerant>();
    }
    
   /**
     * Activa el component.El mètode llançarà
        una excepció en determinades situacions explicades
        a la Taula 1 de l'enunciat de la pràctica.
     * @throws prog2.vista.CentralUBException
     */
    @Override
    public void activa() throws CentralUBException{
        Iterator<BombaRefrigerant> it = sistemaRefrigeracio.iterator();
        while(it.hasNext()){
            if(!it.next().getForaDeServei()) it.next().activa();
            else{throw new CentralUBException("Error: La bomba refrigerant " + it.next().getId() + " esta fora de servei.");}
            
        }
    }
       
    /**
     * Desactiva el component.
     */
    public void desactiva();
    
    /**
     * Revisa el component. Com a resultat de la revisió, podria podria sorgir 
     * una incidència que s'ha de registrar dins d'una pàgina d'incidències.
     * @param p Objecte de tipus PaginaIncidencies.
     */
    public void revisa (PaginaIncidencies p);
    
    /**
     * Obté el cost operatiu del component. El cost operatiu depèn de si el 
     * component està activat. Si no està activat el cost és zero.
     * Si està activat, tindrà un cost que es pot consultar a la Taula 1 de 
     * l'enunciat de la pràctica.
     */
    public float getCostOperatiu();
    
    /**
     * Calcula l'output del component donat l'input. La manera de calcular
     * l'output està descrita a la Figura 2 de l'enunciat de la pràctica.
     * @param input Input que rep el component.
     */
    public float calculaOutput(float input);
    
}
