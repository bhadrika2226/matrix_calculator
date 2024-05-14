package matrix_calculator.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Matrix {
    JFrame mfrm;
    JFrame introFrame;
    JButton home,basic,rank,matrix,sol;
    static JLabel path;
    Object source;
    HomeGUI workspace;
    BasicGUI basicgui;
    RankGUI rankgui;
    MatrixOpGUI matrixop;
    SolnGUI solngui;


    Container c;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Matrix() {

        introFrame=new JFrame();
        introFrame.setLocationRelativeTo(null);
        introFrame.setBounds(11*(Matrix.screenSize.width)/43,7*(Matrix.screenSize.height)/26,750,400);
        introFrame.setUndecorated(true);
        introFrame.setVisible(true);


        ImageIcon ii=new ImageIcon(System.getProperty("user.dir")+"\\IntroLogo.jpg");
        JLabel logo = new JLabel("",ii,JLabel.CENTER);
        logo.setLayout(new FlowLayout());
        logo.setBounds(4*(Matrix.screenSize.width)/15,7*(Matrix.screenSize.height)/24,718,361);
        introFrame.add(logo);

        Container c1= introFrame.getContentPane();
        c1.setBackground(Color.BLACK);
        int delay = 5000;

        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                introFrame.dispose();
                mfrm.setVisible(true);
            }
        });
        timer.setRepeats(false);
        timer.start();

        mfrm = new JFrame("Matrix Calculator");
        mfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mfrm.setLayout(null);
        mfrm.setExtendedState(JFrame.MAXIMIZED_BOTH);

        c = mfrm.getContentPane();

        JPanel menu = new JPanel();
        menu.setBackground(new Color(18,55,80));//color set_2 blue
        menu.setBounds(0, 0, screenSize.width / 6, screenSize.height);
        menu.setLayout(null);

        JPanel title = new JPanel();
        title.setBackground(new Color(44, 90, 120)); //color set 3
        title.setBounds(screenSize.width / 6, 0, 5 * screenSize.width / 6, screenSize.height / 20);
        title.setLayout(null);
        title.setVisible(true);

        path=new JLabel("Home>");
        title.add(path);
        path.setForeground(Color.white);
        path.setBounds(14,10,5 * screenSize.width / 6,20);
        path.setFont(new Font("Path", Font.PLAIN+Font.BOLD, 12));
        path.setVisible(true);

        workspace=new HomeGUI();


        home = new JButton("Home");
        menu.add(home);
        home.setBounds(screenSize.width / 103, screenSize.height / 10, 70, 38);
        home.setForeground(Color.WHITE);
        home.setBackground(new Color(18,55,80));
        home.addActionListener(this::bt);
        home.setToolTipText("Home");

        basic = new JButton("Basic Operations");
        menu.add(basic);
        basic.setBounds(screenSize.width / 103, 11*(screenSize.height )/ 65, 140, 38);
        basic.setFont(new Font("Basic Operations", Font.CENTER_BASELINE, 12));
        basic.setForeground(Color.WHITE);
        basic.setBackground(new Color(18,55,80));
        basic.addActionListener(this::bt);
        basic.setToolTipText("Basic Operations");

        matrix = new JButton("Matrix Operations");
        menu.add(matrix);
        matrix.setBounds(screenSize.width / 103, 11*(screenSize.height) / 46, 140, 38);
        matrix.setFont(new Font("Matrix Operations", Font.CENTER_BASELINE, 12));
        matrix.setForeground(Color.WHITE);
        matrix.setBackground(new Color(18,55,80));
        matrix.addActionListener(this::bt);
        matrix.setToolTipText("Matrix Operations");

        rank = new JButton("Rank");
        menu.add(rank);
        rank.setBounds(screenSize.width / 103, 4*(screenSize.height)/ 13, 70, 38);
        rank.setFont(new Font("Rank", Font.CENTER_BASELINE, 12));
        rank.setForeground(Color.WHITE);
        rank.setBackground(new Color(18,55,80));
        rank.addActionListener(this::bt);
        rank.setToolTipText("Rank");

        sol = new JButton("Solution of Linear Equations");
        menu.add(sol);
        sol.setBounds(screenSize.width / 103, 14*(screenSize.height )/ 37, 210, 38);
        sol.setFont(new Font("Solution of Linear Equations", Font.CENTER_BASELINE, 12));
        sol.setForeground(Color.WHITE);
        sol.setBackground(new Color(18,55,80));
        sol.addActionListener(this::bt);
        sol.setToolTipText("Solution of Linear Equations");

        basicgui=new BasicGUI();
        basicgui.basicPanel.setVisible(false);

        rankgui=new RankGUI();
        rankgui.rankPanel.setVisible(false);


        matrixop=new MatrixOpGUI();
        matrixop.matrixPanel.setVisible(false);


        solngui=new SolnGUI();
        solngui.solnPanel.setVisible(false);

        c.add(menu);
        c.add(title);
        c.add(workspace.homePanel);
        c.add(basicgui.basicPanel);
        c.add(matrixop.matrixPanel);
        c.add(rankgui.rankPanel);
        c.add(solngui.solnPanel);
        
    }
    public void bt(ActionEvent ae) {

        source=ae.getSource();

        if(source==home){
	
            path.setText("Home>");
            c.remove(workspace.homePanel);
            workspace=new HomeGUI();
            System.gc();

            if(!workspace.flag){
            c.remove(basicgui.basicPanel);
            c.remove(matrixop.matrixPanel);
            c.remove(rankgui.rankPanel);
            c.remove(solngui.solnPanel);}

            c.add(workspace.homePanel);
            workspace.homePanel.setVisible(true);
            mfrm.revalidate();
            mfrm.repaint();

        }
        else if(source==basic){

	    path.setText("Home>Basic Operations>");
            c.remove(basicgui.basicPanel);
            basicgui=new BasicGUI();
            System.gc();
            if(!basicgui.flag) {
                basicgui.flag = true;
                c.remove(workspace.homePanel);
                c.remove(matrixop.matrixPanel);
                c.remove(rankgui.rankPanel);
                c.remove(solngui.solnPanel);
            }
            c.add(basicgui.basicPanel);
            basicgui.basicPanel.setVisible(true);


            mfrm.revalidate();
            mfrm.repaint();

        }
        else if(source==matrix){
	    
	    path.setText("Home>Matrix Operations>");
            c.remove(matrixop.matrixPanel);
            matrixop=new MatrixOpGUI();
            System.gc();
            if(!matrixop.flag) {


                c.remove(workspace.homePanel);
                c.remove(basicgui.basicPanel);
                c.remove(rankgui.rankPanel);
                c.remove(solngui.solnPanel);
            }

            c.add(matrixop.matrixPanel);
            matrixop.matrixPanel.setVisible(true);

            mfrm.revalidate();
            mfrm.repaint();

        }
        else if(source==rank){

	    path.setText("Home>Rank>");
            c.remove(rankgui.rankPanel);
            rankgui=new RankGUI();
            System.gc();
            if(!rankgui.flag) {
                c.remove(workspace.homePanel);
                c.remove(basicgui.basicPanel);
                c.remove(matrixop.matrixPanel);
                c.remove(solngui.solnPanel);
            }

            c.add(rankgui.rankPanel);
            rankgui.rankPanel.setVisible(true);
            mfrm.revalidate();
            mfrm.repaint();

        }
        else {
            c.remove(solngui.solnPanel);
            solngui = new SolnGUI();
            System.gc();

	    path.setText("Home>Solution of system of linear equations");
            if (!solngui.flag) {
                solngui.flag = true;
                c.remove(workspace.homePanel);
                c.remove(basicgui.basicPanel);
                c.remove(matrixop.matrixPanel);
                c.remove(rankgui.rankPanel);
            }
            c.add(solngui.solnPanel);
            solngui.solnPanel.setVisible(true);

            mfrm.revalidate();
            mfrm.repaint();
        }

    }

    public static void printMatrix(JPanel p, float[][] arr) {

        JLabel[][] label = new JLabel[arr.length][arr[0].length];
        JPanel box = new JPanel();
        GridLayout g = new GridLayout(arr.length, arr[0].length);
        g.setVgap(4);
        box.setLayout(g);

        box.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.BLACK));
        box.setBackground(new Color(204, 235, 255));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                label[i][j]=new JLabel();
                label[i][j].setFont(new Font("Roman", Font.CENTER_BASELINE, 18));
                label[i][j].setForeground(Color.black);
                label[i][j].setBackground(new Color(204, 235, 255));
                label[i][j].setOpaque(true);
                label[i][j].setText(" "+arr[i][j]);
                label[i][j].setSize(new Dimension((int)(Math.log10(Math.abs(arr[i][j]))+1)*2+2, 18));
                label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                if(j==arr[0].length-1){
                    label[i][j].setText(label[i][j].getText() + " ");
                }
                box.add(label[i][j]);
            }
        }
        p.add(box);
        box.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Matrix();
            }
        });
    }

}