package account;

import java.util.Date;

public class User {
    private String id;
    private String name;
    private String address;
    private String phone;
    private Date dateTime;

    public User(String id, String name, String address,
                String phone, Date dateTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.dateTime = dateTime;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

}
