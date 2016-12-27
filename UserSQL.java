import java.awt.EventQueue;
import java.sql.*;

import java.util.*;
import java.util.Date;


public class UserSQL {
	
		
	//根据就诊号就诊号mid，查询某个用户信息，返回一个user对象
	public static User getUser(String mid){
		String sql="select * from UserMedicalHistory where mid='"+mid+"'";
		ResultSet rs=SQL.executeQuery(sql);
		User user=null;
		try {
			if(rs.next()){
				
				user=new User();
				user.setMID(rs.getString("mid"));
				user.setID(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(Integer.parseInt(rs.getString("age")) );
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				
				user.setDeptid(rs.getString("deptid"));
				user.setDocid(rs.getString("docid"));
				user.setDesc(rs.getString("desc"));
				user.setDiag(rs.getString("diag"));
				user.setMed(rs.getString("med"));
				if(rs.getString("chargeitem")!=null)
				user.setChargeitem(rs.getString("chargeitem"));
				if(rs.getString("cost")!=null)
				user.setCost(Float.parseFloat(rs.getString("cost")));
				if(rs.getString("state")!=null)
				user.setState(Integer.parseInt(rs.getString("state")));
				if(rs.getString("aptime")!=null)
				user.setAptime(Timestamp.valueOf(rs.getString("aptime")));
				else{user.setAptime(null);}
				if(rs.getString("regtime")!=null)
				user.setRegtime(Timestamp.valueOf(rs.getString("regtime")));
				if(rs.getString("chargetime")!=null)
				user.setChargetime(Timestamp.valueOf(rs.getString("chargetime")));
				if(rs.getString("finishtime")!=null)
				user.setFinishtime(Timestamp.valueOf(rs.getString("finishtime")));}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.close();
		return user;
		
	}
	
	
	//根据查询语句sql，查询符合条件的一组用户，返回arraylist<user>对象
	public static ArrayList<User> getUserList(String sql){
		ArrayList<User> list=new ArrayList<User>();
		ResultSet rs=SQL.executeQuery(sql);
		User user=null;

		try {
			while(rs.next()){
				
				user=new User();
				user.setMID(rs.getString("mid"));
				user.setID(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(Integer.parseInt(rs.getString("age")) );
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				
				user.setDeptid(rs.getString("deptid"));
				user.setDocid(rs.getString("docid"));
				user.setDesc(rs.getString("desc"));
				user.setDiag(rs.getString("diag"));
				user.setChargeitem(rs.getString("chargeitem"));
				user.setCost(Float.parseFloat(rs.getString("cost")));
				user.setState(Integer.parseInt(rs.getString("state")));
				
				user.setAptime(Timestamp.valueOf(rs.getString("aptime")));
				user.setRegtime(Timestamp.valueOf(rs.getString("regtime")));
				user.setChargetime(Timestamp.valueOf(rs.getString("chargetime")));
				user.setFinishtime(Timestamp.valueOf(rs.getString("finishtime")));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.close();
		return list;
	}
	
	
	//根据预约号aid，查询预约信息
	public static User getUserByAid(String aid){
		String sql="select * from UserAppointment where aid='"+aid+"'";
		ResultSet rs=SQL.executeQuery(sql);
		User user=null;
		try {
			if(rs.next()){
				
		     
				user=new User();
				user.setAID(rs.getString("aid"));
				user.setID(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(Integer.parseInt(rs.getString("age")) );
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setAptime(Timestamp.valueOf(rs.getString("aptime")));
				Date now=new Date(System.currentTimeMillis());
				if(Timestamp.valueOf(rs.getString("aptime")).compareTo(now)>=0)
				{
					int i=1;
					user.setValid(i);
				}
				else
				{
					int i=0;
					user.setValid(i);	
				}
					
				//user.setRegtime(Timestamp.valueOf(rs.getString("time")));
				user.setDeptid(rs.getString("deptid"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL.close();
		return user;	
	}
	
	//根据身份证号id，查询一个用户的一组预约信息
		public static ArrayList getUserByid(String id){
			ArrayList list=new ArrayList();
			String sql="select * from UserAppointment where id='"+id+"'";
			ResultSet rs=SQL.executeQuery(sql);
			User user=null;
			try {
				while(rs.next()){
					user=new User();
					user.setMID(rs.getString("aid"));
					user.setID(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setSex(rs.getString("sex"));
					user.setAge(Integer.parseInt(rs.getString("age")) );
					user.setAddress(rs.getString("address"));
					user.setPhone(rs.getString("phone"));
					user.setAptime(Timestamp.valueOf(rs.getString("aptime")));
					user.setAge(Integer.parseInt(rs.getString("valid")) );
					user.setDeptid(rs.getString("deptid"));
					list.add(user);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SQL.close();
			return list;	
		}
		
		
//		public static Object[][] queryAp(String id)
//		{
//			Object[][] results=getApResult(UserSQL.getUserByid(id));
//			return results;
//			
//		}
//		
//		//将预约信息查询结果包装成Object[][],以用来绑定JTable
//		private static Object[][] getApResult(ArrayList list)
//		{
//			Object[][] resu=new Object[list.size()][5];
//			for(int i=0;i<list.size();i++)
//			{
//				User user=(User)list.get(i);
//				if(user.getValid()==1)
//				{
//				    resu[i][0]=user.getAID();
//					resu[i][1]=user.getName();
//					resu[i][2]=user.getSex();
//					resu[i][3]= Integer.toString(user.getAge());
//					resu[i][4]=SQL.executeQuery("select *from Dept where id='"+user.getDeptid()+"'");
//					//resu[i][5]=user.getAptime().toString();	
//				}	
//			}
//			return resu;
//		}
		
		public static Object[][] getApResult(String id)
		{
			ArrayList<User> list=new ArrayList<User>();
			String sql="select * from UserAppointment where id='"+id+"'";
			ResultSet rs=SQL.executeQuery(sql);
			User user=null;
			try {
				while(rs.next()){
					user=new User();
					user.setAID(rs.getString("aid"));
					user.setID(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setSex(rs.getString("sex"));
					user.setAge(Integer.parseInt(rs.getString("age")) );
					user.setAddress(rs.getString("address"));
					user.setPhone(rs.getString("phone"));
					user.setAptime(Timestamp.valueOf(rs.getString("aptime")));
					user.setValid(Integer.parseInt(rs.getString("valid")) );
					user.setDeptid(rs.getString("deptid"));
					list.add(user);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SQL.close();
			Object[][] resu=new Object[list.size()][6];
			for(int i=0;i<list.size();i++)
			{
				User user1=(User)list.get(i);
				if(user1.getValid()==1)
				{
			        resu[i][0]=user1.getAID();
				    resu[i][1]=user1.getName();
					resu[i][2]=user1.getSex();
					resu[i][3]=user1.getAge();
					String sql2="select * from Dept where id='"+user1.getDeptid()+"'";
					ResultSet rs2=SQL.executeQuery(sql2);
					try {
						if(rs2.next())
							resu[i][4]=user1.getDeptid()+rs2.getString("name");
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					resu[i][5]=user1.getAptime();
				}	
			} 
			return resu;
		}
		
		
	




public static Object[][] getDocList(String docid)
{
	ArrayList<User> list=new ArrayList<User>();
	String sql="select * from Doctor where id='"+docid+"'";
	ResultSet rs=SQL.executeQuery(sql);
	String l=null;
	try {
		if(rs.next())
			 l=rs.getString("list");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
    int length=l.length();
	int count=0;
	for(int i=0;i<length;i=i+12)
	{
		String usermid=l.substring(i, i+12);
		User u2=UserSQL.getUser(usermid);
		if(u2!=null)
			if(u2.getAptime()==null)
			list.add(u2);
	}
	Object[][] resu=new Object[list.size()][6];
	for(int i=0;i<list.size();i++)
	{
		User user1=(User)list.get(i);
		
		if(user1.getAptime()==null&&user1.getState()==1)
		{
	        resu[i][0]=user1.getMID();
		    resu[i][1]=user1.getName();
			resu[i][2]=user1.getSex();
			resu[i][3]=user1.getAge();
			resu[i][4]=user1.getRegtime();
		    resu[i][5]="正常";
		    count++;
		}
	}
		for(int i1=0;i1<list.size();i1++)
		{
			User user11=(User)list.get(i1);
			
			if(user11.getAptime()==null&&user11.getState()==11)
			{
		        resu[count][0]=user11.getMID();
			    resu[count][1]=user11.getName();
				resu[count][2]=user11.getSex();
				resu[count][3]=user11.getAge();
				resu[count][4]=user11.getRegtime();
			    resu[count][5]="已过号";
			    count++;
			}
				
			} 
	return resu;
	

}
public static Object[][] getDocApList(String docid)
{
	
ArrayList<User> list=new ArrayList<User>();
String sql="select * from Doctor where id='"+docid+"'";
ResultSet rs=SQL.executeQuery(sql);
String l=null;
try {
	if(rs.next())
		 l=rs.getString("list");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
	int length=l.length();
	for(int i=0;i<length;i=i+12)
	{
		String usermid=l.substring(i,i+12);
		User u2=UserSQL.getUser(usermid);
		if(u2!=null&&u2.getAptime()!=null)
				list.add(u2);
	
	}
	int count2=0;
	Object[][] resu=new Object[list.size()][7];
	for(int i=0;i<list.size();i++)
	{
		User user=(User)list.get(i);
		 Calendar now = Calendar.getInstance();  
		 int nh = now.get(Calendar.HOUR_OF_DAY);
	     int nm = now.get(Calendar.MINUTE);
	     int ns = now.get(Calendar.SECOND);  
		
		Date d=user.getAptime();
		Calendar c = Calendar.getInstance();              
        c.setTime(d);                                 
        int ah = c.get(Calendar.HOUR_OF_DAY);
        int am = c.get(Calendar.MINUTE);
        int as = c.get(Calendar.SECOND);  
        
        long l1=nh*3600+nm*60+ns;
        long l2=ah*3600+am*60+as;
        
      
		if(java.lang.Math.abs(l1-l2)<=3600&&user.getState()==1)
		{
	        resu[count2][0]=user.getMID();
		    resu[count2][1]=user.getName();
			resu[count2][2]=user.getSex();
			resu[count2][3]=user.getAge();
			resu[count2][4]=user.getRegtime();
			resu[count2][5]=user.getAptime();
			resu[count2][6]="可直接就诊";
			count2++;
		}
		
		
	
	}
	
	for(int i=0;i<list.size();i++)
	{
		User user=(User)list.get(i);
		 Calendar now = Calendar.getInstance();  
		 int nh = now.get(Calendar.HOUR_OF_DAY);
	     int nm = now.get(Calendar.MINUTE);
	     int ns = now.get(Calendar.SECOND);  
		
		Date d=user.getAptime();
		Calendar c = Calendar.getInstance();              
        c.setTime(d);                                 
        int ah = c.get(Calendar.HOUR_OF_DAY);
        int am = c.get(Calendar.MINUTE);
        int as = c.get(Calendar.SECOND);  
        
        long l1=nh*3600+nm*60+ns;
        long l2=ah*3600+am*60+as;
        
      
		if(java.lang.Math.abs(l1-l2)>3600&&user.getState()==1)
		{
	        resu[count2][0]=user.getMID();
		    resu[count2][1]=user.getName();
			resu[count2][2]=user.getSex();
			resu[count2][3]=user.getAge();
			resu[count2][4]=user.getRegtime();
			resu[count2][5]=user.getAptime();
			resu[count2][6]="等待";
			count2++;
		}
		}
	for(int i=0;i<list.size();i++)
	{
		User user=(User)list.get(i);
		 
		if(user.getState()==11)
		{
	        resu[count2][0]=user.getMID();
		    resu[count2][1]=user.getName();
			resu[count2][2]=user.getSex();
			resu[count2][3]=user.getAge();
			resu[count2][4]=user.getRegtime();
			resu[count2][5]=user.getAptime();
			resu[count2][6]="已过号";
			count2++;
			
		}
		}
	return resu;
}


public static Object[][] getChargedUser(String sql){
	ArrayList<User> list=new ArrayList<User>();
	ResultSet rs=SQL.executeQuery(sql);
	User user=null;

	try {
		while(rs.next()){
			
			user=new User();
			user.setMID(rs.getString("mid"));
			user.setID(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setAge(Integer.parseInt(rs.getString("age")) );
			user.setAddress(rs.getString("address"));
			user.setPhone(rs.getString("phone"));
			
			user.setDeptid(rs.getString("deptid"));
			user.setDocid(rs.getString("docid"));
			user.setDesc(rs.getString("desc"));
			user.setDiag(rs.getString("diag"));
		    if(rs.getString("chargeitem")!=null)
			user.setChargeitem(rs.getString("chargeitem"));
			if(rs.getString("cost")!=null)
			user.setCost(Float.parseFloat(rs.getString("cost")));
			if(rs.getString("state")!=null)
			user.setState(Integer.parseInt(rs.getString("state")));
			if(rs.getString("aptime")!=null)
			user.setAptime(Timestamp.valueOf(rs.getString("aptime")));
			else{user.setAptime(null);}
			if(rs.getString("regtime")!=null)
			user.setRegtime(Timestamp.valueOf(rs.getString("regtime")));
			if(rs.getString("chargetime")!=null)
			user.setChargetime(Timestamp.valueOf(rs.getString("chargetime")));
			if(rs.getString("finishtime")!=null)
			user.setFinishtime(Timestamp.valueOf(rs.getString("finishtime")));
			list.add(user);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SQL.close();
	Object[][] resu=new Object[list.size()][7];
	for(int i=0;i<list.size();i++)
	{
		User user1=(User)list.get(i);
		if(user1.getState()==2)
		{
	        resu[i][0]=user1.getMID();
		    resu[i][1]=user1.getName();
			resu[i][2]=user1.getSex();
			String sql2="select * from Dept where id='"+user1.getDeptid()+"'";
			ResultSet rs2=SQL.executeQuery(sql2);
			try {
				if(rs2.next())
					resu[i][3]=rs2.getString("name");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			String sql3="select * from Doctor where id='"+user1.getDocid()+"'";
			ResultSet rs3=SQL.executeQuery(sql3);
			try {
				if(rs3.next())
					resu[i][4]=rs3.getString("name");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			resu[i][5]="等待缴费";
		}	
	} 
	return resu;
}



}
