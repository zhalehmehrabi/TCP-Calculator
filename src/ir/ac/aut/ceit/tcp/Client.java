import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket socket;

    public static void main(String args[]) {
        System.out.println("pla select the operand : \n" + "1-Add\n" +
                "2-Subtract\n" +
                "3-Divide\n" +
                "4-Multiply\n" +
                "5-Sin\n" +
                "6-Cos\n" +
                "7-Tan\n" +
                "8-Cot");
        Scanner scan = new Scanner(System.in);
        int operation = scan.nextInt();
        String massage = "";
        switch (operation){
            case 1:
            {
                System.out.println("Enter first number : ");
                float first = scan.nextFloat();
                System.out.println("Enter second number : ");
                float sec = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+Float.toString(sec)+"/";
                break;
            }
            case 2:
            {
                System.out.println("Enter first number : ");
                float first = scan.nextFloat();
                System.out.println("Enter second number : ");
                float sec = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+Float.toString(sec)+"/";
                break;
            }
            case 3:
            {
                System.out.println("Enter first number : ");
                float first = scan.nextFloat();
                System.out.println("Enter second number : ");
                float sec = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+Float.toString(sec)+"/";
                break;
            }
            case 4:
            {
                System.out.println("Enter first number : ");
                float first = scan.nextFloat();
                System.out.println("Enter second number : ");
                float sec = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+Float.toString(sec)+"/";
                break;
            }
            case 5:
            {
                System.out.println("Enter the angle : ");
                float first = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+"/";
                break;
            }
            case 6:
            {
                System.out.println("Enter the angle : ");
                float first = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+"/";
                break;
            }
            case 7:
            {
                System.out.println("Enter the angle : ");
                float first = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+"/";
                break;
            }
            case 8:
            {
                System.out.println("Enter the angle : ");
                float first = scan.nextFloat();
                massage = "/"+Integer.toString(operation)+"/"+ Float.toString(first)+"/"+"/";
                break;
            }
        }




        try {
            String host = "169.254.40.96";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);

            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);



            String sendMessage = massage + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : " + sendMessage);

            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("slm");
            String message = br.readLine();
            System.out.println("Message received from the server : " + message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            //Closing the socket
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}