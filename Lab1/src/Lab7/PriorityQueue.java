package Lab7;

public class PriorityQueue extends Heap {

	public PriorityQueue(Integer tamañoArreglo) {
		super(tamañoArreglo);
	}

	public void MaxHeapInsert(Object k) {
		Integer i = size;
		A[i] = k;
		size++;
		while (i > 0 && Parent(i) < (int) A[i]) {
			int parentIndex = Parent(i);
			if (parentIndex >= 0 && (int) A[parentIndex] < (int) A[i]) {
				Object temp = A[Parent(i)];
				A[Parent(i)] = A[i];
				A[i] = temp;
				i = Parent(i);
			} else {
				break;
			}
		}
	}

	public Object HeapExtractMax() {
		Object max = A[0];
		A[0] = A[size - 1];
		size--;
		MaxHeapify(0, size);
		return max;
	}

	public Object HeapMaximum() {
		return A[0];
	}
}
