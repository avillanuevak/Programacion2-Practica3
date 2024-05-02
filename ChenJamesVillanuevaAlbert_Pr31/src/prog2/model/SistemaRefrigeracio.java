/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.CentralUBException;

/**
 *
 * @author Albert
 */
public class SistemaRefrigeracio implements InComponent{
    
    private ArrayList<BombaRefrigerant> sistemaRefrigeracio;
    
    public SistemaRefrigeracio(){
        this.sistemaRefrigeracio = new ArrayList<>();
    }

    public ArrayList<BombaRefrigerant> getSistemaRefrigeracio() {
        return sistemaRefrigeracio;
    }

    public void setSistemaRefrigeracio(ArrayList<BombaRefrigerant> sistemaRefrigeracio) {
        this.sistemaRefrigeracio = sistemaRefrigeracio;
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
    @Override
    public void desactiva(){
        Iterator<BombaRefrigerant> it = sistemaRefrigeracio.iterator();
        while(it.hasNext()){
            it.next().desactiva();
        }
    }
    
    /**
     * Revisa el component. Com a resultat de la revisió, podria podria sorgir 
     * una incidència que s'ha de registrar dins d'una pàgina d'incidències.
     * @param p Objecte de tipus PaginaIncidencies.
     */
    @Override
    public void revisa (PaginaIncidencies p){
        Iterator<BombaRefrigerant>it = sistemaRefrigeracio.iterator();
        while(it.hasNext()){
            it.next().revisa(p);
        }
    }
    
    /**
     * Obté el cost operatiu del component.El cost operatiu depèn de si el 
     * component està activat. Si no està activat el cost és zero.
     * Si està activat, tindrà un cost que es pot consultar a la Taula 1 de 
     * l'enunciat de la pràctica.
     * @return 
     */
    @Override
    public float getCostOperatiu(){
        float costOperatiu = 0;
        Iterator<BombaRefrigerant>it = sistemaRefrigeracio.iterator();
        while(it.hasNext()){
            if(it.next().getActivat()) costOperatiu += 125;
        }
        return costOperatiu;
    }
    
    /**
     * Calcula l'output del component donat l'input.La manera de calcular
     * l'output està descrita a la Figura 2 de l'enunciat de la pràctica.
     * @param input Input que rep el component.
     * @return 
     */
    @Override
    public float calculaOutput(float input){
        float bombesActivades = 0f;
        Iterator<BombaRefrigerant>it = sistemaRefrigeracio.iterator();
        while(it.hasNext()){
            if(it.next().getActivat()) bombesActivades += 1;
        }
        return min(input, 250f * bombesActivades);
    }
    
    /**
     * Funcio que afegeix una bomba refrigerant al sistema de refrigeració
     * si el seu identificador no és trobat a la llista.
     * @param b 
     */
    public void afegirBomba(BombaRefrigerant b){
        Iterator<BombaRefrigerant>it = sistemaRefrigeracio.iterator();
        while(it.hasNext()){
            if(it.next().getId() != b.getId()) sistemaRefrigeracio.add(b);
        } 
    }
}
