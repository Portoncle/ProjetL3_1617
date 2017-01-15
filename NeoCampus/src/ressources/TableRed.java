package ressources;

import GUI.IReel;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author nicol
 */
public class TableRed extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            List<Alerte> alertes = IReel.getAlertes();
            Iterator it = alertes.listIterator();
            boolean found = false;
            Alerte alerte;
            
            String type = (String) table.getValueAt(row, 1);
            float val;
            
            if(column == 1) {
                while(it.hasNext() && !found) {
                    alerte = (Alerte) it.next();

                    if(alerte.getType().equals(type)) {
                        found = true;
                        val = (float) table.getValueAt(row, 3);
                        if(val < alerte.getBorneMin() || val > alerte.getBorneMax()) cell.setBackground(Color.RED);
                    }
                }
            }
            
            if(!found) cell.setBackground(Color.WHITE);
            
            return cell;
    }
}
