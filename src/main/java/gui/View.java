package gui;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    JLabel panel1=new JLabel();

    public JLabel titleLabel= new JLabel("Polynomial Calculator");
    public  JLabel firstLabel= new JLabel("First Polynomial = ");
    public JLabel resultLabel= new JLabel("Result = ");
    private  JTextField fp= new JTextField();
    public  JTextField rp= new JTextField();
    public JLabel secondLabel= new JLabel("Second Polynomial = ");
    public JTextField sp= new JTextField();
    public JButton multiplicateButton= new JButton("Multiplay");
    public JButton subtractButton= new JButton("Substract");
    public JButton divideButton= new JButton("Divide");
    public JButton derivativeButton= new JButton("Derivative");
    public JButton addButton= new JButton("Add");
   public  JButton integrateButton= new JButton("Integrate");
    JFrame frame=new JFrame();

    public View(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(80, 20, 350, 40);

        firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        firstLabel.setBounds(10, 70, 150, 25);

        fp.setHorizontalAlignment(SwingConstants.CENTER);
        fp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fp.setBounds(160, 70, 300, 25);

        secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        secondLabel.setBounds(10, 110, 150, 25);

        sp.setHorizontalAlignment(SwingConstants.CENTER);
        sp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        sp.setBounds(160, 110, 300, 25);

        addButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addButton.setBounds(10, 150, 100, 25);

        subtractButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        subtractButton.setBounds(150, 150, 100, 25);

        divideButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        divideButton.setBounds(300, 150, 100, 25);

        multiplicateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        multiplicateButton.setBounds(10, 200, 100, 25);

        derivativeButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        derivativeButton.setBounds(150, 200, 100, 25);

        integrateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        integrateButton.setBounds(300, 200, 100, 25);


        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        resultLabel.setBounds(10, 300, 150, 25);

        rp.setHorizontalAlignment(SwingConstants.CENTER);
        rp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rp.setBounds(160, 300, 300, 25);

        // addButton.addActionListener(e -> controller.addButtonClicked());
        panel1.add(titleLabel);
        panel1.add(firstLabel);
        panel1.add(fp);
        panel1.add(resultLabel);
        panel1.add(rp);
        panel1.add(secondLabel);
        panel1.add(sp);
        panel1.add(addButton);
        panel1.add(subtractButton);
        panel1.add(divideButton);
        panel1.add(multiplicateButton);
        panel1.add(derivativeButton);
        panel1.add(integrateButton);

        frame.setContentPane(panel1);
    }

    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }

    public String getFp() {
        return fp.getText().trim();
    }
    public String getSp() {
        return sp.getText().trim();
    }

public void setRp(String text){rp.setText(text);}

    public JButton getMultiplicateButton() {
        return multiplicateButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDerivativeButton() {
        return derivativeButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getIntegrateButton() {
        return integrateButton;
    }


}
