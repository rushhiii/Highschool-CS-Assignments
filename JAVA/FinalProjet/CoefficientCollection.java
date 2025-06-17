package FinalProjet;
// import java.util.ArrayList;

// public class Collection {
//     private ArrayList<Double> coefficients;

//     public Collection() {
//         coefficients = new ArrayList<Double>();
//     }

//     public void addCoefficient(Double coefficient) {
//         coefficients.add(coefficient);
//     }

//     public Double getCoefficient(int index) {
//         return coefficients.get(index);
//     }

//     public int getCoefficientsSize() {
//         return coefficients.size();
//     }
// }

import java.util.ArrayList;

public class CoefficientCollection {
  private ArrayList<Double> coefficients;

  public CoefficientCollection(double a, double b, double c) {
    coefficients = new ArrayList<Double>();
    coefficients.add(a);
    coefficients.add(b);
    coefficients.add(c);
  }

  public double get(int index) {
    return coefficients.get(index);
  }

  public void set(int index, double value) {
    coefficients.set(index, value);
  }

  public int size() {
    return coefficients.size();
  }

  public void add(double value) {
    coefficients.add(value);
  }

  public void remove(int index) {
    coefficients.remove(index);
  }
}
