package edu.umb.cs681.hw11;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	HashMap<java.nio.file.Path, Integer> hashMap = new HashMap<java.nio.file.Path, Integer>();
	
	private ReentrantLock unStaticLock = new ReentrantLock();
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
		unStaticLock.lock();
		if( hashMap.get(path) != null ){
			hashMap.put(path, hashMap.get(path)+1);
		}else{
			hashMap.put(path, 1);
					
		}
		unStaticLock.unlock();
	}
	
	public int getCount(java.nio.file.Path path){
		unStaticLock.lock();
		if( hashMap.get(path) != null ){
			return hashMap.get(path);
		}else{
			unStaticLock.unlock();		
			
		}
		return 0;
	} 
}
