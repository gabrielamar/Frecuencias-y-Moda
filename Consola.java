/*********************************************
 * Gabriela Martín                           *
 *                Curso de Programación Java *
 * Capitulo05/Consola.java                   *
 *********************************************/

 /**
 * Esta clase recoge una serie de naturales      *
 * y calcula frecuencia absoluta, relativa       *
 * y moda de la serie.                           *
 * @author Gabriela Martín                       */

class Consola {
  public static void main (String args[]) {
    System.out.println
        ("Consola de ingreso de datos");

    int m;
    Numero X;
    boolean NoNum = true;
    /* Va ingresando datos uno por uno, si se trata
       de un numero positivo, crea un par: (numero, repeticiones)
       si es un numero negativo termina la recoleccion y da los
       resultados */
    do{
       do {
          m = Terminal.leeEntero
            ("Ingrese un natural a la vez, cuando quiera ver los cálculos ingrese un negativo cualquiera: "); 

          if(Numero.buscarNumero(m) == null && m >=0){
             new Numero(m,1);
            }
          else{ if (m >= 0)
                 {X = Numero.buscarNumero(m);
                  X.Increm();
                  }

              }

         } while (m >= 0);


    /* Controla que se haya ingresado algo más que sólo
    un numero negativo */

    NoNum = Numero.NoNum();
    if (NoNum){
    Numero.listarNumeros();
    Numero.listarModas();
    }
    else{System.out.println("No has introducido ningún dato");

    }
   }while (!NoNum);

  }
}

/******** Fin de Consola.java ****************/
