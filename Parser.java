import java.io.*;
import java.util.*;
import java.lang.*;

public class Parser {
	private List<String> parse;

	public Parser (List<String> parse) {
		this.parse = parse;
	}

	public Double calculateLatency () {
		String target = this.parse.get(parse.size()-1);

		return Double.parseDouble(target.split("=")[1].split("/")[1]);
	}	

	public Double calculatePacketLoss () {
		String target = this.parse.get(parse.size()-2);

		return Double.parseDouble(target.split(",")[2].split(" ")[1].replace("%",""));
	}

	public Double calculateJitter () {
		List<Double> latencyList = new ArrayList<Double> ();
		String target;

		for (int i=1; i<parse.size()-4; i++) {
			target = parse.get(i).split("time=")[1].split(" ")[0];
			latencyList.add(Double.parseDouble(target));
			//System.out.println(target);
		}

		double jitter = 0.0;
		int i;
		for (i=0; i<latencyList.size()-2; i++)
			jitter += Math.abs(latencyList.get(i) - latencyList.get(i+1));

		return jitter/i;
	} 
}