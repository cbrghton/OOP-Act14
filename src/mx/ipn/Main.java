package mx.ipn;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TrabajaFechas trabajaFechas = new TrabajaFechas();
        Scanner scanner = new Scanner(System.in);
        String flag = "S";

        while (flag.equals("S") || flag.equals("s")) {
            System.out.println("""
                    Bienvenido a la Actividad 14
                    ¿Qué acción desea realizar?
                    1. Formatear una fecha al español
                    2. Obtener la estación del año de una fecha
                    3. Obtener el dia de la semana de una suma/resta de dias en una fecha
                    4. Obtener la edad en semanas de una persona""");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    option1(trabajaFechas, scanner);
                    break;
                case 2:
                    option2(trabajaFechas, scanner);
                    break;
                case 3:
                    option3(trabajaFechas, scanner);
                    break;
                case 4:
                    option4(trabajaFechas, scanner);
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

            System.out.println("¿Desea repetir? S/N");
            flag = scanner.nextLine();
        }
    }

    public static void option1(TrabajaFechas trabajaFechas, Scanner scanner) {
        System.out.println("Ingrese la fecha a formatear dd-mm-yyyy ej. 01-01-2021");
        String stringDate = scanner.nextLine();

        try {
            String spanishDate = trabajaFechas.formatoSpanish(trabajaFechas.getFormatter().parse(stringDate));
            System.out.println("La fecha formateada es: " + spanishDate);
        } catch (ParseException exception) {
            System.out.println("Ingresaste datos incorrectos");
        }
    }

    public static void option2(TrabajaFechas trabajaFechas, Scanner scanner) {
        System.out.println("Ingresa la fecha dd-mm-yyyy ej. 01-01-2021");
        String stringDate = scanner.nextLine();

        try {
            String season = trabajaFechas.estacionDelAnio(trabajaFechas.getFormatter().parse(stringDate));
            System.out.println("La estación del año de la fecha es: " + season);
        } catch (ParseException exception) {
            System.out.println("Ingresaste datos incorrectos");
        }
    }

    public static void option3(TrabajaFechas trabajaFechas, Scanner scanner) {
        System.out.println("Ingresa la fecha dd-mm-yyyy ej. 01-01-2021");
        String stringDate = scanner.nextLine();

        System.out.println("Ingresa los dias a sumar (se aceptan números negativos)");
        int days = scanner.nextInt();
        scanner.nextLine();

        try {
            System.out.println("El dia de la semana resultante es: " + trabajaFechas.queDia(trabajaFechas.getFormatter().parse(stringDate), days));
        } catch (ParseException exception) {
            System.out.println("Ingresaste datos incorrectos");
        }
    }

    public static void option4(TrabajaFechas trabajaFechas, Scanner scanner) {
        System.out.println("Ingrese la fecha de nacimiento de la persona dd-mm-yyyy ej. 01-01-2021");
        String birthDateString = scanner.nextLine();

        try {
            System.out.println("La edad en semanas de la persona es: " + trabajaFechas.edadEnSemanas(trabajaFechas.getFormatter().parse(birthDateString)));
        } catch (ParseException exception) {
            System.out.println("Ingresaste datos incorrectos");
        }
    }
}
