package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

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

		// oxygen generator rating
		int oxygen = 0;
		List<String> dataTemp = new ArrayList<>(data);
		for (int i=0; i<dataTemp.get(0).length(); i++) {
			int counter1 = 0;
			int counter0 = 0;
			for (int j=0; j<dataTemp.size(); j++) {
				if (dataTemp.get(j).charAt(i) == '1') {
					counter1++;
				} else {
					counter0++;
				}
			}
			
			if ((counter1 > counter0) || (counter1 == counter0)) { //удаляем тех у кого 0 в начале
				deleteElements(dataTemp, i, '0');
			} else { //удаляем тех у кого 1 в начале
				deleteElements(dataTemp, i, '1');
			}
			
			if (dataTemp.size() == 1) {
				System.out.println(dataTemp.get(0));
				oxygen = Integer.parseInt(dataTemp.get(0), 2);
				break;
			}
		}
		
		// CO2 scrubber rating
		int co2 = 0;
		dataTemp = new ArrayList<>(data);
		for (int i=0; i<dataTemp.get(0).length(); i++) {
			int counter1 = 0;
			int counter0 = 0;
			for (int j=0; j<dataTemp.size(); j++) {
				if (dataTemp.get(j).charAt(i) == '1') {
					counter1++;
				} else {
					counter0++;
				}
			}
			
			if (counter1 < counter0) { //удаляем тех у кого 0 в начале
				deleteElements(dataTemp, i,'0');
			} else { //удаляем тех у кого 1 в начале
				deleteElements(dataTemp, i, '1');
			}
			
			if (dataTemp.size() == 1) {
				System.out.println(dataTemp.get(0));
				co2 = Integer.parseInt(dataTemp.get(0), 2);
				break;
			}
		}
		
		System.out.println(co2 * oxygen);
		
	}
	
	private static void deleteElements(List<String> dataTemp, int i, char digit) {
		List<Integer> indexsForDelete = new ArrayList<>();
		for (int j=0; j<dataTemp.size(); j++) {
			if (dataTemp.get(j).charAt(i) == digit) {
				indexsForDelete.add(j);
			}
		}
		
		for (int j=indexsForDelete.size()-1; j>=0; j--) {
			int index = indexsForDelete.get(j);
			dataTemp.remove(index);
		}
	}

}
