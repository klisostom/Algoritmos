package arvores;

import errors.NodoIsNull;

public class ArvoreBinariaBusca<E> {
	private NodoA<E> raiz;
	private int qtd;

	public ArvoreBinariaBusca() {
		raiz = null;
		qtd = 0;
	}
	
	private NodoA<E> checkNode(NodoA<E> x) throws NodoIsNull {
		if(x == null) throw new NodoIsNull("O nodo fornecido é nulo.");
		return x;
	}
	
	/**
	 * Visita a subárvore a esquerda da raiz, em seguida visita a raiz e, por último, visita a subárvore direita.
	 * @param x
	 */
	public void inorderTreeWalk(NodoA<E> x) {
		if (x != null) {
			inorderTreeWalk(x.getEsquerdo());
			System.out.print("[" + x.getChave() + "] ");
			inorderTreeWalk(x.getDireito());
		}
	}
	
	/**
	 * @param x
	 * @param k
	 * @return nodo
	 */
	@SuppressWarnings("unused")
	private NodoA<E> treeSearch(NodoA<E> x, Integer k){
		
		if (x == null || k == x.getChave()) {
			return x;
		}
		
		if (k < x.getChave()) {
			return treeSearch(x.getEsquerdo(), k);
		}
		
		return treeSearch(x.getDireito(), k);
	}
	
	/**
	 * Pesquisa se uma dada chave recebida existe na árvore.
	 * @param i
	 */
	public void search(Integer i) {
		NodoA<E> w = iterativeTreeSearch(this.getRaiz(), i);
		if (w != null) {
			System.out.println("A chave " + w.getChave() + " existe na árvore!");
		} else {
			System.out.println("A chave informada não existe!");
		}
	}

	/**
	 * @param x
	 * @param k
	 * @return nodo
	 */
	private NodoA<E> iterativeTreeSearch(NodoA<E> x, Integer k){	// x deve ser um ponteiro para a raiz
		try {
			x = checkNode(x);
		} catch (NodoIsNull e) {
			e.printStackTrace();
		}
		
		while (x != null && k != x.getChave()) {
			if (k < x.getChave()) {
				x = x.getEsquerdo();
			} else {
				x = x.getDireito();
			}
		}
		return x;
	}
	
	/**
	 * @param x
	 * @return Nodo com a menor chave
	 */
	public NodoA<E> treeMinimum(NodoA<E> x) {
		
		while (x.getEsquerdo() != null ) {
			x = x.getEsquerdo();
		}
		return x;
	}
	
	/**
	 * @param x
	 * @return Nodo com a maior chave
	 */
	public NodoA<E> treeMaximum(NodoA<E> x) {
		while (x.getDireito() != null) {
			x = x.getDireito();
		}
		return x;
	}
	
	/**
	 * @param x
	 * @return o sucessor de um nodo
	 */
	public NodoA<E> treeSuccessor(NodoA<E> x){
		
		if (x.getDireito() != null) {
			return treeMinimum(x.getDireito());
		}
		
		NodoA<E> y = x.getPai();
		
		while (y != null && x == y.getDireito()) {
			x = y;
			y = y.getPai();
		}
		
		return y;
	}
	
	public NodoA<E> treePredecessor(NodoA<E> x){
		
		if (x.getEsquerdo() != null) {
			return treeMaximum(x.getEsquerdo());
		}
		
		NodoA<E> y = x.getPai();
		
		while (y != null && x == y.getEsquerdo()) {
			x = y;
			y = y.getPai();
		}
		
		return y;
	}
	
	/**
	 * @param T
	 * @param z
	 */
	public void treeInsert(ArvoreBinariaBusca<E> T, NodoA<E> z) {
		NodoA<E> y = null;
		NodoA<E> x = T.raiz;
		
		while (x != null) {
			y = x;
			if (z.getChave() < x.getChave()) {
				x = x.getEsquerdo();
			} else {
				x = x.getDireito();
			}
		}
		
		z.setPai(y);
		
		if (y == null) {
			T.setRaiz(z); //System.out.println(T.getRaiz().getEsquerdo());
		} else if(z.getChave() < y.getChave()){
			y.setEsquerdo(z);
		} else {
			y.setDireito(z);
		}
	}
	
	/**
	 * @param T
	 * @param u
	 * @param v
	 */
	private void transplant(ArvoreBinariaBusca<E> T, NodoA<E> u, NodoA<E> v) {
		if (u.getPai() == null) {
			T.setRaiz(v);
		} else if(u == u.getPai().getEsquerdo()) {
			u.getPai().setEsquerdo(v);
		} else {
			u.getPai().setDireito(v);
		}
		
		if (v != null) {
			v.setPai(u.getPai());
		}
	}
	
	/**
	 * @param T
	 * @param z
	 */
	public void treeDelete(ArvoreBinariaBusca<E> T, NodoA<E> z) {
		if (z.getEsquerdo() == null) {
			transplant(T, z, z.getDireito());
		} else if(z.getDireito() == null) {
			transplant(T, z, z.getEsquerdo());
		} else {
			NodoA<E> y = treeMinimum(z.getDireito());
			if (y.getPai() != z) {
				transplant(T, y, y.getDireito());
				y.setDireito(z.getDireito());
				y.getDireito().setPai(y);
			}
			
			transplant(T, z, y);
			y.setEsquerdo(z.getEsquerdo());
			y.getEsquerdo().setPai(y);
		}
		
	}
	
	/* === GETs e SETs === */
	/**
	 * @return the raiz
	 */
	public NodoA<E> getRaiz() {
		return raiz;
	}

	/**
	 * @param raiz the raiz to set
	 */
	public void setRaiz(NodoA<E> raiz) {
		this.raiz = raiz;
	}

	/**
	 * @return the qtd
	 */
	public int getQtd() {
		return qtd;
	}

}
