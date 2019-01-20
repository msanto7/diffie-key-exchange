//COSC 450 TCP program for Diffie-Hellman Key Exchange 
//Group - Fongheiser


import java.util.*;
import java.io.*;
import java.math.BigInteger;   //used for modPow
import java.net.*; //transmission over a network 

public class Server {
    
    public static void main(String[] args) throws Exception {

        int p;  //(large prime number)
        int g;  //(primitve root modulo p
        int A;  //(A = g^a mod p)
        String str[];       
        Scanner input = new Scanner(System.in);
        int b;
        int B;
  
        
        //port number chosen is currently local host, must use machines IP when testing 2 computers 
        ServerSocket serverSocket = new ServerSocket(444);   //opens the socket for the server      
        System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());
        System.out.println("IP Address of server machine: " + Inet4Address.getLocalHost().getHostAddress());  //This is the local IP

        while (true) {  //we want the server to stay running even when clients disconnect 

            //****************************************************  Listen and Connect to Client...print info to Client
            Socket socket = serverSocket.accept();              //pointer to socket object once connection is made to a client
            PrintStream printS = new PrintStream(socket.getOutputStream());  //once connnection is made to server / send info
            printS.println("Hello Client! ");
            printS.println("Port Number of the Server: " + socket.getPort());
            printS.println("IP Address of the Server: " + Inet4Address.getLocalHost().getHostAddress());
            //to be sent to GUI      
            //*********************************************************************************************
            InputStreamReader inputR = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferR = new BufferedReader(inputR);
            String s1;
            s1 = bufferR.readLine();   //read the initial message from the server "Hello Server"
            System.out.print(s1);      //"print this to the server console for confirmation 

            //connected to a client and waiting for the next move....
            s1 = bufferR.readLine(); //start loop....see what the client does next   
            str = s1.split("\\s");
            
            while (!str[0].equals("stop")) {   //continue to read input and respond or reset until client wants to disconnect 
                
                p = Integer.parseInt(str[0]);
                g = Integer.parseInt(str[1]);
                A = Integer.parseInt(str[2]);               
                System.out.println();
                System.out.println("p = " + p);
                System.out.println("g = " + g);
                System.out.println("A = " + A);
                
                //Now pick a secret b for the server and calculate B = g^b mod p               
                System.out.println();
                System.out.println("Please enter a secret (b): ");
                b = input.nextInt();
                
                BigInteger bP = BigInteger.valueOf(p);       //convert to BigInteger for use of modPow function
                BigInteger bG = BigInteger.valueOf(g);
                BigInteger bA = BigInteger.valueOf(A);
                BigInteger bb = BigInteger.valueOf(b);
                
                //Calculate public key using secret key b
                BigInteger bB;
                bB = bG.modPow(bb, bP);
                B = bB.intValue();
                String sB = (B + " ");
                printS.println(sB);   //send public key B back to the client
                
                BigInteger s;
                s = bA.modPow(bb, bP);          //shared secret key
                System.out.println("s = " + s);
                
                
                str[0] = "stop";
                
            } //End while loop

            if (str[0] == "stop") {
                inputR.close();
                bufferR.close();
                printS.close();
                socket.close();
            } //if client disconnects...close that specific socket

        } // End while loop

        //socket() - endpoint for comm
        //bind() - assign a unique address - IP and port #
        //listen() - wait for client to request access
        //connect() - ask to server
        //accept() - server receives a call
        //send() recv() 
        //close() - hang up 
        
    } //Ends main
    
    
} //Ends Class
