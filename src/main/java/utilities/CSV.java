package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSV {

	public static List<String[]> get(String fileName) {
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((testRow = br.readLine()) != null) {
				String[] line = testRow.split(",");
				data.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found" + fileName);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read" + fileName);
		}

		return data;

	}

	public static List<Integer> getIntegers(String fileName) {
		List<List<Integer>> data = new ArrayList<List<Integer>>();
		String testRow;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((testRow = br.readLine()) != null) {
				    List<Integer> x = Arrays.stream(testRow.split(","))
				            .map(Integer::parseInt)
				            .collect(Collectors.toList());
				    
				    data.add(x);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found" + fileName);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read" + fileName);
		}
		
		return data.get(0);

	}

}
