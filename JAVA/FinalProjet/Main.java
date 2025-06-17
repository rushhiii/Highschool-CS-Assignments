package FinalProjet;

// import java.awt.BasicStroke;
// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.RenderingHints;
// import java.util.Scanner;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

// public class Main extends JPanel {
//   private static final int WIDTH = 800;
//   private static final int HEIGHT = 600;
//   private static final int MARGIN = 50;
//   private static final int SCALE = 10;
//   private static final int TICK_SIZE = 5;

//   private double a, b, c;

//   public Main(double a, double b, double c) {
//     this.a = a;
//     this.b = b;
//     this.c = c;
//   }

//   private double f(double x) {
//     return a * x * x + b * x + c;
//   }

//   private void drawAxis(Graphics2D g) {
//     g.setStroke(new BasicStroke(2));
//     g.drawLine(MARGIN, HEIGHT / 2, WIDTH - MARGIN, HEIGHT / 2);
//     g.drawLine(WIDTH / 2, MARGIN, WIDTH / 2, HEIGHT - MARGIN);

//     g.setFont(g.getFont().deriveFont(14f));

//     // X axis labels and ticks
//     for (int i = -10; i <= 10; i++) {
//       int x = WIDTH / 2 + i * SCALE;
//       int y = HEIGHT / 2;

//       g.drawLine(x, y - TICK_SIZE, x, y + TICK_SIZE);

//       if (i != 0) {
//         g.drawString(Integer.toString(i), x - 5, y + 20);
//       }
//     }

//     // Y axis labels and ticks
//     for (int i = -10; i <= 10; i++) {
//       int x = WIDTH / 2;
//       int y = HEIGHT / 2 - i * SCALE;

//       g.drawLine(x - TICK_SIZE, y, x + TICK_SIZE, y);

//       if (i != 0) {
//         g.drawString(Integer.toString(i), x + 10, y + 5);
//       }
//     }
//   }

//   private void drawFunction(Graphics2D g) {
//     g.setColor(Color.BLUE);
//     g.setStroke(new BasicStroke(2));

//     double x1 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
//     double x2 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);

//     double y1 = f(x1);
//     double y2 = f(x2);

//     double vertexX = -b / (2 * a);
//     double vertexY = f(vertexX);

//     int prevX = 0;
//     int prevY = 0;

//     for (int i = -100; i <= 100; i++) {
//       double x = (double) i / SCALE;
//       double y = f(x);

//       int screenX = WIDTH / 2 + (int) (x * SCALE);
//       int screenY = HEIGHT / 2 - (int) (y * SCALE);

//       if (i > -100 && i <= 100) {
//         g.drawLine(prevX, prevY, screenX, screenY);
//       }

//       prevX = screenX;
//       prevY = screenY;
//     }

//     g.setColor(Color.RED);
//     g.fillOval((int) (WIDTH / 2 + vertexX * SCALE - 3), (int) (HEIGHT / 2 - vertexY * SCALE - 3), 6, 6);

//     g.setColor(Color.BLACK);
//     g.drawString(String.format("Discriminant = %.2f", b * b - 4 * a * c), 20, 20);
//     g.drawString(String.format("Root 1 = %.2f", x1), 20, 40);
//     g.drawString(String.format("Root 2 = %.2f", x2), 20, 60);
//     g.drawString(String.format("Vertex = (%.2f, %.2f)", vertexX, vertexY), 20, 80);
//   }

//   @Override
//   public void paintComponent(Graphics g) {
//     super.paintComponent(g);

//     Graphics2D g2d = (Graphics2D) g;

//     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

//     drawAxis(g2d);
//     drawFunction(g2d);
//   }

//   public static void main(String[] args) {
//     Scanner scanner = new Scanner(System.in);

//     System.out.print("Enter the value of a: ");
//     double a = scanner.nextDouble();

//     System.out.print("Enter the value of b: ");
//     double b = scanner.nextDouble();

//     System.out.print("Enter the value of c: ");
//     double c = scanner.nextDouble();

//     Main graph = new Main(a, b, c);

//     JFrame frame = new JFrame("Quadratic Equation Graph");
//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     frame.setSize(WIDTH, HEIGHT);
//     frame.add(graph);
//     frame.setVisible(true);
//   }
// }


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = scanner.nextDouble();
        scanner.close();

        // Create a Polynomial object
        Polynomial polynomial = new Polynomial(a, b, c);

        // Create a Graph object and display the graph
        Graph graph = new Graph(polynomial);
        graph.displayGraph();

        // Calculate the discriminant and display it
        double discriminant = polynomial.calculateDiscriminant();
        System.out.println("Discriminant: " + discriminant);

        // Calculate the zeroes and display them
        double[] zeroes = polynomial.calculateZeroes();
        System.out.println("Zeroes: " + zeroes[0] + ", " + zeroes[1]);

        // Calculate the vertices and display them
        double[] vertices = polynomial.calculateVertices();
        System.out.println("Vertices: (" + vertices[0] + ", " + vertices[1] + ")");

        // Calculate the steps and display them
        Step step = new Step(polynomial);
        String steps = step.calculateSteps();
        System.out.println("Steps: " + steps);
    }
}

