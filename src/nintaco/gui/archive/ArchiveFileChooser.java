package nintaco.gui.archive;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import nintaco.task.*;
import static java.lang.Math.*;
import static nintaco.util.GuiUtil.*;

public class ArchiveFileChooser extends javax.swing.JDialog {

  private final TaskScheduler scheduler = new TaskScheduler();  
  
  private List<String> entries;
  private String selectedFile;
  
  public ArchiveFileChooser(final Window parent, final List<String> entries,
      final int defaultEntry) {
    super(parent);
    setModal(true);
    initComponents();
    getRootPane().setDefaultButton(openButton);    
    scaleFonts(this);
    addTextFieldEditListener(searchTextField, this::searchTextEdited);     

    this.entries = entries;
    final DefaultListModel<EntryElement> model = new DefaultListModel<>();
    for(int i = 0; i < entries.size(); i++) {
      final String entry = entries.get(i);
      model.addElement(new EntryElement(entry, entry));
    }
    
    fileList.setModel(model);
    fileList.setVisibleRowCount(min(25, entries.size()));
    if (defaultEntry < 0) {
      optionsButton.setVisible(false);
    } else if (defaultEntry < entries.size()) {
      fileList.setSelectedIndex(defaultEntry);      
    }
    
    pack();
    setLocationRelativeTo(getParent());
  }
  
  public String getSelectedFile() {
    return selectedFile;
  }
  
  private void searchTextEdited() {
    scheduler.cancelAll();
    scheduler.add(new SearchTask(fileList, entries, searchTextField.getText()));
  }
  
  private void cancelButtonPressed() {
    closeDialog();
  }
  
  private void closeDialog() {
    scheduler.dispose();
    dispose();
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    scrollPane = new javax.swing.JScrollPane();
    fileList = new javax.swing.JList<>();
    cancelButton = new javax.swing.JButton();
    openButton = new javax.swing.JButton();
    searchTextField = new SearchTextField();
    optionsButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("Select file from archive");
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

    scrollPane.setMaximumSize(null);
    scrollPane.setMinimumSize(null);
    scrollPane.setPreferredSize(null);

    fileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    fileList.setMaximumSize(null);
    fileList.setMinimumSize(null);
    fileList.setPreferredSize(null);
    fileList.setVisibleRowCount(16);
    fileList.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        fileListMouseClicked(evt);
      }
    });
    fileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        fileListValueChanged(evt);
      }
    });
    scrollPane.setViewportView(fileList);

    cancelButton.setMnemonic('C');
    cancelButton.setFocusPainted(false);
    cancelButton.setLabel("   Cancel   ");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    openButton.setMnemonic('O');
    openButton.setText("Open");
    openButton.setEnabled(false);
    openButton.setFocusPainted(false);
    openButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        openButtonActionPerformed(evt);
      }
    });

    searchTextField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        searchTextFieldActionPerformed(evt);
      }
    });

    optionsButton.setText("Options...");
    optionsButton.setFocusPainted(false);
    optionsButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        optionsButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(optionsButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
            .addComponent(openButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cancelButton))
          .addComponent(searchTextField))
        .addContainerGap())
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, openButton});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cancelButton)
          .addComponent(openButton)
          .addComponent(optionsButton))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void fileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_fileListValueChanged
    openButton.setEnabled(fileList.getSelectedValue() != null);
  }//GEN-LAST:event_fileListValueChanged

  private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
    final EntryElement element = (EntryElement)fileList.getSelectedValue();
    if (element != null) {
      selectedFile = element.getEntry();
      closeDialog();
    }
  }//GEN-LAST:event_openButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    cancelButtonPressed();
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    cancelButtonPressed();
  }//GEN-LAST:event_formWindowClosing

  private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    if (fileList.getSelectedIndex() >= 0) {
      fileList.requestFocusInWindow();
      EventQueue.invokeLater(() -> scrollToCenter(fileList, 
          fileList.getSelectedIndex()));
    } else {
      requestFocusInWindow();
    }
  }//GEN-LAST:event_formComponentShown

  private void optionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsButtonActionPerformed
    new ArchiveOptionsDialog(this).setVisible(true);
  }//GEN-LAST:event_optionsButtonActionPerformed

  private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
    if (openButton.isEnabled()) {
      openButton.doClick();
    } else {
      requestFocusInWindow();
    }
  }//GEN-LAST:event_searchTextFieldActionPerformed

  private void fileListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileListMouseClicked
    if (evt.getClickCount() == 2) {
      final int index = fileList.locationToIndex(evt.getPoint());
      final ListModel<EntryElement> model = fileList.getModel();
      if (index >= 0 && index < fileList.getModel().getSize()) {
        final EntryElement element = model.getElementAt(index);
        if (element != null) {
          selectedFile = element.getEntry();
          closeDialog();
        }
      }
    }
  }//GEN-LAST:event_fileListMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JList<EntryElement> fileList;
  private javax.swing.JButton openButton;
  private javax.swing.JButton optionsButton;
  private javax.swing.JScrollPane scrollPane;
  private javax.swing.JTextField searchTextField;
  // End of variables declaration//GEN-END:variables
}