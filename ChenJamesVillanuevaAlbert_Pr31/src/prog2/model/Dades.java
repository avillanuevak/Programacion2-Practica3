/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.Iterator;
import java.util.List;
import prog2.vista.CentralUBException;

/**
 *
 * @author dortiz
 */
public class Dades implements InDades{
    public final static long  VAR_UNIF_SEED = 123;
    public final static float GUANYS_INICIALS = 0;
    public final static float PREU_UNITAT_POTENCIA = 1;
    public final static float PENALITZACIO_EXCES_POTENCIA = 200;

    // Afegir atributs:
    
    
    private VariableUniforme variableUniforme;
    private int insercioBarres;
    private Reactor reactor;
    private SistemaRefrigeracio sistemaRefrigeracio;
    private GeneradorVapor generadorVapor;
    private Turbina turbina;
    private Bitacola bitacola;
    private int dia;
    private float guanysAcumulats;
    
    
    public Dades(){
        // Inicialitza Atributs
        this.variableUniforme = new VariableUniforme(VAR_UNIF_SEED);
        this.insercioBarres = 100;
        this.reactor = new Reactor();
        this.sistemaRefrigeracio = new SistemaRefrigeracio();
        this.generadorVapor = new GeneradorVapor();
        this.generadorVapor.activa();
        this.turbina = new Turbina();
        this.turbina.activa();
        this.bitacola = new Bitacola();
        this.dia = 1;
        this.guanysAcumulats = GUANYS_INICIALS;
        
        // Afegeix bombes refrigerants
        BombaRefrigerant b0 = new BombaRefrigerant(variableUniforme, 0);
        BombaRefrigerant b1 = new BombaRefrigerant(variableUniforme, 1);
        BombaRefrigerant b2 = new BombaRefrigerant(variableUniforme, 2);
        BombaRefrigerant b3 = new BombaRefrigerant(variableUniforme, 3);
        
        this.sistemaRefrigeracio.afegirBomba(b0);
        this.sistemaRefrigeracio.afegirBomba(b1);
        this.sistemaRefrigeracio.afegirBomba(b2);
        this.sistemaRefrigeracio.afegirBomba(b3);
    }
    
    /**
     * Actualitza l'economia de la central. Genera una pàgina econòmica a 
     * partir de la demanda de potencia actual. Aquesta pàgina econòmica inclou 
     * beneficis, penalització per excès de potència, costos operatius y 
     * guanys acumulats.
     * @param demandaPotencia Demanda de potència actual.
     */
    
    
    private PaginaEconomica actualitzaEconomia(float demandaPotencia){
        PaginaEconomica pagina;
        float beneficis = 0;
        float penalitzacio = 0;
        float costos = 0;
        float guanys = 0;
        
        if(this.calculaPotencia()>demandaPotencia){
            beneficis = demandaPotencia;
        }else{
            beneficis = this.calculaPotencia();
            penalitzacio = beneficis - demandaPotencia;
        }
        if(reactor.isActivat()){
            costos += 30;
        }
        
        costos += sistemaRefrigeracio.getCostOperatiu();
        
        if(generadorVapor.isActivat()){
            costos += 25;
        }
        
        if(turbina.isActivat()){
            costos += 20;
        }
        guanys = beneficis - penalitzacio - costos + guanysAcumulats;
        pagina = new PaginaEconomica (dia, beneficis, penalitzacio, costos, guanys);
        
        return pagina;
    }
    
    /**
     * Actualitza l'estat de la central. El mètodo ha de establir la nova
     * temperatura del reactor i revisar els components de la central. Si
     * es troben incidències, s'han de registrar en la pàgina d'incidències
     * que es proporciona com a paràmetre d'entrada.
     * @param paginaIncidencies Pàgina d'incidències.
     */
    private void actualitzaEstatCentral(PaginaIncidencies paginaIncidencies) {
        // Completar
    }
    
    public Bitacola finalitzaDia(float demandaPotencia) {
        // Actualitza economia
        PaginaEconomica paginaEconomica = actualitzaEconomia(demandaPotencia);
        
        // Actualitza estat central i registra incidencies
        PaginaIncidencies paginaIncidencies = new PaginaIncidencies(dia);
        actualitzaEstatCentral(paginaIncidencies);
        
        // Genera pàgina d'estat
        PaginaEstat paginaEstat = mostraEstat(demandaPotencia);
        
        // Incrementa dia
        dia += 1;
        
        // Guarda pàgines de bitacola
        bitacola.afegeixPagina(paginaEconomica);
        bitacola.afegeixPagina(paginaEstat);
        bitacola.afegeixPagina(paginaIncidencies);
        
        // Retorna pàgines
        Bitacola bitacolaDia = new Bitacola();
        bitacolaDia.afegeixPagina(paginaEconomica);
        bitacolaDia.afegeixPagina(paginaEstat);
        bitacolaDia.afegeixPagina(paginaIncidencies);
        return bitacolaDia;
    }

    
    /**
     * Retorna el grau d'inserció de les barres de control en percentatge.
     */
    @Override
    public float getInsercioBarres(){
    
    }
    
    /**
     * Estableix el grau d'inserció de les barres de control en percentatge.
     * @param insercioBarres Percentatge d'inserció de les barres de control.
     */
    public void setInsercioBarres(float insercioBarres) throws CentralUBException{
        
    }
     
    /**
     * Activa el reactor de la central.
     */
    public void activaReactor() throws CentralUBException{
        
    }

    /**
     * Desactiva el reactor de la central.
     */
    public void desactivaReactor(){
        
    }
    
    /**
     * Retorna l'objecte que contè el reactor de la central.
     */
    public Reactor mostraReactor(){
        
    }
    
    /**
     * Activa una bomba refrigerant amb Id donat com a paràmetre.
     * @param id Identificador de la bomba que es vol activar.
     */
    public void activaBomba(int id) throws CentralUBException{
        
    }
    
    /**
     * Desactiva una bomba refrigerant amb Id donat com a paràmetre.
     * @param id Identificador de la bomba que es vol activar.
     */
    public void desactivaBomba(int id){
        
    }
    
    /**
     * Retorna l'objecte que contè el sistema de refrigeració de la central.
     */
    public SistemaRefrigeracio mostraSistemaRefrigeracio(){
        
    }
    
    /**
     * Retorna la potència generada per la central. Aquesta potència es 
     * l'output de la turbina. Es pot consultar la Figura 2 a l'enunciat per
     * veure els detalls.
     */
    public float calculaPotencia(){
        
    }
    
    /**
     * Retorna una pàgina de estat per a la configuració actual de la central.
     * Amb aquest propòsit és necessari coneixer la demanda de potència actual.
     * @param demandaPotencia Demanda de potència actual.
     */
    public PaginaEstat mostraEstat(float demandaPotencia){
        
    }
      
    /**
     * Retorna la bitacola de la central.
     */
    public Bitacola mostraBitacola(){
        
    }
    
    /**
     * Retorna una llista amb totes les pàgines d'incidències de la bitàcola de
     * la central.
     */
    public List<PaginaIncidencies> mostraIncidencies(){
        
    }
   
}