// Adventure.java - read the input of adventure file

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import static java.lang.System.*;

class Adventure {

	private static HashMap<String, Room> worldMap;
	private static HashMap<Character, String[]> options;
	private static String[] arr; 

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

			// System.out.println("-> "+inputline);
			if (inputline.equals("")) {
				command = ' ';
			} else {
				command = inputline.charAt(0);
			}
			
			switch(command) {
				case 'r': 
					// System.out.println("r");
					Room room = new Room();
					opIndex = 97;
					String name = inputline.substring(2);
					room.name = name;
					worldMap.put(name, room);
					currentRoom = room;
					// System.out.println("CURR: "+currentRoom);
					break;
				case 'd': 
					String desc = inputline.substring(2);
					currentRoom.description = desc;
					// System.out.println("d");
					break;
				case 'o': 
					if (currentRoom.options == null) {
						options = new HashMap<Character, String[]>();
					}
					arr = new String[2];
					String option = inputline.substring(2);
					arr[0] = option;
					// System.out.println((char)opIndex);
					currentRoom.options = options;
					options.put((char)opIndex,arr);
					// System.out.println("o");
					opIndex++;
					break;
				case 't': 
					String tag = inputline.substring(2);
					arr[1] = tag;
					System.out.println(arr[0]+","+arr[1]);
					// System.out.println("t");
					break;
				case ' ':
					// System.out.println("blank line");
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

        startPoint(currentRoom);

        System.out.println("");
        for(Map.Entry<Character, String[]> entry : options.entrySet()){
        	System.out.println(entry.getKey()+" - "+entry.getValue()[0]);
        }
        System.out.println("");
        
        BufferedReader inpt = new BufferedReader(new InputStreamReader(System.in));
        
        try {
        	while (true) {
        		String selection = inpt.readLine();
        		char ch = selection.charAt(0);

        		System.out.println("["+options.get(ch)[0]+"]");
        		System.out.println("");

        		currentRoom = worldMap.get(options.get(ch)[1]);
        		System.out.println("ARRAY: " + arr[0]+","+arr[1]);
        		System.out.println(currentRoom.description);
        		System.out.println("");
        		// for(Map.Entry<String, Room> entry : worldMap.entrySet()){
        		// 	System.out.println(entry.getKey()+" - "+entry.getValue());
        		// 	System.out.println("OPTIONS: "+entry.getValue().options.get('a')[1]+" , "+entry.getValue().options.get('b')[1]);
        		// }

        		for(Map.Entry<Character, String[]> entry : options.entrySet()){
        			System.out.println(entry.getKey()+" - "+entry.getValue()[0]);
        		}
        		System.out.println("");
        	}
        }catch (IOException error) {
            System.out.println("invalid option!");
        }
	}

	void startPoint(Room currentRoom) {
		Map.Entry<String, Room> entry = worldMap.entrySet().iterator().next();
		currentRoom = entry.getValue();
		System.out.println(currentRoom.description);
	}

	// Room creation functions
	// public void 
}