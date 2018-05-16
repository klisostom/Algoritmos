package heaps;

import errors.HeapChaveNovaMenor;
import errors.HeapUnderFlow;
import errors.IndexOut;

public class MaxPriorityQueue {
	private MaxHeap MH;
	
	public MaxPriorityQueue() {
		MH = new MaxHeap();
	}
	
	public void increaseKey(Arranjo A, int i, int chave) throws HeapChaveNovaMenor, IndexOut {
		//i = (i - 1);
		A.checarIndice(A, i);
		
		if(chave < A.getA()[i]) {
			throw new HeapChaveNovaMenor("Nova chave é menor do que a chave atual.");
		}
		
		A.getA()[i] = chave;
				
		while(i > 0 && A.getA()[A.parent(i)] < A.getA()[i]) {	// A[PARENT(I)] < A[I]
			int temp = A.getA()[i];
			A.getA()[i] = A.getA()[A.parent(i)];
			A.getA()[A.parent(i)] = temp;
			
			i = A.parent(i);
		}
		
	}
	
	public void insert(Arranjo A, int chave) throws IndexOut {
		int i = A.getTamanho_do_heap();
		int j = A.getComprimento();
		
		if(i == j) {
			A.dobrarArray();
		}
			
		if (i < j) {
			A.getA()[i] = (int) Double.NEGATIVE_INFINITY;
			A.setTamanho_do_heap(i + 1);	// tamanho_do_heap++
		} else {
			A.checarIndice(A, i);	// Se chegar aqui certamente lancará a exceção 'IndexOut'
		}
		
							
		try {
			increaseKey(A, i, chave);
		} catch (HeapChaveNovaMenor e) {
			e.printStackTrace();
		} catch (IndexOut e) {
			e.printStackTrace();
		}
		
	}
	
	public int maximum(Arranjo A) {
		return A.getA()[0];
	}
	
	public int extractMax(Arranjo A) throws HeapUnderFlow {
		int t = A.getTamanho_do_heap();
		
		if(t < 0) {
			throw new HeapUnderFlow("Heap underflow - Tentando acessar elementos de uma coleção vazia.");
		}
		
		int maior = A.getA()[0];
		A.getA()[0] = A.getA()[t - 1];

		A.setTamanho_do_heap( (t - 1) );
		MH.maxHeapify(A, 0);
		
		return maior;
	}
	
	
}













