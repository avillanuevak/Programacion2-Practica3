/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Albert Villanueva
 */
public class PaginaEconomica extends PaginaBitacola{
    private int dia;
    private float beneficis, costOperatiu, penalitzacioExcessProduccio, guanysAcumulats;
    

    public PaginaEconomica(int dia, float beneficis, float costOperatiu, float penalitzacioExcessProduccio, float guanysAcumulats){
        this.dia = dia;
        this.beneficis = beneficis;
        this.costOperatiu = costOperatiu;
        this.penalitzacioExcessProduccio = penalitzacioExcessProduccio;
        this.guanysAcumulats = guanysAcumulats;
    }

    public int getDia() {
        return dia;
    }

    public float getBeneficis() {
        return beneficis;
    }

    public float getCostOperatiu() {
        return costOperatiu;
    }

    public float getPenalitzacioExcessProduccio() {
        return penalitzacioExcessProduccio;
    }

    public float getGuanysAcumulats() {
        return guanysAcumulats;
    }
    
    @Override
    public String toString(){
        return """
               # Pagina Economica
               - Dia: """ + getDia() +
               "- Beneficis: " + getBeneficis() + " Unitats Economiques" +
               "- Penalitzacio Excess Produccio: " + getPenalitzacioExcessProduccio() + " Unitats Economiques" +
               "- Cost Operatiu: " + getCostOperatiu() + " Unitats Economiques" +
               "- Guanys Acumulats: " + getGuanysAcumulats() + " Unitats Economiques\n";
    }
}
