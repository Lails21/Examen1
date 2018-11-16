package edu.upc.eetac.dsa;

public class Bike {

    //Atributos
    String idBike;
    String description;
    double km;
    String idStation;

    //Constructor vacío
    public Bike(){

    }

    // Constructor creado por nosotros
    public Bike (String idBike, String description, double km, String idStation){
        this.idBike=idBike;
        this.description=description;
        this.km=km;
        this.idStation=idStation;
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

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
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
