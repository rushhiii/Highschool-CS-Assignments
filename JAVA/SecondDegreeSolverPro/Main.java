package SecondDegreeSolverPro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField equationField;
    private JTextArea solutionArea;

    public Main() {
        setTitle("Equation Solver");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        equationField = new JTextField();
        JButton solveButton = new JButton("Solve");
        solutionArea = new JTextArea();
        solutionArea.setEditable(false);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equation = equationField.getText();
                solveEquation(equation);
            }
        });

        mainPanel.add(equationField, BorderLayout.NORTH);
        mainPanel.add(solveButton, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(solutionArea), BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void solveEquation(String equation) {
        // Split the equation into its components
        String[] parts = equation.split(" ");
        double a = Double.parseDouble(parts[0]);
        double b = Double.parseDouble(parts[2]);
        double c = Double.parseDouble(parts[4]);

        // Perform the calculations
        double discriminant = b * b - 4 * a * c;
        double root1, root2;

        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            String solution = "Roots are real and different:\n";
            solution += "Root 1: " + root1 + "\n";
            solution += "Root 2: " + root2 + "\n";
            solutionArea.setText(solution);
        } else if (discriminant == 0) {
            root1 = -b / (2 * a);
            String solution = "Roots are real and same:\n";
            solution += "Root: " + root1 + "\n";
            solutionArea.setText(solution);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            String solution = "Roots are complex and different:\n";
            solution += "Root 1: " + realPart + " + " + imaginaryPart + "i\n";
            solution += "Root 2: " + realPart + " - " + imaginaryPart + "i\n";
            solutionArea.setText(solution);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}

// class Main {
//   public static void main(String[] args) {
//     Main gui = new Main();
//     gui.display();
//   }
// }