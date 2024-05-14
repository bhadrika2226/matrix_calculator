package matrix_calculator.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI {

    boolean flag=false;
    Object source;
    JPanel homePanel;
    JLabel infoQ,info, image, info2, info3, info4;
    JButton moreinfo, i1, i2,i3,i4;
    int w = Matrix.screenSize.width;
    int h = Matrix.screenSize.height;


    public HomeGUI() {
        homePanel = new JPanel();
        homePanel.setBounds(w / 6, h / 20, 5 * w / 6, h);
        homePanel.setBackground(new Color(168, 208, 230));
        homePanel.setLayout(null);
        homePanel.setVisible(true);

        ImageIcon ie = new ImageIcon(System.getProperty("user.dir")+"\\HomeLogo.png");
        image = new JLabel("", ie, JLabel.CENTER);
        image.setBounds(50, 50, 512, 512);
        image.setVisible(true);
        homePanel.add(image);

        infoQ = new JLabel("What is a matrix?");
        infoQ.setBounds(600,118, 500, 38);
        infoQ.setBackground(new Color(168, 208, 230));
        infoQ.setForeground(Color.BLACK);
        infoQ.setFont(new Font("str",Font.CENTER_BASELINE,38));
        infoQ.setOpaque(true);
        infoQ.setVisible(true);
        homePanel.add(infoQ);

        String text = "<html><p> A matrix is a collection of numbers arranged into a fixed number of rows and columns." +
                " Matrices are the most important and a basic part of Mathematics which are used in higher studies and real-life problems." +
                " The evolution of the most powerful tools of Mathematics is a result of an attempt to obtain compact and simple methods of solving the system of linear equations." +
                " Also, matrices have wide application in engineering, physics, economics, statistics and computer graphics. <br> " +
                "<br>" +
                "      This Matrix Calculator not only helps in performing the operations on matrices, calculates the rank of an entered matrix, performs various operations such as determinant, transpose, inverse, adjoint but also does implementation of matrices to solve a given system of linear algebraic equations." +
                " Below are descriptions of the matrix operations that this calculator can perform.";

        info = new JLabel(text);
        info.setBounds(600, 70, 500, 500);
        // info.setBackground(new Color(168, 208, 230));
        info.setForeground(Color.BLACK);
        info.setFont(new Font("str",Font.CENTER_BASELINE,15));
        // info.setOpaque(true);
        info.setVisible(true);
        homePanel.add(info);

        moreinfo = new JButton("Know more!!");
        homePanel.add(moreinfo);
        moreinfo.setVisible(true);
        moreinfo.setBounds(1000, 600, 200, 38);
        moreinfo.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        moreinfo.setForeground(Color.WHITE);
        moreinfo.setBackground(new Color(18, 60, 80));
        moreinfo.setVisible(true);
        moreinfo.addActionListener(bt);


        String text2 = "<html><p><H1>Basic Operations:</H1>"+" <u>Matrix addition:</u> This can be performed on matrices of the same size." +
                " This means that the order of the matrices must be same." +
                " If the condition satisfies, matrix addition is performed by adding the corresponding element in the matrices.<br><br>" +
                "<u>Matrix subtraction:</u> This is performed similar as matrix addition with the only difference that the values are subtracted rather than added." +
                " However, the condition remains the same that the order must of matrices must be same.<br><br>" +
                "<u>Matrix multiplication:</u> In order to multiply two matrices, the number of columns in the first matrix must match the number of rows in the second matrix." +
                " If the matrices are of correct order, then the product involves multiplying the corresponding elements in row of the first matrix, by that of the columns of the second matrix and summing up the result.<br><br>" +
                "<H1>Matrix Operations:</H1>This section includes the operations such as determinant, transpose, inverse and adjoint of matrix." +
                " Except transpose, it is necessary to enter a square matrix.<br><br>" +
                "<u>Determinant:</u> The determinant is a value that can be computed from the elements of a square matrix." +
                " Each 2x2 matrix is called a minor." +
                " First the minors are obtained by eliminating the ith and jth row and column respectively." +
                " This procedure can be extended to give a recursive definition for the determinant of a nxn matrix, known as Laplace expansion.<br><br>" +
                "<u>Transpose:</u> This is a matrix formed by swapping the rows into column and vice-versa.<br><br> " + "Read more on page 2..." + "</p></html>";

        info2 = new JLabel(text2);
        info2.setBounds(100, 10, 600, 700);
        info2.setBackground(new Color(168, 208, 230));
        info2.setForeground(Color.BLACK);
        info2.setFont(new Font("str",Font.CENTER_BASELINE,15));
        info2.setOpaque(true);

        String text3 = "<html><p> <u>Adjoint and Inverse:</u><br>"+"The adjoint of a square matrix A is the transpose of its cofactor matrix ." +
                " A=[Aij]nxn, where Aij is the cofactor of an element." +
                " The inverse of a matrix A can be given by this formula A." +
                " Inv(A) = I; where I is the identity matrix. Also, Inv(A) = (adj A)/|A|.<br><br>" +
                "<H1>Rank of a matrix:</H1>" +
                "This calculator gives the rank of matrix by two methods namely RankByDeterminant and RankByEchelonForm.<br><br>" +
                "<u>RankByDeterminant:</u> The Rank of a matrix is said to be 'r' if <br>" +
                "it has atleast one non-zero minor of order 'r' and Every minor of matrix of order higher than 'r' is zero." +
                " Check all the minors of the matrix." +
                " Minors are determinants of smaller square matrices made by removing particular rows and columns." +
                " So, to find rank by this method determinants need to be calculated.<br><br>" +
                "<u>RankByEchelonForm:</u> The Rank can be determined by counting the number of non-zero rows and columns and 'r' = Number of non-zero rows." +
                " Thus, matrix rank is calculated by reducing the matrix to a row echelon form using elementary row operations.<br><br>" + "Read more on page 3...." +
                "</p></html>";

        info3 = new JLabel(text3);
        info3.setBounds(100, 10, 500, 550);
        info3.setBackground(new Color(168, 208, 230));
        info3.setForeground(Color.BLACK);
        info3.setFont(new Font("str",Font.CENTER_BASELINE,15));
        info3.setOpaque(true);

        String text4 = "<html><p> <H1>Solution of system of linear equations:</H1> " + "Options for three methods are given to get the solution of linear equations." + " Solution by Cramer's Rule, by Inverse, by Row Reduction form. <br><br>" +
                "If the rank of the given matrix and the augmented matrix matches then there exists solution. However, if it doesn't match then the system of equations is inconsistent.<br><br>" +
                "<u>Solution by Cramer's Rule:</u> First, set an augmented matrix. Calculate determinant of the main(square) matrix. To find the ith solution of the system of linear equations using Cramer's rule replace the ith column of the main matrix by solution vector and calculate it's determinant. Then divide the determinant by the main one : this is one part of the solution set. Repeat the same procedure for each variable. If the main determinant is zero, the system has either inconsistent or infinitely many solutions.<br><br>" +
                "<u>Solution by Inverse:</u> First, set the given matrix and calculate its inverse (in case it is nonsingular). Then multiply the inverse matrix by the solution vector. The resultant vector is a solution of the given system of equations.<br><br>" +
                "<u>Solution by Row Reduction:</u> This method gives an idea about whether the system has infinite solutions or not. This method uses the Gauss Jordan elimination to find the solution.<br><br> </p></html>";
        info4 = new JLabel(text4);
        info4.setBounds(100,10, 500, 550);
        info4.setBackground(new Color(168, 208, 230));
        info4.setForeground(Color.BLACK);
        info4.setFont(new Font("str",Font.CENTER_BASELINE,15));
        info4.setOpaque(true);

        i1 = new JButton("1");
        i1.setBounds(750, 550, 60, 35);
        i1.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        i1.setForeground(Color.WHITE);
        i1.setBackground(new Color(18, 60, 80));
        i1.addActionListener(bt);

        i2 = new JButton("2");
        i2.setBounds(820, 550, 60, 35);
        i2.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        i2.setForeground(Color.WHITE);
        i2.setBackground(new Color(18, 60, 80));
        i2.addActionListener(bt);

        i3 = new JButton("3");
        i3.setBounds(890, 550, 60, 35);
        i3.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        i3.setForeground(Color.WHITE);
        i3.setBackground(new Color(18, 60, 80));
        i3.addActionListener(bt);

        i4 = new JButton("Back");
        i4.setBounds(850, 600, 100, 35);
        i4.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        i4.setForeground(Color.WHITE);
        i4.setBackground(new Color(18, 60, 80));
        i4.addActionListener(bt);


    }

    ActionListener bt = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            source = e.getSource();

            if (source == moreinfo) {
                homePanel.remove(info);
                homePanel.remove(moreinfo);
                homePanel.remove(infoQ);
                info2.setVisible(true);
                i1.setForeground(new Color(18, 60, 80));
                i1.setBackground(new Color(232, 206, 191));
                i1.setBounds(747, 547, 66, 41);
                i2.setForeground(Color.WHITE);
                i2.setBackground(new Color(18, 60, 80));
                i2.setBounds(820, 550, 60, 35);
                i3.setForeground(Color.WHITE);
                i3.setBackground(new Color(18, 60, 80));
                i3.setBounds(890, 550, 60, 35);

                i1.setVisible(true);
                i2.setVisible(true);
                i3.setVisible(true);
                i4.setVisible(true);
                image.setVisible(false);
                homePanel.add(info2);
                homePanel.add(i1);
                homePanel.add(i2);
                homePanel.add(i3);
                homePanel.add(i4);

                homePanel.revalidate();
                homePanel.repaint();
            
            } else if (source == i1) {
                homePanel.remove(moreinfo);

                i1.setVisible(true);
                i1.setForeground(new Color(18, 60, 80));
                i1.setBackground(new Color(232, 206, 191));
                i1.setBounds(747, 547, 66, 41);
                i2.setVisible(true);
                i2.setForeground(Color.white);
                i2.setBackground(new Color(44, 90, 120));
                i2.setBounds(820, 550, 60, 35);
                i3.setVisible(true);
                i3.setForeground(Color.white);
                i3.setBackground(new Color(44, 90, 120));
                i3.setBounds(890, 550, 60, 35);

                image.setVisible(false);
                info2.setVisible(true);
                homePanel.add(info2);

                homePanel.revalidate();
                homePanel.repaint();

            }else if (source == i2) {
                homePanel.remove(info2);
                homePanel.remove(moreinfo);

                i1.setVisible(true);
                i1.setForeground(Color.white);
                i1.setBackground(new Color(44, 90, 120));
                i1.setBounds(750, 550, 60, 35);
                
                i2.setVisible(true);
                i2.setForeground(new Color(18, 60, 80));
                i2.setBackground(new Color(232, 206, 191));
                i2.setBounds(817, 547, 66, 41);

                i3.setVisible(true);
                i3.setForeground(Color.white);
                i3.setBackground(new Color(44, 90, 120));
                i3.setBounds(890, 550, 60, 35);


                image.setVisible(false);
                info3.setVisible(true);
                homePanel.add(info3);

                homePanel.revalidate();
                homePanel.repaint();

            } else if (source == i3) {
                homePanel.remove(info2);
                homePanel.remove(info3);
                homePanel.remove(moreinfo);
                i1.setVisible(true);
                i1.setForeground(Color.white);
                i1.setBackground(new Color(44, 90, 120));
                i1.setBounds(750, 550, 60, 35);

                i2.setVisible(true);
                i2.setForeground(Color.white);
                i2.setBackground(new Color(44, 90, 120));
                i2.setBounds(820, 550, 60, 35);

                i3.setVisible(true);
                i3.setForeground(new Color(18, 60, 80));
                i3.setBackground(new Color(232, 206, 191));
                i3.setBounds(887, 547, 66, 41);

                image.setVisible(false);
                info4.setVisible(true);
                homePanel.add(info4);

                homePanel.revalidate();
                homePanel.repaint();
            }
            else
            {
                homePanel.remove(info2);
                homePanel.remove(info3);
                homePanel.remove(info4);
                homePanel.remove(i4);
                homePanel.add(info);
                homePanel.add(infoQ);
                homePanel.add(moreinfo);
                i1.setVisible(false);
                i2.setVisible(false);
                i3.setVisible(false);
                image.setVisible(true);

                homePanel.revalidate();
                homePanel.repaint();
            }
        }
    };
}