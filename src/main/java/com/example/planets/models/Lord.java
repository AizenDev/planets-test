package com.example.planets.models;

import javax.persistence.*;
import java.util.List;

@Table(name = "lords")
@Entity
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lid;

    @Column(name = "lname")
    private String lname;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy="lord")
    private List<Planet> planets;

    public Lord(Long id, String name, int age) {
        this.lid = id;
        this.lname = name;
        this.age = age;
    }

    public Lord() {}

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
