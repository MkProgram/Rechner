package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.cFrame;


public class ClearAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		cFrame.setText(" ");
	}

}
