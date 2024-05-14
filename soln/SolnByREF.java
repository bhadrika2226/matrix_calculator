package matrix_calculator.soln;
import matrix_calculator.rank.*;
import javax.swing.*;
import java.awt.*;

public class SolnByREF {
    public int solution (float[][]mat,float[][] answer,JPanel displayOp){
        RankByREF ref = new RankByREF();
        JLabel l;

        int rank=ref.getRank(displayOp,ref.getREF(displayOp,mat),mat[0].length-1);
        System.out.println("∴Rank of A="+rank);

        JPanel temp=new JPanel();
        int rankAug=ref.getRank(temp,ref.getREF( temp,mat),mat[0].length);

        l=new JLabel(" Rank of A="+rank+"& Rank of A|B ="+rankAug);
        l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
        displayOp.add(l);
        System.out.println(" Rank of A|B ="+rankAug);

        if(rank!=rankAug) {
            System.out.println("No solution possible for this System of Equations!!");
            return 10;
        }
        else
        {
            l=new JLabel("     Rank of A= Rank of A|B=>The given system of equation is consistent");
            l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
            displayOp.add(l);

            if(mat[0].length-1== rank){ //mat[0].length -1 is number of unknowns
                l=new JLabel("      No. of variables=Rank of A=>We get unique solution for given system of equations.");
                l.setFont(new Font("Operations", Font.CENTER_BASELINE,12));
                displayOp.add(l);
                System.out.println("We get an unique solution!!");
                CramSolution ob=new CramSolution();
                ob.soln(mat, mat.length, mat[0].length,answer);

                int c=mat[0].length-1;
                String[] varNm = {"x", "y", "z", "w", "t"};
                JLabel []ans = new JLabel[c];

                l=new JLabel(" Hence, ");
                l.setFont(new Font("    Hence", Font.CENTER_BASELINE,13));
                displayOp.add(l);
                for(int i=0;i<c;i++){
                    ans[i]= new JLabel(varNm[i] +" = "+answer[i][0],SwingConstants.CENTER);
                    ans[i].setFont(new Font("Det", Font.CENTER_BASELINE, 13));
                    displayOp.add(ans[i]);
                }
                return 11;
            }
            else {
                int param = (mat[0].length - 1) - rank;
                System.out.println("We get infinite solutions with " + param + " parameters!!");
                return param;
            }
        }
    }
}