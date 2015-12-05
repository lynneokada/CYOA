// cyoa.java - main file for processing adventure file

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import static java.lang.System.*;

class cyoa {
	private static HashMap<String, Room> worldMap;

	static void buildWorld(String filename) throws IOException {
		Scanner scan = new Scanner (new File(filename));

		HashMap<String, Room> worldMap = new HashMap<String, Room>();
		char command;
		String inputline;
		while(scan.hasNextLine()) {
			inputline = scan.nextLine();
			System.out.println(inputline);
			command = inputline.charAt(0);
			switch(command) {
				case 'r': 
					System.out.println("r");
					Room room = new Room();
					String roomName = inputline.substring(2);
					worldMap.put(roomName, room);
					break;
				case 'd': 
					System.out.println("d");
					break;
				case 'o': 
					System.out.println("o");
					break;
				case 't': 
					System.out.println("t");
					break;
				default : break;
			}
		}
	}

	public static void main(String[] args) {
		String filename = args[0];
		System.out.println(filename);

		try {
            buildWorld(filename);
        }catch (IOException error) {
            
        }

	}
}