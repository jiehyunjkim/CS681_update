package edu.umb.cs681.hw13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {
	private ReentrantLock lock = new ReentrantLock();
	private double balance = 0;
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();
	
	public void withdraw(double amount){
		lock.lock();
		try {
			while(balance < 0){
				sufficientFundsCondition.await();
			}
			belowUpperLimitFundsCondition.signalAll();
			balance -= amount;
			
		}catch (Exception e) {
			System.out.println(e);
		}
		lock.unlock(); 
	}
	
	public void deposit(double amount){
		lock.lock();
		try {
			while(balance >= 300){
				// waiting for the balance to go below 300.
				belowUpperLimitFundsCondition.await(); 
			}
			sufficientFundsCondition.signalAll();
			balance += amount;
		}catch (Exception e) {
			System.out.println(e);
		}
		lock.unlock(); 
	}
	
}
