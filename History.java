// History.java - keeps a log of user's input

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import static java.lang.System.*;

class History {
	private class Node {
      char item;
      Node prev;
   	}
   	private Node head = null;

   	public boolean isempty() {
   		if (head == null) {
        	return true;
      	}
      return false;
  	}

  	public void insert(char newitem) {
      // throw new RuntimeException("Replace this with working code");
      	if (isempty()) {
        	head = new Node();
        	head.item = newitem;
      	} else {
        	Node newNode = new Node();
        	newNode.item = newitem;
        	newNode.prev = head;
        	head = newNode;
      	}

      	// System.out.println("add "+newitem);
   	}

   	public char remove() {
        head = head.prev;

        return head.item;
    }
}