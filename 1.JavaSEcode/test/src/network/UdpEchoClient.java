package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp = "";
    private int serverPort = 0;

    public UdpEchoClient(String ip,int port) throws SocketException {
        //不能手动分配端口
        socket = new DatagramSocket();
        //由于UDP自身不会持有对端的信息。就需要在应用程序里，将对端的情况记录下来
        //主要记录对端的ip和端口
        serverIp = ip;
        serverPort = port;
    }


    public void start() throws IOException {
        System.out.println("客户端，启动！");
        Scanner scanner = new Scanner(System.in);
        while(true){
            //1.从控制台读取数据，作为请求
            System.out.print("->");
            String request = scanner.next();
            //2.把请求内容构造成 DatagramPacket对象。发给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length, InetAddress.getByName(serverIp),serverPort);
            //用到了3个DatagramPacket的构造方法
            //1.只指定字节数组缓冲区的（服务器收请求的时候需要使用，客户端收响应的时候也需要使用）
            //2.指定字节数组缓冲区，同时指定一个InetAddress对象（这个对象就同时包含了IP和端口）（服务器返回响应给客户端）
            //3.指定字节数组缓冲区，同时指定IP + 端口号
            socket.send(requestPacket);
            //3.尝试读取服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            //4.把响应转换成字符串，并显示出来
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println(response);
        }

    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
