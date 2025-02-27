/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seproject.entities;

import java.io.Serializable;
/**
 *
 * @author Daniel Servejeira
 */
public class Person implements Serializable{
    private String name;
    private String birthday;
    private Boolean gender;
    private String cpf;
    
    public Person(String name, String birthday, Boolean gender, String cpf) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Name: " + name +
               "\nBirthday: " + birthday +
               "\nGender: " + gender +
               "\nCPF: " + cpf;
        
    }
}
