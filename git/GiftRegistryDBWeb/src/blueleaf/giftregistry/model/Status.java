package blueleaf.giftregistry.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {
String message;
int code;
public Status(){
	code=200;
	message="Failed";
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}

}
