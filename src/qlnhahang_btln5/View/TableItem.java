/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import java.awt.Color;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author HaPhong
 */
public class TableItem extends javax.swing.JPanel {    
    
    public TableItem() {
        initComponents();
        
    }
    
    public void setItem(Object obj){
        if (obj instanceof Tables){ 
            Tables item= (Tables) obj;
            lbSoBan.setText(item.getTbNumber()+"");
        }else {
            lbSoBan.setText(obj+"");
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSoBan = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 153, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 255, 153)));

        lbSoBan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbSoBan.setText("1");
        lbSoBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickSoBan(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(lbSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbSoBan, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickSoBan(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickSoBan
        
    }//GEN-LAST:event_clickSoBan

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbSoBan;
    // End of variables declaration//GEN-END:variables
}
