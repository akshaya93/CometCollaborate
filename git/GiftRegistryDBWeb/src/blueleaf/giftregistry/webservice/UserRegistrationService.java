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

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/registeruser")
public class UserRegistrationService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserInfo addUser(UserInfo newUser)
	{
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfo addedUser=db.addUser(con, newUser);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addedUser;
	}
	
	@Path("/newuser/{email}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String checkOldUser(@PathParam("email") String email) {
		String oldUser="true";
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfo addedUser=db.checkNewUser(con,email);
		if(addedUser.getUserID()==0){
			oldUser="false";
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oldUser;
	}
	
	
}
