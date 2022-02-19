package com.tuling.seata.controller;


import com.tuling.seata.domin.Order;
import com.tuling.seata.service.IOrderService;
import com.tuling.seata.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public ResultVo create(Order order) {
        orderService.createOrder(order);

        ResultVo resultVo = new ResultVo();
        resultVo.setMsg("创建订单成功");
        resultVo.setSuccess(true);
        resultVo.setData("订单ID:"+order.getId());
        return resultVo;
    }

    /**
     * 获取所有的订单信息
     * @return
     */
    @GetMapping("/getAll")
    public String getAll(){
        List<Order> all = orderService.getAll();
        System.out.println("#####: " + all);
        return "success";
    }

    @GetMapping("/getOrderById")
    public String getOrderById(int id) {
        Order orderById = orderService.getOrderById(id);
        System.out.println("###: " + orderById);
        return "success";
    }


}

