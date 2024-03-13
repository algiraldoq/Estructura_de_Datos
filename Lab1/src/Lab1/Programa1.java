package Lab1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Programa1 {
	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
		List<Integer> listanumeros = new ArrayList<Integer>();
		
		System.out.println("Ingrese Cantidad de numeros:");
		String contador = myobj.nextLine();
		Integer cont = Integer.valueOf(contador);
		
		for (Integer iterator = 0; iterator < cont; iterator++) {
			System.out.println("Ingrese numero:");
			String numero2 = myobj.nextLine();
			Integer num2 = Integer.valueOf(numero2);
			
			listanumeros.add(num2);
		}
		myobj.close();
		System.out.println("Numero maximo:" + listanumeros.stream().max(Comparator.naturalOrder()).get());
		System.out.println("Numero minimo:" + listanumeros.stream().min(Comparator.naturalOrder()).get());
		System.out.println("Suma:" + listanumeros.stream().reduce(0, Integer::sum));
		System.out.println("Promedio:" + listanumeros.stream().reduce(0, Integer::sum)/cont);
	}
}
