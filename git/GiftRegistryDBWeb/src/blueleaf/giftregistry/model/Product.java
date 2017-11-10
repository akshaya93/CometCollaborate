package blueleaf.giftregistry.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	long productID;
	String productName;
	float price;
	String imageURL;
	int rating;
	int certification;
	int brandID;
	int categoryID;
	String brandName="";
	String categoryName="";
	public Product(){
	}
	public Product(long productID, String productName, float price, String imageURL, int rating, int certification,
			int brandID, int categoryID, String brandname, String category) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.imageURL = imageURL;
		this.rating = rating;
		this.certification = certification;
		this.brandID = brandID;
		this.categoryID = categoryID;
		this.brandName = brandname;
		this.categoryName = category;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getCertification() {
		return certification;
	}
	public void setCertification(int certification) {
		this.certification = certification;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getBrandname() {
		return brandName;
	}
	public void setBrandname(String brandname) {
		this.brandName = brandname;
	}
	public String getCategory() {
		return categoryName;
	}
	public void setCategory(String category) {
		this.categoryName = category;
	}
	
}