package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import reciver.ClienteReciver;
import sender.ClienteSender;


public class Cliente {
public static void main(String[] args) throws IOException {

        System.out.println("Qual o servidor?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String serverHostname = br.readLine();
        
        System.out.println("Qual a porta do servidor?");
        br = new BufferedReader(new InputStreamReader(System.in));
        int serverPort = Integer.parseInt(br.readLine());
        
        

        if (args.length > 0)
           serverHostname = args[0];
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port "+ serverPort +".");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, serverPort);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput;

        System.out.println ("Type Message (\"Bye.\" to quit)");
	while ((userInput = stdIn.readLine()) != null){
            String response;
	    //out.println(userInput);
            out.println(ClienteSender.sender(userInput));
            
            response = in.readLine();
	    System.out.println("Recived from server: " + response);
            System.out.println(ClienteReciver.Reciver(response));
	   } // end
        
        out.println(ClienteSender.sender("logout"));
        System.out.println("Recived from server: " + in.readLine());
        
	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }

}
