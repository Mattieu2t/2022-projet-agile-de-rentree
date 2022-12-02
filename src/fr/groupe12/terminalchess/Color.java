package fr.groupe12.terminalchess;

public enum Color {
    BLACK,WHITE;
	
	public static Color get(boolean b) {
		return b ? WHITE : BLACK;
	}
}
