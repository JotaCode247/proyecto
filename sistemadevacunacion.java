import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class sistemadevacunacion {

    // Lista principal donde se guardan todos los pacientes

    private static List<ArrayList<String>> pacientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // seccion de registro
    // Mmedinte funcion sin parametros
    // recoger datos basicos, validar repeticion, guardar para usarlos luego y crear
    // clave de acceso
    public static void moduloRegistro() {

        System.out.println("\n--- REGISTRO DE PACIENTE ---");

        // aqui recojo los datos- entrada - lectura y almaceno
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        /*
         * Recorre la lista de pacientes y valida que la cédula ingresada no esté
         * repetida
         * p.get (2) posicion,que es la posicion de la cedula en la listas
         */

        // equals metodo de string, lo uso para validar que la cedula ingresada no sea
        // igual a una almacenada
        for (ArrayList<String> p : pacientes) { // la p es la variable individual para validar cada paciente
            if (p.get(2).equals(cedula)) {
                System.out.println("La cédula ya está registrada.");
                return;
            }
        }

        // Aquí solicito datos que luego usare para asignar la cita
        System.out.print("Fecha de nacimiento (DD/MM/YYYY): ");
        String fechaNac = scanner.nextLine();

        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine().toUpperCase(); /* funcion toUpperCase() por si el usuario copiaa miniscula */

        System.out.print("Tipo de sangre: ");
        String tipoSangre = scanner.nextLine().toUpperCase();

        System.out.print("Peso: ");
        String peso = scanner.nextLine();

        // Generación de clave
        /*
         * uso el substring para que mediante indice tome las dos primeras letras del
         * nombre y 2 d el apellido
         */
        /*
         * el substring extrae la subcadena que comienza en el índice especificado o
         * indices indicados
         */
        String clave = nombre.substring(0, 2).toUpperCase()
                + apellido.substring(0, 2).toUpperCase()
                + cedula;

        // Guardar los datos del paciente en un ArrayList
        // Cada dato se guarda en una posición específica
        // Luego se accede a ellos usando get(posición)
        ArrayList<String> paciente = new ArrayList<>();
        paciente.add(nombre); // 0 - Nombre
        paciente.add(apellido); // 1 - Apellido
        paciente.add(cedula); // 2 - Cédula
        paciente.add(fechaNac); // 3 - Fecha de nacimiento
        paciente.add(sexo); // 4 - Sexo
        paciente.add(tipoSangre); // 5 - Tipo de sangre
        paciente.add(peso); // 6 - Peso
        paciente.add(clave); // 7 - Clave de acceso

        // Agrega el paciente recién creado a la lista general de pacientes.
        // Guardo el paciente en la lista principal para poder usarlo después
        pacientes.add(paciente);

        System.out.println("Paciente registrado correctamente.");
        System.out.println("Clave de acceso: " + clave);
    }

    // seccion asignar citas - en dias
    // aca creo funcion sin parametros para llamar y crear la asignacion de citas

    public static void moduloAsignacionCita() {

        System.out.println("\n--- ASIGNACIÓN DE CITA ---");

        System.out.print("Ingrese cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese clave: ");
        String clave = scanner.nextLine();

        boolean encontrado = false; // aqui Inicializo la variable en falso porque aún no sé si el paciente existe
        /*
         * falso por que todavía no se ha recorrido la lista
         * ni se ha inicializado una comparacion
         */

        // aca recrro y busco el paciente
        /* aqui ya meto true porque comparo y verifico existencia */
        for (ArrayList<String> p : pacientes) {

            if (p.get(2).equals(cedula) && p.get(7).equals(clave)) {

                encontrado = true;
                /* Si la cédula y la clave coinciden, entonces sí encontré al paciente. */

                // ===== proceso para calcular la edad =====
                String fecha = p.get(3); // Aquí obtengo la fecha de nacimiento que está guardada como texto (desde el
                                         // arrylist)

                // Extraer día, mes y año con substring
                /*
                 * Como la fecha está guardada en formato DD/MM/YYYY texto, uso substring para
                 * separar día, mes y año.
                 */
                // luego Integer.parseInt para convetir texto a número
                int diaNac = Integer.parseInt(fecha.substring(0, 2)); // toma los dos primeros caracteres (día)
                int mesNac = Integer.parseInt(fecha.substring(3, 5));
                int anioNac = Integer.parseInt(fecha.substring(6, 10));

                LocalDate hoy = LocalDate.now(); // aca Obtengo la fecha actual del sistema.
                /* “Obtengo la fecha actual para compararla con la fecha de nacimiento. */
                int diaAct = hoy.getDayOfMonth();
                int mesAct = hoy.getMonthValue();
                int anioAct = hoy.getYear();

                // aca hago el calculo de la edad, años, meses y dias
                int anios = anioAct - anioNac;
                int meses = mesAct - mesNac;
                int dias = diaAct - diaNac;

                /*
                 * Si los días o meses quedan negativos, hago un ajuste restando o sumando para
                 * que la edad quede correcta
                 */
                // es decir, Si los días quedan negativos, tomo un mes y lo convierto en días,
                // por eso resto un mes (mes --;).
                if (dias < 0) {
                    dias += 30;
                    meses--;
                }
                //// Tomo un año y lo convierto en 12 meses
                if (meses < 0) {
                    meses += 12;
                    anios--;
                }

                // Edad total en días
                /* Calculo la edad total en días para facilitar comparaciones y priorización */
                int edadDias = (anios * 365) + (meses * 30) + dias;

                // ===== aqui valido primo =====
                /*
                 * Primero verifico si los últimos dos dígitos de la cédula son un número primo
                 * usando un método.
                 * Luego preparo los datos del paciente que necesito para calcular la asignación
                 * de la cita.
                 */

                String ced = p.get(2);
                int ultimosDos = Integer.parseInt(ced.substring(ced.length() - 2)); /*
                                                                                     * Posiciones: 0 1 2 3 4 5 6 7
                                                                                     * Valores: 1 2 3 4 5 6 7 8
                                                                                     */
                /*
                 * aca con ced.length() se saca el tamaño de la cédula
                 * ced.length() -2 posición de los últimos 2 números ced.length() - 2 -> 6 -- El
                 * -2 sirve para ubicarse dos posiciones antes del final del texto.
                 * substring(...) toma esos dos números
                 * Integer.parseInt(...) → convierte a entero
                 */

                boolean primo = esPrimo(ultimosDos); // Llamo a un método que me dice si el número es primo y guardo el
                                                     // resultado
                /*
                 * retorno boolean : true si es primo
                 * false si no lo es
                 */
                // la variable primo Sirve para tomar decisiones más adelante (mediante los
                // ifacontinuacion)

                // SECCION PARA LA ASIGNACIÓN DE CITA

                int diasCita = 0; // Inicializo la variable donde se guardan los días de la cita.
                String sexo = p.get(4); // Obtiene el sexo del paciente desde la lista.
                String sangre = p.get(5); // Obtiene el rh
                double peso = Double.parseDouble(p.get(6));

                // aca inicio la prriorizacion
                /* Solo entra aquí si el paciente tiene más de 60 años */
                if (anios > 60) {

                    if (sexo.equals("F")) { // Luego verifico el sexo del paciente.

                        /*
                         * Uso condicionales anidados para filtrar al paciente por edad, sexo, peso,
                         * tipo de sangre
                         * y si su cédula termina en número primo.
                         * Según la combinación, asigno los días de la cita
                         */

                        if (peso > 70) {
                            if (sangre.equals("O+") && primo)
                                diasCita = edadDias / 150;
                            else if (sangre.equals("O+") && !primo)
                                diasCita = edadDias / 80;
                            else if (sangre.equals("A-") && primo)
                                diasCita = edadDias / 200;
                            else if (sangre.equals("A-") && !primo)
                                diasCita = edadDias / 45;
                            else if (primo)
                                diasCita = edadDias / 175;
                        } else {
                            diasCita = edadDias / 100;
                        }

                    } else if (sexo.equals("M")) {

                        if (peso > 80) {
                            if (sangre.equals("O+") && primo)
                                diasCita = edadDias / 180;
                            else if (sangre.equals("O+") && !primo)
                                diasCita = edadDias / 90;
                            else if (sangre.equals("A-") && primo)
                                diasCita = edadDias / 210;
                            else if (sangre.equals("A-") && !primo)
                                diasCita = edadDias / 40;
                            else if (primo)
                                diasCita = edadDias / 145;
                        } else {
                            diasCita = edadDias / 105;
                        }
                    }

                } else {
                    diasCita = edadDias / 250;
                }

                // Mostrar edad en años, meses y días
                System.out.println("Edad del paciente: " + anios + " años, " + meses + " meses y " + dias + " días");

                // Convertir días a meses y días
                int mesesCita = diasCita / 30;
                int diasRestantes = diasCita % 30;

                System.out.println("\nSu cita será en " + mesesCita + " meses y " + diasRestantes + " días.");
                break;
            }
        }
        /*
         * Uso una variable booleana para saber
         * si el paciente fue encontrado o no después de recorrer la lista
         */
        if (!encontrado) {
            System.out.println("Cédula o clave incorrecta.");
        }
    }

    // funcion de retorno boleano que recibe entero paraverificar el primo
    //
    public static boolean esPrimo(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // =========================
    // MENÚ PRINCIPAL
    // =========================
    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n1. Registrar paciente");
            System.out.println("2. Asignar cita");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1)
                moduloRegistro();
            else if (opcion == 2)
                moduloAsignacionCita();
            else if (opcion == 3)
                System.out.println("Saliendo...");
            else
                System.out.println("Opción inválida");

        } while (opcion != 3);
    }
}
