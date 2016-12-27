import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Other{
	public Other(){
		super();
	}
}
/************************ҽ��***************************/

class Doctor {
	private String ID;//���֤��
	private String pwd;//�����
	private String name;//ԤԼ��
	private String sex;
	private int age;
	private String phone;
	private String deptid;
	private int state;
	private int mnum;
	private int dnum ;
	private float mincome;
	private float dincome;
	private String list;
	
	
	public Doctor(){
		super();
	}
	
	public Doctor(String ID,String pwd,String name,String sex,int age,String phone,String deptid,int state){
		this.ID=ID;
		this.pwd=pwd;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.phone=phone;
		this.deptid=deptid;
		this.state=state;
	}
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){  
		this.ID=ID;
	}
	public String getPwd(){
		return pwd;
	}
	
	public void setPwd(String pwd){  
		this.pwd=pwd;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){  
		this.name=name;
	}
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){  
		this.sex=sex;
	}
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){  
		this.age=age;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){  
		this.phone=phone;
	}	
	public String getDeptid(){
		return deptid;
	}
	
	public void setDeptid(String deptid){  
		this.deptid=deptid;
	}
	public int getState(){
		return state;
	}
	
	public void setState(int state){  
		this.state=state;
	}
	public int getMnum(){
		return mnum;
	}
	
	public void setMnum(int mnum){  
		this.mnum=mnum;
	}
	public int getDnum(){
		return dnum;
	}
	
	public void setDnum(int dnum){  
		this.dnum=dnum;
	}
	public float getMincome(){
		return mincome;
	}
	
	public void setMincome(float mincome){  
		this.mincome=mincome;
	}
	public float getDincome(){
		return dincome;
	}
	public void setDincome(float dincome){  
		this.dincome=dincome;
	}

	public String getList(){
		return list;
	}
	
	public void setList(String list){  
		this.list=list;
	}


public static Object[][] getDoc(String deptid)
{
	ArrayList<Doctor> list=new ArrayList<Doctor>();
	String sql="select * from Doctor where deptid='"+deptid+"'";
	ResultSet rs=SQL.executeQuery(sql);
	Doctor d=null;
	try {
		while(rs.next()){
			d=new Doctor();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
			d.setSex(rs.getString("sex"));
			d.setAge(Integer.parseInt(rs.getString("age")));
			d.setList(rs.getString("list"));
			d.setState(Integer.parseInt(rs.getString("state")));
			
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][5];
	for(int i=0;i<list.size();i++)
	{
		Doctor d1=(Doctor)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
			resu[i][2]=d1.getSex();
			resu[i][3]=d1.getAge();
			if(d1.getList()!=null)
		      resu[i][4]=(d1.getList().length())/12;
			else
				resu[i][4]=0;
      }	
	return resu;
}


public static Object[][] getDocInfo(String deptid)
{
	ArrayList<Doctor> list=new ArrayList<Doctor>();
	String sql="select * from Doctor where deptid='"+deptid+"'";
	ResultSet rs=SQL.executeQuery(sql);
	Doctor d=null;
	try {
		while(rs.next()){
			d=new Doctor();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
			d.setSex(rs.getString("sex"));
			d.setAge(Integer.parseInt(rs.getString("age")));
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][4];
	for(int i=0;i<list.size();i++)
	{
		Doctor d1=(Doctor)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
			resu[i][2]=d1.getSex();
			resu[i][3]=d1.getAge();
      }	
	return resu;
}
}



/************************�Һ��շ���Ա***************************/

class Register {
	private String ID;//���֤��
	private String pwd;//�����
	private String name;//ԤԼ��
	private String sex;
	private int age;
	private String phone;
	
	public Register(){
		super();
	}
	
	public Register(String ID,String pwd,String name,String sex,int age,String phone){
		this.ID=ID;
		this.pwd=pwd;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.phone=phone;
	}
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){  
		this.ID=ID;
	}
	public String getPwd(){
		return pwd;
	}
	
	public void setPwd(String pwd){  
		this.pwd=pwd;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){  
		this.name=name;
	}
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){  
		this.sex=sex;
	}
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){  
		this.age=age;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){  
		this.phone=phone;
	}


public static Object[][] getRegInfo()
{
	ArrayList<Register> list=new ArrayList<Register>();
	String sql="select * from Register";
	ResultSet rs=SQL.executeQuery(sql);
	Register d=null;
	try {
		while(rs.next()){
			d=new Register();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
			d.setSex(rs.getString("sex"));
			d.setAge(Integer.parseInt(rs.getString("age")));
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][4];
	for(int i=0;i<list.size();i++)
	{
		Register d1=(Register)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
			resu[i][2]=d1.getSex();
			resu[i][3]=d1.getAge();
      }	
	return resu;
}
}

class Phar {
	private String ID;
	private String pwd;
	private String name;
	private String sex;
	private int age;
	private String phone;
	
	public Phar(){
		super();
	}
	
	public Phar(String ID,String pwd,String name,String sex,int age,String phone){
		this.ID=ID;
		this.pwd=pwd;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.phone=phone;
	}
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){  
		this.ID=ID;
	}
	public String getPwd(){
		return pwd;
	}
	
	public void setPwd(String pwd){  
		this.pwd=pwd;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){  
		this.name=name;
	}
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){  
		this.sex=sex;
	}
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){  
		this.age=age;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){  
		this.phone=phone;
	}


