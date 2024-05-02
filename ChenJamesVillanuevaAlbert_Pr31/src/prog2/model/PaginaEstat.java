/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Albert Villanueva
 */
public class PaginaEstat extends PaginaBitacola {

    int dia;
    float demandaPotEnergetica;
    float insercioBarres;
    float oReactor;
    float oSistemaRefrigeracio;
    float oGeneradorVapor;
    float oTurbina;
    float demandaSatisfeta; 

    public PaginaEstat() {}

    public PaginaEstat(int dia, float demandaPotEnergetica, float insercioBarres, float oReactor, float oSistemaRefrigeracio, float oGeneradorVapor, float oTurbina) {
        this.dia = dia;
        this.demandaPotEnergetica = demandaPotEnergetica;
        this.insercioBarres = insercioBarres;
        this.oReactor = oReactor;
        this.oSistemaRefrigeracio = oSistemaRefrigeracio;
        this.oGeneradorVapor = oGeneradorVapor;
        this.oTurbina = oTurbina;
        this.demandaSatisfeta = (oTurbina/demandaPotEnergetica) * 100 ;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public float getDemandaPotEnergetica() {
        return demandaPotEnergetica;
    }

    public void setDemandaPotEnergetica(float demandaPotEnergetica) {
        this.demandaPotEnergetica = demandaPotEnergetica;
    }

    public float getInsercioBarres() {
        return insercioBarres;
    }

    public void setInsercioBarres(float insercioBarres) {
        this.insercioBarres = insercioBarres;
    }

    public float getoReactor() {
        return oReactor;
    }

    public void setoReactor(float oReactor) {
        this.oReactor = oReactor;
    }

    public float getoSistemaRefrigeracio() {
        return oSistemaRefrigeracio;
    }

    public void setoSistemaRefrigeracio(float oSistemaRefrigeracio) {
        this.oSistemaRefrigeracio = oSistemaRefrigeracio;
    }

    public float getoGeneradorVapor() {
        return oGeneradorVapor;
    }

    public void setoGeneradorVapor(float oGeneradorVapor) {
        this.oGeneradorVapor = oGeneradorVapor;
    }

    public float getoTurbina() {
        return oTurbina;
    }

    public void setoTurbina(float oTurbina) {
        this.oTurbina = oTurbina;
    }

    public float getDemandaSatisfeta() {
        return demandaSatisfeta;
    }

    public void setDemandaSatisfeta(float demandaSatisfeta) {
        this.demandaSatisfeta = demandaSatisfeta;
    }
    
    @Override
    public String toString() {
        return """
               # Pagina Estat
               - Dia: """ + getDia() +"\n"
                + "- Demanda de potencia: " + this.getDemandaPotEnergetica()+ "\n"
                + "- Inserció Barres: " + this.getInsercioBarres() + "%\n"
                + "- Output Reactor: "+ this.getoReactor() +" Graus\n"
                + "- Output Sistema de Refrigeració: "+ this.getoSistemaRefrigeracio() +" Graus\n"
                + "- Output Generador de Vapor: "+ this.getoGeneradorVapor() +" Graus\n"
                + "- Output Turbina: "+ this.getoTurbina() +" Unitats de Potència\n"
                + "- Demanda de Potència Satisfeta: " + this.getDemandaSatisfeta() +" %";
    }
}
