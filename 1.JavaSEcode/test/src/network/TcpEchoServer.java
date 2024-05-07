package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Tcp面向字节流
public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException{
        System.out.println("服务器，启动！");
        ExecutorService service = Executors.newCachedThreadPool();
        while(true) {
            //通过accept方法，把内核中已经建立好的连接拿到应用程序中
            //建立连接的细节流程都是内核自动完成的，应用程序只需要“捡现成”的
            Socket clientSocket = serverSocket.accept();
            //此处不应该执教调用processConnection，回导致服务器不能处理多个客户端
            //应该创建新的线程来调用
//            Thread t = new Thread(()->{
//                try {
//                    processConnection(clientSocket);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            })
//              t.start();
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
    public void processConnection(Socket clientSocket) throws IOException {
        //进入方法，先打印一个日志，表示当时有客户端连上了
        System.out.printf("[%s:%d] 客户端上线！\n",clientSocket.getInetAddress(),clientSocket.getPort());

        //进行数据交互
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
           //使用try()方法，避免后续用完了流对象忘记关闭。
           //由于客户端发来的数据可能是“多条数据”=》针对多条数据进行循环处理
            while(true){
                Scanner scanner = new Scanner(inputStream);

                if(!scanner.hasNext()){
                    //连接断开，循环结束
                    System.out.printf("[%s,%d] 客户端下线！\n",clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }
                //1. 读取请求并解析，此处就以next来作为读取请求的方式=》读到“空白符”next就返回
                String request = scanner.next();
                //2. 根据需求，计算响应
                String response = process(request);
                //3. 把响应写回到客户端
                //   可以把String转成字节数组，写入到OutputStream
                //   也可以使用 PrintWriter 把OutputStream包裹一下写入字符串
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                //此处的打印，不是打印到控制台，而是写入到outputStream对应的流对象中，也就是写入到clientSocket里面
                //自然这个数据也就通过网络发送出去了，发给当前这个连接的另外一段
                printWriter.flush();
                //4. 打印一下这次请求交互过程的内容
                System.out.printf("[%s:%d] req=%s, resp=%s\n",clientSocket.getInetAddress(),clientSocket.getPort(),request,response);

            }


        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                clientSocket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    public String process(String request){
        //此处也是写的回显服务器，响应和请求是一样的
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
