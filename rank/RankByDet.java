package matrix_calculator.rank;
import matrix_calculator.GUI.Matrix;
import matrix_calculator.matrixop.*;
import javax.swing.*;
import java.awt.*;

public class RankByDet {

    public static void fill(float[][] to_arr,float[][] from_arr,int init_row,int init_col){
        int order= to_arr.length;
        int m=0,n=0;
        for(int i=init_row;i<init_row+order;i++){
            for(int j=init_col;j<init_col+order;j++){
                to_arr[m][n++]=from_arr[i][j];
            }
            m++;
            n=0;
        }
    }
    
    public static boolean isNullMatrix(float arr[][]){
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }
    public static int getRank(JPanel p, float[][] arr, int order, int row_count, int col_count){

        if(isNullMatrix(arr))
            return 0;
        boolean flag=true;
        DeterminantOfMatrix ob=new DeterminantOfMatrix();
            int i=1,rank=order;
            float[][] subMatrix;
            JLabel l;

        while(flag){

            if(order==1){
                rank=order;
                break;
            }

            subMatrix=new float[order][order];
            for(int m=0;m<=row_count && flag;m++){
                for(int n=0;n<=col_count && flag;n++){
                    fill(subMatrix,arr,m,n);
                    System.out.println("SubMatrix No."+i);

                    l=new JLabel("SubMatrix No."+i);
                    l.setFont(new Font("Operations", Font.CENTER_BASELINE,13));
                    p.add(l);
                    Matrix.printMatrix(p,subMatrix);
                    l=new JLabel("Det="+ob.det(subMatrix,0));
                    l.setFont(new Font("Operations", Font.CENTER_BASELINE,13));
                    p.add(l);
                    p.revalidate();
                    p.repaint();

                    if(ob.det(subMatrix,0)!=0){
                        rank=order;
                        flag=false;
                    }
                    i++;
                }
            }
            order--;
            row_count++;
            col_count++;
        }
        JLabel op=new JLabel("∴ Rank of Matrix is:"+rank);
        op.setFont(new Font("",Font.CENTER_BASELINE,15));
        p.add(op);
    return rank;
    }

    
}
