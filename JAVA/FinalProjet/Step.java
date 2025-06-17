package FinalProjet;

import java.util.ArrayList;

public class Step {
    private Polynomial polynomial;
    
    public Step(Polynomial polynomial) {
        this.polynomial = polynomial;
    }
    
    public ArrayList<String> solve() {
        ArrayList<String> steps = new ArrayList<String>();
        
        double a = polynomial.getA();
        double b = polynomial.getB();
        double c = polynomial.getC();
        
        double discriminant = polynomial.getDiscriminant();
        steps.add("Discriminant: " + discriminant);
        
        if (discriminant < 0) {
            steps.add("No real roots");
            return steps;
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            steps.add("Single root: " + root);
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            steps.add("Root 1: " + root1);
            steps.add("Root 2: " + root2);
        }
        
        double vertexX = -b / (2 * a);
        double vertexY = a * vertexX * vertexX + b * vertexX + c;
        steps.add("Vertex: (" + vertexX + ", " + vertexY + ")");
        
        return steps;
    }
}
