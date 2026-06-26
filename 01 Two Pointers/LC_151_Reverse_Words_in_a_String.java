class Solution {
    public void helper(StringBuilder a , int start, int end){
        while(start<end){
            char temp = a.charAt(start);
            a.setCharAt(start,a.charAt(end));
            a.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        //trim
        //stringbuilder with no dup spaces
        //reverse tehe sb
        //reverse the words

        int i =0,
        j=s.length()-1;

        while(i<j){
            if(s.charAt(i)==' '){
                i++;
            }
            else{
                break;
            }
        }
        while(j>=0){
            if(s.charAt(j)==' '){
                j--;
            }
            else{break;}
        }
        StringBuilder sb = new StringBuilder();
        
        while(i<=j){
            if(s.charAt(i)!=' ') sb.append(s.charAt(i));
            else if(sb.length()>0 && sb.charAt(sb.length()-1)!=' ')sb.append(s.charAt(i));
            i++;
        }

        int l=0,
        r=sb.length()-1;

        while(l<r){
            char temp = sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;
            r--;
        }
        int start =0,
        end=0;
        while(start<sb.length()){
            while(end<sb.length()&&sb.charAt(end)!=' '){
                end++;
            }
            helper(sb,start,end-1);
            start=end+1;
            end = start;
        }
        return sb.toString();
    }
}