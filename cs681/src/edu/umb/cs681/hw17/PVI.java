package edu.umb.cs681.hw17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class PVI {
	static List<Covid> covid = Arrays.asList(
			new Covid(15578, 209),
			new Covid(55218, 668));
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new FileReader("files/data.csv"));
			
			double sumofCases = covid.stream().map(Covid::getCases)
					.reduce(0, (result, cases) -> {
	                    ++cases/result;
					});
			
			System.out.println("Sum of cases: "+sumofCases);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static class Covid {
		private int cases;
		private int death;
		
		public Covid(int cases, int death) {
			this.cases = cases;
			this.death = death;
		} 
		
		public int getCases() {
			return cases;
		}
		
		public int getDeath() {
			return death;
		}
	}
}
