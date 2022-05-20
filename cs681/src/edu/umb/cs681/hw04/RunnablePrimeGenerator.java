package edu.umb.cs681.hw04;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {
	
	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {
		RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(1, 100);
		RunnablePrimeGenerator gen2 = new RunnablePrimeGenerator(101, 200);
		Thread t1 = new Thread(gen1);
		Thread t2 = new Thread(gen2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		
		gen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		gen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
		
		long primeNum = gen1.getPrimes().size() + gen2.getPrimes().size();
		System.out.println("\n" + primeNum + " prime numbers are found in total.");
        

	}

}

/*
 * 
bash-3.2$ time edu.umb.cs681.hw04.RunnablePrimeGenerator 10000000000 1
real    0m0.009s

bash-3.2$ time edu.umb.cs681.hw04.RunnablePrimeGenerator 10000000000 2
real    0m0.008s

bash-3.2$ time edu.umb.cs681.hw04.RunnablePrimeGenerator 10000000000 4
real    0m0.008s

bash-3.2$ time edu.umb.cs681.hw04.RunnablePrimeGenerator 10000000000 8
real    0m0.008s

bash-3.2$ time edu.umb.cs681.hw04.RunnablePrimeGenerator 10000000000 16
real    0m0.003s

 * */
