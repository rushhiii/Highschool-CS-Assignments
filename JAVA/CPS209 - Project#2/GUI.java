import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.*;
//import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

public class GUI extends JPanel {
    private JFrame frame;
    private JLabel label;
    private RoundedJTextField roundedTextField;
    private int userInputLabelFontSize = 20;
    private int headingFontSize = 96;
    private JPanel centerPanel = new JPanel(new GridBagLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            // Color startColor = new Color(0, 0, 0); // Black color
            // Color endColor = new Color(180, 180, 180); // White color

            Color startColor = new Color(18, 52, 86); // Dark-Blue color
            Color endColor = new Color(0, 0, 0); // black color

            // Color startColor = new Color(0, 0, 0); // Black color
            // Color endColor = new Color(123, 50, 250); // Purplr color

            GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);

            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        }
    };
    private JLabel headingLabel;
    private GridBagConstraints gbc;
    private Equation Equation;
    private JLabel roots;
    private Graph graph;
    private JLabel vertices;
    private JLabel discriminant;
    JTextArea outputTextArea;
    EquationSolver equationSolver;

    public GUI() {
        frame = new JFrame("Second Degree Solver Pro");
        label = new JLabel();
        Equation = new Equation();
        roots = new JLabel();
        vertices = new JLabel();
        discriminant = new JLabel();
        // centerPanel = new JPanel();
        graph = new Graph();
        outputTextArea = new JTextArea();
        equationSolver = new EquationSolver(outputTextArea);

        // graph.setVertices(vertices); // Pass your list of vertices here

    }

    public void display() {
        setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000, 700));
        frame.setLocationRelativeTo(null);

        addComponents();
        // addzeroesroots("");

        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    // Background color - bg
    private void addComponents() {

        ImageIcon icon = new ImageIcon("gui-icon.png"); // icon
        frame.setIconImage(icon.getImage());

        centerPanel.setOpaque(false);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(-100, 0, 50, 0);

        headingLabel = new JLabel("x² Solver");

        try {
            // Load custom font for the heading
            Font customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("Roboto-Bold.ttf"));
            Font customFontLarge = customFont1.deriveFont(Font.BOLD, headingFontSize);
            headingLabel.setFont(customFontLarge);
        } catch (Exception e) {
            // Fallback font if custom font loading fails
            headingLabel.setFont(new Font("Arial", Font.BOLD, headingFontSize));
        }

        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setOpaque(false);
        centerPanel.add(headingLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);

        roundedTextField = new RoundedJTextField(15);
        roundedTextField.setOpaque(false);
        roundedTextField.setBackground(new Color(0, 0, 0, 0));
        Border roundedBorder = new RoundedBorder(10, Color.GRAY);
        roundedTextField.setBorder(roundedBorder);

        try {
            // Load custom font for the text field
            Font customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
            Font customFontLarge2 = customFont2.deriveFont(Font.CENTER_BASELINE, userInputLabelFontSize);
            roundedTextField.setFont(customFontLarge2);
        } catch (Exception e) {
            // Fallback font if custom font loading fails
            roundedTextField.setFont(new Font("Arial", Font.CENTER_BASELINE, userInputLabelFontSize));
        }

        roundedTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // String equation = JOptionPane.showInputDialog("Enter the equation (in ax^2 + bx + c = 0 form):");
                    String equation = roundedTextField.getText().trim();

                    if (!isValidEquationFormat(equation)) {
                        JOptionPane.showMessageDialog(null, "The equation should be in the form ax^2+bx+c= 0");
                    } else {

                        addRefreshButton(centerPanel);
                        repositionTextField();
                        centerPanel.remove(headingLabel);
                        roundedTextField.setText("");
                    }
                }
            }
        });

        centerPanel.add(roundedTextField, gbc);

        // Create a JScrollPane to make the output scrollable
        // JScrollPane scrollPane = new JScrollPane(outputTextArea);
        // frame.add(scrollPane, BorderLayout.CENTER);
        outputTextArea.setEditable(false);

        add(centerPanel, BorderLayout.CENTER);

    }

    private static boolean isValidEquationFormat(String equation) {
         equation = equation.replaceAll("\\s", "");

        // Check if the equation matches the expected pattern
        return equation.matches("^\\d*x\\^2[+-]\\d*x[+-]\\d*=0$");
    }

    // private void addzeroesroots(String solution) {
    // // Remove the existing declaration of the gbc variable

    // String discriminant = Equation.solveEquation(solution);

    // // Create a new GridBagConstraints for the roots
    // GridBagConstraints gbc = new GridBagConstraints();
    // gbc.gridx = 1; // Position the roots next to the label
    // gbc.gridy = 1; // Use the same y-coordinate as the roundedTextField
    // gbc.insets = new Insets(0, 10, 0, 0); // Adjust the insets as needed

    // roots.setText("Solution: " + discriminant);
    // roots.setForeground(Color.WHITE);
    // roots.setOpaque(false);
    // centerPanel.add(roots, gbc);

    // // Update the vertices of the graph
    // // List<Double> vertices = Equation.getVertices(solution);
    // // graph.setVertices(vertices);

    // frame.pack(); // Re-pack the frame to adjust the layout
    // }

    private void repositionTextField() {

        String inputText = roundedTextField.getText().trim();
        if (!inputText.isEmpty()) {
            String solution = Equation.solveEquation(inputText); // Solve the equation

            label.setText("Equation: " + inputText); // Set the label text with the solution
            // addzeroesroots(inputText);
            roots.setText(solution);

            String minOrMax = Equation.vertices(inputText);
            vertices.setText(minOrMax);

            String discriminantwer = Equation.discriminant(inputText);
            discriminant.setText(discriminantwer);

            // Update the vertices of the graph
            List<Double> graphVertices = Equation.getVertices(inputText);
            graph.setVisible(true);
            graph.setVertices(graphVertices);

            // Call repaint on the graph to update the drawing
            graph.repaint();
            outputTextArea.setVisible(true);

            // ! Like this
            outputTextArea.setText("");
            equationSolver.solveQuadraticEquation(inputText);

            // ! Uncomment this line, give setText a parameter of an empty string and move
            // it above solveQuadraticEquation()
            // outputTextArea.setText();

            // String solution = Equation.solveEquation(inputText); // Solve the equation

            // // Print the step-by-step solutions
            // List<String> steps = Equation.getSolutionSteps(inputText);
            // for (String step : steps) {
            // System.out.println(step);
            // }
            // label.setForeground(Color.WHITE); // Set the text color to white
        } else {
            label.setText(""); // Clear the label if the input is empty
            roots.setText("");
            vertices.setText("");
            discriminant.setText("");
            // outputTextArea.setText("");
            graph.setVisible(false);
            outputTextArea.setVisible(false);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(580, 0, 0, 0);

      
        // JPanel centerPanel = (JPanel) roundedTextField.getParent();

        centerPanel.remove(roundedTextField);
        centerPanel.add(roundedTextField, gbc);
      
        JTextField roundedTextField = new JTextField(20);


        // all top labels position and font size
        int topLabelsFontSize = 18;
        int topLabelPosition = 590;

        // Change text color to white
        label.setForeground(Color.WHITE);

        try {
            // Load custom font for the label
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
            Font customFontLarge = customFont.deriveFont(Font.BOLD, topLabelsFontSize);
            label.setFont(customFontLarge);
            roundedTextField.setFont(customFontLarge);
        } catch (Exception e) {
            // Fallback font if custom font loading fails
            label.setFont(new Font("Arial", Font.BOLD, topLabelsFontSize));
        }

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0; // Set the x-coordinate to 0
        gbc2.gridy = 0; // Set the y-coordinate to 0
        gbc2.insets = new Insets(0, 0, topLabelPosition, 730);

        // 12x^2+4x+2=0
        // 2x^2+4x+2=0
        // 12x^2+22x+4=0
        // 1x^2-5x+6=0
        // 3x^2-5x+6=0 

        centerPanel.add(label, gbc2);

        try {
            // Load custom font for the label
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
            Font customFontLarge = customFont.deriveFont(Font.BOLD, topLabelsFontSize);
            roots.setFont(customFontLarge);
        } catch (Exception e) {
            // Fallback font if custom font loading fails
            roots.setFont(new Font("Arial", Font.BOLD, topLabelsFontSize));
        }

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.insets = new Insets(0, 660, topLabelPosition, 0);

        roots.setAlignmentX(LEFT_ALIGNMENT);
        roots.setForeground(Color.WHITE);
        roots.setOpaque(false);
        centerPanel.add(roots, gbc3);

        try {
            // Load custom font for the label
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
            Font customFontLarge = customFont.deriveFont(Font.BOLD, topLabelsFontSize);
            vertices.setFont(customFontLarge);
        } catch (Exception e) {
            // Fallback font if custom font loading fails
            vertices.setFont(new Font("Arial", Font.BOLD, topLabelsFontSize));
        }

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 0;
        gbc4.insets = new Insets(0, 200, topLabelPosition, 0);

        vertices.setForeground(Color.WHITE);
        vertices.setOpaque(false);
        centerPanel.add(vertices, gbc4);

        try {
            // Load custom font for the label
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
            Font customFontLarge = customFont.deriveFont(Font.BOLD, topLabelsFontSize);
            discriminant.setFont(customFontLarge);
        } catch (Exception e) {
            // Fallback font if custom font loading fails
            discriminant.setFont(new Font("Arial", Font.BOLD, topLabelsFontSize));
        }

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        gbc5.insets = new Insets(0, 0, topLabelPosition, 240);

        discriminant.setForeground(Color.WHITE);
        discriminant.setOpaque(false);
        centerPanel.add(discriminant, gbc5);

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 0;
        gbc6.insets = new Insets(0, 500, 0, 0);
        gbc6.anchor = GridBagConstraints.CENTER;

        centerPanel.add(graph, gbc6);
        repaint();

        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
            Font customFontLarge = customFont.deriveFont(Font.PLAIN, topLabelsFontSize);
            outputTextArea.setFont(customFontLarge);
        } catch (Exception e) {
            outputTextArea.setFont(new Font("Arial", Font.BOLD, topLabelsFontSize));
        }

        GridBagConstraints gbc7 = new GridBagConstraints();
        gbc7.gridx = 0;
        gbc7.gridy = 0;
        gbc7.insets = new Insets(0, 0, 0, 500);
        int padding = 10;
        outputTextArea.setMargin(new Insets(padding, padding, padding, padding));
        centerPanel.remove(outputTextArea);
        centerPanel.add(outputTextArea, gbc7);

        
        JButton downloadButton = new JButton("Download");

        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
            Font customFontLarge = customFont.deriveFont(Font.BOLD, topLabelsFontSize);
            downloadButton.setFont(customFontLarge);
        } catch (Exception e) {
            downloadButton.setFont(new Font("Arial", Font.BOLD, topLabelsFontSize));
        }

        GridBagConstraints gbc8 = new GridBagConstraints();
        gbc8.gridx = 0;
        gbc8.gridy = 0;
        gbc8.insets = new Insets(580, 0, 0, 460);
        // gbc7.anchor = GridBagConstraints.CENTER;
        // int padding = 10;
        // downloadButton.setMargin(new Insets(padding, padding, padding, padding));
        centerPanel.remove(downloadButton);
        centerPanel.add(downloadButton, gbc7);

        downloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = outputTextArea.getText();
                saveTextToFile(text);
            }
        });
        

        centerPanel.add(downloadButton, gbc8);


        frame.pack(); // Re-pack the frame to adjust the layout
    }

    private static void saveTextToFile(String text) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save As");
        
        // Set the default directory to the Downloads folder
        String userHome = System.getProperty("user.home");
        String defaultDownloadsDir = userHome + File.separator + "Downloads";
        fileChooser.setCurrentDirectory(new File(defaultDownloadsDir));
        
        fileChooser.setSelectedFile(new File("Steps.txt")); // Set the default file name
        
        int userSelection = fileChooser.showSaveDialog(null);
    
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(fileToSave)) {
                writer.print(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void addRefreshButton(JPanel panel) {
        ImageIcon icon = new ImageIcon("refresh-icon.png"); // Replace with the actual path to the refresh icon
        Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JButton refreshButton = new JButton(scaledIcon);
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repositionTextField();
                // ! This line deletes the "Equation:" display even after it is set in
                // repositionTextField()
                // label.setText("");
                // centerPanel.remove(label);
                // centerPanel.remove(roots);
                // centerPanel.remove(vertices);
                // centerPanel.remove(discriminant);
                // centerPanel.remove(refreshButton);
                // centerPanel.add(headingLabel);

                frame.pack(); // Re-pack the frame to adjust the layout
            }
        });

        // refreshButton.setOpaque(true); // Set the button to be trdiscriminantparent
        refreshButton.setContentAreaFilled(false); // trdiscriminantparent background
        refreshButton.setBorderPainted(false); // Remove the button's border

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Position the refresh button next to the roundedTextField
        gbc.gridy = 0;
        gbc.insets = new Insets(580, 350, 0, 0); // Adjust the insets as needed

        panel.add(refreshButton, gbc);
    }

    // Custom border class for rounded borders
    public static class RoundedBorder implements Border {
        private int radius;
        private Color color;

        public RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius, this.radius, this.radius, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }
    }

    // Custom text field class with rounded edges
    class RoundedJTextField extends JTextField {
        private Shape shape;

        public RoundedJTextField(int size) {
            super(size);
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            super.paintComponent(g);
            g2d.dispose();
        }

        protected void paintBorder(Graphics g) {
            g.setColor(Color.WHITE);
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }

    // public static void main(String[] args) {
    //     System.out.println("\n");

    //     GUI gui = new GUI();

    //     gui.display();
    // }
}
