package matrix_calculator.basicop;


public class BasicOperations {

    public static float[][] addition(float[][] arr1,float[][] arr2){
        int r=arr1.length,c=arr1[0].length;
        float[][] arr=new float[r][c];
        for (int i = 0; i <r; i++) {
            for (int j = 0; j <c; j++) {
                arr[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        return arr;
    }
   public static float[][] subtraction(float[][] arr1,float[][] arr2)
    {
        int r=arr1.length,c=arr1[0].length;
        float[][] arr=new float[r][c];
        for (int i = 0; i <r; i++) {
            for (int j = 0; j <c; j++) {
                arr[i][j]=arr1[i][j]-arr2[i][j];
            }
        }
        return arr;
    }
   public static float[][] multiplication(float[][] arr1,float[][] arr2)
    {
        int r1=arr1.length,r2=arr2.length,c2=arr2[0].length;
                float[][] arr = new float[r1][c2];
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c2; j++) {
                        for (int k = 0; k < r2; k++) {
                            arr[i][j] += ((arr1[i][k]) * (arr2[k][j]));
                        }
                    }
                }
                return arr;
    }

    }

