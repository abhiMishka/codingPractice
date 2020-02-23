import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Points extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.red);

        int radius = 150;
        int a = 00;
        int b = 00;
        int h = getHeight();
        int w = getWidth()/8;

        for (double i = 0; i <= 360; i=i+0.5) {

            int x = (int) (h-(radius+a) * Math.cos(i));
            int y = (int) (w-(radius+b) * Math.sin(i));
            g2d.drawOval(x, y, 1,1);
        }
    }

    public static void main(String[] args) {
        Points points = new Points();
        JFrame frame = new JFrame("Points");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(points);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
