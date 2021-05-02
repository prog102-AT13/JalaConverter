/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Joel Rodrigo Rojas Roman
 */
package org.fundacion.jala.converter.view.compiler;

import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.util.ArrayList;

/**
 * This class creates a tree of files as a Jtree.
 */
public class FileTree extends JPanel {
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    private JTree tree;

    public FileTree(final String projectName) {
        root = new DefaultMutableTreeNode(projectName);
        treeModel = new DefaultTreeModel(root);
        createChild("Main.java");
        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    public FileTree(final String projectName, final String firstFile) {
        root = new DefaultMutableTreeNode(projectName);
        treeModel = new DefaultTreeModel(root);
        createChild(firstFile);
        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    /**
     * Accesses to child paths of a parent path.
     *
     * @param fileRoot represents the parent path.
     * @param node represents tree where the child routes are nested.
     */
    private void createChildren(final File fileRoot, final DefaultMutableTreeNode node) {
        File[] files = fileRoot.listFiles();
        if (files == null) return;

        for (File file : files) {
            DefaultMutableTreeNode childNode =
                    new DefaultMutableTreeNode(file.getName());
            node.add(childNode);
            if (file.isDirectory()) {
                createChildren(file, childNode);
            }
        }
    }

    /**
     * Adds a child path that represents new file of project.
     */
    public void createChild(final String nameFile) {
        root.add(new DefaultMutableTreeNode(nameFile));
    }

    /**
     * Adds a list of child paths that represents new file of project.
     */
    public void createChildrenList(final ArrayList<String> fileNames) {
        root.removeAllChildren();
        for (String fileName : fileNames) {
            root.add(new DefaultMutableTreeNode(fileName));
        }
    }

    public static DefaultTreeModel createFileTree(final String projectName, final String nameFile) {
        DefaultMutableTreeNode root1;
        DefaultTreeModel treeModel1;
        root1 = new DefaultMutableTreeNode(projectName);
        treeModel1 = new DefaultTreeModel(root1);
        root1.add(new DefaultMutableTreeNode(nameFile));
        return treeModel1;
    }

    /**
     * Adds a list of child paths that represents new file of project.
     */
    public static DefaultTreeModel updateFileTree(final String projectName, final ArrayList<String> fileNames) {
        DefaultMutableTreeNode root1;
        DefaultTreeModel treeModel1;
        root1 = new DefaultMutableTreeNode(projectName);
        treeModel1 = new DefaultTreeModel(root1);
        for (String fileName : fileNames) {
            root1.add(new DefaultMutableTreeNode(fileName));
        }
        return treeModel1;
    }
}

