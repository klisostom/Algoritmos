package ordenacao;

public class Counting {

	public Counting() {
		// TODO Auto-generated constructor stub
	}
	
	public void countingSort(int[]A, int[]B, int k) {
		int[] C = new int[k];
		
		for (int i = 0; i < A.length; i++) {
			C[A[i]] = C[A[i]] + 1;
		}
		
		for (int i = 0; i < k; i++) {
			C[i] = C[i] + C[i - 1];
		}
		
		for (int i = A.length - 1; i >= 0; i--) {
			B[C[A[i]]] = A[i];
			C[A[i]] = C[A[i]] - 1;
		}
	}

	public static void main(String[] args) {
		int[] A = {2,5,3,0,2,3,0,3};
		int[] B = new int[A.length];
		
		Counting ct = new Counting();
		ct.countingSort(A,B,5);
		for (int i : B) {
			System.out.print(i+" ");
		}
	}

}
