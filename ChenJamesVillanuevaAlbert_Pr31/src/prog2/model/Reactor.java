/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import prog2.vista.CentralUBException;

/**
 *
 * @author Albert
 */
public class Reactor implements InComponent{
    
    private float temperaturaReactor;
    private boolean activat;
    
    public Reactor(){}
    
    /**
     * Getter i setter de temperatura reactor
     * @return 
     */
    public float getTemperaturaReactor() {
        return temperaturaReactor;
    }

    public void setTemperaturaReactor(float temperaturaReactor) {
        this.temperaturaReactor = temperaturaReactor;
    }

    public boolean isActivat() {
        return activat;
    }

    public void setActivat(boolean activat) {
        this.activat = activat;
    }
    
    /**
     * Activa el component.El mètode llançarà
        una excepció en determinades situacions explicades
        a la Taula 1 de l'enunciat de la pràctica.
     * @throws prog2.vista.CentralUBException
     */
    @Override
    public void activa() throws CentralUBException{
        this.activat = this.getTemperaturaReactor() <= 1000f;
    }
    
    /**
     * Desactiva el component.
     */
    @Override
    public void desactiva(){
        this.activat = this.temperaturaReactor <= 1000f;
    }
    /**
     * Revisa el component. Com a resultat de la revisió, podria podria sorgir 
     * una incidència que s'ha de registrar dins d'una pàgina d'incidències.
     * @param p Objecte de tipus PaginaIncidencies.
     */
    @Override
    public void revisa (PaginaIncidencies p){
        if(this.getTemperaturaReactor() > 1000f){
            this.desactiva();
            p.afegeixIncidencia("Reactor: Activat = " + this.isActivat() + ", Temperatura: " + this.getTemperaturaReactor());
        }
    }
    
    /**
     * Obté el cost operatiu del component. El cost operatiu depèn de si el 
     * component està activat. Si no està activat el cost és zero.
     * Si està activat, tindrà un cost que es pot consultar a la Taula 1 de 
     * l'enunciat de la pràctica.
     * @return
     */
    @Override
    public float getCostOperatiu(){
        float costOperatiu = 0;
        if(this.isActivat()) costOperatiu += 30;
        return costOperatiu;
    }
    
    /**
     * Calcula l'output del component donat l'input. La manera de calcular
     * l'output està descrita a la Figura 2 de l'enunciat de la pràctica.
     * @param input Input que rep el component.
     * @return
     */
    @Override
    public float calculaOutput(float input){
        float output;
        if(!this.isActivat()) output = this.getTemperaturaReactor();
        else{
            output = (this.getTemperaturaReactor() + (100 - input) * 10);
        }
        return output;
    }
}
