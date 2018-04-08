package cn.flyingxiao.leetcode;

import java.util.BitSet;

public class CountPrimes {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		System.out.println(s.countPrimes(2)); //0
		System.out.println(s.countPrimes(3)); //1
		System.out.println(s.countPrimes(4)); //2
		System.out.println(s.countPrimes(20)); //8
		System.out.println(s.countPrimes(30)); //10
		System.out.println(s.countPrimes(34)); //11
		System.out.println(s.countPrimes(36)); //11
		System.out.println(s.countPrimes(40)); //12
		System.out.println(s.countPrimes(50)); //15
		System.out.println(s.countPrimes(60)); //17
		System.out.println(s.countPrimes(70)); //19
		System.out.println(s.countPrimes(80)); //22
		System.out.println(s.countPrimes(90)); //24
		System.out.println(s.countPrimes(100)); //25
		System.out.println(s.countPrimes(1500000)); //114155
	}
	
	static class Solution {
		
		/**
		 * ^_^passed^_^
		 */
		public int countPrimes(int n) {
			if (n <= 2) {
				return 0;
			}
			
			int count = 0;
			boolean[] mark = new boolean[n];
			mark[0] = true;
			
			for (int i = 2; i < n; i++) {
				//2 is prime number, its index is 1
				if (!mark[i - 1]) {
					count++;
					//set all the multiple of i to true
					for (int j = i * 2; j < n; j += i) {
						mark[j - 1] = true;
					}
				}
			}
			
			return count;
		}
		
		/**
		 * ^_^passed^_^
		 */
		public int countPrimes3(int n) {
			BitSet bs = new BitSet(n);
			bs.set(0);bs.set(1);
			
			int ind = 0;
			int count = 0;
			
			while(ind < n) {
				ind = bs.nextClearBit(ind + 1);
				if (ind >= n) {
					return count;
				}
				count++;
				for (int i = 2 * ind; i < n; i += ind) {
					bs.set(i);
				}
			}
			
			return count;
		}
		
		/**
		 * time limited
		 * -_- fail -_-
		 */
		public int countPrimes2(int n) {
	    	int result = 0;
	    	
	    	if (n <= 1) {
	    		return 0;
	    	}
	    	
    		boolean exist = false;
    		for (int i = 1; i <= n; i += 2) {
    			for (int j = 2; j <= Math.sqrt(i); j++) {
    				if (i % j == 0) {
    					exist = true;
    					break;
    				}
    			}
    			if (!exist) {
    				result++;
    			}
    			exist = false;
    		}
    		return result;
	    }
		
		//wrong -_-
	    public int countPrimes1(int n) {
	    	int result = 0;
	    	
	    	if (n <= 1) {
	    		return 0;
	    	}
	    	
	    	if (n <= 35) {
	    		boolean exist = false;
	    		for (int i = 2; i <= n; i++) {
	    			for (int j = 2; j < i; j++) {
	    				if (i % j == 0) {
	    					exist = true;
	    					break;
	    				}
	    			}
	    			if (!exist) {
	    				result++;
	    			}
	    			exist = false;
	    		}
	    		return result;
	    	}
	    	
	    	int num_2 = countDiviedBy(n, 2);
	    	int num_3 = countDiviedBy(n, 3);
	    	int num_5 = countDiviedBy(n, 5);
	    	int num_7 = countDiviedBy(n, 7);
	    	
	    	int num_6 = countDiviedBy(n, 6);
	    	int num_10 = countDiviedBy(n, 10);
	    	int num_14 = countDiviedBy(n, 14);
	    	int num_15 = countDiviedBy(n, 15);
	    	int num_21 = countDiviedBy(n, 21);
	    	int num_35 = countDiviedBy(n, 35);
	    	
	        return  n - (num_2 + num_3 + num_5 + num_7 - num_6 - num_10 - num_14 - num_15 - num_21 - num_35) + 3;
	    }
	    
	    private int countDiviedBy(int n, int d) {
	    	return n / d;
	    }
	}

}
