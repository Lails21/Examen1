package edu.upc.eetac.dsa;

import java.util.*;

import org.apache.log4j.Logger;
import sun.awt.image.ImageWatched;

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
        log.info(users.size());
        log.info("User added:" +users.get(idUser));
    }

    public void addStation(String idStation, String description, int max, double lat, double lon){
        if (nStations != S){
            stations[nStations]= new Station(idStation, description, max, lat, lon);
            log.info(nStations);
            log.info("Station added:" +stations[nStations]);
            nStations++;
        }
        else{
            log.error("Maximum stations added (no more space available)");
        }
    }

    public void addBike(String idBike, String description, double km, String idStation) throws StationFullException, StationNotFoundException {
        Bike b = new Bike(idBike, description, km);
        log.info("Bike added:" + b);
        int i;
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
            if (stations[i-1].getBikes().size() < stations[i-1].getMax()) {
                stations[i-1].addBikes(b);
                log.info("Bikes on station i:" + stations[i-1].getIdStation()+":" +stations[i-1].getBikes());
            } else {
                log.error("Station full (no more space available)");
                throw new StationFullException();
            }
        }
    }

    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {
        int i;
        boolean enc = false;
        for (i = 0; i < nStations && !enc; i++) {
            if (idStation.equals(stations[i].getIdStation())) {
                enc = true;
                log.info("Station found");
            }
        }
        i--;
        if(enc){

        LinkedList<Bike> bcs = stations[i].getBikes();
        log.info("List of bikes without order:" + bcs);
        Collections.sort(bcs, new Comparator<Bike>() {
            @Override
            public int compare(Bike p1, Bike p2) {
                double res = p1.getKm() - (p2.getKm());
                if (res < 0.0) {
                    return -1;
                } else if (res > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        log.info("List after order:" + bcs);
        return bcs;
    }
         else{
            log.error("Station not found");
            throw new StationNotFoundException();
        }
    }


    public Bike getBike(String idStation, String idUser) throws UserNotFoundException, StationNotFoundException{
        int i = 0;
        boolean enc = false;
        for (i = 0; i < nStations && !enc; i++) {
            if (idStation.equals(stations[i].getIdStation())) {
                enc = true;
                log.info("Station found");
            }
        }
        i--;
        if (enc) {
            Bike bici = stations[i].getBikes().removeFirst();
            User usuario = users.get(idUser);
            log.info("Bikes in the station:" + stations[i].getBikes());
            if (usuario != null) {
                log.info("First bike in the station:" + bici);
                usuario.addBikes(bici);
                return bici;
            } else {
                log.error("User not found");
                throw new UserNotFoundException();
            }
        }
        else{
            log.error("Station not found");
            throw new StationNotFoundException();
        }
}

    public List<Bike> bikesByUser(String idUser) throws UserNotFoundException{
        User usuario = users.get(idUser);
        if (usuario != null){
            LinkedList<Bike> bikes=usuario.getBikes();
            log.info("List of bikes of" +idUser+":"+bikes);
            return  bikes;
        }
        else{
            log.error("User not found");
            throw new UserNotFoundException();
        }

    }

    public int numUsers(){
        log.info("Tamaño lista de usuarios:" +this.users.size());
        return this.users.size();
    }

    public int numStations(){
        log.info("Número de estaciones:" +this.nStations);
        return this.nStations;
    }

    public int numBikes(String idStation) throws StationNotFoundException{
        int i = 0;
        boolean enc = false;
        for (i = 0; i < nStations && !enc; i++) {
            if (idStation.equals(stations[i].getIdStation())) {
                enc = true;
                log.info("Station found");
            }
        }
        i--;
        if (!enc) {
            log.error("Station not found");
            throw new StationNotFoundException();
        } else {
            this.stations[i].getBikes().size();
            }
        return this.stations[i].getBikes().size();
    }

    public void clear(){
        nStations=0;
        this.stations = new Station[10];
        this.users = new HashMap<>();
    }

}


