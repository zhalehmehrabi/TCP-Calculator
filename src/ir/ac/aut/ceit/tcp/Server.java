package ir.ac.aut.ceit.udpproxy.proxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket socket;

    public static void main(String[] args) {
        try {

            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");

            //Server is running always. This is done using this while(true) loop
            while (true) {
                //Reading the message from the client
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String clientMassage = br.readLine();
                System.out.println("Message received from client is " + clientMassage);
                String receavedFromServer[]= clientMassage.split("/");
                System.out.println(receavedFromServer[0]);
                int operation = Integer.valueOf(receavedFromServer[1]);
                float firstOperand = Float.valueOf(receavedFromServer[2]);
                float secondOperand = Float.valueOf(receavedFromServer[3]);
                float answer = 0;
                long startTime = 0;
                long finishTime = 0;
                long totalTime;
                switch (operation){
                    case 1:
                        {
                            startTime = System.nanoTime();
                            answer = firstOperand + secondOperand;
                            finishTime = System.nanoTime();
                            break;
                        }
                    case 2:
                    {
                        startTime = System.nanoTime();
                        answer = firstOperand - secondOperand;
                        finishTime = System.nanoTime();
                        break;
                    }
                    case 3:
                    {
                        startTime = System.nanoTime();
                        answer = firstOperand / secondOperand;
                        finishTime = System.nanoTime();
                        break;
                    }
                    case 4:
                    {
                        startTime = System.nanoTime();
                        answer = firstOperand * secondOperand;
                        finishTime = System.nanoTime();
                        break;
                    }
                    case 5:
                    {
                        startTime = System.nanoTime();
                        answer = (float) Math.sin(firstOperand);
                        finishTime = System.nanoTime();
                        break;
                    }
                    case 6:
                    {
                        startTime = System.nanoTime();
                        answer = (float) Math.cos(firstOperand);
                        finishTime = System.nanoTime();
                        break;
                    }
                    case 7:
                    {
                        startTime = System.nanoTime();
                        answer = (float) Math.tan(firstOperand);
                        finishTime = System.nanoTime();
                    }
                    case 8:
                    {
                        startTime = System.nanoTime();
                        answer = (float)(1/( Math.tan(firstOperand)));
                        finishTime = System.nanoTime();
                    }
                }
                totalTime = finishTime - startTime;
                String returnMessage = "/"+Long.toString(totalTime)+"/"+Float.toString(answer)+"/";
                //Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage + "\n");
                System.out.println("Message sent to the client is " + returnMessage);
                bw.flush();
                System.out.println("ajb");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("asdfasdfasdf");
            } catch (Exception e) {
                System.out.println("helloooooo");
            }
        }
    }
}