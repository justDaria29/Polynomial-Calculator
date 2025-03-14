package controller;

import gui.View;
import logic.Operation;
import model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivideButtonListener implements ActionListener{
    private View view;
    public DivideButtonListener(View view){this.view=view;}

    @Override
    public void actionPerformed(ActionEvent e){
        String poly1=view.getFp();
        String poly2=view.getSp();
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        /*Polynomial p1 = new Polynomial(poly1);
        Polynomial p2 = new Polynomial(poly2);*/
        Polynomial result= Operation.divide(p1,p2);
        view.setRp(result.toString());
    }
}
