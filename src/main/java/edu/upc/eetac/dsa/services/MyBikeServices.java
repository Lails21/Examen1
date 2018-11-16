package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/MyBike", description = "Endpoint to My Bike edu.upc.eetac.dsa.services")
@Path("/MyBike")

public class MyBikeServices {

    private MyBike mb;
    public MyBikeServices() throws StationFullException, StationNotFoundException {
        this.mb=MyBikeImpl.getInstance();
        this.mb = MyBikeImpl.getInstance();
        this.mb.addUser("user1", "Juan", "Lopex");


        this.mb.addStation("Station1","description:: station1", 10, 3, 3);
        this.mb.addStation("Station2","description:: station2", 10, 3, 3);

        this.mb.addBike("bike101", "descripton", 25.45, "Station1");
        this.mb.addBike("bike102", "descripton", 70.3, "Station1");
        this.mb.addBike("bike103", "descripton", 10.2, "Station1");

        this.mb.addBike("bike201", "descripton", 1325.45, "Station2");
        this.mb.addBike("bike202", "descripton", 74430.3, "Station2");
        this.mb.addBike("bike203", "descripton", 1320.2, "Station2");
    }

    @GET
    @ApiOperation(value = "get list of bikes ordered by km", notes = "X")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Station not found")

    })
    @Path("/1{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesOrderedByKm(@PathParam("idStation") String idStation) {
        List<Bike> bikes;
        try{
            bikes = this.mb.bikesByStationOrderByKms(idStation);
            GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(bikes) {};
            return Response.status(201).entity(entity).build();
        }
        catch (StationNotFoundException e){
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @GET
    @ApiOperation(value = "get list of bikes of a user", notes = "X")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Station not found")

    })
    @Path("/2{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bikesByUser(@PathParam("idUser") String idUser) {

        try{
            List<Bike> bicis = this.mb.bikesByUser(idUser);
            GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(bicis) {};
            return Response.status(201).entity(entity).build();
        }
        catch (UserNotFoundException e){
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

}
