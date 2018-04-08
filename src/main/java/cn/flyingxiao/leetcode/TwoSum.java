package cn.flyingxiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * 
 * Output: index1=1, index2=2
 * 
 * @author flyingxiao
 * 
**/

public class TwoSum {
	public static void main(String[] args) {
//		int[] test = {2, 11, 15, 7, 0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88};
//		int target = 174;
		
		int[] test = {0,4,3,0};
		int target = 0;
		
		Solution s = new Solution();
		int[] result = s.twoSum(test, target);
		System.out.println("index1=" + result[0] + ", index2="  + result[1]);
		
	}
	
	static class Solution {
		
	    /**
	     * binary search & hashmap
	     * ^_^ passed ^_^
	     */
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int index1 = 0;
	    int index2 = 0;
		public int[] twoSum(int[] numbers, int target) {
	        int[] result = new int[2];
	        
	        binarySearch(numbers, 0, numbers.length - 1, target);
	        
	        result[0] = index1 > index2 ? index2 : index1;
	        result[1] = index1 > index2 ? index1 : index2;
	        return result;
	    }
		private void binarySearch(int[] numbers, int start, int end, int target) {
			if (end < start) {
	    		return;
	    	}
			int mid = start + (end - start + 1) / 2;
	    	if (map.get(target - numbers[mid]) != null) {
	    		index1 = map.get(target - numbers[mid]);
	    		index2 = mid + 1;
	    		return;
	    	} else {
	    		map.put(numbers[mid], mid + 1);
	    	}
	    	if (1 == end - start + 1) {
	    		return;
	    	}
	    	
	    	binarySearch(numbers, start, mid - 1, target);
	    	binarySearch(numbers, mid + 1, end, target);
		}
		
		/**
		 * traverse the map while put the element in hashmap
		 * -_- fail -_-
		 */
		public int[] twoSum4(int[] numbers, int target) {
	        int[] result = new int[2];
	        int index1 = 0;
	        int index2 = 0;
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < numbers.length; i++) {
	        	if (target < numbers[i]) {
	        		continue;
	        	}
	        	if (map.get(target - numbers[i]) != null) {
	        		index1 = map.get(target - numbers[i]);
	        		index2 = i + 1;
	        		break;
	        	} else {
	        		map.put(numbers[i], i + 1);
	        	}
	        }
	        
	        result[0] = index1;
	        result[1] = index2;
	        return result;
	    }
		
		/**
		 * O(n) time complex
		 * put the array element in hashmap, then traverse the map
		 * -_- fail -_-
		 */
		public int[] twoSum3(int[] numbers, int target) {
	        int[] result = new int[2];
	        int index1 = 0;
	        int index2 = 0;
	        Map<Integer, String> map = new HashMap<Integer, String>();
	        
	        for (int i = 0; i < numbers.length; i++) {
	        	if (map.get(numbers[i]) != null) {
	        		map.put(numbers[i], map.get(numbers[i]) + "," + String.valueOf(i + 1));
	        	} else {
	        		map.put(numbers[i], String.valueOf(i + 1));
	        	}
	        }
	        for (Integer first : map.keySet()) {
	        	if (map.get(target - first) != null) {
	        		if (first * 2 == target) {
	        			index1 = Integer.parseInt(map.get(first).split(",")[0]);
	        			index2 = Integer.parseInt(map.get(first).split(",")[1]);
	        		} else {
	        			index1 = Integer.parseInt(map.get(first));
	        			index2 = Integer.parseInt(map.get(target - first));
	        		}
	        		break;
	        	}
	    	}
	        
	        result[0] = index1;
	        result[1] = index2;
	        return result;
	    }
		
		/**
		 * if there are not duplicated numbers ...
		 * O(n) time complex
		 * -_- fail -_-
		 */
		public int[] twoSum2(int[] numbers, int target) {
	        int[] result = new int[2];
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < numbers.length; i++) {
	        	map.put(numbers[i], i + 1);
	        }
	        for (Integer first : map.keySet()) {
	        	if (map.get(target - first) != null && first * 2 != target) {
	        		if (map.get(first) > map.get(target - first)) {
	        			result[0] = map.get(target - first);
	        			result[1] = map.get(first);
	        		} else {
	        			result[0] = map.get(first);
	    				result[1] = map.get(target - first);
	        		}
	        		break;
	        	}
	    	}
	        
	        return result;
	    }
		
		/**
		 * O(nlog(n))
		 * -_- fail -_-
		 */
	    public int[] twoSum1(int[] numbers, int target) {
	        int[] result = new int[2];
	        
	        for (int i = 0; i < numbers.length - 1; i++) {
	        	for (int j = i + 1; j < numbers.length; j++) {
	        		if (numbers[i] + numbers[j] == target) {
	        				result[0] = i + 1;
	        				result[1] = j + 1;
	        				break;
	        		}
	        	}
	        }
	        
	        return result;
	    }
	}
}

