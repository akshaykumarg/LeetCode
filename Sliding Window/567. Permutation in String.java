/*

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True

Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

*/

class Solution {
    public String shortestPalindrome(String s) {
       	int n = s.length();
        if(n==0) return "";
		int i=1;
		int start=0;
		for(i=1;i<n;i++) {
			if(palindrome(s, i))
				start=i;
		}
		
		String rev = find(s, start+1, n);
		return rev+s;
    }
    
    String find(String s, int start, int n) {
        StringBuilder str = new StringBuilder();
        for(int i=n-1;i>=start;i--)
            str.append(s.charAt(i));
        return str.toString();
	}
	
	boolean palindrome(String s, int last) {
		int i=0, j=last;
		
		while(i<j) {
			if(s.charAt(i++)!=s.charAt(j--))
				return false;
		}
		return true;
	}
}
