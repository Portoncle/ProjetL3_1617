/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.IData;



/**
 *
 * @author PALACIOS Nicolas
 */
public class Main {
    
    public static void main(String args[]) {
        // CONSTRUCTION DU SET DE CAPTEURS
        
        IData iData = new IData(/*SETCAPTEURS capteurs*/);
        iData.setLocationRelativeTo(null);
        iData.setVisible(true);
    }
    
}