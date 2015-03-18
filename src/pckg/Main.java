package pckg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Main {
	static HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

	public static void refreshHash() {
		hash.put(24, 95);
		hash.put(25, 96);
		hash.put(26, 99);
		hash.put(27, 93);
		hash.put(28, 98);
		hash.put(29, 97);
		hash.put(30, 98);
		hash.put(31, 99);
		hash.put(32, 85);
		hash.put(33, 95);
		hash.put(34, 90);
		hash.put(35, 81);
		hash.put(36, 87);
		hash.put(40, 99);
		hash.put(41, 94);
		hash.put(42, 77);
		hash.put(43, 85);
		hash.put(45, 86);
		hash.put(47, 95);
	}
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	public static int importancia(int ent){
		if (ent == 0){
			return 1;
		}
		else if(ent < 85){
			return 2;
		} else if (ent < 90){
			return 3;
		} else if (ent < 170){
			return 4;
		} else {
			return 5;
		}	
	}
	public static int directs(int imp){
		switch (imp) {
		case 1:
			return randInt(21, 40);
		case 2:
			return randInt(11, 20);
		case 3:
			return randInt(6, 10);
		case 4:
			return randInt(3, 5);
		case 5:
			return randInt(1, 2);
		}
		return -1;
	}
	
	public static void main(String[] args) {

		BufferedReader br = null;
		PrintWriter writer = null;
		try {
			String sCurrentLine;
			String saida = "";
			String importancia;
			int soma = 0;
			br = new BufferedReader(
					new FileReader(
							"/home/diego/eclipse-workspace/TratamentoDadosNeurais/src/pckg/dados.txt"));
			writer = new PrintWriter("saidadados.txt", "UTF-8");
			while ((sCurrentLine = br.readLine()) != null) {
				refreshHash();
				soma = 0;
				saida = "";
				importancia = "";
				// System.out.println(sCurrentLine);
				String[] attr = sCurrentLine.split(",");
				if (attr[57].equals("0")) {
					importancia = "1";
				} else {
					Iterator it = (Iterator) hash.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry) it.next();
						if (!attr[Integer.parseInt(pair.getKey() + "")]
								.equals("0")) {
							soma += Integer.parseInt(pair.getValue() + "");
						}
						it.remove();
					}
				}
				writer.println(sCurrentLine + "," +directs(importancia(soma)) + "," + importancia(soma));

			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (writer != null)
					writer.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
