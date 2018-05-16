package grafos;

public class Arestas {
	private Vertices verticeOrigem;
    private Vertices verticeDestino;
    private double valor;
    private boolean direcionada;

    public Arestas(Vertices verticeOrigem, Vertices verticeDestino, double valor, boolean direcionada) {
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.valor = valor;
		this.direcionada = direcionada;
	}

	public Arestas(Vertices verticeOrigem, Vertices verticeDestino) {
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
	}
	
	public Arestas(Vertices verticeOrigem, Vertices verticeDestino, double valor) {
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.valor = valor;
	}
	
	public Vertices getVerticeOrigem() {
		return verticeOrigem;
	}
	public void setVerticeOrigem(Vertices verticeOrigem) {
		this.verticeOrigem = verticeOrigem;
	}
	public Vertices getVerticeDestino() {
		return verticeDestino;
	}
	public void setVerticeDestino(Vertices verticeDestino) {
		this.verticeDestino = verticeDestino;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isDirecionada() {
		return direcionada;
	}
	public void setDirecionada(boolean direcionada) {
		this.direcionada = direcionada;
	}
    
    
}
