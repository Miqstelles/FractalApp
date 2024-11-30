import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalApp {
    private JFrame frame;
    private JButton mandelbrotButton;
    private JButton sierpinskiButton;

    public FractalApp() {
        frame = new JFrame("Gerador de Fractais");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        mandelbrotButton = new JButton("Mandelbrot");
        mandelbrotButton.setBounds(50, 100, 150, 50);
        mandelbrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MandelbrotSettings();
            }
        });

        sierpinskiButton = new JButton("Sierpinski");
        sierpinskiButton.setBounds(200, 100, 150, 50);
        sierpinskiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SierpinskiSettings();
            }
        });

        frame.add(mandelbrotButton);
        frame.add(sierpinskiButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FractalApp();
    }
}
