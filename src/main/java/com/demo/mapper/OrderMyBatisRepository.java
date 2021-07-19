package com.demo.mapper;

import com.demo.model.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface OrderMyBatisRepository {

    @Select("select * from order")
    public List<Order> findAll();

    @Select("SELECT * FROM order WHERE id = #{orderId}")
    public Order findById(int id);

    @Delete("DELETE FROM order WHERE id = #{orderId}")
    public int deleteById(int id);

    @Insert("INSERT INTO db_example.order (order_id, value) VALUES (#{orderId}, #{value})")
    public int insert(Order order);

}
