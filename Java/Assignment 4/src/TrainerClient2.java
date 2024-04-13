import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

public class TrainerClient2 extends Application {

    //Variable definitions
    DataOutputStream osToServer;
    private final ComboBox<String> comboBoxPokemonType = new ComboBox<>();
    private final TextField textBoxPokemonName = new TextField();
    private final Button btSendToDayCare = new Button("Send to Day Care");
    private final Button btPickUpFromDayCare = new Button("Pick Up From Day Care");
    private final UUID trainerUUID = UUID.randomUUID();

    /**
     *
     * @param primaryStage
     * This handles creating the GUI and threads
     */
    @Override
    public void start(Stage primaryStage) {
        comboBoxPokemonType.getItems().addAll("Bulbasaur", "Charmander", "Squirtle", "Pikachu");
        btPickUpFromDayCare.setVisible(false);

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Choose a Pokemon Type"), 0, 0);
        gridPane.add(new Label("Pokemon's Name"), 0, 1);

        gridPane.add(comboBoxPokemonType, 1, 0);
        gridPane.add(textBoxPokemonName, 1, 1);
        gridPane.add(btSendToDayCare, 0, 2);
        gridPane.add(btPickUpFromDayCare, 1, 2);

        textBoxPokemonName.setAlignment(Pos.BASELINE_RIGHT);
        textBoxPokemonName.setPrefColumnCount(5);

        Scene scene = new Scene(gridPane, 200, 200);
        primaryStage.setTitle("TrainerClient");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Start threads based off buttons
        btSendToDayCare.setOnAction(e -> sendToDayCare());
        btPickUpFromDayCare.setOnAction(e -> pickUpPokemon());
    }

    /**
     * Method to handle picking up pokemon from the server
     */
    private void pickUpPokemon() {
        btSendToDayCare.setDisable(false);
        btSendToDayCare.setVisible(true);

        btPickUpFromDayCare.setDisable(true);
        btPickUpFromDayCare.setVisible(false);

        comboBoxPokemonType.setDisable(false);
        comboBoxPokemonType.setVisible(true);

        textBoxPokemonName.setDisable(false);
        textBoxPokemonName.setVisible(true);

        try {
            osToServer.writeUTF(trainerUUID.toString());
            osToServer.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Method to handle sending pokemon to the daycare
     */
    private void sendToDayCare() {
        try {
            String pokemonName;
            String pokemonType;

            //Check if fields are filled out
            if (textBoxPokemonName.getText().trim().isEmpty() || comboBoxPokemonType.getSelectionModel().isEmpty()) {
                throw new RuntimeException("Provide a pokemon name and select a Pokemon");
            }

            pokemonType = textBoxPokemonName.getText().trim();
            pokemonName = comboBoxPokemonType.getValue();

            updateUI();

            //Open socket and write to server
            Socket connectToServer = new Socket("localhost", 8000);
            osToServer = new DataOutputStream(connectToServer.getOutputStream());

            osToServer.writeUTF(trainerUUID.toString());
            osToServer.writeUTF(pokemonName);
            osToServer.writeUTF(pokemonType);
            osToServer.flush();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Update the UI after sending Pokemon to the server
     */
    private void updateUI() {
        btSendToDayCare.setDisable(true);
        btSendToDayCare.setVisible(false);

        btPickUpFromDayCare.setDisable(false);
        btPickUpFromDayCare.setVisible(true);

        comboBoxPokemonType.setDisable(true);
        comboBoxPokemonType.setVisible(false);

        textBoxPokemonName.setDisable(true);
        textBoxPokemonName.setVisible(false);
    }
}
