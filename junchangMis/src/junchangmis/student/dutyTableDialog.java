/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dutyTableDialog.java
 *
 * Created on 2011-5-9, 20:25:32
 */

package junchangmis.student;

import junchangmis.MainFrame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.write.WriteException;
import publicmethod.*;
import junchangmis.codecSetting.*;
import javax.swing.JOptionPane;

/**
 *
 * @author developers
 */
public class dutyTableDialog extends javax.swing.JDialog {

    MainFrame parent;
    /** Creates new form dutyTableDialog */
    public dutyTableDialog(java.awt.Frame parent, boolean modal,MainFrame pparent) {
        super(parent, modal);
        this.parent = pparent;
        initComponents();
        this.jButtonConfirm.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setTitle("班级选择");
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClassCode = new javax.swing.JLabel();
        jTextFieldClassCode = new javax.swing.JTextField();
        jLabelCodeShow = new javax.swing.JLabel();
        jCheckBoxPrint = new javax.swing.JCheckBox();
        jButtonConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelClassCode.setText("输入专业班级编码");

        jTextFieldClassCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClassCodeActionPerformed(evt);
            }
        });

        jLabelCodeShow.setText("——");

        jCheckBoxPrint.setText("是否打印");

        jButtonConfirm.setText("确定");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButtonConfirm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelClassCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxPrint)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldClassCode, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCodeShow, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClassCode)
                    .addComponent(jTextFieldClassCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodeShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jCheckBoxPrint)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirm)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldClassCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClassCodeActionPerformed
        // TODO add your handling code here:
        String classCode = this.jTextFieldClassCode.getText();
        if (classCode == null || classCode.length() != 6) {
            JOptionPane.showConfirmDialog(null, "专业班级的编码格式错误！", "提示", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            this.jLabelCodeShow.setText("");
            this.jTextFieldClassCode.setSelectionStart(0);
        } else {           
            String codeTriple = codecMethod.getCodeTripleMeaning(this.jTextFieldClassCode.getText());//获得总编码的翻译结果
            if (codeTriple == null) {
                JOptionPane.showConfirmDialog(null, "不存在该专业班级编码！", "提示", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                this.jTextFieldClassCode.setSelectionStart(0);
                return;
            }           
            this.jLabelCodeShow.setText("：" + codeTriple);
            this.jButtonConfirm.setEnabled(true);//只有编码格式正确后，确定按钮才可以用
        }
}//GEN-LAST:event_jTextFieldClassCodeActionPerformed

    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
       /*     dutyTableExcel work = new dutyTableExcel(this.jTextFieldClassCode.getText());
            String filename = "交费登记表\\";
            filename = filename + this.jTextFieldClassCode.getText() + "班交费登记表.xls";
            work.setOutputFile(filename);
            work.write();
            System.out.println("Please check the result file " + filename);
            JOptionPane.showConfirmDialog(null, "生成成功", "提示", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (this.jCheckBoxPrint.isSelected() == true) {
                PrintTest.print(PrintTest.getPath() + "\\" + filename);
            } else {
                PrintTest.showTable(PrintTest.getPath() + "\\" + filename);
            }
            //this.parent.setVisible(true);//显示父窗口
            dispose();//关闭自己
*/

            
}//GEN-LAST:event_jButtonConfirmActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dutyTableDialog dialog = new dutyTableDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JCheckBox jCheckBoxPrint;
    private javax.swing.JLabel jLabelClassCode;
    private javax.swing.JLabel jLabelCodeShow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldClassCode;
    // End of variables declaration//GEN-END:variables

}
