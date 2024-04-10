import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Lopez_Server extends Application {

    //Text Area for displaying contents
    private TextArea ta = new TextArea();

    @Override
    public void start(Stage primaryStage){
        ta.setWrapText(true);
        //Create a scene adn place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 200, 200);
        primaryStage.setTitle("Lopez Server");
        primaryStage.setScene(scene);
        primaryStage.show();



        new Thread(()-> connectToClient()).start();

    }//end of method start

    private void connectToClient() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            Platform.runLater(() ->
                    ta.appendText("Lopez Server started at " + new Date() + "\n"));
            Socket connectToClient = serverSocket.accept();

            Platform.runLater(() ->
                    ta.appendText("Connected to a client at " + new Date() + "\n"));

            //Create input and output
            DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());
            DataOutputStream osToClient = new DataOutputStream(connectToClient.getOutputStream());

            while(true){

                double annualInterestRate = isFromClient.readDouble();
                int numberOfYears = isFromClient.readInt();
                double loanAmount = isFromClient.readDouble();

                //Computer monthly and total payments
                Loan mortage = new Loan(annualInterestRate, numberOfYears, loanAmount);
                double monthlyPayment = mortage.getMonthlyPayment();
                double totalPayment = mortage.getTotalPayment();

                //Send the results to the client
                osToClient.writeDouble(monthlyPayment);
                osToClient.writeDouble(totalPayment);

                //Print information on the Server GUI
                Platform.runLater(() ->{
                    ta.appendText("Annual Interest Rate: " + annualInterestRate +
                            "\nNumber of Years: " + numberOfYears +
                            "\nLoan Amount: " + loanAmount + "\n");
                    ta.appendText("monthly Payment: " + monthlyPayment +
                            "\ntotal Payment: " + totalPayment + "\n");
                });

            }//end of while loop
        }//end of try block
        catch (IOException e){
            System.out.println(e);

        }
    }//end of method connecttoclient
}//end of class
