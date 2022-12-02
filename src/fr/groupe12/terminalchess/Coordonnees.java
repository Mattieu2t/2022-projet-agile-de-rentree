package fr.groupe12.terminalchess;

import java.util.List;

public class Coordonnees {
	private int X;
	private int Y;
	
	public Coordonnees(int x, int y) {
		this.X = x;
		this.Y = y;
	}	
	
	public Coordonnees(String coord) {
		this.X = (int) (coord.charAt(0) - 'A');
		this.Y = (int) (coord.charAt(1) - '1');
	}

	public String toString() {
		return "" + (char)(X+'A') + (Y+1) ;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}

	public boolean equals(Coordonnees coord) {
		if (this == coord)
			return true;
		if (coord == null)
			return false;
		if (X != coord.X)
			return false;
		if (Y != coord.Y)
			return false;
		return true;
	}

	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	public void setX(int x) {
		X = x;
	}
	
	public void setY(int y) {
		Y = y;
	}
	
	public static boolean contains(List<Coordonnees> coords, Coordonnees coord) {
		for(Coordonnees coo : coords) {
			if(coo.equals(coord)) {
				return true;
			}
		}
		return false;
	}
	
}
