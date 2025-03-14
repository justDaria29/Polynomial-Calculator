package controller;

import gui.View;
import logic.Operation;
import model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener {

    private View view;
    public AddButtonListener(View view){this.view=view;}

    @Override
    public void actionPerformed(ActionEvent e){
        String poly1=view.getFp();
        String poly2=view.getSp();
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1.parsePolynomial(poly1);
        p2.parsePolynomial(poly2);
        Polynomial result= Operation.add(p1,p2);
        view.setRp(result.toString());
    }
}

