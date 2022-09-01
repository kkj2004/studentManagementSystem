package model;
//教师类
public class Teacher {
    private int id;
    private String name;
    private String password;
    private String TeachCourseName;

    public Teacher(){

    }
    public Teacher(String name,String password){
        this.name = name;
        this.password = password;
    }
    public Teacher(int id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Teacher(int id,String name,String password,String TeachCourseName){
        this.id = id;
        this.name = name;
        this.password = password;
        this.TeachCourseName = TeachCourseName;
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
    public String getTeachCourse() {
        return TeachCourseName;
    }
    public void setTeachCourse(String TeachCourse) {
        this.TeachCourseName = TeachCourse;
    }

    public String toString(){
        return name+" "+password;
    }
}
