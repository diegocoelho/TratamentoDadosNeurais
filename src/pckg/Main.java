package pckg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		 
		BufferedReader br = null;
		PrintWriter writer = null;
		try {
 
			String sCurrentLine;
			String saida = "";
			br = new BufferedReader(new FileReader("/home/diego/eclipse-workspace/TratamentoDadosNeurais/src/pckg/dados.txt"));
			 writer = new PrintWriter("saidadados.txt", "UTF-8");
			while ((sCurrentLine = br.readLine()) != null) {
				saida = "";
				System.out.println(sCurrentLine);
				String[] attr = sCurrentLine.split(",");
				System.out.println(attr[57]);
				
				
				writer.println(sCurrentLine);
				
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
				if(writer != null)writer.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
 
	}

}
