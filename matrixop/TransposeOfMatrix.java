package matrix_calculator.matrixop;
import java.util.Arrays;

public class TransposeOfMatrix {
    public static float[][] transpose(float[][] arr,int row,int col){
        float[][] temp = new float[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                temp[i][j] = arr[j][i];
            }
        }
        printMatrix(temp);
        return  temp;
    }

    public static void printMatrix(float[][] arr){
        for(float[] element: arr){
            System.out.println(Arrays.toString(element));
        }

    }
}
