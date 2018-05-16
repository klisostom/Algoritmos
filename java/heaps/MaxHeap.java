package heaps;

public class MaxHeap {
	
	public MaxHeap() {
		super();
	}

	/* Por ser recursivo, o Cormen falou no livro que pode dar problema em alguns compiladores. */
	public void maxHeapify(Arranjo A, int i) {
		int L = A.left(i);
		int R = A.right(i);
		int maior = i;
			
		if(L < A.getTamanho_do_heap() && A.getA()[L] > A.getA()[i]){
			maior = L;
		} 
		
		if(R < A.getTamanho_do_heap() && A.getA()[R] > A.getA()[maior]) {
			maior = R;
		}
		
		if(maior != i) {
			int aux = A.getA()[i];
			A.getA()[i] = A.getA()[maior];
			A.getA()[maior] = aux;
			maxHeapify(A, maior);
		}
	}
	
	/* maxHeapify iterativo. */
	public void maxHeapify_2(Arranjo A, int i) {
		int maior = i;
		int L = A.left(i);
		int R = A.right(i);
		
		//System.out.println("\nTamanho_do_heap :" + A.getTamanho_do_heap());
		
		if(L < A.getTamanho_do_heap() && A.getA()[L] > A.getA()[i]){
			maior = L;
		} else {
			maior = i;
		}
		
		if(R < A.getTamanho_do_heap() && A.getA()[R] > A.getA()[maior]) {
			maior = R;
		}
		
		if(maior != i) {
			int aux = A.getA()[i];
			A.getA()[i] = A.getA()[maior];
			A.getA()[maior] = aux;
		}
		
		i = maior;
	}
	
	public void buildMaxHeap(Arranjo A) {
		A.setTamanho_do_heap(A.getComprimento());

		for(int i = A.getComprimento() / 2; i >= 0; i--) {
			//System.out.println(i);
			maxHeapify(A, i);	
		}
	}
	
	public void heapsort(Arranjo A) {
		buildMaxHeap(A);
		int aux = 0;
		
		for(int i = A.getComprimento(); i > 0 ; i--) {
			aux = A.getA()[1];
			A.getA()[1] = A.getA()[i];
			A.getA()[i] = aux;
			A.setTamanho_do_heap(A.getTamanho_do_heap() - 1);
			maxHeapify(A, 1);
		}
	}
	
}
