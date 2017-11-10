package blueleaf.giftregistry.webservice;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import blueleaf.giftregistry.DbAccess.DBConnector;
import blueleaf.giftregistry.model.UserInfo;
import blueleaf.giftregistry.services.UserInfoService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;

@Path("/customerdetails")
public class CustomerDetailsService {

   UserInfoService us=new UserInfoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserInfo> getAllUsers(@QueryParam("name") String name)
	{
	   return us.getAllUsers();
	}
	
	@Path("/updateInfo/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserInfo updateUserInfo(UserInfo newInfo)
	{
		if(newInfo.getUserID()==0){
			return null;
		}
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfo updatedUser=db.updateUser(con, newInfo);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedUser;
	}
	
	
	@Path("/{emailID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getUser(@PathParam("emailID") String emailID) {
		
		return us.getUser(emailID);
	}
	
	
	
}
