package cn.flyingxiao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author flyingxiao
 *
 */
public class LongestSubstringWRC {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(s.lengthOfLongestSubstring("bbbbb"));
		System.out.println(s.lengthOfLongestSubstring("abba"));
		System.out.println(s.lengthOfLongestSubstring("abcdefgaaaaaahijklmnopq"));
	}
	
	static class Solution {
		
		/**
		 * ^_^ passed ^_^
		 */
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			
			if (s == null || "".equals(s)) {
				return 0;
			}
			
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int length = 0;
			
			for (int i = 0; i < s.length(); i++) {
				//exist in the map, length >= i - map.get(s.codePointAt(i)) to solve such situation: abba
				//recompute max, and recompute length from the first occurence of the current letter
				if (map.containsKey(s.codePointAt(i)) && length >= i - map.get(s.codePointAt(i))) {
					max = Math.max(max, i - map.get(s.codePointAt(i)));
					length = i - map.get(s.codePointAt(i));
				} else {
				//not exist in the map, recompute length and max
					length++;
					max = Math.max(max, length);
				}
				map.put(s.codePointAt(i), i);
			}
			
	        return max;
	    }
		
		/**
		 * ^_^ passed ^_^
		 */
		public int lengthOfLongestSubstring1(String s) {
			String longest = "";
			
			if (s == null || "".equals(s)) {
				return 0;
			}
			
			char ch;
			int index;
			int length = s.length();
			String current = "";
			
			for (int i = 0; i < length; i++) {
				ch = s.charAt(i);
				index = current.indexOf(ch);
				
				if (index == -1) {  //no repeat char, put the current char to the pre-longest substring
					current += ch;
				} else {  //if found repeat char, delete substring before the first occurence char
					current = current.substring(index + 1) + ch;
				}
				if (current.length() > longest.length()) { //longest is the current longest substring real time
					longest = current;
				}
			}
			
	        return longest.length();
	    }
	}
}
