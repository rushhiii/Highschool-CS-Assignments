package FinalProjet;

// public class Polynomial {
//     private double a, b, c;

//     public Polynomial(double a, double b, double c) {
//         this.a = a;
//         this.b = b;
//         this.c = c;
//     }

//     public double calculateDiscriminant() {
//         return Math.pow(b, 2) - 4 * a * c;
//     }

//     public double[] calculateZeroes() {
//         double discriminant = calculateDiscriminant();
//         if (discriminant < 0) {
//             return new double[0];
//         } else if (discriminant == 0) {
//             double[] zeroes = new double[1];
//             zeroes[0] = -b / (2 * a);
//             return zeroes;
//         } else {
//             double[] zeroes = new double[2];
//             zeroes[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
//             zeroes[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
//             return zeroes;
//         }
//     }

//     public double[] calculateVertices() {
//         double xVertex = -b / (2 * a);
//         double yVertex = a * Math.pow(xVertex, 2) + b * xVertex + c;
//         return new double[]{xVertex, yVertex};
//     }
// }


import java.util.ArrayList;

public class Polynomial {
    private double a, b, c;

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public ArrayList<Double> getZeroes() {
        ArrayList<Double> zeroes = new ArrayList<Double>();
        double discriminant = getDiscriminant();
        if (discriminant < 0) {
            return zeroes;
        }
        if (discriminant == 0) {
            zeroes.add(-b / (2 * a));
        } else {
            zeroes.add((-b + Math.sqrt(discriminant)) / (2 * a));
            zeroes.add((-b - Math.sqrt(discriminant)) / (2 * a));
        }
        return zeroes;
    }

    public double getVertexX() {
        return -b / (2 * a);
    }

    public double getVertexY() {
        return a * getVertexX() * getVertexX() + b * getVertexX() + c;
    }

    public boolean isMinVertex() {
        return a > 0;
    }

    public boolean isMaxVertex() {
        return a < 0;
    }

    public double evaluate(double x) {
        return a * x * x + b * x + c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
