package edu.umb.cs681.hw14;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	HashMap<java.nio.file.Path, AtomicInteger> hashMap = new HashMap<java.nio.file.Path, AtomicInteger>();
	
	private static ReentrantLock staticLock = new ReentrantLock();
	private static AccessCounter instance = null;
	
	
	public static AccessCounter getInstance()
	{
		staticLock.lock();
		if( instance == null ){
			instance = new AccessCounter();
		}else{
			staticLock.unlock();
					
		}
		return instance;
	}

	public void increment(java.nio.file.Path path){
		hashMap.compute(path, (java.nio.file.Path k, AtomicInteger a) -> {
			if( a == null ){
				return new AtomicInteger(1);
			}else{
				return new AtomicInteger(a.incrementAndGet());
						
			}
		});
		
	}
	
	public int getCount(java.nio.file.Path path){
		return hashMap.compute(path, (java.nio.file.Path k, AtomicInteger a) -> {
			if(a == null) {
				return new AtomicInteger(0);
			} else {
				return a;
			}
		}).get();
	}
}
