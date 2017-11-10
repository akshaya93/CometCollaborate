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
import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

@Path("/registryproductmapper")
public class RegistryProductMappingService {
	
	@Path("/addproduct/{registryID}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status addProductToRegistry(@PathParam("registryID") String regID,Product p)
	{
		Status s=new Status();
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean success=db.addProductToRegistry(con,regID,p);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;
	}

	
	@Path("/deleteproduct/{registryID}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status deleteProductFromRegistry(@PathParam("registryID") String regID,Product p)
	{
		Status s=new Status();
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean success=db.deleteProductFromRegistry(con,regID,p);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;
	}
	
	
	@Path("/allproducts/{registryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProductsOfRegistry(@PathParam("registryID") String regID) throws SQLException
	{
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Product> l=db.getAllProductsOfRegistry(con,regID);
		return l;
	}
	
	@Path("/shareprivateregistry/{buyerUserID}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status deleteProductFromRegistry(@PathParam("buyerUserID") int buyerUserID,Registry r)
	{
		Status s=new Status();
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean success=db.shareRegistry(con,buyerUserID,r);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;
	}
	
	@Path("/markregistrypublic/{registryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status markRegistryPublic(@PathParam("registryID") int registryID)
	{
		Status s=new Status();
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean success=db.markRegistryPublic(con,registryID);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;
	}
	
	@Path("/deleteallprivateregistrymapping/{registryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteAllPrivateRegistryMapping(@PathParam("registryID") int registryID)
	{
		Status s=new Status();
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean success=db.deleteAllPrivateRegistryMapping(con,registryID);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;
	}
	
	
	@Path("/getallsharedregistries/{userID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Registry> getAllSharedRegistry(@PathParam("userID") int userID)
	{
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Registry> lr=db.getAllSharedRegistry(con,userID);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lr;
	}
}
