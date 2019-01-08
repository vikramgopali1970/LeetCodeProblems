package LeetProblem;

public class UTF8Validation {
    private String[] bData;

    public void init(int[] data){
        this.bData = new String[data.length];
        for(int i=0;i<data.length;i++){
            this.bData[i] = String.format("%08d",Integer.parseInt(Integer.toString(data[i],2)));
        }
    }

    public boolean validUtf8(int[] data) {
        this.init(data);
        int b = 0;
        for(int i=0;i<this.bData.length;i++){
            String str = this.bData[i];
            if(b == 0 && str.substring(0,1).equals("0")){
                //1 byte
            }else if(b == 0 && str.substring(0,3).equals("110")){
                //2 bytes
                b=1;
            }else if(b == 0 && str.substring(0,4).equals("1110")){
                //3 byte
                b=2;
            }else if(b == 0 && str.substring(0,5).equals("11110")){
                //4 byte
                b=3;
            }else if(b!= 0){
                if(!str.substring(0,2).equals("10")){
                    return false;
                }else{
                    b--;
                }
            }else{
                return false;
            }
        }
        return b==0;
    }

}
