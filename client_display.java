
//COSC 450 TCP program for Diffie-Hellman Key Exchange 
//Group - Fongheiser


import java.math.BigInteger;    //for modPow function
import java.util.*;
import java.io.*;
import java.net.*;   //transmission over a network 

public class client_display extends javax.swing.JFrame {

    Scanner input = new Scanner(System.in);
    Boolean socketOpen = false;       //used to tell if a socket is in use 
    String ipAddr;  //these 2 variables are set by the user 
    int port;
    Socket socket;
    //socket created and requesting the server specified ip and port #
    PrintStream printS;
    InputStreamReader inputR;
    BufferedReader bufferR;
    //String upper;
    //String lower;
    String message;
    String messageSep[];
    

    /**
     * Creates new form client_display
     */
    public client_display() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        serverMessage = new javax.swing.JTextArea();
        send_message = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        disconnect = new javax.swing.JButton();
        clientMessage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        connect = new javax.swing.JButton();
        ipNumber = new javax.swing.JTextField();
        portNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel portNum = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        serverMessage.setEditable(false);
        serverMessage.setColumns(20);
        serverMessage.setLineWrap(true);
        serverMessage.setRows(5);
        jScrollPane1.setViewportView(serverMessage);

        send_message.setText("send_message");
        send_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_messageActionPerformed(evt);
            }
        });

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        disconnect.setText("Exit / Disconnect");
        disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectActionPerformed(evt);
            }
        });

        clientMessage.setText("enter message");
        clientMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientMessageActionPerformed(evt);
            }
        });

        jLabel1.setText("Server");

        jLabel2.setText("Client");

        connect.setText("connect");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        portNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portNumberActionPerformed(evt);
            }
        });

        jLabel3.setText("IP #");

        portNum.setText("Port #");

        jLabel4.setText("Please enter a prime number p, a primitive root g modulus p, and your secret key a. (Seperate by spaces)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(send_message)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clientMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(connect)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ipNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(portNum)
                                .addGap(18, 18, 18)
                                .addComponent(portNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(resetButton)
                        .addGap(38, 38, 38)
                        .addComponent(disconnect)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(connect)
                            .addComponent(ipNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(portNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portNum))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(send_message)
                    .addComponent(clientMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(disconnect))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void send_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_messageActionPerformed
        // TODO add your handling code here:

        String empty = "";
        if (clientMessage.getText().equals(empty)) {
            clientMessage.setText("");
            clientMessage.requestFocus();
            //do nothing if there is no text to send
        } else if (clientMessage.getText().equals("stop")) { //if the client sends the message "stop" then disconnect
            try {
                printS.println("stop");
                socket.close();
                serverMessage.setText("You have been disconnected...");
                socketOpen = false;
            } catch (Exception e) {
                serverMessage.append("Could not Disconnect from Socket and Server");
            }
        } else {   //otherwise send the message to the server 
            try {
                message = clientMessage.getText();
                messageSep = message.split("\\s");
                serverMessage.append("p = " + messageSep[0] + "\n");
                serverMessage.append("g = " + messageSep[1] + "\n");
                serverMessage.append("a = " + messageSep[2] + "\n");
                
                int p = Integer.parseInt(messageSep[0]);
                int g = Integer.parseInt(messageSep[1]);
                int a = Integer.parseInt(messageSep[2]); 
                
                BigInteger bP = BigInteger.valueOf(p);       //convert to BigInteger for use of modPow function
                BigInteger bG = BigInteger.valueOf(g);
                BigInteger ba = BigInteger.valueOf(a);
               
                //now calculate A given the initial numbers 
                //int num;
                int A;
                BigInteger bA;
                bA = bG.modPow(ba, bP);
                A = bA.intValue();
                
                String sP = Integer.toString(p);    //convert back to string
                String sG = Integer.toString(g);
                String sA = Integer.toString(A);
                
                printS.println(sP + " " + sG + " " + sA);   //send (p,g, and our calculated A to the server)
                    
                //calculate our shared secret key using B
                String sB = bufferR.readLine();
                String sepB[] = sB.split("\\s");
                int B = Integer.parseInt(sepB[0]);
                BigInteger bB = BigInteger.valueOf(B);               
                BigInteger s = bB.modPow(ba, bP);
                int iS = s.intValue();
                serverMessage.append("\n s = " + iS);   //print shared key to screen
                
                
            } catch (Exception e) {
                serverMessage.append("Message Send Failed");
            }
            //then send message to the server
            // printS.println(clientMessage.getText());
        }
    }//GEN-LAST:event_send_messageActionPerformed

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
        // TODO add your handling code here:

        if (socketOpen == false) {
            //if there is no connection the try to connect  

            try {
                ipAddr = ipNumber.getText();
                port = Integer.parseInt(portNumber.getText());
                socket = new Socket(ipAddr, port);
                inputR = new InputStreamReader(socket.getInputStream());
                bufferR = new BufferedReader(inputR);
                printS = new PrintStream(socket.getOutputStream());
                socketOpen = true;
                printS.println("Hello Server:");
                String s1 = bufferR.readLine();
                String s2 = bufferR.readLine();
                String s3 = bufferR.readLine();
                System.out.println(s1);
                if (socket.isConnected()) {
                    serverMessage.setText(s1);
                    serverMessage.append("\n" + s2);
                    serverMessage.append("\n" + s3);
                }
            } catch (Exception e) {
                serverMessage.append("Could Not Connect to Server: Sorry");
            }
        } else { //if there is already a connection the button should do nothing
            ;
        }
    }//GEN-LAST:event_connectActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        serverMessage.setText(null);  //set the screen blankS
    }//GEN-LAST:event_resetButtonActionPerformed

    private void disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectActionPerformed
        // TODO add your handling code here:
        if (socket.isConnected()) {
            try {
                printS.println("stop");
                socket.close();
                serverMessage.setText("You have been disconnected...");
                socketOpen = false;
            } catch (Exception e) {
                serverMessage.append("Could not Disconnect from Socket and Server");
            }
        } else {
            ;
        }
    }//GEN-LAST:event_disconnectActionPerformed

    private void clientMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientMessageActionPerformed

    private void portNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portNumberActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(client_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client_display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client_display().setVisible(true);
            }
        });

    } //Ends Main


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField clientMessage;
    private javax.swing.JButton connect;
    private javax.swing.JButton disconnect;
    private javax.swing.JTextField ipNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField portNumber;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton send_message;
    public javax.swing.JTextArea serverMessage;
    // End of variables declaration//GEN-END:variables
} // Ends Class 
