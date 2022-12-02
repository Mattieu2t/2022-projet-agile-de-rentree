package fr.groupe12.terminalchess;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import fr.groupe12.terminalchess.pieces.Cavalier;
import fr.groupe12.terminalchess.pieces.Fou;
import fr.groupe12.terminalchess.pieces.Pion;
import fr.groupe12.terminalchess.pieces.Reine;
import fr.groupe12.terminalchess.pieces.Roi;
import fr.groupe12.terminalchess.pieces.Tour;

public abstract class Piece {
	
	private Plateau plateau;
	private Coordonnees coords;
	private Color color;
	
	public Piece(Plateau plateau, Coordonnees coords, Color color) {
		this.plateau = plateau;
		this.coords = coords;
		this.color = color;
	}
	
	public Coordonnees getCoords() {
		return coords;
	}
	
	public Color getColor() {
		return color;
	}
	
	protected void filterMoves(List<Coordonnees> coords) {
		List<Coordonnees> temp = new ArrayList<Coordonnees>();
		for(Coordonnees coord : coords) {
			if(!canMove(coord)) temp.add(coord);
		}
		coords.removeAll(temp);
	}
	
	protected boolean canMove(Coordonnees coord) {
		boolean res = true;
		
		Coordonnees old = new Coordonnees(this.coords.getX(), this.coords.getY());
		this.bouger(coord);
		Color other = color == Color.WHITE ? Color.BLACK : Color.WHITE;
		List<Coordonnees> cases = plateau.allPossibleCases(other);
		if(Coordonnees.contains(cases, plateau.getKing(other).getCoords())) {
			this.bouger(old);
			res = false;
		}
		return res;
	}
	
	
	public void bouger(Coordonnees coord) {
		if (this.plateau.getPiece(coord) != null) {
			this.plateau.getPieces().remove(this.plateau.getPiece(coord));
		}
		this.coords.setX(coord.getX());
		this.coords.setY(coord.getY());
		
	}
	
	public boolean isInBoard(Coordonnees coord) {
		return coord.getX() >= 0 && coord.getX() < 8 && coord.getY() >=0 && coord.getY() < 8;
	}
	
	public abstract List<Coordonnees> getCoosPossible(boolean filter);
	
	public abstract EPiece getType();
	
	public Plateau getPlateau() {
		return plateau;
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		obj.put("x", coords.getX());
		obj.put("y", coords.getY());
		obj.put("color", color.name());
		obj.put("type", getType().name());
		return obj;
	}
	
	public static Object fromJSON(JSONObject obj, Plateau plateau) {
		Coordonnees coord = new Coordonnees(obj.getInt("x"), obj.getInt("y"));
		Color color = Color.valueOf(obj.getString("color"));
		EPiece type = EPiece.valueOf(obj.getString("type"));
		if(type == EPiece.CAVALIER) return new Cavalier(plateau, coord, color);
		if(type == EPiece.FOU) return new Fou(plateau, coord, color);
		if(type == EPiece.PION) return new Pion(plateau, coord, color);
		if(type == EPiece.REINE) return new Reine(plateau, coord, color);
		if(type == EPiece.ROI) return new Roi(plateau, coord, color);
		if(type == EPiece.TOUR) return new Tour(plateau, coord, color);
		return null;
	}

}