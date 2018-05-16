package heaps;

import errors.HeapChaveNovaMenor;
import errors.HeapUnderFlow;
import errors.IndexOut;

public class Main {

	public static void main(String[] args) throws HeapChaveNovaMenor {
		
		/*Integer[] A = {15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
		Arranjo arr = new Arranjo(A);
		MaxPriorityQueue mpq = new MaxPriorityQueue();
		
		
		System.out.print("0: "+ "tamanho: " + arr.getTamanho_do_heap() + " - ");
		arr.print();
		System.out.println("nenhum insert ainda");
		
		
		//mpq.increaseKey(arr, 0, 16);
		mpq.insert(arr, 50);
		System.out.print("\n1: " + "tamanho: " + arr.getTamanho_do_heap() + " - ");
		arr.print();
		
		mpq.insert(arr, 54);
		System.out.print("\n2: "+ "tamanho: " + arr.getTamanho_do_heap()+ " - ");
		arr.print();
		
		mpq.insert(arr, 58);
		System.out.print("\n3: "+ "tamanho: " + arr.getTamanho_do_heap()+ " - ");
		arr.print();*/
		//====================
		//int[] A = {27,17,3,16,13,10,1,5,7,12,4,8,9,0};
		
		int[] A = {15,13,9,5,12,8,7,4,0,6,2,1};

		Arranjo arr = new Arranjo(A);
		MaxHeap max = new MaxHeap();
		
		arr.print();
		//max.buildMaxHeap(arr);
		MaxPriorityQueue mpq = new MaxPriorityQueue();
		try {
			mpq.insert(arr, 10);
			//mpq.extractMax(arr);
		} catch (IndexOut e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		arr.print();
		
		
	}

}
