package spring.normal;

import org.springframework.ui.context.Theme;

import java.util.NavigableMap;

public class JavaBeanPropertyRule {
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public JavaBeanPropertyRule(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        JavaBeanPropertyRule javaBeanPropertyRule = new JavaBeanPropertyRule(28);
        javaBeanPropertyRule.setName("김예성");
        System.out.println(javaBeanPropertyRule.getName() + "은 " + javaBeanPropertyRule.getAge() + "살 입니다.");

    }

}

class Test {
    public static void main(String[] args) {

    }
}
