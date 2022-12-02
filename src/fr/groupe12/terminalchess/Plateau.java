package fr.groupe12.terminalchess;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.groupe12.terminalchess.pieces.Cavalier;
import fr.groupe12.terminalchess.pieces.Fou;
import fr.groupe12.terminalchess.pieces.Pion;
import fr.groupe12.terminalchess.pieces.Reine;
import fr.groupe12.terminalchess.pieces.Roi;
import fr.groupe12.terminalchess.pieces.Tour;

public class Plateau {
	
	private List<Piece> pieces;
	private boolean player = true; // true = white   false = black
	private boolean whiteChess = false;
	private boolean blackChess = false;
	
	public Plateau() {
		pieces = new ArrayList<Piece>();
	}
	
	public boolean getTurn() {
		return player;
	}
	
	public void afficher() {
		String lineSeparator = "    —   —   —   —   —   —   —   —";
		String letters = "    A   B   C   D   E   F   G   H";
		System.out.println(lineSeparator);
		String line;
		String[][] strPieces = getStringPieces();
		for(int y=0; y<8; y++) {
			line = ""+(8-y)+" | ";
			for(int x=0; x<8; x++) {
				if(strPieces[y][x] != null) {
					line += strPieces[y][x] + " | ";
				} else line += "  | ";
			}
			System.out.println(line);
			System.out.println(lineSeparator);
		}
		System.out.println(letters);
	}
	
