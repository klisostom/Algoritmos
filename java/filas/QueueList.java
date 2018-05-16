package filas;

import errors.QueueUnderFlow;
import listas.Nodo;

public class QueueList<E> {
	private Nodo<E> cabeca;
	private Nodo<E> calda;
	
	public QueueList() {
		cabeca = new Nodo<E>(null, null);
		calda = new Nodo<E>(null, null);
		cabeca.setSucessor(calda);
		//calda.setSucessor(cabeca);// Apenas se a lista for circular é que a calda aponta o seu sucessor para a cabeça
	}
	
	public boolean queueEmpty(QueueList<E> Q) {
		return Q.cabeca.getSucessor() == Q.calda;
	}
	
	public void enqueue(QueueList<E> Q, E x) {
		Nodo<E> novo = new Nodo<E>(calda, x);
		cabeca.setSucessor(novo);
	}
	
	public E dequeue(QueueList<E> Q) throws QueueUnderFlow {
		if(Q.queueEmpty(Q)) throw new QueueUnderFlow("Underflow - Ffila vazia!");
		
		return null;
	}
}
