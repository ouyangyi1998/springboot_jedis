package com.jerry.springboot_jedis.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Setter
@Getter
public class User extends BaseEntity implements Serializable{
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "age")
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
