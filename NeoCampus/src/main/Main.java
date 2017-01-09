/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.IBegin;
import GUI.IData;



/**
 *
 * @author PALACIOS Nicolas
 */
public class Main {
    
    public static void main(String args[]) {
        /*IData iData = new IData();
        iData.setLocationRelativeTo(null);
        iData.setVisible(true);*/
        IBegin iBegin = new IBegin();
        iBegin.setLocationRelativeTo(null);
        iBegin.setVisible(true);
    }
    
}
