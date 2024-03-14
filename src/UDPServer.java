import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        // 创建UDP服务器套接字并指定端口
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[10];
        byte[] sendData = new byte[10];

        while (true) {
            // 接收来自客户端的数据报
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            // 解析数据报内容
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            // 处理接收的数据并回复
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
