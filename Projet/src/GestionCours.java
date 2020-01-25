import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigestSpi;
import java.sql.*;

public class GestionCours {

    int i = 0;
    int nbprof = 0;
    Connection conn;

    public GestionCours(Connection conn,int nbprof) throws SQLException {
        this.nbprof = nbprof;
        this.conn = conn;
        build();
    }

    private void build() throws SQLException {
        JFrame modifgroupe = new JFrame("Modification des groupes de cours");
        modifgroupe.setSize(700,400);
        modifgroupe.setResizable(true);
        modifgroupe.setLocationRelativeTo(null);
        modifgroupe.setContentPane(getContentpane());
        modifgroupe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        modifgroupe.setVisible(true);
    }

    private JPanel getContentpane() throws SQLException {

        JPanel global = new JPanel();
        global.setLayout(new BorderLayout());

        PreparedStatement ps;
        ResultSet rs;

        String [] salle = new String[4];

        i = 0;
        ps = conn.prepareStatement("SELECT * FROM `Salles`");
        rs = ps.executeQuery();

        while (rs.next()){
            salle[i] = rs.getString(1)+". "+rs.getString(2)+"/"+rs.getString(4);
            i++;
        }



        i = 0;
        ps = conn.prepareStatement("SELECT * FROM `Cours` WHERE `NumeroProfesseur`  = "+nbprof+"");
        rs = ps.executeQuery();

        while (rs.next()){
            i++;
        }

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(i,6));

        ResultSet rsp;
        ps = conn.prepareStatement("SELECT * FROM `Cours` WHERE `NumeroProfesseur`  = "+nbprof+"");
        rsp = ps.executeQuery();

        while (rsp.next()) {

            JLabel nbgroupe = new JLabel("Numero de groupe : ");
            main.add(nbgroupe);
            JLabel nbgroup = new JLabel(rsp.getString(3));
            main.add(nbgroup);
            JLabel code = new JLabel("Code salle : ");
            main.add(code);
            JLabel cod = new JLabel(rsp.getString(1));
            main.add(cod);
            JLabel salles = new JLabel("Salle : ");
            JComboBox sal = new JComboBox(salle);

            main.add(salles);
            main.add(sal);


            JButton upt = new JButton("UPDATE");
            upt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Statement state = null;
                    try {
                        state = conn.createStatement();
                        state.executeUpdate("UPDATE `Cours` SET `Code` = '" + sal.getSelectedItem() + "' WHERE `Cours`.`Code` = " + rsp.getString(1) + " AND `Cours`.`NumeroProfesseur` = " + rsp.getString(2) + " AND `Cours`.`DateCours` = '" + rsp.getString(5) + "' AND `Cours`.`Horaire` = '" + rsp.getString(6) + "';\n");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "La salle que vous avez selectionnez est deja selectionnée");
                    }
                }
            });

            main.add(upt);
        }
        global.add(main,BorderLayout.CENTER);

        return global;
    }
}
