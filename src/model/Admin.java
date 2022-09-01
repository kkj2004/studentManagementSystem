package model;
//管理员类
public class Admin {
    private int id;
    private String name;
    private String password;

    public Admin(){

    }
    public Admin(String name,String password){
        this.name = name;
        this.password = password;
    }
    public Admin(int id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
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
    public String toString(){
        return name+" "+password;
    }
}
