class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int p1=0,p2=heights.length-1;
        while(p1<p2){
            int min=Math.min(heights[p1],heights[p2]);
            max=Math.max(max,min*(p2-p1));
            if(heights[p1]>=heights[p2]){
                p2--;
            }
            else{
                p1++;
            }
        }
        return max;
    }
}
