class Pair{
    char ch;
    int count;
    public Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> max = new PriorityQueue<>((x,y)->Integer.compare(y.count,x.count));
        if(a>0) max.offer(new Pair(a,'a'));
        if(b>0) max.offer(new Pair(b,'b'));
        if(c>0) max.offer(new Pair(c,'c'));

        StringBuilder res = new StringBuilder();
        while(!max.isEmpty()){
            Pair largest = max.poll();
            int n = res.length();

            if(n >= 2 &&
                res.charAt(n - 1) == largest.ch &&
                res.charAt(n - 2) == largest.ch ){
                if(!max.isEmpty()){
                    Pair alt = max.poll();
                    res.append(alt.ch);
                    alt.count -=1;
                    if(alt.count!=0){
                        max.offer(alt);
                    }
                }
                else{
                    return res.toString();
                }
                

            }
            else{
                res.append(largest.ch);
                largest.count-=1;

            }
            if(largest.count!=0){
                    max.offer(largest);
                }

        }
        return res.toString();
    }

}
            //while(true){
        //     if((a>0)&& (((a>=b && a>=c) && s_a<2)
        //     ||(s_b==2 && (a>=c && a<=b))
        //     ||(s_c==2 &&(a>=b && a<=c)))){
        //         sb.append('a');
        //         s_a++;
        //         a-=1;

        //         s_b=0;
        //         s_c=0;
        //     }
        //     else if((b>0) && (((b>=a && b>=c) && s_b<2)
        //     ||(s_a==2 && (b>=c && b<=a))
        //     ||(s_c==2 &&(b>=a && b<=c)))){
        //         sb.append('b');
        //         s_b++;
        //         b-=1;

        //         s_a=0;
        //         s_c=0;
        //     }
        //     else if((c>0) && (((c>=b && c>=a) && s_c<2)
        //     ||(s_b==2 && (c>=a && c<=b))
        //     ||(s_a==2 &&(c>=b && c<=a)))){
        //         sb.append('c');
        //         s_c++;
        //         c-=1;

        //         s_b=0;
        //         s_a=0;
        //     }
        //     else{
        //         break;
        //     }
        // }