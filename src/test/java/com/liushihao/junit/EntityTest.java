package com.liushihao.junit;

import com.liushihao.entity.User;
import org.junit.Test;

public class EntityTest {

    @Test
    public void getEntityClass() {
        User user = new User();
        User user1 = new User();
        user.setAge(user1.getAge());
        System.out.println("==========" + user.getClass());
        System.out.println("user1.getAge() = " + user1.getAge());
        System.out.println("user = " + user);
    }
}
