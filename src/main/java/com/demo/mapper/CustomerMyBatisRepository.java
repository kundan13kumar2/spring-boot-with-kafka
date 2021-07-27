/*
package com.demo.mapper;

import com.demo.model.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface CustomerMyBatisRepository {

    @Select("select * from customer")
    public List<Customer> findAll();

    @Select("SELECT * FROM customer WHERE customer_id = #{customerId}")
    public Customer findById(int id);

    @Delete("DELETE FROM customer WHERE customer_id = #{customerId}")
    public int deleteById(int id);

    @Insert("INSERT INTO sakila.customer (customer_id,store_id,first_name,last_name,email,address_id,active) " +
            "VALUES (#{customerId}, #{storeId}, #{firstName}, #{lastName}, #{email}, #{addressId}, #{active})")
    public int insert(Customer customer);
}
*/
