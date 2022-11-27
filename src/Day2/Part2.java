package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day2\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int hor = 0;
		int depth = 0;
		int aim = 0;
		for (int i=0; i<arr.length; i++) {
			String[] splitted = arr[i].split(" ");
			
			int value = Integer.parseInt(splitted[1]);
			switch (splitted[0]) {
				case "forward" -> {
					hor += value;
					depth += aim * value;
				}
				case "down" -> aim += value;
				case "up" -> aim -= value;
				default -> {
					System.out.println("error!");
					return;
				}
			}
					
		}
		
		System.out.println(hor * depth);
	}

}
