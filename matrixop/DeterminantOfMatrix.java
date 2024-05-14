package matrix_calculator.matrixop;
public class DeterminantOfMatrix {

    public static float det(float[][] arr, int p) {
        int order = arr.length;

        //if the order entered by user is 0 or less than it.
        if (order <= p){
            return 0;
        }
        //the case when the order is 1.
        else if (order == 1){
            return arr[0][0];
        }
        else {

            //creating an array temp of order less than 1.
            float[][] temp = new float[order - 1][order - 1];

            //if the order is 2
            if (order == 2) {
                return (arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0]);
            }
            //solves for any n*n matrix.
            else {

                int m = 0, n = 0;
                for (int j = 1; j < order; j++) {
                    for (int k = 0; k < order; k++) {
                        //ignoring that column which belongs to the current element.
                        if (k != p) {
                            temp[m][n++] = arr[j][k];    //stores the elements in matrix temp
                        }
                    }

                    //after filling elements in 1st row resetting our m and n.....
                    m++;
                    n = 0;
                }
            }
            //calculating determinant using recursion.
            return arr[0][p] * (float) Math.pow(-1, p) * det(temp, 0) + det(arr, p + 1);
        }
    }
    
    
}