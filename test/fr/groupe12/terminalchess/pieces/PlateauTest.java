package fr.groupe12.terminalchess.pieces;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import fr.groupe12.terminalchess.Color;
import fr.groupe12.terminalchess.Coordonnees;
import fr.groupe12.terminalchess.EPiece;
import fr.groupe12.terminalchess.Piece;
import fr.groupe12.terminalchess.Plateau;
import fr.groupe12.terminalchess.UserItf;

class PlateauTest {
	public Plateau plateau = new Plateau();
	@BeforeEach
	void test() {
		plateau = plateau.init();
	}
	
	@Test
	public void testBouger() {
		assertEquals(EPiece.PION , this.plateau.getPiece(new Coordonnees("A2")).getType());
		assertEquals(null , this.plateau.getPiece(new Coordonnees("A4")));
		this.plateau.getPiece(new Coordonnees("A2")).bouger(new Coordonnees("A4"));
		assertEquals(EPiece.PION , this.plateau.getPiece(new Coordonnees("A4")).getType());
	}
	
	@Test
	public void testManger() {
		assertEquals(32 , this.plateau.getPieces().size());
		this.plateau.getPiece(new Coordonnees("E2")).bouger(new Coordonnees("E6"));
		this.plateau.getPiece(new Coordonnees("F1")).bouger(new Coordonnees("C4"));
		this.plateau.getPiece(new Coordonnees("C4")).bouger(new Coordonnees("F7"));
		assertEquals(31, this.plateau.getPieces().size());
	}
	
	@Test
	public void testCoordonnee() {
		assertEquals(new Coordonnees("A1").getX(),new Coordonnees(0, 0).getX());
		assertEquals(new Coordonnees("A1").getY(),new Coordonnees(0, 0).getY());
	}
	
	@Test
	public void testPossibiliteFou() {
		Fou fouTest = new Fou(plateau, new Coordonnees("D4"), Color.WHITE);
		List<Coordonnees> listeTest = new ArrayList<Coordonnees>();
		listeTest.add(new Coordonnees("E5"));
		listeTest.add(new Coordonnees("F6"));
		listeTest.add(new Coordonnees("G7"));
		listeTest.add(new Coordonnees("E3"));
		listeTest.add(new Coordonnees("C3"));
		listeTest.add(new Coordonnees("C5"));
		listeTest.add(new Coordonnees("B6"));
		listeTest.add(new Coordonnees("A7"));
		
		assertEquals(fouTest.getCoosPossible().toString(),listeTest.toString());
	}
	
	@Test
	public void testPossibiliteTour() {
		Tour tourTest = new Tour(plateau, new Coordonnees("D4"), Color.WHITE);
		List<Coordonnees> listeTest = new ArrayList<Coordonnees>();
		listeTest.add(new Coordonnees("D5"));
		listeTest.add(new Coordonnees("D6"));
		listeTest.add(new Coordonnees("D7"));
		listeTest.add(new Coordonnees("D3"));
		listeTest.add(new Coordonnees("E4"));
		listeTest.add(new Coordonnees("F4"));
		listeTest.add(new Coordonnees("G4"));
		listeTest.add(new Coordonnees("H4"));
		listeTest.add(new Coordonnees("C4"));
		listeTest.add(new Coordonnees("B4"));
		listeTest.add(new Coordonnees("A4"));		
		
		assertEquals(tourTest.getCoosPossible().toString(),listeTest.toString());
	}
	
	@Test
	public void testPossibiliteCavalier() {
		Cavalier cavalierTest = new Cavalier(plateau, new Coordonnees("D4"), Color.WHITE);
		List<Coordonnees> listeTest = new ArrayList<Coordonnees>();
		listeTest.add(new Coordonnees("F5"));
		listeTest.add(new Coordonnees("F3"));
		listeTest.add(new Coordonnees("B5"));
		listeTest.add(new Coordonnees("B3"));
		listeTest.add(new Coordonnees("E6"));
		listeTest.add(new Coordonnees("C6"));		
		
		assertEquals(cavalierTest.getCoosPossible().toString(),listeTest.toString());
	}
	
	@Test
	public void testPossibiliteRoi() {
		Roi roiTest = new Roi(plateau, new Coordonnees("D4"), Color.WHITE);
		List<Coordonnees> listeTest = new ArrayList<Coordonnees>();
		listeTest.add(new Coordonnees("C3"));
		listeTest.add(new Coordonnees("C4"));
		listeTest.add(new Coordonnees("C5"));
		listeTest.add(new Coordonnees("D3"));
		listeTest.add(new Coordonnees("D4"));
		listeTest.add(new Coordonnees("D5"));		
		listeTest.add(new Coordonnees("E3"));
		listeTest.add(new Coordonnees("E4"));
		listeTest.add(new Coordonnees("E5"));
		
		assertEquals(roiTest.getCoosPossible().toString(),listeTest.toString());
	}
	
	@Test
	public void testPossibiliteReine() {
		Reine reineTest = new Reine(plateau, new Coordonnees("D4"), Color.WHITE);
		List<Coordonnees> listeTest = new ArrayList<Coordonnees>();
		listeTest.add(new Coordonnees("E5"));
		listeTest.add(new Coordonnees("F6"));
		listeTest.add(new Coordonnees("G7"));
		listeTest.add(new Coordonnees("E3"));
		listeTest.add(new Coordonnees("C3"));
		listeTest.add(new Coordonnees("C5"));		
		listeTest.add(new Coordonnees("B6"));
		listeTest.add(new Coordonnees("A7"));
		listeTest.add(new Coordonnees("D5"));
		listeTest.add(new Coordonnees("D6"));
		listeTest.add(new Coordonnees("D7"));
		listeTest.add(new Coordonnees("D3"));
		listeTest.add(new Coordonnees("E4"));
		listeTest.add(new Coordonnees("F4"));
		listeTest.add(new Coordonnees("G4"));		
		listeTest.add(new Coordonnees("H4"));
		listeTest.add(new Coordonnees("C4"));
		listeTest.add(new Coordonnees("B4"));
		listeTest.add(new Coordonnees("A4"));
		
		assertEquals(reineTest.getCoosPossible().toString(),listeTest.toString());
	}

}
