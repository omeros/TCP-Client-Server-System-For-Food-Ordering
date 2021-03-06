package maman16targil1;

import java.io.Serializable;

/********************** Class  represents the Order ***********************************************/
public class Order implements Serializable
/********************************************************************/
{
	public String _serialNumber="";
	public String _name=null;;
	public String _phone=null;;
	public String _adress=null;;
	public boolean _food[]=null;;
	public int _amount[]; 
	private int _price=0; 
	
	/*********************** Constructor *********************************************/
	public Order(String serialNumber ,String name,String phone, String adress ,boolean [] food ,int [] amount, int price )
	/********************************************************************/
	{
		 _serialNumber=serialNumber;
		 _name=name  ;
		 _phone=phone;
		 _adress=adress;
		 _food=food;
		 _amount=amount; 
		 _price= price;
	}
	
	/********************* toString **********************************************/
	public String toString()
	/********************************************************************/
	{
		String s="  serialNumber :"+ _serialNumber+"  _name :"+_name+ " _phone :" +_phone+ "  adress :" +_adress+ "  food :" +_food+ "  amount :" +_amount +" Price  :" + _price; 
		return s;
	}

	/********************************************************************/
	public boolean [] get_food() 
		/********************************************************************/
	{
		return _food;
	}
	
	/********************************************************************/
	public void set_food(int index)
	/********************************************************************/

	{
		this._food[index] = true;
	}

	/*************************************************************/
	public int[] get_amount()
	/*******************************************************************/
	{
		return _amount;
	}
/**************************************************************************/
	public void set_amount(int _amount, int index) 
	/********************************************************************/
	{
		this._amount[index] = _amount;
	}
	
	
	/********************************************************************/
	public int get_price() 
	/********************************************************************/
	{
		return _price;
	}

	/********************************************************************/
	public void set_price(int _price) 
	/********************************************************************/
	{
		this._price = _price;
	}

	/********************************************************************/
	public String get_serialNumber()
	/********************************************************************/
	{
		return _serialNumber;
	}

	/********************************************************************/
	public void set_serialNumber(String _serialNumber) 
	/********************************************************************/
	{
		this._serialNumber = _serialNumber;
	}

	/********************************************************************/
	public String get_name()
	/********************************************************************/
	{
		return _name;
	}

	/********************************************************************/
	public void set_name(String _name)
	/********************************************************************/
	{
		this._name = _name;
	}

	/********************************************************************/
	public String get_phone() 
	/********************************************************************/
	{
		return _phone;
	}

	/********************************************************************/
	public void set_phone(String _phone)
	/********************************************************************/
	{
		this._phone = _phone;
	}

	/********************************************************************/
	public String get_adress() 
	/********************************************************************/
	{
		return _adress;
	}
	/********************************************************************/
	public void set_adress(String _adress)
	/********************************************************************/
	{
		this._adress = _adress;
	}

}
