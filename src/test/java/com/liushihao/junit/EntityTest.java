package com.liushihao.junit;

import com.liushihao.entity.User;
import org.junit.Test;

public class EntityTest {

    @Test
    public void getEntityClass() {
        User user = new User();
        System.out.println("==========" + user.getClass());
    }
}
