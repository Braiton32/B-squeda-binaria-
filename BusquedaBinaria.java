import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BusquedaBinaria {

    public static int[] leerArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int count = 0;

            while ((linea = br.readLine()) != null) {
                count++;
            }
            int[] numeros = new int[count];
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader(nombreArchivo));
            int i = 0;
            while ((linea = br2.readLine()) != null) {
                numeros[i] = Integer.parseInt(linea.trim());
                i++;
            }
            br2.close();

            return numeros;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    public static int busquedaBinaria(int[] arr, int dato) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int mitad = inicio + (fin - inicio) / 2;

            if (arr[mitad] == dato) {
                return mitad;
            } else if (arr[mitad] < dato) {
                inicio = mitad + 1;
            } else {
                fin = mitad - 1;
            }
        }
        return -1;
    }

    public static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void escribirArchivo(int[] arr, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int num : arr) {
                bw.write(num + "");
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("error al escribir el archivo: " + e.getMessage());
        }
    }
}
