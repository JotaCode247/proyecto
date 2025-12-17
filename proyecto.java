import java.util.Scanner;

public class proyecto {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menu();

    }

    // MENU PRINCIPAL
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println("");
        System.out.println("\n ********* SISTEMA DE CONVERSIONES *********");
        System.out.println(" 1. CONVERTIR DECIMAL A BINARIO  ");
        System.out.println(" 2. CONVERTIR BINARIO A DECIMAL  ");
        System.out.println(" 3. CONVERTIR DECIMAL A OCTAL ");
        System.out.println(" 4. CONVERTIR OCTAL A DECIMAL");
        System.out.println(" 5. HEXADECIMAL A DECIMAL ");
        System.out.println(" 6. DECIMAL A HEXADECIMAL ");
        System.out.println(" 7. ROMANOS A DECIMAL ");
        System.out.println(" 8. DECIMAL A ROMANOS ");
        System.out.println(" 9. SALIR ");
        System.out.println("");
        System.out.println("Seleccione una opcion: (1-9)");

        op = sc.nextInt();

        switch (op) { // Estructura switch para seleccionar la opcion
            case 1:
                decimalBinario();
                break;
            case 2:
                binarioDecimal();
                break;
            case 3:
                decimalOctal();
                break;
            case 4:
                octalDecimal();
                break;
            case 5:
                hexadecimalDecimal();

                break;
            case 6:
                decimalHexadecimal();
                break;
            case 7:
                romanosDecimal();
                break;
            case 8:
                decimalRomanos();
                break;
            case 9:
                salir();
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opcion no valida. Intente de nuevo.");
                reiniciar();
                break;

        }
    }

    // METODOS DE CONVERSIONES
    // Metodo de decimal a binario
    /*
     * Este método se encarga de interactuar con el usuario.
     * Recibe el número decimal, llama al método que realiza la conversión a
     * binario,
     * muestra el resultado y retorna al menú principal.
     */

    private static void decimalBinario() {
        Scanner sc = new Scanner(System.in);
        int dec = 0;
        String bin = "";

        System.out.println(" ***** ingrese un numero base 10 para convertir a binario *****");
        System.out.println("\n Ingrese un numero decimal: ");
        dec = sc.nextInt();

        if (dec < 0) {
            System.out.println("Error: el numero debe ser positivo.");
            reiniciar();
            return; // frena el metodo en caso de ser negativo
        }

        bin = decBinario(dec);
        System.out.println("El numero " + dec + " en binario es: " + bin);
        reiniciar();
    }

    private static String decBinario(int dec) {
        int reiduos = 0;
        String bin = "";
        while (dec > 0) {
            /*
             * El ciclo while sigue ejecutándose mientras el número decimal sea mayor que 0.
             * En cada iteración, el número se divide por 2 y se obtiene el residuo que
             * forma el binario
             */
            int residuo = dec % 2;
            bin = residuo + bin;
            /*
             * Concatenamos el residuo al principio del string bin para formar el número
             * binario,
             * ya que estamos construyendo el número desde el bit menos significativo al más
             * significativo
             */
            dec = dec / 2;
        }

        return bin;

    }

    // metodo binario a decimal
    private static void binarioDecimal() {
        Scanner bi = new Scanner(System.in);
        String bin = "";
        int dec = 0;
        System.out.println("x: Ingrese un número binario: ");
        bin = bi.next();
        if ((bin.matches("[01]+"))) {
            dec = bindecimal(bin);
            System.out.println("El número: " + bin + " en base decimal es: " + dec);
        } else {
            System.out.println("x: No está ingresando un número binario.");
        }
        reiniciar();

    }

    private static int bindecimal(String bin) {
        int valor = 0;
        int d = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            d = Integer.parseInt(bin.substring(i, i + 1));
            valor += Math.pow(2, bin.length() - (i + 1)) * d;
        }
        return valor;

    }

    // metodo decimal a octal
    private static void decimalOctal() {
        Scanner sc = new Scanner(System.in);
        int deci = 0;
        String octal = "";
        System.out.println(" ***** ingrese un numero base 10 para convertir a octal *****");

        System.out.println("\n Ingrese un numero decimal: ");
        deci = sc.nextInt();
        if (deci < 0) {
            System.out.println("El numero debe ser positivo. Intente de nuevo.");
            reiniciar();
        }
        if (deci == 0) {
            System.out.println("El numero en octal es: 0");
            reiniciar();
        }
        octal = decOctal(deci);
        System.out.println("El numero " + deci + " en octal es: " + octal);
        reiniciar();
    }

    private static String decOctal(int deci) {
        String resoctal = "";
        while (deci > 0) {
            int residuo = deci % 8; // variable tempral que guarda el residuo
            resoctal = residuo + resoctal; // concatenacion de residuos y los invierte
            deci = deci / 8; // actualizacion del valor decimal
        }

        return resoctal;
    }

    // metodo octal a decimal
    private static void octalDecimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** ingrese un numero octal para convertir a decimal *****");
        System.out.print("Ingrese un numero octal: ");

        String octal = sc.nextLine();
        int deci = ocdecimal(octal);

        if (deci != -1) {
            System.out.println("Decimal: " + deci);
        }

        sc.close();
    }

    private static int ocdecimal(String octal) {
        int numDecimal = 0;
        int potenciaDeOcho = 1;

        for (int i = octal.length() - 1; i >= 0; i--) {
            char digitoChar = octal.charAt(i);
            int digito = digitoChar - '0';

            // Validar octal
            if (digito < 0 || digito > 7) {
                System.out.println("Error: el número no es octal.");
                return -1;
            }

            numDecimal += digito * potenciaDeOcho;
            potenciaDeOcho *= 8;
        }

        return numDecimal;
    }

    // metodo hexadecimal a decimal
    private static void hexadecimalDecimal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("***** ingrese un numero hexadecimal para convertir a decimal *****");
        System.out.print("Ingrese hexadecimal: ");
        String hex = sc.nextLine().toUpperCase();

        int decimal = hexDecimal(hex);

        if (decimal != -1) {
            System.out.println("El numero hexadecimal " + hex + " en decimal es: " + decimal);
        }
        reiniciar();
    }

    private static int hexDecimal(String hex) {
        int total = 0;
        int potencia = 1;

        for (int i = hex.length() - 1; i >= 0; i--) {
            char c = hex.charAt(i);
            int valor = 0;

            // números
            if (c == '0')
                valor = 0;
            else if (c == '1')
                valor = 1;
            else if (c == '2')
                valor = 2;
            else if (c == '3')
                valor = 3;
            else if (c == '4')
                valor = 4;
            else if (c == '5')
                valor = 5;
            else if (c == '6')
                valor = 6;
            else if (c == '7')
                valor = 7;
            else if (c == '8')
                valor = 8;
            else if (c == '9')
                valor = 9;

            // letras
            else if (c == 'A')
                valor = 10;
            else if (c == 'B')
                valor = 11;
            else if (c == 'C')
                valor = 12;
            else if (c == 'D')
                valor = 13;
            else if (c == 'E')
                valor = 14;
            else if (c == 'F')
                valor = 15;

            else {
                System.out.println("Error: no es hexadecimal valido.");
                return -1;
            }

            total = total + (valor * potencia);
            potencia = potencia * 16;
        }

        return total;

    }

    // metodo decimal a hexadecimal
    private static void decimalHexadecimal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("***** ingrese un numero decimal para convertir a hexadecimal *****");
        System.out.print("Ingrese decimal: ");
        int dec = sc.nextInt();

        if (dec < 0) {
            System.out.println("El numero debe ser positivo.");
            reiniciar();
        }

        String hex = decHex(dec);
        System.out.println("El numero " + dec + " en hexadecimal es: " + hex);
        reiniciar();
    }

    private static String decHex(int dec) {
        String hex = "";
        int residuo = 0;

        while (dec > 0) {
            residuo = dec % 16;

            if (residuo == 10)
                hex = "A" + hex;
            else if (residuo == 11)
                hex = "B" + hex;
            else if (residuo == 12)
                hex = "C" + hex;
            else if (residuo == 13)
                hex = "D" + hex;
            else if (residuo == 14)
                hex = "E" + hex;
            else if (residuo == 15)
                hex = "F" + hex;
            else
                hex = residuo + hex;

            dec = dec / 16;
        }

        return hex;
    }

    // metodo romanos a decimal
    private static void romanosDecimal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("***** ingrese un numero romano para convertir a decimal *****");
        System.out.print("Ingrese romano: ");
        String romano = sc.nextLine().toUpperCase();

        if (!romanoValido(romano)) {
            System.out.println("Error: numero romano invalido.");
            reiniciar();
        }

        int decimal = romanoDecimal(romano);
        System.out.println("El numero romano " + romano + " en decimal es: " + decimal);
        reiniciar();
    }

    private static int romanoDecimal(String romano) {
        int total = 0;
        int anterior = 0;

        for (int i = romano.length() - 1; i >= 0; i--) {
            int valor = 0;

            char c = romano.charAt(i);

            if (c == 'I')
                valor = 1;
            else if (c == 'V')
                valor = 5;
            else if (c == 'X')
                valor = 10;
            else if (c == 'L')
                valor = 50;
            else if (c == 'C')
                valor = 100;
            else if (c == 'D')
                valor = 500;
            else if (c == 'M')
                valor = 1000;
            else {
                System.out.println("Romano invalido.");
                return -1;
            }

            if (valor < anterior) {
                total = total - valor;
            } else {
                total = total + valor;
                anterior = valor;
            }
        }

        return total;
    }

    private static boolean romanoValido(String romano) {
        int contador = 1;

        for (int i = 1; i < romano.length(); i++) {
            if (romano.charAt(i) == romano.charAt(i - 1)) {
                contador++;

                // No se pueden repetir más de 3 veces
                if (contador > 3) {
                    return false;
                }

                // V, L, D no se repiten
                if (romano.charAt(i) == 'V' ||
                        romano.charAt(i) == 'L' ||
                        romano.charAt(i) == 'D') {
                    return false;
                }
            } else {
                contador = 1;
            }
        }
        return true;
    }

    // metodo decimal a romanos
    private static void decimalRomanos() {
        Scanner sc = new Scanner(System.in);

        System.out.println("***** ingrese un numero decimal para convertir a romano *****");
        System.out.print("Ingrese decimal: ");
        int num = sc.nextInt();

        if (num <= 0 || num > 3999) {
            System.out.println("Numero fuera de rango.");
            reiniciar();
        }

        String romano = decRomano(num);
        System.out.println("El numero en romano es: " + romano);
        reiniciar();
    }

    private static String decRomano(int num) {
        String romano = "";

        while (num >= 1000) {
            romano += "M";
            num -= 1000;
        }
        while (num >= 900) {
            romano += "CM";
            num -= 900;
        }
        while (num >= 500) {
            romano += "D";
            num -= 500;
        }
        while (num >= 400) {
            romano += "CD";
            num -= 400;
        }
        while (num >= 100) {
            romano += "C";
            num -= 100;
        }
        while (num >= 90) {
            romano += "XC";
            num -= 90;
        }
        while (num >= 50) {
            romano += "L";
            num -= 50;
        }
        while (num >= 40) {
            romano += "XL";
            num -= 40;
        }
        while (num >= 10) {
            romano += "X";
            num -= 10;
        }
        while (num >= 9) {
            romano += "IX";
            num -= 9;
        }
        while (num >= 5) {
            romano += "V";
            num -= 5;
        }
        while (num >= 4) {
            romano += "IV";
            num -= 4;
        }
        while (num >= 1) {
            romano += "I";
            num -= 1;
        }

        return romano;
    }

    // metodo salir
    private static void salir() {
        System.out.println("Gracias por usar el sistema de conversiones.");
    }

    // metodo reiniciar
    private static void reiniciar() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("\n Presione ENTER para volver al menu principal...");
        sc1.nextLine();

        menu();

    }
}
