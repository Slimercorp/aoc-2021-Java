package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
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
		
		int hor = 0;
		int depth = 0;
		int aim = 0;
		for (int i=0; i<data.size(); i++) {
			String[] splitted = data.get(i).split(" ");
			
			int value = Integer.parseInt(splitted[1]);
			switch (splitted[0]) {
				case "forward":
					hor += value;
					depth += aim * value;
					break;
				case "down":
					aim += value;
					break;
				case "up":
					aim -= value;
					break;
				default:
					System.out.println("error!");
					return;
			}
					
		}
		
		System.out.println(hor * depth);
		
		scan.close();
	}

}
