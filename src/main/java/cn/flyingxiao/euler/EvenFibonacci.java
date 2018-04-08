package cn.flyingxiao.euler;

public class EvenFibonacci {

	public static void main(String[] args) {
		
		
		System.out.println( "sum : " + evenFibSum());
	}
	
	private static int evenFibSum() {
		int sum = 0;
		
		int a = 1;
		int b = 1;
		
		while (a <= 4000000) {
			if (a % 2 == 0) {
				sum += a;
			}
			if (b % 2 == 0 && b <= 4000000) {
				sum += b;
			}
			a = a + b;
			b = a + b;
		}
		
		return sum;
	}
	
	private static int evenFibSum1() {
		int sum = 0;
		
		int a = 1;
		int b = 2;
		
		while (a <= 4000000) {
			if (a % 2 == 0) {
				sum += a;
			}
			if (b % 2 == 0 && b <= 4000000) {
				sum += b;
			}
			a = a + b;
			b = a + b;
		}
		
		return sum;
	}

}
