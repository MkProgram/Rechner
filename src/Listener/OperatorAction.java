package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import gui.cFrame;
public class OperatorAction extends AbstractAction implements ActionListener {

	public AbstractAction keyListener;
	
	public OperatorAction()
	{
		keyListener = new AbstractAction()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OperatorAction.setInput(e);
			}
			
		};
	}
	private static void setInput(ActionEvent e)
	{
		String txt_out = cFrame.lb_output.getText();
		String sOperator = ( (JButton)e.getSource() ).getText();
		if(cFrame.sOperator.equals("") && !txt_out.equals(" "))
		{
			cFrame.sOperator = sOperator;
			txt_out += " " + sOperator + " ";
			cFrame.setText(txt_out);
			cFrame.calculated = false;
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setInput(e);
	}

}
