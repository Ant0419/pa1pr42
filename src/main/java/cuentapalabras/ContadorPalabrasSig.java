package cuentapalabras;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ContadorPalabrasSig extends ContadorPalabras{
    private ArrayList<String> noSignificativas;
    public ContadorPalabrasSig(){
        noSignificativas = new ArrayList<>();
    }
    public void leeArrayNoSig(String[] palsNS){
        noSignificativas.clear();
        for(int i=0; i<palsNS.length; ++i){
            noSignificativas.add(palsNS[i].toUpperCase());
        }
    }
    public void leeFicheroNoSig(String filNoSig, String del) throws IOException{
        noSignificativas.clear();
        Path path = Path.of(filNoSig);
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String linea = br.readLine();
            while (linea != null) {
                anyadePalabrasNoSignificativas(linea, del);
                linea = br.readLine();
            }
        }
    }
    private void anyadePalabrasNoSignificativas(String linea, String del){
        String[] palabrasProcesadas = linea.split(del);
        for (String palabrasProcesada : palabrasProcesadas) {
            noSignificativas.add(palabrasProcesada.toUpperCase());
        }
    }

}
