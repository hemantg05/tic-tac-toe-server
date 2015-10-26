package com.appylook.game.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "services" path)
 */
@Path("services")
public class GameResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 * 
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRestaurants() {
		return "The services are running well !";
	}

	/**
	 * Return the computer game for the m,n,k game
	 * @param gameState The state of the game
	 * @return the coordinate decided by computer for it's turn 
	 */
	@POST
	@Path("game")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDraw(GameState gameState) {
		int m = gameState.getM();
		int n = gameState.getN();
		System.out.println(m + "X" + n);
		String[][] array = gameState.getArray();
		for(int i=0;i<array.length;i++){
			String str ="";
			for(int j=0;j<array[i].length;j++){
				str += array[i][j] + " "; 
			}
			System.out.println(str);
		}
		
		while (true) {
            int xEntry = (int) Math.floor((Math.random() * m) * 1);
            int yEntry = (int) Math.floor((Math.random() * n) * 1);
            if (array[xEntry][yEntry].equals("-")) {
            	return Response.ok("{\"x\" : " + xEntry +", \"y\" : " + yEntry +" }")
            			.header("contentType", "application/json")
        				.header("Access-Control-Allow-Origin", "*")
        				.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
        				.build();
            }
        }
	}
}
