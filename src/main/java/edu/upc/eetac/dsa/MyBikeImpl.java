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

    // Constructor privado (forma parte del Singleton)
    private MyBikeImpl(){
        nStations=0;
        this.users=new HashMap<>();
        this.stations = new Station[10];
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
            log.error("Maximum stations added (no more space available)");
        }
    }

    public void addBike(String idBike, String description, double km, String idStation) throws StationFullException, StationNotFoundException {
        Bike b = new Bike(idBike, description, km);
        log.info("Bike added:" + b);
        int i = 0;
        boolean enc = false;
        for (i = 0; i < nStations && !enc; i++) {
            if (idStation.equals(stations[i].getIdStation())) {
                enc = true;
                log.info("Station found");
            }
        }
        if (!enc) {
            log.error("Station not found");
            throw new StationNotFoundException();
        } else {
            if (stations[i].getBikes().size() < stations[i].getMax()) {
                stations[i].addBikes(b);
                log.info("Bikes on station i:" + stations[i].getBikes());
            } else {
                log.error("Station full (no more space available)");
                throw new StationFullException();
            }
        }
    }

    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException{
        int i;
        boolean enc;
    }

    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException{

    }

    public List<Bike> bikesByUser(String userId) throws UserNotFoundException{

    }

    public int numUsers(){

    }

    public int numStations(){

    }

    public int numBikes(String idStation) throws StationNotFoundException{

    }

    public void clear(){

    }

}


