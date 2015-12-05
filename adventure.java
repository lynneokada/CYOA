// adventure.java - read the input of adventure file

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import static java.lang.System.*;

class Adventure {

	private static HashMap<String, Room> worldMap;

	static void buildWorld(String filename) throws IOException {
		Scanner scan = new Scanner (new File(filename));

		HashMap<String, Room> world = new HashMap<String, Room>();
		char command;
		String inputline;
		while(scan.hasNextLine()) {
			inputline = scan.nextLine();

			System.out.println("-> "+inputline);
			if (inputline.equals("")) {
				command = ' ';
			} else {
				command = inputline.charAt(0);
			}
			
			switch(command) {
				case 'r': 
					System.out.println("r");
					Room room = new Room();
					String name = inputline.substring(2);
					world.put(name, room);
					break;
				case 'd': 
					String desc = inputline.substring(2);
					System.out.println("d");
					break;
				case 'o': 
					String option = inputline.substring(2);
					System.out.println("o");
					break;
				case 't': 
					String tag = inputline.substring(2);
					System.out.println("t");
					break;
				case ' ':
					System.out.println("blank line");
					break;
				default : break;
			}
		}
	}

	public void startAdventure(String filename) {
		System.out.println("Start new adventure");

		try {
            buildWorld(filename);
        }catch (IOException error) {
            
        }
	}
}