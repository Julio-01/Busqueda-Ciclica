public class BusquedaCiclica{

    int[] secuencia; // La secuencia donde se buscara
    int busqueda; // El elemento a buscar
    int iteraciones = 0; // Numero de iteraciones

    /* 
    Constructor de Busqueda Ciclica
    @param secuencia - la secuencia donde buscaremos
    @param busqueda - elemento a buscar
    */
    public BusquedaCiclica(int[] secuencia, int busqueda){
        this.secuencia = secuencia;
        this.busqueda = busqueda;
    }

    /* 
    Metodo que inicia la busqueda de la secuencia e imprime el resultado
    */
    public void iniciar(){
        System.out.println("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% NUEVA SECUENCIA %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        int resultado = bbc();
        System.out.println("=============================================== RESULTADO ===============================================");
        if(resultado==-1){
            System.out.println("No existe el elemento en la secuencia.\n");
        }else
            System.out.println("Indice del elemento buscado: " + resultado + "\n");
    }

    /* 
    Metodo que implementa la busqueda binaria ciclica. Regresamos -1 si el elemento no es encontrado
    @return int - el indice del elemento buscado
    */
    public int bbc(){
        System.out.print("Secuencia: " + secuencia[0]);
        for(int i = 1; i < secuencia.length ; i++){
            System.out.print(" - " + secuencia[i]);
        }
        System.out.print("\nElemento a buscar: " + busqueda + "\n");
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        int n = secuencia.length-1;
        int resultado = encontrarIndice(secuencia, 0, n, busqueda);
        return resultado;
    }

    /* 
    Metodo que implementa la busqueda binaria ciclica recursivamente
    @param secuencia - la secuencia donde buscaremos
    @param izq - el pivote izquierdo (indice izquierdo)
    @param der - el pivote derecho (indice derecho)
    @param busqueda - el elemento a buscar
    @return int - el indice del elemento buscado
    */
    private int encontrarIndice(int[] secuencia, int izq, int der, int busqueda){
        iteraciones++;
        int mitad = (izq + der) / 2;
        imprimirProgreso(secuencia,izq,der);
        System.out.print("Mitad: " + mitad + "\nX[" + mitad + "] = " + secuencia[mitad] + " == " + busqueda + "? ");
        // Si el pivote izquierdo y el pivote derecho se cruzan entonces no existe el elemento
        if(der < izq){
            System.out.print("No, los indices han sido rabasados\n\n");
            return -1;
        }else{
            if(busqueda == secuencia[mitad]){
                System.out.print("Si\n\n");
                return mitad;
            }
            System.out.print("No\n\n");
            if (secuencia[mitad] <= secuencia[der]){
                if(busqueda > secuencia[mitad] && busqueda <= secuencia[der])
                    return encontrarIndice(secuencia, mitad + 1, der, busqueda);
                else
                    return encontrarIndice(secuencia, izq, mitad - 1, busqueda);
            }else{
                if(busqueda >= secuencia[izq] && busqueda < secuencia[mitad])
                    return encontrarIndice(secuencia, izq, mitad - 1 , busqueda);
                else
                    return encontrarIndice(secuencia, mitad + 1, der, busqueda);
            }
        }
    }

    /* 
    Metodo que imprime el desarrollo de la busqueda
    @param secuencia - la secuencia actual donde buscamos
    @param izq - el pivote izquierdo (indice izquierdo)
    @param der - el pivote derecho (indice derecho)
    */
    private void imprimirProgreso(int[] secuencia, int izq, int der){
        System.out.println("--------------------------------------------------");
        System.out.print("Secuencia Actual: " + secuencia[izq]);
        for(int i = izq+1; i <= der ; i++){
            System.out.print(" - " + secuencia[i]);
        }
        System.out.println("\nIteracion " + iteraciones + "\n");
        System.out.println("Indice izquierdo: " + izq + " - X[" + izq + "]=" + secuencia[izq]);
        System.out.println("Indice derecho: " + der + "   - X[" + der + "]=" + secuencia[der]);
    }
    

}