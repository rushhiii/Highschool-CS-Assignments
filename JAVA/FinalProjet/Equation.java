import java.text.DecimalFormat;
import java.util.List;

public class Equation {
    public String solveEquation(String equation) {
        System.out.print("Entered String: " + equation);
        // Remove spaces and split the equation into its components
        equation = equation.replaceAll("\\s", "");
        String[] components = equation.split("=");

        if (components.length != 2) {
            System.out.println("Invalid equation format");
            return equation;
        }

        String leftSide = components[0];
        String rightSide = components[1];

        // Extract coefficients
        int a = 0;
        int b = 0;
        int c = 0;

        String[] terms = leftSide.split("(?=[-+])"); // Split at + or - signs

        for (String term : terms) {
            if (term.contains("x^2")) {
                a = extractCoefficient_ForEquation(term, "x^2");
            } else if (term.contains("x")) {
                b = extractCoefficient_ForEquation(term, "x");
            } else {
                c = Integer.parseInt(term);
            }
        }

        

        // String[] termsR = rightSide.split("(?=[-+])"); // Split at + or - signs

        // for (String term : termsR) {
        // if (term.contains("x^2")) {
        // a = extractCoefficient(term, "x^2");
        // } else if (term.contains("x")) {
        // b = extractCoefficient(term, "x");
        // } else {
        // c = Integer.parseInt(term);
        // }
        // }

        // Solve the equation using the quadratic formula
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            DecimalFormat df = new DecimalFormat("#.###");
            // return "Roots are real and distinct";

            return "Roots: " + df.format(root1) + ", " + df.format(root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            DecimalFormat df = new DecimalFormat("#.###");
            // return "Roots are real and equal";
            return "Root: " + df.format(root);
        } else {
            return "No real roots";
        }
    }

    public String vertices(String equation) {
        // Remove spaces and split the equation into its components
        equation = equation.replaceAll("\\s", "");
        String[] components = equation.split("=");

        if (components.length != 2) {
            System.out.println("Invalid equation format");
            return equation;
        }

        String leftSide = components[0];
        String rightSide = components[1];

        // Extract coefficients
        // int a = 0;
        // int b = 0;
        // int c = 0;

        double a = 0;
        double b = 0;
        double c = 0;

        String[] terms = leftSide.split("(?=[-+])"); // Split at + or - signs

        for (String term : terms) {
            if (term.contains("x^2")) {
                a = extractCoefficient_ForEquation(term, "x^2");
            } else if (term.contains("x")) {
                b = extractCoefficient_ForEquation(term, "x");
            } else {
                c = Integer.parseInt(term);
            }
        }

        double vertexX = (-b) / (2 * a);
        double vertexY = a * vertexX * vertexX + b * vertexX + c;

        System.out.println("\n");

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        if (a > 0) {
            // Min value
            // NO Max value
            return "Min(" + decimalFormat.format(vertexX) + ", " + decimalFormat.format(vertexY) + ")";
        } else if (a < 0) {
            // Max value
            // NO Min value
            return "Max(" + decimalFormat.format(vertexX) + ", " + decimalFormat.format(vertexY) + ")";
        } else {
            return "Value of 'a' can not be zero.";
        }
    }

    public String discriminant(String equation) {
        // Remove spaces and split the equation into its components
        equation = equation.replaceAll("\\s", "");
        String[] components = equation.split("=");

        if (components.length != 2) {
            System.out.println("Invalid equation format");
            return equation;
        }

        String leftSide = components[0];
        String rightSide = components[1];

        // Extract coefficients
        int a = 0;
        int b = 0;
        int c = 0;

        String[] terms = leftSide.split("(?=[-+])"); // Split at + or - signs

        for (String term : terms) {
            if (term.contains("x^2")) {
                a = extractCoefficient_ForEquation(term, "x^2");
            } else if (term.contains("x")) {
                b = extractCoefficient_ForEquation(term, "x");
            } else {
                c = Integer.parseInt(term);
            }
        }

        // System.out.println("\na = " + a);
        // System.out.println("b = " + b);
        // System.out.println("c = " + c);

        // double d = Math.sqrt((b * b) - (4 * a * c));

        // if (a > 0) {
        // // Min value
        // // NO Max value
        // double x = -b/(2*a);
        // double y = -d/(4*a);
        // DecimalFormat df = new DecimalFormat("#.##");
        // return "Discriminant: " + d + " | Min(" + df.format(x) + ", " + df.format(y)
        // + ")";
        // } else if (a < 0) {
        // // Max value
        // // NO Min value
        // double x = -b/(2*a);
        // double y = -d/(4*a);
        // DecimalFormat df = new DecimalFormat("#.##");
        // return "Discriminant: " + d + " | Max(" + df.format(x) + ", " + df.format(y)
        // + ")";
        // } else {

        // return "No Min or Max value";
        // }

        if (a != 0) {
            double d = (b * b) - (4 * a * c);
            DecimalFormat df = new DecimalFormat("#.##");
            if (d > 0) {
                // Two distinct real roots
                // double x1 = (-b + Math.sqrt(d)) / (2 * a);
                // double x2 = (-b - Math.sqrt(d)) / (2 * a);
                return "Discriminant: " + df.format(d);
            } else if (d == 0) {
                // One real root (repeated root)
                double x = -b / (2 * a);
                return "Discriminant: " + df.format(d);
            } else {
                // Complex roots
                return "Discriminant: " + df.format(d);
            }
        } else {
            return "Value of 'a' can not be zero..";
        }
    }

    private int extractCoefficient_ForEquation(String term, String variable) {
        if (term.endsWith(variable)) {
            return term.equals(variable) ? 1 : Integer.parseInt(term.substring(0, term.indexOf(variable)));
        } else {
            return -1 * (term.equals("-" + variable) ? 1 : Integer.parseInt(term.substring(0, term.indexOf(variable))));
        }
    }

    public List<Double> getVertices(String equation) {
        equation = equation.replaceAll("\\s", "");
        String[] components = equation.split("=");

        if (components.length != 2) {
            System.out.println("Invalid equation format");
            return null;
        }

        String leftSide = components[0];
        String rightSide = components[1];

        // Extract coefficients
        double a = 0;
        double b = 0;
        double c = 0;

        String[] terms = leftSide.split("(?=[-+])");

        for (String term : terms) {
            if (term.contains("x^2")) {
                a = extractCoefficient_ForGraph(term, "x^2");
            } else if (term.contains("x")) {
                b = extractCoefficient_ForGraph(term, "x");
            } else {
                c = Integer.parseInt(term);
            }
        }

        return List.of(a, b, c);
    }

    private double extractCoefficient_ForGraph(String term, String variable) {
        if (term.endsWith(variable)) {
            return term.equals(variable) ? 1 : Double.parseDouble(term.substring(0, term.indexOf(variable)));
        } else {
            return -1
                    * (term.equals("-" + variable) ? 1 : Double.parseDouble(term.substring(0, term.indexOf(variable))));
        }
    }

}
