package bjtu.controller;

import java.util.ArrayList;
import java.util.List;

import bjtu.deJson.FactoryDeJson;
import bjtu.model.Factory;
import bjtu.network.HttpClient;
import bjtu.util.Config;

/**
 * Created by 李奕杭_lyh on 2017/5/16.
 */

public class FactoryController {
    private HttpClient httpClient = new HttpClient();
    private FactoryDeJson factoryDeJson = new FactoryDeJson();

    public Factory login(String mobile,String password){
        List<Factory> list = new ArrayList<>();
        String url= Config.developmentHost+"/factories/login?factory[mobile]="+mobile+"&factory[password]="+password;
        String method = "GET";
        String result = httpClient.doPost(url,method);
        list = factoryDeJson.json2List(result);
        return list.get(0);
    }
}
