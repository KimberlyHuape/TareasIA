package PUZZLE;

public class Nodo {
		private String nombre;
	    private Nodo izquierdo, derecho;

	    public Nodo(String nombre) {
	        this.nombre = nombre;
	        izquierdo = null;
	        derecho = null;
	    }
		
	    public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Nodo getIzquierdo() {
			return izquierdo;
		}

		public void setIzquierdo(Nodo izquierdo) {
			this.izquierdo = izquierdo;
		}

		public Nodo getDerecho() {
			return derecho;
		}

		public void setDerecho(Nodo derecho) {
			this.derecho = derecho;
		}
		
		
		@Override
		public String toString() {
			return "[ Nodo "+ nombre +" ]";
		}
		
	}
