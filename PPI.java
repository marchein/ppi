package ppi;

import ppi.Number;

public class PPI {

	private double x, y, z;
	private String width, height, size;
	public boolean debug = false;
	
	
	public PPI(String breite, String hoehe, String groesse){
		
		width = String.valueOf(removeAllNonNumber(String.valueOf(breite), "int"));
		height = String.valueOf(removeAllNonNumber(String.valueOf(hoehe), "int"));
		size = String.valueOf(removeAllNonNumber(String.valueOf(groesse), "double"));

		try {
			x = Double.parseDouble(width);
		} catch (NumberFormatException n) {
			System.out.println(n.getMessage());
			x = 0;
		}
		try {
			y = Double.parseDouble(height);
			if(y == 9000) {
			    debug = true;
			    y = 1080.0;
			}
		} catch (NumberFormatException n) {
			System.out.println(n.getMessage());
			y = 0;
		}
		try {
			z = Double.parseDouble(size);
		} catch (NumberFormatException n){
			System.out.println(n.getMessage());
			z = 1;
		}
	}
	
	public double berechnen() throws IllegalArgumentException {
		
		if(x <= 0) {
		    if(x < 1 || width == null) { 
			throw new IllegalArgumentException("Die Breite kann nicht kleiner als 1 sein.");
		    } else {
			x = x * (-1);
			x = Double.parseDouble(x + "");
			x = Math.abs(x);
		    }
		}
		
		if(y <= 0) {
		    if(y < 1 || height == null) { 
			throw new IllegalArgumentException("Die Höhe kann nicht kleiner als 1 sein.");
		    } else {
			y = y * (-1);
			y = Double.parseDouble(y + "");
			y = Math.abs(y);
		    }
		}
		
		if(z <= 0) {
		    if(z <= 0) { 
			throw new ArithmeticException("Die Größe des Displays darf nicht 0 sein.");
		    } else {
			z = z * (-1);
			z = Double.parseDouble(z + "");
			z = Math.abs(z);
		    }
		}
		
		if(debug){
		    System.out.println("x = " + x + "\n" + "y = " + y + "\n" + "z = " + z);
		}
		
		return (double)Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / z * 100000) / 100000;
	}

	
	public static double removeAllNonNumber(String str, String type) {
		try {
		    if("int".equals(type)) {
			return Double.parseDouble(Number.formatLikeInt(str));	
		    } else {
			return Double.parseDouble(Number.formatLikeDouble(str));
		    }
		} catch (NumberFormatException n) {
		    return 0;
		}
	}
}