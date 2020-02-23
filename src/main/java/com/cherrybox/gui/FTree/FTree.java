package com.cherrybox.gui.FTree;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import java.util.List;
import java.io.*;

public class FTree extends JTree implements DropTargetListener {
	private static final long serialVersionUID = 2L;
	
	//model => title, list => file
	DefaultMutableTreeNode root;
	DefaultTreeModel model;
	DropTarget target;
	
	public FTree() {
		super();
		setVisible(true);
		target = new DropTarget(this,DnDConstants.ACTION_COPY_OR_MOVE,
                (DropTargetListener) this,true,null);
		this.setFont(new Font("����������_ac", Font.PLAIN, 16));
		root = new DefaultMutableTreeNode("Select Project");
		root.removeAllChildren();
		model = new DefaultTreeModel(root);
		this.setModel(model);
	}
	
	public void resetTree() {
		
		root.removeAllChildren();
		root = new DefaultMutableTreeNode("Select Project");
		model.setRoot(root);
		this.setModel(model);
	}
	
	public File getFileSelected() {
		return new File(getPathSelceted());
	}
	
	public String getPathSelceted() {
		TreePath tpath = this.getSelectionPath();		
		return getTreePath(tpath);
	}
	
	public String getTreePath(TreePath tpath) {
		String path = "drive";
		for(int i=0; i<tpath.getPath().length;i++)
			path = path + "\\" + tpath.getPath()[i].toString();
		return path;
	}
	
	/*
	public void addFile(File file) {
		list.add(file.getAbsolutePath());
		model.addElement(file.getName());
	}
	
	public void removeFileAt(int index) {
		model.removeElementAt(index);
		list.remove(index);
	}
	*/
	public void updateTree(String source){
		File file = new File(source);
		
		root.removeAllChildren();
		root = new DefaultMutableTreeNode(file.getName());
		if(file.isDirectory()) {
			File[] filelist = file.listFiles();
			for(File f : filelist)
				updateTreeNode(f, root);
		}
		model.setRoot(root);
		this.setModel(model);
		
	}
	
	public void updateTreeNode(File file, DefaultMutableTreeNode roots) {
		DefaultMutableTreeNode temproot = new DefaultMutableTreeNode(file.getName());
		
		if(file.isDirectory()) {
			File[] filelist = file.listFiles();
			for(File f : filelist)
				updateTreeNode(f,temproot);
		}
		roots.add(temproot);
	}
	
	private void copyFile(File file,String source) {
		File copyfile = new File(source +"\\"+file.getName());
		try {
			FileInputStream fin = new FileInputStream(file);
			FileOutputStream fout = new FileOutputStream(copyfile);
			
			int filebyte = 0;
			while((filebyte = fin.read())!= -1) {
				fout.write(filebyte);
			}
			fin.close();
			fout.close();
		}
		catch(IOException e){
			
		}
	}
	
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		System.out.println("dragEnter");
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		System.out.println("dragOver");
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		System.out.println("dropActionChanged");
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub
		 System.out.println("dragOver");
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		// TODO Auto-generated method stub
		if((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE)!=0) {
			dtde.acceptDrop(dtde.getDropAction());
            Transferable tr = dtde.getTransferable();			
			//file�� drop�� ��ġ�� �߰��� ��ġ
			Point loc = dtde.getLocation();
			TreePath destinationPath = getPathForLocation(loc.x,loc.y);
			String path="";
			if((new File(this.getTreePath(destinationPath))).isFile()) {
				TreePath parPath = destinationPath.getParentPath();
				path = this.getTreePath(parPath);
			}
			else if((new File(this.getTreePath(destinationPath))).isDirectory()){
				path = this.getTreePath(destinationPath);
			}
			try {
				List<File> newList =(List)tr.getTransferData(DataFlavor.javaFileListFlavor);
				for(File f : newList){
					addDragFile(f, path);
				}
				this.updateTree("drive\\" + root.toString());
			}
			catch(Exception e) {}
		
		}
	}	
	
	private void addDragFile(File file, String source) {
		if(file.isFile()) {
			copyFile(file,source);
		}
		else if(file.isDirectory()) {
			File[] filearr = file.listFiles();
			for(File f: filearr) {
				addDragFile(f, source+"\\"+ file.getName());
			}
		}            		            		
    }
	
	
}
