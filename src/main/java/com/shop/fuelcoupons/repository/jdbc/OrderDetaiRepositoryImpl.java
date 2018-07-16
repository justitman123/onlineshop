package com.shop.fuelcoupons.repository.jdbc;

import com.shop.fuelcoupons.model.OrderDetail;
import com.shop.fuelcoupons.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class OrderDetaiRepositoryImpl implements OrderDetailRepository {

    private static final RowMapper<OrderDetail> ROW_MAPPER = BeanPropertyRowMapper.newInstance(OrderDetail.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertOrderDetail;

    @Autowired
    public OrderDetaiRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertOrderDetail = new SimpleJdbcInsert(dataSource)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    @Transactional
    public OrderDetail save(OrderDetail orderDetail, int orderId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", orderDetail.getId())
                .addValue("amount", orderDetail.getAmount())
                .addValue("fuel_name", orderDetail.getFuelName())
                .addValue("quantity", orderDetail.getQuantity())
                .addValue("order_id", orderId);
        if (orderDetail.isNew()) {
            Number newId = insertOrderDetail.executeAndReturnKey(map);
            orderDetail.setId(newId.intValue());
        } else {
            if (namedParameterJdbcTemplate.update("UPDATE order_details " +
                            "SET amount=:amount, fuel_name=:fuelName, quantity=:quantity, order_id=:orderId " +
                            "WHERE id=:id AND order_id=:order_id", map) == 0) {
                return null;
            }
        }
        return orderDetail;
    }

    @Override
    @Transactional
    public boolean delete(int id, int orderId) {
        return jdbcTemplate.update("DELETE FROM order_details WHERE id=? AND order_id=?", id, orderId) != 0;
    }

    @Override
    public OrderDetail get(int id, int orderId) {
        List<OrderDetail> carts = jdbcTemplate.query(
                "SELECT * FROM order_details WHERE id = ? AND order_id = ?", ROW_MAPPER, id, orderId);
        return DataAccessUtils.singleResult(carts);
    }

    @Override
    public List<OrderDetail> getAll(int orderId, int userId) {
        return jdbcTemplate.query(
                "SELECT * " +
                        "FROM order_details AS s " +
                        "RIGHT JOIN orders q ON s.order_id =? " +
                        "WHERE q.user_id=? AND q.id =?", ROW_MAPPER, orderId, userId, orderId);
    }
}
