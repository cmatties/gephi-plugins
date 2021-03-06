package com.polinode.polinodeexporter;

import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;


/**
 *
 * @author stephenrogers
 */
public class PolinodeExporterSettingsPanel extends javax.swing.JPanel {

    private ActionListener actionListener;
    private String realPrivateKey;

    final public static String BUTTON_DETAILEDINSTRUCTIONS = "Detailed Instructions";
    final public static String BUTTON_CREATEPOLINODEACCOUNT  = "Create Polinode Account";
    final public static String BUTTON_CANCEL = "Cancel";
    final public static String BUTTON_OK = "OK";

    /**
     * Creates new form PolinodeExporterSettingsPanel
     */
    public PolinodeExporterSettingsPanel(ActionListener actionListener) {
        initComponents();
        this.actionListener = actionListener;
    }

    public void setup() {
        
        Preferences prefs = NbPreferences.forModule(PolinodeExporterSettingsPanel.class);
        polinodePublicKey.setText(prefs.get("polinodePublicKey", ""));
        realPrivateKey = prefs.get("polinodePrivateKey", "");
        if( realPrivateKey.length()==0 )
            polinodePrivateKey.setText("");
        else
            polinodePrivateKey.setText("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXX"+realPrivateKey.substring(realPrivateKey.length()-4, realPrivateKey.length()));
    }

    public void unsetup(boolean update) {
        Preferences props = NbPreferences.forModule(PolinodeExporterSettingsPanel.class);
        if (update) {
            try {
                props.put("polinodePublicKey", this.getPolinodePublicKey());
                props.put("polinodePrivateKey", this.getPolinodePrivateKey());
                props.put("isNetworkPublic", jradioPublic.isSelected() ? "Yes" : "No");
            } catch (Exception e) {
                Logger.getLogger(PolinodeExporter.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public String getNetworkName() {
        return networkName.getText();
    }
            
    public String getNetworkDescription() {
        return networkDescription.getText();
    }
            
    public String getPolinodePublicKey() {
        return polinodePublicKey.getText();
    }

    public String getPolinodePrivateKey() {
        if( polinodePrivateKey.getText().length()>=8 && !polinodePrivateKey.getText().substring(0, 8).equals("XXXXXXXX") ) {
            return polinodePrivateKey.getText();
        }
        else {
            return realPrivateKey;
        }
    }

    public boolean getIsNetworkPublic()
    {
        return jradioPublic.isSelected();
    }

    public boolean getPublicPrivateSelected()
    {
        return jradioPublic.isSelected() || jradioPrivate.isSelected();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupPublicPrivate = new javax.swing.ButtonGroup();
        jpanelMain = new javax.swing.JPanel();
        jlabelExportToPolinode = new javax.swing.JLabel();
        jlabelNetworkName = new javax.swing.JLabel();
        networkName = new javax.swing.JTextField();
        jlabelDescription = new javax.swing.JLabel();
        jscrollDescription = new javax.swing.JScrollPane();
        networkDescription = new javax.swing.JTextArea();
        jlabelVisibility = new javax.swing.JLabel();
        jradioPublic = new javax.swing.JRadioButton();
        jradioPrivate = new javax.swing.JRadioButton();
        jlabelPolinodeAPIKeys = new javax.swing.JLabel();
        jlabelPublicKey = new javax.swing.JLabel();
        polinodePublicKey = new javax.swing.JTextField();
        jlabelPrivateKey = new javax.swing.JLabel();
        polinodePrivateKey = new javax.swing.JTextField();

        jlabelExportToPolinode.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlabelExportToPolinode, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jlabelExportToPolinode.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jlabelNetworkName, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jlabelNetworkName.text")); // NOI18N

        networkName.setText(org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.networkName.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jlabelDescription, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jlabelDescription.text")); // NOI18N

        networkDescription.setColumns(20);
        networkDescription.setRows(5);
        jscrollDescription.setViewportView(networkDescription);

        org.openide.awt.Mnemonics.setLocalizedText(jlabelVisibility, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jlabelVisibility.text")); // NOI18N

        groupPublicPrivate.add(jradioPublic);
        org.openide.awt.Mnemonics.setLocalizedText(jradioPublic, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jradioPublic.text")); // NOI18N

        groupPublicPrivate.add(jradioPrivate);
        org.openide.awt.Mnemonics.setLocalizedText(jradioPrivate, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jradioPrivate.text")); // NOI18N

        jlabelPolinodeAPIKeys.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jlabelPolinodeAPIKeys, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jlabelPolinodeAPIKeys.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jlabelPublicKey, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jlabelPublicKey.text")); // NOI18N

        polinodePublicKey.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        polinodePublicKey.setText(org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.polinodePublicKey.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jlabelPrivateKey, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jlabelPrivateKey.text")); // NOI18N

        polinodePrivateKey.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        polinodePrivateKey.setText(org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.polinodePrivateKey.text")); // NOI18N

        javax.swing.GroupLayout jpanelMainLayout = new javax.swing.GroupLayout(jpanelMain);
        jpanelMain.setLayout(jpanelMainLayout);
        jpanelMainLayout.setHorizontalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabelPublicKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabelPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(polinodePublicKey)
                            .addComponent(polinodePrivateKey)))
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlabelNetworkName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabelVisibility, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jradioPrivate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jradioPublic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(networkName)
                            .addComponent(jscrollDescription)))
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabelExportToPolinode)
                            .addComponent(jlabelPolinodeAPIKeys))
                        .addGap(407, 407, 407)))
                .addContainerGap())
        );
        jpanelMainLayout.setVerticalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelExportToPolinode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelNetworkName)
                    .addComponent(networkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addComponent(jlabelDescription)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addComponent(jscrollDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jradioPublic)
                            .addComponent(jlabelVisibility))
                        .addGap(3, 3, 3)
                        .addComponent(jradioPrivate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelPolinodeAPIKeys)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelPublicKey)
                    .addComponent(polinodePublicKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelPrivateKey)
                    .addComponent(polinodePrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupPublicPrivate;
    private javax.swing.JLabel jlabelDescription;
    private javax.swing.JLabel jlabelExportToPolinode;
    private javax.swing.JLabel jlabelNetworkName;
    private javax.swing.JLabel jlabelPolinodeAPIKeys;
    private javax.swing.JLabel jlabelPrivateKey;
    private javax.swing.JLabel jlabelPublicKey;
    private javax.swing.JLabel jlabelVisibility;
    private javax.swing.JPanel jpanelMain;
    private javax.swing.JRadioButton jradioPrivate;
    private javax.swing.JRadioButton jradioPublic;
    private javax.swing.JScrollPane jscrollDescription;
    private javax.swing.JTextArea networkDescription;
    private javax.swing.JTextField networkName;
    private javax.swing.JTextField polinodePrivateKey;
    private javax.swing.JTextField polinodePublicKey;
    // End of variables declaration//GEN-END:variables
}
