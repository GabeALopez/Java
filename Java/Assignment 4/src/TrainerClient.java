import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TrainerClient extends Application{
    //IO streams
    DataOutputStream osToServer;
    DataInputStream isFromServer;

    private ComboBox comboBoxPokemonType = new ComboBox<String>();
    private TextField textBoxPokemonName = new TextField();
    private Button btSendToDayCare = new Button("Send to Day Care");
    private Button btPickUpFromDayCare = new Button("Pick Up From Day Care");

    @Override
    public void start(Stage primaryStage){

        comboBoxPokemonType.getItems().addAll("Bulbasaur", "Charmander", "Squirtle", "Pikachu");

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Choose a Pokemon Type"), 0,0);
        gridPane.add(new Label("Pokemon's Name"), 0,1);

        gridPane.add(comboBoxPokemonType, 1,0);
        gridPane.add(textBoxPokemonName, 1, 1);
        gridPane.add(btSendToDayCare, 0, 2);
        gridPane.add(btPickUpFromDayCare, 1, 2);

        textBoxPokemonName.setAlignment(Pos.BASELINE_RIGHT);
        textBoxPokemonName.setPrefColumnCount(5);


        //Create a scene adn place it in the stage
        Scene scene = new Scene(gridPane, 200, 200);
        primaryStage.setTitle("TrainerClient");
        primaryStage.setScene(scene);
        primaryStage.show();

        btSendToDayCare.setOnAction(e -> connectToServer());

        try{
            //Create socket
            Socket connectToServer = new Socket("localhost", 8000);

            //Create input output streams to send data
            isFromServer = new DataInputStream(connectToServer.getInputStream());
            osToServer = new DataOutputStream(connectToServer.getOutputStream());
        }catch (IOException ex){
            System.out.println(ex);
        }

        //new Thread(()-> connectToClient()).start();

    }//end of method start

    private void connectToServer() {

        try {

            String pokemonName;
            String pokemonType;
            if (!textBoxPokemonName.getText().trim().isEmpty()) {

                pokemonName = textBoxPokemonName.getText().trim();

                if (!comboBoxPokemonType.getSelectionModel().isEmpty()) {

                    pokemonType = comboBoxPokemonType.getTypeSelector().trim();

                } else {
                    throw new RuntimeException("Select a Pokemon");
                }

            } else {
                throw new RuntimeException("Provide a pokemon name");
            }


            //Sending information to the server
            osToServer.writeChars(pokemonName);
            osToServer.writeChars(pokemonType);

            osToServer.flush();

            /*
            //Get information from the server
            double monthlyPayment = isFromServer.readDouble();
            double totalPayment = isFromServer.readDouble();

            ta.appendText("Annual Interest Rate: " + annualInterestRate +
                    "\nNumber of Years: " + numberOfYears +
                    "\nLoan Amount: " + loanAmount + "\n");
            ta.appendText("monthly Payment: " + monthlyPayment +
                    "\ntotal Payment: " + totalPayment + "\n");

            */
        }
        catch (IOException ex){
            System.out.println(ex);
        }

    }//end of method connecttoclient

}
