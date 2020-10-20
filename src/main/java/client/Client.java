package client;
/**
 * 后发送请求
 */

import entity.ChangeInfo;
import entity.commonFunc;
import entity.TransmitInfo;
import mybeans.Users;
import myutils.ObjectTranslate;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * 客户端
 * 1）登陆功能：用户可以注册，登录。
 * 2）显示用户：将在线用户显示在列表中。
 * 3）接收信息：能接收其他用户发出的信息。
 * 4）发送信息：能发出用户要发出的信息。
 * 5）私聊功能：选择用户进行私聊。
 * 6）群聊功能：在群组里聊天
 */
public class Client {
    private static String clientIpAdress;

    static {
        try {
            clientIpAdress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static int clientPort = 8001;

    public Client() throws UnknownHostException{
    }

    public static String getClientIpAdress() {
        return clientIpAdress;
    }

    public static void setClientIpAdress(String clientIpAdress) {
        Client.clientIpAdress = clientIpAdress;
    }

    public static int getClientPort() {
        return clientPort;
    }

    public static void setClientPort(int clientPort) {
        Client.clientPort = clientPort;
    }

    /**
     * 发送信息
     *
     * @param user    使用发送的用户
     * @param funCode 功能码，判断意图
     * @param msgType 发送的消息的类型
     * @param list    发送的数据（一个或多个对象，用ArrayList存储)
     * @return 发送是否成功
     */
    public static boolean sendMessage(String user, int funCode, String msgType, Object list) throws UnknownHostException,IOException{
        Socket socket=getTCPSock();
        //设置来源
        ChangeInfo from = new ChangeInfo();
        from.setChangeAddress(socket.getLocalAddress().toString());
        from.setChangePort(socket.getLocalPort());
        from.setUsername(user);

        //设置去向
        ChangeInfo to = new ChangeInfo();
        to.setChangeAddress(socket.getRemoteSocketAddress().toString());
        to.setChangePort(socket.getPort());
        to.setUsername("");

        return commonFunc.send(socket, commonFunc.packMsg(from, to, funCode, msgType, list));
    }


    /**
     * 接收消息
     *
     * @return transmitInfo对象，封装了传输信息
     */
    public static TransmitInfo reveiceMessage() throws UnknownHostException,IOException {
        Socket socket=getTCPSock();
        System.out.println("客户端接收消息");
        return commonFunc.dimountMsg(commonFunc.receive(socket));
    }
    public static Socket getTCPSock() throws UnknownHostException,IOException {
        System.out.println("获取连接");
        return new Socket(InetAddress.getByName(clientIpAdress), 8001);
    }
    public static boolean login() {
        Socket loginSocket = null;
        int count=10;
        while (true) {
            try {
                System.out.println("开始连接服务");
                TransmitInfo transmitInfo = reveiceMessage();
                System.out.println("接受到服务器发送的消息");
                System.out.println(transmitInfo.getForm().getChangeAddress() + ":/" + transmitInfo.getForm().getChangePort());
                ArrayList msg = (ArrayList<Object>) transmitInfo.getTransmitContent();


                if(msg!=null&&msg.size()>0) {
                    Users my = (Users) msg.get(0);
                    System.out.println(my);
                }else {
                    System.out.println("数据丢失");
                }

                System.out.println("客户端发送消息");
                Users serMsg=new Users();
                serMsg.setUsername("fxp");
                serMsg.setPassword("123456");
                serMsg.setIdentCode("123");
                serMsg.setUid(12L);

                ArrayList<Users> users=new ArrayList<>();
                users.add(serMsg);

                sendMessage("",7,"server",users);
                System.out.println();

                System.out.println(getServerState());
                System.out.println();

            count--;
            if(count<=0){
                break;
            }
                //throw new Exception("自定义");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("服务器异常");
                break;
            }
        }
        return true;
    }


    //获取服务器就绪信息
    //如果服务器就绪，返回true，否则返回false
    public static boolean getServerState() throws Exception {
        TransmitInfo transServer = Client.reveiceMessage();
        if (transServer.getFunctionCode() == 5) {
            System.out.println("服务器就绪");
            return true;
        } else {
            System.out.println("服务器繁忙或错误");
            return false;
        }

    }

    //建立UDP连接，监听8002端口，接收来自服务器转发的消息，刷新主页面
    public static void UDPreceive() {
        //UDP连接
        DatagramSocket mysocket = null;
        //包装数据
        DatagramPacket mypacket = null;
        //一直接收
        while (true) {
            try {
                //监听8002端口
                mysocket = new DatagramSocket(9000);
                //设置接收包的长度
                byte[] buf = new byte[1024];
                mypacket = new DatagramPacket(buf, 1024);
                //接收信息
                System.out.println("MYMI:我正在等待信息");
                mysocket.receive(mypacket);
                System.out.println();
                System.out.println("MYMI:我收到了信息");

                //解析数据
                //TransmitInfo receiveMsg=(TransmitInfo) ObjectTranslate.ByteToObject(mypacket.getData());

                TransmitInfo receiveMsg = commonFunc.dimountMsg(mypacket.getData());
                System.out.println(receiveMsg);
                //处理收到的信息


                Thread.sleep(1000);
                mysocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        login();
        //UDPreceive();
    }
}
