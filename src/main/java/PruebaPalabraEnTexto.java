import cuentapalabras.PalabraEnTexto;

public class PruebaPalabraEnTexto {
    public static void main(String[] args) {
        String p1 = "GORRA";
        String p2 = "gorra";
        PalabraEnTexto Palabra1 = new PalabraEnTexto(p1);
        Palabra1.incrementa();
        PalabraEnTexto Palabra2 = new PalabraEnTexto(p2);
        System.out.println("Palabra 1 = " + Palabra1);
<<<<<<< HEAD
        System.out.println("Palabra 2 = " +Palabra2);
=======
        System.out.println("Palabra 2 = " + Palabra2);
>>>>>>> developer_2
        if(Palabra1.equals(Palabra2)){
            System.out.println("Las palabras son iguales");
        }else{
            System.out.println("Las palabras son distintas");
        }

    }
}
