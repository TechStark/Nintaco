package nintaco.gui.debugger.breakpoint;

import java.awt.*;
import javax.swing.event.*;
import nintaco.*;
import static nintaco.util.GuiUtil.*;
import static nintaco.util.StringUtil.*;

public class CreateBreakpointDialog extends javax.swing.JDialog {

  private final DocumentListener bankListener 
      = createDocumentListener(this::bankEdited);
  private final DocumentListener startAddressListener 
      = createDocumentListener(this::startAddressEdited);
  private final DocumentListener endAddressListener 
      = createDocumentListener(this::endAddressEdited);
  
  private Breakpoint breakpoint = new Breakpoint();
  private boolean ok;
  
  public CreateBreakpointDialog(final Window parent) {
    super(parent);
    setModal(true);
    initComponents();
    initTextFields();
    scaleFonts(this);
    pack();
    setLocationRelativeTo(parent);
  }
  
  private void initTextFields() {
    addLoseFocusListener(this, bankTextField);
    addLoseFocusListener(this, startAddressTextField);
    addLoseFocusListener(this, endAddressTextField);
  }
  
  private void closeDialog() {
    dispose();
  }

  public boolean isOk() {
    return ok;
  }

  public Breakpoint getBreakpoint() {
    return breakpoint;
  }
  
  public void setBreakpoint(final Breakpoint breakpoint) {
    this.breakpoint = new Breakpoint(breakpoint);
  }
  
  private void bankEdited() {
    breakpoint.setBank(parseInt(bankTextField.getText(), true, 0xFF));
    updateButtons();
  }
  
  private void startAddressEdited() {
    breakpoint.setStartAddress(parseInt(startAddressTextField.getText(), true, 
        0xFFFF));
    updateButtons();
  }
  
  private void endAddressEdited() {
    breakpoint.setEndAddress(parseInt(endAddressTextField.getText(), true, 
        0xFFFF));
    updateButtons();
  }
  
  private void updateButtons() {
    okButton.setEnabled(breakpoint.getStartAddress() >= 0x0000 
        && breakpoint.getStartAddress() <= 0xFFFF
        && (!breakpoint.isRange() 
            || breakpoint.getStartAddress() <= breakpoint.getEndAddress()));
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    bankLabel = new javax.swing.JLabel();
    bankTextField = new javax.swing.JTextField();
    addressLabel = new javax.swing.JLabel();
    startAddressTextField = new javax.swing.JTextField();
    dashLabel = new javax.swing.JLabel();
    endAddressTextField = new javax.swing.JTextField();
    typeComboBox = new javax.swing.JComboBox();
    enabledCheckBox = new javax.swing.JCheckBox();
    cancelButton = new javax.swing.JButton();
    okButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setMaximumSize(null);
    setMinimumSize(null);
    setPreferredSize(null);
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    bankLabel.setText("Bank:");
    bankLabel.setMaximumSize(null);
    bankLabel.setMinimumSize(null);
    bankLabel.setPreferredSize(null);

    bankTextField.setColumns(4);
    bankTextField.setMaximumSize(null);
    bankTextField.setMinimumSize(null);
    bankTextField.setPreferredSize(null);

    addressLabel.setText("Address:");
    addressLabel.setToolTipText("");
    addressLabel.setMaximumSize(null);
    addressLabel.setMinimumSize(null);
    addressLabel.setPreferredSize(null);

    startAddressTextField.setColumns(6);
    startAddressTextField.setText("$0000");
    startAddressTextField.setMaximumSize(null);
    startAddressTextField.setMinimumSize(null);
    startAddressTextField.setPreferredSize(null);

    dashLabel.setText("<html>&mdash;</html>");
    dashLabel.setMaximumSize(null);
    dashLabel.setMinimumSize(null);
    dashLabel.setPreferredSize(null);

    endAddressTextField.setColumns(6);
    endAddressTextField.setMaximumSize(null);
    endAddressTextField.setMinimumSize(null);
    endAddressTextField.setPreferredSize(null);

    typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Execute", "Read", "Write", "Access" }));
    typeComboBox.setMaximumSize(null);
    typeComboBox.setMinimumSize(null);
    typeComboBox.setPreferredSize(null);

    enabledCheckBox.setSelected(true);
    enabledCheckBox.setText("Enabled");
    enabledCheckBox.setMaximumSize(null);
    enabledCheckBox.setMinimumSize(null);
    enabledCheckBox.setPreferredSize(null);

    cancelButton.setMnemonic('C');
    cancelButton.setText("  Cancel  ");
    cancelButton.setMaximumSize(null);
    cancelButton.setMinimumSize(null);
    cancelButton.setPreferredSize(null);
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    okButton.setMnemonic('O');
    okButton.setText("OK");
    okButton.setMaximumSize(null);
    okButton.setMinimumSize(null);
    okButton.setPreferredSize(null);
    okButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(bankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(startAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(dashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(endAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(enabledCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(18, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bankTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(startAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(dashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(endAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(enabledCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    closeDialog();
  }//GEN-LAST:event_formWindowClosing

  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    final int type = typeComboBox.getSelectedIndex();
    if (breakpoint.getStartAddress() >= 0x0000 
        && breakpoint.getStartAddress() <= 0xFFFF && type >= 0) {
      ok = true;
      breakpoint.setType(type);
      breakpoint.setEnabled(enabledCheckBox.isSelected());      
    }
    closeDialog();
  }//GEN-LAST:event_okButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    closeDialog();
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    if (breakpoint != null) {
      if (breakpoint.getType() >= 0 && breakpoint.getType() < 4) {
        typeComboBox.setSelectedIndex(breakpoint.getType());
      } else {
        typeComboBox.setSelectedIndex(0);
      }
      if (breakpoint.getBank() >= 0 && breakpoint.getBank() <= 0xFF) {
        bankTextField.setText(String.format("$%02X", breakpoint.getBank()));
      } else {
        bankTextField.setText("");
      }
      if (breakpoint.getStartAddress() >= 0 
          && breakpoint.getStartAddress() <= 0xFFFF) {
        startAddressTextField.setText(String.format("$%04X", 
            breakpoint.getStartAddress()));
      } else {
        startAddressTextField.setText("");
      }
      if (breakpoint.getEndAddress() >= 0 
          && breakpoint.getEndAddress() <= 0xFFFF) {
        endAddressTextField.setText(String.format("$%04X", 
            breakpoint.getEndAddress()));
      } else {
        endAddressTextField.setText("");
      }
      enabledCheckBox.setSelected(breakpoint.isEnabled());      
    }
    
    updateButtons();
    
    startAddressTextField.selectAll();
    startAddressTextField.requestFocus();
    
    bankTextField.getDocument().addDocumentListener(bankListener);
    endAddressTextField.getDocument().addDocumentListener(endAddressListener);
    startAddressTextField.getDocument().addDocumentListener(
        startAddressListener);
  }//GEN-LAST:event_formComponentShown

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel addressLabel;
  private javax.swing.JLabel bankLabel;
  private javax.swing.JTextField bankTextField;
  private javax.swing.JButton cancelButton;
  private javax.swing.JLabel dashLabel;
  private javax.swing.JCheckBox enabledCheckBox;
  private javax.swing.JTextField endAddressTextField;
  private javax.swing.JButton okButton;
  private javax.swing.JTextField startAddressTextField;
  private javax.swing.JComboBox typeComboBox;
  // End of variables declaration//GEN-END:variables

}