package matrix_calculator.rank;
import java.util.*;
public class RowOperations {
    public float getK(float[] r1, float[] r2){

        Map<Float,Integer> hp = new HashMap();
        float []k=new float[r1.length];

        for(int i=0,j=0;i<r1.length;i++,j++){  //try exception Handling
            if(r1[i]==0){
                j--;
            }
            else {
                k[j]=r2[i]/r1[i];

                // Hash mapping started to find most occurred k
                float key =k[j];
                if(hp.containsKey(key)){
                    int freq = hp.get(key);
                    freq++;
                    hp.put(key,freq);
                }
                else{
                    hp.put(key,1);
                }
            }
        }
        //to calculate most frequent k
        int max_count=0;
        float result=-1;

        for(Map.Entry<Float ,Integer> val : hp.entrySet()){
            if(max_count<val.getValue()){
                max_count=val.getValue();
                result=val.getKey();
            }
        }
        result=(max_count==1)?k[0]:result;
        System.out.println("k="+result);
       // p.add(new JLabel("K="+result));
        return result;
    }

    public void rowMinus(float[] r1,float[] r2,float m){
        for(int i=0;i<r1.length;i++){
            r2[i]-=m*r1[i];
        }
    }

    public float completeDiv(float[] r1,float[] r2){
        float prev=0,current=0;
        for(int i=0;i<r1.length;i++){
            if(r1[i]==0){
                continue;
            }
            else{
                if(r2[i]%r1[i]!=0){
                    return 0;
                }
                else{
                    current=r2[i]/r1[i];
                    prev=i==0?current:prev;
                    if(current!=prev){
                        return 0;
                    }
                }
            }
        }
        return current;
    }

    public int checkZeroRows(float[][] arr,int col){
        int check=0,i,j;
        for(i=0;i<arr.length;i++){
            for(j=0;j<col;j++){
                if(arr[i][j]!=0) {
                    check++;
                    break;
                }
            }
        }
        return check;
    }
}