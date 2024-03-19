package Logicadi;

import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.FIS;

public class logica{
	 public static void main(String[] args) {
	    	
		    
	    	String fileName = "C:/Users/Kimberly/eclipse-workspace/IA/src/fuzzy_logic.fcl";
	        try {
	            FIS fis = FIS.load(fileName, false);
	            if (fis == null) {
	                System.err.println("NO SE ENCONTRO EL ARCHIVO FCL: " + fileName);
	                return;
	            }

	        Scanner s = new Scanner(System.in);
	        System.out.println("INGRESE LOS DATOS DE LA CASA");
	        System.out.println("(ZONA, DETALLE, PRECIO)\n");
	        
	        System.out.print("ZONA (100 - 500) ");
	        int ZONA = s.nextInt();

	        System.out.print("DETALLE: (1 - 10) ");
	        int DETALLE = s.nextInt();

	        System.out.print("PRECIO: (100000 - 1000000) $: ");
	        double PRECIO = s.nextDouble();
	        s.close();
	        
	        fis.setVariable("ZONA", ZONA);
	        fis.setVariable("DETALLE", DETALLE);
	        fis.setVariable("PRECIO", PRECIO);
	        System.out.println();

	        fis.evaluate();

	        double CATEGORIA = fis.getVariable("CATEGORIA").getValue();
	        System.out.print("LA CATEGORIA DE LA CASA ES: ");
	        
	        if (CATEGORIA < 30) {
	            System.out.println("CASA CHICA");
	        } else if (CATEGORIA < 70) {
	            System.out.println("CASA MEDIA");
	        } else {
	            System.out.println("CASA LUJO");
	        }
	        
	    }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }}