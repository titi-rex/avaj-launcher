package avaj_launcher;

import java.util.LinkedList;
import java.util.List;

import avaj_launcher.exceptions.EmptyFileException;
import avaj_launcher.exceptions.InvalidAircraftTypeException;
import avaj_launcher.exceptions.ParsingException;
import avaj_launcher.flyable.AircraftFactory;
import avaj_launcher.flyable.Flyable;
import avaj_launcher.weather.WeatherProvider;
import avaj_launcher.weather.WeatherTower;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.io.File;

public class Simulator {

    private int             numChange;
    private List<Flyable>   fleet = new LinkedList<Flyable>();
    private WeatherProvider provider = WeatherProvider.getInstance();
    private WeatherTower    weatherTower = new WeatherTower(provider);
    private AircraftFactory factory = AircraftFactory.getInstance();
    private static PrintStream     console = System.out;


    
    public static void main(String ...args) {
        System.out.println("Hello.");

        if (args.length != 1) {
            System.out.println("Usage: java avaj_launcher.Simulator [file]");
            return ;
        }
        try {
            PrintStream output = new PrintStream(new File("simulation.txt"));
            System.setOut(output);

            Simulator simulator = new Simulator(args[0]);

            for (Flyable flyable : simulator.fleet) {
                flyable.registerTower(simulator.weatherTower);
            }

            for (int i = 0; i < simulator.numChange; i++) {
                simulator.run();
            }
            System.setOut(Simulator.console);
        } catch (ParsingException | InvalidAircraftTypeException | IOException e) {
            System.setOut(Simulator.console);
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.setOut(Simulator.console);
            System.out.println("Fatal: " + e);
        }
    }

    
    private Simulator(String scenario) throws EmptyFileException, ParsingException, InvalidAircraftTypeException, IOException {
        int lineNumber = 1;
        try (LineNumberReader reader = new LineNumberReader(new FileReader(scenario))) {
            String line = reader.readLine();
            if (line == null)
                throw new EmptyFileException();
            numChange = Integer.parseInt(line);

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String words[] = line.split(" ");
                
                if (words.length != 5)
                    throw new ParsingException("too much parameter at line: " + lineNumber, lineNumber);
                fleet.add(
                    factory.newAircraft(
                        words[0], 
                        words[1], 
                        new Coordinates(
                            Integer.parseInt(words[2]), 
                            Integer.parseInt(words[3]), 
                            Integer.parseInt(words[4])
                            )
                        )
                );
            }
        } 
        catch (NumberFormatException e) {
            throw new ParsingException("invalid number format at line: " + lineNumber, lineNumber);
        }
        catch (IndexOutOfBoundsException e) {
            throw new ParsingException("missing parameter at line: " + lineNumber, lineNumber);
        }
        catch (InvalidAircraftTypeException e) {
            throw new ParsingException(e.getMessage() + ", at line: " + lineNumber, lineNumber);
        }
    }

    public void run() {
        weatherTower.changeWeather();
    }
}
