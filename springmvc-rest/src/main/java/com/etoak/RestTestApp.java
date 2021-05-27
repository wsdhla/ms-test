package com.etoak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class RestTestApp {
    public static void main(String[] args) {
        SpringApplication.run(RestTestApp.class, args);
    }
}


@RestController()
class OrderController {
    private int orderNo;
    private List<OrderEntity> orderList = new ArrayList<>();

    /**
     * 增加
     * @param bo
     * @return
     */
    //@RequestMapping(value = "order", method = {RequestMethod.POST})
    @PostMapping("order")
    public List<OrderEntity> addOrder(@RequestBody OrderEntity bo) {

        if (orderList.indexOf(bo) < 0) {
            bo.setId(UUID.randomUUID().toString());
            bo.setOrderNo(++orderNo);
            orderList.add(bo);
        }

        return orderList;
    }

    /**
     * 删除
     * @param orderNo
     * @return
     */
    //@RequestMapping(value = "order/{orderNo}", method = {RequestMethod.DELETE})
    @DeleteMapping("order/{orderNo}")
    public List<OrderEntity> delOrder(@PathVariable int orderNo) {
        orderList.remove(new OrderEntity(orderNo));

        return orderList;
    }

    /**
     * 修改
     * @param bo
     * @return
     */
    //@RequestMapping(value = "order", method = {RequestMethod.PUT})
    @PutMapping("order")
    public List<OrderEntity> modifyOrder(@RequestBody OrderEntity bo) {
        int idx = orderList.indexOf(bo);
        if (idx > -1) {
            String id = orderList.get(idx).getId();
            orderList.remove(bo);
            bo.setId(id);
            orderList.add(bo);
        }
        return orderList;
    }

    /**
     * 查询
     * @param orderNo
     * @return
     */
    //@RequestMapping(value = "order/{orderNo}", method = {RequestMethod.GET})
    @GetMapping(value = "order/{orderNo}")
    public OrderEntity getOrderInfo(@PathVariable int orderNo) {
        int idx = orderList.indexOf(new OrderEntity(orderNo));
        if (idx > -1) {
            return orderList.get(idx);
        }
        return null;
    }


    /**
     * 查询列表
     * @return
     */
    //@RequestMapping(value = "orders", method = {RequestMethod.GET})
    @GetMapping(value = "orders")
    public List<OrderEntity> getOrderList() {
        return orderList;
    }
}

class OrderEntity {
    /**
     * 唯一标识
     */
    private String id;

    /**
     * 订单编号
     */
    private int orderNo;

    /**
     * 订单内容
     */
    private String orderContent;

    public OrderEntity(String id, int orderNo, String orderContent) {
        this.id = id;
        this.orderNo = orderNo;
        this.orderContent = orderContent;
    }

    public OrderEntity(int orderNo) {
        this.orderNo = orderNo;
    }

    public OrderEntity() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }


    @Override
    public int hashCode() {
        return String.valueOf(this.orderNo).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return String.valueOf(this.orderNo).equals(String.valueOf(((OrderEntity)obj).orderNo));
    }
}
