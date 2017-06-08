package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;

import gui.cFrame;




public class InputAction extends AbstractAction {

	public AbstractAction keyListener;
	
	
	static int max = 25;
	public InputAction()
	{
		keyListener = new AbstractAction()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InputAction.setInput(e);
				((JButton)e.getSource()).requestFocusInWindow();
			}
			
		};
	}
	private static void setInput(ActionEvent e)
	{		
		String txt_out = cFrame.getText();
		if(txt_out.length() < InputAction.max)
		{
			String txt_in = ( (JButton)e.getSource() ).getText();
			if(txt_out != " " && !cFrame.calculated)
			{			
				txt_in = txt_out + txt_in;
			}
			cFrame.setText(txt_in);
			cFrame.calculated = false;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		this.setInput(e);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
