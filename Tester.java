import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;

public class Tester {
	public Tester () {}


	public List<String> ping (String destination, int count, int size) {
		List<String> output = new ArrayList<String> ();

		Runtime rt = Runtime.getRuntime();
		String command = "ping " + destination + " -c " + Integer.toString(count) + " -s " + Integer.toString(size);

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			
			String s;	
			while ((s = stdInput.readLine()) != null) {
				output.add(s);
			    //System.out.println(s);
			}

			return output;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void automatico (int hours, String filename) {
		String[] destinations = {"www.google.pt","www.instagram.com","www.facebook.com","www.twitch.tv","www.amazon.com","www.youtube.com"};
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    	try {
        FileWriter fw = new FileWriter(filename);
    	PrintWriter pw = new PrintWriter(fw);

			for (int i=0; i<hours; i++) {

				for (int j=0; j<destinations.length; j++) {
					System.out.println("A calcular...");
					Parser parser = new Parser(this.ping(destinations[j], 16, 56));
					pw.println("--------------------------------------------------");
					pw.println(LocalDateTime.now().format(formatter).toString());
					pw.println("Destino: " + destinations[j]);
					pw.println("Latency: " + Double.toString(parser.calculateLatency()) + "ms");
					pw.println("Packet Loss: " + Double.toString(parser.calculatePacketLoss()) + "%");
					pw.println("Jitter: " + Double.toString(parser.calculateJitter()) + "ms");
					pw.println("--------------------------------------------------");
				}
				System.out.println("A esperar..");
	
				if (i != hours-1) Thread.sleep(1000 * 60 * 60); // adormecer durante uma hora
			}
		pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}