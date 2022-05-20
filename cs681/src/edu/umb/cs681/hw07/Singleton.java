package edu.umb.cs681.hw07;

public class Singleton {
	private Singleton(){};
	private static volatile Singleton instance;
	
	// Factory method to return the singleton instance
	public static Singleton getInstance(){
		if(instance==null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
