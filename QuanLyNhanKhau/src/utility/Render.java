package utility;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Render extends DefaultTableCellRenderer {
    public Component getTableCellRenderComponent(JTable table,Object value, boolean isSelected,boolean hasFocus,int row,int column) {
        if (value instanceof JCheckBox) {

            JCheckBox JCheckBox = (JCheckBox) value;
            return JCheckBox;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
