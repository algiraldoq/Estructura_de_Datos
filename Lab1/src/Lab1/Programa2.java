package Lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Programa2 {
	public static void main(String[] args) {
		File archivo = new File("/home/artifex/Documents/Universidad/test_pr2.txt");
		String palabraABuscar = "en";
        int contador = 0;
        try {
            // Crear un objeto FileReader para leer el archivo
            FileReader fr = new FileReader(archivo);
            // Crear un objeto BufferedReader para leer líneas de texto eficientemente
            BufferedReader br = new BufferedReader(fr);
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    // Eliminar cualquier signo de puntuación adjunto a la palabra
                    palabra = palabra.replaceAll("[^a-zA-Z]", "");
                    // Comparar la palabra con la palabra buscada (ignorando mayúsculas y minúsculas)
                    if (palabra.equalsIgnoreCase(palabraABuscar)) {
                        contador++;
                    }
                }
            }
            br.close();
            System.out.println("La palabra '" + palabraABuscar + "' se repite " + contador + " veces.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
