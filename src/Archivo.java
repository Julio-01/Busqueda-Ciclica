import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    
    private String ruta;
    private File archivo;
    private ArrayList<Integer> secuencia;


    public Archivo(String ruta) {
        this.ruta = ruta;
        this.archivo = new File(this.ruta);
    }


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
                    if(!numeros[i].equals("")){
                        int numero = Integer.parseInt(numeros[i]);
                        secuencia.add(numero);
                    }else{
                        realizarBusqueda(secuencia);
                        secuencia = new ArrayList<Integer>();
                    }
                }
            }
            realizarBusqueda(secuencia);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    public void realizarBusqueda(ArrayList<Integer> lista){
        if(lista.size() <= 0){
            return;
        }
        int[] arreglo = convertirLista(lista);
        int buscar = lista.get(lista.size()-1);
        BusquedaCiclica busqueda = new BusquedaCiclica(arreglo,buscar);
        busqueda.iniciar();
    }

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