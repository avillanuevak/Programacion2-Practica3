/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Albert
 */
public class PaginaEstat extends PaginaBritacola {

    int nDia;
    double demandaPotEnergetica;
    double insercioBarres;
    double oReactor;
    double oSistemaRefrigeracio;
    double oGeneradorVapor;
    double oTurbina;
    double demandaSatisfeta; //falta un método para calcular la demanda satisfeta

    public PaginaEstat() {
    }

    public PaginaEstat(int nDia, double demandaPotEnergetica, double insercioBarres, double oReactor, double oSistemaRefrigeracio, double oGeneradorVapor, double oTurbina) {
        this.nDia = nDia;
        this.demandaPotEnergetica = demandaPotEnergetica;
        this.insercioBarres = insercioBarres;
        this.oReactor = oReactor;
        this.oSistemaRefrigeracio = oSistemaRefrigeracio;
        this.oGeneradorVapor = oGeneradorVapor;
        this.oTurbina = oTurbina;
        //this.demandaSatisfeta = 
    }

    public int getnDia() {
        return nDia;
    }

    public void setnDia(int nDia) {
        this.nDia = nDia;
    }

    public double getDemandaPotEnergetica() {
        return demandaPotEnergetica;
    }

    public void setDemandaPotEnergetica(double demandaPotEnergetica) {
        this.demandaPotEnergetica = demandaPotEnergetica;
    }

    public double getInsercioBarres() {
        return insercioBarres;
    }

    public void setInsercioBarres(double insercioBarres) {
        this.insercioBarres = insercioBarres;
    }

    public double getoReactor() {
        return oReactor;
    }

    public void setoReactor(double oReactor) {
        this.oReactor = oReactor;
    }

    public double getoSistemaRefrigeracio() {
        return oSistemaRefrigeracio;
    }

    public void setoSistemaRefrigeracio(double oSistemaRefrigeracio) {
        this.oSistemaRefrigeracio = oSistemaRefrigeracio;
    }

    public double getoGeneradorVapor() {
        return oGeneradorVapor;
    }

    public void setoGeneradorVapor(double oGeneradorVapor) {
        this.oGeneradorVapor = oGeneradorVapor;
    }

    public double getoTurbina() {
        return oTurbina;
    }

    public void setoTurbina(double oTurbina) {
        this.oTurbina = oTurbina;
    }

    public double getDemandaSatisfeta() {
        return demandaSatisfeta;
    }

    public void setDemandaSatisfeta(double demandaSatisfeta) {
        this.demandaSatisfeta = demandaSatisfeta;
    }
    
    
    @Override
    public String toString() {
        return "# Pàgina Estat\n"
                + "- Dia: " + getnDia() +"\n"
                + "- Demanda de potencia: " + this.getDemandaPotEnergetica()+ "\n"
                + "- Inserció Barres: " + this.getInsercioBarres() + "%\n"
                + "- Output Reactor: "+ this.getoReactor() +" Graus\n"
                + "- Output Sistema de Refrigeració: "+ this.getoSistemaRefrigeracio() +" Graus\n"
                + "- Output Generador de Vapor: "+ this.getoGeneradorVapor() +" Graus\n"
                + "- Output Turbina: "+ this.getoTurbina() +" Unitats de Potència\n"
                + "- Demanda de Potència Satisfeta: " + this.getDemandaSatisfeta() +" %";
    }
}
