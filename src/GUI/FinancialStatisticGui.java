package GUI;

import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import BUS.IInvoiceBUS;
import BUS.implement.InvoiceBUS;
import Constant.SystemConstant;
import DTO.Invoice;
public class FinancialStatisticGui extends JFrame {

	private JPanel contentPane;
	static private JTextField txtTotal;
	private JTable table;
	private JDateChooser dateChooserFrom,dateChooserTo  ;
	private JButton btnNewButtonTK;
	private JScrollPane scrollPane_1;
	private static ChartPanel chartPanel;
	private Choice choice ;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinancialStatisticGui frame = new FinancialStatisticGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static void setColumn_Day(Vector<String> v)
	{
		v.add("Date");
		v.add("ID Invoice");
		v.add("Price Medicine");
		v.add("Price Service");
		v.add("Price Total");
	}

	public static void getDataToRow_Day(Vector<Object> row,  Invoice i)
	{
		row.add(i.getPayDate());
		row.add(i.getId());
		row.add(i.getTotalPriceMedicine());
		row.add(i.getTotalPriceService());
		row.add(i.getTotalPriceMedicine()+i.getTotalPriceService());
	}
	
	// get data to DefaultTableModel
public static DefaultTableModel showDataToTable_Day(Date d1, Date d2)  
{  
	    double total=0;
		double totalDays=0;
	    final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		DefaultTableModel model =new DefaultTableModel();
		Vector<String> column =new Vector<String>();
		setColumn_Day(column);
	    model.setColumnIdentifiers(column);
	    IInvoiceBUS invoice = new InvoiceBUS();
	    List<Invoice> list =new ArrayList<Invoice>();
	    list= invoice.findAllOderByDate();   // find all invoice			
	    List<Invoice> invoices = new ArrayList<Invoice>();
	    
	    if (d1.compareTo(d2)<=0)			
		{
	    	for (int i=0;i<list.size();i++)			
				{
	    		  Invoice p=(Invoice)list.get(i);		
				  @SuppressWarnings("deprecation")
				  Date date =new Date(p.getPayDate().getYear(), p.getPayDate().getMonth(),p.getPayDate().getDate());
				  
				  if (date.compareTo(d1)>=0 && date.compareTo(d2)<=0 )
					{ 
					
					  invoices.add(p);
					}
				}
				       for (int k=0;k<invoices.size();k++) {
				    	   		Invoice pi = (Invoice)invoices.get(k);
								Date dateini =new Date(pi.getPayDate().getYear(), pi.getPayDate().getMonth(),pi.getPayDate().getDate());
								Vector<Object> row =new Vector<Object>();
			    				getDataToRow_Day(row,pi);				
			    				model.addRow(row);	
			    				total+=pi.getTotalPriceMedicine()+pi.getTotalPriceService();
			    				if (k==0) {
			    					 totalDays = pi.getTotalPrice();
			    				}
			    				if (k>0) {
			    	    		 Invoice p1=(Invoice)invoices.get(k-1);
			    				 Date date1 =new Date(p1.getPayDate().getYear(), p1.getPayDate().getMonth(),p1.getPayDate().getDate());
			    				 if (date1.compareTo(dateini)==0) {
			    					 totalDays += pi.getTotalPrice();
			    				 } else 
			    				 {
					    			 dataset.addValue(totalDays, "Doanh thu", ""+date1);
			    					 totalDays = pi.getTotalPrice();
			    				 }
			    				 if (k==invoices.size()-1) {
					    			 dataset.addValue(totalDays, "Doanh thu", ""+dateini);

			    				 }

			    				}
							}


			    }
		
		else JOptionPane.showMessageDialog(null, "Please choose the start date before the end date !");
		// get data to chart			
	    JFreeChart barChart = ChartFactory.createBarChart(			 
					            "Invoice Manager Statistics",
					            "Time", "Revenue",
					            dataset, PlotOrientation.VERTICAL, false, false, false);
		chartPanel = new ChartPanel(barChart);
		txtTotal.setText(""+total/SystemConstant.unit);

		return model;
								
}

public static DefaultTableModel showDataToTable()  
{   double total=0;
	DefaultTableModel model =new DefaultTableModel();
	Vector<String> column =new Vector<String>();
	setColumn_Day(column);
    model.setColumnIdentifiers(column);
    IInvoiceBUS invoice = new InvoiceBUS();
    List<Invoice> list =new ArrayList<Invoice>();
    list= invoice.findAllOderByDate();   // find all invoice			

  
    	for (int i=0;i<list.size();i++)			
			{
    		  Invoice p=(Invoice)list.get(i);		
							Vector<Object> row =new Vector<Object>();
		    				getDataToRow_Day(row,p);				
		    				model.addRow(row);	
		    				total+=p.getTotalPriceMedicine()+p.getTotalPriceService();
						}

		    
	
	
	txtTotal.setText(""+total/SystemConstant.unit);

	return model;
								
}



public static void setColumn_Month(Vector<String> v)
{
	v.add("Month");
	v.add("Price Medicine");
	v.add("Price Service");
	v.add("Price Total");
}
public static void getDataToRow_Month(Vector<Object> row,  Invoice i)
{
	row.add(i.getPayDate().getMonth()+1);
	row.add(i.getTotalPriceMedicine());
	row.add(i.getTotalPriceService());
	row.add(i.getTotalPriceMedicine()+i.getTotalPriceService());
}
@SuppressWarnings("deprecation")
public static DefaultTableModel showDataToTable_Month(Date d1, Date d2)  
{   double total=0;
    final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	DefaultTableModel model =new DefaultTableModel();
	Vector<String> column =new Vector<String>();
	setColumn_Month(column);
    model.setColumnIdentifiers(column);
    
    IInvoiceBUS invoice = new InvoiceBUS();
	List<Invoice> list =new ArrayList<Invoice>();
	list= invoice.findAllOderByDate();    // find all invoice
	int[] month =new int[13];
	double[] total_medicine =new double[13];
	double[] total_service = new double[13];

	if (d1.compareTo(d2)<=0)
	{
		for (int i=0;i<list.size();i++)
		{   Invoice p=(Invoice)list.get(i);
			Date date =new Date(p.getPayDate().getYear(), p.getPayDate().getMonth(),p.getPayDate().getDate());
			if (date.compareTo(d1)>=0 && date.compareTo(d2)<=0 )
	      	{
			   month[p.getPayDate().getMonth()+1]= p.getPayDate().getMonth()+1;
			   total_medicine[p.getPayDate().getMonth()+1]+=p.getTotalPriceMedicine();
			   total_service[p.getPayDate().getMonth()+1]+=p.getTotalPriceService();
		    }

		}
		for (int i=1;i<=12;i++)
		{  if ( month[i] != 0)
		  {
			Vector<Object> row =new Vector<Object>();
			row.add(month[i]);
			row.add(total_medicine[i]);
			row.add(total_service[i]);
			row.add(total_medicine[i] + total_service[i] );
			total+=total_medicine[i] + total_service[i];
			dataset.addValue(total_medicine[i] + total_service[i], "Doanh thu", "Tháng "+month[i]);
			model.addRow(row);
		  }
		
		}
		
		
	}
	else JOptionPane.showMessageDialog(null, "Please choose the start date before the end date !");
	
	 JFreeChart barChart = ChartFactory.createBarChart(
	            "Invoice Manager Statistics ",
	            "Time", "Revenue",
	            dataset, PlotOrientation.VERTICAL, false, false, false);
	 chartPanel = new ChartPanel(barChart);
	
	txtTotal.setText(""+total/SystemConstant.unit);

	return model;
					
}


