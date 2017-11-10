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
import blueleaf.giftregistry.model.Category;
import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

@Path("/productmanagement")
public class ProductManagementService {

	
	@Path("/getbrands")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Brand> lb=db.getBrands(con);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lb;
	}
	
	@Path("/getcategories")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategories(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Category> lc=db.getCategory(con);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lc;
	}
	
	@Path("/addproduct/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status addProduct(Product prod)
	{
        Status s=new Status();
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		Product np=db.addProduct(con, prod);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(np.getProductID()!=0){
		s.setCode(100);
		s.setMessage("Success");
		}
		return s;
	}
	
	@Path("/deleteproduct/{productID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteProduct(@PathParam("productID") String productID) {
        Status s=new Status();
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean success=db.deleteProduct(con, productID);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success){
		s.setCode(100);
		s.setMessage("Success");
		}
		return s;
	}
	
	
	@Path("/allproducts/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts()
	{
	    DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Product> lp=db.getAllProducts(con);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lp;
	}
	
}
