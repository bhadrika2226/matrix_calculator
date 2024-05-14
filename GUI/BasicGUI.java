package matrix_calculator.GUI;
import matrix_calculator.basicop.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class BasicGUI {
    boolean flag = false;
    Object source;
    Integer[] n = {1, 2, 3, 4, 5};

    JPanel basicPanel, input1, input2, box1, box2, output;
    JTextField[] element1, element2;

    JButton addition, subtraction, multiplication, done, calculate, refresh;
    JLabel lMatrix1, lMatrix2, m1, operation;
    JComboBox R1, C1, R2, C2;
    Border br;
    int w = Matrix.screenSize.width;
    int h = Matrix.screenSize.height;
    int click = 0;
    int r1, r2, c1, c2;

    public BasicGUI() {

        basicPanel = new JPanel();
        basicPanel.setBounds(w / 6, h / 20, 5 * w / 6, h);
        basicPanel.setBackground(new Color(168, 208, 230));
        basicPanel.setLayout(null);
        basicPanel.setVisible(true);


        addition = new JButton("Addition");
        basicPanel.add(addition);
        addition.setBounds(5 * w / 51, (h / 20) + 6, 170, 38);
        addition.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        addition.setForeground(Color.WHITE);
        addition.setBackground(new Color(18, 60, 80));
        addition.setVisible(true);
        addition.addActionListener(this::bt);


        subtraction = new JButton("Subtraction");
        basicPanel.add(subtraction);
        subtraction.setBounds(5 * w / 14, (h / 20) + 6, 170, 38);
        subtraction.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        subtraction.setForeground(Color.WHITE);
        subtraction.setBackground(new Color(18, 60, 80));
        subtraction.setVisible(true);
        subtraction.addActionListener(this::bt);

        multiplication = new JButton("Multiplication");
        basicPanel.add(multiplication);
        multiplication.setVisible(true);
        multiplication.setBounds(5 * w / 8, (h / 20) + 6, 170, 38);
        multiplication.setFont(new Font("Addition", Font.CENTER_BASELINE, 15));
        multiplication.setForeground(Color.WHITE);
        multiplication.setBackground(new Color(18, 60, 80));
        multiplication.setVisible(true);
        multiplication.addActionListener(this::bt);

        m1 = new JLabel("Order of the Matrix:", SwingConstants.CENTER);
        m1.setBounds(9 * w / 46, 7 * h / 36, 170, 33);
        m1.setBackground(new Color(168, 208, 230));
        m1.setForeground(new Color(18, 60, 80));
        m1.setFont(new Font("m1", Font.CENTER_BASELINE, 17));
        m1.setOpaque(true);
        m1.setVisible(false);
        basicPanel.add(m1);


        lMatrix1 = new JLabel("MATRIX : 1", SwingConstants.LEFT);
        lMatrix1.setBounds(w / 3, 5 * h / 36, 85, 38);
        lMatrix1.setOpaque(true);
        lMatrix1.setVisible(false);
        lMatrix1.setBackground(new Color(168, 208, 230));
        lMatrix1.setFont(new Font("m1", Font.CENTER_BASELINE, 15));
        lMatrix1.setForeground(Color.BLACK);
        basicPanel.add(lMatrix1);


        R1 = new JComboBox(n);
        R1.setSelectedIndex(0);
        R1.setBounds(8 * w / 25, 7 * h / 36, 60, 33);
        R1.setBackground(new Color(232, 206, 191));
        R1.setOpaque(true);
        R1.setVisible(false);
        R1.setToolTipText("Row");
        basicPanel.add(R1);


        C1 = new JComboBox(n);
        C1.setSelectedIndex(0);
        C1.setBounds(4 * w / 11, 7 * h / 36, 60, 33);
        C1.setBackground(new Color(232, 206, 191));
        C1.setOpaque(true);
        C1.setVisible(false);
        C1.setToolTipText("Column");
        basicPanel.add(C1);

        lMatrix2 = new JLabel("MATRIX : 2", SwingConstants.LEFT);
        lMatrix2.setBounds(7 * w / 16, 5 * h / 36, 85, 38);
        lMatrix2.setFont(new Font("m1", Font.CENTER_BASELINE, 15));
        lMatrix2.setBackground(new Color(168, 208, 230));
        lMatrix2.setForeground(Color.BLACK);
        lMatrix2.setOpaque(true);
        lMatrix2.setVisible(false);
        basicPanel.add(lMatrix2);


        R2 = new JComboBox(n);
        R2.setSelectedIndex(0);
        R2.setBounds(3 * w / 7, 7 * h / 36, 60, 33);
        R2.setBackground(new Color(232, 206, 191));
        R2.setOpaque(true);
        R2.setVisible(false);
        R2.setToolTipText("Row");
        basicPanel.add(R2);


        C2 = new JComboBox(n);
        C2.setSelectedIndex(0);
        C2.setBounds(8 * w / 17, 7 * h / 36, 60, 33);
        C2.setBackground(new Color(232, 206, 191));
        C2.setOpaque(true);
        C2.setVisible(false);
        C2.setToolTipText("Column");
        basicPanel.add(C2);

        done = new JButton("Done");
        done.setBounds(9 * w / 17, 7 * h / 36, 70, 33);
        done.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        done.setForeground(Color.WHITE);
        done.setBackground(new Color(44, 90, 120));
        done.setVisible(false);
        done.addActionListener(process);
        basicPanel.add(done);

        operation = new JLabel();
        operation.setFont(new Font("m1", Font.CENTER_BASELINE, 30));
        operation.setBackground(new Color(168, 208, 230));
        operation.setForeground(new Color(44, 90, 120));
        operation.setVisible(false);
        basicPanel.add(operation);

        calculate = new JButton("Calculate");
        calculate.setBounds(9 * w / 17, 7 * h / 36, 70, 33);
        calculate.setFont(new Font("Calculate", Font.CENTER_BASELINE, 13));
        calculate.setForeground(Color.WHITE);
        calculate.setBackground(new Color(44, 90, 120));
        calculate.setVisible(false);
        calculate.addActionListener(calc);
        basicPanel.add(calculate);


        refresh = new JButton("Refresh");
        refresh.setBounds(9 * w / 17, 7 * h / 36, 70, 33);
        refresh.setFont(new Font("Refresh", Font.CENTER_BASELINE, 13));
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(new Color(44, 90, 120));
        refresh.setVisible(false);
        refresh.addActionListener(this::ref);
        basicPanel.add(refresh);

        br = BorderFactory.createLineBorder(new Color(44, 90, 120), 1);
        input1 = new JPanel();
        input1.setLayout(new FlowLayout());
        input1.setBackground(new Color(232, 206, 191));
        input1.setVisible(true);
        input1.setBorder(br);

        box1 = new JPanel();
        input1.add(box1);
        box1.setVisible(true);

        input2 = new JPanel();
        input2.setLayout(new FlowLayout());
        input2.setBackground(new Color(232, 206, 191));
        input2.setVisible(true);
        input2.setBorder(br);

        box2 = new JPanel();
        input2.add(box2);
        box2.setVisible(true);

        output = new JPanel();
        output.setBackground(new Color(204, 235, 255));
        output.setOpaque(true);
        output.setVisible(false);
        output.setLayout(new FlowLayout());
        output.setBorder(br);
    }

    public void ref(ActionEvent e1) {
        output.removeAll();
        basicPanel.remove(output);
        basicPanel.repaint();
        basicPanel.revalidate();
        for (int i = 0; i < (element1.length); i++) {
            element1[i].setText("");
        }
        for (int j = 0; j < element2.length; j++)
            element2[j].setText("");

    }

    ActionListener calc = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            float arr1[][] = new float[r1][c1];
            float arr2[][] = new float[r2][c2];
            float ans[][];

            int k = 0;
            int l = -1;
            try {
                for (int i = 0; i < r1; i++)
                    for (int j = 0; j < c1; j++) {
                        arr1[i][j] = Float.parseFloat(element1[k].getText());
                        k++;
                    }

                k = 0;
                for (l = -1; l < r2 - 1; ) {
                    l++;
                    for (int m = 0; m < c2; m++) {

                        arr2[l][m] = Float.parseFloat(element2[k].getText());
                        k++;
                    }

                }

                output.setBounds(3 * w / 10 - 30 * c1 - 30 * c2, 7 * h / 24 + 40 * Math.max(r1, r2), 8 * w / 41 + 60 * c2 + 60 * c1, r1 * 40 + 20);
                basicPanel.add(output);
                output.setVisible(true);
                basicPanel.revalidate();
                basicPanel.repaint();
                for (float[] el : arr1) {
                    System.out.println(Arrays.toString(el));
                }
                for (float[] el : arr2) {
                    System.out.println(Arrays.toString(el));

                }


                JLabel sol = new JLabel();
                sol.setBounds(0, 0, 100, 14);
                sol.setForeground(Color.BLACK);
                sol.setFont(new Font("sol", Font.ROMAN_BASELINE, 17));

                if (source == addition) {

                    sol.setText("The Addition of given two Matrix is:");
                    output.removeAll();
                    output.add(sol);
                    ans = BasicOperations.addition(arr1, arr2);
                    Matrix.printMatrix(output, ans);

                } else if (source == subtraction) {

                    sol.setText("The Subtraction of given two Matrix is:");
                    output.removeAll();
                    output.add(sol);
                    ans = BasicOperations.subtraction(arr1, arr2);
                    Matrix.printMatrix(output, ans);
                } else {

                    sol.setText("The Multiplication of given two Matrix is:");
                    output.removeAll();
                    output.add(sol);
                    ans = BasicOperations.multiplication(arr1, arr2);
                    Matrix.printMatrix(output, ans);
                }
            } catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(basicPanel, "Kindly enter proper input!!!!");
                if (l == -1) {
                    element1[k].setText("");
                    element1[k].requestFocus(true);
                } else {
                    element2[k].setText("");
                    element2[k].requestFocus(true);
                }
            }
        }
    };

    ActionListener process = new ActionListener() {
        public void
        actionPerformed(ActionEvent ae) {

            try {
                r1 = (int) R1.getSelectedItem();
                c1 = (int) C1.getSelectedItem();
                r2 = (int) R2.getSelectedItem();
                c2 = (int) C2.getSelectedItem();

                basicPanel.remove(output);

                if (source == addition) {
                    if (r1 != r2 || c1 != c2)
                        throw new Exception();
                    operation.setText("+");
                } else if (source == subtraction) {
                    if (r1 != r2 || c1 != c2)
                        throw new Exception();
                    operation.setText("-");
                } else {
                    if (c1 != r2)
                        throw new Exception();
                    operation.setText("*");
                }

                if (click != 0) {
                    box1.removeAll();
                    box2.removeAll();
                }
                int A = Math.max(r1, r2) * 20;

                input1.setBounds(3 * w / 10 - 30 * c1 - 30 * c2, 11 * h / 43 + A - 20 * r1, 60 * c1 + 10, r1 * 40 + 10);
                box1.setLayout(new GridLayout(r1, c1));
                element1 = new JTextField[r1 * c1];
                for (int i = 0; i < (r1 * c1); i++) {
                    element1[i] = new JTextField();
                    element1[i].setPreferredSize(new Dimension(60, 40));
                    element1[i].setBackground(new Color(204, 235, 255));
                    element1[i].setFont(new Font("element", Font.BOLD, 15));
                    element1[i].setHorizontalAlignment(JTextField.CENTER);
                    element1[i].setBorder(br);
                    element1[i].setFocusTraversalKeysEnabled(true);
                    box1.add(element1[i]);
                }
                basicPanel.add(input1);

                operation.setBounds(9 * w / 28 + c1 * 30 - c2 * 30 + 10, 11 * h / 43 + A, 50, 33);
                operation.setVisible(true);
                input2.setBounds(7 * w / 19 + 30 * c1 - 30 * c2, 11 * h / 43 + A - 20 * r2, 60 * c2 + 10, r2 * 40 + 10);
                box2.setLayout(new GridLayout(r2, c2));
                element2 = new JTextField[r2 * c2];
                for (int i = 0; i < (r2 * c2); i++) {
                    element2[i] = new JTextField();
                    element2[i].setPreferredSize(new Dimension(60, 40));
                    element2[i].setBackground(new Color(204, 235, 255));
                    element2[i].setFont(new Font("element", Font.BOLD, 15));
                    element2[i].setHorizontalAlignment(JTextField.CENTER);
                    element2[i].setBorder(br);
                    box2.add(element2[i]);
                }
                basicPanel.add(input2);
                basicPanel.add(operation);
                basicPanel.add(calculate);
                basicPanel.add(refresh);

                calculate.setBounds(9 * w / 23 + 30 * c1 + 30 * c2, 11 * h / 43 + A, 100, 33);
                calculate.setVisible(true);
                refresh.setBounds(9 * w / 19 + 30 * c1 + 30 * c2, 11 * h / 43 + A, 100, 33);
                refresh.setVisible(true);

                click++;
                basicPanel.revalidate();
                basicPanel.repaint();
            } catch (Exception E) {
                if (source != multiplication)
                    JOptionPane.showMessageDialog(basicPanel, "The operation is not possible as the rows & columns are not compatible!!!!", "ERROR", JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(basicPanel, "please make sure columns of matrix:1 & rows of matrix:2 is same!!!!", "ERROR", JOptionPane.WARNING_MESSAGE);
                basicPanel.remove(input1);
                basicPanel.remove(input2);
                basicPanel.remove(operation);
                basicPanel.remove(calculate);
                basicPanel.remove(refresh);
                basicPanel.repaint();
                basicPanel.revalidate();
            }
        }
    };

    public void bt(ActionEvent bt) {
        source = bt.getSource();
        try {

            m1.setVisible(true);
            lMatrix1.setVisible(true);
            lMatrix2.setVisible(true);
            R1.setVisible(true);
            R2.setVisible(true);
            C1.setVisible(true);
            C2.setVisible(true);
            done.setVisible(true);
            basicPanel.remove(output);

            if (source == addition) {

                Matrix.path.setText("Home>Basic Operations>Addition");
                basicPanel.remove(output);
                addition.setBackground(new Color(232, 206, 191));
                addition.setForeground(Color.BLACK);
                subtraction.setForeground(Color.WHITE);
                subtraction.setBackground(new Color(18, 60, 80));
                multiplication.setForeground(Color.WHITE);
                multiplication.setBackground(new Color(18, 60, 80));


                if (click != 0) {
                    operation.setText("+");
                }
                if (r1 != r2 || c1 != c2)
                    throw new Exception();

            } else if (source == subtraction) {

                Matrix.path.setText("Home>Basic Operations>Subtraction");
                basicPanel.remove(output);
                addition.setBackground(new Color(18, 60, 80));
                addition.setForeground(Color.WHITE);
                subtraction.setBackground(new Color(232, 206, 191));
                subtraction.setForeground(Color.BLACK);
                multiplication.setForeground(Color.WHITE);
                multiplication.setBackground(new Color(18, 60, 80));


                if (click != 0) {
                    operation.setText("-");
                }
                if (r1 != r2 || c1 != c2)
                    throw new Exception();

            } else if (source == multiplication) {

                Matrix.path.setText("Home>Basic Operations>Multiplication");
                basicPanel.remove(output);
                addition.setBackground(new Color(18, 60, 80));
                addition.setForeground(Color.WHITE);
                subtraction.setForeground(Color.WHITE);
                subtraction.setBackground(new Color(18, 60, 80));
                multiplication.setBackground(new Color(232, 206, 191));
                multiplication.setForeground(Color.BLACK);


                if (click != 0) {
                    operation.setText("*");
                }

                if (c1 != r2)
                    throw new Exception();

            }
            basicPanel.revalidate();
            basicPanel.repaint();
        } catch (Exception E) {
            if (source != multiplication)
                JOptionPane.showMessageDialog(basicPanel, "The operation is not passible as the rows & columns are not compitable!!!!", "ERROR", 2);
            else
                JOptionPane.showMessageDialog(basicPanel, "please make sure columns of matrix:1 & rows of matrix:2 is same!!!!", "ERROR", 2);

            basicPanel.remove(input1);
            basicPanel.remove(input2);
            basicPanel.remove(operation);
            basicPanel.remove(calculate);
            basicPanel.remove(refresh);

            basicPanel.repaint();
            basicPanel.revalidate();
        }
    }
}












