package network;
import java.io.IOException;
import java.net.*;
public class UdpEchoServer {
    //创建应该DatagramSocket对象，后续操作网卡的基础
    private DatagramSocket socket = null;

    //服务器和客户端都需要创建Socket对象
    //但是服务器的socket要显示指定端口号，而客户端的socket一般不能显式指定（系统自动分配随机端口）
    public UdpEchoServer(int port) throws SocketException {
        //手动分配端口
        socket = new DatagramSocket(port);
//        //自动分配端口
//        socket = new DatagramSocket();
    }
    public  void start() throws IOException {
        //通过这个方法来启动服务器
        System.out.println("服务器，启动！！");
        while(true){
            //1.读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            //服务器一启动就会执行到这里的receive方法，如果客户端还没有发来连接请求，就会进入阻塞状态

            //数据是以二进制文件存储在requestPacket中的，需要将其转成String      //此处的length是数据的真正长度
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());
            //2.根据请求计算响应
            //由于此处是回声服务器，请求是什么样，响应就是什么样
            String response = process(request);

            //3.把响应写回到客户端
            //  搞一个响应对象，DatagramPacket
            //  往DatagramPacket里构造刚才的数据，再通过send返回
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //4.打印一个日志，把这次数据交换的详细情况打印出来
            System.out.printf("[%s,%d] req=%s,resp=%s\n",responsePacket.getAddress().toString(),
                    responsePacket.getPort(),request,response);

        }
    }
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }

}
