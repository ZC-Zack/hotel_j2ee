package com.xmut.hotel.serviceimp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.xmut.hotel.entity.Order;
import com.xmut.hotel.entity.Room;
import com.xmut.hotel.mapper.OrderMapper;
import com.xmut.hotel.mapper.RoomMapper;
import com.xmut.hotel.service.OrderService;
import com.xmut.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private HttpSession session;

    @Autowired
    private RoomMapper roomMapper;

    private JSONObject jsonObject;

    @Override
    public List<Order> getListOrderByExit(Integer usedExit) {
        return orderMapper.selectOrderByExit(usedExit);
    }

    @Override
    public JSONObject getJSONObjectMonth(){
        List<Order> list = orderMapper.getAllOrder();
        //
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        //Date date=new Date();
        int month;

        int season[] = new int[12];
        for(int i = 0; i < season.length; i++)
            season[i]=0;
        Integer money[] = new Integer[12];
        for(int i = 0;i < money.length;i++) {
            money[i] = 0;
        }

        try {
            for(int i = 0; i < list.size(); i++){
                Date date = formatter.parse(list.get(i).getInDate());
                cal.setTime(date);
                month = cal.get(Calendar.MONTH);
                for (int j = 0; j < 12; j++) {
                    if (month == j) {
                        season[j]++;
                        money[j] += list.get(j).getPrice();
                        break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //json对像
        //JSONObject resultJson=new JSONObject();
        //JSONArray jsonArray=new JSONArray();

        JSONObject jsonOject=new JSONObject();
        jsonOject.put("value",season);
        jsonOject.put("money",money);

        //jsonArray.add(jsonOject);
        //resultJson.put("chart1", jsonArray);
        //return resultJson;
        return jsonOject;
        /*JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        formatJSON(jsonArray);
        return jsonObject;*/
    }

    @Override
    public JSONObject getJSONObjectOrderByExit(Integer usedExit) {
        List<Order> list = getListOrderByExit(usedExit);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        formatJSON(jsonArray);
        return jsonObject;
    }

    @Override
    public int setOrder(JSONObject jsonObject) {
        Order order = JSON.toJavaObject(jsonObject, Order.class);
        String orderId = orderMapper.selectLastId();
        orderId = String.format("%04d", Integer.parseInt(orderId) + 1);
        order.setOrderId(orderId);
        order.setUsername((String) session.getAttribute("username"));
        order.setUsedExit(0);
        Room room = new Room();
        room.setRoomId(jsonObject.getString("roomId"));
        room.setRoomExit(1);
        roomMapper.updateRoomUsedById(room);
        return orderMapper.insertOrder(order);
    }

    @Override
    public int cancelOrder(JSONObject jsonObject) {
        Order order = JSON.toJavaObject(jsonObject, Order.class);
        return orderMapper.updateOrderUsedById(order);
    }

    @Override
    public int confirmOrder(JSONObject jsonObject) {
        Order order = JSON.toJavaObject(jsonObject, Order.class);
        order.setUsedExit(1);
        return orderMapper.updateOrderUsedById(order);
    }

    //格式化信息
    @Override
    public void formatJSON(JSONArray jsonArray) {
        jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", jsonArray.size());
    }
}
