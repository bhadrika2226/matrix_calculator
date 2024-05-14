package matrix_calculator.GUI;
import matrix_calculator.GUI.Matrix;
import matrix_calculator.basicop.*;
import matrix_calculator.matrixop.*;
import matrix_calculator.soln.*;
import matrix_calculator.rank.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolnGUI {
    public JScrollPane output1;
    boolean flag = false;
    Object source;
    JButton cramsoln, solnByInv, done, solnByREF, calculate, refresh;
    JPanel input, box, solnPanel, output,op1;
    JLabel x1, x2;
    Integer[] dropdown = {1, 2, 3, 4, 5};
    String[] varNm = {"x", "y", "z", "w", "t"};
    JTextField[] element;
    JLabel[] v;
    Border br;
    int w = Matrix.screenSize.width, h = Matrix.screenSize.height, r, c, click = 0;

    JComboBox var, eqns;

    public SolnGUI() {
        solnPanel = new JPanel();
        solnPanel.setBounds(w / 6, h / 20, 5 * w / 6, h);
        solnPanel.setBackground(new Color(168, 208, 230));
        solnPanel.setLayout(null);
        solnPanel.setVisible(true);

        cramsoln = new JButton("Solution By Cramer's Method");
        solnPanel.add(cramsoln);
        cramsoln.setBounds(1 * Matrix.screenSize.width / 20, (Matrix.screenSize.height / 20) + 6, 300, 38);
        cramsoln.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        cramsoln.setForeground(Color.WHITE);
        cramsoln.setBackground(new Color(18, 60, 80));
        cramsoln.setVisible(true);
        cramsoln.addActionListener(this::bt);

        solnByInv = new JButton("Solution By Inverse Of Matrix");
        solnPanel.add(solnByInv);
        solnByInv.setBounds(6 * Matrix.screenSize.width / 20, (Matrix.screenSize.height / 20) + 6, 300, 38);
        solnByInv.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        solnByInv.setForeground(Color.WHITE);
        solnByInv.setBackground(new Color(18, 60, 80));
        solnByInv.setVisible(true);
        solnByInv.addActionListener(this::bt);

        solnByREF = new JButton("Solution By Row Reduction");
        solnPanel.add(solnByREF);
        solnByREF.setBounds(11 * Matrix.screenSize.width / 20, (Matrix.screenSize.height / 20) + 6, 300, 38);
        solnByREF.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        solnByREF.setForeground(Color.WHITE);
        solnByREF.setBackground(new Color(18, 60, 80));
        solnByREF.setVisible(true);
        solnByREF.addActionListener(this::bt);

        x1 = new JLabel("Number of equations:", SwingConstants.CENTER);
        x1.setFont(new Font("Number of equations:", Font.CENTER_BASELINE, 15));
        x1.setBackground(new Color(168, 208, 230));
        x1.setForeground(new Color(18, 60, 80));
        x1.setBounds(5 * Matrix.screenSize.width / 29, (Matrix.screenSize.height / 20) + 100, 190, 33);
        x1.setOpaque(true);
        x1.setVisible(true);


        eqns = new JComboBox(dropdown);
        eqns.setSelectedIndex(0);
        eqns.setBounds(3 * Matrix.screenSize.width / 10, Matrix.screenSize.height / 6, 60, 33);
        eqns.setToolTipText("No. of equations");
        eqns.setBackground(new Color(232, 206, 191));
        eqns.setForeground(new Color(18, 60, 80));
        eqns.setVisible(true);

        x2 = new JLabel("Number of variables:", SwingConstants.CENTER);
        x2.setFont(new Font("Number of variables:", Font.CENTER_BASELINE, 15));
        x2.setBackground(new Color(168, 208, 230));
        x2.setForeground(new Color(18, 60, 80));
        x2.setBounds(5 * Matrix.screenSize.width / 13, Matrix.screenSize.height / 6, 200, 33);
        x2.setOpaque(true);
        x2.setVisible(true);


        var = new JComboBox(dropdown);
        var.setSelectedIndex(0);
        var.setBounds(17 * Matrix.screenSize.width / 33, Matrix.screenSize.height / 6, 60, 33);
        var.setToolTipText("No. of variables");
        var.setBackground(new Color(232, 206, 191));
        var.setForeground(new Color(18, 60, 80));
        var.setVisible(true);

        done = new JButton("Done");
        done.setBounds(4 * w / 6, h / 6, 70, 33);
        done.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        done.setForeground(Color.WHITE);
        done.setBackground(new Color(44, 90, 120));
        done.setVisible(true);
        done.addActionListener(process);

        calculate = new JButton("Calculate");
        calculate.setBounds(9 * w / 17, 7 * h / 35, 70, 33);
        calculate.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        calculate.setForeground(Color.WHITE);
        calculate.setBackground(new Color(44, 90, 120));
        calculate.addActionListener(calc);

        refresh = new JButton("Refresh");
        refresh.setBounds(9 * w / 17, 7 * h / 35, 70, 33);
        refresh.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(new Color(44, 90, 120));
        refresh.addActionListener(this::ref);

        br = BorderFactory.createLineBorder(new Color(44, 90, 120), 1);
        input = new JPanel();
        input.setLayout(new FlowLayout());
        input.setBackground(new Color(232, 206, 191));
        input.setBorder(br);

        box = new JPanel();
        input.add(box);
        box.setVisible(true);

        output = new JPanel();
        output.setBackground(new Color(204, 235, 255));
        output.setBorder(BorderFactory.createLineBorder(new Color(18, 55, 80), 1));

        op1=new JPanel(new FlowLayout(FlowLayout.LEFT,10,27));
        TitledBorder tb=new TitledBorder(br,"Solution:");
        tb.setTitlePosition(TitledBorder.TOP);
        tb.setTitleColor(Color.BLACK);
        tb.setTitleFont(new Font("Solution:",Font.BOLD,17));
        op1.setBorder(tb);
        op1.setBackground(new Color(204, 235, 255));




        output1=new JScrollPane(op1);
        output1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        output1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        output1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        output1.getViewport().setBackground(new Color(204, 235, 255));
        output1.setLayout(new ScrollPaneLayout());
        output1.setBorder(br);
        solnPanel.add(output1);
        op1.setVisible(true);
    }

    public void bt(ActionEvent ae) {
        source = ae.getSource();

        solnPanel.add(x1);
        solnPanel.add(eqns);
        solnPanel.add(x2);
        solnPanel.add(var);
        solnPanel.add(done);
        solnPanel.remove(output);
        solnPanel.remove(output1);
        solnPanel.revalidate();
        solnPanel.repaint();

    try{
        if (source == cramsoln) {
            Matrix.path.setText("Home>Solution of system of linear equations>By Cramer's rule");
            cramsoln.setForeground(Color.BLACK);
            cramsoln.setBackground(new Color(232, 206, 191));
            solnByInv.setForeground(Color.WHITE);
            solnByInv.setBackground(new Color(18, 60, 80));
            solnByREF.setForeground(Color.WHITE);
            solnByREF.setBackground(new Color(18, 60, 80));
            if(r!=c){
                throw new Exception();
            }

        } else if (source == solnByInv) {
            Matrix.path.setText("Home>Solution of system of linear equations>By Inverse");
            solnByInv.setForeground(Color.BLACK);
            solnByInv.setBackground(new Color(232, 206, 191));
            cramsoln.setForeground(Color.WHITE);
            cramsoln.setBackground(new Color(18, 60, 80));
            solnByREF.setForeground(Color.WHITE);
            solnByREF.setBackground(new Color(18, 60, 80));
             if(r!=c){
                throw new Exception();
            }

        } else if (source == solnByREF) {
            Matrix.path.setText("Home>Solution of system of linear equations>By Reduced row echelon form");
            solnByREF.setForeground(Color.BLACK);
            solnByREF.setBackground(new Color(232, 206, 191));
            solnByInv.setForeground(Color.WHITE);
            solnByInv.setBackground(new Color(18, 60, 80));
            cramsoln.setForeground(Color.WHITE);
            cramsoln.setBackground(new Color(18, 60, 80));
            if(r>c){
                throw new Exception();
            }

        }
    }
    catch(Exception e){
        solnPanel.remove(input);
        solnPanel.remove(calculate);
        solnPanel.remove(refresh);
        solnPanel.revalidate();
        solnPanel.repaint();

        if (r > c) {
            JOptionPane.showMessageDialog(solnPanel, "The number of equations need not be more than the number of variables.",
            "ERROR", 2);
            return;
        } 
        
        else {
            if (source == solnByInv) {
                JOptionPane.showMessageDialog(solnPanel, "This method includes calculating the inverse of coefficient " +
                "matrix which is possible only for square matrices");
            } 
                    
            else if (source == cramsoln) {
                JOptionPane.showMessageDialog(solnPanel, "Cramer’s Rule is a method that uses determinants to solve systems of equations\n" +
                "and determinant can be calculated only for square matrices");
            }
            return;
        }
    }


}

    ActionListener process = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            int i, j = 0;

            solnPanel.remove(output);
            solnPanel.remove(output1);
            try {
                r = (int) eqns.getSelectedItem();
                c = (int) var.getSelectedItem();
                if ((r > c) || ((r < c) && source != solnByREF)) {
                    throw new Exception();
                }

            }
            catch (Exception e) {
                solnPanel.remove(input);
                    solnPanel.remove(calculate);
                    solnPanel.remove(refresh);
                    solnPanel.revalidate();
                    solnPanel.repaint();

                if (r > c) {
                    JOptionPane.showMessageDialog(solnPanel, "The number of equations need not be more than the number of variables.",
                            "ERROR", 2);
                            return;
                }
                    
                 
                else {
                    if (source == solnByInv) {
                        JOptionPane.showMessageDialog(solnPanel, "This method includes calculating the inverse of coefficient " +
                                "matrix which is possible only for square matrices","ERROR", 2);

                    } 
                    else if (source == cramsoln) {
                        JOptionPane.showMessageDialog(solnPanel, "Cramer’s Rule is a method that uses determinants to solve systems of equations\n" +
                                "and determinant can be calculated only for square matrices","ERROR", 2);
                    }
                    
                    return;
                }
            }


            if (click != 0) {
                box.removeAll();
            }

            box.setLayout(new GridLayout(r, 2 * c + 1));
            element = new JTextField[r * (c + 1)];
            v = new JLabel[r * c];

            for (i = 0; i < element.length; i++) {
                element[i] = new JTextField();
                element[i].setPreferredSize(new Dimension(60, 40));
                element[i].setBackground(new Color(204, 235, 255));
                element[i].setFont(new Font("element", Font.BOLD, 15));
                element[i].setHorizontalAlignment(JTextField.CENTER);
                element[i].setBorder(br);
                element[i].setFocusTraversalKeysEnabled(true);
                box.add(element[i]);

                if (j < (r * c)) {
                    v[j] = new JLabel();
                        v[j].setText(varNm[j % c]);
                    if ((j + 1) % c == 0) {
                        v[j].setText("  " + v[j].getText() + "    =   ");


                    } else {
                        v[j].setText("  " + v[j].getText() + "    +   ");

                    }

                    v[j].setFont(new Font("Det",Font.BOLD+Font.ITALIC,15));
                    v[j].setBackground(new Color(204, 235, 255));
                    v[j].setOpaque(true);
                    box.add(v[j]);
                    j++;
                }

                if (j % c == 0) {
                    i++;
                    element[i] = new JTextField();
                    element[i].setPreferredSize(new Dimension(60, 40));
                    element[i].setBackground(new Color(204, 235, 255));
                    element[i].setFont(new Font("element", Font.BOLD, 15));
                    element[i].setHorizontalAlignment(JTextField.CENTER);
                    element[i].setBorder(br);
                    element[i].setFocusTraversalKeysEnabled(true);
                    box.add(element[i]);
                }

            }

            input.setBounds((w / 3 - 40 * c), 4 * h / 18, ((c + 1) * 62) + (c * 60) + 8, 40 * r + 10);
            input.setVisible(true);
            solnPanel.add(input);

            calculate.setBounds((w / 3 - 38 * c) + (input.getWidth() - 225) / 2, 4 * h / 18 + input.getHeight() + 25, 100, 33);
            calculate.setVisible(true);
            solnPanel.add(calculate);

            refresh.setBounds((w / 3 - 38 * c) + input.getWidth() / 2, 4 * h / 18 + input.getHeight() + 25, 100, 33);
            refresh.setVisible(true);
            solnPanel.add(refresh);

            solnPanel.revalidate();
            solnPanel.repaint();

            click++;
        }
    };

    ActionListener calc = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {

            JLabel op;
            JLabel []ans = new JLabel[c];


            if (source == solnByInv) {

                float [][]coeff = new float[r][r];
                float [][]constants = new float[r][1];
                float[][] result;
                int k = 0;


                try {
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            coeff[i][j] = Float.parseFloat(element[k].getText());
                            k++;
                        }
                        constants[i][0] = Float.parseFloat(element[k].getText());
                        k++;
                    }
                }
                catch (NumberFormatException nfe){
                    System.out.println(nfe);
                    JOptionPane.showMessageDialog(solnPanel, "Invalid input!\nMatrix operations can be performed only on digit",
                            "ERROR",JOptionPane.WARNING_MESSAGE );
                    element[k].setText("");
                    element[k].requestFocus(true);
                    return;
                }

                op1.removeAll();
                output.setVisible(true);
                output.setLayout(new GridLayout(c,1));
                solnPanel.add(output);


                solnPanel.revalidate();
                solnPanel.repaint();

                try {
                    output.removeAll();
                    op1.removeAll();

                    SolnByInv solbyInv = new SolnByInv();
                    result=solbyInv.sol(coeff, constants, c,op1);
                    output.setBounds(20, 4 * h / 18 + input.getHeight() + 83, 150, c*35);

                    for(int i=0;i<c;i++){
                        ans[i]= new JLabel("",SwingConstants.CENTER);
                        ans[i].setText(varNm[i] +"  =  "+ result[i][0]);
                        ans[i].setPreferredSize(new Dimension(100,35));
                        ans[i].setFont(new Font("Det", Font.BOLD+Font.ITALIC, 17));
                        ans[i].setForeground(Color.BLACK);
                        output.add(ans[i]);
                    }
                    output1.setBounds(210,4 * h / 18 + input.getHeight() + 83,2*w/3,output.getHeight()+100);
                    output1.setVisible(true);
                    output1.revalidate();
                    output1.repaint();
                    solnPanel.add(output1);
                    output.setVisible(true);
                    output.setBorder(br);
                    solnPanel.add(output);
                    solnPanel.revalidate();
                    solnPanel.repaint();
                }
                catch (ArithmeticException e){


                    output.removeAll();
                    output.setBounds((5*w/6-200)/3, 4 * h / 18 + input.getHeight() + 83, 600, 40);
                    output.setLayout(new GridLayout(1,1));

                    if(RankByDet.isNullMatrix(BasicOperations.multiplication(AdjointOfMatrix.adjoint(coeff),constants))){
                        op = new JLabel("The given system of linear equations has infinite solutions");
                    }
                    else{
                        op = new JLabel("The given system of linear equations in inconsistent");
                    }
                    op.setFont(new Font("Det",Font.BOLD+Font.ITALIC,17));
                    op.setHorizontalAlignment(JLabel.CENTER);
                    op.setBorder(br);
                    output.add(op);
                    output.revalidate();
                    output.repaint();
                }
            }

            else {
                float[][] matrix = new float[r][c + 1];
                float[][] result = new float[c][1];

                int k = 0;

                try {
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c + 1; j++) {
                            matrix[i][j] = Float.parseFloat(element[k].getText());
                            k++;
                        }
                    }
                }catch (NumberFormatException nfe){
                    System.out.println(nfe);
                    JOptionPane.showMessageDialog(solnPanel, "Invalid input!\nMatrix operations can be performed only on digit",
                            "ERROR",2 );
                    element[k].setText("");
                    element[k].requestFocus(true);
                    return;
                }

                output.setBounds((w / 3 - 40 * c)+(input.getWidth()-150)/2, 4 * h / 18 + input.getHeight() + 83, 150, c*35);
                output.setVisible(true);
                output.setLayout(new GridLayout(c,1));
                solnPanel.add(output);
                solnPanel.revalidate();
                solnPanel.repaint();

                if (source == cramsoln) {
                    CramSolution cm = new CramSolution();
                    System.out.println(cm.soln(matrix, r, c + 1,result));

                    if (cm.soln(matrix, r, c + 1,result) == 2) {
                        cm.soln(matrix, r, c + 1,result);
                        output.removeAll();

                        for(int i=0;i<c;i++){
                            ans[i]= new JLabel("",SwingConstants.CENTER);
                            ans[i].setText(varNm[i] +"  =  "+ result[i][0]);
                            ans[i].setPreferredSize(new Dimension(100,35));
                            ans[i].setFont(new Font("Det", Font.BOLD+Font.ITALIC, 17));
                            ans[i].setForeground(Color.BLACK);
                            output.add(ans[i]);

                        }
                        output.setVisible(true);
                        output.setBorder(br);
                        solnPanel.add(output);
                        solnPanel.revalidate();
                        solnPanel.repaint();
                    }
                    else{

                        output.removeAll();
                        output.setBounds((5*w/6-200)/3, 4 * h / 18 + input.getHeight() + 83, 550, 40);
                        output.setLayout(new GridLayout(1,1));

                        if (cm.soln(matrix, r, c + 1,result) == 0) {
                            op = new JLabel("The given system of linear equations has infinite solutions");
                        }
                        else{
                            op = new JLabel("The given system of linear equations is inconsistent");
                        }
                        op.setHorizontalAlignment(JLabel.CENTER);
                        op.setFont(new Font("Det",Font.BOLD+Font.ITALIC,17));
                        op.setBorder(br);
                        output.add(op);
                        output.revalidate();
                        output.repaint();
                    }


                }

                else {
                    op1.removeAll();
                    SolnByREF sol = new SolnByREF();
                    if (sol.solution(matrix,result,op1) == 11) {
                        output.removeAll();
                        output.setBounds(20, 4 * h / 18 + input.getHeight() + 83, 150, c*35);                       
                        output1.setVisible(false);
                        //unique

                        for(int i=0;i<c;i++){
                            ans[i]= new JLabel("",SwingConstants.CENTER);
                            ans[i].setText(varNm[i] +"  =  "+ result[i][0]);
                            ans[i].setPreferredSize(new Dimension(100,35));
                            ans[i].setFont(new Font("Det", Font.BOLD+Font.ITALIC, 17));
                            ans[i].setForeground(Color.BLACK);
                            output.add(ans[i]);
                        }
                        output1.setBounds(210,4 * h / 18 + input.getHeight() + 83,2*w/3,output.getHeight()+100);
                        output1.setVisible(true);
                        output1.revalidate();
                        output1.repaint();
                        solnPanel.add(output1);
                        output.setVisible(true);
                        output.setBorder(br);
                        solnPanel.add(output);
                        solnPanel.revalidate();
                        solnPanel.repaint();
                    }
                    else{
                        output.removeAll();
                        output.setBounds((5*w/6-200)/3, 4 * h / 18 + input.getHeight() + 83, 650, 40);
                        output.setLayout(new GridLayout(1,1));

                        if (sol.solution(matrix,result,op1) == 10) {
                            //no solution
                            op = new JLabel("The given system of linear equations is inconsistent");
                        }
                        else {
                            //infinite solution
                            op = new JLabel("The given system of linear equations has infinite solutions with "+
                                    sol.solution(matrix,result,op1) +" parameter");
                        }
                        op.setHorizontalAlignment(JLabel.CENTER);
                        op.setFont(new Font("Det",Font.BOLD+Font.ITALIC,17));
                        op.setBorder(br);
                        output.add(op);
                        output.revalidate();
                        output.repaint();
                    }

                }


            }


        }

    };

    public void ref(ActionEvent ae){
        solnPanel.remove(output);
        solnPanel.remove(output1);
        solnPanel.revalidate();
        solnPanel.repaint();
        for(int i=0;i<(element.length);i++)
        {
            element[i].setText("");
        }
    }
}


