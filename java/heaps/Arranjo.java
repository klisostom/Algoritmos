package heaps;

import errors.IndexOut;

/**
 * Objeto arranjo que representa um heap.
 * @author Manchelsin
 */
public class Arranjo {
	/**
	 * Embora A[1 .. A.comprimento] possa conter números, só os elementos em A[A.tamanho_do_heap], 
	 * onde A.tamanho_do_heap <= A.comprimento, são elementos válidos do heap.
	 * A raiz da árvore é A[1].
	 */
	private int tamanho_do_heap = 0;	// Representa quantos elementos no heap estão armazenados dentro do arranjo.
	private int comprimento = 0;	// Dá o número de elementos no arranjo.
	private int[] A;
	
	public Arranjo(int[] A) {
		this.A = A;
		comprimento = A.length;
		
		for(int i = 0; i < comprimento; i++) {
			if(A[i] != 0) {
				tamanho_do_heap++;
			} 
		}

	}
	
	/*public Arranjo(int x) {
		A = new int[x];
		comprimento = x;
		
		for(int i = 0; i < comprimento; i++) {
			if(A[i] != null) {
				tamanho_do_heap++;
			} 
		}
	}*/

	protected void checarIndice(Arranjo A, int i) throws IndexOut {
		if (i < 0 || i > (A.getComprimento() - 1)) {
			throw new IndexOut("Indice fora do intervalo do array: "+i);
		}
	}
	
	public void print() {
		for (int i = 0; i < this.getComprimento(); i++) {
			System.out.print(A[i] + " ");
		}
	}

	public void dobrarArray() {
		int[] temp = this.A.clone();
		this.A = null;
		int[] A2 = new int[(temp.length * 2)];
		
		for (int i = 0; i < A2.length; i++) {
			A2[i] = (int)Double.POSITIVE_INFINITY;
		}
		
		for (int i = 0; i < temp.length; i++) {
			A2[i] = temp[i];
		}
		
		this.A = A2.clone();
		A2 = null;
		this.setComprimento(this.A.length);
		
	}
	
	public int parent(int i) {
		return ((i - 1) / 2);
		//return x;
		//return i>>1;
	}

	public int left(int i) {
		return 2 * i + 1;
		//return i<<1;
	}

	public int right(int i) {
		return 2 * i + 2;
		//return i<<1|1;
	}
	
	/*==== gets e sets ====*/
	public int getTamanho_do_heap() {
		return tamanho_do_heap;
	}

	public void setTamanho_do_heap(int x) {
		tamanho_do_heap = x;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int x) {
		comprimento = x;
	}

	public int[] getA() {
		return this.A;
	}
}