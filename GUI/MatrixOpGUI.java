package matrix_calculator.GUI;
import matrix_calculator.matrixop.*;

import javax.naming.directory.InvalidAttributeIdentifierException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MatrixOpGUI {
    boolean flag=false;
    Integer[] n = {1, 2, 3, 4, 5};
    JButton det,adjoint,inverse,transpose,done,calculate,refresh;
    JPanel matrixPanel,input,output,box;
    JTextField [] element;
    float[][] arr1;
    JLabel m1,op1;
    Object source;
    Border br;
    int w = Matrix.screenSize.width;
    int h = Matrix.screenSize.height;
    JComboBox cbox,rbox;
    int click=0,r,c;


    public MatrixOpGUI()
    {
        matrixPanel = new JPanel();
        matrixPanel.setBounds(w / 6, h / 20, 5 * w / 6, h);
        matrixPanel.setBackground(new Color(168,208,230));
        matrixPanel.setLayout(null);
        matrixPanel.setVisible(true);

        det = new JButton("Determinant");
        matrixPanel.add(det);
        det.setBounds(3*w/40, (h / 20) + 6, 130, 38);
        det.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        det.setForeground(Color.WHITE);
        det.setBackground(new Color(18,60,80));
        det.addActionListener(this::order);
        det.setVisible(true);

        transpose= new JButton("Transpose");
        matrixPanel.add (transpose);
        transpose.setBounds(6*w/23, (h / 20) + 6, 130, 38);
        transpose.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        transpose.setForeground(Color.WHITE);
        transpose.setBackground(new Color(18,60,80));
        transpose.addActionListener(this::order);
        transpose.setVisible(true);

        inverse = new JButton("Inverse");
        matrixPanel.add(inverse);
        inverse.setBounds(4*w/9, (h / 20) + 6, 130, 38);
        inverse.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        inverse.setForeground(Color.WHITE);
        inverse.setBackground(new Color(18,60,80));
        inverse.addActionListener(this::order);
        inverse.setVisible(true);

        adjoint= new JButton("Adjoint");
        matrixPanel.add (adjoint);
        adjoint.setBounds(5*w/8, (h / 20) + 6, 130, 38);
        adjoint.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        adjoint.setForeground(Color.WHITE);
        adjoint.setBackground(new Color(18,60,80));
        adjoint.addActionListener(this::order);
        adjoint.setVisible(true);

        m1 = new JLabel("Order of the Matrix:", SwingConstants.CENTER);
        m1.setFont(new Font("Order of the Matrix:", Font.CENTER_BASELINE, 17));
        m1.setBackground(new Color(168, 208, 230));
        m1.setForeground(new Color(18, 60, 80));
        m1.setBounds(19*w/78, (h / 5), 170, 33);
        m1.setOpaque(true);
        m1.setVisible(true);

        rbox = new JComboBox(n);
        rbox.setSelectedIndex(0);
        rbox.setBounds(7*w/19+10, (h /5), 60, 33);
        rbox.setBackground(new Color(232, 206, 191));
        rbox.setOpaque(true);
        rbox.setVisible(true);
        rbox.setToolTipText("Row");

        cbox = new JComboBox(n);
        cbox.setSelectedIndex(0);
        cbox.setBounds(8*w/19+15, (h /5), 60, 33);
        cbox.setBackground(new Color(232, 206, 191));
        cbox.setOpaque(true);
        cbox.setVisible(true);
        cbox.setToolTipText("Column");

        done = new JButton("Done");
        done.setBounds(w/2, (h /5), 70, 33);
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

        refresh= new JButton("Refresh");
        refresh.setBounds(9 * w / 17, 7 * h / 35, 70, 33);
        refresh.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(new Color(44, 90, 120));
        refresh.addActionListener(this::ref);


        br=BorderFactory.createLineBorder(new Color(44, 90, 120),1);
        input = new JPanel();
        input.setLayout(new FlowLayout());
        input.setBackground(new Color(232, 206, 191));
        input.setBorder(br);

        box = new JPanel();
        input.add(box);
        box.setVisible(true);

        output=new JPanel();
        output.setBackground(new Color(204, 235, 255));
        output.setLayout(new FlowLayout());
        output.setBorder(BorderFactory.createLineBorder(new Color(18,55,80),1));
    }

    public void order(ActionEvent ae) {
        source = ae.getSource();

        try {
            if (source == det) {

                Matrix.path.setText("Home>Matrix Operations>Determinant");
                det.setBackground(new Color(232, 206, 191));
                det.setForeground(Color.BLACK);
                transpose.setForeground(Color.WHITE);
                transpose.setBackground(new Color(18, 60, 80));
                inverse.setForeground(Color.WHITE);
                inverse.setBackground(new Color(18, 60, 80));
                adjoint.setForeground(Color.WHITE);
                adjoint.setBackground(new Color(18, 60, 80));

                matrixPanel.add(m1);
                matrixPanel.add(rbox);
                matrixPanel.add(cbox);
                matrixPanel.add(done);
                matrixPanel.remove(output);

                if (r != c) {
                    throw new Exception();
                }
    
            } else if (source == transpose) {
    
                Matrix.path.setText("Home>Matrix Operations>Transpose");
                transpose.setBackground(new Color(232, 206, 191));
                transpose.setForeground(Color.BLACK);
                det.setForeground(Color.WHITE);
                det.setBackground(new Color(18, 60, 80));
                inverse.setForeground(Color.WHITE);
                inverse.setBackground(new Color(18, 60, 80));
                adjoint.setForeground(Color.WHITE);
                adjoint.setBackground(new Color(18, 60, 80));

                matrixPanel.add(m1);
                matrixPanel.add(rbox);
                matrixPanel.add(cbox);
                matrixPanel.add(done);
                matrixPanel.remove(output);
            }
    
            else if (source == inverse) {
    
                Matrix.path.setText("Home>Matrix Operations>Inverse");
                inverse.setBackground(new Color(232, 206, 191));
                inverse.setForeground(Color.BLACK);
                transpose.setForeground(Color.WHITE);
                transpose.setBackground(new Color(18, 60, 80));
                det.setForeground(Color.WHITE);
                det.setBackground(new Color(18, 60, 80));
                adjoint.setForeground(Color.WHITE);
                adjoint.setBackground(new Color(18, 60, 80));

                matrixPanel.add(m1);
                matrixPanel.add(rbox);
                matrixPanel.add(cbox);
                matrixPanel.add(done);
                matrixPanel.remove(output);

                if (r != c) {
                    throw new Exception();
                }
            }
    
            else if (source == adjoint) {
    
                Matrix.path.setText("Home>Matrix Operations>Adjoint");
                adjoint.setBackground(new Color(232, 206, 191));
                adjoint.setForeground(Color.BLACK);
                transpose.setForeground(Color.WHITE);
                transpose.setBackground(new Color(18, 60, 80));
                inverse.setForeground(Color.WHITE);
                inverse.setBackground(new Color(18, 60, 80));
                det.setForeground(Color.WHITE);
                det.setBackground(new Color(18, 60, 80));

                matrixPanel.add(m1);
                matrixPanel.add(rbox);
                matrixPanel.add(cbox);
                matrixPanel.add(done);
                matrixPanel.remove(output);

                if (r != c) {
                    throw new Exception();
                }
            }
            matrixPanel.revalidate();
            matrixPanel.repaint();
        } catch (Exception e) {
            if (source != transpose) {
                JOptionPane.showMessageDialog(matrixPanel,"Entered order is incorrect.\n" +
                        " This operation is valid only for square matrices!","ERROR",2 );
                matrixPanel.remove(input);
                matrixPanel.remove(calculate);
                matrixPanel.remove(refresh);
                matrixPanel.revalidate();
                matrixPanel.repaint();
            }
        }
    }

    ActionListener process = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            output.setVisible(false);

            try {
                r = (int) rbox.getSelectedItem();
                c = (int) cbox.getSelectedItem();

                if(source!=transpose && r!=c){
                    throw new Exception();
                }

            }catch (Exception e){

                System.out.println(e);
                JOptionPane.showMessageDialog(matrixPanel,"Entered order is incorrect.\n" +
                        " This operation is valid only for square matrices!","ERROR",2 );

                rbox.setSelectedIndex(0);
                cbox.setSelectedIndex(0);
                matrixPanel.remove(input);
                matrixPanel.remove(calculate);
                matrixPanel.remove(refresh);
                matrixPanel.revalidate();
                matrixPanel.repaint();

                return;
            }

            if (click != 0) {
                box.removeAll();
            }

            box.setLayout(new GridLayout(r, c));
            element = new JTextField[r * c];

            for (int i = 0; i < (r * c); i++) {
                element[i] = new JTextField();
                element[i].setPreferredSize(new Dimension(60, 40));
                element[i].setBackground(new Color(204, 235, 255));
                element[i].setFont(new Font("element",Font.BOLD,15));
                element[i].setHorizontalAlignment(JTextField.CENTER);
                element[i].setBorder(br);
                element[i].setFocusTraversalKeysEnabled(true);
                box.add(element[i]);
            }

            input.setBounds((5*w/6-(c*10)) /3, (13*h / 43), 60*c+10, r *40+10);
            input.setVisible(true);
            matrixPanel.add(input);

            calculate.setBounds(9 * w / 23 + 30 * c, (13*h / 43) + input.getHeight()/2  , 100, 33);
            calculate.setVisible(true);
            matrixPanel.add(calculate);

            refresh.setBounds(9 * w / 19 + 30 * c, (13*h / 43) + input.getHeight()/2  , 100, 33);
            refresh.setVisible(true);
            matrixPanel.add(refresh);

            click++;
            matrixPanel.revalidate();
            matrixPanel.repaint();

        }
    };
    ActionListener calc = new ActionListener(){
        public void  actionPerformed(ActionEvent e) {

            arr1 = new float[r][c];
            float [][] ans;
            int k = 0;
            try{
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        arr1[i][j] = Float.parseFloat(element[k].getText());
                        k++;
                    }
                }
            }
            catch (NumberFormatException nfe){
                System.out.println(nfe);
                JOptionPane.showMessageDialog(matrixPanel, "Invalid input!\nMatrix operations can be performed only on digit",
                        "ERROR",2 );
                element[k].setText("");
                element[k].requestFocus(true);
                return;
            }

            output.setBounds((5*w/6-(c*55+33)) /3, (11*h / 20), 94*c+150, r *60+60);
            output.setVisible(true);
            TitledBorder tb=new TitledBorder("Solution:");
            tb.setTitlePosition(TitledBorder.TOP);
            tb.setTitleColor(Color.BLACK);
            tb.setTitleFont(new Font("Solution:",Font.BOLD,17));
            output.setBorder(tb);
            matrixPanel.add(output);
            matrixPanel.revalidate();
            matrixPanel.repaint();

            for (float[] el : arr1) {
                System.out.println(Arrays.toString(el));
            }


            if (source == det) {
                DeterminantOfMatrix d1 = new DeterminantOfMatrix();
                output.removeAll();
                output.setBounds((5*w/6-(c*55+33)) /3, (11*h / 20),300,60);
                op1 = new JLabel("Determinant =  " + (d1.det(arr1, 0)));
                op1.setFont(new Font("Det", Font.BOLD, 17));
                op1.setBounds(0, 20, 250, 50);
                op1.setForeground(Color.BLACK);
                output.add(op1);
                matrixPanel.revalidate();
                matrixPanel.repaint();
            }

            else if (source == transpose) {
                output.setBounds((5*w/6-(r*55+33)) /3, (11*h / 20), 70*r+10, c *50+10);
                output.removeAll();
                ans = TransposeOfMatrix.transpose(arr1, r, c);
                Matrix.printMatrix(output, ans);
            }

            else if (source == inverse) {
                output.removeAll();
                try{
                    JPanel temp=new JPanel();
                    ans = InverseOfMatrix.inverse(arr1,temp);
                    Matrix.printMatrix(output, ans);
                }
                catch (ArithmeticException ae){
                    output.removeAll();
                    output.setVisible(false);
                    JOptionPane.showMessageDialog(matrixPanel,"Inverse is not possible\n " +
                            "As the determinant of matrix is zero!\nInv(A) = adj(A) / |A| ","ERROR",2 );

                    matrixPanel.repaint();
                    matrixPanel.revalidate();
                }

            }

            else {
                output.removeAll();
                ans = AdjointOfMatrix.adjoint(arr1);
                Matrix.printMatrix(output, ans);
            }

        }
    };

    public void ref(ActionEvent e1) {
        matrixPanel.remove(output);
        matrixPanel.revalidate();
        matrixPanel.repaint();
        for (int i = 0; i < (element.length); i++) {
            element[i].setText("");
        }
    }

}
