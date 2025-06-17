package SecondDegreeSolverPro;

// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;
// import javax.swing.border.*;
// import java.io.File;
// import java.awt.geom.RoundRectangle2D;


// public class GUI extends JPanel implements ActionListener {
//   private JFrame frame;
//   private JLabel label;
//   private JTextField textField;
//   private int count = 0;

//   public GUI() {
//     frame = new JFrame("Polynomial Solver");
//     label = new JLabel("Number of clicks: 0");
//     textField = new JTextField(20);
//   }

//   public void display() {
//     // Set the layout manager
//     setLayout(new BorderLayout());

//     // Create a panel for the center components
//     JPanel centerPanel = new JPanel(new BorderLayout());
//     centerPanel.setOpaque(false); // Set the panel to be transparent

//     // Create the heading text label and center it
//     JLabel headingLabel = new JLabel("Polynomial Solver");

//     // Load the custom1 font
//     try {
//       Font customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("Roboto-Bold.ttf"));
//       Font customFontLarge = customFont1.deriveFont(Font.BOLD, 35);
//       headingLabel.setFont(customFontLarge);
//     } catch (Exception e) {
//       e.printStackTrace();
//       // If there's an error loading the font, fall back to a default font
//       headingLabel.setFont(new Font("Roboto", Font.BOLD, 35));
//     }

//     headingLabel.setHorizontalAlignment(JLabel.CENTER);
//     headingLabel.setForeground(Color.WHITE); // Set the text color to white
//     headingLabel.setOpaque(false); // Set the label to be transparent

//     // Create a panel for the text box and center it
//     JPanel textBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//     textBoxPanel.setOpaque(false); // Set the panel to be transparent
//     textBoxPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding to the text box panel

//     // Create a rounded border for the text box
//     Border roundedBorder = new RoundedBorder(10, Color.GRAY);
//     textField.setBorder(roundedBorder);

//     textBoxPanel.add(textField);
//     // Load the custom1 font
//     try {
//       Font customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("Roboto-Regular.ttf"));
//       Font customFontLarge2 = customFont2.deriveFont(Font.CENTER_BASELINE, 16);
//       textField.setFont(customFontLarge2);
//     } catch (Exception e) {
//       e.printStackTrace();
//       // If there's an error loading the font, fall back to a default font
//       textField.setFont(new Font("Roboto", Font.CENTER_BASELINE, 16));
//     }

//     // Add the heading and text box panels to the center panel
//     centerPanel.add(headingLabel, BorderLayout.NORTH);
//     centerPanel.add(textBoxPanel, BorderLayout.CENTER);

//     // Add the center panel to the main panel
//     add(centerPanel, BorderLayout.CENTER);

//     frame.getContentPane().add(this);
//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     frame.setMinimumSize(new Dimension(700, 600)); // Set the minimum size of the frame
//     JTextField field = new RoundJTextField(15);
//     frame.add(field);

//     frame.pack();
//     frame.setLocationRelativeTo(null);
//     frame.setVisible(true);
//   }

//   @Override
//   protected void paintComponent(Graphics g) {
//     super.paintComponent(g);

//     Graphics2D g2d = (Graphics2D) g;
//     int width = getWidth();
//     int height = getHeight();

//     // Define the gradient colors
//     Color startColor = new Color(0, 0, 0);
//     Color endColor = new Color(180, 180, 180);

//     // Create a gradient paint object
//     GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);

//     // Paint the gradient background
//     g2d.setPaint(gradient);
//     g2d.fillRect(0, 0, width, height);
//   }

//   @Override
//   public void actionPerformed(ActionEvent e) {
//     count++;
//     label.setText("Number of clicks: " + count);
//   }

//   // public static void main(String[] args) {
//   // GUI gui = new GUI();
//   // gui.display();
//   // }

//   // Custom border class for rounded corners
//   public static class RoundedBorder implements Border {
//     private int radius;
//     private Color color;

//     public RoundedBorder(int radius, Color color) {
//       this.radius = radius;
//       this.color = color;
//     }

//     public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//       Graphics2D g2d = (Graphics2D) g.create();
//       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//       g2d.setColor(color);
//       // g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f)); // Set transparency
//       // (0.5f for 50% transparency)
//       g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
//       g2d.dispose();
//     }

//     public Insets getBorderInsets(Component c) {
//       return new Insets(this.radius, this.radius, this.radius, this.radius);
//     }

//     public boolean isBorderOpaque() {
//       return true; // Set to false to indicate transparency
//     }
//   }
//   public class RoundJTextField extends JTextField {
//     private Shape shape;
//     public RoundJTextField(int size) {
//         super(size);
//         setOpaque(false); // As suggested by @AVD in comment.
//     }
//     protected void paintComponent(Graphics g) {
//          g.setColor(getBackground());
//          g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
//          super.paintComponent(g);
//     }
//     protected void paintBorder(Graphics g) {
//          g.setColor(getForeground());
//          g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
//     }
//     public boolean contains(int x, int y) {
//          if (shape == null || !shape.getBounds().equals(getBounds())) {
//              shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
//          }
//          return shape.contains(x, y);
//     }
// }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JTextField equationField;
    private JTextArea solutionArea;

    public GUI() {
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
                new GUI();
            }
        });
    }
}