import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.sql.*;

import java.net.InetSocketAddress;
import java.util.Map;
/*
In order to communicate with the DB server from a browser tab, you will need to append the route name to the url
*/
class Main {

 public static void main(String[] args)throws IOException{
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() throws IOException{   

    // Create a port - this is your Gateway
    int port = 8500;

    // Create the HTTPserver object
    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);

    // Create the database object
    Database db = new Database("jdbc:sqlite:chinook.db");
    
    // Create a route handler to respond to the request (default route)
    server.createContext("/", new RouteHandler("Default route...") );

    // create a route called 'customers' that gets all customer records.
    String sql = "";
    sql  = " Select * from customers ";
    server.createContext("/customers", new RouteHandler(db,sql) );

    // Create a route called 'employees' that gets all employee records.
    sql  = " Select * from employees ";
    server.createContext("/employees", new RouteHandler(db,sql) ) ;
        
    // Create a route called 'songs' that gets track(song) records. Limit to 200 records.
    sql  = " Select tracks.name, albums.title, tracks.composer FROM tracks ";
    sql += " INNER JOIN albums ON albums.albumid=tracks.albumid ";
    sql  += " LIMIT 200 ";    
    server.createContext("/songs", new RouteHandler(db,sql) ) ;


    // Start the server      
    server.start();
    System.out.println("Server is listening on port " + port);      
  }    
}


