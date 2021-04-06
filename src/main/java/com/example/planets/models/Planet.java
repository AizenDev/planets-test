package com.example.planets.models;

import javax.persistence.*;

@Table(name = "planets")
@Entity
public class Planet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "pname")
    private String pname;

    @ManyToOne
    @JoinColumn(name="lord_id", nullable=false)
    private Lord lord;

    public Planet() {
    }

    public Planet(Long id, String name) {
        this.pid = id;
        this.pname = name;
    }
    public Long getId() {
        return pid;
    }

    public void setId(Long id) {
        this.pid = id;
    }

    public String getName() {
        return pname;
    }

    public void setName(String name) {
        this.pname = name;
    }
}
