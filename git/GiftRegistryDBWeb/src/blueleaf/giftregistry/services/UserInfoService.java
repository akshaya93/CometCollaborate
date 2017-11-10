package blueleaf.giftregistry.services;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import blueleaf.giftregistry.DbAccess.DBConnector;
import blueleaf.giftregistry.model.UserInfo;

public class UserInfoService {

	public List<UserInfo> getAllUsers(){
		DBConnector db=new DBConnector();
		Connection conn=db.getConnection();
	    List<UserInfo> lu= db.getAllUserInfo(conn);
	    try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return lu; 
	}

	public UserInfo getUser(String emailID) {
		// TODO Auto-generated method stub
		DBConnector db=new DBConnector();
		Connection conn=db.getConnection();
	    UserInfo uI= db.getUserInfo(conn,emailID);
	    try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return uI; 
	}

}
