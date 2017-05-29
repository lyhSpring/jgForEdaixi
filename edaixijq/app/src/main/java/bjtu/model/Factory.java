package bjtu.model;

public class Factory {
    private int id;
    private String factory_name;
    private String mobile;
    private int status;
    private String email;
    private String password;
    private int station_id;
    private int region_id;
    private String role = "jg";

    public int getId() {
        return id;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public String getMobile() {
        return mobile;
    }

    public int getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getStation_id() {
        return station_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public String getRole(){return role; }

    public void setId(int id) {
        this.id = id;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public void setRole(String role) { this.role = role; }
}
