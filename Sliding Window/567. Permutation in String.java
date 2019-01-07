// Given a string s, you are allowed to convert it to a palindrome by 
//adding characters in front of it. Find and return the shortest palindrome 
//you can find by performing this transformation.
    
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
