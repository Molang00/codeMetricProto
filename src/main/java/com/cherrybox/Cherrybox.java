package com.cherrybox;

import com.cherrybox.gui.MainGui;
import com.cherrybox.calculator.CodeMetric;
import java.awt.EventQueue;
import java.io.IOException;

public class Cherrybox {
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		CodeMetric.calculateCodeMetric();
	}
}