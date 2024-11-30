import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotFractal extends JFrame {
    private int width = 800;
    private int height = 800;
    private int maxIterations;

    public MandelbrotFractal(int iterations) {
        super("Fractal de Mandelbrot");
        this.maxIterations = iterations;

        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new FractalPanel());
        setVisible(true);
    }

    class FractalPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage fractalImage = generateMandelbrotFractal();
            g.drawImage(fractalImage, 0, 0, null);
        }

        private BufferedImage generateMandelbrotFractal() {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            double zx, zy, cX, cY, tmp;
            int color;

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    zx = zy = 0;
                    cX = (x - width / 2.0) * 4.0 / width;
                    cY = (y - height / 2.0) * 4.0 / height;
                    int iter = maxIterations;
                    while (zx * zx + zy * zy < 4 && iter > 0) {
                        tmp = zx * zx - zy * zy + cX;
                        zy = 2.0 * zx * zy + cY;
                        zx = tmp;
                        iter--;
                    }
                    color = iter | (iter << 8);
                    image.setRGB(x, y, color);
                }
            }
            return image;
        }
    }

    public static void main(String[] args) {
        new MandelbrotFractal(1000);
    }
}
