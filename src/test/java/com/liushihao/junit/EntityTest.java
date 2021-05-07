package com.liushihao.junit;

import com.liushihao.entity.Dish;
import com.liushihao.entity.User;
import org.junit.Test;

import java.util.ArrayList;

public class EntityTest {

    @Test
    public void getProperty() {
        ArrayList<Integer> integers = new ArrayList<>();
        Dish dish = new Dish(1, "dish", "dish1", 4);
        Integer name1test = dish.getName1test();
        integers.add(name1test);
    }

    @Test
    public void getEntityClass() {
        /*User user = new User();
        User user1 = new User();
        user.setAge(user1.getAge());
        System.out.println("==========" + user.getClass());
        System.out.println("user1.getAge() = " + user1.getAge());
        System.out.println("user = " + user);*/

        /*ArrayList<Object> list = new ArrayList<>();
        list.add(new User());
        list.add(null);
        User user2 = (User) list.get(0);
//        user2.setAge(8);
        User user3 = (User) list.get(1);
        if (null == user3 || null == user3.getAge()) {
            System.out.println("null == user3 || null == user3.getAge()");
        }*/

        User user1 = new User();
        user1.setId("001");
        user1.setUserName("刘世豪");
        user1.setAge(null);
        System.out.println("前 = " + user1);
        user1 = changeUser();
        System.out.println("后 = " + user1);
    }

    private User changeUser(){
        User user = new User();
        user.setAge(18);
        return user;
    }
}
