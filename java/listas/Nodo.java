package listas;

public class Nodo<E> {
	private Nodo<E> sucessor;
	private E chave;
	
	public Nodo(Nodo<E> sucessor, E chave) {
		this.sucessor = sucessor;
		this.chave = chave;
	}
	
	/**
	 * @return the sucessor
	 */
	public Nodo<E> getSucessor() {
		return sucessor;
	}
	/**
	 * @param sucessor the sucessor to set
	 */
	public void setSucessor(Nodo<E> sucessor) {
		this.sucessor = sucessor;
	}
	/**
	 * @return the chave
	 */
	public E getChave() {
		return chave;
	}
	/**
	 * @param chave the chave to set
	 */
	public void setChave(E chave) {
		this.chave = chave;
	}
	
	
}
