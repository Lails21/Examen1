package edu.upc.eetac.dsa;

import java.util.*;

import org.apache.log4j.Logger;

public class MyBikeImpl implements MyBike{

    //Inicializamos el log4j llamando al archivo de propiedades
    final static Logger log = Logger.getLogger(MyBikeImpl.class.getName());

    // SINGLETON (fachada)
    private static MyBikeImpl instance;
    protected int nStations;
    protected Station[] stations;
    protected HashMap<String, User> users;
    protected LinkedList<Bike> bikesusers;
    protected LinkedList<Bike> bikeskm;

    // Constructor privado (forma parte del Singleton)
    private MyBikeImpl(){
        nStations=0;
        this.stations = new Station[10];
        this.bikesusers=new LinkedList<>();
        this.users=new HashMap<>();
        this.bikeskm=new LinkedList<>();
    }
    // Método que retorna el instance y si es nulo la inicializamos
    public static MyBike getInstance() {
        if (instance == null) {
            // Creamos una nueva instancia
            instance = new MyBikeImpl();
        }
        return instance;
    }

    public void addUser(String idUser, String name, String surname){
        users.put(idUser, new User(idUser, name, surname));
        log.info("User added:" +users.get(idUser));
    }

    public void addStation(String idStation, String description, int max, double lat, double lon){
        if (nStations != S){
            stations[nStations]= new Station(idStation, description, max, lat, lon);
            log.info("Station added:" +stations[nStations]);
        }
        else{
            log.error("Maximum stations added (no more space available");
        }
    }

    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException{

    }







}
