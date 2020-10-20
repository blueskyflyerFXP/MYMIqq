package servers;
/**
 * 先发送请求
 */

import entity.ChangeInfo;
import entity.TransmitInfo;
import entity.commonFunc;
import mybeans.Users;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 服务端
 * 1)检验登陆信息：检查登陆信息是否正确，并向客户端返回登陆信息，如信息正确。就允许用户登陆。
 * 2)显示在线状态：将该用户的状态发给各在线用户。
 * 3)转发聊天信息：将消息转发给所有在线的用户。
 */
public class Server {
    private static String serverIpAdress;
    private static int serverPort=8001;
    private static ServerSocket mysocket;

    static {
        try {
            serverIpAdress = InetAddress.getLocalHost().getHostAddress();
            mysocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public Server() throws IOException {
    }

    public Server(String serverIpAdress, int serverPort) throws IOException {
        Server.serverIpAdress = serverIpAdress;
        Server.serverPort = serverPort;
    }

    public static String getServerIpAdress() {
        return serverIpAdress;
    }

    public static void setServerIpAdress(String serverIpAdress) {
        Server.serverIpAdress = serverIpAdress;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public static void setServerPort(int serverPort) {
        Server.serverPort = serverPort;
    }

    /**
     * 发送信息
     * @param user 使用发送的用户
     * @param funCode 功能码，判断意图
     * @param msgType 发送的消息的类型
     * @param list 发送的消息（一个或多个对象，用ArrayList存储)
     * @return 发送是否成功
     */
    public static boolean sendMessage(Socket socket,String user,int funCode, String msgType, Object list) throws IOException {

        //获取TCP连接
        //Socket socket=getSocket();
        System.out.println("服务器发送消息");
        //设置来源
        ChangeInfo from=new ChangeInfo();
        from.setChangeAddress(socket.getLocalAddress().toString());
        from.setChangePort(socket.getLocalPort());
        from.setUsername(null);

        //设置去向
        ChangeInfo to=new ChangeInfo();
        to.setChangeAddress(socket.getRemoteSocketAddress().toString());
        to.setChangePort(socket.getPort());
        to.setUsername(user);

        return commonFunc.send(socket,commonFunc.packMsg(from,to,funCode,msgType,list));
    }

    /**
     * 接收消息
     * @return transmitInfo对象，封装了传输信息
     */
    public static TransmitInfo reveiceMessage(Socket socket) throws IOException {

        //获取TCP连接
       // Socket socket=getSocket();
        //System.out.println("服务器接收消息");
        return commonFunc.dimountMsg(commonFunc.receive(socket));
    }
    public static Socket getSocket() throws IOException {
        return mysocket.accept();
    }

    //提供服务
    public  void myServer(){
        try {
            System.out.println("服务启动");
            Users getuser=null;
            while (true) {

                System.out.println("正在监听客户端，等待客户端接入");

                Users serMsg = new Users();
                serMsg.setUsername("fxp");
                serMsg.setPassword("123456");
                serMsg.setIdentCode("123");
                serMsg.setUid(12L);
                ArrayList<Users> users = new ArrayList<>();
                users.add(serMsg);

                //发送服务器已就绪
                Server.sendMessage(getSocket(),null, 11, "server", users);

                System.out.println("服务器接受信息");
                TransmitInfo transmitInfo = reveiceMessage(getSocket());
                System.out.println(transmitInfo.getForm().getChangeAddress() + ":/" + transmitInfo.getForm().getChangePort());
                ArrayList<Object> msg = (ArrayList<Object>) transmitInfo.getTransmitContent();
                if (msg != null && msg.size() > 0) {
                    Users my = (Users) msg.get(0);
                    System.out.println(my);
                } else {
                    System.out.println("数据丢失");
                }

                responseServerState(true);
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("服务器断开");
            System.out.println("正在重启服务器。。。。。");
            this.myServer();
        }
    }
    public static boolean responseServerState(boolean state) throws Exception{
        if(state){
            return sendMessage(getSocket(),"",5,"server",null);
        }else {
            return sendMessage(getSocket(),"",6,"server",null);
        }

    }
    public static void main(String[] args)throws Exception{
        Server server=new Server();
        server.myServer();

    }
}
