package Banhmy;

public class Producer extends Thread{
long index=1;
Store store=null;

public Producer(Store s) {
	store=s;
}
public void run() {
	
	while(true) {
		try {
			boolean result=store.put(index);
			if(result==true) {
				System.out.println("** Producer "+(index++)+" is made.");
			}else {
			System.out.println("Store is full");
			}
		} catch (Exception e) {
		}
	}
}
}
