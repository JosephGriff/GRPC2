package ie.gmit.ds;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.io.Console;

import javax.ws.rs.core.Response.Status;




@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UserApiResource {


    private HashMap<Integer, User> usersMap = new HashMap<>();

    public UserApiResource() {
        User testUser = new User(1, "The GZA", "HipHop", "3");
        usersMap.put(testUser.getUserID(), testUser);

    }

    @GET
    public Collection<User> getUsers() {
        // usersMap.values() returns Collection<User>
        // Collection is the interface implemented by Java collections like ArrayList, LinkedList etc.
        // it's basically a generic list.
        // https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html

        return usersMap.values();
    }

    @GET
    @Path("/{userID}")
    public  User getUserById(@PathParam("userID") int userID){return usersMap.get(userID);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUserAccount(User acc) {

        usersMap.put(acc.userID, acc);

        return Response.status(Status.CREATED).type(MediaType.TEXT_PLAIN).entity("UserAccount Created for " + acc.getUserName() + ".").build();
    }

    @DELETE
    @Path("delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUserAccount(User acc) {

        usersMap.remove(acc.getUserID());

        return Response.status(Status.ACCEPTED).type(MediaType.TEXT_PLAIN).entity("User " + acc.getUserID() + " Removed").build();
        }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserAccount(User acc){

        String err;

        if(usersMap.containsKey(acc.userID)){
            err = "Updated User Details";
        }
        else{
            err = "Unable to complete update";
        }


        return Response.status(Status.ACCEPTED).type(MediaType.TEXT_PLAIN).entity(err).build();

    }

    }