package model;

/**
 * Created by junhan on 2016/9/10.
 */
public class Person<T> {

    private String name;
    private String address;
    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void privateMethod() {

    }
}
