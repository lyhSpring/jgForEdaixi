package bjtu.model;

public class Order {
    private int id;
    private int courier_id;
    private int washing_status;
    private int factory_id;
    private int waybill_id;
    private int voucher_status;
    private int categories_id;
    private int status;
    private int address_id;
    private String address = "beijinghaidian";
    private int total_price;
    private int user_id;
    private int act_pay;
    private Waybill waybill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public int getWashing_status() {
        return washing_status;
    }

    public void setWashing_status(int washing_status) {
        this.washing_status = washing_status;
    }

    public int getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(int factory_id) {
        this.factory_id = factory_id;
    }

    public int getWaybill_id() {
        return waybill_id;
    }

    public void setWaybill_id(int waybill_id) {
        this.waybill_id = waybill_id;
    }

    public int getVoucher_status() {
        return voucher_status;
    }

    public void setVoucher_status(int voucher_status) {
        this.voucher_status = voucher_status;
    }

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAct_pay() {
        return act_pay;
    }

    public void setAct_pay(int act_pay) {
        this.act_pay = act_pay;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }
}
