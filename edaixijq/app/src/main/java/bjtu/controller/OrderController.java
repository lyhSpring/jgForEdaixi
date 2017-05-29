package bjtu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bjtu.deJson.OrderDeJson;
import bjtu.deJson.WaybillDeJson;
import bjtu.model.Order;
import bjtu.model.Waybill;
import bjtu.network.HttpClient;
import bjtu.util.Config;

public class OrderController {
    private HttpClient httpClient = new HttpClient();
    private OrderDeJson orderDeJson = new OrderDeJson();
    private WaybillDeJson waybillDeJson = new WaybillDeJson();

    //获取正在清洗的订单
    public List<Order> getOrdersByStatus(int factory_id){
        List<Order> orderList = new ArrayList<>();
        String method = "GET";
        //获取订单部分的信息 status = 1
        String orderUrl1 = Config.developmentHost+"orders/getOrdersByFactoryId?order[status]=4&order[factory_id]="+factory_id;

        String result1 = httpClient.doPost(orderUrl1,method);
        orderList = orderDeJson.deJson(result1);
        //根据order_id获取订单对应运单部分的信息
        for (int i=0;i<orderList.size();i++){
            String waybillUrl = Config.developmentHost+"waybills/getWaybillByStatus?waybill[order_id]="+orderList.get(i).getId()
                    +"&waybill[recieve_type]=3";
            httpClient.setResult("");
            String waybillResult = httpClient.doPost(waybillUrl,"GET");
            Waybill waybill = waybillDeJson.deJson(waybillResult);
            orderList.get(i).setWaybill(waybill);
        }
        return orderList;
    }

    //清洗完成      修改和补充订单、运单的信息
    public void washing2Finished(Order order,int factory_id){
        Date currTime = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currTime);
        cal.add(Calendar.HOUR_OF_DAY,2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String exp_time = sdf.format(cal.getTime());
        String modifyMethod = "PUT";
        String createMethod = "POST";

        //修改订单--factory_id,status=>下一个状态
        String modifyOrderUrl = Config.developmentHost+"/orders/"+order.getId()+"?order[status]=5";
        httpClient.doPost(modifyOrderUrl,modifyMethod);
        System.out.print("-------------------------"+modifyOrderUrl);
        //修改运单--status=>下一个状态，actual_time
        String modifyWaybillUrl = Config.developmentHost+"/waybills/"+order.getWaybill().getId()+"?waybill[status]=4";
        httpClient.doPost(modifyWaybillUrl,modifyMethod);

        //创建新的运单，该订单可以由快递员抢单取送
        String createWaybillUrl = Config.developmentHost+"/waybills?waybill[sender_type]=3&waybill[sender_id]="+factory_id
                +"&waybill[status]=5&waybill[exp_time]="+exp_time
                +"&waybill[order_id]="+order.getId()
                +"&waybill[recieve_type]=1";
        httpClient.doPost(createWaybillUrl,createMethod);
    }

    //获取清洗完成的订单
    public List<Order> getOrdersByFactoryId(int factory_id){
        List<Order> orderList = new ArrayList<>();
        //获取订单部分的信息
        String orderUrl = Config.developmentHost+"orders/getOrdersByFactoryId?order[status]=5&order[factory_id]="+factory_id;
        String method = "GET";
        String result = httpClient.doPost(orderUrl,method);
        orderList = orderDeJson.deJson(result);
        //根据order_id status recieve_type获取订单对应运单部分的信息
        for (int i=0;i<orderList.size();i++){
            String waybillUrl = Config.developmentHost+"/waybills/getWaybillByStatusAndId?waybill[order_id]="+orderList.get(i).getId()
                    +"&waybill[status]=5&waybill[recieve_type]=1";
            String waybillResult = httpClient.doPost(waybillUrl,"GET");
            Waybill waybill = waybillDeJson.deJson(waybillResult);
            orderList.get(i).setWaybill(waybill);
        }
        return orderList;
    }

}
