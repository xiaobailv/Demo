package com.liushihao.entity;

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)*/
public class Dish {

    private Integer calores;
    private String name;
    private String name1Test;
    private Integer name1test;

    public Integer getCalores() {
        return calores;
    }

    public void setCalores(Integer calores) {
        this.calores = calores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1Test() {
        return name1Test;
    }

    public void setName1Test(String name1Test) {
        this.name1Test = name1Test;
    }

    public Integer getName1test() {
        return name1test;
    }

    public void setName1test(Integer name1test) {
        this.name1test = name1test;
    }

    public Dish(Integer calores, String name, String name1Test, Integer name1test) {
        this.calores = calores;
        this.name = name;
        this.name1Test = name1Test;
        this.name1test = name1test;
    }

    public Dish() {
    }
}
