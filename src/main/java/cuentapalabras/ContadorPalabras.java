package cuentapalabras;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
import java.util.concurrent.TimeoutException;

public class ContadorPalabras {
    ArrayList<PalabraEnTexto> palabras;
    public ContadorPalabras(){
        palabras = new ArrayList<>();
    }
    private int esta(String pal){
        PalabraEnTexto aux = new PalabraEnTexto(pal);
        for(int i=0; i< palabras.size(); ++i){
            if(palabras.get(i).equals(aux)){
                return i;
            }
        }
        return -1;
    }
    /*Este metodo llama al metodo esta y si el metodo devuelve una pos>0 incrementa el num de veces que aparece la palabra
    * si pos<0 añade una nueva PalabraEnTexto al array.
    */
    protected void incluye(String pal){
        int pos = esta(pal);
        if(pos>0){
            palabras.get(pos).incrementa();
        }else{
            palabras.add(new PalabraEnTexto(pal));
        }
    }
    /*
    * Este metodo se le introduce una linea de texto y un delimitador, se guarda esa linea en palabras que estaran
    * separadas por del y hacemos un bucle que llamamos al metodo incluye.
    */
    private void incluyeTodas(String linea, String del){
        String[] palabrasProcesadas = linea.split(del);
        for(String pal: palabrasProcesadas){
            incluye(pal);
        }
    }
    //El string[] texto en cada posicion tiene las lineas del texto para ello separarlo con el delimitador llamas al
    //incluyeTodas de arriba
    public void incluyeTodas(String[] texto, String del){
        for(String s: texto){
            incluyeTodas(s,del);
        }
    }
    /*
    *En este metodo se pasa el nombre del fichero y el delimitador de las palabras, se abre el fichero usamos el
    * BufferedReader -> Guarda cada linea del fichero en un String que se llama linea llamando al primer metodo de incluyeTodas.
    */
    public void incluyeTodasFichero(String nomFich, String del) throws IOException {
        Path path = Path.of(nomFich);
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String linea = br.readLine();
            while (linea != null) {
                incluyeTodas(linea, del);
                linea = br.readLine();
            }
        }
    }
    //Busca una palabra que se introduce y devuelve la posicion, en caso de no encontrarlo lanza "NoSuchElementException"
    public PalabraEnTexto encuentra(String pal){
        int pos = esta(pal);
        if(pos == -1){
            throw new NoSuchElementException();
        }else{
            return palabras.get(pos);
        }
    }
    //Usamos StringJoinner para que la impresion en pantalla sea como la pedida en la practica.
    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner(" - ", "[", "]");
        for(PalabraEnTexto palabraEnTexto: palabras){
            sj.add(palabraEnTexto.toString());
        }
        return sj.toString();
    }
    public void presentaPalabras(String fichero) throws FileNotFoundException {

    }
    public void presentaPalabras (PrintWriter pw){

    }

}