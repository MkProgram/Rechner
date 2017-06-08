package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

import gui.cFrame;


public class BackAction extends AbstractAction implements ActionListener
{
	public AbstractAction keyListener;
	
	public BackAction()
	{
		keyListener = new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BackAction.back(e);
			}
			
		};
	}
	private static void back(ActionEvent e)
	{
		String txt_out = cFrame.getText();
		char lastChar = ' ';
		if(!txt_out.equals(" ") )
		{
			try
			{				
				lastChar = txt_out.charAt(txt_out.length()-1);
				txt_out = txt_out.substring(0, txt_out.length()-1 );
			}
			catch (Exception ex)
			{}			
			if( !txt_out.equals("") )
			{
				String sOperators = "/*-+";
				if( sOperators.indexOf(lastChar) != -1 )
				{
					cFrame.sOperator = "";
				}
				cFrame.setText(txt_out);				
				
			}
			else cFrame.setText(" ");
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.back(e);
	}

}
