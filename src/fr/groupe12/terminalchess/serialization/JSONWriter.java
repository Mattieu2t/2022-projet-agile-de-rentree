package fr.groupe12.terminalchess.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.json.JSONObject;

import fr.groupe12.terminalchess.Plateau;

public class JSONWriter {
	
	private static String path = System.getProperty("user.dir") + System.getProperty("file.separator") + "saves" + System.getProperty("file.separator");
	
	public static void saveGame(Plateau plateau, String name) {
		JSONObject obj = plateau.toJSON();
		write(new File(path + name), obj);
	}
	
	private static void write(File file, JSONObject obj) {
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(obj.toString());
			fw.flush();
		} catch (FileNotFoundException e) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
				write(file, obj);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
