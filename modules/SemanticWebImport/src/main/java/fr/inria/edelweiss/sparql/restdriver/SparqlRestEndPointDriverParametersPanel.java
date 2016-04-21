package fr.inria.edelweiss.sparql.restdriver;

import fr.inria.edelweiss.sparql.DriverParametersPanel;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;

/*
 * SparqlRestEndPointDriverParametersPanel.java
 *
 * Created on Jul 19, 2011, 3:51:43 PM
 */
/**
 *
 * @author edemairy
 */
public class SparqlRestEndPointDriverParametersPanel
        extends DriverParametersPanel<SparqlRestEndPointDriverParameters> {

    private DefaultTableModel restParametersModel;
    private DefaultTableModel restPropertiesModel;

    public SparqlRestEndPointDriverParametersPanel(final SparqlRestEndPointDriverParameters parameters) {
        super();
        initComponents();

        setParameters(parameters);
        reset();

        restParametersModel = new DefaultTableModel();
        restParametersTable.setModel(restParametersModel);
        fillParameters();
        restParametersTable.invalidate();

        restPropertiesModel = new DefaultTableModel() {
            @Override
            public int getRowCount() {
                return parameters.getRequestProperties().size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return parameters.getRequestProperties().keySet().toArray()[rowIndex];
                    case 1:
                        return parameters.getRequestProperties().values().toArray()[rowIndex];
                }
                return null;
            }

            @Override
            public void addRow(Object[] rowData) {
                parameters.getRequestProperties().put((String) rowData[0], (String) rowData[1]);
            }
        };
        restPropertiesTable.setModel(restPropertiesModel);
        fillProperties();
        restPropertiesTable.invalidate();
    }

    private void fillParameters() {
        restParametersModel.addColumn("REST parameter name");
        restParametersModel.addColumn("Value");
        for (String parameterName : getParameters().getRequestParameters().keySet()) {
            String[] datas = new String[2];
            datas[0] = parameterName;
            datas[1] = getParameters().getRequestParameters().get(parameterName);
            restParametersModel.addRow(datas);
        }
    }

    private void fillProperties() {
        restPropertiesModel.addColumn("Properties parameter name");
        restPropertiesModel.addColumn("Value");
        for (String propertyName : getParameters().getRequestProperties().keySet()) {
            String[] datas = new String[2];
            datas[0] = propertyName;
            datas[1] = getParameters().getRequestProperties().get(propertyName);
            restPropertiesModel.addRow(datas);
        }
    }

    public String getUrl() {
        return urlTextField.getText();
    }

    public final void setUrl(String newUrl) {
        urlTextField.setText(newUrl);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        urlTextField = new javax.swing.JTextField();
        urlLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        restParametersTable = new javax.swing.JTable();
        addTagButton = new javax.swing.JButton();
        newParameterRestName = new javax.swing.JTextField();
        newParameterRestValue = new javax.swing.JTextField();
        removeTagButton = new javax.swing.JButton();
        queryTagName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        restPropertiesTable = new javax.swing.JTable();
        newPropertyName = new javax.swing.JTextField();
        newPropertyValue = new javax.swing.JTextField();
        addPropertyButton = new javax.swing.JButton();
        removePropertyButton = new javax.swing.JButton();

        urlTextField.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.urlTextField.text")); // NOI18N
        urlTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlTextFieldActionPerformed(evt);
            }
        });
        urlTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                urlTextFieldKeyTyped(evt);
            }
        });

        urlLabel1.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.urlLabel1.text")); // NOI18N

        restParametersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nurll", "nullr"
            }
        ));
        restParametersTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        restParametersTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(restParametersTable);
        restParametersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        restParametersTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.restParametersTable.columnModel.title0")); // NOI18N
        restParametersTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.restParametersTable.columnModel.title1")); // NOI18N

        addTagButton.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.addTagButton.text")); // NOI18N
        addTagButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTagButtonMouseClicked(evt);
            }
        });
        addTagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTagButtonActionPerformed(evt);
            }
        });

        newParameterRestName.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.newParameterRestName.text")); // NOI18N

        newParameterRestValue.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.newParameterRestValue.text")); // NOI18N

        removeTagButton.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.removeTagButton.text")); // NOI18N
        removeTagButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeTagButtonMouseClicked(evt);
            }
        });

        queryTagName.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.queryTagName.text")); // NOI18N
        queryTagName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryTagNameActionPerformed(evt);
            }
        });
        queryTagName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                queryTagNameKeyTyped(evt);
            }
        });

        jLabel1.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.jLabel1.text")); // NOI18N

        restPropertiesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nullr", "nullr"
            }
        ));
        restPropertiesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        restPropertiesTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(restPropertiesTable);
        restPropertiesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        restPropertiesTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointParametersPanel.restParametersTable.columnModel.title0")); // NOI18N
        restPropertiesTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointParametersPanel.restParametersTable.columnModel.title1")); // NOI18N

        newPropertyName.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.newPropertyName.text")); // NOI18N

        newPropertyValue.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.newPropertyValue.text")); // NOI18N
        newPropertyValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPropertyValueActionPerformed(evt);
            }
        });

        addPropertyButton.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.addPropertyButton.text")); // NOI18N
        addPropertyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPropertyButtonMouseClicked(evt);
            }
        });
        addPropertyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPropertyButtonActionPerformed(evt);
            }
        });

        removePropertyButton.setText(org.openide.util.NbBundle.getMessage(SparqlRestEndPointDriverParametersPanel.class, "SparqlRestEndPointDriverParametersPanel.removePropertyButton.text")); // NOI18N
        removePropertyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removePropertyButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urlLabel1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(urlTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(queryTagName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(newPropertyName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newPropertyValue)
                        .addGap(18, 18, 18)
                        .addComponent(addPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removePropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(newParameterRestName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newParameterRestValue)
                        .addGap(18, 18, 18)
                        .addComponent(addTagButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeTagButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLabel1)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryTagName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addPropertyButton)
                        .addComponent(removePropertyButton))
                    .addComponent(newPropertyName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPropertyValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newParameterRestName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newParameterRestValue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTagButton)
                    .addComponent(removeTagButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addTagButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTagButtonMouseClicked
        String[] rowData = new String[3];
        rowData[0] = newParameterRestName.getText();
        rowData[1] = newParameterRestValue.getText();
        restParametersModel.addRow(rowData);
        restParametersTable.invalidate();
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_addTagButtonMouseClicked

    private void addTagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTagButtonActionPerformed
    }//GEN-LAST:event_addTagButtonActionPerformed

    private void removeTagButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeTagButtonMouseClicked
        for (int i : restParametersTable.getSelectedRows()) {
            restParametersModel.removeRow(i);
        }
    }//GEN-LAST:event_removeTagButtonMouseClicked

    private void addPropertyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPropertyButtonMouseClicked
        String[] rowData = new String[3];
        rowData[0] = newPropertyName.getText();
        rowData[1] = newPropertyValue.getText();
        restPropertiesModel.addRow(rowData);
        restPropertiesTable.invalidate();
        this.invalidate();
        this.validate();
    }//GEN-LAST:event_addPropertyButtonMouseClicked

    private void addPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPropertyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPropertyButtonActionPerformed

    private void removePropertyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removePropertyButtonMouseClicked
        for (int i : restPropertiesTable.getSelectedRows()) {
            restPropertiesModel.removeRow(i);
        }
    }//GEN-LAST:event_removePropertyButtonMouseClicked

    private void newPropertyValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPropertyValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPropertyValueActionPerformed

    private void urlTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlTextFieldActionPerformed
        getParameters().setEndPointUrl(urlTextField.getText());
    }//GEN-LAST:event_urlTextFieldActionPerformed

    private void queryTagNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryTagNameActionPerformed
        getParameters().setQueryTagName(queryTagName.getText());
    }//GEN-LAST:event_queryTagNameActionPerformed

    private void queryTagNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_queryTagNameKeyTyped
        getParameters().setQueryTagName(queryTagName.getText());
    }//GEN-LAST:event_queryTagNameKeyTyped

    private void urlTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlTextFieldKeyTyped
        getParameters().setEndPointUrl(urlTextField.getText());
    }//GEN-LAST:event_urlTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPropertyButton;
    private javax.swing.JButton addTagButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField newParameterRestName;
    private javax.swing.JTextField newParameterRestValue;
    private javax.swing.JTextField newPropertyName;
    private javax.swing.JTextField newPropertyValue;
    private javax.swing.JTextField queryTagName;
    private javax.swing.JButton removePropertyButton;
    private javax.swing.JButton removeTagButton;
    private javax.swing.JTable restParametersTable;
    private javax.swing.JTable restPropertiesTable;
    private javax.swing.JLabel urlLabel1;
    private javax.swing.JTextField urlTextField;
    // End of variables declaration//GEN-END:variables

    void fillMap(Map<String, String> map) {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(restParametersModel.getDataVector());
        map.clear();
        for (int row = 0; row < data.size(); ++row) {
            ArrayList<String> currentRow = data.get(row);
            map.put(currentRow.get(0), currentRow.get(1));
        }
    }

    String getQueryTagName() {
        return queryTagName.getText();
    }

    void setQueryTagName(final String newTagName) {
        queryTagName.setText(newTagName);
    }

    final void reset() {
        setUrl(getParameters().getEndPointUrl());
        setQueryTagName(getParameters().getQueryTagName());
    }

    @Override
    public void update(Observable o, Object arg) {
        reset();
    }
}