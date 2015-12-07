// cyoa.java - main file for processing adventure file

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import static java.lang.System.*;

class cyoa {
	
	public static void main(String[] args) {
		String filename = args[0];
		// System.out.println(filename);
		
		Adventure newAdventure = new Adventure();
        
        newAdventure.startAdventure(filename);        
	}
}