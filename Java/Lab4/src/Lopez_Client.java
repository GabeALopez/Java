import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Lopez_Client extends Application {

    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private Button btSubmit = new Button("Submit");
    private TextArea ta = new TextArea();

    //IO streams
    DataOutputStream osToServer;
    DataInputStream isFromServer;

    @Override
    public void start(Stage primaryStage){
        ta.setWrapText(true);

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Annual Interest Rate"), 0,0);
        gridPane.add(new Label("Number of Years"), 0,1);
        gridPane.add(new Label("Loan Amount"), 0,2);

        gridPane.add(tfAnnualInterestRate, 1,0);
        gridPane.add(tfNumberOfYears, 1,1);
        gridPane.add(tfLoanAmount, 1,2);
        gridPane.add(btSubmit, 2,1);

        tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BASELINE_RIGHT);
        tfLoanAmount.setAlignment(Pos.BASELINE_RIGHT);

        tfAnnualInterestRate.setPrefColumnCount(5);
        tfNumberOfYears.setPrefColumnCount(5);
        tfLoanAmount.setPrefColumnCount(5);

        BorderPane pane = new BorderPane();
        pane.setCenter(new ScrollPane(ta));
        pane.setTop(gridPane);

        //Create a scene adn place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Lopez Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        btSubmit.setOnAction(e -> connectToServer());

        try{
            //Create socket
            Socket connectToServer = new Socket("localhost", 8000);

            //Create input output streams to send data
            isFromServer = new DataInputStream(connectToServer.getInputStream());
            osToServer = new DataOutputStream(connectToServer.getOutputStream());
        }catch (IOException ex){
            ta.appendText(ex.toString() + "\n");
        }

        //new Thread(()-> connectToClient()).start();

    }//end of method start

    private void connectToServer() {

        try{

            double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText().trim());
            int numberOfYears = Integer.parseInt(tfNumberOfYears.getText().trim());
            double loanAmount = Double.parseDouble(tfLoanAmount.getText().trim());

            //Sending information to the server
            osToServer.writeDouble(annualInterestRate);
            osToServer.writeInt(numberOfYears);
            osToServer.writeDouble(loanAmount);

            osToServer.flush();

            //Get information from the server
            double monthlyPayment = isFromServer.readDouble();
            double totalPayment = isFromServer.readDouble();

            ta.appendText("Annual Interest Rate: " + annualInterestRate +
                    "\nNumber of Years: " + numberOfYears +
                    "\nLoan Amount: " + loanAmount + "\n");
            ta.appendText("monthly Payment: " + monthlyPayment +
                    "\ntotal Payment: " + totalPayment + "\n");

        }
        catch (IOException ex){
            System.out.println(ex);
        }

    }//end of method connecttoclient


}
