
public class main{

    public static void main(String[] args){
        String ruta = "ejemplares.txt";
        Archivo archivo = new Archivo(ruta);
        archivo.leerArchivo();
    }

}