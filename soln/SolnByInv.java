package matrix_calculator.soln;
import matrix_calculator.basicop.*;
import matrix_calculator.matrixop.*;
import matrix_calculator.GUI.Matrix;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
public class SolnByInv {

    public static void printMatrix(float[][] arr) {
        for (float[] element : arr) {
            System.out.println(Arrays.toString(element));
        }

    }

    public float[][] sol(float[][] coeff, float[][] constants, int n,JPanel displayOp) {

        JLabel l;
        float[][] inverse,answer;

        l=new JLabel("Matrix of Coefficients:  A=");
        l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
        displayOp.add(l);
        System.out.println("Matrix of Coefficients:A");
        Matrix.printMatrix(displayOp,coeff);

        l=new JLabel("Matrix of Constants: B=");
        l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
        displayOp.add(l);
        System.out.println("Matrix of Constants:B");
        Matrix.printMatrix(displayOp,constants);

        try {

            inverse=InverseOfMatrix.inverse(coeff,displayOp);
            l=new JLabel("  A-1B=");
            l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
            displayOp.add(l);
            Matrix.printMatrix(displayOp,inverse);
            l=new JLabel("*");
            l.setFont(new Font("Operations", Font.CENTER_BASELINE,14));
            displayOp.add(l);
            Matrix.printMatrix(displayOp,constants);

            answer = BasicOperations.multiplication(inverse, constants);
            for(int i=0;i<n;i++){
                answer[i][0]=Math.round(answer[i][0]);
            }

            l=new JLabel("=");
            l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
            displayOp.add(l);
            Matrix.printMatrix(displayOp,answer);

            int c= constants.length;
            String[] varNm = {"x", "y", "z", "w", "t"};
            JLabel []ans = new JLabel[c];

            l=new JLabel("    Hence,");
            l.setFont(new Font("    Hence", Font.CENTER_BASELINE,13));
            displayOp.add(l);

            for(int i=0;i<c;i++){
                ans[i]= new JLabel(varNm[i] +" = "+answer[i][0],SwingConstants.CENTER);
                ans[i].setFont(new Font("Det", Font.CENTER_BASELINE, 13));
                displayOp.add(ans[i]);
            }
            printMatrix(answer);
            return answer;

        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }

    }

}