import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Gestion {

    public Connection conn;
    public int id;
    JFrame gestion;

    public Gestion(Connection conn,int id) throws SQLException {
        this.conn = conn;
        this.id = id;
        jframecreation().setVisible(true);
    }

    public JFrame jframecreation() throws SQLException {

        gestion = new JFrame();
        gestion.setSize(700,400);
        gestion.setResizable(true);
        gestion.setLocationRelativeTo(null);
        gestion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestion.setContentPane(getContentpane());
        return gestion;

    }

    private Container getContentpane() throws SQLException {


        JPanel persone = new JPanel();
        persone.setLayout(new BorderLayout());

        JPanel labelpanel = new JPanel();
        labelpanel.setLayout(new GridLayout(20,1));

        JPanel fieldpanel = new JPanel();
        fieldpanel.setLayout(new GridLayout(20,1));

        JPanel titlepanel = new JPanel();
        titlepanel.setLayout(new FlowLayout());

        JLabel title = new JLabel("Here you can modify the student : ");
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        Font fonte = new Font(" TimesRoman ",Font.ITALIC,15);
        title.setFont(fonte);


        persone.setBackground(Color.LIGHT_GRAY);
        // CHAMPS DE TEXT NECESSAIRE POUR LA CREATION POUR UNE PERSONNE

        PreparedStatement ps = null;
        System.out.println(id);
        System.out.println("select * from `Eleve` Where `NumEleve` = "+id+"");
        ps = conn.prepareStatement("select * from `Eleve` Where `NumEleve` = "+id+"");
        ResultSet rs = ps.executeQuery();

        System.out.println("Request ok");

        while (rs.next()) {


            JLabel name = new JLabel("Nom* : ");
            JTextField namef = new JTextField(rs.getString("Nom"));
            namef.setColumns(30);
            labelpanel.add(name);
            fieldpanel.add(namef);

            JLabel surname = new JLabel("Nom de Famille* : ");
            JTextField surnamef = new JTextField(rs.getString("Prenom"));
            surnamef.setColumns(30);
            labelpanel.add(surname);
            fieldpanel.add(surnamef);

            JLabel login = new JLabel("Login* :");
            JTextField loginf = new JTextField(rs.getString("Login"));
            loginf.setColumns(30);
            labelpanel.add(login);
            fieldpanel.add(loginf);


            JLabel mdp = new JLabel("Mot de passe* : ");
            JPasswordField mdpf = new JPasswordField(rs.getString("mdp"));
            mdpf.setColumns(30);
            labelpanel.add(mdp);
            fieldpanel.add(mdpf);

            JLabel codepost = new JLabel("CodePostal : ");
            JTextField codepostf = new JTextField(rs.getString("CodePostal"));
            namef.setColumns(30);
            labelpanel.add(codepost);
            fieldpanel.add(codepostf);

            JLabel dateinscription = new JLabel("Date d'inscritption : ");
            JTextField dateinscriptionf = new JTextField(rs.getString("DateInscription"));
            surnamef.setColumns(30);
            labelpanel.add(dateinscription);
            fieldpanel.add(dateinscriptionf);

            JLabel birthday = new JLabel("Date de naissance : ");
            JTextField birthdayf = new JTextField(rs.getString("DateNaissance"));
            namef.setColumns(30);
            labelpanel.add(birthday);
            fieldpanel.add(birthdayf);

            JLabel email = new JLabel("Email : ");
            JTextField emailf = new JTextField(rs.getString("Email"));
            surnamef.setColumns(30);
            labelpanel.add(email);
            fieldpanel.add(emailf);

            JLabel lastschool = new JLabel("Etablissement précédent : ");
            JTextField lastschoolf = new JTextField(rs.getString("EtablissementPrec"));
            namef.setColumns(30);
            labelpanel.add(lastschool);
            fieldpanel.add(lastschoolf);

            JLabel numeleve = new JLabel("Numero Eleve : ");
            JTextField numelevef = new JTextField(rs.getString("NumEleve"));
            surnamef.setColumns(30);
            labelpanel.add(numeleve);
            fieldpanel.add(numelevef);

            JLabel numrue = new JLabel("Numero/Nom de la rue : ");
            JTextField numruef = new JTextField(rs.getString("NumeroNomRue"));
            namef.setColumns(30);
            labelpanel.add(numrue);
            fieldpanel.add(numruef);

            JLabel numgroupe = new JLabel("Numéro du groupe : ");
            JTextField numgroupef = new JTextField(rs.getString("NumGroupe"));
            surnamef.setColumns(30);
            labelpanel.add(numgroupe);
            fieldpanel.add(numgroupef);

            JLabel numpromo = new JLabel("Numéro de la promotion : ");
            JTextField numpromof = new JTextField(rs.getString("NumPromotion"));
            namef.setColumns(30);
            labelpanel.add(numpromo);
            fieldpanel.add(numpromof);

            JLabel paysdenaissance = new JLabel("Pays de naissance : ");
            JTextField paysdenaissancef = new JTextField(rs.getString("PaysNaissance"));
            surnamef.setColumns(30);
            labelpanel.add(paysdenaissance);
            fieldpanel.add(paysdenaissancef);

            JLabel photo = new JLabel("Photo : ");
            JTextField photof = new JTextField(rs.getString("Photo"));
            namef.setColumns(30);
            labelpanel.add(photo);
            fieldpanel.add(photof);

            JLabel sexe = new JLabel("Sexe : ");
            JTextField sexef = new JTextField(rs.getString("Sexe"));
            surnamef.setColumns(30);
            labelpanel.add(sexe);
            fieldpanel.add(sexef);

            JLabel teldom = new JLabel("Tel. Domicile : ");
            JTextField teldomf = new JTextField(rs.getString("TelDomicile"));
            namef.setColumns(30);
            labelpanel.add(teldom);
            fieldpanel.add(teldomf);

            JLabel telmob = new JLabel("Tel. Mobile : ");
            JTextField telmobf = new JTextField(rs.getString("TelMObile"));
            surnamef.setColumns(30);
            labelpanel.add(telmob);
            fieldpanel.add(telmobf);

            JLabel ville = new JLabel("Ville : ");
            JTextField villef = new JTextField("NULL");
            namef.setColumns(30);
            labelpanel.add(ville);
            fieldpanel.add(villef);

            JLabel villedenaissance = new JLabel("Ville de naissance : ");
            JTextField villedenaissancef = new JTextField(rs.getString("VilleNaissance"));
            surnamef.setColumns(30);
            labelpanel.add(villedenaissance);
            fieldpanel.add(villedenaissancef);

            // ACTION BOUTON
            JPanel action = new JPanel();
            action.setLayout(new GridLayout(2, 1));
            JButton modify = new JButton("Delete");
            JButton delete = new JButton("Modify");
            action.add(modify);
            action.add(delete);

            JPanel boutonpanel = new JPanel();
            boutonpanel.setLayout(new GridLayout(4, 1));
            boutonpanel.add(action);


            JButton submit = new JButton("SUBMIT");
            submit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Statement state2 = null;
                    try {
                        state2 = conn.createStatement();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        state2.executeUpdate("UPDATE `Eleve` SET " +
                                " `Nom` = '"+namef.getText().toUpperCase()+"', `Prenom` = '"+surnamef.getText().toUpperCase()+"'," +
                                " `DateNaissance` = '"+birthdayf.getText().toUpperCase()+"'," +
                                " `VilleNaissance` = '"+villedenaissancef.getText().toUpperCase()+"'," +
                                " `PaysNaissance` = '"+paysdenaissancef.getText().toUpperCase()+"'," +
                                " `Sexe` = '"+sexef.getText().toUpperCase()+"', " +
                                "`DateInscription` = '"+dateinscriptionf.getText().toUpperCase()+"'," +
                                " `EtablissementPrec` = '"+lastschoolf.getText().toUpperCase()+"', " +
                                "`Photo` = '"+photof.getText().toUpperCase()+"', " +
                                "`NumeroNomRue` = '"+numruef.getText().toUpperCase()+"', " +
                                "`CodePostal` = '"+codepostf.getText().toUpperCase()+"', " +
                                "`Ville` = '"+villef.getText().toUpperCase()+"', " +
                                "`TelMobile` = '"+telmobf.getText().toUpperCase()+"', " +
                                "`TelDomicile` = '"+teldomf.getText().toUpperCase()+"', " +
                                "`Email` = '"+emailf.getText().toUpperCase()+"', `login` = '"+loginf.getText().toUpperCase()+"', " +
                                "`Mdp` = '"+mdpf.getText().toUpperCase()+"', `NumGroupe` = '"+numgroupef.getText().toUpperCase()+"'," +
                                " `NumPromotion` = '"+numpromof.getText().toUpperCase()+"' WHERE `Eleve`.`NumEleve` = "+id+";");
                        //state.executeUpdate("CREATE USER '"+loginf.getText().toUpperCase()+"'@'%' IDENTIFIED WITH mysql_native_password AS '"+mdpf.getText().toUpperCase()+"'; GRANT SELECT ON *.* TO '"+loginf.getText().toUpperCase()+"'@'%' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;GRANT ALL PRIVILEGES ON `Projet_BDD2`.* TO '"+loginf.getText().toUpperCase()+"'@'%';\n");
                        gestion.dispose();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }
            });

            persone.add(labelpanel, BorderLayout.WEST);
            persone.add(fieldpanel, BorderLayout.CENTER);
            persone.add(boutonpanel, BorderLayout.EAST);
            persone.add(submit, BorderLayout.SOUTH);
            persone.add(title, BorderLayout.NORTH);
        }
            return persone;

    }

    /*public JTextField setNull(String value){
        if (value.equals(null)) {
            return "NULL";
        }
        else return value;
    }*/

}
