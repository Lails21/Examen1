package edu.upc.eetac.dsa;

import java.util.LinkedList;

public class User {

    //Atributos
    String idUser;
    String name;
    String surname;
    LinkedList<Bike> bikes;

    //Constructor vacío
    public User(){
        this.bikes=new LinkedList<>();

    }

    // Constructor creado por nosotros
    public User(String idUser, String name, String surname){
        this.idUser=idUser;
        this.name=name;
        this.surname=surname;
        this.bikes=new LinkedList<>();
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

    public LinkedList<Bike> getBikes(){
        return bikes;
    }

    public void setBikes(LinkedList<Bike> bikes){
        this.bikes=bikes;
    }

    public void addBikes (Bike b){
        this.getBikes().add(b);
    }

    @Override
    public String toString(){
        return "User[" +
                "idUser='" + idUser + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bikes='" + bikes + '\'' +
                ']';
    }
}
