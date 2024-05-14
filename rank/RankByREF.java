package matrix_calculator.rank;
import matrix_calculator.GUI.Matrix;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class RankByREF {
    RowOperations rob = new RowOperations();

   public float[][] getREF(JPanel p, float arr[][])
    {

        int repeat = arr.length - 1;
        JLabel l;
        Matrix.printMatrix(p,arr);

        for (int i = 0; i < repeat; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                float k= rob.getK(arr[i], arr[j]);
                rob.rowMinus(arr[i], arr[j],k);
//                String str="R"+(j+1)+"-("+k+")R"+(i+1);
                l=new JLabel("R"+(j+1)+"-("+k+")R"+(i+1));
                l.setFont(new Font("Operations", Font.CENTER_BASELINE,13));
                p.add(l);
                System.out.printf("R%d-kR%d \n", j+1, i+1);
                Matrix.printMatrix(p,arr);
                p.revalidate();
                p.repaint();
            }
        }
        for (int i = 0; i <repeat; i++) {
            for (int j=i+1; j < arr.length; j++) {
                if (rob.completeDiv(arr[i], arr[j]) != 0) {
                    rob.rowMinus(arr[i], arr[j], rob.completeDiv(arr[i], arr[j]));

                    l=new JLabel("<html><u>Comparing R</u><html>"+(j+1)+" and R"+(i+1));
                    l.setFont(new Font("Operations", Font.PLAIN,12));
                    p.add(l);
                    System.out.printf("Comparing R%d and R%d", j+1, i+1);
                    Matrix.printMatrix(p,arr);
                    p.revalidate();
                    p.repaint();
                    printArr(arr);
                }
            }
        }
        return arr;
    }
    public int getRank(JPanel p,float arr[][],int col){
        int r=rob.checkZeroRows(getREF(p,arr),col);
        JLabel op=new JLabel("∴ Rank of Matrix is:"+r);
        op.setFont(new Font("",Font.CENTER_BASELINE,15));
        p.add(op);
        return r;
    }

    static void printArr(float[][] arr) {
        for (float[] element : arr) {
            System.out.println(Arrays.toString(element));
        }
    }

}