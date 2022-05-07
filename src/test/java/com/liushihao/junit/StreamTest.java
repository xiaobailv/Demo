package com.liushihao.junit;

import com.liushihao.entity.Student;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void test1() {
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
//        Stream<Integer> stream2 = Stream.iterate(0, x -> x + 2).limit(6);
//        stream2.forEach(System.out::println);

        // 准备数据
        List<Integer> nums = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(6);
                add(6);
                add(8);
            }
        };
        // 筛选出集合中的偶数 非stream方式
        List<Integer> evens = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        for (Integer even : evens) {
            System.out.println("even = " + even);
        }
        // 筛选出集合中的偶数 stream方式
        System.out.println("##########################");
        List<Integer> collect = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("##########################");

        // 筛选出集合中所有不重复的偶数
        List<Integer> collect2 = nums.stream().filter(num -> num % 2 == 0).distinct().collect(Collectors.toList());
        collect2.forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Student> students = new ArrayList<Student>(){
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
        // 从集合中筛选出武汉大学的学生
        List<Student> collect = students.stream().filter(student -> "武汉大学".equals(student.getSchool())).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("####################");

        // 从集合中筛选出前两个专业为土木工程专业的学生
        List<Student> collect2 = students.stream().filter(student -> "土木工程".equals(student.getMajor())).limit(6).collect(Collectors.toList());
        collect2.forEach(System.out::println);

        System.out.println("####################");

        // 从集合中筛选出专业为土木工程的学生, 并按年龄从小到大排序, 筛选出年龄最小的两个学生
        List<Student> collect3 = students.stream().filter(student -> "土木工程".equals(student.getMajor())).sorted((s1, s2) -> s1.getAge() - s2.getAge()).limit(2).collect(Collectors.toList());
        collect3.forEach(System.out::println);
    }

    @Test
    public void name() {
        List<Student> students = new ArrayList<Student>(){
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
        List<Student> students1 = new ArrayList<Student>();
//        Optional<Student> first = students1.stream().findFirst();
//        if (!first.isPresent()) {
//            System.out.println("1111");
//            return;
//        }
//        Student student = first.get();
//        System.out.println("student = " + student);

        students1 = null;
        if (CollectionUtils.isNotEmpty(students1)) {
            Student student = students1.get(0);
            System.out.println("student = " + student);
        } else System.out.println("为空");
    }
}
