package bjtu.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bjtu.adapter.OrderListViewAdapter;
import bjtu.controller.OrderController;
import bjtu.model.Order;

public class WaitingActivity extends AppCompatActivity {
    //申明控件
    private TextView hintTextView;
    private ListView orderListJGView;

    private OrderController orderController = new OrderController();
    private List<Order> dataList = new ArrayList<>();
    private OrderListViewAdapter adapter ;

    private int factory_id = 0;
    private String region = "海淀区";
    private int region_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        Intent intent = this.getIntent();
        factory_id = intent.getIntExtra("userID",0);

        //初始化控件
        hintTextView = (TextView) findViewById(R.id.hintForNoOrders);
        orderListJGView = (ListView) findViewById(R.id.orderListQSView);
        //获取订单数据
        Runnable getOrdersTask = new Runnable() {
            @Override
            public void run() {
                dataList = orderController.getOrdersByStatus(factory_id);
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        };
        Thread getOrdersThread = new Thread(getOrdersTask);
        getOrdersThread.start();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0: //显示提示      清洗完成
                    Toast.makeText(WaitingActivity.this,"清洗完成",Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                    break;
                case 1:
                    //显示界面中的控件
                    if(dataList.size() <= 0){
                        hintTextView.setVisibility(View.VISIBLE);
                        orderListJGView.setVisibility(View.INVISIBLE);
                    }else{
                        adapter = new OrderListViewAdapter(WaitingActivity.this,dataList);
                        orderListJGView.setAdapter(adapter);
                        orderListJGView.setOnItemClickListener(new orderListJGItemClickListener());
                    }
                    break;
            }
        }
    };

    class orderListJGItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            //修改和补充订单、运单的信息
            Runnable modifyInfoTask = new Runnable() {
                @Override
                public void run() {
                    //清洗完成，修改订单信息和运单信息,创建新的运单
                    orderController.washing2Finished(dataList.get(position),factory_id);
                    Message msg = new Message();
                    msg.what = 0;
                    handler.sendMessage(msg);
                }
            };
            Thread modifyInfoThread = new Thread(modifyInfoTask);
            modifyInfoThread.start();
        }
    }
}
