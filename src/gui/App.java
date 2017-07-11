package gui;

import java.util.ArrayList;
import java.util.List;
import jclipboard.JClipboard;
import jclipboard.listeners.DataCopiedListener;
import model.TM_URL;

public class App extends javax.swing.JFrame implements DataCopiedListener {

    private List<String> urls;
    private JClipboard clip;

    public App() {
        initComponents();
        urls = new ArrayList<>();

        clip = new JClipboard(10, this);
        clip.start();

        tabUrl.setModel(new TM_URL(urls));
        this.setAlwaysOnTop(true);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUrl = new javax.swing.JTable();
        opAOT = new javax.swing.JCheckBox();

        jMenuItem1.setText("Eliminar URL");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerfermed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabUrl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabUrl.setComponentPopupMenu(jPopupMenu1);
        tabUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabUrlMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabUrlMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabUrlMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabUrl);

        opAOT.setSelected(true);
        opAOT.setText("Always on top");
        opAOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opAOTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opAOT)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opAOT)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opAOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opAOTActionPerformed
        this.setAlwaysOnTop(opAOT.isSelected());
    }//GEN-LAST:event_opAOTActionPerformed

    private void tabUrlMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUrlMouseReleased
        
    }//GEN-LAST:event_tabUrlMouseReleased

    private void tabUrlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUrlMousePressed
//        if (evt.isPopupTrigger()) {
//            JPopupMenu menu = new JPopupMenu();
//            JMenuItem mi = new JMenuItem("asd");
//            mi.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("asdlkajsdlkjasd");
//                }
//            });
//            menu.add(mi);
//
//            menu.setLocation(evt.getLocationOnScreen());
//            menu.setVisible(true);
//        }
    }//GEN-LAST:event_tabUrlMousePressed

    private void tabUrlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabUrlMouseClicked
        
    }//GEN-LAST:event_tabUrlMouseClicked

    private void eliminarActionPerfermed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerfermed
        System.out.println(tabUrl.getValueAt(tabUrl.getSelectedRow(), 0));
    }//GEN-LAST:event_eliminarActionPerfermed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox opAOT;
    private javax.swing.JTable tabUrl;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stringCopied(String text) {
        if (text.contains("http")) {
            urls.add(text);

            tabUrl.setModel(new TM_URL(urls));
        }
    }
}