	public FinancialStatisticGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statistics and Revenues");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 19));
		lblNewLabel.setBounds(369, 11, 526, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From :");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(418, 55, 110, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("To :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(712, 57, 93, 17);
		contentPane.add(lblNewLabel_1_1);
		
		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(538, 52, 110, 20);
		dateChooserFrom.setDate(new Timestamp(System.currentTimeMillis()));
		contentPane.add(dateChooserFrom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 390, 419);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(815, 55, 110, 20);
		dateChooserTo.setDate(new Timestamp(System.currentTimeMillis()));
		contentPane.add(dateChooserTo);
		
		 btnNewButtonTK = new JButton("");
		btnNewButtonTK.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButtonTK.setBounds(979, 45, 40, 35);
		btnNewButtonTK.setIcon(new ImageIcon(SystemConstant.img_search1));
		contentPane.add(btnNewButtonTK);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total (triệu) :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(20, 531, 142, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtTotal = new JTextField();
		txtTotal.setForeground(Color.BLUE);
		txtTotal.setBorder(null);
		txtTotal.setEnabled(false);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setBackground(SystemColor.activeCaption);
		txtTotal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtTotal.setBounds(183, 530, 171, 17);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(410, 101, 809, 419);
		contentPane.add(scrollPane_1);
		
	    chartPanel = new ChartPanel((JFreeChart) null);
		scrollPane_1.setViewportView(chartPanel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Types of time");
		lblNewLabel_1_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(33, 57, 96, 17);
		contentPane.add(lblNewLabel_1_2);
		
		choice = new Choice();
		choice.setBounds(135, 54, 241, 18);
		choice.addItem("All");
		choice.addItem("Statistics Day");
		choice.addItem("Statistics Month");
		contentPane.add(choice);
		
		table.setModel(showDataToTable());
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(1029, 45, 40, 35);
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_exit3));
		contentPane.add(btnNewButton);

		btnNewButtonTK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat month =new SimpleDateFormat ("MM");
			    SimpleDateFormat year =new SimpleDateFormat ("yyyy");
		        SimpleDateFormat day =new SimpleDateFormat ("dd");

		        String m =month.format(dateChooserFrom.getDate());	    
		        String y =year.format(dateChooserFrom.getDate());
		        String d =day.format(dateChooserFrom.getDate());
		    
		        @SuppressWarnings("deprecation")
				Date date1 = new Date(Integer.parseInt(y)-1900, Integer.parseInt(m)-1, Integer.parseInt(d));
		        
		        
		        String m1 =month.format(dateChooserTo.getDate());
		        String y1 =year.format(dateChooserTo.getDate());
		        String d1 =day.format(dateChooserTo.getDate());
		    
		        @SuppressWarnings("deprecation")
				Date date2 = new Date(Integer.parseInt(y1)-1900, Integer.parseInt(m1)-1, Integer.parseInt(d1));
		        if (choice.getSelectedItem().toString().equalsIgnoreCase("All")) {
				    table.setModel(showDataToTable());
				    scrollPane_1.setViewportView(null);
		        } 
		        	
		        else 
		        {
                    if (choice.getSelectedItem().toString()=="Statistics Day")
                    {
  
    				    table.setModel(showDataToTable_Day(date1, date2));
    			        
    					
                    }
           
                    else if (choice.getSelectedItem().toString()=="Statistics Month")
                    {
                    	table.setModel(showDataToTable_Month(date1, date2));
                    }
                    scrollPane_1.setViewportView(chartPanel);

			}
			}
			
		});

	}
}