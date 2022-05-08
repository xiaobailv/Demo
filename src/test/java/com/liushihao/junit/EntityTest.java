package com.liushihao.junit;

import com.liushihao.entity.Dish;
import com.liushihao.entity.Log;
import com.liushihao.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntityTest {

    @Test
    public void forAddList() {
        ArrayList<Log> logs = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Log log = new Log();
            log.setId("" + i);
            logs.add(log);
        }
        for (Log log1 : logs) {
            System.out.println("log1 = " + log1);
        }
    }

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

    private User changeUser() {
        User user = new User();
        user.setAge(18);
        return user;
    }

    private Object getObject (Object object) {
        if (object.getClass().getName().equals("java.util.List")) {
            return object;
        } else {
            return new HashMap<>();
        }
    }

    @Test
    public void getObj() {
        List<Object> objects = new ArrayList<>();
        Object object = getObject(objects);
        System.out.println("object.getClass() = " + object.getClass());
        System.out.println(object instanceof ArrayList);
    }
}
