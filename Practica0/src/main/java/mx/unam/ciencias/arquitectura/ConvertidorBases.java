package mx.unam.ciencias.arquitectura;
import java.lang.Math;
import java.util.HashMap;

/**
* Clase encargada de la conversión de números en bases potencias de dos/decimal
* a números en bases potencias de dos/decimal.
*/
public class ConvertidorBases{

    private static final ConvertidorBases INSTANCE = new ConvertidorBases();
    private final HashMap<String, String> diccionario;

    private ConvertidorBases(){
        HashMap<String, String> diccionario = new HashMap<String, String>();
        diccionario.put("0000", "0");
        diccionario.put("0001", "1");
        diccionario.put("0010", "2");
        diccionario.put("0011", "3");
        diccionario.put("0100", "4");
        diccionario.put("0101", "5");
        diccionario.put("0110", "6");
        diccionario.put("0111", "7");
        diccionario.put("1000", "8");
        diccionario.put("1001", "9");
        diccionario.put("1010", "A");
        diccionario.put("1011", "B");
        diccionario.put("1100", "C");
        diccionario.put("1101", "D");
        diccionario.put("1110", "E");
        diccionario.put("1111", "F");

        diccionario.put("0","0000");
        diccionario.put("1","0001");
        diccionario.put("2","0010");
        diccionario.put("3","0011");
        diccionario.put("4","0100");
        diccionario.put("5","0101");
        diccionario.put("6","0110");
        diccionario.put("7","0111");
        diccionario.put("8","1000");
        diccionario.put("9","1001");
        diccionario.put("A","1010");
        diccionario.put("B","1011");
        diccionario.put("C","1100");
        diccionario.put("D","1101");
        diccionario.put("E","1110");
        diccionario.put("F","1111");

        this.diccionario = diccionario;
    }

    /**
    * Método que convierte números en base dos a su representación en base octal.
    * @param n String que representa el número en base 2.
    * @return String que representa el número recibido en base 10. 
    */
    public String dosAOctal(String n) throws NumberFormatException{
        int i = n.length();
        int j = n.length() / 3;
        String numero = "";
        while(j > 0){
            String oct = this.diccionario.get("0" + n.substring(i - 3, i));
            if(oct == null)
                throw new NumberFormatException("El argumento no es un número en base dos, por favor, intenta de nuevo.");
            numero = oct + numero;
            j--;
            i = i - 3;
        }
        String oct = n.substring(0, i);
        if(oct == null)
            throw new NumberFormatException("El argumento no es un número en base dos, por favor, intenta de nuevo.");
        else if (oct.length() == 1)
            oct = this.diccionario.get("000" + oct);
        else if (oct.length() == 2)
            oct = this.diccionario.get("00" + oct);
        return oct + numero;
    }

    /**
    * Método que convierte números en base dos a su representación en base decimal.
    * @param n String que representa al número en base dos.
    * @return String que representa al número en base decimal.
    */
    public String dosADiez(String n) throws NumberFormatException{
        return octalADiez(dosAOctal(n));
    }

    /**
    * Método que convierte números en base dos a su representación en base hexadecimal.
    * @param n String que representa al número en base dos.
    * @return String que representa al número en base hexadecimal.
    */
    public String dosAHexadecimal(String n) throws NumberFormatException{
        int i = n.length();
        int j = n.length() / 4;
        String numero = "";
        while(j > 0){
            String hex = this.diccionario.get(n.substring(i - 4, i));
            if(hex == null)
                throw new NumberFormatException("El argumento no es un número en base dos, por favor, intenta de nuevo.");
            numero = hex + numero;
            j--;
            i = i - 4;
        }
        String hex = n.substring(0, i);
        if(hex == null)
            throw new NumberFormatException("El argumento no es un número en base dos, por favor, intenta de nuevo.");
        else if (hex.length() == 1)
            hex = this.diccionario.get("000" + hex);
        else if (hex.length() == 2)
            hex = this.diccionario.get("00" + hex);
        else if (hex.length() == 3)
            hex = this.diccionario.get("0" + hex);
        return hex + numero;
    }

