package cuentapalabras;

public class PruebaContadorPalabras {
    public static void main(String[] args) {
        ContadorPalabras c1 = new ContadorPalabras();
        String [] datos = {
                "Esta es la primera frase del ejemplo",
                "y esta es la segunda frase"
        };
        String del = "[ ]";
        c1.incluyeTodas(datos, del);
        System.out.println(c1);
    }


}