package fr.groupe12.terminalchess.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.groupe12.terminalchess.Color;
import fr.groupe12.terminalchess.Coordonnees;
import fr.groupe12.terminalchess.EPiece;
import fr.groupe12.terminalchess.Piece;
import fr.groupe12.terminalchess.Plateau;

public class Roi extends Piece {
	private boolean roqueDisponible = false;
	private boolean aBouge = false;
	public Roi(Plateau plateau, Coordonnees coords, Color color) {
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
		List<Coordonnees> coord = new ArrayList<Coordonnees>();
		
		for (int x1 = x-1 ; x1<= x+1;x1++) {
			for (int y1 = y-1 ; y1<= y+1;y1++) {
				if (this.isInBoard(new Coordonnees(x1, y1)) && !super.getPlateau().isPieceOnCase(new Coordonnees(x1,y1))) {
					coord.add(new Coordonnees(x1, y1));
				}
				if(isInBoard(new Coordonnees(x1,y1)) && super.getPlateau().isPieceOnCase(new Coordonnees(x1,y1))) {
					if(super.getPlateau().getPiece(new Coordonnees(x1, y1)).getColor() != this.getColor()) {
						coord.add(new Coordonnees(x1, y1));
					}
				}
			}
		}
		
		if(filter) super.filterMoves(coord);
		
		return coord;
	}

	@Override
	public EPiece getType() {
		return EPiece.ROI;
	}
	
	public boolean canRoqueGauche() {
		if(!aBouge) return false;
		Piece piece = super.getColor() == Color.WHITE ? super.getPlateau().getPiece(new Coordonnees("A1")) : super.getPlateau().getPiece(new Coordonnees("H8"));
		
		if(piece != null && piece.getType() == EPiece.TOUR) {
			Tour tour = (Tour) piece;
			return !tour.aBouger();
		}
		
		return false;
	}

}