    /**
    * Método que convierte números en base octal a su representación en base dos.
    * @param n String que representa al número en base octal
    * @return String que representa al número en base dos.
    */
    public String octalADos(String num) throws NumberFormatException{
        int n = num.length();
        String oct = "";
        while( n != 0){
            String s = diccionario.get(num.substring(n-1, n));
            if (s == null || s.substring(0, 1).equals("1"))
                throw new NumberFormatException("Se ha detectado un carácter no válido en el número octal. Por favor, intenta de nuevo");
            oct = s.substring(1,4) + oct;
            n--;
        }
        return oct;
    }

    /**
    * Método que convierte números en base dos a su representación en base decimal.
    * @param n String que representa el número en base octal.
    * @return int que representa el número recibido en base 10. 
    */
    public String octalADiez(String n) throws NumberFormatException{
        int i = n.length() - 1;
        int j = 0;
        int numero = 0;
        while(i >= 0){
            int digito = Integer.parseInt(n.substring(i, i+1));
            if(digito >= 8)
                throw new NumberFormatException("El argumento no es un número en base octal, por favor, intenta de nuevo.");
            int oct = digito * (int) Math.pow(8, j);
            numero += oct;
            j++;
            i--;
        }
        return Integer.toString(numero);
    }

    /**
    * Método que convierte números en base octal a su representación en base hexadecimal.
    * @param n String que representa al número en base octal.
    * @return String que representa al número en base hexadecimal.
    */
    public String octalAHexadecimal(String n) throws NumberFormatException{
        return dosAHexadecimal(octalADos(n));
    }

    /**
    * Método que convierte números en base decimal a su representación en base dos.
    * @param n String que representa al número en base diez.
    * @return String que representa al número en base dos.
    */
    public String diezADos(String n) throws NumberFormatException{
        return octalADos(diezAOctal(n));
    }

    /**
    * Método que  convierte números en base diez a su representación en base octal.
    * @param n String que representa al número en base diez.
    * @return String que representa al número en base octal.
    */
    public String diezAOctal(String n) throws NumberFormatException{
        int numero = Integer.parseInt(n);
        if (numero < 0)
            throw new NumberFormatException("Solo se aceptan números naturales. Por favor, intenta de nuevo.");
        String octal = "";
        while( (numero / 8) != 0 ){
            octal = Integer.toString(numero % 8) + octal;
            numero = numero / 8;
        }
        octal = Integer.toString(numero % 8) + octal;
        return octal;
    }

    /**
    * Método que convierte números en base diez a su representación en base hexadecimal.
    * @param n String que representa al número en base 10.
    * @return String que representa al número recibido en base hexadecimal. 
    */
    public String diezAHexadecimal(String n) throws NumberFormatException{
        return octalAHexadecimal(diezAOctal(n));
    }

    /**
    * Método que convierte números en base hexadecimal a su representación en base dos.
    * @param n String que representa al número en base hexadecimal.
    * @return String que representa al número en base dos.
    */
    public String hexadecimalADos(String num) throws NumberFormatException{
        int n = num.length();
        String hex = "";
        while(n != 0){
            String s = diccionario.get(num.substring(n-1, n));
            if (s == null)
                throw new NumberFormatException("Se ha detectado un carácter no válido en el número hexadecimal. Por favor, intenta de nuevo");
            hex = s + hex;
            n--;
        }
        return hex;
    }

    /**
    * Método que convierte números en base hexadecimal a su representación en base octal.
    * @param n String que representa al número en base hexadecimal.
    * @return String que representa al número en base octal.
    */
    public String hexadecimalAOctal(String n) throws NumberFormatException{
        return dosAOctal(hexadecimalADos(n));
    }

    /**
    * Método que convierte números en base hexadecimal a su representación en base diez.
    * @param n String que representa al número en base hexadecimal.
    * @return String que representa al número en base decimal.
    */
    public String hexadecimalADiez(String n) throws NumberFormatException{
        return dosADiez(hexadecimalADos(n));
    }

    public static ConvertidorBases getInstance(){
        return INSTANCE;
    }
}