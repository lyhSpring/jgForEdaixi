package bjtu.model;

/**
 * Created by 李奕杭_lyh on 2017/5/20.
 */

public class Waybill {
    private int id;
    private String sender_type;
    private int sender_id;
    private int status;
    private int recieve_id;
    private String exp_time;
    private String act_time;
    private int waybill_id;
    private int order_id;
    private int recieve_type;

    public int getId() {
        return id;
    }

    public String getSender_type() {
        return sender_type;
    }

    public int getSender_id() {
        return sender_id;
    }

    public int getStatus() {
        return status;
    }

    public int getRecieve_id() {
        return recieve_id;
    }

    public String getExp_time() {
        return exp_time;
    }

    public String getAct_time() {
        return act_time;
    }

    public int getWaybill_id() {
        return waybill_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getRecieve_type() {
        return recieve_type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSender_type(String sender_type) {
        this.sender_type = sender_type;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRecieve_id(int recieve_id) {
        this.recieve_id = recieve_id;
    }

    public void setExp_time(String exp_time) {
        this.exp_time = exp_time;
    }

    public void setAct_time(String act_time) {
        this.act_time = act_time;
    }

    public void setWaybill_id(int waybill_id) {
        this.waybill_id = waybill_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setRecieve_type(int recieve_type) {
        this.recieve_type = recieve_type;
    }
}
