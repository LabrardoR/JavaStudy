package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;
    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        //需要在创建 Socket 的同时，和服务器“建立连接”，此时就得告诉Socket服务器在哪里
        socket = new Socket(serverIp,serverPort);
    }
    public void start(){
        //tcp的客户端行为和udp的客户端差不多

        //1.从控制台读取用户输入的内容
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            PrintWriter writer = new PrintWriter(outputStream);
            Scanner scannerNetwork = new Scanner(inputStream);
            while(true){
                System.out.print("->");
                String request = scanner.next();
                //2.把字符串作为请求，发给服务器
                //  这里使用println。是为了让请求还没带上换行
                //  也就是和服务器读取请求，scanner。next呼应
                writer.println(request);
                writer.flush();
                //3.从服务器读取响应
                String response = scannerNetwork.next();
                //4.把响应显示到界面上
                System.out.println(response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
