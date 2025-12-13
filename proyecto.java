import java.util.Scanner;

public class proyecto {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        menu();
        
    }
    //MENU PRINCIPAL
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        int op=0;
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

        switch (op){                                              //Estructura switch para seleccionar la opcion
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

    //METODOS DE CONVERSIONES

    private static void decimalBinario(){
        Scanner sc = new Scanner(System.in);
        int reiduos = 0;
        int dec=0;
        String bin="";
        System.out.println(" ***** ingrese un numero base 10 para convertir a binario *****");
        System.out.println("\n Ingrese un numero decimal: ");
        dec = sc.nextInt();
        bin = decBinario(dec);
        System.out.println("El numero "+dec+" en binario es: "+bin);
        reiniciar();
        
    }
    private static String decBinario(int dec) {
        String bin="";
        while (dec > 0) {
            int residuo = dec % 2;  // logica temporal- modificar
            bin = residuo + bin;
            dec = dec / 2;
        }
        

        return bin;
        
        }
    //metodo binario a decimal
    private static void binarioDecimal() {
        Scanner bi = new Scanner(System.in);
        String bin="";
        int dec=0;
        
        System.out.println(" ***** ingrese un numero binario para convertir a binario *****");
        System.out.println("\n Ingrese binario : ");
        bin = bi.nextLine();
        dec = bindecimal(bin);
        System.out.println("El numero binario : "+bin+" a decimal es: "+dec);
        reiniciar();
        
        
    }

    private static int bindecimal (String bin) {
        int valor=0;
        int d=0;
        for(int i= bin.length()-1; i>=0; i--){
            d= Integer.parseInt(bin.substring(i, i+1));
            valor += Math.pow(2, bin.length()-(i+1))*d;
        }
        return valor;

    }


    //metodo decimal a octal
    private static void decimalOctal() {
    Scanner sc = new Scanner(System.in);
    int deci=0;
    String octal="";
    System.out.println(" ***** ingrese un numero base 10 para convertir a octal *****");
   
    System.out.println("\n Ingrese un numero decimal: ");
    deci = sc.nextInt();
    if(deci < 0){
        System.out.println("El numero debe ser positivo. Intente de nuevo.");
        reiniciar();
    }
    if(deci == 0){
        System.out.println("El numero en octal es: 0");
        reiniciar();
    }
    octal = decOctal(deci);
    System.out.println("El numero "+deci+" en octal es: "+octal);
    reiniciar();
    }

    private static String decOctal(int deci) {
    String resoctal = "";
    while (deci > 0){
        int residuo = deci % 8;  // variable tempral que guarda el residuo
        resoctal = residuo + resoctal; // concatenacion de residuos y los invierte
        deci = deci / 8; // actualizacion del valor decimal
    }
    
    return resoctal;
    }
    //metodo octal a decimal
    private static void octalDecimal() {
    String octal="";
    int deci=0;
    Scanner sc = new Scanner(System.in);
    System.out.println(" ***** ingrese un numero octal para convertir a decimal *****");
    System.out.println("\n Ingrese un numero octal: ");
    octal = sc.nextLine();
    
        
    }
    //metodo hexadecimal a decimal
    private static void hexadecimalDecimal() {
    
    }
    //metodo decimal a hexadecimal
    private static void decimalHexadecimal() {
    
    }
    //metodo romanos a decimal
    private static void romanosDecimal() {
    
    }

    //metodo decimal a romanos

    private static void decimalRomanos() {
        
    }

    //metodo salir
    private static void salir() {
        System.out.println("Gracias por usar el sistema de conversiones.");
    }
    
    //metodo reiniciar
    private static void reiniciar() {
    Scanner sc1 = new Scanner(System.in);
    System.out.println("\n Presione ENTER para volver al menu principal...");
    sc1.nextLine();

    menu();
    
    }







}
