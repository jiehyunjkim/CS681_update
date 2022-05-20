package edu.umb.cs681.hw13;

public class Test {
	public static void main(String[] args) {
			
		ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
		WithdrawRunnable withdraw = new WithdrawRunnable(account);
		DepositRunnable deposit= new DepositRunnable(account);
		
		Thread[] threads = new Thread[20];
		
		Thread d1  = new Thread(deposit);	
        Thread w1  = new Thread(withdraw);
        Thread d2  = new Thread(deposit);	
        Thread w2  = new Thread(withdraw);
        Thread d3  = new Thread(deposit);	
        Thread w3  = new Thread(withdraw);
			
        d1.start();			
        w1.start();		
        d2.start();			
        w2.start();
        d3.start();			
        w3.start();		
					
		deposit.setDone();
		withdraw.setDone();
		
        d1.interrupt();		
        w1.interrupt();
        d2.interrupt();		
        w2.interrupt();
        d3.interrupt();		
        w3.interrupt();

		try {
			d1.join();
			d2.join();
			d3.join();
			
		} catch (InterruptedException e) {
			System.out.println(e);
		} 		
	}
	
}

