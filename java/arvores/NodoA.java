package arvores;

/**
 * @author Manchelsin
 * Árvore baseada em lista ligada.
 * @param <E>
 */
public class NodoA<E> {
	private NodoA<E> esquerdo = null;
	private NodoA<E> direito = null;
	private NodoA<E> pai = null;
	private Integer chave = null;

	public NodoA(NodoA<E> esquerdo, NodoA<E> direito, NodoA<E> pai, Integer chave) {
		this.esquerdo = esquerdo;
		this.direito = direito;
		this.pai = pai;
		this.chave = chave;
	}

	/**
	 * @return the esquerdo
	 */
	public NodoA<E> getEsquerdo() {
		return esquerdo;
	}

	/**
	 * @param esquerdo the esquerdo to set
	 */
	public void setEsquerdo(NodoA<E> esquerdo) {
		this.esquerdo = esquerdo;
	}

	/**
	 * @return the direito
	 */
	public NodoA<E> getDireito() {
		return direito;
	}

	/**
	 * @param direito the direito to set
	 */
	public void setDireito(NodoA<E> direito) {
		this.direito = direito;
	}

	/**
	 * @return the pai
	 */
	public NodoA<E> getPai() {
		return pai;
	}

	/**
	 * @param pai the pai to set
	 */
	public void setPai(NodoA<E> pai) {
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