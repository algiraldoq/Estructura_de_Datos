package Lab7;

import java.util.Random;

public class PruebaLab7 {

	public static void main(String[] args) {
		// Generar un arreglo de enteros aleatorios con 20 elementos
		int[] arreglo = new int[20];
		Random random = new Random();
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = random.nextInt(100);
		}

		// Crear un objeto PriorityQueue y agregar los elementos del arreglo
		PriorityQueue priorityQueue = new PriorityQueue(arreglo.length);
		for (int i = 0; i < arreglo.length; i++) {
			priorityQueue.MaxHeapInsert(arreglo[i]);
		}

		// Imprimir el contenido de la PriorityQueue
		System.out.println("Contenido de la PriorityQueue:");
		for (int i = 0; i < priorityQueue.size; i++) {
			System.out.print(priorityQueue.A[i] + " ");
		}
		System.out.println();

		System.out.println("BuildBuildMaxHeap:");
		priorityQueue.BuildMaxHeap();
		for (int i = 0; i < priorityQueue.size; i++) {
			System.out.print(priorityQueue.A[i] + " ");
		}
		System.out.println();

		System.out.println("HeapSort:");
		priorityQueue.HeapSort();
		for (int i = 0; i < priorityQueue.size; i++) {
			System.out.print(priorityQueue.A[i] + " ");
		}
		System.out.println();

		// Probar la funcionalidad de HeapExtractMax en la PriorityQueue
		System.out.println("HeapExtractMax en PriorityQueue:");
		int max3 = (int) priorityQueue.HeapExtractMax();
		System.out.println("Elemento máximo extraído: " + max3);
		System.out.println("Contenido de la PriorityQueue después de extraer el máximo:");
		for (int i = 0; i < priorityQueue.size; i++) {
			System.out.print(priorityQueue.A[i] + " ");
		}
		System.out.println();

		// Probar la funcionalidad de HeapMaximum
		System.out.println("HeapMaximum:");
		int max2 = (int) priorityQueue.HeapMaximum();
		System.out.println("Elemento máximo: " + max2);
	}
}
