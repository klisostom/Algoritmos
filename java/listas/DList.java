package listas;

/**
 * @author suporte04
 *
 * @param <E>
 * Segundo o Cormen
 */
public class DList<E> {
	private DNodo<E> cabeca;
	private DNodo<E> calda;
	
	public DList() {
		this.cabeca = new DNodo<E>(null, null, null);
		this.calda = new DNodo<E>(null, cabeca, null);
		cabeca.setSucessor(calda);
	}
	
	public DNodo<E> pesquisar(DList<E> lista, E chave){
		DNodo<E> x = lista.primeiro();
		
		while ( (x != calda) && (x.getchave() != chave) ) {
			x = x.getSucessor();
		}
		
		return x;
	}
	
	/** Retorna o primeiro nodo */
	public DNodo<E> primeiro(){
		return cabeca.getSucessor();
	}
	
	/** Retorna o último nodo */
	public DNodo<E> ultimo(){
		return calda.getAntecessor();
	}
	
	/** Adiciona um nodo no início da lista */
	public void adicionar(DList<E> L, DNodo<E> x) {
		x.setSucessor(L.primeiro());
		x.setAntecessor(cabeca);
		L.cabeca.getSucessor().setAntecessor(x);
		L.cabeca.setSucessor(x);
		//x.setAntecessor(null);
	}

	public void delete(DList<E> L, DNodo<E> x) {
		x.getAntecessor().setSucessor(x.getSucessor());
		x.getSucessor().setAntecessor(x.getAntecessor());
	}
	
	public void print(DList<E> L) {
		DNodo<E> x = L.primeiro();
		
		while (x != calda) {
			System.out.print("[" + x.getchave() + "] ");
			x = x.getSucessor();
		}
	}
}
