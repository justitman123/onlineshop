package ru.javawebinar.topjava.web;

import com.shop.fuelcoupons.model.User;
import com.shop.fuelcoupons.util.exception.NotFoundException;
import com.shop.fuelcoupons.web.user.AdminAjaxController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.repository.mock.InMemoryUserRepositoryImpl;

import java.util.Collection;

import static ru.javawebinar.topjava.UserTestData.ADMIN;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml"})
@RunWith(SpringRunner.class)
public class InMemoryAdminRestControllerSpringTest {

    @Autowired
    private AdminAjaxController controller;

    @Autowired
    private InMemoryUserRepositoryImpl repository;

    @Before
    public void setUp() throws Exception {
        repository.init();
    }
}
