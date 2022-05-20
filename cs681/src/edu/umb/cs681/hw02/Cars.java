package edu.umb.cs681.hw02;

import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.*;

public class Cars {
	
	static List<Car> cars = Arrays.asList(
			new Car(20000, 2017, 25000),
			new Car(30000, 2019, 38000),
			new Car(1000, 2022, 99000),
			new Car(55000, 2013, 12000)
			);
	
	public static void main(String[] args) {
		Car carvar = cars.stream().min(Comparator.comparing(Car::getPrice)).get();
		System.out.println("Minimum Price"+carvar);
		
		Car carvar1 = cars.stream().max(Comparator.comparing(Car::getPrice)).get();
		System.out.println("Maximum Price:"+carvar1);
		
		/*double averagePrice = cars.stream().map(Car::getPrice).
				reduce(0, Integer::sum);*/
		double averagePrice = cars.stream().mapToDouble(Car::getPrice).average().orElse(Double.NaN);
		/*int[] result = new int[2];
		int[] prices = new int[] {25000, 38000, 99000, 12000};
		for(Integer price: prices){result = accumulate(result, price);}
		
		Integer averagePrice = cars.stream().map(car -> car.getPrice()).
				reduce(new int[2], (result, price)->{return;}, 
						(finalResult, intermediateResult)->finalResult)[1];*/
		System.out.println("Average Price:"+ averagePrice);
	}
	
	private static int[] accumulate(int[] result, Integer price) {
		
		
		return null;
	}

	static class Car {
		private int mileage;
		private int year;
		private int price;
		
		private int dominationCount;
		private int count;
		
		public Car(int mileage, int year, int price) {
			this.mileage = mileage;
			this.year = year;
			this.price = price;
		} 
		
		public int getPrice() {
			return price;
		}
		
		public int getYear() {
			return year;
		}
		
		public int getMileage() {
			return mileage;
		}
		
		public int getDominationCount() {
			return dominationCount;
		}
		
		public void setDominationCount(int cnt) {
			this.count = cnt;
		}
			
		public class PriceComparator implements Comparator<Car>{
				public int compare(Car car1, Car car2){
					return car2.getPrice() - car1.getPrice();
			}
		}
		
		public class YearComparator implements Comparator<Car>{
				public int compare(Car car1, Car car2){
					return car1.getYear() - car2.getYear();
			}
		}
		
		public class MileageComparator implements Comparator<Car>{
			public int compare(Car car1, Car car2){
				return car2.getMileage() - car1.getMileage();
			}
		}
		
		public class ParetoComparator implements Comparator<Car>{
			public int compare(Car car1, Car car2){
				return car2.getDominationCount() - car1.getDominationCount();
			}
		}
		
		@Override
        public String toString() {
            return "Car: " +
                    "mileage='" + mileage + '\'' +
                    ", year=" + year + '\'' +
                    ", price=" + price;
        }
	}
}
