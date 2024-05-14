package matrix_calculator.soln;
import java.util.*;
import matrix_calculator.matrixop.*;

public class CramSolution {
    public int soln(float mat[][], int r, int c,float[][] answer) {
        DeterminantOfMatrix ob = new DeterminantOfMatrix();
       // RankByDet robj = new RankByDet();

        System.out.println(r);
        System.out.println(c);
        float[][] coeffmat = new float[r][c - 1];

        fillByIgnore(coeffmat, mat, c - 1);

        for (float[] element : coeffmat) {
            System.out.println(Arrays.toString(element));
        }

        float D = ob.det(coeffmat, 0);
        System.out.println(D);

//        if (D == 0) {
//            return 0;
//        }
//        else {
            float[][] varmat = new float[r][c - 1];
            for (int i = 0; i < r; i++) {
                fillByIgnore(varmat, mat, i);
                if(ob.det(varmat, 0)==0 && D==0){
                    return 0;
                }

                answer[i][0] = ob.det(varmat, 0) * (float) Math.pow(-1, i + r + 1) / D;
                if (i==(c-2) && ob.det(varmat, 0)!=0 && D==0) {
                    return 1;
                }
            }

            System.out.println("The matrix of solution:");
            for (float[] element : answer) {
                System.out.println(Arrays.toString(element));
            }
            return 2;
//        }


    }

     static void fillByIgnore(float[][] to_arr, float[][] from_arr, int col) {
        int m = 0, n = 0;
        for (int i = 0; i < from_arr.length; i++) {
            for (int j = 0; j < from_arr[0].length; j++) {
                if (j != col) {
                    to_arr[m][n++] = from_arr[i][j];
                }
            }
            m++;
            n = 0;
        }
    }

}