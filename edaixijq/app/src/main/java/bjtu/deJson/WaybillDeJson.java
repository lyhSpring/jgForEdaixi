package bjtu.deJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import bjtu.model.Waybill;

public class WaybillDeJson {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX",Locale.CHINA);

    public Waybill deJson(String jsonStr){
        Waybill waybill = new Waybill();
        try{
            JSONObject jsonObject = new JSONObject(jsonStr);
            waybill.setId(jsonObject.getInt("id"));
            waybill.setSender_type(jsonObject.getString("sender_type"));
            waybill.setSender_id(jsonObject.getInt("sender_id"));
            waybill.setStatus(jsonObject.getInt("status"));
            waybill.setRecieve_id(jsonObject.getInt("recieve_id"));
            waybill.setExp_time(jsonObject.getString("exp_time"));
            waybill.setAct_time(jsonObject.getString("actual_time"));
            waybill.setWaybill_id(jsonObject.getInt("waybill_id"));
            waybill.setOrder_id(jsonObject.getInt("order_id"));
            waybill.setRecieve_type(jsonObject.getInt("recieve_type"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return waybill;
    }
}
