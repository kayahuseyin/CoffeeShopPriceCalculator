package weekeight;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class frame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox cb;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JRadioButton r1;
	private JRadioButton r2;
	private JRadioButton r3;
	private JSpinner spinner;
	private JTextField paid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 438);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new LineBorder(Color.ORANGE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("BEVERAGE");
		lblNewLabel_1.setBounds(25, 100, 79, 14);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.ORANGE);
		contentPane.add(lblNewLabel_1);
		
		cb = new JComboBox();
		cb.setBounds(134, 97, 100, 22);
		cb.setModel(new DefaultComboBoxModel(new String[] {"LATTE", "AMERICANO", "MACCHIATO"}));
		contentPane.add(cb);
		
		Double[] prices = {8.00, 8.50, 9.00}; // fiyatlarý eþleþti sýrayla 
		
		lblNewLabel_2 = new JLabel("CUP SIZE");
		lblNewLabel_2.setBounds(25, 155, 79, 14);
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("CUPS");
		lblNewLabel_3.setBounds(25, 213, 79, 14);
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("CARAMEL");
		lblNewLabel_4.setBounds(25, 264, 79, 14);
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("PAID");
		lblNewLabel_5.setBounds(25, 313, 79, 14);
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(lblNewLabel_5);
		
		r1 = new JRadioButton("REGULAR");
		r1.setForeground(Color.WHITE);
		r1.setFont(new Font("Tahoma", Font.BOLD, 13));
		r1.setBounds(134, 126, 100, 23);
		r1.setBackground(Color.WHITE);
		r1.setOpaque(false);
		contentPane.add(r1);
		
		r2 = new JRadioButton("TALL");
		r2.setForeground(Color.WHITE);
		r2.setFont(new Font("Tahoma", Font.BOLD, 13));
		r2.setBounds(134, 152, 100, 23);
		r2.setOpaque(false);
		contentPane.add(r2);
		
		r3 = new JRadioButton("GRANDE");
		r3.setFont(new Font("Tahoma", Font.BOLD, 13));
		r3.setForeground(Color.WHITE);
		r3.setBounds(134, 178, 100, 23);
		r3.setOpaque(false);
		contentPane.add(r3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(134, 211, 30, 20);
		spinner.setOpaque(false);
		contentPane.add(spinner);
		
		
		JCheckBox check = new JCheckBox("New check box");
		check.setBounds(134, 261, 22, 23);
		check.setOpaque(false); //saydam
		
		contentPane.add(check);
		
		paid = new JTextField();
		paid.setText("0");
		paid.setBounds(134, 311, 112, 20);
		contentPane.add(paid);
		paid.setColumns(10);
		
		JLabel spinnerlbl = new JLabel("New label");
		spinnerlbl.setFont(new Font("Tahoma", Font.PLAIN, 5));
		spinnerlbl.setForeground(Color.DARK_GRAY);
		spinnerlbl.setBounds(561, 374, 46, 14);
		contentPane.add(spinnerlbl);
		
		
	
		
		// action listener
		JButton btnNewButton = new JButton("CALCULATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb.getSelectedIndex();	
				
				
				
				double originalPrice = prices[cb.getSelectedIndex()];
				String value = spinner.getValue().toString();
				spinnerlbl.setText(value);
				double d = Double.parseDouble(value);
				// spinner'ýn valuesini stringe aktardým
				originalPrice=originalPrice*d;
				//stringi double a çevirip çarptým
				
				if (r2.isSelected())originalPrice=originalPrice*1.50;
				if(r3.isSelected())originalPrice=originalPrice*1.8;
				if(check.isSelected())originalPrice=originalPrice+2;
				
				
				paid.setText("" + originalPrice);
				
			}
			
		});
		btnNewButton.setBounds(134, 344, 112, 23);
		contentPane.add(btnNewButton);
		
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 649, 406);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(frame.class.getResource("/weekeight/coffee.png")));
		contentPane.add(lblNewLabel);
		
	}
}
