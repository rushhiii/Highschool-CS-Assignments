import java.text.DecimalFormat;

import javax.swing.JTextArea;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EquationSolver {
    // public static void main(String[] args) {
    // System.out.println("\n");

    // String equationString = "1x^2-5x+6=0";

    // double[] coefficients = getValues(equationString);

    // double a = coefficients[0];
    // double b = coefficients[1];
    // double c = coefficients[2];

    // DecimalFormat df = new DecimalFormat("#.##");
    // // System.out.println("a = " + a);
    // // System.out.println("b = " + b);
    // // System.out.println("c = " + c);

    // double signCheck = Math.sqrt((b * b) + (-4 * a * c));

    // System.out.println("Quadratic formula: x = (-b ± √(b^2 - 4ac)) / (2a)\nHere,
    // a = " + df.format(a) + ", b = "
    // + df.format(b) + ", c = " + df.format(c) + "\nTherefor by substituting values
    // in the formula we get,");
    // System.out.println("x = (-(" + df.format(b) + ")" + " ± √((" + df.format(b) +
    // ")^2 - " + "4 * " + df.format(a)
    // + " * " + df.format(c) + "))" + " / " + "(2 * " + df.format(a) + ")");
    // System.out.println();
    // if (-4 * a * c > 0) {
    // System.out.println("x = (" + df.format(-b) + " ± √(" + df.format(b * b) + " +
    // " + df.format(-4 * a * c)
    // + "))" + " / " + df.format(2 * a));
    // } else {
    // System.out.println("x = (" + df.format(-b) + " ± √(" + df.format(b * b) + " -
    // " + df.format(-(-4 * a * c))
    // + "))" + " / " + df.format(2 * a));
    // }
    // System.out.println(
    // "x = (" + df.format(-b) + " ± √" + df.format((b * b) + (-4 * a * c)) + ")" +
    // " / " + df.format(2 * a));
    // System.out.println("x = (" + df.format(-b) + " ± " + df.format(Math.sqrt((b *
    // b) + (-4 * a * c))) + ")" + " / "
    // + df.format(2 * a));

    // // x1 positive \u2081
    // char subscript1 = '\u2081';
    // if (signCheck > 0) {
    // System.out.print("x" + subscript1 + " = (" + df.format(-b) + " + "
    // + df.format(Math.sqrt((b * b) + (-4 * a * c)))
    // + ") / " + df.format(2 * a) + " = " + df.format(-b + (Math.sqrt((b * b) + (-4
    // * a * c)))) + " / "
    // + df.format(2 * a) + " = ");

    // // double numerator = -b + (Math.sqrt((b * b) + (-4 * a * c)));
    // // double denominator = 2 * a;
    // reduceFractionForPositive(a, b, c);

    // // System.out.print(" or " + df.format((-b + (Math.sqrt((b * b) + (-4 * a *
    // // c)))) / (2 * a)));
    // } else {
    // System.out.println("x" + subscript1 + " = (" + df.format(-b) + " + ("
    // + df.format((Math.sqrt((b * b) + (-4 * a * c))))
    // + ")) / " + df.format(2 * a) + " = " + df.format(-b + (Math.sqrt((b * b) +
    // (-4 * a * c)))) + " / "
    // + df.format(2 * a) + " = ");
    // reduceFractionForPositive(a, b, c);

    // }

    // System.out.println();

    // // x2 negative \u2082
    // char subscript2 = '\u2081';
    // if (signCheck > 0) {
    // // System.out.println("x"+ subscript2 +" = (" + df.format(-b) + " - " +
    // // df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a) +
    // "
    // // = " + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " +
    // // df.format(2 * a) + " = " + df.format((-b - (Math.sqrt((b * b) + (-4 * a *
    // // c)))) / (2 * a)));
    // System.out.print("x" + subscript2 + " = (" + df.format(-b) + " - "
    // + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a) +
    // " = "
    // + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " + df.format(2 *
    // a) + " = ");

    // reduceFractionForNegative(a, b, c);

    // // System.out.print(" or " + df.format((-b - (Math.sqrt((b * b) + (-4 * a *
    // // c)))) / (2 * a)));

    // } else {
    // System.out.println("x" + subscript2 + " = (" + df.format(-b) + " - ("
    // + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ")) / " + df.format(2 * a) +
    // " = "
    // + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " + df.format(2 *
    // a) + " = ");

    // reduceFractionForNegative(a, b, c);

    // }

    // // System.out.println(df.format(Math.sqrt((b * b) + (-4 * a * c))));
    // }

    // private JTextArea outputTextArea;

    // public void solveQuadraticEquation(String equationString) {

    // double[] coefficients = getValues(equationString);

    // double a = coefficients[0];
    // double b = coefficients[1];
    // double c = coefficients[2];

    // DecimalFormat df = new DecimalFormat("#.##");
    // // System.out.println("a = " + a);
    // // System.out.println("b = " + b);
    // // System.out.println("c = " + c);

    // double signCheck = Math.sqrt((b * b) + (-4 * a * c));

    // outputTextArea.append("Quadratic formula: x = (-b ± √(b^2 - 4ac)) /
    // (2a)\nHere, a = " + df.format(a) + ", b = "
    // + df.format(b) + ", c = " + df.format(c) + "\nTherefor by substituting values
    // in the formula we get,");
    // outputTextArea.append("x = (-(" + df.format(b) + ")" + " ± √((" +
    // df.format(b) + ")^2 - " + "4 * " + df.format(a)
    // + " * " + df.format(c) + "))" + " / " + "(2 * " + df.format(a) + ")");
    // outputTextArea.append("\n");
    // if (-4 * a * c > 0) {
    // outputTextArea.append("x = (" + df.format(-b) + " ± √(" + df.format(b * b) +
    // " + " + df.format(-4 * a * c)
    // + "))" + " / " + df.format(2 * a));
    // } else {
    // outputTextArea.append("x = (" + df.format(-b) + " ± √(" + df.format(b * b) +
    // " - " + df.format(-(-4 * a * c))
    // + "))" + " / " + df.format(2 * a));
    // }
    // outputTextArea.append(
    // "x = (" + df.format(-b) + " ± √" + df.format((b * b) + (-4 * a * c)) + ")" +
    // " / " + df.format(2 * a));
    // outputTextArea.append("x = (" + df.format(-b) + " ± " +
    // df.format(Math.sqrt((b * b) + (-4 * a * c))) + ")" + " / "
    // + df.format(2 * a));

    // // x1 positive \u2081
    // char subscript1 = '\u2081';
    // if (signCheck > 0) {
    // outputTextArea.append("x" + subscript1 + " = (" + df.format(-b) + " + "
    // + df.format(Math.sqrt((b * b) + (-4 * a * c)))
    // + ") / " + df.format(2 * a) + " = " + df.format(-b + (Math.sqrt((b * b) + (-4
    // * a * c)))) + " / "
    // + df.format(2 * a) + " = ");

    // // double numerator = -b + (Math.sqrt((b * b) + (-4 * a * c)));
    // // double denominator = 2 * a;
    // reduceFractionForPositive(a, b, c);

    // // System.out.print(" or " + df.format((-b + (Math.sqrt((b * b) + (-4 * a *
    // // c)))) / (2 * a)));
    // } else {
    // outputTextArea.append("x" + subscript1 + " = (" + df.format(-b) + " + ("
    // + df.format((Math.sqrt((b * b) + (-4 * a * c))))
    // + ")) / " + df.format(2 * a) + " = " + df.format(-b + (Math.sqrt((b * b) +
    // (-4 * a * c)))) + " / "
    // + df.format(2 * a) + " = ");
    // reduceFractionForPositive(a, b, c);

    // }

    // outputTextArea.append("\n");

    // // x2 negative \u2082
    // char subscript2 = '\u2081';
    // if (signCheck > 0) {
    // // System.out.println("x"+ subscript2 +" = (" + df.format(-b) + " - " +
    // // df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a) +
    // "
    // // = " + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " +
    // // df.format(2 * a) + " = " + df.format((-b - (Math.sqrt((b * b) + (-4 * a *
    // // c)))) / (2 * a)));
    // outputTextArea.append("x" + subscript2 + " = (" + df.format(-b) + " - "
    // + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a) +
    // " = "
    // + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " + df.format(2 *
    // a) + " = ");

    // reduceFractionForNegative(a, b, c);

    // // System.out.print(" or " + df.format((-b - (Math.sqrt((b * b) + (-4 * a *
    // // c)))) / (2 * a)));

    // } else {
    // outputTextArea.append("x" + subscript2 + " = (" + df.format(-b) + " - ("
    // + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ")) / " + df.format(2 * a) +
    // " = "
    // + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " + df.format(2 *
    // a) + " = ");

    // reduceFractionForNegative(a, b, c);

    // }
    // }

    // public static void reduceFractionForNegative(double a, double b, double c) {
    // double numerator = -b - (Math.sqrt((b * b) + (-4 * a * c)));
    // double denominator = 2 * a;
    // BigDecimal decimalNumerator = BigDecimal.valueOf(numerator);
    // BigDecimal decimalDenominator = BigDecimal.valueOf(denominator);

    // BigInteger gcd =
    // decimalNumerator.toBigInteger().gcd(decimalDenominator.toBigInteger());

    // BigDecimal reducedNumerator = decimalNumerator.divide(new BigDecimal(gcd));
    // BigDecimal reducedDenominator = decimalDenominator.divide(new
    // BigDecimal(gcd));

    // DecimalFormat df = new DecimalFormat("#.##");

    // if (reducedDenominator.compareTo(BigDecimal.ONE) == 0) {
    // System.out.print(df.format((-b - (Math.sqrt((b * b) + (-4 * a * c)))) / (2 *
    // a)));
    // } else {
    // System.out.print(df.format(reducedNumerator) + " / " +
    // df.format(reducedDenominator) + " or "
    // + df.format((-b - (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
    // }
    // }

    // public static void reduceFractionForPositive(double a, double b, double c) {
    // double numerator = -b + (Math.sqrt((b * b) + (-4 * a * c)));
    // double denominator = 2 * a;
    // BigDecimal decimalNumerator = BigDecimal.valueOf(numerator);
    // BigDecimal decimalDenominator = BigDecimal.valueOf(denominator);

    // BigInteger gcd =
    // decimalNumerator.toBigInteger().gcd(decimalDenominator.toBigInteger());

    // BigDecimal reducedNumerator = decimalNumerator.divide(new BigDecimal(gcd));
    // BigDecimal reducedDenominator = decimalDenominator.divide(new
    // BigDecimal(gcd));

    // DecimalFormat df = new DecimalFormat("#.##");

    // if (reducedDenominator.compareTo(BigDecimal.ONE) == 0) {
    // System.out.print(df.format((-b + (Math.sqrt((b * b) + (-4 * a * c)))) / (2 *
    // a)));
    // } else {
    // System.out.print(df.format(reducedNumerator) + " / " +
    // df.format(reducedDenominator) + " or "
    // + df.format((-b + (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
    // }
    // }

    private JTextArea outputTextArea;
    private DecimalFormat df;

    public EquationSolver(JTextArea outputTextArea) {
        this.outputTextArea = outputTextArea;
        this.df = new DecimalFormat("#.##");
    }

    public void solveQuadraticEquation(String equation) {

        double[] coefficients = getValues(equation);

        double a = coefficients[0];
        double b = coefficients[1];
        double c = coefficients[2];

        outputTextArea.append("Quadratic formula:\nx = (-b ± √(b^2 - 4ac)) / (2a)\n");
        outputTextArea.append("Here, a = " + df.format(a) + ", b = " + df.format(b) + ", c = " + df.format(c) + "\n");
        outputTextArea.append("Therefore, by substituting values we get:\n");

        outputTextArea.append("x = (-(" + df.format(b) + ") ± √((" + df.format(b) + ")^2 - " + "4 * " + df.format(a)
                + " * " + df.format(c) + "))" + " / " + "(2 * " + df.format(a) + ")\n");

        if (-4 * a * c > 0) {
            outputTextArea.append("x = (" + df.format(-b) + " ± √(" + df.format(b * b) + " + " + df.format(-4 * a * c)
                    + "))" + " / " + df.format(2 * a) + "\n");
        } else {
            outputTextArea
                    .append("x = (" + df.format(-b) + " ± √(" + df.format(b * b) + " - " + df.format(-(-4 * a * c))
                            + "))" + " / " + df.format(2 * a) + "\n");
        }

        outputTextArea.append("x = (" + df.format(-b) + " ± √" + df.format((b * b) + (-4 * a * c)) + ")" + " / "
                + df.format(2 * a) + "\n");

                double discriminant = (b * b) + (-4 * a * c);

                if (discriminant < 0) {
                    // Handle the case where the quadratic equation has no real roots
                    outputTextArea.append("The quadratic equation has no real roots.");
                    return;
                } else
            
        outputTextArea
                .append("x = (" + df.format(-b) + " ± " + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ")" + " / "
                        + df.format(2 * a) + "\n");
                

        outputTextArea.append("\nRoot 1:\n");

        // x1 positive subscript 1
        // char subscript1 = '\u2081';
        // char subscript1 = '₁';
        char subscript1 = '1';
        if (Math.sqrt((b * b) + (-4 * a * c)) > 0) {
            if (Math.sqrt((b * b) + (-4 * a * c)) % 1 != 0) {
                // The result is a decimal
                outputTextArea.append("x" + subscript1 + " = (" + df.format(-b) + " + "
                        + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a) + " ≈ ");
            
                        reduceFractionForPositive(a, b, c);
            }
            else {
            // result positive
            outputTextArea.append("x" + subscript1 + " = (" + df.format(-b) + " + "
                    + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a) + "\nx" + subscript1
                    + " = "
                    + df.format(-b + (Math.sqrt((b * b) + (-4 * a * c)))) + " / " + df.format(2 * a) + "\nx"
                    + subscript1 + " = ");

            reduceFractionForPositive(a, b, c);
            }
        }
        else {
            // result negative
            outputTextArea.append("x" + subscript1 + " = (" + df.format(-b) + " + ("
                    + df.format((Math.sqrt((b * b) + (-4 * a * c))))
                    + ")) / " + df.format(2 * a) + "\nx" + subscript1 + " = "
                    + df.format(-b + (Math.sqrt((b * b) + (-4 * a * c))))
                    + " / "
                    + df.format(2 * a) + "\nx" + subscript1 + " = ");

            reduceFractionForPositive(a, b, c);
        }

        outputTextArea.append("\nRoot 2:\n");

        // x2 negative subscript 2
        // char subscript2 = '\u2082';
        // char subscript2 = '₂';
        char subscript2 = '2';
        if (Math.sqrt((b * b) + (-4 * a * c)) > 0) {
            if (Math.sqrt((b * b) + (-4 * a * c)) % 1 != 0) {
                // The result is a decimal
                outputTextArea.append("x" + subscript2 + " = (" + df.format(-b) + " - "
                        + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a)
                        + " ≈ ");
            
                reduceFractionForNegative(a, b, c);
            }
                else {
            outputTextArea.append("x" + subscript2 + " = (" + df.format(-b) + " - "
                    + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ") / " + df.format(2 * a) + "\nx" + subscript2
                    + " = "
                    + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " + df.format(2 * a) + "\nx"
                    + subscript2 + " = ");

            reduceFractionForNegative(a, b, c);
                }
        } 
        else {
            outputTextArea.append("x" + subscript2 + " = (" + df.format(-b) + " - ("
                    + df.format(Math.sqrt((b * b) + (-4 * a * c))) + ")) / " + df.format(2 * a) + "\nx" + subscript2
                    + " = "
                    + df.format(-b - (Math.sqrt((b * b) + (-4 * a * c)))) + " / " + df.format(2 * a) + "\nx"
                    + subscript2 + " = ");

            reduceFractionForNegative(a, b, c);
        }
    }

    private void reduceFractionForPositive(double a, double b, double c) {
        double numerator = -b + (Math.sqrt((b * b) + (-4 * a * c)));
        double denominator = 2 * a;
        BigDecimal decimalNumerator = BigDecimal.valueOf(numerator);
        BigDecimal decimalDenominator = BigDecimal.valueOf(denominator);

        BigInteger gcd = decimalNumerator.toBigInteger().gcd(decimalDenominator.toBigInteger());

        BigDecimal reducedNumerator = decimalNumerator.divide(new BigDecimal(gcd));
        BigDecimal reducedDenominator = decimalDenominator.divide(new BigDecimal(gcd));

        DecimalFormat df = new DecimalFormat("#.##");

        if (reducedDenominator.compareTo(BigDecimal.ONE) == 0) {
            outputTextArea.append(df.format((-b + (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
        } 
        else if (Math.sqrt((b * b) + (-4 * a * c)) % 1 != 0) {
            outputTextArea.append(df.format((-b + (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
        }
        else {
            outputTextArea.append(df.format(reducedNumerator) + " / " + df.format(reducedDenominator) + " or "
                    + df.format((-b + (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
        }
    }

    private void reduceFractionForNegative(double a, double b, double c) {
        double numerator = -b - (Math.sqrt((b * b) + (-4 * a * c)));
        double denominator = 2 * a;
        BigDecimal decimalNumerator = BigDecimal.valueOf(numerator);
        BigDecimal decimalDenominator = BigDecimal.valueOf(denominator);

        BigInteger gcd = decimalNumerator.toBigInteger().gcd(decimalDenominator.toBigInteger());

        BigDecimal reducedNumerator = decimalNumerator.divide(new BigDecimal(gcd));
        BigDecimal reducedDenominator = decimalDenominator.divide(new BigDecimal(gcd));

        DecimalFormat df = new DecimalFormat("#.##");

        if (reducedDenominator.compareTo(BigDecimal.ONE) == 0) {
            outputTextArea.append(df.format((-b - (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
        } 
        else if (Math.sqrt((b * b) + (-4 * a * c)) % 1 != 0) {
            outputTextArea.append(df.format((-b - (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
        }
        else if (Math.sqrt((b * b) + (-4 * a * c)) == 0) {
            outputTextArea.append(df.format((-b - (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
        }
        else {
            outputTextArea.append(df.format(reducedNumerator) + " / " + df.format(reducedDenominator) + " or "
                    + df.format((-b - (Math.sqrt((b * b) + (-4 * a * c)))) / (2 * a)));
        }
    }

    private double greatestCommonDivisor(double a, double b) {
        if (b == 0) {
            return a;
        }

        return greatestCommonDivisor(b, a % b);
    }

    static double[] getValues(String equation) {
        // System.out.print("Entered String: " + equation);
        // Remove spaces and split the equation into its components
        equation = equation.replaceAll("\\s", "");
        String[] components = equation.split("=");

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

        double[] coefficients = { a, b, c };
        return coefficients;

    }

    private static int extractCoefficient_ForEquation(String term, String variable) {
        if (term.endsWith(variable)) {
            return term.equals(variable) ? 1 : Integer.parseInt(term.substring(0, term.indexOf(variable)));
        } else {
            return -1 * (term.equals("-" + variable) ? 1 : Integer.parseInt(term.substring(0, term.indexOf(variable))));
        }
    }
}
