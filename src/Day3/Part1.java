package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day3\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);

		int gamma = 0;
		int epsilon = 0;
		for (int i=0; i<arr[0].length(); i++) {
			int counter1 = 0;
			int counter0 = 0;
			for (int j=0; j<arr.length; j++) {
				if (arr[j].charAt(i) == '1') {
					counter1++;
				} else {
					counter0++;
				}
			}
			
			if (counter1>counter0) {
				gamma = (gamma << 1) + 1;
				epsilon = epsilon << 1;
			} else {
				gamma = gamma << 1;
				epsilon = (epsilon << 1) + 1;
			}
		}
		
		System.out.println(gamma * epsilon);
		
	}

}
