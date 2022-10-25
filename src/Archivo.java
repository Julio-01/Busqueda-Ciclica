import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    
    private String ruta; // La ruta del archivo
    private File archivo; // El archivo
    private ArrayList<Integer> secuencia; // Los elementos de la secuencia

    /* 
    Constructor del Archivo que cargaremos
    @param ruta - la ruta del archivo
    */
    public Archivo(String ruta) {
        this.ruta = ruta;
        this.archivo = new File(this.ruta);
    }

    /* 
    Metodo que lee el archivo y separa las secuencias con su elemento a buscar.
    La separacion de elementos sera por medio de una coma y la separacion de las secuencias sera
    por medio de salto de linea.
    */
    public void leerArchivo() {
        try {
            FileReader fr = new FileReader(this.archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            secuencia = new ArrayList<Integer>();
            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(",");
                String[] elemento = linea.split("\n");
                for (int i = 0; i < numeros.length; i++) {
                    // Si la entrada es seguida de una coma entonces es una secuencia
                    if(!numeros[i].equals("")){
                        int numero = Integer.parseInt(numeros[i]);
                        secuencia.add(numero);
                    
                    // Si la entrada contiene una cadena vacia entonces existe un salto de linea y
                    // realizamos la busqueda de la secuencia e inicializamos una nueva
                    }else{
                        realizarBusqueda(secuencia);
                        secuencia = new ArrayList<Integer>();
                    }
                }
            }
            // Realizamos la busqueda de la ultima secuencia
            realizarBusqueda(secuencia);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    /* 
    Metodo que realiza la busqueda de una secuencia. Si el tamaño de la lista es negativo o
    igual a 1 no realizamos ninguna busqueda
    @param lista - la lista que contiene los elementos de la secuencia
    */
    public void realizarBusqueda(ArrayList<Integer> lista){
        if(lista.size() <= 1){
            return;
        }
        int[] arreglo = convertirLista(lista);
        // El ultimo elemento de la lista es el elemento que buscamos
        int buscar = lista.get(lista.size()-1);
        BusquedaCiclica busqueda = new BusquedaCiclica(arreglo,buscar);
        busqueda.iniciar();
    }

    /* 
    Metodo que convierte una lista a un arreglo de enteros.
    @param lista - la lista a convertir
    @return int[] - el arreglo convertido
    */
    public int[] convertirLista(ArrayList<Integer> lista){
        if(lista.size() <= 0){
            int[] arreglo = new int[0];
            return arreglo;
        }
        int[] arreglo = new int[lista.size()-1];
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = lista.get(i);
        }
        return arreglo;
    }
}