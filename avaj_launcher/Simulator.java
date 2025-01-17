package avaj_launcher;

import java.util.LinkedList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.File;

public class Simulator {

    private List<Flyable>   fleet;
    private int             numChange;
    private WeatherProvider provider = WeatherProvider.getInstance();
    private WeatherTower    weatherTower = new WeatherTower(provider);
    private AircraftFactory factory = AircraftFactory.getInstance();


    public static void main(String ...args) {

        if (args.length != 1) {
            System.out.println("Usage: ...");
            System.out.println("Usage: ...");
            return ;
        }
        Simulator simulator = new Simulator(args[0]);


       
        for (int i = 0; i < simulator.numChange; i++) {
            simulator.run();
        }
    }

    private Simulator(String scenario)  {
        try (LineNumberReader reader = new LineNumberReader(new FileReader(scenario))) {
            String line = reader.readLine();
            System.out.println("line is " + line);
        } catch (IOException e) {
            
        }


    }

    public void run() {
        weatherTower.changeWeather();
    }


    // private static List<Flyable> createFleet(String file) {
    //     try (BufferedReader br = new BufferedReader(new FileReader(file)) ) {
    //         String line = br.readLine();
            
    //     } catch (IOException e){

    //     } 
        
    //     return null;
    // }
}

/*
 *  Flyable         ship = factory.newAircraft("JetPlane","bob",new Coordinates(4,4,4));
        Flyable         ship2 = factory.newAircraft("Helicopter","alice",new Coordinates(4,4,4));
        Flyable         ship3 = factory.newAircraft("Baloon","borys",new Coordinates(4,4,4));
        
        ship.registerTower(weatherTower);
        ship2.registerTower(weatherTower);
        ship3.registerTower(weatherTower);
 * 
 */