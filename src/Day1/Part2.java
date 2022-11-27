package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {

	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day1\\data.txt";

		final int[] arr = Files.readString(Path.of(path)).lines().mapToInt(Integer::parseInt).toArray();
	
		int counter = 0;
		for (int i=0; i<arr.length-3; i++) {
			final int sum1 = arr[i] + arr[i+1] + arr[i+2];
			final int sum2 = arr[i+1] + arr[i+2] + arr[i+3];
			
			if ((sum2 - sum1) > 0) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}

}
