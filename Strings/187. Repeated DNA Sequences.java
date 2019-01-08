// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
// for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify 
// repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) 
// that occur more than once in a DNA molecule.
    
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        HashSet<String> set = new HashSet<String>();
        HashSet<String> res = new HashSet<String>();
        
        
        for(int i=0;i+9<s.length();i++){
            String temp = s.substring(i, i+10);
            if(set.contains(temp)){
                res.add(temp);
            }
            else
                set.add(temp);
        }
        List<String> list = new ArrayList<>(res);
        
        return list;
    }
}
