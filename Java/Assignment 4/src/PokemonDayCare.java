import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PokemonDayCare extends Application {

    //Variable definitions
    private TextArea ta = new TextArea();
    private int connectionCount = 0;
    private Map<String, Pokemon> pokemonMap = new HashMap<>();

    /**
     * This handles the GUI and receiving connections
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        ta.setWrapText(true);
        Scene scene = new Scene(new ScrollPane(ta), 200, 200);
        primaryStage.setTitle("Pokemon Day Care");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(this::connectToClient).start();
    }

    /**
     * Get connection from the client and display information
     */
    private void connectToClient() {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            Platform.runLater(() ->
                    ta.appendText("Server started at " + new Date() + "\n"));

            //While loop to accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                connectionCount++;

                Platform.runLater(() ->
                        ta.appendText("New connection with trainer. Total connections: " + connectionCount + "\n"));

                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method handles the information that is coming from the client
     * @param clientSocket
     */
    private void handleClient(Socket clientSocket) {
        try (DataInputStream isFromClient = new DataInputStream(clientSocket.getInputStream())) {

            while (true) {
                String trainerUUID = isFromClient.readUTF();

                //Check if the client is already with the server and then save the Pokemon
                if (!pokemonMap.containsKey(trainerUUID)) {
                    String pokemonName = isFromClient.readUTF();
                    String pokemonType = isFromClient.readUTF();

                    Pokemon pokemon = new Pokemon(pokemonType, pokemonName);
                    pokemon.checkIn();
                    pokemonMap.put(trainerUUID, pokemon);

                    Platform.runLater(() ->
                            ta.appendText("Trainer's IP address is " + clientSocket.getInetAddress() +
                                    "\nPokemon " + pokemonName + " has been checked in\n"));
                    //If client is already with the server give back Pokemon and remove client from registry
                } else {
                    Pokemon pokemon = pokemonMap.get(trainerUUID);

                    if (pokemon != null) {
                        pokemon.checkOut();
                        pokemonMap.remove(trainerUUID);

                        Platform.runLater(() ->
                                ta.appendText("Pokemon " + pokemon.getName() + " has been checked out\n"));
                    } else {
                        Platform.runLater(() ->
                                ta.appendText("No Pokemon found for trainerUUID " + trainerUUID + "\n"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
