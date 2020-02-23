package com.cherrybox.gui.FList;

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

import java.util.*;
import java.util.List;
import java.io.*;

public class FList extends JList implements DropTargetListener {
	private static final long serialVersionUID = 2L;
	
	//model => title, list => file
	DefaultListModel model = new DefaultListModel();
	List<String> list = new ArrayList();
	DropTarget target;
	
	public FList() {
		super();
		setVisible(true);
		target = new DropTarget(this,DnDConstants.ACTION_COPY_OR_MOVE,
                (DropTargetListener) this,true,null);
		this.setFont(new Font("����������_ac", Font.PLAIN, 16));
		updateList("drive");
	}
	
	public File getFileAt(int index) {
		return new File(list.get(index));
	}
	
	public void addFile(File file) {
		list.add(file.getAbsolutePath());
		model.addElement(file.getName());
	}
	
	public void removeFileAt(int index) {
		model.removeElementAt(index);
		list.remove(index);
	}
	
	public void updateList(String source){
		list.clear();
		model.clear();
		File dir = new File(source);
		File[] filelist = dir.listFiles();
		if(filelist == null){
			System.out.println("error");
		}
		else {
			for (File file : filelist) {
				addFile(file);
			}
			//updateDir(source);
		}
		this.setModel(model);
	}
	
	public void updateDir(String source) {
		File dir = new File(source);
		File[] filelist = dir.listFiles();
		for(int i=0;i<filelist.length;i++) {
			File file = filelist[i];
			if(file.isFile()) {
				addFile(file);
			}
			else if(file.isDirectory()) {
				updateDir(file.getAbsolutePath());
			}
		}
		this.setModel(model);
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
		System.out.println("drop");
		
		if((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE)!=0){
            dtde.acceptDrop(dtde.getDropAction());
            Transferable tr = dtde.getTransferable();
            
            this.setSelectedIndex(-1);
            updateList("drive");
            
            try{
                //���޵Ǵ� ������ ����Ʈ���·� ��ȯ
                //���ϸ���Ʈ�� DataFlavor�� �̿��Ͽ� tr�� ����
            	List<File> newList =(List)tr.getTransferData(DataFlavor.javaFileListFlavor);
            	
            	for(int i = 0; i< newList.size();i++) {
            		addDragFile(newList.get(i), "drive");            		            		
                }
            	updateList("drive");
             
            }catch(Exception e){
                e.printStackTrace();
            }
        }
	}	
	
	private void copyFile(File file, String source) {
		File copyfile = new File(source + "\\" + file.getName());
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
	
	private void addDragFile(File file, String source) {
		if(file.isFile()) {
			boolean copytwice=false;
			for(int i = 0; i < list.size(); i++ ) {
    			if(list.get(i).equals(file.getAbsolutePath())) {
    				copytwice=true;
    			}	
    		}
    		if(!copytwice)copyFile(file,source);
		}
		else if(file.isDirectory()) {
			source = source + "//" +file.getName();
			File dir = new File(source);
			dir.mkdir();
			File[] filearr = file.listFiles();
			for(File f: filearr) {
				addDragFile(f, source);
			}
		}            		            		
    }	
	
	
}
