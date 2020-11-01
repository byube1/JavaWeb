package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.myConnection;
import dto.item;

public class ProductDAO {
	public static String Login(String User, String pass) throws SQLException {
		String result = null;
		Connection cn = myConnection.makeConnection();
		if (cn != null) {
			String sql = "SELECT fullName FROM dbo.Userinfo WHERE userID = ? AND password = ?";
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, User);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString("fullName");
			}
			rs.close();
			cn.close();
			return result;
		}
		return result;
	}

	public static ArrayList<item> getProduct() throws SQLException {
		ArrayList<item> result = new ArrayList<item>();
		Connection cn = myConnection.makeConnection();
		if (cn != null) {
			String sql = "SELECT ID, Name,Descruption,Quantity,Price,Img FROM dbo.product";
			PreparedStatement pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ID = rs.getString("ID");
				String Name = rs.getString("Name");
				String Desc = rs.getString("Descruption");
				float Price = rs.getFloat("Price");
				int Quantity = rs.getInt("Quantity");
				String img = rs.getString("Img");
				item newItem = new item(ID, Name, Desc, Quantity, Price, img);
				result.add(newItem);
			}
			rs.close();
			pst.close();
			cn.close();

		}
		return result;
	}
	
	public static int deleteItem(String Code) throws SQLException {
		Connection cn = myConnection.makeConnection();
		int result=0;
		if(cn!=null) {
			String sql = "DELETE dbo.product WHERE ID = ?";			
			PreparedStatement pst = cn.prepareStatement(sql);		
			pst.setString(1,Code);
			result=pst.executeUpdate();
			cn.close();			
		}
		cn.close();
		return result;
	}
	
	public static int addItem(String ID, String Name, String Descruption, String Img,float Price,int Quantity) throws SQLException {
		Connection cn = myConnection.makeConnection();
		int result=0;
		if(cn!=null) {
			String sql = "INSERT INTO dbo.product( ID ,Name ,Descruption ,Quantity ,Price ,Img)VALUES  (?,?,?,?,?,?)";			
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1,ID);
			pst.setString(2,Name);
			pst.setString(3, Descruption);
			pst.setFloat(4,Price);
			pst.setInt(5,Quantity);		
			pst.setString(6,Img);
			result=pst.executeUpdate();
			cn.close();			
		}		
		return result;
	}	
	
	public static int updateProduct (String ID, String Name, String Descruption, String Img,float Price,int Quantity) throws SQLException {
		Connection cn = myConnection.makeConnection();
		int result=0;
		if(cn!=null) {
			String sql = "UPDATE dbo.product SET Name=?,Descruption=?,Quantity=?,Price=?,Img=? WHERE ID =?";			
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(6,ID);
			pst.setString(1,Name);
			pst.setString(2, Descruption);
			pst.setString(5,Img);
			pst.setFloat(4, Price);
			pst.setInt(3, Quantity);
			result=pst.executeUpdate();
			cn.close();			
		}
		return result;
	}
//	public static void main(String[] args) {
//		int a ;
//		try {
//			a = updateProduct("1", "asd", "asd", "asdww",22222, 3443);
//			System.out.println(a);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
