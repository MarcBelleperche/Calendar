import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Calendar {

    Color blueefrei = new Color(52, 152, 219);
    Color purpleefrei = new Color(142, 68, 173);
    Connection conn;
    JFrame calendar;
    String groupes[] = new String[6];
    String value = "1";
    int log = 0;
    int nbgroupestudent = 0;

    public Calendar(Connection conn, int log, int nbgroupestudent) throws SQLException {
        this.conn = conn;
        this.log = log;
        this.nbgroupestudent = nbgroupestudent;
        build();
    }

    public void build() throws SQLException {
        calendar = new JFrame("Calendar");
        calendar.setSize(700,400);
        calendar.setResizable(true);
        calendar.setLocationRelativeTo(null);
        calendar.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calendar.setContentPane(getcontentPane());
        calendar.setVisible(true);
    }

    private JPanel getcontentPane() throws SQLException {


        PreparedStatement psp = conn.prepareStatement("SELECT `NumGroupe`,`NomGroupe` FROM `GroupeTD`");
        ResultSet rsp = psp.executeQuery();
        int i = 0;
        while (rsp.next()) {
            groupes[i]=(rsp.getString(1))+". "+rsp.getString(2);
            i++;
        }

        JComboBox selectgroupetd = new JComboBox(groupes);
        selectgroupetd.setSelectedIndex(Integer.parseInt(value)-1);


        PreparedStatement ps = conn.prepareStatement("SELECT `Horaire`,`DateCours`,`NumGroupe` FROM `Cours` NATURAL JOIN `Eleve` ");
        ResultSet rs = ps.executeQuery();
        Boolean m8 = false;
        Boolean m10 = false;
        Boolean m12 = false;
        Boolean m14 = false;
        Boolean m16 = false;
        Boolean m18 = false;

        Boolean t8 = false;
        Boolean t10 = false;
        Boolean t12 = false;
        Boolean t14 = false;
        Boolean t16 = false;
        Boolean t18 = false;

        Boolean w8 = false;
        Boolean w10 = false;
        Boolean w12 = false;
        Boolean w14 = false;
        Boolean w16 = false;
        Boolean w18 = false;

        Boolean tu8 = false;
        Boolean tu10 = false;
        Boolean tu12 = false;
        Boolean tu14 = false;
        Boolean tu16 = false;
        Boolean tu18 = false;

        Boolean f8 = false;
        Boolean f10 = false;
        Boolean f12 = false;
        Boolean f14 = false;
        Boolean f16 = false;
        Boolean f18 = false;

        Boolean s8 = false;
        Boolean s10 = false;
        Boolean s12 = false;
        Boolean s14 = false;
        Boolean s16 = false;
        Boolean s18 = false;

        Boolean suns8 = false;
        Boolean suns10 = false;
        Boolean suns12 = false;
        Boolean suns14 = false;
        Boolean suns16 = false;
        Boolean suns18 = false;

        String seleciton = selectgroupetd.getSelectedItem().toString().split("\\.")[0];

        if (log == 1){
            seleciton = String.valueOf(nbgroupestudent);
        }

        while (rs.next()) {

            if (rs.getString(3).indexOf(seleciton)!= - 1) {

                if (rs.getString(2).indexOf("MONDAY") != -1 && rs.getString(1).indexOf("08:00:00") != -1) m8 = true;
                if (rs.getString(2).indexOf("MONDAY") != -1 && rs.getString(1).indexOf("10:00:00") != -1) m10 = true;
                if (rs.getString(2).indexOf("MONDAY") != -1 && rs.getString(1).indexOf("12:00:00") != -1) m12 = true;
                if (rs.getString(2).indexOf("MONDAY") != -1 && rs.getString(1).indexOf("14:00:00") != -1) m14 = true;
                if (rs.getString(2).indexOf("MONDAY") != -1 && rs.getString(1).indexOf("16:00:00") != -1) m16 = true;
                if (rs.getString(2).indexOf("MONDAY") != -1 && rs.getString(1).indexOf("18:00:00") != -1) m18 = true;

                if (rs.getString(2).indexOf("TUESDAY") != -1 && rs.getString(1).indexOf("08:00:00") != -1) t8 = true;
                if (rs.getString(2).indexOf("TUESDAY") != -1 && rs.getString(1).indexOf("10:00:00") != -1) t10 = true;
                if (rs.getString(2).indexOf("TUESDAY") != -1 && rs.getString(1).indexOf("12:00:00") != -1) t12 = true;
                if (rs.getString(2).indexOf("TUESDAY") != -1 && rs.getString(1).indexOf("14:00:00") != -1) t14 = true;
                if (rs.getString(2).indexOf("TUESDAY") != -1 && rs.getString(1).indexOf("16:00:00") != -1) t16 = true;
                if (rs.getString(2).indexOf("TUESDAY") != -1 && rs.getString(1).indexOf("18:00:00") != -1) t18 = true;

                if (rs.getString(2).indexOf("WEDNESDAY") != -1 && rs.getString(1).indexOf("08:00:00") != -1) w8 = true;
                if (rs.getString(2).indexOf("WEDNESDAY") != -1 && rs.getString(1).indexOf("12:00:00") != -1) w12 = true;
                if (rs.getString(2).indexOf("WEDNESDAY") != -1 && rs.getString(1).indexOf("14:00:00") != -1) w14 = true;
                if (rs.getString(2).indexOf("WEDNESDAY") != -1 && rs.getString(1).indexOf("16:00:00") != -1) w16 = true;
                if (rs.getString(2).indexOf("WEDNESDAY") != -1 && rs.getString(1).indexOf("18:00:00") != -1) w18 = true;

                if (rs.getString(2).indexOf("THURSDAY") != -1 && rs.getString(1).indexOf("08:00:00") != -1) tu8 = true;
                if (rs.getString(2).indexOf("THURSDAY") != -1 && rs.getString(1).indexOf("10:00:00") != -1) tu10 = true;
                if (rs.getString(2).indexOf("THURSDAY") != -1 && rs.getString(1).indexOf("12:00:00") != -1) tu12 = true;
                if (rs.getString(2).indexOf("THURSDAY") != -1 && rs.getString(1).indexOf("14:00:00") != -1) tu14 = true;
                if (rs.getString(2).indexOf("THURSDAY") != -1 && rs.getString(1).indexOf("16:00:00") != -1) tu16 = true;
                if (rs.getString(2).indexOf("THURSDAY") != -1 && rs.getString(1).indexOf("18:00:00") != -1) tu18 = true;

                if (rs.getString(2).indexOf("FRIDAY") != -1 && rs.getString(1).indexOf("08:00:00") != -1) f8 = true;
                if (rs.getString(2).indexOf("FRIDAY") != -1 && rs.getString(1).indexOf("10:00:00") != -1) f10 = true;
                if (rs.getString(2).indexOf("FRIDAY") != -1 && rs.getString(1).indexOf("12:00:00") != -1) f12 = true;
                if (rs.getString(2).indexOf("FRIDAY") != -1 && rs.getString(1).indexOf("14:00:00") != -1) f14 = true;
                if (rs.getString(2).indexOf("FRIDAY") != -1 && rs.getString(1).indexOf("16:00:00") != -1) f16 = true;
                if (rs.getString(2).indexOf("FRIDAY") != -1 && rs.getString(1).indexOf("18:00:00") != -1) f18 = true;

                if (rs.getString(2).indexOf("SATURDAY") != -1 && rs.getString(1).indexOf("08:00:00") != -1) s8 = true;
                if (rs.getString(2).indexOf("SATURDAY") != -1 && rs.getString(1).indexOf("10:00:00") != -1) s10 = true;
                if (rs.getString(2).indexOf("SATURDAY") != -1 && rs.getString(1).indexOf("12:00:00") != -1) s12 = true;
                if (rs.getString(2).indexOf("SATURDAY") != -1 && rs.getString(1).indexOf("14:00:00") != -1) s14 = true;
                if (rs.getString(2).indexOf("SATURDAY") != -1 && rs.getString(1).indexOf("16:00:00") != -1) s16 = true;
                if (rs.getString(2).indexOf("SATURDAY") != -1 && rs.getString(1).indexOf("18:00:00") != -1) s18 = true;

                if (rs.getString(2).indexOf("SUNDAY") != -1 && rs.getString(1).indexOf("08:00:00") != -1) suns8 = true;
                if (rs.getString(2).indexOf("SUNDAY") != -1 && rs.getString(1).indexOf("10:00:00") != -1) suns10 = true;
                if (rs.getString(2).indexOf("SUNDAY") != -1 && rs.getString(1).indexOf("12:00:00") != -1) suns12 = true;
                if (rs.getString(2).indexOf("SUNDAY") != -1 && rs.getString(1).indexOf("14:00:00") != -1) suns14 = true;
                if (rs.getString(2).indexOf("SUNDAY") != -1 && rs.getString(1).indexOf("16:00:00") != -1) suns16 = true;
                if (rs.getString(2).indexOf("SUNDAY") != -1 && rs.getString(1).indexOf("18:00:00") != -1) suns18 = true;


            }
        }
        
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel cal = new JPanel();
        cal.setLayout(new GridLayout(7,7));

        // MONDAY
        JLabel monday = new JLabel("Monday");
        monday.setHorizontalAlignment(SwingConstants.CENTER);
        cal.add(monday);

        JLabel tuesday = new JLabel("Tuesday");
        tuesday.setHorizontalAlignment(SwingConstants.CENTER);
        cal.add(tuesday);

        JLabel wednesday = new JLabel("Wednesday");
        wednesday.setHorizontalAlignment(SwingConstants.CENTER);
        cal.add(wednesday);

        JLabel thursday = new JLabel("Thursday");
        thursday.setHorizontalAlignment(SwingConstants.CENTER);
        cal.add(thursday);

        JLabel friday = new JLabel("Friday");
        friday.setHorizontalAlignment(SwingConstants.CENTER);
        cal.add(friday);

        JLabel saturday = new JLabel("Saturday");
        saturday.setHorizontalAlignment(SwingConstants.CENTER);
        cal.add(saturday);

        JLabel sunday = new JLabel("Sunday");
        sunday.setHorizontalAlignment(SwingConstants.CENTER);
        cal.add(sunday);


        JPanel mon8 = new JPanel();
        if (m8 == true)mon8.setBackground(blueefrei);
        mon8.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(mon8);
        JPanel tue8 = new JPanel();
        if (t8 == true)tue8.setBackground(blueefrei);
        tue8.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tue8);
        JPanel wed8 = new JPanel();
        if (w8 == true)wed8.setBackground(blueefrei);
        wed8.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(wed8);
        JPanel tues8 = new JPanel();
        if (tu8 == true)tues8.setBackground(blueefrei);
        tues8.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tues8);
        JPanel fri8 = new JPanel();
        if (f8 == true)fri8.setBackground(blueefrei);
        fri8.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(fri8);
        JPanel sat8 = new JPanel();
        if (s8 == true)sat8.setBackground(blueefrei);
        sat8.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sat8);
        JPanel sun8 = new JPanel();
        if (suns8 == true)sun8.setBackground(blueefrei);
        sun8.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sun8);




        JPanel mon10 = new JPanel();
        if (m10 == true)mon10.setBackground(blueefrei);
        mon10.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(mon10);
        JPanel tue10 = new JPanel();
        if (t10 == true)tue10.setBackground(blueefrei);
        tue10.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tue10);
        JPanel wed10 = new JPanel();
        if (w10 == true)wed10.setBackground(blueefrei);
        wed10.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(wed10);
        JPanel tues10 = new JPanel();
        if (tu10 == true)tues10.setBackground(blueefrei);
        tues10.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tues10);
        JPanel fri10 = new JPanel();
        if (f10 == true)fri10.setBackground(blueefrei);
        fri10.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(fri10);
        JPanel sat10 = new JPanel();
        if (s10 == true)sat10.setBackground(blueefrei);
        sat10.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sat10);
        JPanel sun10 = new JPanel();
        if (suns10 == true)sun10.setBackground(blueefrei);
        sun10.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sun10);

        JPanel mon12 = new JPanel();
        if (m12 == true)mon12.setBackground(blueefrei);
        mon12.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(mon12);
        JPanel tue12 = new JPanel();
        if (t12 == true)tue12.setBackground(blueefrei);
        tue12.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tue12);
        JPanel wed12 = new JPanel();
        if (w12 == true)wed12.setBackground(blueefrei);
        wed12.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(wed12);
        JPanel tues12 = new JPanel();
        if (tu12 == true)tues12.setBackground(blueefrei);
        tues12.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tues12);
        JPanel fri12 = new JPanel();
        if (f12 == true)fri12.setBackground(blueefrei);
        fri12.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(fri12);
        JPanel sat12 = new JPanel();
        if (s12 == true)sat12.setBackground(blueefrei);
        sat12.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sat12);
        JPanel sun12 = new JPanel();
        if (suns12 == true)sun12.setBackground(blueefrei);
        sun12.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sun12);


        JPanel mon14 = new JPanel();
        if (m14 == true)mon14.setBackground(blueefrei);
        mon14.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(mon14);
        JPanel tue14 = new JPanel();
        if (t14 == true)tue14.setBackground(blueefrei);
        tue14.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tue14);
        JPanel wed14 = new JPanel();
        if (w14 == true)wed14.setBackground(blueefrei);
        wed14.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(wed14);
        JPanel tues14 = new JPanel();
        if (tu14 == true)tues14.setBackground(blueefrei);
        tues14.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tues14);
        JPanel fri14 = new JPanel();
        if (f14 == true)fri14.setBackground(blueefrei);
        fri14.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(fri14);
        JPanel sat14 = new JPanel();
        if (s14 == true)sat14.setBackground(blueefrei);
        sat14.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sat14);
        JPanel sun14 = new JPanel();
        if (suns14 == true)sun14.setBackground(blueefrei);
        sun14.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sun14);

        JPanel mon16 = new JPanel();
        if (m16 == true)mon16.setBackground(blueefrei);
        mon16.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(mon16);
        JPanel tue16 = new JPanel();
        if (t16 == true)tue16.setBackground(blueefrei);
        tue16.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tue16);
        JPanel wed16 = new JPanel();
        if (w16 == true)wed16.setBackground(blueefrei);
        wed16.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(wed16);
        JPanel tues16 = new JPanel();
        if (tu16 == true)tues16.setBackground(blueefrei);
        tues16.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tues16);
        JPanel fri16 = new JPanel();
        if (f16 == true)fri16.setBackground(blueefrei);
        fri16.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(fri16);
        JPanel sat16 = new JPanel();
        if (s16 == true)sat16.setBackground(blueefrei);
        sat16.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sat16);
        JPanel sun16 = new JPanel();
        if (suns16 == true)sun16.setBackground(blueefrei);
        sun16.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sun16);

        JPanel mon18 = new JPanel();
        if (m18 == true)mon18.setBackground(blueefrei);
        mon18.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(mon18);
        JPanel tue18 = new JPanel();
        if (t18 == true)tue18.setBackground(blueefrei);
        tue18.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tue18);
        JPanel wed18 = new JPanel();
        if (w18 == true)wed18.setBackground(blueefrei);
        wed18.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(wed18);
        JPanel tues18 = new JPanel();
        if (tu18 == true)tues18.setBackground(blueefrei);
        tues18.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(tues18);
        JPanel fri18 = new JPanel();
        if (f18 == true)fri18.setBackground(blueefrei);
        fri18.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(fri18);
        JPanel sat18 = new JPanel();
        if (s18 == true)sat18.setBackground(blueefrei);
        sat18.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sat18);
        JPanel sun18 = new JPanel();
        if (suns18 == true)sun18.setBackground(blueefrei);
        sun18.setBorder(BorderFactory.createLineBorder(Color.black));
        cal.add(sun18);

        JPanel horaire = new JPanel();
        horaire.setLayout(new GridLayout(7,1));

        JLabel time = new JLabel("Horaires/Jours");
        horaire.add(time);
        JLabel eight = new JLabel("8h - 10 h");
        horaire.add(eight);
        JLabel ten = new JLabel("10h - 12h");
        horaire.add(ten);
        JLabel twelve = new JLabel("12h - 14h");
        horaire.add(twelve);
        JLabel fourteen = new JLabel("14h - 16h");
        horaire.add(fourteen);
        JLabel sixteen = new JLabel("16h - 18h");
        horaire.add(sixteen);
        JLabel eighteen = new JLabel("18h - 20h");
        horaire.add(eighteen);

        System.out.println(log);

        if (log != 1 & log != 2) {

            JPanel actionbtn = new JPanel();
            actionbtn.setLayout(new GridLayout(1, 5));

            JButton gestioneleve = new JButton("Gestion Eleves");
            gestioneleve.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SeePersoneAdd spa = null;
                    try {
                        spa = new SeePersoneAdd(conn);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    spa.affichaetud.setVisible(true);
                }
            });

            actionbtn.add(gestioneleve);

            JButton cours = new JButton("Gestion cours");
            cours.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Cours c1 = new Cours(conn);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            actionbtn.add(cours);

            JButton credits = new JButton("A Propos");
            credits.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            actionbtn.add(credits);

            JButton refresh = new JButton("RFRSH");
            refresh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        calendar.setContentPane(getcontentPane());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    calendar.revalidate();
                }
            });
            actionbtn.add(refresh);

            actionbtn.add(selectgroupetd);

            selectgroupetd.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try {
                        String val = selectgroupetd.getSelectedItem().toString().split("\\.")[0];
                        value = val;
                        calendar.setContentPane(getcontentPane());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    calendar.revalidate();
                }
            });

            main.add(actionbtn,BorderLayout.NORTH);

        }
        else if (log == 2){

            JPanel profmodif = new JPanel();
            profmodif.setLayout(new GridLayout(1,2));
            selectgroupetd.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try {
                        String val = selectgroupetd.getSelectedItem().toString().split("\\.")[0];
                        value = val;
                        calendar.setContentPane(getcontentPane());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    calendar.revalidate();
                }
            });

            JButton modifcours = new JButton("Modifications Cours");
            modifcours.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        GestionCours gc = new GestionCours(conn,nbgroupestudent);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });


            profmodif.add(modifcours);
            profmodif.add(selectgroupetd);
            main.add(profmodif,BorderLayout.NORTH);
        }

        cal.setBackground(Color.WHITE);
        main.add(cal,BorderLayout.CENTER);
        main.add(horaire,BorderLayout.WEST);

        return main;
    }
}
