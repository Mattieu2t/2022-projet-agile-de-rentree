package fr.groupe12.terminalchess.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.groupe12.terminalchess.Color;
import fr.groupe12.terminalchess.Coordonnees;
import fr.groupe12.terminalchess.EPiece;
import fr.groupe12.terminalchess.Piece;
import fr.groupe12.terminalchess.Plateau;

public class Tour extends Piece {
	private boolean aBouge = false;
	public Tour(Plateau plateau, Coordonnees coords, Color color) {
		super(plateau, coords, color);
	}
	
	public void bouger(Coordonnees coord) {
		super.bouger(coord);
		aBouge = true;
	}
	
	@Override
	public List<Coordonnees> getCoosPossible(boolean filter) {
		int x = this.getCoords().getX();
		int y = this.getCoords().getY();
		ArrayList<Coordonnees> coord = new ArrayList<>();
		
		int i = 1;
		while(isInBoard(new Coordonnees(x,y+i)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x,y+i))){
			coord.add(new Coordonnees(x,y+i));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x,y+i)) && super.getPlateau().isPieceOnCase(new Coordonnees(x,y+i))) {
			if(super.getPlateau().getPiece(new Coordonnees(x, y+i)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x, y+i));
			}
		}
		
		
		i = 1;
		while(isInBoard(new Coordonnees(x,y-i)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x,y-i))){
			coord.add(new Coordonnees(x,y-i));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x,y-i)) && super.getPlateau().isPieceOnCase(new Coordonnees(x,y-i))) {
			if(super.getPlateau().getPiece(new Coordonnees(x, y-i)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x, y-i));
			}
		}
		
		
		i = 1;
		while(isInBoard(new Coordonnees(x+i,y)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x+i,y))){
			coord.add(new Coordonnees(x+i,y));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x+i,y)) && super.getPlateau().isPieceOnCase(new Coordonnees(x+i,y))) {
			if(super.getPlateau().getPiece(new Coordonnees(x+i, y)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x+i, y));
			}
		}
		
		
		i = 1;
		while(isInBoard(new Coordonnees(x-i,y)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x-i,y))){
			coord.add(new Coordonnees(x-i,y));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x-i,y)) && super.getPlateau().isPieceOnCase(new Coordonnees(x-i,y))) {
			if(super.getPlateau().getPiece(new Coordonnees(x-i, y)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x-i, y));
			}
		}
		
		if(filter) super.filterMoves(coord);
		return coord;
	}

	@Override
	public EPiece getType() {
		return EPiece.TOUR;
	}
	
	public boolean aBouger() {
		return aBouge;
	}

}