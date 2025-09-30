package fr.epita.biostat.datamodel;

public class BioStatEntry {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public BioStatEntry(String name, String sex, Integer age, Integer height, Integer weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    //"Name",     "Sex", "Age", "Height (in)", "Weight (lbs)
    private String name;
    private String sex;
    private Integer age;
    private Integer height;
    private Integer weight;

}
