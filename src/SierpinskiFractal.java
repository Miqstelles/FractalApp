import javax.swing.*;
import java.awt.*;

public class SierpinskiFractal extends JFrame {
    private int iterations;

    public SierpinskiFractal(int iterations) {
        super("Triângulo de Sierpinski");
        this.iterations = iterations;

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new FractalPanel());
        setVisible(true);
    }

    class FractalPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int[] xPoints = {getWidth() / 2, 50, getWidth() - 50};
            int[] yPoints = {50, getHeight() - 50, getHeight() - 50};
            drawSierpinski(g, iterations, xPoints, yPoints);
        }

        private void drawSierpinski(Graphics g, int depth, int[] xPoints, int[] yPoints) {
            if (depth == 0) {
                g.fillPolygon(xPoints, yPoints, 3);
            } else {
                int[] midX = {
                        (xPoints[0] + xPoints[1]) / 2,
                        (xPoints[1] + xPoints[2]) / 2,
                        (xPoints[2] + xPoints[0]) / 2
                };
                int[] midY = {
                        (yPoints[0] + yPoints[1]) / 2,
                        (yPoints[1] + yPoints[2]) / 2,
                        (yPoints[2] + yPoints[0]) / 2
                };

                // Recursivamente desenhar os triângulos menores
                drawSierpinski(g, depth - 1, new int[]{xPoints[0], midX[0], midX[2]}, new int[]{yPoints[0], midY[0], midY[2]});
                drawSierpinski(g, depth - 1, new int[]{midX[0], xPoints[1], midX[1]}, new int[]{midY[0], yPoints[1], midY[1]});
                drawSierpinski(g, depth - 1, new int[]{midX[2], midX[1], xPoints[2]}, new int[]{midY[2], midY[1], yPoints[2]});
            }
        }
    }

    public static void main(String[] args) {
        new SierpinskiFractal(5);
    }
}
