import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        // 从用户输入获取数据
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        // 创建UDP客户端套接字
        DatagramSocket clientSocket = new DatagramSocket();

        // 指定服务器地址
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[10];
        byte[] receiveData = new byte[10];

        // 发送数据到服务器
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        // 接收来自服务器的数据报
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        // 解析并打印服务器响应
        String modifiedSentence = new String(receivePacket.getData());

        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}
