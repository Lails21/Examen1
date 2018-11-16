package edu.upc.eetac.dsa;

import java.util.LinkedList;

public class User {

    //Atributos
    String idUser;
    String name;
    String surname;

    //Constructor vacío
    public User(){

    }

    // Constructor creado por nosotros
    public User(String idUser, String name, String surname){
        this.idUser=idUser;
        this.name=name;
        this.surname=surname;
    }

    // Sets & Gets
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString(){
        return "User[" +
                "idUser='" + idUser + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ']';
    }
}
