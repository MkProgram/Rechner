package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import gui.cFrame;
import Calc.Calculation;

public class EqualsAction extends AbstractAction implements ActionListener{

	public AbstractAction keyListener;
	
	public EqualsAction()
	{
		keyListener = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EqualsAction.equals(e);
			}
			
		};
	}
	private static void equals(ActionEvent e)
	{
		if(!cFrame.sOperator.equals("") )
		{
			String txt_out = cFrame.getText();
			
			char cOperator = cFrame.sOperator.charAt(0);
			int value1 = 0;
			int value2 = 0;
			String[] arrValues = txt_out.split( Pattern.quote(String.valueOf(cOperator)) );		
			try
			{
				value1 = Integer.parseInt(arrValues[0].trim() );
				value2 = Integer.parseInt(arrValues[1].trim() );
			}
			catch (Exception ex)
			{}
			cFrame.calc = new Calculation(value1, value2, cOperator);
			if(cFrame.calc.result != "0")
			{
				cFrame.setText(cFrame.calc.result);
				cFrame.calculated = true;
				cFrame.sOperator = "";
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EqualsAction.equals(e);
	}
	

}
