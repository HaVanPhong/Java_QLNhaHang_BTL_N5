package qlnhahang_btln5.View;

import java.awt.Color;
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
                if (isSelected){
                    item.setBackgroundd(Color.red);
                }
                if (dangPhucVu((Tables)o)){
                    item.setBackgroundd(Color.yellow);
                }
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
    
    public boolean dangPhucVu(Tables table){
        for (int i=0; i<OrderManager.getListOrderingOfTable().size(); i++){
            if (OrderManager.getListOrderingOfTable().get(i).getTbNumber()== table.getTbNumber() && OrderManager.getListOrderingOfTable().get(i).getDishOrders().size()>0){
                return true;
            }
        }
        return false;
    }
    
    
    
}
