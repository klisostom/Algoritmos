package filas;

import errors.QueueOverFlows;
import errors.QueueUnderFlow;

public class Queue {
	// Caso o objeto não seja instanciado, os valores serão estes
	private int fila[] = null;
	private int cabeca = -1;
	private int calda = -1;
	private int quantidade = -1;
	
	public Queue(int tamanhoFila) {
		super();
		fila = new int[tamanhoFila];
		cabeca = 0;
		calda = cabeca;
	}
	
	public void enqueue(Queue Q, int x) throws QueueOverFlows {
		if(Q.cabeca == Q.calda) {
			throw new QueueOverFlows("Overflows!");
		}
		fila[Q.calda] = x;
		
		if(Q.calda == fila.length) {
			Q.calda = 1;
		} else {
			Q.calda = Q.calda + 1;
		}
		
		quantidade++;
	}
	
	public int dequeue(Queue Q) throws QueueUnderFlow {
		if(queueEmpty(Q)) {
			throw new QueueUnderFlow("UnderFlows!");
		}
		
		int x = fila[Q.cabeca];
		
		if(Q.cabeca == fila.length) {
			Q.cabeca = 1;
		} else {
			Q.cabeca = Q.cabeca + 1;
		}
		
		quantidade--;
		return x;
	}
	
	public boolean queueEmpty(Queue Q) {
		return (quantidade == 0);
	}
}
