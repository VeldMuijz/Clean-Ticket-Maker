/*
 * IntroScreen.java
 *
 * Created on Jul 12, 2012, 11:27:01 AM
 */
package view;

import main.MainApp;

/**
 * This is the Introduction screen. From here the user will see some general
 * information about the application and instructions.
 * @author vm
 */
public class IntroScreen extends javax.swing.JPanel {

	/** Creates new form IntroScreen */
	public IntroScreen() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCRA = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextIntroText = new javax.swing.JTextArea();
        jButtonOSA = new javax.swing.JButton();
        jButtonGEA = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));

        jButtonCRA.setBackground(new java.awt.Color(254, 254, 254));
        jButtonCRA.setText("CRA");
        jButtonCRA.setMaximumSize(new java.awt.Dimension(150, 30));
        jButtonCRA.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonCRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCRAActionPerformed(evt);
            }
        });

        jTextIntroText.setColumns(20);
        jTextIntroText.setEditable(false);
        jTextIntroText.setFont(new java.awt.Font("Arial", 0, 12));
        jTextIntroText.setRows(5);
        jTextIntroText.setText("Dit is een test.");
        jScrollPane2.setViewportView(jTextIntroText);

        jButtonOSA.setBackground(new java.awt.Color(254, 254, 254));
        jButtonOSA.setText("OSA");
        jButtonOSA.setMaximumSize(new java.awt.Dimension(150, 30));
        jButtonOSA.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonOSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOSAActionPerformed(evt);
            }
        });

        jButtonGEA.setBackground(new java.awt.Color(254, 254, 254));
        jButtonGEA.setText("GEA");
        jButtonGEA.setMaximumSize(new java.awt.Dimension(150, 30));
        jButtonGEA.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonGEA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGEAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonGEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void jButtonGEAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGEAActionPerformed
	//Use this to switch from screen Intro to SelectionGEA
	MainApp.getInstance().switchPanel(new view.SelectionScreenGEA());
		
	}//GEN-LAST:event_jButtonGEAActionPerformed

	private void jButtonCRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCRAActionPerformed
	//Use this to switch from screen Intro to SelectionCRA
	MainApp.getInstance().switchPanel(new view.SelectionScreenCRA());
		
	}//GEN-LAST:event_jButtonCRAActionPerformed

	private void jButtonOSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOSAActionPerformed
		//Use this to switch from screen Intro to SelectionGEA
	MainApp.getInstance().switchPanel(new view.SelectionScreenOSA());
	}//GEN-LAST:event_jButtonOSAActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCRA;
    private javax.swing.JButton jButtonGEA;
    private javax.swing.JButton jButtonOSA;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextIntroText;
    // End of variables declaration//GEN-END:variables
}
