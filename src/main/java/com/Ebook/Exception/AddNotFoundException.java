package com.Ebook.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class AddNotFoundException extends RuntimeException {
private static final long serialVersionUID = 1L;
private String resourceName;
private Object addId;
public AddNotFoundException(String resourceName, Object id) {
super(String.format("%s not found with %s", resourceName, id));
this.resourceName = resourceName;
this.addId = id;
}
public String getResourceName() {
return resourceName;
}

public Object getAddId() {
return addId;
}





}
