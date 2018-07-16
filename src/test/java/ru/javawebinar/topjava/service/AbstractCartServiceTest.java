package ru.javawebinar.topjava.service;

import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.service.CartService;
import com.shop.fuelcoupons.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static ru.javawebinar.topjava.CartTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

public abstract class AbstractCartServiceTest extends AbstractServiceTest {

    @Autowired
    protected CartService service;

    @Test
    public void deleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(CART1_ID, 1);
    }

    @Test
    public void getNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(CART1_ID, ADMIN_ID);
    }

    @Test
    public void update() throws Exception {
        Cart updated = getUpdated();
        service.update(updated, USER_ID);
        assertMatch(service.get(CART1_ID, USER_ID), updated);
    }

    @Test
    public void updateNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=" + CART1_ID);
        service.update(CART1, ADMIN_ID);
    }
}