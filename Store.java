package Banhmy;

public class Store {
int max=10;
long []a;
int n;

public Store(){
	n=0;
	a=new long[max];
}

private  boolean emtpy() {
	return n==0;
}
private boolean full() {
	return n==max;
}

public synchronized boolean put(long x) {
	if(full()) {
		return false;
	}else {
		a[n++]=x;
	}
	try {
		Thread.sleep(500);
	} catch (Exception e) {	
	}
	return true;
}

public synchronized long get() {
	long result=0;
	if(!emtpy()) {
		result=a[0];
		for(int i=0;i<n-1;i++) {
			a[i]=a[i+1];
			n--;
		}
	}
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;	
}
}
