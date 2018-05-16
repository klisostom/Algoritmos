package listas;

public class DNodo<E> {
	private DNodo<E> sucessor;
	private DNodo<E> antecessor;
	private E chave;
	
	public DNodo(E chave, DNodo<E> antecessor, DNodo<E> sucessor ) {
		this.sucessor = sucessor;
		this.antecessor = antecessor;
		this.chave = chave;
	}

	public DNodo<E> getSucessor() {
		return sucessor;
	}

	public void setSucessor(DNodo<E> sucessor) {
		this.sucessor = sucessor;
	}

	public DNodo<E> getAntecessor() {
		return antecessor;
	}

	public void setAntecessor(DNodo<E> antecessor) {
		this.antecessor = antecessor;
	}

	public E getchave() {
		return chave;
	}

	public void setchave(E chave) {
		this.chave = chave;
	}
	
	
}
