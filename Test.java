import java.io.*;
import java.lang.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Test {
	public static void main (String args[]) {



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		try {

        	FileWriter fw = new FileWriter("wtf");
    		PrintWriter pw = new PrintWriter(fw);


    		pw.println("lol lol lol");
    		pw.close();
		} catch (Exception e) {}
	}	
}