package controller;

import gui.View;
import logic.Operation;
import model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegrationButtonListener implements ActionListener{

    private View view;
    public IntegrationButtonListener(View view){this.view=view;}

    @Override
    public void actionPerformed(ActionEvent e){
        String poly1=view.getFp();
        Polynomial p1 = new Polynomial();
        p1.parsePolynomial(poly1);
       // Polynomial p1 = new Polynomial(poly1);

        Polynomial result= Operation.integration(p1);
        view.setRp(result.toString());
    }
}
