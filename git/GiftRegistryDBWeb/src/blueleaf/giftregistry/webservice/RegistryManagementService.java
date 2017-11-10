package blueleaf.giftregistry.webservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import blueleaf.giftregistry.DbAccess.DBConnector;
import blueleaf.giftregistry.model.Brand;
import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.Status;

@Path("/registrymanagement")
public class RegistryManagementService {
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Registry addRegistry(Registry r){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		Registry nr=db.addRegistry(con,r);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nr;
	}
	
	@Path("/getallregistry/{userID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Registry> getAllUserRegistry(@PathParam("userID") String userID){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Registry> lr=db.getUserRegistry(con,userID);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lr;
		
	}
	
	@Path("/delete/{registryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteRegistry(@PathParam("registryID") String registryID){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		Status s=new Status();
		boolean b=db.deleteRegistry(con,registryID);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(b){
			s.setMessage("Success");
			s.setCode(100);
		}
		return s;
	}


}
