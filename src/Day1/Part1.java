package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day1\\data.txt");
		Scanner scan;
		
		try {
			 scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File is not found");
			return;
		}
		
		List<Integer> data = new ArrayList<>();
		
		
		while (scan.hasNextInt()) {
			data.add(scan.nextInt());
		}
		
		int counter = 0;
		
		for (int i=1; i<data.size(); i++) {
			if ((data.get(i) - data.get(i-1)) > 0) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
		scan.close();
	}

}
