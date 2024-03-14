import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 1234; // 可以更改为任意未被使用的端口

        ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("Echo from server: " + inputLine);
            }
            //return a number


    }
}

