package grafos;

import java.util.Vector;
import errors.OpostoError;

public class GrafoSimples {
	private int qtdVertices;
    private Vector<Vertices> vertices;
    private Arestas matrizAdj[][];
    
    public GrafoSimples() {
    	
    }
    
    public  void inserirVertice(Vertices Vertice) {
    	
    }

    public  void removerVertice(Vertices Vertice) {
    	
    }

    public  Arestas insereAresta(Vertices VerticeUm, Vertices VerticeDois, double valor) {
				
    	return null;
    }

    public  Arestas insereAresta(Vertices VerticeUm, Vertices VerticeDois) {
		return null;
    	
    }

    public  void removeAresta(Arestas Aresta) {
    	
    }

    public  Arestas insereArco(Vertices VerticeUm, Vertices VerticeDois,
            double valor) {
				return null;
    	
    }

    public  Arestas insereArco(Vertices VerticeUm, Vertices VerticeDois) {
		return null;
    	
    }

    public  void removeArco(Arestas Aresta) {
    	
    }

    public  int grau(Vertices Vertice) {
		return qtdVertices;
    	
    }

    public  int ordem() {
		return qtdVertices;
    	
    }

    public  Vector<Vertices> vertices() {
		return vertices;
    	
    }

    public  Vector<Vertices> arestas() {
		return vertices;
    	
    }

    public  Vector<Vertices> arestasIncidentes(Vertices vertice) {
		return vertices;
    	
    }

    public  Vector<Vertices> finalVertices(Arestas a) {
		return vertices;
    	
    }

    public  Vertices oposto(Vertices v, Arestas a) throws OpostoError{
		return v;
    	
    }

    public  boolean isAdjacente(Vertices v, Vertices w) {
		return false;
    	
    }

	public void mostraVertices() {

	}

	public void mostraMatriz() {
		// TODO Auto-generated method stub
		
	}
}
