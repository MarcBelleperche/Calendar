import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Statement;

public class Main {

    static Connexion c1;

    public static void main (String agrs[]) throws SQLException, IOException {

        //Lauching();
        c1 = new Connexion();
        c1.setVisible(true);
        //c1.setVisible(true);
        //SeePersoneAdd seePersoneAdd =  new SeePersoneAdd(c1.conn);

    }

    /*public static void Lauching() throws IOException {

        JWindow win = new JWindow();
        JPanel pane = new JPanel();
        JLabel image = new JLabel(new ImageIcon("BDD.jpg"));
        pane.setLayout(new BorderLayout());
        pane.add(image, BorderLayout.CENTER);
        win.setContentPane(pane);
        win.setSize(640, 375);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        win.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    win.dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }*/

}
