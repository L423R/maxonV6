package utils;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Maxon on 01.03.2017.
 */
public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {

    private JXDatePicker picker = new JXDatePicker();

    public DateCellEditor() {
        picker.setFormats(new SimpleDateFormat("dd/MM/yy"));
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value==null)
        {
            picker.setDate(new Date(System.currentTimeMillis()));
            return picker;
        }
        Timestamp timestamp = (Timestamp) value;
        Date date = new Date(timestamp.getTime());
        picker.setDate(date);
        return picker;
    }

    public Object getCellEditorValue() {
        //picker.getDate().getTime();
        if (picker.getDate()==null)
            return null;
        Timestamp timestamp = new Timestamp(picker.getDate().getTime());
        return timestamp;
    }
}
