import java.io.*;

public class Menu {
	private BufferedReader input;
	private Tester tester;

	public Menu () {
		this.input = new BufferedReader (new InputStreamReader (System.in));
		this.tester = new Tester();
	}

	public void start () {

		try {	
			System.out.println("------------------- Bem vindo! -------------------");
			System.out.println("Deseja realizar um teste singular(S) ou automático(A)?");

			switch (input.readLine()) {
				case "S":
					this.singular();
					break;
				case "A":
					this.automatico();
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}

		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void singular () {
		try {
			String destination, count, size;
	
			System.out.println("Insira o destino:");
			destination = input.readLine();
			
			System.out.println("Insira o número de pacotes a serem enviados:");
			count = input.readLine();
			
			System.out.println("Insira o tamanho dos pacotes a serem enviados:");
			size = input.readLine();
			
			Parser parser = new Parser (tester.ping(destination,Integer.parseInt(count),Integer.parseInt(size)));
			
			System.out.println("--------------------------------------------------");
			System.out.println("Latencia: " + Double.toString(parser.calculateLatency()) + "ms");
			System.out.println("Packet Loss: " + Double.toString(parser.calculatePacketLoss()) + "%");
			System.out.println("Jitter: " + Double.toString(parser.calculateJitter()) + "ms");
			System.out.println("--------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void automatico () {
		try {
			System.out.println("Insira o número de horas:");
			int horas = Integer.parseInt(input.readLine());

			System.out.println("Insira o nome do ficheiro para guardar os resultados:");
			String filename = input.readLine();

			tester.automatico(horas,filename);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}