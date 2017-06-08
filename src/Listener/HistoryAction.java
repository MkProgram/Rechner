package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.cFrame;

public class HistoryAction  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cFrame.list.setVisible(!cFrame.list.isVisible() );
	}

}
