package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class RequestHandler implements Runnable {
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;

	public void setDone()
	{
		lock.lock();
		try {
			done = true;
			
		} finally {
			lock.unlock();
		}
		
	}
	
	public void run() {
		String[] files = {"a.html", "b.html", "c.html", "d.html"};
		
		while(true) {
			lock.lock();
			try {
				if(done) {
					System.out.println("It is done");
					break;
				}
				
				int num = new Random().nextInt(files.length);
				Path path = FileSystems.getDefault().getPath(".", files[num]);				
				
				AccessCounter.getInstance().increment(path);
				AccessCounter.getInstance().getCount(path);
				
			} finally {
				lock.unlock();
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}

	}
	
	public static void main(String[] args) {
		RequestHandler rh1  = new RequestHandler();
		RequestHandler rh2  = new RequestHandler();
		RequestHandler rh3  = new RequestHandler();
		RequestHandler rh4  = new RequestHandler();
		RequestHandler rh5  = new RequestHandler();
		RequestHandler rh6  = new RequestHandler();
		RequestHandler rh7  = new RequestHandler();
		RequestHandler rh8  = new RequestHandler();
		RequestHandler rh9  = new RequestHandler();		
		RequestHandler rh10 = new RequestHandler();
	
		
		Thread Th1  = new Thread(rh1);
		Thread Th2  = new Thread(rh2);
		Thread Th3  = new Thread(rh3);
		Thread Th4  = new Thread(rh4);
		Thread Th5  = new Thread(rh5);
		Thread Th6  = new Thread(rh6);
		Thread Th7  = new Thread(rh7);
		Thread Th8  = new Thread(rh8);
		Thread Th9  = new Thread(rh9);
		Thread Th10 = new Thread(rh10);
		
		
		Th1.start();
		Th2.start();
		Th3.start();
		Th4.start();
		Th5.start();
		Th6.start();
		Th7.start();
		Th8.start();
		Th9.start();
		Th10.start();
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		rh1.setDone();
		rh2.setDone();
		rh3.setDone();
		rh4.setDone();
		rh5.setDone();
		rh6.setDone();
		rh7.setDone();
		rh8.setDone();
		rh9.setDone();
		rh10.setDone();
		
		
		Th1.interrupt();
		Th2.interrupt();
		Th3.interrupt();
		Th4.interrupt();
		Th5.interrupt();
		Th6.interrupt();
		Th7.interrupt();
		Th8.interrupt();
		Th9.interrupt();
		Th10.interrupt();
		
		
		try {
			Th1.join();
			Th2.join();
			Th3.join();
			Th4.join();
			Th5.join();
			Th6.join();
			Th7.join();
			Th8.join();
			Th9.join();
			Th10.join();
			
		} catch (InterruptedException e) {
			System.out.println(e);
		}   		
	}	

	
}
