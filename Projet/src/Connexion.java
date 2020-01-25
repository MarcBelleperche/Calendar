import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion extends JFrame {

    String nom = "";
    String psw = "";
    ConnectB cb;
    Connection conn;


    public Connexion(){
        Build();

        try {
            cb = new ConnectB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.conn = cb.getConn();
    }

    public void Build(){

        setSize(400,200);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(getContentPane());

    }

    public JPanel getContentPane(){
        JPanel fenetremdp = new JPanel();

        fenetremdp.setLayout(new FlowLayout());
        fenetremdp.setBackground(Color.LIGHT_GRAY);

        JLabel name = new JLabel("User");
        JLabel mdp = new JLabel("Password");

        JTextField nameu = new JTextField();
        nameu.setColumns(10);
        JPasswordField mdpu = new JPasswordField();
        mdpu.setColumns(10);

        JButton submit = new JButton("Submit");
        Connexion c1 = this;
        
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                nom = nameu.getText();
                psw = mdpu.getText();
                found = cb.Checkconnect(nom,psw,c1);
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                System.out.println("Driver OK !!!");
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/PRJ_MB_AB_CB", "Marc", "Aglup5224");
                System.out.println("Connection OK !!!");
                if (found == true){
                dispose();
                    Calendar cal1 = new Calendar(conn,cb.Etat,cb.numgroupestudent);}

                    else {JOptionPane.showMessageDialog(null,"WRONG PSW OR LOGIN");}
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"WRONG PSW OR LOGIN");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"WRONG PSW OR LOGIN");
                }
            }
        });

        fenetremdp.add(name);
        fenetremdp.add(nameu);
        fenetremdp.add(mdp);
        fenetremdp.add(mdpu);
        fenetremdp.add(submit);
        return fenetremdp;
    }

}
