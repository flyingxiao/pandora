package cn.flyingxiao.euler;

import java.math.BigInteger;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author flyingxiao
 *
 */
public class Multiples3And5 {
	
	private static long target = 10000000000l;
	private static BigInteger big_target = new BigInteger("10000000000");

	public static void main(String[] args) {
		
		long start, end;
		
//		start = System.currentTimeMillis();
//		System.out.println(SumDivisableBy3And5());
//		end = System.currentTimeMillis();
//		System.out.println(end - start);
//		
//		start = System.currentTimeMillis();
//		System.out.println(SumDivisableBy1(3) + SumDivisableBy1(5) - SumDivisableBy1(15));
//		end = System.currentTimeMillis();
//		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		System.out.println(SumDivisableBy2(3) + SumDivisableBy2(5) - SumDivisableBy2(15));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		BigInteger b1 = SumDivisableBy(3);
		BigInteger b2 = SumDivisableBy(5);
		BigInteger b3 = SumDivisableBy(15);
		System.out.println(b1.add(b2).subtract(b3));
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	/**
	 * work even the target is very very big
	 */
	static BigInteger SumDivisableBy(int n) {
		BigInteger n_big = new BigInteger(String.valueOf(n));
		BigInteger biggest = big_target.subtract(BigInteger.ONE).divide(n_big); //(target - 1) / n
		BigInteger two = new BigInteger("2");
		
		BigInteger sum = n_big.multiply(BigInteger.ONE.add(biggest)).multiply(biggest).divide(two);
		
		return sum;
	}
	
	/**
	 * only work when sum is less than the MAX_VALUE
	 */
	static long SumDivisableBy2(int n) {
		
		long sum = 0;
		sum = n * (1 + (long)((target - 1) / n)) * ((long)((target - 1) / n)) / 2;
		
		return sum;
	}
	
	/**
	 * Brute-Force
	 */
	static long SumDivisableBy1(int n) {
		
		long sum = 0;
		
		for (int i = 1; i < target; i++) {
			if (i % n == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	/**
	 * Brute-Force
	 */
	static long SumDivisableBy3And5() {
		
		long sum = 0;
		
		for (int i = 1; i < target; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}

}
