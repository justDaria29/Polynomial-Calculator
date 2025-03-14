package model;
import javax.swing.*;
import java.util.TreeMap;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

private TreeMap<Integer, Double> terms;      // TreeMap to store polynomial terms with powers as keys and coefficients as values

public Polynomial(){                        // Constructor initializes the TreeMap
    terms=new TreeMap<>();
}
    public Polynomial Polynomial1(Polynomial p1) {
        Polynomial polynomial = new Polynomial(); // Create a new Polynomial object
        polynomial.setTerms(new TreeMap<>(p1.getTerms())); // Copy the terms from p1 to the new Polynomial
        return polynomial; // Return the new Polynomial object
    }


    // Method to parse a polynomial string and populate the TreeMap with its terms
public void parsePolynomial(String polynomialString){
    terms.clear();
    polynomialString=polynomialString.replaceAll("\\s+","");  //remove whitespace
    String[] termStrings=polynomialString.split("(?=[-+])");            //split polynomial by + or -

    for(String termString:termStrings){   // Iterate through each term string obtained after splitting
        double coefficient;
        int power;

        if(termString.contains("x")){    // If the term contains 'x', parse the coefficient and power
            String[] parts=termString.split("x");
            if(parts[0].isEmpty())
                coefficient=1.0;
            else if (parts[0].equals("-")) {
                coefficient=-1.0;
            }else
                coefficient=Double.parseDouble(parts[0]);

            if(parts[1].length()==1||parts[1].isEmpty())
                power=1;
            else
                power=Integer.parseInt(parts[1].substring(1));
        } else{
            coefficient=Double.parseDouble(termString);
            power=0;
        }

        terms.put(power,coefficient);
    }
}


    // Method to convert the polynomial to a string representation
@Override
    public String toString(){
    StringBuilder result=new StringBuilder();
    for(int power:terms.descendingKeySet()){ // Iterate through the terms in descending order of powers
        double coefficient=terms.get(power);
        if(coefficient!=0){                 // Append the appropriate sign and coefficient to the result string
            if(coefficient>0 && result.length()!=0)
                result.append(" + ");
            if(coefficient<0){
                result.append(" - ");
                coefficient=-coefficient;
            }

            if(power==0)
                result.append(coefficient);
            else{
                if(coefficient!=1)
                    result.append(coefficient);
                result.append("x");
                if(power!=1)
                    result.append("^").append(power);
            }
        }
    }
    return result.toString();
}

    // Getters and Setters for terms TreeMap
    public TreeMap<Integer, Double> getTerms() {
        return terms;
    }

    public void setTerms(TreeMap<Integer, Double> terms) {
        this.terms = terms;
    }

    public Polynomial(Polynomial polynomial){
    this.terms=new TreeMap<>(polynomial.terms);
    }

    public void orderTerms() {
        TreeMap<Integer, Double> orderedTerms = new TreeMap<>(Collections.reverseOrder());
        orderedTerms.putAll(terms);
        terms = orderedTerms;
        //trebuie modificata ca sa returneze termenii din polinom
    }

    public int degree() {
    if(terms.isEmpty())
    System.out.println("cade");
        return terms.isEmpty() ? 0 : terms.lastKey();
    }

    public double firstCoefficient() {
        // Check if the polynomial is empty
        if (terms.isEmpty()) {
            throw new IllegalStateException("Polynomial is empty");
        }

        // Get the coefficient of the term with the highest power
        int highestPower = terms.lastKey();
        return terms.get(highestPower);
    }

    public void addTerm(int power, double coefficient) {
        terms.put(power, coefficient);
    }


}
