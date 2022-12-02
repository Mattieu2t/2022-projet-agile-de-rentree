package fr.groupe12.terminalchess.serialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

import fr.groupe12.terminalchess.Plateau;

public class JSONReader {
	
	public static Plateau loadPlateau(String path) {
		JSONObject obj = parseJsonFile(path);
		return Plateau.fromJSON(obj);
	}
	
	public static JSONObject parseJsonFile(File file) {
		JSONObject obj = new JSONObject();
		if(!file.exists() || !file.canRead() || !file.isFile()) return obj;
		obj = new JSONObject(fileToString(file));
		return obj;
	}
	
	public static JSONObject parseJsonFile(String path) {
		return parseJsonFile(new File(path));
	}

	public static String fileToString(File file) {
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
