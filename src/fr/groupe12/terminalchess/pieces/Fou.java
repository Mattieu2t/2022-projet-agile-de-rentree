package fr.groupe12.terminalchess.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.groupe12.terminalchess.Color;
import fr.groupe12.terminalchess.Coordonnees;
import fr.groupe12.terminalchess.EPiece;
import fr.groupe12.terminalchess.Piece;
import fr.groupe12.terminalchess.Plateau;

public class Fou extends Piece {

	public Fou(Plateau plateau, Coordonnees coords, Color color) {
		super(plateau, coords, color);
	}

	@Override
	public List<Coordonnees> getCoosPossible(boolean filter) {
		int x = this.getCoords().getX();
		int y = this.getCoords().getY();
		List<Coordonnees> coord = new ArrayList<Coordonnees>();
		int i = 1;
		while(isInBoard(new Coordonnees(x+i,y+i)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x+i,y+i))){
			coord.add(new Coordonnees(x+i,y+i));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x+i,y+i)) && super.getPlateau().isPieceOnCase(new Coordonnees(x+i,y+i))) {
			if(super.getPlateau().getPiece(new Coordonnees(x+i, y+i)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x+i, y+i));
			}
		}
		
		
		i = 1;
		while(isInBoard(new Coordonnees(x+i,y-i)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x+i,y-i))){
			coord.add(new Coordonnees(x+i,y-i));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x+i,y-i)) && super.getPlateau().isPieceOnCase(new Coordonnees(x+i,y-i))) {
			if(super.getPlateau().getPiece(new Coordonnees(x+i, y-i)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x+i, y-i));
			}
		}
		
		
		i = 1;
		while(isInBoard(new Coordonnees(x-i,y-i)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x-i,y-i))){
			coord.add(new Coordonnees(x-i,y-i));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x-i,y-i)) && super.getPlateau().isPieceOnCase(new Coordonnees(x-i,y-i))) {
			if(super.getPlateau().getPiece(new Coordonnees(x-i, y-i)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x-i, y-i));
			}
		}
		
		
		i = 1;
		while(isInBoard(new Coordonnees(x-i,y+i)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x-i,y+i))){
			coord.add(new Coordonnees(x-i,y+i));
			i++;
		}
		
		if(isInBoard(new Coordonnees(x-i,y+i)) && super.getPlateau().isPieceOnCase(new Coordonnees(x-i,y+i))) {
			if(super.getPlateau().getPiece(new Coordonnees(x-i, y+i)).getColor() != this.getColor()) {
				coord.add(new Coordonnees(x-i, y+i));
			}
		}
		
		if(filter) super.filterMoves(coord);
		
		return coord;
	}

	@Override
	public EPiece getType() {
		return EPiece.FOU;
	}

}
