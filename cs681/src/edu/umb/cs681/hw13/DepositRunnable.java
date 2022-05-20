package edu.umb.cs681.hw13;

import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable {
	private ThreadSafeBankAccount2 account = null;
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
		
	public DepositRunnable(ThreadSafeBankAccount2 account) {
		this.account = account;
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}
	
	public void run() {
		while (true) {
			lock.lock();
			try{
				if (done) {
					System.out.println("You deposit money.");
					break;
				}
			} finally {
				lock.unlock();
			}
			account.withdraw(300);
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
				continue;
			}
		}
	}
}
