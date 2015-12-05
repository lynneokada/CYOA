// cyoa.java - main file for processing adventure file

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class cyoa {
	static void processFile(String filename) throws IOException {
		Scanner scan = new Scanner (new File(filename));

		

	}

	public static void main(String[] args) {
		String filename = args[0];
		System.out.println(filename);

		try {
            processFile(filename);
        }catch (IOException error) {
            
        }
	}
}