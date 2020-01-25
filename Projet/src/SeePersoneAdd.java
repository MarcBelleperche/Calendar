import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.lang.Integer.parseInt;

public class SeePersoneAdd {

    Connection conn;
    JFrame affichaetud;
    Statement state;
    int nbligne = 0;
    public int id;

    public SeePersoneAdd(Connection conn) throws SQLException {
        this.conn = conn;
        affichageetudiant();
    }

    private void affichageetudiant() throws SQLException {

        affichaetud = new JFrame("Gestion des etudiants");
        affichaetud.setSize(700,400);
        affichaetud.setResizable(true);
        affichaetud.setLocationRelativeTo(null);
        affichaetud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        affichaetud.setContentPane(getContentpane());
    }

    private Container getContentpane() throws SQLException {
        nbligne = 0;
        JPanel affichageetudiant = new JPanel();
        affichageetudiant.setLayout(new BorderLayout());


        try {
            state = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps = conn.prepareStatement("select * from Eleve");
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            nbligne += 5;
        }

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(nbligne,2));

        JPanel boutonaction = new JPanel();
        boutonaction.setLayout(new GridLayout(((nbligne/5)*3),1));


        ResultSet rsr = ps.executeQuery();


        while(rsr.next()) {

            JLabel num = new JLabel(rsr.getString("NumEleve"));

            JLabel name = new JLabel("Nom de Famille :");
            center.add(name);

            JLabel namee = new JLabel(rsr.getString("Nom"));
            center.add(namee);

            JLabel surname = new JLabel("Nom :");
            center.add(surname);

            JLabel surnamee = new JLabel(rsr.getString("Prenom"));
            center.add(surnamee);

            JLabel login = new JLabel("Login :");
            center.add(login);

            JLabel logine = new JLabel(rsr.getString("login"));
            center.add(logine);

            JLabel mdp = new JLabel("MDP : ");
            center.add(mdp);

            JLabel mdpe = new JLabel(rsr.getString("mdp"));
            center.add(mdpe);

            JLabel space = new JLabel("");
            center.add(space);

            JLabel space2 = new JLabel("");
            center.add(space2);

            id = rsr.getInt("NumEleve");

            JButton delete = new JButton("Delete");
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        //PreparedStatement ps = conn.prepareStatement("SELECT `NumEleve`,`Nom` FROM `Eleve` WHERE `Nom` = '"+namee.getText().toUpperCase()+"'");
                        //ResultSet rsr = ps.executeQuery();

                        /*while (rsr.next()) {
                            state.executeUpdate("DELETE " +
                                    "FROM `Cours`\n" +
                                    "WHERE `Cours`.`NumEleve` = '" + rsr.getString(1) + "';");
                        }*/
                        state.executeUpdate("DELETE FROM `Eleve` WHERE `Eleve`.`Nom` = '"+namee.getText().toUpperCase()+"' ");
                        affichaetud.setContentPane(getContentpane());
                        affichaetud.revalidate();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            boutonaction.add(delete);

            JButton modify = new JButton("Modify");
            modify.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.out.println(parseInt(num.getText()));
                        Gestion g1 = new Gestion(conn,parseInt(num.getText()));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            boutonaction.add(modify);

            JLabel space3 = new JLabel("");
            boutonaction.add(space3);
        }

        JPanel addetu = new JPanel();
        addetu.setLayout(new GridLayout(5,3));

        JLabel surname = new JLabel("Prenom :");
        addetu.add(surname);

        JTextField surnamee = new JTextField();
        addetu.add(surnamee);

        JLabel name = new JLabel("Nom de Famille :");
        addetu.add(name);

        JTextField namee = new JTextField();
        addetu.add(namee);

        JLabel login = new JLabel("Login :");
        addetu.add(login);

        JTextField logine = new JTextField();
        addetu.add(logine);

        JLabel mdp = new JLabel("MDP : ");
        addetu.add(mdp);

        JPasswordField mdpe = new JPasswordField();
        addetu.add(mdpe);

        JButton add = new JButton("ADD");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statement state2 = null;
                try {
                    state2 = conn.createStatement();
                    state2.executeUpdate("INSERT INTO `Eleve` (`Nom`, `Prenom`, `login`, `Mdp`) VALUES ('"+namee.getText().toUpperCase()+"','"+surnamee.getText().toUpperCase()+"','"+logine.getText().toUpperCase()+"','"+mdpe.getText().toUpperCase()+"');");
                    //state2.executeUpdate("CREATE USER '"+logine.getText().toUpperCase()+"'@'%' IDENTIFIED WITH mysql_native_password AS '"+mdpe.getText().toUpperCase()+"';" +
                    //        "GRANT SELECT ON *.* TO '"+logine.getText().toUpperCase()+"'@'%' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;" +
                    //        "GRANT ALL PRIVILEGES ON `Projet_BDD2`.* TO '"+logine.getText().toUpperCase()+"'@'%';\n");
                affichaetud.setContentPane(getContentpane());
                affichaetud.revalidate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        addetu.add(add);




        affichageetudiant.add(center,BorderLayout.CENTER);
        affichageetudiant.add(boutonaction,BorderLayout.EAST);
        affichageetudiant.add(addetu,BorderLayout.SOUTH);

        return affichageetudiant;

    }
}
