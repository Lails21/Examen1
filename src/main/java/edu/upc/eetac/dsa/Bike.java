package edu.upc.eetac.dsa;

public class Bike {

    //Atributos
    String idBike;
    String description;
    double km;

    //Constructor vacío
    public Bike(){

    }

    // Constructor creado por nosotros
    public Bike (String idBike, String description, double km){
        this.idBike=idBike;
        this.description=description;
        this.km=km;
    }

    // Sets & Gets
    public String getIdBike() {
        return idBike;
    }

    public void setIdBike(String idBike) {
        this.idBike = idBike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "idBike='" + idBike + '\'' +
                ", description='" + description + '\'' +
                ", km=" + km +
                '}';
    }

}
