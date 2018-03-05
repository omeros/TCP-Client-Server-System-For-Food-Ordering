package maman16targil1;

import java.awt.Color;
import java.awt.FlowLayout;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Menu extends JFrame implements Runnable
{
	private final static String newline = "\n";
	public JTextArea textArea;
	public   JCheckBox arrBox[];
	JComboBox<Integer>  arrJcombo[];
	 private final int size = 16;
	 JTextArea textArea2;
	 JTextArea textArea3;
	 JTextArea textArea4;
	 JTextArea textArea5;
	private  Order _order=null;;
    public int _amount;
    private JButton save;
    private JButton  exit;
    private JButton newOrder;
    private String _serial;
    String _food;
    int _price;
    Controller c;
    String arr[];
    public int arrPrice[];
    public Integer[] quantity;
    String _name;
    String _phone;
    String _adress;
    private String[] foodArr1;
    private boolean [] foodArr2;
    int countF; 
    int k;
    private int[] amountArr;
    
    /**************** Constructor ************************************************************/
	public Menu(String arr[])       
	/*****************************************************************************/
	{
		 super( " Menu ");
		 setLayout(new FlowLayout());
		 this.arr=arr;
		 _amount=1;
		 _name="";
		 _phone="";
		 _adress="";
		 foodArr1  = new String [12];
		 foodArr2  = new boolean [12]; 
		 amountArr = new int [12];
		 for( int i=0;i<12;i++)
		{
			 foodArr2[i]=false;
			 amountArr[i]=1; 
		}
		  countF=0;
		   k=0;
		   _serial="";		   
		   _price=0;
	}

	/******************* Run method ************************************************/
	public void run ()
	/*****************************************************************************/
	{
			

		 arrPrice = new int[16];
		
		 arrBox= new JCheckBox[size+2];
	     arrJcombo =  new JComboBox[size+2];
		CheckBoxHandler handler = new CheckBoxHandler ();
		int i=0;
		while (i<size)
		{
			if( (i%4)==0)
			{
				String s=arr[i];
				JTextArea textArea1 = new JTextArea(s+ newline,1, 17);
			    textArea1.setFont(new Font("Arial Black", Font.BOLD, 11));
			    Color c = new Color(0,0,0,100);
			    textArea1.setBackground(c);
				textArea1.setEditable(false);
			    setVisible(false);
				add(textArea1);

				JTextArea textArea8 = new JTextArea("",1, 17);
				textArea8.setBackground(c);
				textArea8.setEditable(false);
			    setVisible(false);
				add(textArea8);
				
				JTextArea textArea9 = new JTextArea("",1, 17);
				textArea9.setBackground(c);
				textArea9.setEditable(false);
			    setVisible(false);
				add(textArea9);
				i++;
				continue;
				
			}
			
			String s=arr[i];
			foodArr1[k]=s;
			JTextArea textArea1 = new JTextArea(s+ newline,1, 25);
		    textArea1.setFont(new Font("Arial Black", Font.BOLD, 11));
			textArea1.setEditable(false);
		    setVisible(true);
			add(textArea1);
			JCheckBox box1 = new JCheckBox ("i want it, ");
			arrBox[i]=box1;       			
		    
			 quantity= new Integer [10];  
			  int j;
			  for( j=0;j<10;j++)
			  {
				  quantity[j]=j+1 ;
			  }
		    JComboBox<Integer>   quantityComboBox = new JComboBox<Integer>(quantity);
		    arrJcombo[i]=quantityComboBox;
		    add(quantityComboBox);
		    add(box1);
		    
		    int x= 30+i;
		    arrPrice[i]=x;
		    textArea5 = new JTextArea("price = " + x ,1, 1);
			textArea5.setFont(new Font("Arial Black", Font.ITALIC, 11));
			textArea5.setEditable(false);
		    setVisible(true);
			add(textArea5);
					
			arrBox[i].addItemListener(handler);
			arrJcombo[i].addItemListener(handler);
		    
		    i++;
		}
		
		 textArea2 = new JTextArea("Add_Name"  ,1, 17);
	    textArea2.setFont(new Font("Arial Black", Font.ITALIC, 11));
		textArea2.setEditable(true);
	    setVisible(true);
		add(textArea2);  
		
		 textArea3 = new JTextArea("Add_Phone"  ,1, 17);
		textArea3.setFont(new Font("Arial Black", Font.ITALIC, 11));
		textArea3.setEditable(true);
	    setVisible(true);
		add(textArea3); 
		
		 textArea4 = new JTextArea("Add_Adress"  ,1, 17);
		textArea4.setFont(new Font("Arial Black", Font.ITALIC, 11));
		textArea4.setEditable(true);
	    setVisible(true);
		add(textArea4); 
		
		 save = new  JButton ( " save");
		 add(save);
		 ButtonsHandler handler2 = new ButtonsHandler();
		 save.addActionListener(handler2);
		 
		 exit = new JButton ( " Exit");
		 add(exit);
		 exit.addActionListener(handler2);
		 
		 newOrder = new JButton ( "newOrder");
		 add(newOrder);
		 newOrder.addActionListener(handler2);
		 
		JTextArea textArea5 = new JTextArea("Press save to order "  ,1, 1);
		textArea5.setEditable(false);
	    setVisible(true);
		add(textArea5); 
		
		
	}
	
	/************************ Handler the Buttons ************************************************************/
	private class ButtonsHandler implements ActionListener
 /*********************************************************************************************************/
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("");
			String s;
	   		if(event.getSource()==save)                                // Button save
			{
	
	   		 
	   			if( (arrBox[1].isSelected() ) )
				{
		   	        foodArr2[0]=true;
		   	     _price=_price+arrPrice[1]*amountArr[0];
		   	      s="1";
		   	     for( int i=0;i<amountArr[0];i++)
		   	     {
		   	    	s=s+s;
		   	     }
		   	     _serial=_serial+s;
				}
	   			
	   			
				if( (arrBox[2].isSelected() ) )
				{
			   	        foodArr2[1]=true;
			   	     _price=_price+arrPrice[2]*amountArr[1];
			   	      s="2";
			   	     for( int i=0;i<amountArr[1];i++)
			   	     {
			   	    	s=s+s;
			   	     }
			   	        _serial=_serial+s;
				}
				
				 if( (arrBox[3].isSelected()) )
				{
					foodArr2[2]=true;
					 _price=_price+arrPrice[3]*amountArr[2];
				      s="3";
				   	     for( int i=0;i<amountArr[2];i++)
				   	     {
				   	    	s=s+s;
				   	     }
				   	        _serial=_serial+s;				
				}
				 
				 if( (arrBox[5].isSelected()) )
				{
						foodArr2[3]=true;
					    _price=_price+arrPrice[5]*amountArr[3];
					      s="4";
					   	     for( int i=0;i<amountArr[3];i++)
					   	     {
					   	    	s=s+s;
					   	     }
					   	        _serial=_serial+s;				
			}
				 if( (arrBox[6].isSelected()) )
				{
							foodArr2[4]=true;
							_price=_price+arrPrice[6]*amountArr[4];
						      s="5";
						   	     for( int i=0;i<amountArr[4];i++)
						   	     {
						   	    	s=s+s;
						   	     }
						   	        _serial=_serial+s;				
	              }
				 if( (arrBox[7].isSelected()) )
				{
						foodArr2[5]=true;
						 _price=_price+arrPrice[7]*amountArr[5];
					      s="6";
					   	     for( int i=0;i<amountArr[5];i++)
					   	     {
					   	    	s=s+s;
					   	     }
					   	        _serial=_serial+s;				
			  }
				 
				 if( (arrBox[9].isSelected()) )
				{
						foodArr2[6]=true;
						 _price=_price+arrPrice[9]*amountArr[6];
					      s="7";
					   	     for( int i=0;i<amountArr[6];i++)
					   	     {
					   	    	s=s+s;
					   	     }
					   	        _serial=_serial+s;				
				}
				 if( (arrBox[10].isSelected()) )
				{
						foodArr2[7]=true;
						_price=_price+arrPrice[10]*amountArr[7];
					      s="8";
					   	     for( int i=0;i<amountArr[7];i++)
					   	     {
					   	    	s=s+s;
					   	     }
					   	        _serial=_serial+s;				
				}
				 if( (arrBox[11].isSelected()) )
				{
						foodArr2[8]=true;
						 _price=_price+arrPrice[11]*amountArr[8];
					      s="9";
					   	     for( int i=0;i<amountArr[8];i++)
					   	     {
					   	    	s=s+s;
					   	     }
					   	        _serial=_serial+s;				
			  }
				 
				 if( (arrBox[13].isSelected()) )
				{
						foodArr2[9]=true;
						 _price=_price+arrPrice[13]*amountArr[9];
					      s="10";
					   	     for( int i=0;i<amountArr[9];i++)
					   	     {
					   	    	s=s+s;
					   	     }
					   	        _serial=_serial+s;		
			 }
				 if( (arrBox[14].isSelected()) )
				{
						foodArr2[10]=true;
						 _price=_price+arrPrice[14]*amountArr[10];
					      s="11";
					   	     for( int i=0;i<amountArr[10];i++)
					   	     {
					   	    	s=s+s;
					   	     }
					   	        _serial=_serial+s;				}
				 if( (arrBox[15].isSelected()) )
				{
					 foodArr2[11]=true;
					 _price=_price+arrPrice[15]*amountArr[11];
				      s="12";
				   	     for( int i=0;i<amountArr[11];i++)
				   	     {
				   	    	s=s+s;
				   	     }
				   	        _serial=_serial+s;
				}
				 
			   		System.out.println("");

	   			

			   int  p=_price;
	   		   _name = textArea2.getText();
		       _phone= textArea3.getText();
			   _adress = textArea4.getText();
			   if( (_adress.equals("Add_Adress"))||(_name.equals("Add_Name"))||(_phone.equals("Add_Phone" ))   ) 
			   {
				   JOptionPane.showMessageDialog(null, "Please Fille all the requared data" );
				}
			   else
			   {
					Order r = new Order (_serial,_name,_phone, _adress,foodArr2,amountArr,p);
					setOrder(r);
				    c.finished();
			   }
			}
	   		
	   		
	   		if(event.getSource()==exit)             // Button exit
			{
	   						
	    			System.exit(0);
				
			}
	   		
	   		
			if(event.getSource()==newOrder)         // Button new Order
			{	   		
			    c.finished();


			}
	   		
    	}
	}

	 /******************************* Handler the CheckBox and the ComboBox **************************************************************************/	
	private class CheckBoxHandler implements ItemListener
	 /*********************************************************************************************************/
	{
		public void itemStateChanged( ItemEvent event)
		{

			 if ( ( event.getSource()==arrJcombo[1] ))
			{
				 if(event.getStateChange() == ItemEvent.SELECTED)
	    		{
				     Integer amount = (Integer)event.getItem(); 
				     amountArr[0]=(int)amount;
			     	 

	    		}

	    	}
			 if ( ( event.getSource()==arrJcombo[1] )&&(!arrBox[1].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[0]=0;
				     	 

		    		}

		    	}
		

			 if( event.getSource()==arrJcombo[2] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[1]=(int)amount;
		    	}

			}
		
		 if ( ( event.getSource()==arrJcombo[2] )&&(!arrBox[2].isSelected()) )
			{
				 if(event.getStateChange() == ItemEvent.SELECTED)
	    		{
			     	 amountArr[1]=0;
			     	 

	    		}

	    	}

			 if( event.getSource()==arrJcombo[3] )
				 {
					 if(event.getStateChange() == ItemEvent.SELECTED)
			    	{
						 	Integer amount = (Integer)event.getItem();
						 	amountArr[2]=(int)amount;
			    	}

				 }
			 if ( ( event.getSource()==arrJcombo[3] )&&(!arrBox[3].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[2]=0;
				     	 

		    		}

		    	}
			
			

			 if( event.getSource()==arrJcombo[5] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[3]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[5] )&&(!arrBox[5].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[3]=0;
				     	 

		    		}

		    	}

			
			

			
			 if( event.getSource()==arrJcombo[6] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[4]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[6] )&&(!arrBox[6].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[4]=0;
				     	 

		    		}

		    	}
				

			 
			 if( event.getSource()==arrJcombo[7] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[5]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[7] )&&(!arrBox[7].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[5]=0;
				     	 

		    		}

		    	}

			 
			 if( event.getSource()==arrJcombo[9] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[6]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[9] )&&(!arrBox[9].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[6]=0;
				     	 

		    		}

		    	}
			 

			 if( event.getSource()==arrJcombo[10] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[7]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[10] )&&(!arrBox[10].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[7]=0;
				     	 

		    		}

		    	}
			 

			 
			 if( event.getSource()==arrJcombo[11] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[8]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[11] )&&(!arrBox[11].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[8]=0;
				     	 

		    		}

		    	}

			 if( event.getSource()==arrJcombo[13] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[9]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[13] )&&(!arrBox[13].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[9]=0;
				     	 

		    		}

		    	}

			 if( event.getSource()==arrJcombo[14] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[10]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[14] )&&(!arrBox[14].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[10]=0;
				     	 

		    		}

		    	}

			 if( event.getSource()==arrJcombo[15] )
			 {
				 if(event.getStateChange() == ItemEvent.SELECTED)
		    	{
					 	Integer amount = (Integer)event.getItem();
					 	amountArr[11]=(int)amount;
		    	}

			}
			 if ( ( event.getSource()==arrJcombo[15] )&&(!arrBox[15].isSelected()) )
				{
					 if(event.getStateChange() == ItemEvent.SELECTED)
		    		{
				     	 amountArr[11]=0;
				     	 

		    		}

		    	}
			
		}
	}
	
	/**************** Set *************************************************/
	public  void setOrder( Order r)
	/*************************************************************************/
	{
		_order=r;
	}
	
	/******************* Get ***************************************************/
	public Order getOrder()
	/***********************************************************************/
	{
		return _order;
	}
	
	/*********************** Set **************************************************************/
	public void  setController(Controller cont)
	/*************************************************************************************/
	{
		c=cont;
	}
	
	/************************* Get ***************************************************/
	public Controller  getController()
	/***************************************************************************/
	{
		return c;
	}
	
	
	
}


