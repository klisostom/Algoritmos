
package grafos;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {

        // TODO Auto-generated method stub
        GrafoSimples G=new GrafoSimples();
        
        System.out.println("inserindo");
        Vertices v1=new Vertices(1,0);
        Vertices v2=new Vertices(2,0);
        Vertices v3=new Vertices(3,0);
        G.inserirVertice(v1);
        G.inserirVertice(v2);
        G.inserirVertice(v3);
        
        G.insereAresta(v1,v1,11);               
        G.insereAresta(v1,v2,12);
        G.insereAresta(v1,v3,13);
        
        G.insereAresta(v2, v1, 21);        
        G.insereAresta(v2, v2, 22);
        G.insereAresta(v2, v3, 23);
        
        System.out.println("GRAU:"+G.grau(v3));
        
        G.insereAresta(v3, v1, 31);        
        G.insereAresta(v3, v2, 32);
        Arestas a3=G.insereAresta(v3, v3, 33);     
        
        System.out.println("GRAU:"+G.grau(v1));
        mostra(G);
        
        System.out.println("removendo");
        G.removerVertice(v1);
        mostra(G);
        G.removerVertice(v2);
        mostra(G);
        
        System.out.println("VERTICES:");
        
        Vector x;
        x=G.vertices();
        for(int f=0;f<x.size();f++)
           System.out.println(x.get(f));
        
        
        System.out.println("ARESTAS:");
        
        x=G.arestas();
        for(int f=0;f<x.size();f++)
           System.out.println(x.get(f));
        
        
        System.out.println("arestasIncidentes:");        
        x=G.arestasIncidentes(v3);
        for(int f=0;f<x.size();f++)
           System.out.println(x.get(f));
        
        System.out.println("finalVertices:");        
        x=G.finalVertices(a3);
        for(int f=0;f<x.size();f++)
           System.out.println(x.get(f));
        
        System.out.println("oposto:");        
        
        try{
          System.out.println(G.oposto(v3,a3));
        }catch(Exception e){
          System.out.println(e.getMessage());
        }
        
        System.out.println("É Adjacente?"); 
        System.out.println(G.isAdjacente(v3,v3));
                
    }
    
    public static void mostra(GrafoSimples G){
        System.out.println("Ordem:"+G.ordem());
        System.out.println("Vertices:");
        G.mostraVertices(); 
		System.out.println();  
		G.mostraMatriz();        
    
    }
}
