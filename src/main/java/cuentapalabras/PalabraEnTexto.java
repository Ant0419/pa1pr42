package cuentapalabras;

import java.util.Objects;

public class PalabraEnTexto {
    private String palabra;//la palabra debera almacenarse en mayus
    private int veces;
    public PalabraEnTexto(String p){
        palabra = p.toUpperCase();
        veces = 1;
    }
    public void incrementa(){
        ++veces;
    }
    @Override
    public boolean equals(Object o){
        return (o instanceof PalabraEnTexto) && ((PalabraEnTexto) o).palabra.equals(palabra);
    }
    @Override
    public int hashCode(){
        return Objects.hash(palabra);
    }
    @Override
    public String toString(){
        return palabra + ": " + veces;
    }
}
