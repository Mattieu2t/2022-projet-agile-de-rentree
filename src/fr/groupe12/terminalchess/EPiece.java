package fr.groupe12.terminalchess;

public enum EPiece {
	
	FOU("\u2657", "\u265D"),
	TOUR("\u2656", "\u265C"),
	CAVALIER("\u2658", "\u265E"),
	REINE("\u2655", "\u265B"),
	ROI("\u2654", "\u265A"),
	PION("\u2659", "\u265F");
	
	
	private String white;
	private String black;
	
	private EPiece(String white, String black) {
		this.white = white;
		this.black = black;
	}
	
	public String getFromColor(Color color) {
		return color == Color.WHITE ? white : black;
	}
	
	public String getBlack() {
		return black;
	}
	
	public String getWhite() {
		return white;
	}

}
