public class BusquedaCiclica{

    int[] secuencia;
    int busqueda;
    int iteraciones = 0;

    public BusquedaCiclica(int[] secuencia, int busqueda){
        this.secuencia = secuencia;
        this.busqueda = busqueda;
    }

    public void iniciar(){
        System.out.println("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% NUEVA SECUENCIA %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
        int resultado = bbc();
        System.out.println("=============================================== RESULTADO ===============================================");
        if(resultado==-1){
            System.out.println("No existe el elemento en la secuencia.\n");
        }else
            System.out.println("Indice del elemento buscado: " + resultado + "\n");
    }

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

    private int encontrarIndice(int[] secuencia, int izq, int der, int busqueda){
        iteraciones++;
        int mitad = (izq + der) / 2;
        imprimirProgreso(secuencia,izq,der);
        System.out.print("Mitad: " + mitad + "\nX[" + mitad + "] = " + secuencia[mitad] + " == " + busqueda + "? ");
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