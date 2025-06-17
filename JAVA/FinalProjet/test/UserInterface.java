package FinalProjet;

import java.util.Scanner;

public class UserInterface {
    private Polynomial polynomial;
    private Step step;

    public UserInterface() {
      double a = Double.parseDouble(aTextField.getText());
double b = Double.parseDouble(bTextField.getText());
double c = Double.parseDouble(cTextField.getText());
this.polynomial = new Polynomial(a, b, c);
        // this.polynomial = new Polynomial();
        // this.step = new Step();
      Polynomial poly = new Polynomial(a, b, c);
// Step step = new Step(poly);
      this.step = new Step(poly);

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients of the second degree polynomial function ax^2 + bx + c:");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();

        polynomial.setCoefficients(a, b, c);

        double discriminant = polynomial.calculateDiscriminant();
        System.out.println("Discriminant = " + discriminant);

        if (discriminant > 0) {
            double[] roots = polynomial.calculateRoots();
            System.out.println("Roots = {" + roots[0] + ", " + roots[1] + "}");

            double[] vertices = polynomial.calculateVertices();
            System.out.println("Vertices = {" + vertices[0] + ", " + vertices[1] + "}");

            step.calculateSteps(polynomial.getCoefficients(), roots[0], roots[1]);

            Graph graph = new Graph(polynomial);
            graph.displayGraph();
        } else if (discriminant == 0) {
            double[] roots = polynomial.calculateRoots();
            System.out.println("Root = " + roots[0]);

            double[] vertex = polynomial.calculateVertex();
            System.out.println("Vertex = {" + vertex[0] + ", " + vertex[1] + "}");

            step.calculateSteps(polynomial.getCoefficients(), roots[0]);

            Graph graph = new Graph(polynomial);
            graph.displayGraph();
        } else {
            double[] complexRoots = polynomial.calculateComplexRoots();
            System.out.println("Roots = {" + complexRoots[0] + " + " + complexRoots[1] + "i, "
                    + complexRoots[0] + " - " + complexRoots[1] + "i}");

            double[] vertex = polynomial.calculateVertex();
            System.out.println("Vertex = {" + vertex[0] + ", " + vertex[1] + "}");

            step.calculateSteps(polynomial.getCoefficients(), complexRoots[0], complexRoots[1]);

            Graph graph = new Graph(polynomial);
            graph.displayGraph();
        }
    }
}
