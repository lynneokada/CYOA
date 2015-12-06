// Adventure.java - read the input of adventure file

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import static java.lang.System.*;

class Adventure {

	private static HashMap<String, Room> worldMap;
	private static HashMap<Character, String> options;

	static void buildWorld(String filename) throws IOException {
		Scanner scan = new Scanner (new File(filename));

		// HashMap<String, Room> world = new HashMap<String, Room>();
		worldMap = new HashMap<String, Room>();
		char command;
		String inputline;
		int opIndex = 0;
		Room currentRoom = new Room();

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
					opIndex = 97;
					String name = inputline.substring(2);
					room.name = name;
					worldMap.put(name, room);
					currentRoom = room;
					break;
				case 'd': 
					String desc = inputline.substring(2);
					currentRoom.description = desc;
					System.out.println("d");
					break;
				case 'o': 
					if (currentRoom.options == null) {
						options = new HashMap<Character, String>();
					}
					String option = inputline.substring(2);
					// System.out.println((char)opIndex);
					currentRoom.options = options;
					options.put((char)opIndex,option);
					System.out.println("o");
					opIndex++;
					break;
				case 't': 
					String tag = inputline.substring(2);
					currentRoom.tag = tag;
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

		// Iterator it = worldMap.entrySet().iterator();

		try {
            buildWorld(filename);
        }catch (IOException error) {
            System.out.println("invalid adventure!");
        }

        Room currentRoom = new Room();
        // System.out.println(worldMap);
        currentRoom = worldMap.get("room1");
        System.out.println(currentRoom.description);
        System.out.println("");
        for(Map.Entry<Character, String> entry : options.entrySet()){
        	System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("");
        
	}

	// Room creation functions
	// public void 
}