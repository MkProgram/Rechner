package Calc;

import java.sql.ResultSet;

import javax.swing.DefaultListModel;

import gui.cFrame;

public class History {
	
	DefaultListModel<String> model;
	DbHelper Db = new DbHelper();
	
	public History()
	{
		ResultSet res = Db.getHistory();
		this.model = (DefaultListModel<String>) cFrame.list.getModel();
		try
		{
			while(res.next())
			{
				String sHistory = res.getString("value1")+" "+res.getString("operator")+" "+res.getString("value2");
				model.addElement(sHistory);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void pushHistory(int val1, int val2, char operator)
	{
		String sHistory = String.valueOf(val1) + " "+String.valueOf(operator) + " " + String.valueOf(val2);
		model.addElement(sHistory);
		Db.pushDB(val1, val2, operator);
	}
}



