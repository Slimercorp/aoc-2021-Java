package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day3\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		List<String> data = new ArrayList<>();
		
		while (scan.hasNextLine()) {
			data.add(scan.nextLine());
		}
		
		scan.close();

		String gamma = "";
		String epsilon = "";
		for (int i=0; i<data.get(0).length(); i++) {
			int counter1 = 0;
			int counter0 = 0;
			for (int j=0; j<data.size(); j++) {
				if (data.get(j).charAt(i) == '1') {
					counter1++;
				} else {
					counter0++;
				}
			}
			
			if (counter1>counter0) {
				gamma = gamma + "1";
				epsilon = epsilon + "0";
			} else {
				gamma = gamma + "0";
				epsilon = epsilon + "1";
			}
		}
		
		int gammaDec = Integer.parseInt(gamma, 2);
		int epsilonDec = Integer.parseInt(epsilon, 2);
		
		System.out.println(gammaDec * epsilonDec);
		
	}

}
