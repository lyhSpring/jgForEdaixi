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

public class OrderActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_order);

        Intent intent = this.getIntent();
        factory_id = intent.getIntExtra("userID",0);

        //初始化控件
        hintTextView = (TextView) findViewById(R.id.hintForNoOrders);
        orderListJGView = (ListView) findViewById(R.id.orderListQSView);

        //获取已经完成清洗工作的订单
        Runnable getOrdersInFactory = new Runnable() {
            @Override
            public void run() {
                dataList = orderController.getOrdersByFactoryId(factory_id);
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        };
        Thread getOrdersInFactoryThread = new Thread(getOrdersInFactory);
        getOrdersInFactoryThread.start();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0: //显示提示      清洗完成
                    Toast.makeText(OrderActivity.this,"你点击了。。。。",Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                    break;
                case 1:
                    //当订单列表数据不为空时，显示界面中的控件
                    if(dataList.size() <= 0){
                        hintTextView.setVisibility(View.VISIBLE);
                        orderListJGView.setVisibility(View.INVISIBLE);
                    }else{
                        adapter = new OrderListViewAdapter(OrderActivity.this,dataList);
                        orderListJGView.setAdapter(adapter);
                        orderListJGView.setOnItemClickListener(new myListItemOnClickListener());
                    }
                    break;
            }
        }
    };

    class myListItemOnClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Message msg = new Message();
            msg.what = 0;
            handler.sendMessage(msg);
        }
    }
}
