package dk.icourts.filterfromfile;

import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.openide.util.*;

/**
 * Panel for the {@link FilterFromFile} filter
 *
 * @author Yannis Panagis
 */
public class FilterFrmFilePanel extends javax.swing.JPanel {

    private final FilterFromFile filter;
    private final Logger logger = Logger.getLogger(FilterFrmFilePanel.class.getName());

    /**
     * Creates new form FilterFrmFilePanel
     */
    public FilterFrmFilePanel(FilterFromFile filter) {
        this.filter = filter;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileTextField = new javax.swing.JTextField();
        openButton = new javax.swing.JButton();
        neighbors = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        fileTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fileTextField.setText(org.openide.util.NbBundle.getMessage(FilterFrmFilePanel.class, "FilterFrmFilePanel.fileField.text")); // NOI18N
        fileTextField.setMaximumSize(new java.awt.Dimension(30, 50));
        fileTextField.setMinimumSize(new java.awt.Dimension(30, 50));
        fileTextField.setName("fileField"); // NOI18N
        fileTextField.setPreferredSize(new java.awt.Dimension(160, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(fileTextField, gridBagConstraints);

        openButton.setText(org.openide.util.NbBundle.getMessage(FilterFrmFilePanel.class, "FilterFrmFilePanel.openButton.text")); // NOI18N
        openButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(openButton, gridBagConstraints);

        neighbors.setToolTipText(org.openide.util.NbBundle.getMessage(FilterFrmFilePanel.class, "FilterFrmFilePanel.neighbors.toolTipText")); // NOI18N
        neighbors.setLabel(org.openide.util.NbBundle.getMessage(FilterFrmFilePanel.class, "FilterFrmFilePanel.label")); // NOI18N
        neighbors.setName(""); // NOI18N
        neighbors.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                neighborsItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(neighbors, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openButtonMouseClicked
        logger.info("Tyring to open file chooser");
        JFileChooser chooser = new JFileChooser();
        FileFilter ff = new FileNameExtensionFilter("Text files", "txt");
        chooser.addChoosableFileFilter(ff);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            try {
                this.fileTextField.setText(file.getCanonicalPath());
                Set<String> nodesToKeep = this.readLines(file);
                filter.setNodesToKeep(nodesToKeep);
            } catch (FileNotFoundException ex) {
                logger.severe(String.format("File %s not found", file));
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        } else {
            logger.info("Open command cancelled by user.");
        }
    }//GEN-LAST:event_openButtonMouseClicked

    private void neighborsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_neighborsItemStateChanged
        this.filter.setNeighbors(evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_neighborsItemStateChanged

    private Set<String> readLines(File txtFile) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new FileReader(txtFile));
        String line;
        Set<String> lines = new HashSet<String>();
        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "I/O exception in file: {0}", txtFile);
            Exceptions.printStackTrace(ex);
        }
        return lines;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileTextField;
    private javax.swing.JCheckBox neighbors;
    private javax.swing.JButton openButton;
    // End of variables declaration//GEN-END:variables
}
