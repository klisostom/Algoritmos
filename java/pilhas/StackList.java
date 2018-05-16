package pilhas;

import errors.StackUnderFlow;
import listas.Nodo;

public class StackList<E> {
	private Nodo<E> cabeca;
	private int size = -1;
	
	public StackList() {
		cabeca = new Nodo<E>(null, null);
		size = 0;
	}
	
	public boolean stackEmpty(StackList<E> S) {
		return (S.topo() == null);
	}
	
	public void push(StackList<E> S, E x) {
		Nodo<E> novo = new Nodo<E>(S.topo(), x);
		cabeca.setSucessor(novo);
		size++;
	}
	
	public E pop(StackList<E> S) throws StackUnderFlow {
		if(S.stackEmpty(S)) throw new StackUnderFlow("Underflow - A pilha está vazia!");
		
		Nodo<E> nodo = S.topo();
		S.cabeca.setSucessor(nodo.getSucessor());
		nodo.setSucessor(null);
		size--;
		return nodo.getChave();
	}
	
	private Nodo<E> topo() {
		return cabeca.getSucessor();
	}
	
	/* Para fazer debug */
	public int getSize() {
		return size;
	}
	
	public void chaveTopo() {
		System.out.println(this.topo().getChave());
	}
	
	public void print(StackList<E> S) {
		Nodo<E> nodo = S.topo();
		
		while (nodo != null) {
			System.out.print("[" + nodo.getChave() + "] ");
			nodo = nodo.getSucessor();
		}
		System.out.println();
	}
	/* Fim Debug */
}
