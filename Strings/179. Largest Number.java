class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            arr[i]=String.valueOf(nums[i]);
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                if(a.charAt(0)!=b.charAt(0)){
                    if(a.charAt(0)>b.charAt(0))
                        return -1;
                    else
                        return 1;
                }
                else{
                    String first = a+b;
                    String second = b+a;
                    int len=first.length(),i=0;
                    while(i<len){
                        if(first.charAt(i)==second.charAt(i)){
                            i++; continue;
                        }
                        if(first.charAt(i)>second.charAt(i))
                            return -1;
                        else
                            return 1;
                    }
                    
                }
                return 0;
            }
        });
        if(arr[0].equals("0")) return "0";
        
        StringBuilder result = new StringBuilder();
        
        for(String s:arr){
            result.append(s);
        }
        return result.toString();
    }
}
