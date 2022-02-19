package com.tuling.seata.mapper;

import com.tuling.seata.domin.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by smlz on 2019/12/9.
 */
@Mapper
public interface OrderMapper {

    int saveOrder(Order order);

    int updateOrderStatusById(@Param("orderId") Integer orderId,@Param("status") Integer orderStatus);

    List<Order> getAll();

    Order getOrderById(int id);

}
