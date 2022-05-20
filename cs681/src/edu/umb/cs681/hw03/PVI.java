package edu.umb.cs681.hw03;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class PVI {
	/*public static void main(String[] args) {
	       Path path = Path.of("files/data.csv");
	       try (Stream<String> lines = Files.lines(path);) {
	    	   while(path.hasNext()) {
					System.out.println(path.next());
	    	   }
	       }
	       catch (IOException e) {
	           e.printStackTrace();
	       }
	}*/
	static List<Covid> covid = Arrays.asList(
			new Covid(15578, 209),
			new Covid(55218, 668));
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new FileReader("files/data.csv"));
			/*while(sc.hasNext()) {
				System.out.println(sc.next());
			}*/
			
			double sumofCases = covid.stream().map(Covid::getCases).
					reduce(0, Integer::sum);
			
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
