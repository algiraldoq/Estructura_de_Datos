package Lab7;

public class Heap {

	public Object[] A;
	public Integer size = 0;

	public Heap(Integer tamañoArreglo) {
		super();
		A = new Object[tamañoArreglo];
	}

	public Integer Parent(Integer i) {
		return (i / 2) - 1;
	}

	public Integer Left(Integer i) {
		return 2 * i + 1;
	}

	public Integer Right(Integer i) {
		return 2 * i + 2;
	}

	public void MaxHeapify(Integer i, Integer heapSize) {
		Integer largest;
		Integer l = Left(i);
		Integer r = Right(i);

		if (l <= heapSize - 1 && (int) A[l] > (int) A[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= heapSize - 1 && (int) A[r] > (int) A[largest]) {
			largest = r;
		}
		if (largest != i) {
			Object temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			MaxHeapify(largest, heapSize);
		}
	}

	public void BuildMaxHeap() {
		for (int i = A.length / 2 - 1; i >= 0; i--) {
			MaxHeapify(i, size);
		}
	}

	public void HeapSort() {
		BuildMaxHeap();
		Integer heapSize = A.length;
		for (int i = A.length - 1; i >= 1; i--) {
			Object temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			heapSize--;
			MaxHeapify(0, heapSize);
		}
	}
}
