package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer{
    private Map<String,String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("dog","小狗");
        dict.put("cat","小猫");
        dict.put("pig","小猪");
    }

    //重写process方法，在重写的方法中完成翻译的过程

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词不存在！");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
