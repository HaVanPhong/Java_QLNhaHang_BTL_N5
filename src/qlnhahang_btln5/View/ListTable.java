package qlnhahang_btln5.View;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author HaPhong
 */
public class ListTable<E extends Object> extends JList<E>{
    private final DefaultListModel model;
    public ListTable() {
        model= new DefaultListModel();
        setModel(model);
    }

    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean isSelected, boolean cellHasFocus) {
                TableItem item= new TableItem();
                item.setItem(o);
                
                return item;
            }
            
        };
    }
//
//    @Override
//    public void setLayoutOrientation(int layoutOrientation) {
//        super.setLayoutOrientation(layoutOrientation); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
    public void addTable(Tables table){
        model.addElement(table);
    }
    
    
    
}
