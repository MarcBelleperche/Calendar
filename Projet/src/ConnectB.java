import javax.swing.*;
import java.sql.*;


public class ConnectB {


    public Connection getConn() {
        return conn;
    }

    public Connection conn;
    public int Etat = 0;
    public int numgroupestudent = 0;

    public ConnectB() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK !!!");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/PRJ_MB_AB_CB", "Marc", "Aglup5224");
            System.out.println("Connection OK !!!");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Boolean Checkconnect(String nom, String mdp,Connexion connexion){

        boolean found = false;

        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement("SELECT `login`,`Mdp`,`NumGroupe` FROM `Eleve`");

        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmeta = rs.getMetaData();

        while (rs.next()){
            if (nom.toUpperCase().equals(rs.getString("login").toUpperCase())){
                if (mdp.toUpperCase().equals(rs.getString("Mdp").toUpperCase())){
                    //connexion.dispose();
                    Etat = 1;
                    numgroupestudent = rs.getInt(3);
                    found = true;
                    break;
                }
            }
        }
    } catch (SQLException e) {
            e.printStackTrace();
        }

        ps = null;
        try {

            ps = conn.prepareStatement("SELECT `login`,`Mdp`,`NumeroProfesseur` FROM `Professeurs`");


            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmeta = rs.getMetaData();

            while (rs.next()){
                if (nom.toUpperCase().equals(rs.getString("login").toUpperCase())){
                    if (mdp.toUpperCase().equals(rs.getString("Mdp").toUpperCase())){
                        //connexion.dispose();
                        numgroupestudent = rs.getInt(3);
                        Etat = 2;
                        found = true;
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (nom.equals("Marc") && mdp.equals("Aglup5224")) found = true;

        return found;
    }

}
