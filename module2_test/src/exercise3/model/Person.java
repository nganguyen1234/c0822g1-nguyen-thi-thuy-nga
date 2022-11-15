package exercise3.model;
/*
Tính trừu tượng
 */
public abstract class Person {
    /*
    Tính bao đóng
     */
    private String id;
    private String name;
    private String gender;
/*
Tính đa hình
 */
    protected Person() {
    }

    protected Person(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
/*
Tính trừu tượng
 */
    public abstract String getInfo();

    @Override
    public String toString() {
        return 
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'';
    }
}
