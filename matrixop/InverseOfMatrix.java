package matrix_calculator.matrixop;
import matrix_calculator.GUI.Matrix;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
public class InverseOfMatrix
{
    public static float[][] inverse(float[][] arr, JPanel displayOp) throws ArithmeticException{

        float A = DeterminantOfMatrix.det(arr, 0);
        JLabel l;


        arr = AdjointOfMatrix.adjoint(arr);
        l=new JLabel("  Adjoint of Matrix:");
        l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
        displayOp.add(l);
        Matrix.printMatrix(displayOp,arr);

        l=new JLabel("  |A|="+A);
        l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
        displayOp.add(l);
        System.out.println(A);

        if(A==0){
            throw new ArithmeticException();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr[i][j] / A;
            }
        }
        l=new JLabel("  Inverse of Matrix: ");
        l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
        displayOp.add(l);
        Matrix.printMatrix(displayOp,arr);

        return arr;
    }


    public static void printMatrix(float[][] arr){
        for(float[] element: arr){
            System.out.println(Arrays.toString(element));
        }

    }
}