package com.liushihao.junit;

import com.liushihao.entity.ShareVariable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/12/15 10:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestShareVariable {

    @Autowired
    private ShareVariable shareVariable;

    @Test
    public void share() {

        Integer num = shareVariable.variable;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        for (Integer integer : list) {
            num++;
            // shareVariable.variable = num;
        }

        System.out.println("遍历完后的num = " + num);
        System.out.println("遍历完后的shareVariable = " + shareVariable.variable);
        shareVariable.variable = num;
        System.out.println("赋值完后的shareVariable = " + shareVariable.variable);
    }
}
