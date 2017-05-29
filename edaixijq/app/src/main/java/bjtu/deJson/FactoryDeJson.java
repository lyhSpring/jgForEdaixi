package bjtu.deJson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bjtu.model.Factory;

public class FactoryDeJson {

    public Factory deJson(String jsonStr){
        Factory factory = new Factory();
        try{
            JSONArray jsonArray = new JSONArray(jsonStr);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            factory.setId(jsonObject.getInt("id"));
            factory.setFactory_name(jsonObject.getString("factory_name"));
            factory.setMobile(jsonObject.getString("mobile"));
            factory.setStatus(jsonObject.getInt("status"));
            factory.setEmail(jsonObject.getString("email"));
            factory.setPassword(jsonObject.getString("password"));
            factory.setStation_id(jsonObject.getInt("station_id"));
            factory.setRegion_id(jsonObject.getInt("region_id"));
        }catch (Exception e){
            e.printStackTrace();
        }

        return factory;
    }

    public List<Factory> json2List(String jsonStr){
        List<Factory> list = new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(jsonStr);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                Factory factory = new Factory();
                factory.setId(jsonObject.getInt("id"));
                factory.setFactory_name(jsonObject.getString("factory_name"));
                factory.setMobile(jsonObject.getString("mobile"));
                factory.setStatus(jsonObject.getInt("status"));
                factory.setEmail(jsonObject.getString("email"));
                factory.setPassword(jsonObject.getString("password"));
                factory.setStation_id(jsonObject.getInt("station_id"));
                factory.setRegion_id(jsonObject.getInt("region_id"));
                list.add(factory);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