	private String[][] getStringPieces() {
		String[][] tab = new String[8][8];
		int x, y;
		for(Piece piece : pieces) {
			x = piece.getCoords().getX();
			y = 7-piece.getCoords().getY();
			tab[y][x] = piece.getType().getFromColor(piece.getColor());
		}
		return tab;
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	public List<Piece> getWhitePieces() {
		return getPiecesFromColor(Color.WHITE);
	}
	
	public List<Piece> getBlackPieces() {
		return getPiecesFromColor(Color.BLACK);
	}
	
	public List<Coordonnees> allPossibleCases(Color color) {
		List<Coordonnees> res = new ArrayList<Coordonnees>();
		for(Piece p : getPiecesFromColor(color)) {
			res.addAll(p.getCoosPossible(false));
		}
		return res;
	}
	
	public List<Piece> getPiecesFromColor(Color color) {
		List<Piece> res = new ArrayList<Piece>();
		for(Piece p : pieces) {
			if(p.getColor() == color) res.add(p);
		}
		return res;
	}
	
	public boolean isPieceOnCase(Coordonnees coord) {
		int i=0;
		boolean res = false;
		while(i<pieces.size() && !res) {
			if(pieces.get(i).getCoords().equals(coord)) {
				res = true;
			}
			i++;
		}
		return res;
	}
	
	public Piece getPiece(Coordonnees coord) {
		for(Piece piece : pieces) {
			if(piece.getCoords().equals(coord)) return piece;
		}
		return null;
	}
	
	public Piece getKing(Color color) {
		for(Piece p : pieces) {
			if(p.getType() == EPiece.ROI && p.getColor() == color) return p;
		}
		return null;
	}
	
	public List<Coordonnees> aProteger(Color color) {
		List<Coordonnees> res = new ArrayList<Coordonnees>();
		
		
		return res;
	}
	
	
	/*public GameState calculateGameState() {
		List<Coordonnees> whiteCasesPossible = allPossibleCases(Color.WHITE);
		List<Coordonnees> blackCasesPossible = allPossibleCases(Color.BLACK);
		if(whiteChess && whiteCasesPossible.isEmpty()) return GameState.FINI;
		else if(whiteCasesPossible.isEmpty()) return GameState.NUL;
		
		if(blackChess && blackCasesPossible.isEmpty()) return GameState.FINI;
		else if(blackCasesPossible.isEmpty()) return GameState.NUL;
		return GameState.EN_COURS;
	}*/
	
	public GameState calculateGameState() {
		Piece blanc = getKing(Color.WHITE);
		Piece noir = getKing(Color.BLACK);
		if(blanc != null && noir != null) return GameState.EN_COURS;
		if(blanc == null) return GameState.WIN_BLACK;
		else return GameState.WIN_WHITE;
	}
	
	public Plateau init() {
		Plateau plateau = new Plateau();
		for (int cpt = 0; cpt < 8; cpt++) {
			Pion pion = new Pion(plateau, new Coordonnees((char)('A'+cpt) + "2"), Color.WHITE);
			plateau.getPieces().add(pion);
		}
		Fou fouB1 = new Fou(plateau, new Coordonnees("C1"), Color.WHITE);
		Tour tourB1 = new Tour(plateau, new Coordonnees("A1"), Color.WHITE);
		Cavalier cavalierB1 = new Cavalier(plateau, new Coordonnees("B1"), Color.WHITE);
		Fou fouB2 = new Fou(plateau, new Coordonnees("F1"), Color.WHITE);
		Tour tourB2 = new Tour(plateau, new Coordonnees("H1"), Color.WHITE);
		Cavalier cavalierB2 = new Cavalier(plateau, new Coordonnees("G1"), Color.WHITE);
		Reine reineB = new Reine(plateau, new Coordonnees("D1"), Color.WHITE);
		Roi roiB = new Roi(plateau, new Coordonnees("E1"), Color.WHITE);
		
		for (int cpt = 0; cpt < 8; cpt++) {
			Pion pion = new Pion(plateau, new Coordonnees((char)('A'+cpt) + "7"), Color.BLACK);
			plateau.getPieces().add(pion);
		}
		Fou fouN1 = new Fou(plateau, new Coordonnees("C8"), Color.BLACK);
		Tour tourN1 = new Tour(plateau, new Coordonnees("A8"), Color.BLACK);
		Cavalier cavalierN1 = new Cavalier(plateau, new Coordonnees("B8"), Color.BLACK);
		Fou fouN2 = new Fou(plateau, new Coordonnees("F8"), Color.BLACK);
		Tour tourN2 = new Tour(plateau, new Coordonnees("H8"), Color.BLACK);
		Cavalier cavalierN2 = new Cavalier(plateau, new Coordonnees("G8"), Color.BLACK);
		Reine reineN = new Reine(plateau, new Coordonnees("D8"), Color.BLACK);
		Roi roiN = new Roi(plateau, new Coordonnees("E8"), Color.BLACK);
		
		plateau.getPieces().add(fouB1);
		plateau.getPieces().add(tourB1);
		plateau.getPieces().add(cavalierB1);
		plateau.getPieces().add(reineB);
		plateau.getPieces().add(roiB);
		plateau.getPieces().add(fouB2);
		plateau.getPieces().add(cavalierB2);
		plateau.getPieces().add(tourB2);
		
		plateau.getPieces().add(fouN1);
		plateau.getPieces().add(tourN1);
		plateau.getPieces().add(cavalierN1);
		plateau.getPieces().add(reineN);
		plateau.getPieces().add(roiN);
		plateau.getPieces().add(fouN2);
		plateau.getPieces().add(cavalierN2);
		plateau.getPieces().add(tourN2);
		
		
		return plateau;
	}
	
	public void start() {
		
		GameState state = GameState.EN_COURS;
		while(state == GameState.EN_COURS) {
			System.out.println(Ansi.clear);
			String tour = player ? "C'est au tour des blancs de jouer !" : "C'est au tour des noirs de jouer !";
			Color color = Color.get(player);
			afficher();
			System.out.println(tour);
			if((player && whiteChess) || (!player && blackChess)) System.out.println(Ansi.Red.format("Vous êtes en échec !"));
			whiteChess = false;
			blackChess = false;
			boolean select = false;
			Piece piece = null;
			Coordonnees selectCase = null;
			while(!select) {
				System.out.println("Selectionner votre pièce");
				Coordonnees enter = UserItf.selectPiece(this);
				piece = getPiece(enter);
				List<Coordonnees> coords = piece.getCoosPossible(false);
				System.out.println("Cases possibles : " + coords);
				System.out.println("Selectionner la case");
				selectCase = UserItf.selectCase(coords);
				if(selectCase.getX() != -1) {
					select = true;
				}
			}
			piece.bouger(selectCase);
			List<Coordonnees> cases = allPossibleCases(color);
			if(getKing(Color.get(!player)) != null) {
				if(Coordonnees.contains(cases, getKing(Color.get(!player)).getCoords())) {
					if(color == Color.WHITE) blackChess = true; 
					else whiteChess = true;
				}
			}
			
			state = calculateGameState();
			player = !player;
		}
		
		if(state == GameState.WIN_WHITE) {
			System.out.println(Ansi.Red.format("Les blancs ont gagnés !"));
		} else if(state == GameState.WIN_BLACK) {
			System.out.println(Ansi.Red.format("Les noirs ont gagnés !"));
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		obj.put("turn", player);
		obj.put("whiteChess", whiteChess);
		obj.put("blackChess", blackChess);
		JSONArray array = new JSONArray();
		for(Piece piece : pieces) {
			array.put(piece.toJSON());
		}
		obj.put("pieces", array);
		return obj;
	}
	
	public static Plateau fromJSON(JSONObject obj) {
		Plateau plateau = new Plateau();
		JSONArray array = obj.getJSONArray("pieces");
		for(int i=0; i<array.length(); i++) {
			if(Piece.fromJSON(array.getJSONObject(i), plateau) != null) {
				plateau.getPieces().add((Piece) Piece.fromJSON(array.getJSONObject(i), plateau));
			}
		}
		plateau.setWhiteChess(obj.getBoolean("whiteChess"));
		plateau.setBlackChess(obj.getBoolean("blackChess"));
		plateau.setPlayer(obj.getBoolean("turn"));
		return plateau;
	}
	
	public void setWhiteChess(boolean whiteChess) {
		this.whiteChess = whiteChess;
	}
	
	public void setBlackChess(boolean blackChess) {
		this.blackChess = blackChess;
	}
	
	public void setPlayer(boolean player) {
		this.player = player;
	}
	
	public static void main(String[] args) {
		Plateau plateau = new Plateau();
		plateau = plateau.init();
		plateau.start();
		
	}

}
