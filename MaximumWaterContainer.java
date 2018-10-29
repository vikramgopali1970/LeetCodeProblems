package LeetProblem;

public class MaximumWaterContainer {

    public int getMaxWaterVolume(int[] arr){
        return this.getMaxWaterVolumeHelper(arr,0,1,0);
    }

    private int getMaxWaterVolumeHelper(int[] arr,int leftWall, int rightwall, int maxVolume) {
        if(rightwall >=arr.length){
            return 0;
        }
        maxVolume = (maxVolume > getMaxWaterVolumeHelper(arr,leftWall,rightwall+1,maxVolume))?maxVolume:getMaxWaterVolumeHelper(arr,leftWall,rightwall+1,maxVolume);
        int ignore = Math.min(arr[leftWall],arr[rightwall])*(rightwall-leftWall);
        maxVolume = (maxVolume > getMaxWaterVolumeHelper(arr,rightwall,rightwall+1,maxVolume))?maxVolume:getMaxWaterVolumeHelper(arr,rightwall,rightwall+1,maxVolume);
        int include = Math.min(arr[leftWall],arr[rightwall])*(rightwall-leftWall);;
        int stackMax = (ignore > include)?ignore:include;
        maxVolume = (maxVolume > stackMax)?maxVolume:stackMax;
//        System.out.println("left values are "+arr[leftWall]+" right values are "+arr[rightwall]+" maxValue is "+stackMax+" "+maxVolume);
        return maxVolume;
    }


}
