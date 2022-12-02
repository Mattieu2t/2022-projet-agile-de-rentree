package fr.groupe12.terminalchess.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.groupe12.terminalchess.Color;
import fr.groupe12.terminalchess.Coordonnees;
import fr.groupe12.terminalchess.EPiece;
import fr.groupe12.terminalchess.Piece;
import fr.groupe12.terminalchess.Plateau;

public class Cavalier extends Piece {
	
	public Cavalier(Plateau plateau, Coordonnees coords, Color color) {
		super(plateau, coords, color);
	}

	@Override
	public List<Coordonnees> getCoosPossible(boolean filter) {
		int x = this.getCoords().getX();
		int y = this.getCoords().getY();
		List<Coordonnees> coord = new ArrayList<Coordonnees>();

			if (isInBoard(new Coordonnees(x+2,y+1)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x+2,y+1))) {
				coord.add(new Coordonnees(x+2,y+1));
			}
			if (isInBoard(new Coordonnees(x+2,y+1)) && super.getPlateau().isPieceOnCase(new Coordonnees(x+2,y+1))) {
				if(super.getPlateau().getPiece(new Coordonnees(x+2,y+1)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x+2,y+1));
				}
			}
			if (isInBoard(new Coordonnees(x+2,y-1)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x+2,y-1))) {
				coord.add(new Coordonnees(x+2,y-1));
				}
			if (isInBoard(new Coordonnees(x+2,y-1)) && super.getPlateau().isPieceOnCase(new Coordonnees(x+2,y-1))) {
				if(super.getPlateau().getPiece(new Coordonnees(x+2,y-1)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x+2,y-1));
				}
			}
			if (isInBoard(new Coordonnees(x-2,y+1)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x-2,y+1))) {
				coord.add(new Coordonnees(x-2,y+1));
				}
			if (isInBoard(new Coordonnees(x-2,y+1)) && super.getPlateau().isPieceOnCase(new Coordonnees(x-2,y+1))) {
				if(super.getPlateau().getPiece(new Coordonnees(x-2,y+1)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x-2,y+1));
				}
			}
			if (isInBoard(new Coordonnees(x-2,y-1)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x-2,y-1))) {
				coord.add(new Coordonnees(x-2,y-1));
			}
			if (isInBoard(new Coordonnees(x-2,y-1)) && super.getPlateau().isPieceOnCase(new Coordonnees(x-2,y-1))) {
				if(super.getPlateau().getPiece(new Coordonnees(x-2,y-1)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x-2,y-1));
				}
			}
			if (isInBoard(new Coordonnees(x+1,y+2)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x+1,y+2))) {
				coord.add(new Coordonnees(x+1,y+2));
			}
			if (isInBoard(new Coordonnees(x+1,y+2)) && super.getPlateau().isPieceOnCase(new Coordonnees(x+1,y+2))) {
				if(super.getPlateau().getPiece(new Coordonnees(x+1,y+2)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x+1,y+2));
				}
			}
			if (isInBoard(new Coordonnees(x-1,y+2)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x-1,y+2))) {
				coord.add(new Coordonnees(x-1,y+2));
			}
			if (isInBoard(new Coordonnees(x-1,y+2)) && super.getPlateau().isPieceOnCase(new Coordonnees(x-1,y+2))) {
				if(super.getPlateau().getPiece(new Coordonnees(x-1,y+2)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x-1,y+2));
				}
			}
			if (isInBoard(new Coordonnees(x-1,y-2)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x-1,y-2))) {
				coord.add(new Coordonnees(x-1,y-2));
			}
			if (isInBoard(new Coordonnees(x-1,y-2)) && super.getPlateau().isPieceOnCase(new Coordonnees(x-1,y-2))) {
				if(super.getPlateau().getPiece(new Coordonnees(x-1,y-2)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x-1,y-2));
				}
			}
			if (isInBoard(new Coordonnees(x+1,y-2)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x+1,y-2))) {
				coord.add(new Coordonnees(x+1,y-2));
			}
			if (isInBoard(new Coordonnees(x+1,y-2)) && super.getPlateau().isPieceOnCase(new Coordonnees(x+1,y-2))) {
				if(super.getPlateau().getPiece(new Coordonnees(x+1,y-2)).getColor() !=this.getColor()){
				coord.add(new Coordonnees(x+1,y-2));
				}
			}
		
			if(filter) super.filterMoves(coord);
			return coord;
		}

	@Override
	public EPiece getType() {
		return EPiece.CAVALIER;
	}
}