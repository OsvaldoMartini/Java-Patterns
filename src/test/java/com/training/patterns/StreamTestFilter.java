package com.training.patterns;

import java.util.List;
import java.util.NoSuchElementException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StreamTestFilter {
	private List<Integer> list;

	@Test
	public void Test_Qty_Maz_List_Integer() {
		Integer max = list.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);

		System.out.println("max " + max);

		Long count = list.stream().filter(i -> i.toString().equals(max.toString())).count();

		System.out.println("Total " + count);

	}

	@BeforeMethod
	public void setUp() {
		this.list = utilities.CSV.getIntegers("D:\\Projects\\Workspace_2021_3\\Java-Patterns\\Input\\input04.csv");
	}

}
