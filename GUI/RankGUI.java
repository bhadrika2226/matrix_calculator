package matrix_calculator.GUI;
import matrix_calculator.rank.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class RankGUI {
    public JScrollPane output;
    boolean flag = false;
    JButton rankByref, rankByDet;
    JPanel input, box,op;
    JComboBox cbox, rbox;
    JLabel m1,op1,sol;
    JButton done, calculate,refresh;
    JTextField[] element;
    Border br;
    int r,c, w=Matrix.screenSize.width,h=Matrix.screenSize.height,click = 0;
    Integer[] dropdown = {1, 2, 3, 4, 5};
    Object source;

    JPanel rankPanel;

    public RankGUI() {
        rankPanel = new JPanel();
        rankPanel.setBounds(w / 6, h / 20, 5 *w/ 6, h);
        rankPanel.setBackground(new Color(168, 208, 230));
        rankPanel.setLayout(null);
        rankPanel.setVisible(true);

        rankByref = new JButton();
        rankPanel.add(rankByref);
        rankByref.addActionListener(this::order);
        rankByref.setText("Method:1 \n Rank BY Row Echelon Form");
        rankByref.setBounds(w / 6, (h/ 20) + 6, 290, 38);
        rankByref.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        rankByref.setForeground(Color.WHITE);
        rankByref.setBackground(new Color(18, 60, 80));
        rankByref.setVisible(true);


        rankByDet = new JButton();
        rankPanel.add(rankByDet);
        rankByDet.addActionListener(this::order);
        rankByDet.setText("Method:2 \n Rank By Determinant");
        rankByDet.setBounds(w / 2, (h/ 20) + 6, 240, 38);
        rankByDet.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        rankByDet.setForeground(Color.WHITE);
        rankByDet.setBackground(new Color(18, 60, 80));
        rankByDet.setVisible(true);

        m1 = new JLabel("Order of the Matrix:", SwingConstants.CENTER);
        rankPanel.add(m1);
        m1.setFont(new Font("Order of the Matrix:", Font.CENTER_BASELINE, 17));
        m1.setBackground(new Color(168, 208, 230));
        m1.setForeground(new Color(18, 60, 80));
        m1.setBounds(5 * w/ 23 + 40, (h/ 6), 170, 33);
        m1.setOpaque(true);
        m1.setVisible(false);


        rbox = new JComboBox(dropdown);
        rankPanel.add(rbox);
        rbox.setSelectedIndex(0);
        rbox.setBounds(7* w/ 19, (h/ 6), 60, 33);
        rbox.setToolTipText("No. of rows");
        rbox.setBackground(new Color(232, 206, 191));
        rbox.setForeground(new Color(18, 60, 80));
        rbox.setVisible(false);

        cbox = new JComboBox(dropdown);
        rankPanel.add(cbox);
        cbox.setSelectedIndex(0);
        cbox.setBounds(8 * w / 19, (h/ 6), 60, 33);
        cbox.setToolTipText("No. of columns");
        cbox.setBackground(new Color(232, 206, 191));
        cbox.setForeground(new Color(18, 60, 80));
        cbox.setVisible(false);

        done = new JButton("Done");
        rankPanel.add(done);
        done.setBounds(w/2-10, (h/ 6), 70, 33);
        done.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        done.setForeground(Color.WHITE);
        done.setBackground(new Color(44, 90, 120));
        done.addActionListener(this::process);
        done.setVisible(false);

        calculate = new JButton("Calculate");
        calculate.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        calculate.setForeground(Color.WHITE);
        calculate.setBackground(new Color(44, 90, 120));
        calculate.setVisible(false);
        calculate.addActionListener(this::calc);
        rankPanel.add(calculate);


        refresh= new JButton("Refresh");
        refresh.setFont(new Font("Addition", Font.CENTER_BASELINE, 13));
        refresh.setForeground(Color.WHITE);
        refresh.setBackground(new Color(44, 90, 120));
        refresh.setVisible(false);
        refresh.addActionListener(this::ref);
        rankPanel.add(refresh);



        br=BorderFactory.createLineBorder(new Color(44, 90, 120),1);
        input = new JPanel();
        input.setLayout(new FlowLayout());
        input.setBackground(new Color(232, 206, 191));
        input.setVisible(true);
        input.setBorder(br);

        box= new JPanel();
        input.add(box);
        box.setVisible(true);

        op1 = new JLabel();
        op1.setFont(new Font("Det",Font.BOLD+Font.ITALIC,17));
        op1.setForeground(Color.BLACK);
        op1.setBackground(new Color(204, 235, 255));
        op1.setOpaque(true);
        op1.setBorder(br);


        op=new JPanel(new FlowLayout(FlowLayout.LEFT,10,27));
        TitledBorder tb=new TitledBorder(br,"Solution:");
        tb.setTitlePosition(TitledBorder.TOP);
        tb.setTitleColor(Color.BLACK);
        tb.setTitleFont(new Font("Solution:",Font.BOLD,17));
        op.setBorder(tb);
        op.setBackground(new Color(204, 235, 255));




        output=new JScrollPane(op);
        output.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        output.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        output.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        output.getViewport().setBackground(new Color(204, 235, 255));
        output.setLayout(new ScrollPaneLayout());
        output.setBorder(br);
        rankPanel.add(output);
        op.setVisible(true);


    }
    public void calc(ActionEvent ae){

        float[][] arr1= new float[r][c];
        int a;

        int k=0;
        try {
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++) {
                    arr1[i][j] = Float.parseFloat(element[k].getText());
                    k++;
                }

            if (source == rankByref){
                
                op.removeAll();
                RankByREF rankbyref=new RankByREF();
                a=rankbyref.getRank(op,arr1,c);
                System.out.println(a);

                op1.setBounds((w/3-30*c),7*h/24+r*40+5,60*c+260,40);
                op1.setVisible(true);
                op1.setText("   Rank of Matrix is:  "+ a);

                output.setBounds(w / 6,3*h/8+r*40-5,w/2,r*40+3*h/74);
                output.setVisible(true);
                output.revalidate();
                output.repaint();

                rankPanel.add(op1);
                rankPanel.add(output);
                rankPanel.repaint();
                rankPanel.revalidate();
            }
            else {

                op.removeAll();
                RankByDet rankbydet=new RankByDet();
                int order=Math.min(r,c);
                a=rankbydet.getRank(op,arr1,order,r-order,c-order);
                System.out.println(a);

                op1.setBounds((w/3-30*c),7*h/24+r*40+5,60*c+260,40);
                op1.setVisible(true);
                op1.setText("   Rank of Matrix is:  "+ a);

                output.setBounds(w / 6,3*h/8+r*40-5,w/2,r*40+3*h/74);
                output.setVisible(true);
                output.revalidate();
                output.repaint();

                rankPanel.add(op1);
                rankPanel.add(output);
                rankPanel.repaint();
                rankPanel.revalidate();
            }

        }
        catch (NumberFormatException E)
        {
            JOptionPane.showMessageDialog(rankPanel,"Enter proper input!!!");
            element[k].setText("");
            element[k].requestFocus(true);
        }
        for (float[] el:arr1) {
            System.out.println(Arrays.toString(el));
        }


    }

    public void ref(ActionEvent ae)
    {

        for (int i = 0; i < (element.length); i++) {
            element[i].setText("");
        }

        op.removeAll();
        rankPanel.remove(output);
        rankPanel.remove(op1);
        rankPanel.repaint();
        rankPanel.revalidate();
    }
    public void process(ActionEvent ae)
    {
        op.removeAll();
        rankPanel.remove(output);
        rankPanel.remove(op1);
        rankPanel.repaint();
        rankPanel.revalidate();


            r = (int) rbox.getSelectedItem();
            c = (int) cbox.getSelectedItem();

            if(click!=0) {
                box.removeAll();
            }

            input.setBounds((w/3-30*c), 11*h/43, 60*c+10, r *40+10);
            box.setLayout(new GridLayout(r, c));
            element = new JTextField[r * c];
            for (int i = 0; i < (r * c); i++) {
                element[i] = new JTextField();
                element[i].setPreferredSize(new Dimension(60,40));
                element[i].setBackground(new Color(204, 235, 255));
                element[i].setFont(new Font("element",Font.BOLD,15));
                element[i].setHorizontalAlignment(JTextField.CENTER);
                element[i].setBorder(br);
                element[i].setFocusTraversalKeysEnabled(true);
                box.add(element[i]);
            }
            rankPanel.add(input);

            calculate.setBounds(5* w /14 + 30 * c, 11*h /43+20*r-10 , 100, 33);
            calculate.setVisible(true);
            refresh.setBounds(7 * w / 16 + 30 * c, 11*h/43+20*r-10, 100, 33);
            refresh.setVisible(true);

            click++;
            rankPanel.revalidate();
            rankPanel.repaint();


    }

    public void order(ActionEvent ae) {
        source = ae.getSource();

        if (source == rankByref) {

            Matrix.path.setText("Home>Rank>By Reduced row echelon form");
            output.setVisible(false);
            op1.setVisible(false);
            rankByref.setBackground(new Color(232, 206, 191));
            rankByref.setForeground(Color.BLACK);
            rankByDet.setForeground(Color.WHITE);
            rankByDet.setBackground(new Color(18, 60, 80));

            m1.setVisible(true);
            rbox.setVisible(true);
            cbox.setVisible(true);
            done.setVisible(true);

        } else {

            Matrix.path.setText("Home>Rank>By determinant");
            output.setVisible(false);
            op1.setVisible(false);
            rankByDet.setBackground(new Color(232, 206, 191));
            rankByDet.setForeground(Color.BLACK);
            rankByref.setForeground(Color.WHITE);
            rankByref.setBackground(new Color(18, 60, 80));

            m1.setVisible(true);
            rbox.setVisible(true);
            cbox.setVisible(true);
            done.setVisible(true);

        }
        rankPanel.revalidate();
        rankPanel.repaint();
    }



}
