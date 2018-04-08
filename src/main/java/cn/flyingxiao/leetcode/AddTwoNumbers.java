package cn.flyingxiao.leetcode;

/**
 * Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *	Output: 7 -> 0 -> 8
 * @author flyingxiao
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l1_next_1 = new ListNode(4);
		ListNode l1_next_2 = new ListNode(9);
		l1_next_1.next = l1_next_2;
		l1.next = l1_next_1;
		
		ListNode l2 = new ListNode(5);
		ListNode l2_next_1 = new ListNode(6);
		ListNode l2_next_2 = new ListNode(4);
		l2_next_1.next = l2_next_2;
		l2.next = l2_next_1;
		
//		ListNode l1 = new ListNode(1);
//		
//		ListNode l2 = new ListNode(9);
//		ListNode l2_next_1 = new ListNode(9);
//		l2.next = l2_next_1;
		
		Solution s = new Solution();
		ListNode result = s.addTwoNumbers(l1, l2);
		
		do {
			System.out.println(result.val);
			result = result.next;
		}while (result != null);
	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	static class Solution {
		
		/**
		 * 
		 * ^_^ passed ^_^
		 */
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode result = null;
			ListNode next = null;
			
			if (l1 == null && l2 == null) {
				return result;
			}
			
			int add = 0;
			int doubledigit = 0;
			int beforedoubledigit = 0;
			do {
				add = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + beforedoubledigit;
				if (add >= 10) {
					add -= 10;
					doubledigit = 1;
				}
				
				if (result == null) {
					result = new ListNode(add);
					next = result;
				} else {
					next.next = new ListNode(add);
					next = next.next;
				}
				
				beforedoubledigit = doubledigit;
				doubledigit = 0;
				l1 = l1 == null ? null : l1.next;
				l2 = l2 == null ? null : l2.next;
			} while (l1 != null || l2 != null || beforedoubledigit != 0);
	        return result;
	    }
	}

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

