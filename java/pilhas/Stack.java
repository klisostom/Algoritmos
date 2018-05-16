package pilhas;

import errors.StackOverﬂows;
import errors.StackUnderFlow;

/**
 * Pilha utilizando um array.
 * @author Manchelsin
 * @param <E>
 */
public class Stack {
	private int topo;
	private int pilha[];
	
	public Stack(int tamanhoPilha) {
		topo = -1;
		pilha = new int[tamanhoPilha];
		
	}
	
	public boolean stackEmpty(Stack S) {
		if(S.topo < 0) return true;
		else return false;
	}
	
	public void push(Stack S, int x) throws StackOverﬂows {
		int n = pilha.length;
		if(S.topo == (n - 1)) throw new StackOverﬂows("Overflow - A pilha está cheia!");
		S.topo = S.topo + 1;
		pilha[S.topo] = x;
	}
	
	public int pop(Stack S) throws StackUnderFlow {
		if(stackEmpty(S)) {
			throw new StackUnderFlow("Underflow - A pilha está vazia!");
		} else {
			S.topo = S.topo - 1;
		}
		return pilha[S.topo + 1];
	}
}