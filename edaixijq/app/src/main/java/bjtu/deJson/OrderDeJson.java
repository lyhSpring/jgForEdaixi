package bjtu.deJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bjtu.model.Order;

public class OrderDeJson {


    public List<Order> deJson(String jsonStr){
        List<Order> list = new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(jsonStr);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Order order = new Order();
                order.setId(jsonObject.getInt("id"));
                order.setCourier_id(jsonObject.getInt("courier_id"));
                order.setWashing_status(jsonObject.getInt("washing_status"));
                order.setFactory_id(jsonObject.getInt("factory_id"));
                order.setWaybill_id(jsonObject.getInt("waybill_id"));
                order.setVoucher_status(jsonObject.getInt("voucher_status"));
                order.setCategories_id(jsonObject.getInt("categories_id"));
                order.setStatus(jsonObject.getInt("status"));
                order.setAddress_id(jsonObject.getInt("address_id"));
                order.setTotal_price(jsonObject.getInt("totalprice"));
                order.setUser_id(jsonObject.getInt("user_id"));
                list.add(order);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return list;
    }
}
