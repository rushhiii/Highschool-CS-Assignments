package FinalProjet;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JFrame {
  public Graph(Polynomial polynomial) {
    // Extract coefficients from the polynomial object
    double a = polynomial.getA();
    double b = polynomial.getB();
    double c = polynomial.getC();

    // Create the line graph
    ArrayList<Double> xValues = new ArrayList<>();
    ArrayList<Double> yValues = new ArrayList<>();
    for (double x = -10; x <= 10; x += 0.1) {
        double y = a * x * x + b * x + c;
        xValues.add(x);
        yValues.add(y);
    }
    LineGraph lineGraph = new LineGraph(xValues, yValues);

    // Display the line graph
    JFrame frame = new JFrame("Graph");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(lineGraph);
    frame.setSize(600, 400);
    frame.setVisible(true);
}
  
Polynomial polynomial = new Polynomial(1, 2, 1);
Graph graph = new Graph(polynomial);

    private JPanel graphPanel;
    private ArrayList<Double> xValues;
    private ArrayList<Double> yValues;

    public Graph(ArrayList<Double> xValues, ArrayList<Double> yValues) {
        super("Polynomial Graph");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
                g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
                for (int i = 0; i < xValues.size(); i++) {
                    int xPixel = (int) (xValues.get(i) * getWidth() / 20 + getWidth() / 2);
                    int yPixel = (int) (-yValues.get(i) * getHeight() / 20 + getHeight() / 2);
                    g.setColor(Color.BLUE);
                    g.fillRect(xPixel, yPixel, 5, 5);
                }
            }
        };
        this.xValues = xValues;
        this.yValues = yValues;
        add(graphPanel);
        setVisible(true);
    }
}
