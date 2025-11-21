import java.util.Arrays;
import java.util.Scanner;

public class TestingBusquedaBinaria {
    public static void main(String[] args) {
        String archivoEntrada = "numerosBusquedaBinaria.txt";
        String archivoSalida = "numerosBusquedaBinaria_ordenados.txt";

        int[] numeros = BusquedaBinaria.leerArchivo(archivoEntrada);

        if (numeros != null) {
            System.out.println("numeros originales:");
            BusquedaBinaria.imprimirArray(numeros);

            Arrays.sort(numeros);

            System.out.println("\n numeros ordenados:");
            BusquedaBinaria.imprimirArray(numeros);

            BusquedaBinaria.escribirArchivo(numeros, archivoSalida);
            System.out.println("\n archivo generado exitosamente: " + archivoSalida);

            Scanner sc = new Scanner(System.in);
            System.out.print("\n ingresa un número a buscar: ");
            int numeroBuscado = sc.nextInt();

            int resultado = BusquedaBinaria.busquedaBinaria(numeros, numeroBuscado);

            if (resultado != -1) {
                System.out.println("el número " + numeroBuscado + " se encuentra en la posición (índice): " + resultado);
            } else {
                System.out.println("el número " + numeroBuscado + " no está en la lista.");
            }

            sc.close();
        } else {
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