public static Object[][] getPharInfo()
{
	ArrayList<Phar> list=new ArrayList<Phar>();
	String sql="select * from Phar";
	ResultSet rs=SQL.executeQuery(sql);
	Phar d=null;
	try {
		while(rs.next()){
			d=new Phar();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
			d.setSex(rs.getString("sex"));
			d.setAge(Integer.parseInt(rs.getString("age")));
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][4];
	for(int i=0;i<list.size();i++)
	{
		Phar d1=(Phar)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
			resu[i][2]=d1.getSex();
			resu[i][3]=d1.getAge();
      }	
	return resu;
}
}



class Dept {
	private String ID;//���֤�
	private String name;//ԤԼ��
	private int mnum;
	private int dnum ;
	private float mincome;
	private float dincome;
	
	
	
	public Dept(){
		super();
	}
	
	
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){  
		this.ID=ID;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){  
		this.name=name;
	}
	public int getMnum(){
		return mnum;
	}
	
	public void setMnum(int mnum){  
		this.mnum=mnum;
	}
	public int getDnum(){
		return dnum;
	}
	
	public void setDnum(int dnum){  
		this.dnum=dnum;
	}
	public float getMincome(){
		return mincome;
	}
	
	public void setMincome(float mincome){  
		this.mincome=mincome;
	}
	public float getDincome(){
		return dincome;
	}
	public void setDincome(float dincome){  
		this.dincome=dincome;
	}



public static Object[][] getDept()
{
	ArrayList<Dept> list=new ArrayList<Dept>();
	String sql="select * from Dept";
	ResultSet rs=SQL.executeQuery(sql);
	Dept d=null;
	try {
		while(rs.next()){
			d=new Dept();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
		
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][2];
	for(int i=0;i<list.size();i++)
	{
		Dept d1=(Dept)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
      }	
	return resu;
}
}



class Med {
	private String ID;//���֤�
	private String name;//ԤԼ��
	private String pinyin;
	private String spec;
	private float price;
	private int amount;
	private int number;
	
	
	
	public Med(){
		super();
	}
	
	
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){  
		this.ID=ID;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){  
		this.name=name;
	}
	public String getPinyin(){
		return pinyin;
	}
	
	public void setPinyin(String pinyin){  
		this.pinyin=pinyin;
	}
	public String getSpec(){
		return spec;
	}
	
	public void setSpec(String spec){  
		this.spec=spec;
	}
	public float getPrice(){
		return price;
	}
	
	public void setPrice(float price){  
		this.price=price;
	}
	public int getAmount(){
		return amount;
	}
	public void setAmount(int amount){  
		this.amount=amount;
	}
	public int getNumber(){
		return number;
	}
	public void setNumber(int amount){  
		this.number=amount;
	}



public static Object[][] getMed(String sql)
{
	ArrayList<Med> list=new ArrayList<Med>();
	ResultSet rs=SQL.executeQuery(sql);
	Med d=null;
	try {
		while(rs.next()){
			d=new Med();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
			d.setPinyin(rs.getString("pinyin"));
			d.setSpec(rs.getString("spec"));
			d.setPrice(Float.valueOf(rs.getString("price")));
			d.setAmount(Integer.parseInt(rs.getString("amount")));
		
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][6];
	for(int i=0;i<list.size();i++)
	{
		Med d1=(Med)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
		    resu[i][2]=d1.getPinyin();
		    resu[i][3]=d1.getSpec();
		    resu[i][4]=d1.getPrice();
		    resu[i][5]=d1.getAmount();
		   
      }	
	return resu;
}




}




class Item {
	private String ID;//���֤�
	private String name;//ԤԼ��
	private float price;
	private String desc; 
	private String pinyin;
	private int number;
	
	public Item(){
		super();
	}
	
	
	
	public String getID(){
		return ID;
	}
	
	public void setID(String ID){  
		this.ID=ID;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){  
		this.name=name;
	}
	public float getPrice(){
		return price;
	}
	
	public void setPrice(float m){  
		this.price=m;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public void setDesc(String desc){  
		this.desc=desc;
	}
	
	public String getPinyin(){
		return pinyin;
	}
	
	public void setPinyin(String desc){  
		this.pinyin=desc;
	}
	
	public int getNumber(){
		return number;
	}
	public void setNumber(int amount){  
		this.number=amount;
	}
	



public static Object[][] getItem(String sql)
{
	ArrayList<Item> list=new ArrayList<Item>();
	ResultSet rs=SQL.executeQuery(sql);
	Item d=null;
	try {
		while(rs.next()){
			d=new Item();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
			d.setPrice(Float.valueOf(rs.getString("price")));
		    d.setDesc(rs.getString("desc"));
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][4];
	for(int i=0;i<list.size();i++)
	{
		Item d1=(Item)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
		    resu[i][2]=d1.getPrice();
		    resu[i][3]=d1.getDesc();
		    
      }	
	return resu;
}
public static Object[][] getItem2(String sql)
{
	ArrayList<Item> list=new ArrayList<Item>();
	ResultSet rs=SQL.executeQuery(sql);
	Item d=null;
	try {
		while(rs.next()){
			d=new Item();
			d.setID(rs.getString("id"));
			d.setName(rs.getString("name"));
			d.setPinyin(rs.getString("pinyin"));
			d.setPrice(Float.valueOf(rs.getString("price")));
		    d.setDesc(rs.getString("desc"));
			list.add(d);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][4];
	for(int i=0;i<list.size();i++)
	{
		Item d1=(Item)list.get(i);
	        resu[i][0]=d1.getID();
		    resu[i][1]=d1.getName();
		    resu[i][2]=d1.getPinyin();
		    resu[i][3]=d1.getPrice();
		
		    
      }	
	return resu;
}
}




