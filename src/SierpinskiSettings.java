import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SierpinskiSettings {
    private JFrame frame;
    private JTextField iterationsField;
    private JButton generateButton;

    public SierpinskiSettings() {
        frame = new JFrame("Parâmetros de Sierpinski");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        JLabel iterationsLabel = new JLabel("Número de Iterações:");
        iterationsLabel.setBounds(50, 30, 150, 30);
        frame.add(iterationsLabel);

        iterationsField = new JTextField("5");
        iterationsField.setBounds(200, 30, 100, 30);
        frame.add(iterationsField);

        generateButton = new JButton("Gerar Fractal");
        generateButton.setBounds(120, 100, 150, 50);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int iterations = Integer.parseInt(iterationsField.getText());
                new SierpinskiFractal(iterations);
            }
        });

        frame.add(generateButton);
        frame.setVisible(true);
    }
}
