package servers;

import dao.*;
import entity.ChangeInfo;
import entity.TransmitInfo;
import entity.commonFunc;
import mybeans.*;
import myutils.ObjectTranslate;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class serverFunc {

    //功能认证码
    private int[] funCodes = {1, 2};

    //服务器任务管理
    public static boolean taskMangement(Socket socket, int functionCode, Object data) {
        switch (functionCode) {
            case 1:
                break;
            case 2:
                break;
            default:

        }

        return true;
    }

    //用UDP转发消息
    public static void UDPsend(String user,int funCode,String msgType,Object data,String toIP){

        DatagramSocket mysocket=null;
        DatagramPacket mypacket=null;
        try {
            //设置来源和去向的信息
            ChangeInfo from=new ChangeInfo();
            from.setChangeAddress(InetAddress.getLocalHost().getHostAddress());
            from.setChangePort(9000);
            from.setUsername(user);

            ChangeInfo to=new ChangeInfo();
            to.setChangeAddress(toIP);
            to.setChangePort(9000);
            to.setUsername("");
            //包装（加密）
//            TransmitInfo transmitInfo=new TransmitInfo();
//            transmitInfo.setForm(from);
//            transmitInfo.setTo(to);
//            transmitInfo.setFunctionCode(funCode);
//            transmitInfo.setTransmitType(msgType);
//            transmitInfo.setTransmitContent(data);
//            byte[] sendMsg= ObjectTranslate.ObjectToByte(transmitInfo);
             byte[] sendMsg=commonFunc.packMsg(from,to,funCode,msgType,data);
            //建立UDP
            mysocket = new DatagramSocket();
             //发送消息
            DatagramPacket sendpacket=new DatagramPacket(sendMsg,sendMsg.length, InetAddress.getByName(toIP),9000);
            mysocket.send(sendpacket);
            Thread.sleep(1000);
            mysocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //转发聊天信息
    private void forwadMessage(ChatInfo chatInfo,int funCode,String msgType,Object data) throws Exception{
        //查询用户在线状态
        LoginInfo userState = new LoginInfoDao().queryLogin(chatInfo.getChatUser());
        //如果用户在线，转发好友请求
        if(userState.getOnlineState()){
           UDPsend(chatInfo.getYourself(),funCode,msgType,data,"192.168.43.99");
        }
    }

    //检查用户在线状态
    private boolean tryConnectUser(String IpAdress, int port) {
        return true;
    }

    //登录账号
    private void loginAccount(Socket socket, Object data) throws Exception {
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        //解析data
        Users myuser = (Users) mylist.get(0);

        //验证用户存在及密码
        int returnnum = new UsersDao().queryUser(myuser.getUsername(), myuser.getPassword(), myuser.getIdentCode());
        //发送验证结果到客户端
        switch (returnnum) {
            case 2://用户存在且验证成功
                Server.sendMessage(socket, "",11, "server",null);
                break;
            case 1://密码错误
                Server.sendMessage(socket, "",12,  "server",null);
                break;
            case 0://用户不存在
                Server.sendMessage(socket, "",13,"server", null);
                break;
            case -2://服务器异常
                Server.sendMessage(socket, "",7,"server", null);
                break;

        }
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }

    }

    //注册用户
    private void registerAccount(Socket socket, Object data) throws Exception{
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        Users user = (Users) mylist.get(0);
        UserInfo userInfo = (UserInfo) mylist.get(1);
        //查询Users，判断用户是否存在
        int queryResult = new UsersDao().queryUser(user.getUsername(), user.getPassword(), user.getIdentCode());

            if (queryResult > 0) {
                int addresult = new UserInfoDao().addUserInfo(userInfo);
                if(addresult>0){
                    //用户名已存在，注册失败
                    Server.sendMessage(socket, null, 13, "server", null);
                }else{
                    //数据库操作失败
                    Server.sendMessage(socket, null, 7, "server", null);
                }
            } else if(queryResult==0){
                //用户名不存在，注册成功
                Server.sendMessage(socket, null, 12, "server", null);
            }else {
                //数据库操作失败
                Server.sendMessage(socket, null, 7, "server", null);
            }
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }

    }

    //修改自己的资料
    private void modifyData(Socket socket,Object data) throws Exception{
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        UserInfo userInfo=(UserInfo)mylist.get(0);
        int result=new UserInfoDao().updateUserInfo(userInfo);
        if(result>0){
            //修改资料成功
            Server.sendMessage(socket, null, 37, "server", null);
        }else if(result==0){
            //修改资料失败
            Server.sendMessage(socket, null, 38, "server", null);
        }else {
            //数据库操作异常
            Server.sendMessage(socket, null, 7, "server", null);
        }
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }
    }

    //获取聊天列表
    private void getChatList(Socket socket,Object data) throws Exception{
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        ChatInfo chat=(ChatInfo)mylist.get(0);
        ArrayList<ChatInfo> result=new ChatInfoDao().queryChat(chat);
        //返回查询结果
        Server.sendMessage(socket, null, 19, "server", result);
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }
    }


    //获取好友列表
    private void getFriendList(Socket socket,Object data) throws Exception{
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        Users users=(Users)mylist.get(0);
        ArrayList<String> result=new FriendInfoDao().queryFriend(users.getUsername());
        //返回查询结果
        Server.sendMessage(socket, null, 22, "server", result);
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }
    }

    //获取群组列表
    private void getGroupList(Socket socket, Object data) throws Exception{
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        Groups group=(Groups)mylist.get(0);
        //查询所加的群组列表
        ArrayList<String> result=new GroupInfoDao().queryGroups(group.getGroupname());
        //返回查询结果
        Server.sendMessage(socket, null, 22, "server", result);
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }
    }


    //私聊
    private void privateChat(Socket socket,Object data)throws Exception {
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        ChatInfo chatInfo=(ChatInfo)mylist.get(0);
        //把聊天信息存入数据库
        int result=new ChatInfoDao().addChat(chatInfo);
        //查询聊天对象的信息
        LoginInfo login=new LoginInfoDao().queryLogin(chatInfo.getChatUser());
        //如果聊天对象处于在线状态，打开TCP连接，转发消息

        //返回查询结果
        Server.sendMessage(socket, null, 22, "server", result);
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }
        if(login.getOnlineState()){
            Socket sendSocket=new Socket(login.getUserIp(),8002);
            Server.sendMessage(sendSocket,login.getUsername(),47,chatInfo.getMsgType(),chatInfo.getMessage());
            sendSocket.close();
        }
    }

    //群聊
    private void groupChat(Socket socket,Object data)throws Exception {
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        ChatInfo chatInfo=(ChatInfo)mylist.get(0);
        //把聊天信息存入数据库
        int result=new ChatInfoDao().addChat(chatInfo);
        //返回查询结果
        Server.sendMessage(socket, null, 22, "server", result);
        //接收客户端的回复
        TransmitInfo mytrans = Server.reveiceMessage(socket);
        //如果客户端回复收到最终结果，关闭连接
        if (mytrans.getFunctionCode() == 6) {
            socket.close();
        }

        //查询发消息的群成员
        ArrayList<String> groupMember=new GroupInfoDao().queryUsers(chatInfo.getChatUser());
        for(String user:groupMember){
            //查询聊天对象的信息
            LoginInfo login=new LoginInfoDao().queryLogin(chatInfo.getChatUser());
            //如果聊天对象处于在线状态，打开TCP连接，转发消息
            if(login.getOnlineState()){
                Socket sendSocket=new Socket(login.getUserIp(),8002);
                Server.sendMessage(sendSocket,login.getUsername(),47,chatInfo.getMsgType(),chatInfo.getMessage());
                sendSocket.close();
            }
        }


    }


    //加好友
    private void addFriend(Socket socket,Object data)throws Exception {
        //解析客户端发来的信息
        ArrayList<Object> mylist=(ArrayList<Object>) data;
        ChatInfo chat=(ChatInfo)mylist.get(0);
        //查询好友是否存在
        int friend=new UsersDao().queryUser(chat.getChatUser(),"","");
        if(friend>0){
            //用户存在
            Server.sendMessage(socket,null,23,"server",null);
        }else if(friend==0){
            //用户不存在
            Server.sendMessage(socket,null,23,"server",null);
        }else {
            //服务器错误
            Server.sendMessage(socket,null,23,"server",null);
        }
        //接收客户端的下一步指示，如果用户存在，客户端回复继续
        //如果用户不存在，客户端发送断开连接
        TransmitInfo back=Server.reveiceMessage(socket);
        if(back.getFunctionCode()==29) {
            //把好友请求写入ChatInfo
            int result = new ChatInfoDao().addChat(chat);
            //查询加好友用户在线状态
            LoginInfo userState = new LoginInfoDao().queryLogin(chat.getChatUser());
            //如果加好友的用户在线，转发好友请求
            if(userState.getOnlineState()){
                Socket sendMSg=new Socket(userState.getUserIp(),8002);
                //转发好友请求
                Server.sendMessage(sendMSg,chat.getYourself(),45,"addfriend",chat.getMessage());
            }
            //
            if (result > 0) {
                //数据库操作成功，回复客户端
                Server.sendMessage(socket, null, 42, "server", null);
            } else if (result == 0) {
                //数据库操作失误
                Server.sendMessage(socket, null, 42, "server", null);
            } else {
                //服务器错误
                Server.sendMessage(socket, null, 42, "server", null);
            }
        }
        //接收客户端已收到的回复
        TransmitInfo clientinfo=Server.reveiceMessage(socket);
        if(clientinfo.getFunctionCode()==6){
            if(socket!=null) {
                socket.close();
            }
        }
    }

    //申请加群
    private void joinGroup(Socket socket,Object data)throws  Exception {
        //解析客户端发来的信息
        ArrayList<Object> mylist=(ArrayList<Object>) data;
        ChatInfo chat=(ChatInfo)mylist.get(0);

        //收到申请加群请求后先查询是否存在该群
        ArrayList<Groups> existGroup=new GroupsDao().queryGroup(chat.getChatUser());

        if(existGroup==null||existGroup.size()==0){
            //所加的群不存在
            Server.sendMessage(socket,null,12,"server",null);
        }else {
            //所加的群存在
            //获取群主
            String user=existGroup.get(0).getGroupOwer();
            //把加群请求写入群主的ChatInfo
            int result=new ChatInfoDao().addChat(chat);
            //查询群主在线状态
            LoginInfo owerState=new LoginInfoDao().queryLogin(user);
            //如果群主在线，转发加群请求
            if(owerState.getOnlineState()){
                //建立连接
                Socket sendMsg=new Socket(owerState.getUserIp(),8002);
                //向群主发送好友请求
                Server.sendMessage(sendMsg,chat.getYourself(),23,"addgroup",chat);
            }
        }
        //接收客户端已收到的回复
        TransmitInfo clientinfo=Server.reveiceMessage(socket);
        if(clientinfo.getFunctionCode()==6){
            if(socket!=null) {
                socket.close();
            }
        }
    }

    //邀请入群
    private void inviteJoinGroup(Socket socket,Object data)throws Exception {
        //解析客户端发来的信息
        ArrayList<Object> mylist=(ArrayList<Object>) data;
        ChatInfo chat=(ChatInfo)mylist.get(0);

            //把邀请好友请求写入ChatInfo
            int result = new ChatInfoDao().addChat(chat);
            //查询加好友用户在线状态
            LoginInfo userState = new LoginInfoDao().queryLogin(chat.getChatUser());
            //如果加好友的用户在线，转发好友请求
            if(userState.getOnlineState()){
                Socket sendMSg=new Socket(userState.getUserIp(),8002);
                //转发好友请求
                Server.sendMessage(sendMSg,chat.getYourself(),45,"inviteJoinGroup",chat.getMessage());
            }
            //
            if (result > 0) {
                //数据库操作成功，回复客户端
                Server.sendMessage(socket, null, 42, "server", null);
            } else if (result == 0) {
                //数据库操作失误
                Server.sendMessage(socket, null, 42, "server", null);
            } else {
                //服务器错误
                Server.sendMessage(socket, null, 42, "server", null);
            }

        //接收客户端已收到的回复
        TransmitInfo clientinfo=Server.reveiceMessage(socket);
        if(clientinfo.getFunctionCode()==6){
            if(socket!=null) {
                socket.close();
            }
        }
    }

    //同意好友请求
    private void agreeMakeFriend(Socket socket,Object data)throws  Exception {
        //接收来自客户端的消息
        TransmitInfo trans=Server.reveiceMessage(socket);
        ArrayList<Object> mylist=(ArrayList<Object>) trans.getTransmitContent();
        ChatInfo chat=(ChatInfo)mylist.get(0);

            //把同意好友请求写入ChatInfo
            int result = new ChatInfoDao().addChat(chat);
            //把好友信息写入FriendInfo
            FriendsInfo friend=new FriendsInfo();
            friend.setMyself(chat.getYourself());
            friend.setFriend(chat.getChatUser());
            friend.setRemark("");
            friend.setShipTime(new Date());
            int makeFriend=new FriendInfoDao().addFriend(friend);
            //查询加好友用户在线状态
            LoginInfo userState = new LoginInfoDao().queryLogin(chat.getChatUser());
            //如果加好友的用户在线，转发好友请求
            if(userState.getOnlineState()){
                Socket sendMSg=new Socket(userState.getUserIp(),8002);
                ArrayList<Object> msg=new ArrayList<>();
                msg.add(chat.getMessage());
                msg.add(friend);
                //转发好友请求
                Server.sendMessage(sendMSg,chat.getYourself(),45,"makefriend",chat.getMessage());
            }
            //
            if (result > 0) {
                //数据库操作成功，回复客户端
                Server.sendMessage(socket, null, 42, "server", null);
            } else if (result == 0) {
                //数据库操作失误
                Server.sendMessage(socket, null, 42, "server", null);
            } else {
                //服务器错误
                Server.sendMessage(socket, null, 42, "server", null);
            }

        //接收客户端已收到的回复
        TransmitInfo clientinfo=Server.reveiceMessage(socket);
        if(clientinfo.getFunctionCode()==6){
            if(socket!=null) {
                socket.close();
            }
        }
    }

    //同意入群
    private void agreeJoinIn(Socket socket,Object data) throws Exception{
        //接收来自客户端的消息
        TransmitInfo trans=Server.reveiceMessage(socket);
        ArrayList<Object> mylist=(ArrayList<Object>) trans.getTransmitContent();
        ChatInfo chat=(ChatInfo)mylist.get(0);

        //把同意入群请求写入ChatInfo
        int result = new ChatInfoDao().addChat(chat);
        //把加群信息写入GroupsInfo
        GroupsInfo joingroup=new GroupsInfo();
        joingroup.setYourself(chat.getYourself());
        joingroup.setGroup(chat.getChatUser());
        joingroup.setJoinTime(new Date());
        int makeFriend=new GroupInfoDao().addGroupInfo(joingroup);
        //查询加好友用户在线状态
        LoginInfo userState = new LoginInfoDao().queryLogin(chat.getChatUser());
        //如果加好友的用户在线，转发好友请求
        if(userState.getOnlineState()){
            Socket sendMSg=new Socket(userState.getUserIp(),8002);
            ArrayList<Object> msg=new ArrayList<>();
            msg.add(chat.getMessage());
            msg.add(joingroup);
            //转发好友请求
            Server.sendMessage(sendMSg,chat.getYourself(),45,"joingroup",chat.getMessage());
        }
        //
        if (result > 0) {
            //数据库操作成功，回复客户端
            Server.sendMessage(socket, null, 42, "server", null);
        } else if (result == 0) {
            //数据库操作失误
            Server.sendMessage(socket, null, 42, "server", null);
        } else {
            //服务器错误
            Server.sendMessage(socket, null, 42, "server", null);
        }

        //接收客户端已收到的回复
        TransmitInfo clientinfo=Server.reveiceMessage(socket);
        if(clientinfo.getFunctionCode()==6){
            if(socket!=null) {
                socket.close();
            }
        }
    }
    //删除好友
    private  void deleteFriend(Socket socket,Object data)throws Exception{
        //解析数据
        ArrayList<Object> mylist=(ArrayList<Object>)data;
        ChatInfo chat=(ChatInfo)mylist.get(0);

        //删除FriendInfo
        int result=new FriendInfoDao().deleteFriend(chat.getYourself(),chat.getChatUser());
        forwadMessage(chat,11,"deleteFriend",chat.getMessage());
        //
        if (result > 0) {
            //数据库操作成功，回复客户端
            Server.sendMessage(socket, null, 42, "server", null);
        } else if (result == 0) {
            //数据库操作失误
            Server.sendMessage(socket, null, 42, "server", null);
        } else {
            //服务器错误
            Server.sendMessage(socket, null, 42, "server", null);
        }
        //接收客户端已收到的回复
        TransmitInfo clientinfo=Server.reveiceMessage(socket);
        if(clientinfo.getFunctionCode()==6){
            if(socket!=null) {
                socket.close();
            }
        }
    }

    //退出群聊
    private void leaveGroup(Socket socket,Object data){

    }

    //解散群聊
    private void deleteGroup(Socket socket,Object data){

    }
}
