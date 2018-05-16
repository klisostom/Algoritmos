package arvores;

public class ArvoreVermelhoPreto<E> {
	private NodoA_VP<E> raiz;
	private NodoA_VP<E> nil;
	
	public ArvoreVermelhoPreto() {
		nil = new NodoA_VP<E>('p', nil, nil, nil, null);
		raiz = nil;
	}

	public void leftRotate(ArvoreVermelhoPreto<E> T, NodoA_VP<E> x) {
		NodoA_VP<E> y = x.getDireito();
		x.setDireito(y.getEsquerdo());
		
		if (y.getEsquerdo() != T.nil) {
			y.getEsquerdo().setPai(x);
		}
		
		y.setPai(x.getPai());
		
		if (x.getPai() == T.nil) {
			T.raiz = y;
		} else if (x == x.getPai().getEsquerdo()) {
			x.getPai().setEsquerdo(y);
		} else {
			x.getPai().setDireito(y);
		}
		
		y.setEsquerdo(x);
		x.setPai(y);
	}
	
	public void rightRotate(ArvoreVermelhoPreto<E> T, NodoA_VP<E> y) {
		NodoA_VP<E> x = y.getEsquerdo();
		y.setEsquerdo(x.getDireito());
		
		if (x.getDireito() != T.nil) {
			x.getDireito().setPai(y);
		}
		
		x.setPai(y.getPai());
		
		if (y.getPai() == T.nil) {
			T.raiz = x;
		} else if (y == y.getPai().getDireito()) {
			y.getPai().setDireito(x);
		} else {
			y.getPai().setEsquerdo(x);
		}
		
		x.setDireito(y);
		y.setPai(x);
	}

	public void vpInsert(ArvoreVermelhoPreto<E> T, NodoA_VP<E> z) {
		NodoA_VP<E> y = T.nil;
		NodoA_VP<E> x = T.raiz;
		
		while (x != T.nil) {
			y = x;
			
			if (z.getChave() < x.getChave()) {
				x = x.getEsquerdo();
			} else {
				x = x.getDireito();
			}
		}
		
		z.setPai(y);
		
		if (y == T.nil) {
			T.raiz = z;
		} else if (z.getChave() < y.getChave()) {
			y.setEsquerdo(z);
		} else {
			y.setDireito(z);
		}
		
		z.setEsquerdo(T.nil);
		z.setDireito(T.nil);
		z.setColor('v');
		
		vpInsertFixup(T, z);
	}

	private void vpInsertFixup(ArvoreVermelhoPreto<E> T, NodoA_VP<E> z) {
		NodoA_VP<E> y;
		
		while (z.getPai().getColor() == 'v') {
			
			if (z.getPai() == z.getPai().getPai().getEsquerdo()) {
				y = z.getPai().getPai().getDireito();
				
				if (y.getColor() == 'v') {
					z.getPai().setColor('p');
					y.setColor('p');
					z.getPai().getPai().setColor('v');
					z = z.getPai().getPai();
				} else {
					
					if (z == z.getPai().getDireito()) {
						z = z.getPai();
						leftRotate(T, z);
					}
					
					z.getPai().setColor('p');
					z.getPai().getPai().setColor('v');
					rightRotate(T, z.getPai().getPai());
				}
					
			} else {
				y = z.getPai().getPai().getEsquerdo();
				
				if (y.getColor() == 'v') {
					z.getPai().setColor('p');
					y.setColor('p');
					z.getPai().getPai().setColor('v');
					z = z.getPai().getPai();
				} else {
					
					if (z == z.getPai().getEsquerdo()) {
						z = z.getPai();
						rightRotate(T, z);
					}
					
					z.getPai().setColor('p');
					z.getPai().getPai().setColor('v');
					leftRotate(T, z.getPai().getPai());
				}
			}
		}
		
		T.raiz.setColor('p');
	}

	public void vpTransplant(ArvoreVermelhoPreto<E> T, NodoA_VP<E> u, NodoA_VP<E> v) {

		if (u.getPai() == T.nil) {
			T.raiz = v;
		} else if (u == u.getPai().getEsquerdo()) {
			u.getPai().setEsquerdo(v);
		} else {
			u.getPai().setDireito(v);
		}
		
		v.setPai(u.getPai());
	}
	
	public NodoA_VP<E> vpMinimum(NodoA_VP<E> x) {
		
		while (x.getEsquerdo() != null ) {
			x = x.getEsquerdo();
		}
		return x;
	}

	public void vpDelete(ArvoreVermelhoPreto<E> T, NodoA_VP<E> z) {
		NodoA_VP<E> y = z;
		NodoA_VP<E> x;
		char y_original_color = y.getColor();
		
		if (z.getEsquerdo() == T.nil) {
			x = z.getDireito();
			vpTransplant(T, z, z.getDireito());
		} else if (z.getDireito() == T.nil) {
			x = z.getEsquerdo();
			vpTransplant(T, z, z.getEsquerdo());
		} else {
			y = vpMinimum(z.getDireito());
			y_original_color = y.getColor();
			x = y.getDireito();
			
			if (y.getPai() == z) {
				x.setPai(y);
			} else {
				vpTransplant(T, y, y.getDireito());
				y.setDireito(z.getDireito());
				y.getDireito().setPai(y);
			}
			
			vpTransplant(T, z, y);
			y.setEsquerdo(z.getEsquerdo());
			y.getEsquerdo().setPai(y);
			y.setColor(z.getColor());
		}
		
		if (y_original_color == 'p') {
			vpDeleteFixup(T, x);
		}
	}

	private void vpDeleteFixup(ArvoreVermelhoPreto<E> T, NodoA_VP<E> x) {
		NodoA_VP<E> w;
		
		while(x != T.raiz && x.getColor() == 'p') {
			
			if(x == x.getPai().getEsquerdo()) {
				w = x.getPai().getDireito();
				
				if(w.getColor() == 'v') {
					w.setColor('p');
					x.getPai().setColor('v');
					leftRotate(T, x.getPai());
					w = x.getPai().getDireito();
				}
				
				if(w.getEsquerdo().getColor() == 'p' && w.getDireito().getColor() == 'p') {
					w.setColor('v');
					x = x.getPai();
				} else {
					if(w.getDireito().getColor() == 'p') {
						w.getEsquerdo().setColor('p');
						w.setColor('v');
						rightRotate(T, w);
						w = x.getPai().getDireito();
					}
					
					w.setColor(x.getPai().getColor());
					x.getPai().setColor('p');
					w.getDireito().setColor('p');
					leftRotate(T, x.getPai());
					x = T.raiz;
				}
			} else {
				if(x == x.getPai().getDireito()) {
					w = x.getPai().getEsquerdo();
					
					if(w.getColor() == 'v') {
						w.setColor('p');
						x.getPai().setColor('v');
						rightRotate(T, x.getPai());
						w = x.getPai().getEsquerdo();
					}
					
					if(w.getDireito().getColor() == 'p' && w.getEsquerdo().getColor() == 'p') {
						w.setColor('v');
						x = x.getPai();
					} else {
						
						if(w.getEsquerdo().getColor() == 'p') {
							w.getDireito().setColor('p');
							w.setColor('v');
							leftRotate(T, w);
							w = x.getPai().getEsquerdo();
						}
						
						w.setColor(x.getPai().getColor());
						x.getPai().setColor('p');
						w.getEsquerdo().setColor('p');
						rightRotate(T, x.getPai());
						x = T.raiz;
					}
				}
			}
		}
		
		x.setColor('p');
	}
}