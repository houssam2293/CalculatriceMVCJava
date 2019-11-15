/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package mvc;

/**
 *
 * @author AsmaPC
 */
public class Mvc {
    
    public static void main(String[] args) {
    	
    	CalculatorView theView = new CalculatorView();
        
    	CalculatorModel theModel = new CalculatorModel();
        
        CalculatorController theController = new CalculatorController(theView,theModel);
        
        theView.setVisible(true);
        
    }
}