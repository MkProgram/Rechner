package Calc;
public class Calculation
{
	
	private int val1 = 0;
	private int val2 = 0;
	private double dou1 = 0.0;
	private double dou2 = 0.0;
	public char operator = ' ';
	private Calculation calc1;
	public String result = "";
	
	public Calculation(int val1, int val2, char operator)
	{
		this.val1 = val1;
		this.val2 = val2;
		this.operator = operator;
		
		switch(operator)
		{
		case '+':
			this.result = String.valueOf( add(val1, val2) );
		break;
		case '-':
			this.result = String.valueOf( sub(val1, val2) );
		break;
		case '*':
			this.result = String.valueOf( multi(val1, val2) );
		break;
		case '/':
			this.result = String.valueOf( div(val1, val2) );
		break;
		default:
		}
	}
	public Calculation(double val1, double val2, char operator)
	{
		this.dou1 = val1;
		this.dou2 = val2;
		this.operator = operator;
		
		switch(operator)
		{
		case '+':
			this.result = String.valueOf( add(val1, val2) );
		break;
		case '-':
			this.result = String.valueOf( sub(val1, val2) );
		break;
		case '*':
			this.result = String.valueOf( multi(val1, val2) );
		break;
		case '/':
			this.result = String.valueOf( div(val1, val2) );
		break;
		default:
		}
	}
	public Calculation(Calculation calc1, int val2, char operator)
	{
		
	}
	public Calculation(Calculation calc1 , double val2, char operator)
	{
		
	}
	
	//get- Method
	public char getOperator()
	{
		return this.operator;
	}
	public int getValue1()
	{
		return this.val1;
	}
	public int getValue2()
	{
		return this.val2;
	}
	public String getResult()
	{
		return this.result;
	}
	
	// Calculation Methods 
	//add
	private int add(int val1, int val2)
	{
		return val1 + val2;
	}
	private double add(double val1, double val2)
	{
		return val1 + val2;
	}
	//sub
	private int sub(int val1, int val2)
	{
		return val1 - val2;
	}
	private double sub(double val1, double val2)
	{
		return val1 - val2;
	}
	
	//multi
	private int multi(int val1, int val2)
	{
		return val1 * val2;
	}
	private double multi(double val1, double val2)
	{
		return val1 * val2;
	}
	//div
	
	private int div (int val1, int val2)
	{
		return val1 / val2;
	}
	private double div (double val1, double val2)
	{
		return val1 / val2;
	}
}