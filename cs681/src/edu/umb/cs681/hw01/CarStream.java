package edu.umb.cs681.hw01;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.*;

public class CarStream {
	
	static List<Car> cars = Arrays.asList(
			new Car(20000, 2017, 25000),
			new Car(30000, 2019, 38000),
			new Car(1000, 2022, 99000),
			new Car(55000, 2013, 12000)
			);
	
	public static void main(String[] args) {
		List<Car> sortedList = cars.stream().sorted(Comparator.comparingInt(Car::getPrice))
				.collect(Collectors.toList());
		
		sortedList.forEach(System.out::println);
		
		List<Car> sortedList1 = cars.stream().sorted(Comparator.comparingInt(Car::getYear))
				.collect(Collectors.toList());
		
		sortedList.forEach(System.out::println);
		
		List<Car> sortedList2 = cars.stream().sorted(Comparator.comparingInt(Car::getMileage))
				.collect(Collectors.toList());
		
		sortedList.forEach(System.out::println);
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
            return "Car{" +
                    "mileage='" + mileage + '\'' +
                    ", year=" + year + '\'' +
                    ", price=" + price +
                    '}';
        }
	}
}
