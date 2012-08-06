/*
 * SelectionScreenCRA.java
 *
 * Created on Jul 12, 2012, 11:27:01 AM
 */
package view;

import data.Clipboard;
import data.Mail;
import data.PartAndCause;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import main.MainApp;

/**
 * With this view it's possible to select the items you wish to make a call for.
 * The standard format is: Machine:Specialiteit:Part:Cause: Free text
 * Something like this: "CRA:HH:Project:Cash:Vastloper: Machine loopt vast bij 
 * test transacties"
 * @author vm
 */
public class SelectionScreenCRA extends javax.swing.JPanel {

	PartAndCause pac = new PartAndCause();
	String ticketString = "";

	/** Creates new form Selection CRA */
	@SuppressWarnings("OverridableMethodCallInConstructor")
	public SelectionScreenCRA() {
		initComponents();

		//Group the radiobuttons to make sure only 1 is selected
		ButtonGroup radiobuttonGroup = new ButtonGroup();
		radiobuttonGroup.add(jRadioButtonCRA);
		radiobuttonGroup.add(jRadioButtonPCE);

		//Set the selection to the CRA radiobutton by default
		jRadioButtonCRA.setSelected(true);
		ticketString = jRadioButtonCRA.getText() + ":";

		//Clear the comboBoxes
		jComboBoxPart.removeAllItems();
		jComboBoxCause.removeAllItems();

		pac.arrayListFill();

		fillComboBox();

		// Do this when something happens to the combobox
		jComboBoxPart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				conditionalfillComboBox();
				scanner();
				showTicketString();
			}
		});

		scanner();
		showTicketString();
	}

	/**
	 * This method scans for the changes in the option where you can choose from
	 * and updates the ticketString
	 */
	public void scanner() {
		String part = "";
		String machine;
		String speciality1 = "";
		String speciality2 = "";
		String speciality3 = "";

		if (jCheckBoxCombiCall.isSelected()) {
			speciality3 = "CC:";
		}
		if (jCheckBoxProject.isSelected()) {
			speciality2 = "PR:";
		}
		if (jCheckBoxReturnCall.isSelected()) {
			speciality1 = "HH:";
		}

		if (getjComboBoxCause().getSelectedItem().toString().equals("Vastloper")) {
			part = getjComboBoxCause().getSelectedItem().toString() + ": (MTC )";
		} else {
			part = getjComboBoxCause().getSelectedItem().toString();
		}

		if (jRadioButtonCRA.isSelected()) {
			machine = "CRA:";
		} else {
			machine = "PC/E:";
		}

		ticketString = machine + speciality1 + speciality2 + speciality3 + getjComboBoxPart().getSelectedItem().toString() + ":" + part
				+ ":" + jTextFieldFreeText.getText();
		
		//Copy the content of ticketString to the clipboard so you don't
		//have to copy it yourself
		Clipboard clpbrd = new Clipboard();
		clpbrd.copyToClipboard(ticketString);
	}

	/**
	 * This method shows the ticketString
	 */
	public void showTicketString() {
		jTextFieldTicketString.setText(ticketString);
	}

	//Copy the Ticket String
	public void copy() {
	}

	/**
	 * This method fills the comobox with the right items
	 */
	public void fillComboBox() {
		// fill the ComboBox with the parts
		for (int i = 0; i < pac.part.size(); i++) {
			jComboBoxPart.addItem(pac.part.get(i));

		}
		for (int i = 0; i < pac.causeCash.size(); i++) {
			jComboBoxCause.addItem(pac.causeCash.get(i));
		}

	}

	/*
	 * This method fills the Combobox Cause with the right options.
	 */
	public void conditionalfillComboBox() {
		//Make a conditional filled combobox to fill the right causes.
		String chosenPart = jComboBoxPart.getSelectedItem().toString();

		if (chosenPart.equals("CASH")) {
			jComboBoxCause.removeAllItems();

			for (int i = 0; i < pac.causeCash.size(); i++) {
				jComboBoxCause.addItem(pac.causeCash.get(i));
			}

		} else if (chosenPart.equals("COIN")) {
			jComboBoxCause.removeAllItems();

			for (int i = 0; i < pac.causeCoin.size(); i++) {
				jComboBoxCause.addItem(pac.causeCoin.get(i));
			}

		} else if (chosenPart.equals("CONNECTION")) {
			jComboBoxCause.removeAllItems();

			for (int i = 0; i < pac.causeConnection.size(); i++) {
				jComboBoxCause.addItem(pac.causeConnection.get(i));
			}

		} else if (chosenPart.equals("FINANCE")) {
			jComboBoxCause.removeAllItems();

			for (int i = 0; i < pac.causeFinance.size(); i++) {
				jComboBoxCause.addItem(pac.causeFinance.get(i));
			}

		} else if (chosenPart.equals("G4S")) {
			jComboBoxCause.removeAllItems();

			for (int i = 0; i < pac.causeG4S.size(); i++) {
				jComboBoxCause.addItem(pac.causeG4S.get(i));
			}
		} else if (chosenPart.equals("RPNT")) {
			jComboBoxCause.removeAllItems();

			for (int i = 0; i < pac.causeRpnt.size(); i++) {
				jComboBoxCause.addItem(pac.causeRpnt.get(i));
			}
		}

	}

	public JComboBox getjComboBoxCause() {
		return jComboBoxCause;
	}

	public void setjComboBoxCause(JComboBox jComboBoxCause) {
		this.jComboBoxCause = jComboBoxCause;
	}

	public JComboBox getjComboBoxPart() {
		return jComboBoxPart;
	}

	public void setjComboBoxPart(JComboBox jComboBoxPart) {
		this.jComboBoxPart = jComboBoxPart;
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxCombiCall = new javax.swing.JCheckBox();
        jCheckBoxProject = new javax.swing.JCheckBox();
        jCheckBoxReturnCall = new javax.swing.JCheckBox();
        jButtonReturn = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelPart = new javax.swing.JLabel();
        jLabelCause = new javax.swing.JLabel();
        jLabelFreeText = new javax.swing.JLabel();
        jLabelTicketString = new javax.swing.JLabel();
        jTextFieldTicketString = new javax.swing.JTextField();
        jTextFieldFreeText = new javax.swing.JTextField();
        jLabelSpecial = new javax.swing.JLabel();
        jLabelMachine = new javax.swing.JLabel();
        jRadioButtonCRA = new javax.swing.JRadioButton();
        jRadioButtonPCE = new javax.swing.JRadioButton();
        jComboBoxCause = new javax.swing.JComboBox();
        jComboBoxPart = new javax.swing.JComboBox();
        jButtonMail = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));

        jCheckBoxCombiCall.setText("Combi Call");
        jCheckBoxCombiCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCombiCallActionPerformed(evt);
            }
        });

        jCheckBoxProject.setText("Project");
        jCheckBoxProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProjectActionPerformed(evt);
            }
        });

        jCheckBoxReturnCall.setText("Herhaal Call");
        jCheckBoxReturnCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxReturnCallActionPerformed(evt);
            }
        });

        jButtonReturn.setText("Terug");
        jButtonReturn.setMaximumSize(new java.awt.Dimension(100, 30));
        jButtonReturn.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        jButtonReset.setText("Reset");
        jButtonReset.setMaximumSize(new java.awt.Dimension(100, 30));
        jButtonReset.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jLabelPart.setText("Onderdeel");

        jLabelCause.setText("Oorzaak");

        jLabelFreeText.setText("Vrije tekst");

        jLabelTicketString.setText("Ticket String");

        jTextFieldTicketString.setEditable(false);

        jTextFieldFreeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFreeTextKeyReleased(evt);
            }
        });

        jLabelSpecial.setText("Specialiteit");

        jLabelMachine.setText("Machine");

        jRadioButtonCRA.setText("CRA");
        jRadioButtonCRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCRAActionPerformed(evt);
            }
        });

        jRadioButtonPCE.setText("PC/E");
        jRadioButtonPCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPCEActionPerformed(evt);
            }
        });

        jComboBoxCause.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxPart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonMail.setText("Mail");
        jButtonMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                                .addComponent(jButtonMail)
                                .addGap(147, 147, 147)
                                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFreeText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTicketString)
                                    .addComponent(jLabelSpecial)
                                    .addComponent(jLabelPart)
                                    .addComponent(jLabelCause))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFreeText, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTicketString, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonCRA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonPCE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxCause, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jCheckBoxCombiCall)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jCheckBoxProject)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jCheckBoxReturnCall))
                                        .addComponent(jComboBoxPart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMachine)
                        .addContainerGap(820, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMachine)
                    .addComponent(jRadioButtonCRA)
                    .addComponent(jRadioButtonPCE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxCombiCall)
                    .addComponent(jCheckBoxProject)
                    .addComponent(jCheckBoxReturnCall)
                    .addComponent(jLabelSpecial))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPart)
                    .addComponent(jComboBoxPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCause)
                    .addComponent(jComboBoxCause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFreeText)
                    .addComponent(jTextFieldFreeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTicketString)
                    .addComponent(jTextFieldTicketString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void jCheckBoxCombiCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCombiCallActionPerformed
		//scan and show selected items
		scanner();
		showTicketString();
	}//GEN-LAST:event_jCheckBoxCombiCallActionPerformed

	private void jCheckBoxProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProjectActionPerformed
		//scan and show selected items
		scanner();
		showTicketString();
	}//GEN-LAST:event_jCheckBoxProjectActionPerformed

	private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
		// This button serves as a return to the main screen
		MainApp.getInstance().switchPanel(new view.IntroScreen());
	}//GEN-LAST:event_jButtonReturnActionPerformed

	private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
		//Reset all the options to the default
		fillComboBox();
		jComboBoxPart.setSelectedIndex(0);
		jRadioButtonCRA.setSelected(true);
		jCheckBoxCombiCall.setSelected(false);
		jCheckBoxProject.setSelected(false);
		jCheckBoxReturnCall.setSelected(false);
		jTextFieldFreeText.setText(null);
		scanner();
		showTicketString();

	}//GEN-LAST:event_jButtonResetActionPerformed

	private void jCheckBoxReturnCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxReturnCallActionPerformed
		//scan and show selected items
		scanner();
		showTicketString();
	}//GEN-LAST:event_jCheckBoxReturnCallActionPerformed

	private void jRadioButtonPCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPCEActionPerformed
		//scan and show selected items
		scanner();
		showTicketString();

	}//GEN-LAST:event_jRadioButtonPCEActionPerformed

	private void jRadioButtonCRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCRAActionPerformed
		//scan and show selected items
		scanner();
		showTicketString();
	}//GEN-LAST:event_jRadioButtonCRAActionPerformed

	private void jTextFieldFreeTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFreeTextKeyReleased
		//scan and show selected items
		scanner();
		showTicketString();			
	}//GEN-LAST:event_jTextFieldFreeTextKeyReleased

	private void jButtonMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMailActionPerformed
	//Mail authProg = new Mail();
	Mail mail = new Mail();
		try {
			mail.sendMail();
		} catch (Exception ex) {
			Logger.getLogger(SelectionScreenCRA.class.getName()).log(Level.SEVERE, null, ex);
		}
	
	}//GEN-LAST:event_jButtonMailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMail;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JCheckBox jCheckBoxCombiCall;
    private javax.swing.JCheckBox jCheckBoxProject;
    private javax.swing.JCheckBox jCheckBoxReturnCall;
    private javax.swing.JComboBox jComboBoxCause;
    private javax.swing.JComboBox jComboBoxPart;
    private javax.swing.JLabel jLabelCause;
    private javax.swing.JLabel jLabelFreeText;
    private javax.swing.JLabel jLabelMachine;
    private javax.swing.JLabel jLabelPart;
    private javax.swing.JLabel jLabelSpecial;
    private javax.swing.JLabel jLabelTicketString;
    private javax.swing.JRadioButton jRadioButtonCRA;
    private javax.swing.JRadioButton jRadioButtonPCE;
    private javax.swing.JTextField jTextFieldFreeText;
    private javax.swing.JTextField jTextFieldTicketString;
    // End of variables declaration//GEN-END:variables
}
