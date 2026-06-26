class Solution {
    public void helper(StringBuilder sb, int l , int r){
        while(l<r){
            char temp = sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;r--;
            
        }
    }
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int t =0;
        while(t<s.length()){
            sb.append(s.charAt(t));
            t++;
        }
        int start=0,end=0;
        while(end<=sb.length()){
            if(end==sb.length() || sb.charAt(end)==' '){
                helper(sb,start,end-1);
                end++;
                start=end;
            }
            else{end++;}
            
        }
        return sb.toString();
    }
}