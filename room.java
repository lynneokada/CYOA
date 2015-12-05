// room.java - Room class

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class Room {
	private class room {
		String name;
		String description;
		HashMap<char, String> options;
	}


	public void createNewRoom (String name) {
		Room newRoom = new Room();
		room.name = name;
		room.description = null;
		room.options = new HashMap<char, String>();
	}

	public void addDescription(String description) {
		room.description = description;
	}
}