package org.example;

import controller.Controller;
import gui.View;

public class Main {
    public static void main(String[] args){
        View newView=new View();
        Controller controller = new Controller(newView);
        newView.setVisibility(true);
    }
}




