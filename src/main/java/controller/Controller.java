package controller;

import gui.View;

public class Controller {
    private View view;

    public Controller(View view){
        this.view=view;

        view.getAddButton().addActionListener(new AddButtonListener(view));
        view.getSubtractButton().addActionListener(new SubtractButtonListener(view));
        view.getMultiplicateButton().addActionListener(new MultiplicateButtonListener(view));
        view.getDivideButton().addActionListener(new DivideButtonListener(view));
        view.getDerivativeButton().addActionListener(new DerivativeButtonListener(view));
        view.getIntegrateButton().addActionListener(new IntegrationButtonListener(view));

    }

}
