package model;

public class Student {
    private int id;
    private String name;
    private String password;
    private String sex;
    private int age;
    private String dept;
//学生类
    public Student(){

    }
    public Student(String name,String password){
        this.name = name;
        this.password = password;
    }
    public Student(int id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Student(int id,String name,String sex,int age,String dept) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String toString(){
        return name+" "+password;
    }
}
