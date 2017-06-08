package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import Listener.*;
import Calc.*;

import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;


public class cFrame extends JFrame {

	private JPanel contentPane;
	public static JLabel lb_output = new JLabel(" ");
	public static JList<String> list = new JList<String>(new DefaultListModel<String>());
	public static String sOperator = "";
	public static boolean calculated = false;
	public static Calculation calc;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cFrame frame = new cFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cFrame() {
		
		setSize(new Dimension(420, 500));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 503);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(420, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(0, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
				
		lb_output.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lb_output);
		
		JButton btn_history = new JButton("");
		btn_history.setPreferredSize(new Dimension(55, 55));
		panel.add(btn_history, BorderLayout.EAST);
		list.setVisible(false);
		list.setVisibleRowCount(5);
		list.setPreferredSize(new Dimension(0, 90));
		list.setVisible(false);
		panel.add(list, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		//Action Listener
		InputAction ActionInput = new InputAction();
		BackAction ActionBack = new BackAction();
		ClearAction ActionClear = new ClearAction();
		OperatorAction ActionOperator = new OperatorAction();
		EqualsAction ActionEquals = new EqualsAction();
		HistoryAction ActionHistory = new HistoryAction();				
		
		
		
		JButton btn_Ce = new JButton("CE");
		btn_Ce.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_Ce);
		
		JButton btn_C = new JButton("C");
		btn_C.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_C);
		
		JButton btn_back = new JButton("<-");
		btn_back.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_back);
		
		JButton btn_divide = new JButton("/");
		btn_divide.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_divide);
		
		JButton btn_seven = new JButton("7");
		btn_seven.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_seven);
		
		JButton btn_eight = new JButton("8");
		btn_eight.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_eight);
		
		JButton btn_nine = new JButton("9");
		btn_nine.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_nine);
		
		JButton btn_multi = new JButton("x");
		btn_multi.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_multi);
		
		JButton btn_four = new JButton("4");
		btn_four.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_four);
		
		JButton btn_five = new JButton("5");
		btn_five.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_five);
		
		JButton btn_six = new JButton("6");
		btn_six.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_six);
		
		JButton btn_minus = new JButton("-");
		btn_minus.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_minus);
		
		JButton btn_one = new JButton("1");
		btn_one.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_one);
		
		JButton btn_two = new JButton("2");
		btn_two.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_two);
		
		JButton btn_three = new JButton("3");
		btn_three.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_three);
		
		JButton btn_plus = new JButton("+");
		btn_plus.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_plus);
		
		JButton btn_negativ = new JButton("+/-");
		btn_negativ.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_negativ);
		
		JButton btn_zero = new JButton("0");
		btn_zero.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_zero);
		
		JButton btn_comma = new JButton(",");
		btn_comma.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_comma);
		
		JButton btn_equals = new JButton("=");
		btn_equals.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btn_equals);
		
		//Start of addActionListeners
		//{
		btn_back.addActionListener(ActionBack);
		
		btn_history.addActionListener(ActionHistory);
		
		btn_Ce.addActionListener(ActionClear);
		btn_C.addActionListener(ActionClear);
		
		btn_plus.addActionListener(ActionOperator);
		btn_minus.addActionListener(ActionOperator);
		btn_divide.addActionListener(ActionOperator);
		btn_multi.addActionListener(ActionOperator);
		
		btn_equals.addActionListener(ActionEquals);
				
		btn_one.addActionListener(ActionInput);
		btn_two.addActionListener(ActionInput);
		btn_three.addActionListener(ActionInput);
		btn_four.addActionListener(ActionInput);
		btn_five.addActionListener(ActionInput);
		btn_six.addActionListener(ActionInput);
		btn_seven.addActionListener(ActionInput);
		btn_eight.addActionListener(ActionInput);
		btn_nine.addActionListener(ActionInput);
		btn_zero.addActionListener(ActionInput);			
		//}
		//End of addActionListeners
		
		//InputMapping
		//{
		btn_zero.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), "pressed");
		btn_zero.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "pressed");
		btn_zero.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "pressed");
		btn_one.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "pressed");
		btn_one.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_two.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "pressed");
		btn_two.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "pressed");
		btn_two.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_three.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "pressed");
		btn_three.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "pressed");
		btn_three.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_four.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), "pressed");
		btn_four.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0), "pressed");
		btn_four.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_five.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0), "pressed");
		btn_five.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0), "pressed");
		btn_five.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_six.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), "pressed");
		btn_six.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "pressed");
		btn_six.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_seven.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0), "pressed");
		btn_seven.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "pressed");
		btn_seven.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_eight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0), "pressed");
		btn_eight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "pressed");
		btn_eight.getActionMap().put("pressed", ActionInput.keyListener );
		
		btn_nine.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0), "pressed");
		btn_nine.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "pressed");
		btn_nine.getActionMap().put("pressed", ActionInput.keyListener );
		
		
		
		btn_back.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "pressed");
		btn_back.getActionMap().put("pressed", ActionBack.keyListener );
		
		btn_plus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "pressed");
		btn_plus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "pressed");
		btn_plus.getActionMap().put("pressed", ActionOperator.keyListener );
		
		btn_minus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "pressed");
		btn_minus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "pressed");
		btn_minus.getActionMap().put("pressed", ActionOperator.keyListener );
		
		btn_divide.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "pressed");
		btn_divide.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.SHIFT_MASK), "pressed");
		btn_divide.getActionMap().put("pressed", ActionOperator.keyListener );
		
		btn_multi.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "pressed");
		btn_multi.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, InputEvent.SHIFT_MASK), "pressed");
		btn_multi.getActionMap().put("pressed", ActionOperator.keyListener );
		
		btn_equals.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "pressed");
		btn_equals.getActionMap().put("pressed", ActionEquals.keyListener );
		//}
		//End of InputMapping
	}
	public static void setText(String txt_out)
	{
		cFrame.lb_output.setText(txt_out);
	}
	public static String getText()
	{
		return cFrame.lb_output.getText();
	}
}
