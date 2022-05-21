package edu.umb.cs681.hw18;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {
	
	public RunnablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend);
		if (from >= 2 && to >= from) {
			this.from = from;
			this.to = to;
		} else {
			throw new RuntimeException(
				"from must be >= 2, and to must be >= from." + "from==" + from + " to==" + to);
		}
	}
	
	protected boolean isEven(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}

	public void generatePrimeFactors() {
		long divisor = from;
	    while( dividend != 1 && divisor <= to ){
	    	if( divisor > 2 && isEven(divisor)) {
	    		divisor++;
	    		continue;
	    	}
		    if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    }else {
		    	if(divisor==2){ divisor++; }
		    	else{ divisor += 2; }
		    }
		}
	}
	
	public void run() {
		generatePrimeFactors();
		System.out.println("Thread #" + Thread.currentThread().getId() + " generated " + factors);
	}

	public static void main(String[] args) {
		int num = 75;
		
		ExecutorService e = Executors.newFixedThreadPool(2);
        e.execute(new RunnablePrimeFactorizer(num, 2, (long) Math.sqrt(num) / 2));
        e.execute(new RunnablePrimeFactorizer(num, 1 + (long) Math.sqrt(num) / 2, (long) Math.sqrt(num)));

        e.shutdown();
	}
}
