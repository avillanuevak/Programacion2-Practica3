/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;
import java.util.Scanner;
import prog2.adaptador.Adaptador;

/**
 *
 * @author dortiz
 */
public class CentralUB {
    public final static float DEMANDA_MAX = 1600;
    public final static float DEMANDA_MIN = 200;
    public final static float VAR_NORM_MEAN = 1000;
    public final static float VAR_NORM_STD = 600;
    public final static long VAR_NORM_SEED = 123;
    
    /** Generador aleatori de la demanda de potència **/
    private VariableNormal variableNormal;
    
    /** Demanda de potència del dia actual **/
    private float demandaPotencia;
    
    /*Variable de classe adaptador*/
    private Adaptador adaptador;
    /* Constructor*/
    public CentralUB() {
        variableNormal = new VariableNormal(VAR_NORM_MEAN, VAR_NORM_STD, VAR_NORM_SEED);
        demandaPotencia = generaDemandaPotencia();
        
        // Afegir codi adicional si fos necessari:
        this.adaptador = new Adaptador();

    }
    
    public void gestioCentralUB() {
        // Mostrar missatge inicial
        System.out.println("Benvingut a la planta PWR de la UB");
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats");

        // Completar
        System.out.println("*****Menu d'opcions*****");
        
        Scanner sc = new Scanner(System.in);
        enum MenuPrincipal{OP1, OP2, OP3, OP4, OP5, OP6, OP7, OP8, OP9, OP10, OP11, OP12, OPSORTIR}
        MenuPrincipal[] opcionsPrincipals = MenuPrincipal.values(); //Converteix l'enum en un array de constants
        Menu<MenuPrincipal> menu = new Menu<>("MENU PRINCIPAL",opcionsPrincipals); //Defineix el menu amb el nom d'estacio i l'array d'opcions
        
        String[] descripcionsPrincipal = {"",
                                               "",
                                               "Llistar la informacio de les vies tancades",
                                               "Llistar la informacio dels accessos oberts", 
                                               "Llistar la informacio dels accessos tancats",
                                               "Llistar la informacio de les incidencies actuals", 
                                               "Afegir una incidencia", 
                                               "Eliminar una incidencia", 
                                               "Calcular i mostrar el numero total d'accessos que proporcionen accessibilitat", 
                                               "Calcular i mostrar el numero total de metres de longitud d'accessos de nivell", 
                                               "Guardar estacio", 
                                               "Recuperar estacio", 
                                               "Sortir de l'aplicacio"};
        
        String[] descripcionsSecundari1={};
        
        
        menu.setDescripcions(descripcionsPrincipal);
        MenuPrincipal op = null;
        do{
            menu.mostrarMenu(); //Mostrar menu
            op = menu.getOpcio(sc);
            
            switch(op){
                
                case OP1:

                    
                    break;
                
                case OP2:

                    break;
                
                case OP3:

                    break;
                    
                case OP4:

                    break;
                    
                case OP5:

                    break;
                    
                case OP6:

                    break;
                    
                case OP7:
     
                    
                    break;
                    
                case OP8:
    
                    break;
                    
                case OP9:
                    break;
                    
                case OP10:
                    break;
                    
                case OP11:
                    
                    break;
                    
                case OP12:
                    
                    
                case OPSORTIR:
                    System.out.println("Sortint del menu de gestio de l'estacio");
                    break;
            }
        }while(op != MenuPrincipal.OPSORTIR);
    }
    
    
    
    private float generaDemandaPotencia(){
        float valor = Math.round(variableNormal.seguentValor());
        if (valor > DEMANDA_MAX)
            return DEMANDA_MAX;
        else
            if (valor < DEMANDA_MIN)
                return DEMANDA_MIN;
            else
                return valor;
    }
    
    private void finalitzaDia() {
        // Finalitzar dia i imprimir informacio de la central
        String info = new String();
        info = adaptador.finalitzaDia(demandaPotencia);
        System.out.println(info);
        System.out.println("Dia finalitzat\n");
        
        // Generar i mostrar nova demanda de potencia
        demandaPotencia = generaDemandaPotencia();
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats");
    }
}
