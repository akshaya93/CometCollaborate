package blueleaf.giftregistry.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Registry {
	int registryType; //0-private 1-public registry
    int userID;
	int registryID;
	String registryName;

	public Registry(){
		
	}
	public Registry(int registryID,int registryType, int userID,String registryName) {
		this.registryType = registryType;
		this.userID = userID;
		this.registryID = registryID;
		this.registryName=registryName;
	}
	public String getRegistryName() {
		return registryName;
	}
	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}
	
	public int getRegistryID() {
		return registryID;
	}
	public void setRegistryID(int registryID) {
		this.registryID = registryID;
	}
	public int getRegistryType() {
		return registryType;
	}
	public void setRegistryType(int registryType) {
		this.registryType = registryType;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
