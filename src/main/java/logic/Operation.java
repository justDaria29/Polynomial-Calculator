package logic;
import model.Polynomial;

import java.net.SocketOption;
import java.util.TreeMap;
import java.util.Map;

public class Operation {

public static Polynomial add(Polynomial p1, Polynomial p2){
    TreeMap<Integer,Double> resultTerms=new TreeMap<>(p1.getTerms());

    for(int power:p2.getTerms().keySet()){
        double coefficient=p2.getTerms().get(power);
        resultTerms.put(power, resultTerms.getOrDefault(power,0.0)+coefficient);
    }

    Polynomial result=new Polynomial();
    result.setTerms(resultTerms);
    return result;
}

    /*public static Polynomial add(Polynomial p1, Polynomial p2) {
        TreeMap<Integer, Double> resultTerms = new TreeMap<>();

        // Combine terms from p1
        for (Map.Entry<Integer, Double> entry : p1.getTerms().entrySet()) {
            int power = entry.getKey();
            double coefficient = entry.getValue();
            resultTerms.put(power, resultTerms.getOrDefault(power, 0.0) + coefficient);
        }

        // Combine terms from p2
        for (Map.Entry<Integer, Double> entry : p2.getTerms().entrySet()) {
            int power = entry.getKey();
            double coefficient = entry.getValue();
            resultTerms.put(power, resultTerms.getOrDefault(power, 0.0) + coefficient);
        }

        Polynomial result = new Polynomial();
        result.setTerms(resultTerms);
        return result;
    }*/


    public static Polynomial subtract(Polynomial p1, Polynomial p2){
    TreeMap<Integer,Double> resultTerms=new TreeMap<>(p1.getTerms());

    for(int power:p2.getTerms().keySet()){
        double coefficient=p2.getTerms().get(power);
        resultTerms.put(power,resultTerms.getOrDefault(power,0.0)-coefficient);
    }

    Polynomial result=new Polynomial();
    result.setTerms(resultTerms);
    return result;
}

public static Polynomial multiply(Polynomial p1, Polynomial p2){
    TreeMap<Integer,Double> resultTerms=new TreeMap<>();

    for(int power1:p1.getTerms().keySet()){
        double coefficient1=p1.getTerms().get(power1);

        for(int power2:p2.getTerms().keySet()){
            double coefficient2=p2.getTerms().get(power2);
            resultTerms.put(power1+power2, resultTerms.getOrDefault(power1+power2,0.0)+(coefficient1*coefficient2));
        }
    }

    Polynomial result=new Polynomial();
    result.setTerms(resultTerms);
    return result;
}

/*public static Polynomial divide(Polynomial p1, Polynomial p2){

    p1.orderTerms();
    p2.orderTerms();

    Polynomial result=new Polynomial();
    Polynomial remainder=new Polynomial(p1);

    if(p2.getTerms().isEmpty())
        throw new ArithmeticException("Division by zero is impossible");

    while (remainder.degree()>=p2.degree()){

        double coeff1=remainder.firstCoefficient();
        double coeff2=p2.firstCoefficient();

        double quotientCoefficient=coeff1/coeff2;
        int power= remainder.degree()-p2.degree();

        Polynomial quotient=new Polynomial();
        quotient.addTerm(power,quotientCoefficient);
        result=add(result,quotient);

        Polynomial term=multiply(p2,quotient);
        remainder=subtract(remainder,term);
    }

    return result;
}*/

    public static Polynomial divide(Polynomial p1, Polynomial p2) {
        // Ensure divisor is not zero polynomial
        if (p2.getTerms().isEmpty()) {
            throw new ArithmeticException("Division by zero polynomial");
        }

        // Initialize result polynomial as an empty polynomial
        Polynomial result = new Polynomial();

        // Create a copy of the dividend to avoid modifying the original
        Polynomial remainder=new Polynomial();
        remainder.Polynomial1(p1);

        // Ensure both polynomials are ordered by degree
        p1.orderTerms();
        System.out.println(p1.getTerms().toString());
        p2.orderTerms();
        System.out.println(p2.getTerms().toString());
        // Perform polynomial division
        System.out.println(remainder.degree());
        while (remainder.degree() >= p2.degree()&& !remainder.getTerms().isEmpty()) {
            // Determine the leading term of the quotient
            int quotientDegree = remainder.degree() - p2.degree();
            double quotientCoefficient = remainder.firstCoefficient() / p2.firstCoefficient();

            // Add the leading term to the result polynomial
            Polynomial quotientTerm = new Polynomial();
            System.out.println("cade");
            quotientTerm.addTerm(quotientDegree, quotientCoefficient);
            //result = add(result, quotientTerm);
            System.out.println("cade");
            result.addTerm(quotientDegree, quotientCoefficient);
            System.out.println("cade");


            // Multiply the divisor with the quotient term
            Polynomial term = multiply(p2, quotientTerm);
            System.out.println("cade");
            // Subtract the term from the remainder
            remainder = subtract(remainder, term);
            System.out.println("cade");
        }

        return result;
    }


    public static Polynomial derivative(Polynomial p){

    TreeMap<Integer, Double> terms = p.getTerms();
    Polynomial result=new Polynomial();

    for(Map.Entry<Integer,Double> term: terms.entrySet()){

        int power = term.getKey();
        double coefficient = term.getValue();

        if (power > 0) {
            double derivativeCoefficient = power * coefficient;
            int derivativePower = power - 1;
            result.getTerms().put(derivativePower, derivativeCoefficient);
        }
    }

    return result;
}

public static Polynomial integration(Polynomial p){
    TreeMap<Integer,Double> terms=p.getTerms();

    Polynomial result=new Polynomial();

    for (Map.Entry<Integer, Double> term : terms.entrySet()) {
        int power = term.getKey();
        double coefficient = term.getValue();

        double integrationCoefficient = coefficient / (power + 1);
        int integrationPower = power + 1;
        if(power>0)
            result.getTerms().put(integrationPower, integrationCoefficient);
    }

    return result;
}
}

