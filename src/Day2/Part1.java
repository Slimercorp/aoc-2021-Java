package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day2\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int hor = 0;
		int depth = 0;
		for (int i=0; i<arr.length; i++) {
			String[] splitted = arr[i].split(" ");
			
			int value = Integer.parseInt(splitted[1]);
			switch (splitted[0]) {
				case "forward" -> hor += value;
				case "down" -> depth += value;
				case "up" -> depth -= value;
				default -> {
					System.out.println("error!");
					return;
				}
			}
		}
		
		System.out.println(hor * depth);
	}

}