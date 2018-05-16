package arvores;

/**
 * @author Manchelsin
 * Nodo de uma árvore vermelho preto
 * @param <E>
 */
public class NodoA_VP<E> {
	private char color;
	private NodoA_VP<E> esquerdo;
	private NodoA_VP<E> direito;
	private NodoA_VP<E> pai;
	private Integer chave;

	public NodoA_VP(char color, NodoA_VP<E> esquerdo, NodoA_VP<E> direito, NodoA_VP<E> pai, Integer chave) {
		this.color = color;
		this.esquerdo = esquerdo;
		this.direito = direito;
		this.pai = pai;
		this.chave = chave;
	}

	/**
	 * @return the color
	 */
	public char getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(char color) {
		this.color = color;
	}

	/**
	 * @return the esquerdo
	 */
	public NodoA_VP<E> getEsquerdo() {
		return esquerdo;
	}

	/**
	 * @param esquerdo the esquerdo to set
	 */
	public void setEsquerdo(NodoA_VP<E> esquerdo) {
		this.esquerdo = esquerdo;
	}

	/**
	 * @return the direito
	 */
	public NodoA_VP<E> getDireito() {
		return direito;
	}

	/**
	 * @param direito the direito to set
	 */
	public void setDireito(NodoA_VP<E> direito) {
		this.direito = direito;
	}

	/**
	 * @return the pai
	 */
	public NodoA_VP<E> getPai() {
		return pai;
	}

	/**
	 * @param pai the pai to set
	 */
	public void setPai(NodoA_VP<E> pai) {
		this.pai = pai;
	}

	/**
	 * @return the chave
	 */
	public Integer getChave() {
		return chave;
	}

	/**
	 * @param chave the chave to set
	 */
	public void setChave(Integer chave) {
		this.chave = chave;
	}

}
