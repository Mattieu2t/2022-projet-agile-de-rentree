package fr.groupe12.terminalchess.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.groupe12.terminalchess.Color;
import fr.groupe12.terminalchess.Coordonnees;
import fr.groupe12.terminalchess.EPiece;
import fr.groupe12.terminalchess.Piece;
import fr.groupe12.terminalchess.Plateau;

public class Pion extends Piece {
	private boolean aBouge = false;

	public Pion(Plateau plateau, Coordonnees coords, Color color) {
		super(plateau, coords, color);
	}
	
	public void bouger(Coordonnees coord) {
		super.bouger(coord);
		aBouge = true;
		if(this.getColor() == Color.WHITE && this.getCoords().getY() == 7) {
			transformePion();
		} else if(this.getColor() == Color.BLACK && this.getCoords().getY() == 0) {
			transformePion();
		}
	}

	@Override
	public List<Coordonnees> getCoosPossible(boolean filter) {
		int x = this.getCoords().getX();
		int y = this.getCoords().getY();
		List<Coordonnees> coord = new ArrayList<Coordonnees>();
		if (!aBouge) {
			if (this.getColor()==Color.WHITE) {
				if (!super.getPlateau().isPieceOnCase(new Coordonnees(x,y+2))) coord.add(new Coordonnees(x,y+2));
			} else {
				if (!super.getPlateau().isPieceOnCase(new Coordonnees(x,y-2))) coord.add(new Coordonnees(x,y-2));
			}
		}
		if (this.getColor()==Color.WHITE) {
			if(isInBoard(new Coordonnees(x,y+1))) coord.add(new Coordonnees(x,y+1));
			
			if (super.getPlateau().isPieceOnCase(new Coordonnees(x,y+1))) {
				coord.removeAll(coord);
			}
		} else {
			if(isInBoard(new Coordonnees(x,y+1))) coord.add(new Coordonnees(x,y-1));
			
			if (super.getPlateau().isPieceOnCase(new Coordonnees(x,y-1))) {
				coord.removeAll(coord);
			}
		}
		if(super.getPlateau().isPieceOnCase(new Coordonnees(x+1, y+1)) && super.getPlateau().getPiece(new Coordonnees(x+1, y+1)).getColor() != this.getColor() && this.getColor() == Color.WHITE) {
			coord.add(new Coordonnees(x+1, y+1));
		}
		if(super.getPlateau().isPieceOnCase(new Coordonnees(x-1, y+1)) && super.getPlateau().getPiece(new Coordonnees(x-1, y+1)).getColor() != this.getColor() && this.getColor() == Color.WHITE) {

			coord.add(new Coordonnees(x-1, y+1));
		}
		if(super.getPlateau().isPieceOnCase(new Coordonnees(x+1, y-1)) && super.getPlateau().getPiece(new Coordonnees(x+1, y-1)).getColor() != this.getColor() && this.getColor() == Color.BLACK) {
			coord.add(new Coordonnees(x+1, y-1));
		}
		if(super.getPlateau().isPieceOnCase(new Coordonnees(x-1, y-1)) && super.getPlateau().getPiece(new Coordonnees(x-1, y-1)).getColor() != this.getColor() && this.getColor() == Color.BLACK) {
			coord.add(new Coordonnees(x-1, y-1));
		}
		
		if(filter) super.filterMoves(coord);
		return coord;
		
	}
	
	public void transformePion() {
		System.out.println("Choisissez une pièce par laquelle remplacer votre pion :");
		System.out.println("1. Reine, 2. Fou, 3. Tour, 4. Cavalier");
		Scanner sc = new Scanner(System.in);
		String choix = sc.next();
		while(!(choix.equals("1") || choix.equals("2") || choix.equals("3") || choix.equals("4"))) {
			System.out.println("Saisie incorrecte");
			choix = sc.next();
		}
		Piece piece;
		if(choix.equals("1")) {
			piece = new Reine(this.getPlateau(), this.getCoords(), this.getColor());
		} else if(choix.equals("2")) {
			piece = new Fou(this.getPlateau(), this.getCoords(), this.getColor());
		} else if(choix.equals("3")) {
			piece = new Tour(this.getPlateau(), this.getCoords(), this.getColor());
		} else {
			piece = new Cavalier(this.getPlateau(), this.getCoords(), this.getColor());
		}
		getPlateau().getPieces().remove(this);
		getPlateau().getPieces().add(piece);
	}

	@Override
	public EPiece getType() {
		return EPiece.PION;
	}

}
