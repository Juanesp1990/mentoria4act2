package LiteDiccionario;
import java.io.*;
import java.util.*;

public class Diccionario {
    private String palabra;
    private String traduccion;
    private String fila;
    private int numeroDeFilas=0;

    public Diccionario(){}

    public Diccionario (String palabra, String traduccion) {
        this.palabra = palabra;
        this.traduccion = traduccion;

    }

    public String getPalabra () {
        return palabra;
    }

    public void setPalabra (String palabra) {
        this.palabra = palabra;
    }

    public String getTraduccion () {
        return traduccion;
    }

    public void setTraduccion (String traduccion) {
        this.traduccion = traduccion;
    }

    public String getFila () {
        return fila;
    }

    public void setFila (String fila) {
        this.fila = fila;
    }

    public int getNumeroDeFilas () {
        return numeroDeFilas;
    }

    public void setNumeroDeFilas (int numeroDeFilas) {
        this.numeroDeFilas = numeroDeFilas;
    }

    //    metodo para validar si existe el archivo
    public boolean VerificacionPalabra(String buscada){

        return true;
    }

//    metodo agregar nuevo
    public void agregar(){
        String concatenar="";
        fila=palabra+" "+traduccion;
        concatenar = ObtenerLista()+fila;

        try {
            PrintWriter writer = new PrintWriter("juan.txt", "UTF-8");
            writer.println(concatenar);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("palabra agregada correctamente");
    }

//    metodo imprimir lista
    public void imprimirLista(){
        System.out.println(ObtenerLista());
    }
//    metodo buscar
    public String BuscarPalabra(String palabraBuscada){
        String respuesta="";

        String[]lineas=new String[getNumeroDeFilas()];
        lineas=ObtenerLista().split("\n");
        for (int i = 0; i < getNumeroDeFilas(); i++) {
            String []dividirFila=new String[2];
            dividirFila=lineas[i].split(" ");
            if(dividirFila[0].equals(palabraBuscada)){
                System.out.println("Palabra encontrada");
                respuesta=dividirFila[1];
                break;
            }else{
                respuesta="lo sentimos";
            }
        }
        System.out.println();
        return respuesta;
    }

//    metdo obtener lista
    public String ObtenerLista(){
        String leerFila="";
        String temp="";
        int contador=0;
        try {
            FileReader r=new FileReader("juan.txt");
            BufferedReader buffer=new BufferedReader(r);

            while(temp!=null){
                temp=buffer.readLine();
                if (temp == null) {
                    break;
                }else{
                    leerFila=leerFila+temp+"\n";
                    contador=contador+1;
                    setNumeroDeFilas(contador);
                }
            }

        }catch (Exception e){
            System.out.println("Archivo no encontrado");

        }

        return leerFila;
    }
}

