/*********************************************
 * Gabriela Martín Torres                    *
 *                Curso de Programación Java *
 * Capitulo05/Moda.java                      *
 *********************************************/

 /**
 * Esta clase calcula la moda, frecuencia absoluta
 * y frecuencia relativa de un conjunto de datos.
 *
 * Cada objeto de esta clase contendrá las
 * siguientes variables:
 *  - Numero (tipo int)
 *  - Repeticiones del número (tipo int)
 *  - siguienteNumero (tipo Numero)
 *
 * Los métodos soportados por esta clase son:
 *   * Constructores
 *  - Numero (numero, repeticiones)
 *   * Acceso a campos
 *  - BuscarNumero
 *  - ListarNumeros
 *  -ListarModas
 *   * Operaciones 
 *  - Total (numero total de datos ingresados)
 *  - Increm (incrementa en uno el contador de repeticiones)
 *  - Moda
 *  - NoNum (booleano que controla que el conjunto de 
 *  datos no sea vacío)
 *  
 *
 * @author Gabriela Martín
 */

class Numero {  
   private static Numero NumeroInicial = null;

   private int      numero;
   private int      repet;
   private Numero siguienteNumero;

   /** Constructor básico          *
     *  - Requiere necesariamente  *
     *    un numero                */
     
   public Numero(int m,int r) {
      numero = m;
      repet = r;
      
      if (NumeroInicial == null)
         NumeroInicial = this;
      else {
         Numero NumeroAux = NumeroInicial;
         while (NumeroAux.siguienteNumero != null)
            NumeroAux = NumeroAux.siguienteNumero;
         NumeroAux.siguienteNumero = this;
      }

   }
   

   public void Increm () {
      repet  = repet + 1 ;
   }
   
   
   public static float Total(){
       float Total = 0;
       Numero numeroAux = NumeroInicial; 

      while (numeroAux != null) {
         Total += numeroAux.repet; 
         numeroAux = numeroAux.siguienteNumero;
      }
      return Total; 
    }
    
      /** Método toString para la       *
        * impresión del contenido de    *
        * de un objeto de tipo Numero y su frec relativa*/
   public String toString() {
       float FR = repet/Total()*100; 
       String imprime = numero + "   "
                 + " frec abs: "
                 + repet + " frec rel: "+ FR +"%";
      return imprime;
   }


   public static void listarNumeros() {
      System.out.println("LISTADO DE NUMEROS");
      Numero numeroAux = NumeroInicial; 
      while (numeroAux != null) {
         System.out.println(numeroAux);
         numeroAux = numeroAux.siguienteNumero;
      }
   }

   
   public static Numero buscarNumero (int m) {
      Numero NumeroAux = NumeroInicial;

      while (NumeroAux != null) {
         if (NumeroAux.numero == m)
           return NumeroAux;
         NumeroAux = NumeroAux.siguienteNumero;
      }

      return null;
   }
   
public static int Moda(){ 
    Numero Puntero = NumeroInicial;
    int max = Puntero.repet;
    int moda = Puntero.numero;
    while(Puntero.siguienteNumero != null) { 
        Puntero = Puntero.siguienteNumero;
        if(max<Puntero.repet){
            max = Puntero.repet;
            moda = Puntero.numero;
        }
        
    }
    return max;
}

public static void listarModas(){
     Numero Puntero = NumeroInicial; 
     System.out.println("Moda:");
     while(Puntero.siguienteNumero != null) { 
        
        if(Puntero.repet == Numero.Moda()){
           System.out.println(Puntero.numero);
        }
        Puntero = Puntero.siguienteNumero;
    }
    if (Puntero.repet == Numero.Moda()){
           System.out.println(Puntero.numero);
        }
       
   }
   
public static boolean NoNum(){
    boolean NoNum = true; 
    if (Total() == 0){NoNum = false; 
    }
    return NoNum;
}
    

}


/******** Fin de Moda.java ***************/
