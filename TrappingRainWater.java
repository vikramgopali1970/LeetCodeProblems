package LeetProblem;

public class TrappingRainWater {

    public int trap(int[] height){
        int left = 0, right = height.length-1;
        int lmax = 0, rmax = 0, res = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > lmax){
                    lmax = height[left++];
                }else{
                    res += lmax - height[left++];
                }
            }else{
                if(height[right] > rmax){
                    rmax = height[right--];
                }else{
                    res += rmax - height[right];
                }
            }
        }
        return res;
    }
}
