package bjtu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import bjtu.activity.R;
import bjtu.model.Order;

public class OrderListViewAdapter extends MyBaseAdapter{
    private List<Order> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public OrderListViewAdapter(Context context, List<Order> data) {
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);

        this.imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // 实例化组件
        // 这里的R.java文件要引用自己的R.java，引用系统的R文件找不到自定义的布局文件
        convertView = layoutInflater.inflate(R.layout.order_item_ptjg, null);
        ImageView orderStatusImg = (ImageView) convertView.findViewById(R.id.orderImg);
        TextView orderId = (TextView)  convertView.findViewById(R.id.orderId);
        TextView orderStatus = (TextView) convertView.findViewById(R.id.orderStatus);
        TextView orderExpTime = (TextView) convertView.findViewById(R.id.expTime);
        TextView orderFromAddress = (TextView) convertView.findViewById(R.id.orderLoc);

        if(data.get(position).getStatus() == 1 || data.get(position).getStatus() == 5){
            orderStatus.setText("待抢单");
        }else if(data.get(position).getStatus() == 4){
            orderStatus.setText("清洗中");
        }
        orderId.setText(String.valueOf(data.get(position).getId()));
        orderExpTime.setText(data.get(position).getWaybill().getExp_time());
        orderFromAddress.setText(data.get(position).getAddress());

        //这里没有监听异步加载图片出错的原因
        imageLoader.displayImage("http://ons52g6mv.bkt.clouddn.com/order_item.png",orderStatusImg,options);
        return convertView;
    }
}
