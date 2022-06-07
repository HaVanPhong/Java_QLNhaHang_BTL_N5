/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.View;

import java.awt.Color;
import javax.swing.JPanel;
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

        jPBG = new javax.swing.JPanel();
        lbSoBan = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 255, 153)));

        jPBG.setBackground(new java.awt.Color(51, 153, 255));
        jPBG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPBGFocusLost(evt);
            }
        });
        jPBG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPBGMouseClicked(evt);
            }
        });

        lbSoBan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbSoBan.setText("1");
        lbSoBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickSoBan(evt);
            }
        });

        javax.swing.GroupLayout jPBGLayout = new javax.swing.GroupLayout(jPBG);
        jPBG.setLayout(jPBGLayout);
        jPBGLayout.setHorizontalGroup(
            jPBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBGLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(lbSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPBGLayout.setVerticalGroup(
            jPBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBGLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clickSoBan(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickSoBan
        
    }//GEN-LAST:event_clickSoBan

    private void jPBGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPBGFocusLost
       
    }//GEN-LAST:event_jPBGFocusLost

    private void jPBGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPBGMouseClicked
        jPBG.setBackground(Color.yellow);
    }//GEN-LAST:event_jPBGMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPBG;
    private javax.swing.JLabel lbSoBan;
    // End of variables declaration//GEN-END:variables
}
