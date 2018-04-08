package cn.flyingxiao.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * @author flyingxiao
 *
 */
public class MedianOfTwoArrays {

	public static void main(String[] args) {
		
		Solution s = new Solution();
//		int[] nums1 = {1, 2, 3, 4, 5, 6};
//		int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
//		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //4
		
//		int[] nums1 = {1, 2, 3, 4, 5, 6};
//		int[] nums2 = {7, 8, 9, 10, 11, 12};
//		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //6.5
		
		int[] nums1 = {1, 2, 3, 4, 5, 6, 8};
		int[] nums2 = {7, 8, 9, 10, 11, 12};
		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //7
		
//		int[] nums1 = {};
//		int[] nums2 = {};
//		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //0
		
//		int[] nums1 = {2, 4, 5, 6};
//		int[] nums2 = {};
//		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //4.5
		
//		int[] nums1 = {1, 2, 3, 4, 5};
//		int[] nums2 = {};
//		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //3
		
//		int[] nums1 = {};
//		int[] nums2 = {2, 4, 5, 6};
//		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //4.5
		
//		int[] nums1 = {};
//		int[] nums2 = {2, 4, 5};
//		System.out.println(s.findMedianSortedArrays(nums1, nums2)); //4
	}
	
	static class Solution {
		
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int m = nums1.length;
	    	int n = nums2.length;
	    	
	    	if (m == 0 && n == 0) {
	    		return 0;
	    	}
	    	
	    	if (m > n) {
	    		return findMedianSortedArrays(nums2, nums1);
	    	}
	    	
	    	int left = Math.max(1, (n + m) / 2 - n);
	    	int right = Math.min(m, (n + m) / 2);
	    	
	    	for (int i = 0; i <= m; i++) {
	    		int j = (m + n + 1) / 2 - i;
	    		if (i == 0) {
	    			if (nums2[j - 1] <= nums1[i]) {
		    			if((m + n) % 2 == 0) {
		    				return nums2[j - 1] + Math.min(nums1[i], nums2[j]) / 2.0;
		    			} else {
		    				return nums2[j - 1];
		    			}
		    		}
	    			continue;
	    		} else if (j == 0) {
	    			if (nums1[i - 1] <= nums2[0]) {
	    				if((m + n) % 2 == 0) {
		    				return nums1[i - 1] + Math.min(nums1[i], nums2[0]) / 2.0;
		    			} else {
		    				return nums1[i - 1];
		    			}
	    			}
	    			continue;
	    		} else if (i == m - 1) {
	    			
	    		}
	    		if (nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]) {
	    			if((m + n) % 2 == 0) {
	    				return Math.max(nums1[i - 1], nums2[j - 1]) + Math.min(nums1[i], nums2[j]) / 2.0;
	    			} else {
	    				return Math.max(nums1[i - 1], nums2[j - 1]);
	    			}
	    		}
	    	}
	    	
			return 0;
	    }
		
		/**
		 * ^_^passed^_^
		 * O(m+n)
		 */
	    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
	    	int len1 = nums1.length;
	    	int len2 = nums2.length;
	    	
	    	if (len1 == 0 && len2 == 0) {
	    		return 0;
	    	} else if (len2 == 0) {
	    		if (len1 % 2 == 0) {
	    			return (double)(nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2;
	    		} else {
	    			return nums1[len1 / 2];
	    		}
	    	} else if (len1 == 0) {
	    		if (len2 % 2 == 0) {
	    			return (double)(nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2;
	    		} else {
	    			return nums2[len2 / 2];
	    		}
	    	}
	    	
	    	int[] merge = new int[len1 + len2];
	    	
	    	for (int i = 0, j = 0; i < len1  || j < len2;) {
	    		if (i < len1 && j < len2) {
	    			if (nums1[i] <= nums2[j]) {
	    				merge[i + j] = nums1[i];
	    				i++;
	    			} else {
	    				merge[i + j] = nums2[j];
	    				j++;
	    			}
	    		} else if (i < len1) {
	    			merge[i + j] = nums1[i];
	    			i++;
	    		} else if (j < len2) {
	    			merge[i + j] = nums2[j];
	    			j++;
	    		}
	    	}
	    	
	    	if ((len1 + len2) % 2 == 0) {
    			return (double)(merge[(len1 + len2) / 2 - 1] + merge[(len1 + len2) / 2]) / 2;
    		} else {
    			return merge[(len1 + len2) / 2];
    		}
	    }
	}

}
