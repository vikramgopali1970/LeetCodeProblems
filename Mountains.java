package LeetProblem;

public class Mountains {

    public int mountains(int num){
        return this.mountainsRecursiveHelper(num,0,num);
    }

    private int mountainsRecursiveHelper(int num, int b, int remain){
        if(remain==0){
            if(b==0){
                return 1;
            }else{
                return 0;
            }
        }
        int res = 0;
        if( remain < num && b==0){
            res++;
        }

        res += this.mountainsRecursiveHelper(num,b+1,remain-1);
        if(b>0){
            res += this.mountainsRecursiveHelper(num,b-1,remain-1);
        }
        return res;
    }
}
