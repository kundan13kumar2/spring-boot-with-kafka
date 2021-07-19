package com.demo.mapper;

import com.demo.model.Order;
import com.demo.model.Retry;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface RetryMyBatisRepository {

    @Select("select * from retry")
    public List<Order> findAll();

    @Select("SELECT * FROM retry WHERE id = #{eventId}")
    public Order findById(int id);

    @Delete("DELETE FROM retry WHERE id = #{eventId}")
    public int deleteById(int id);

    @Insert("INSERT INTO db_example.retry(event_id, name) " +
            " VALUES (#{eventId}, #{name})")
    public int insert(Retry retry);
}
