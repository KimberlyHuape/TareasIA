package PUZZLE;

public class ARBOL {
	
		    public static void main(String[] args) {
		    	
		        Arboli a = new Arboli();

		        System.out.println(a.vacio()? "Arbol vacio" : "Arbol no vacio" );
		        
		        a.insertar("1");
		        a.insertar("2");
		        a.insertar("3");
		        a.insertar("4");
		        System.out.println("Se insertaron los datos");
		        
		        System.out.print("Se encontro el ");
		        System.out.println(a.buscarNodo("4"));
		        
		        System.out.println("Arbol:");
		        a.imprimirArbol();
		        
		    }
		    
		}


