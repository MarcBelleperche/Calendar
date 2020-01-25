import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.LinkedList;

public class Cours {

    Connection conn;

    public Cours(Connection conn) throws SQLException {
        this.conn = conn;
        build();
    }

    private void build() throws SQLException {
        JFrame cours = new JFrame("Gestion des cours");
        cours.setSize(700,400);
        cours.setResizable(true);
        cours.setLocationRelativeTo(null);
        cours.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cours.setContentPane(getContentpane());
        cours.setVisible(true);
    }

    private JPanel getContentpane() throws SQLException {

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM `GroupeTD` ");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet rs = ps.executeQuery();

        JPanel coursp = new JPanel();
        coursp.setLayout(new GridLayout(3, 4));

        String groupes[] = new String[6];
        String profs[] = new String[2];
        String horaires[] = new String[6];
        String salle[] = new String[4];
        String jours[] = new String[7];

        jours[0] = "MONDAY";
        jours[1] = "TUESDAY";
        jours[2] = "WEDNESDAY";
        jours[3] = "THURSDAY";
        jours[4] = "FRIDAY";
        jours[5] = "SATURDAY";
        jours[6] = "SUNDAY";
        

        horaires[0] = "08:00:00";
        horaires[1] = "10:00:00";
        horaires[2] = "12:00:00";
        horaires[3] = "14:00:00";
        horaires[4] = "16:00:00";
        horaires[5] = "18:00:00";

        int i = 0;


        while (rs.next()) {
            groupes[i]=(rs.getString(1));
            i++;
        }

        i = 0;
        ps = conn.prepareStatement("SELECT NumeroProfesseur,Nom FROM `Professeurs` ");
        rs = ps.executeQuery();

        while (rs.next()){
            profs[i] = rs.getString(1)+". "+rs.getString(2);
            i++;
        }

        i = 0;
        ps = conn.prepareStatement("SELECT * FROM `Salles`");
        rs = ps.executeQuery();

        while (rs.next()){
            salle[i] = rs.getString(1)+". "+rs.getString(2)+"/"+rs.getString(4);
            i++;
        }

        JLabel courss = new JLabel("Salle : ");
            coursp.add(courss);
            JComboBox selectsalle = new JComboBox(salle);
            coursp.add(selectsalle);

            JLabel horaire = new JLabel("Horaire : ");
            JComboBox selecthoraire = new JComboBox(horaires);
            coursp.add(horaire);
            coursp.add(selecthoraire);

            JLabel groupetd = new JLabel("Groupe : ");
            coursp.add(groupetd);
            JComboBox selectgroupetd = new JComboBox(groupes);
            coursp.add(selectgroupetd);

            JLabel prof = new JLabel("Professeur : ");
            JComboBox selectprof = new JComboBox(profs);
            coursp.add(prof);
            coursp.add(selectprof);

            JLabel jour = new JLabel("Jour : ");
            JComboBox selectjour = new JComboBox(jours);
            coursp.add(jour);
            coursp.add(selectjour);
        
            JButton addcours = new JButton("Add Cours");

            addcours.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        //PreparedStatement nbeleve = conn.prepareStatement("SELECT `NumEleve` FROM `Eleve` WHERE `NumGroupe` = "+selectgroupetd.getSelectedItem().toString()+"");
                        //ResultSet rsa = nbeleve.executeQuery();
                        //while(rsa.next()){
                            String profess = selectprof.getSelectedItem().toString().split("\\.")[0];
                            String salless = selectsalle.getSelectedItem().toString().split("\\.")[0];
                            System.out.println("TEST");
                            PreparedStatement ps = conn.prepareStatement("INSERT INTO `Cours` " +
                                    "(`Code`, `NumeroProfesseur`, `NumGroupe`, `NumCours`, `DateCours`, `Horaire`) " +
                                    "VALUES ('"+Integer.parseInt(salless)+"','"+Integer.parseInt(profess)+"', '"+selectgroupetd.getSelectedItem().toString()+"', '1', '"+selectjour.getSelectedItem().toString().toUpperCase()+"', '"+selecthoraire.getSelectedItem().toString()+"');  ");
                            ps.executeUpdate();
                       // }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            coursp.add(addcours);



        return coursp;
    }

}
