package edu.umb.cs681.hw16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Cars {
	public static void main(String[] args) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(20000, 2017, 25000));
		cars.add(new Car(30000, 2019, 38000));
		cars.add(new Car(1000, 2022, 99000));
		cars.add(new Car(20000, 2017, 25000));
		cars.add(new Car(55000, 2013, 12000));
		
		cars.forEach((Car car) -> car.setDominationCount(cars));
		
		Integer minCar = cars.stream().parallel()
                .map((Car car) -> car.getPrice())
                .reduce(0, (result, price) -> {
                    if (result == 0) return price;
                    else if (price < result) return price;
                    else return result;
                });
		System.out.println("Min price: " + minCar);
		
		Integer maxCar = cars.stream().parallel()
                .map((Car car) -> car.getPrice())
                .reduce(0, (result, price) -> {
                    if (result == 0) return price;
                    else if (price > result) return price;
                    else return result;
                });
		System.out.println("Max price: " + maxCar);
		
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
			return this.price;
		}
		
		public int getYear() {
			return this.year;
		}
		
		public int getMileage() {
			return this.mileage;
		}
		
		public int getDominationCount() {
			return this.dominationCount;
		}
		
		public void setDominationCount(List<Car> cars) {
	        int count = 0;
	        for (Car car : cars) {
	            if (!car.equals(this)) {
	                int price = car.getPrice();
	                int year = car.getYear();
	                int mileage = car.getMileage();

	                if (this.getYear() >= year && this.getMileage() <= mileage && this.getPrice() <= price) {
	                    if (this.getYear() > year || this.getMileage() < mileage || this.getPrice() < price) {
	                        count++;
	                    }
	                }
	            }
	        }
	        this.dominationCount = count;
	    }
		
	}
}
