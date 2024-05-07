package cuentapalabras;

import java.util.ArrayList;

public class ContadorPalabras {
    ArrayList<PalabraEnTexto> palabras;
    public ContadorPalabras(){
        palabras = new ArrayList<>();
    }
    //Metodo que busca la PalabraEnTexto en el array si no esta devuelve -1.
    private int esta(String pal){
        PalabraEnTexto aux = new PalabraEnTexto(pal);
        for (int i=0; i<palabras.size(); ++i){
            if(palabras.get(i).equals(aux)){
                return i;
            }
        }
        return -1;
    }
    protected void incluye(String pal){
        int pos = esta(pal);
        if(!(pal.isEmpty())) {
            if (pos < 0) {
                palabras.add(new PalabraEnTexto(pal));
            } else {
                palabras.get(pos).incrementa();
            }
        }
    }
}
