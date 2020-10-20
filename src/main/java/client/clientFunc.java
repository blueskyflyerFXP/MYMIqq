package client;/*
package client;

import entity.TransmitInfo;
import mybeans.*;
import myutils.ObjectTranslate;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

*/

import client.Client;
import entity.TransmitInfo;
import mybeans.ChatInfo;
import mybeans.Groups;
import mybeans.UserInfo;
import mybeans.Users;
import myutils.ObjectTranslate;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 客户端的服务
 */


public class clientFunc {

    //登录账号
    private boolean loginAccount(Users info){
        Socket tcp=null;
        try {

                //发送登录账号请求，同时传输Users对象
                Client.sendMessage(info.getUsername(),11,"login",info);
                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("密码检验成功，正在登录并获取信息");
                    //创建用户空间

                    //获取聊天信息

                    //获取好友列表

                    //获取群组列表

                    //把获取的信息存入临时文件

                    //打开主页面，把信息写入页面指定地方
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(info.getUsername(),6,"client",null);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //注册用户
    private boolean registerAccount(String user, Users users, UserInfo userInfo){
        boolean result=true;
        try {

                //发送注册账号请求，同时传输Users对象和UserInfo对象
                //把发送的信息封装为ArrayList
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(users);
                mydata.add(userInfo);

                Client.sendMessage(user,11,"login",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("用户注册成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("用户名已存在");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(user,6,"client",null);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }

    //修改自己的资料
    private boolean modifyData(UserInfo userInfo){

        boolean result=true;
        try {

                //发送修改资料请求，同时传输UserInfo对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(userInfo);
                Client.sendMessage(userInfo.getUsername(),11,"updateUserInfo",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("修改成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("修改失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(userInfo.getUsername(),6,"updateUserInfo",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //获取聊天列表
    private boolean getChatList(Users users){
        boolean result=true;
        try {

                //发送获取聊天列表请求，同时传输Users对象
                //把发送的信息封装为ArrayList
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(users);


                Client.sendMessage(users.getUsername(),11,"getChatList",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("获取成功");
                    //获取好友列表和群组列表

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("获取失败");
                    //返回主页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(users.getUsername(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //获取好友列表
    private boolean getFriendList(Users users){
        boolean result=true;
        try {

                //发送获取好友列表请求，同时传输Users对象
                //把发送的信息封装为ArrayList
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(users);


                Client.sendMessage(users.getUsername(),11,"getChatList",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("获取成功");
                    //获取好友列表和群组列表

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("获取失败");
                    //返回主页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(users.getUsername(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //获取群组列表
    private boolean getGroupList(Users users){
        boolean result=true;
        try {
                //发送获取群组列表请求，同时传输Users对象
                //把发送的信息封装为ArrayList
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(users);


                Client.sendMessage(users.getUsername(),11,"getChatList",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("获取成功");
                    //获取好友列表和群组列表

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("获取失败");
                    //返回主页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(users.getUsername(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //创建用户空间
    private boolean createUserSpace(UserInfo myinfo, ArrayList<ChatInfo> chatList, ArrayList<Users> friendList, ArrayList<Groups> groupList){
        //把聊天信息、好友列表、群组列表写入文件
        // 把列表信息加入主页面
        File self=new File("src//bufferFile//self.txt");
        File chat=new File("src//bufferFile//chat.txt");
        File friend=new File("src//bufferFile//friend.txt");
        File group=new File("src//bufferFile//group.txt");
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;
        boolean result=true;
        try {
            //个人信息存入文件
            fos=new FileOutputStream(self);
            bos=new BufferedOutputStream(fos);
            bos.write(ObjectTranslate.ObjectToByte(myinfo));
            //聊天信息存入文件
            fos=new FileOutputStream(chat);
            bos=new BufferedOutputStream(fos);
            bos.write(ObjectTranslate.ObjectToByte(chatList));
            //好友信息存入文件
            fos=new FileOutputStream(friend);
            bos=new BufferedOutputStream(fos);
            bos.write(ObjectTranslate.ObjectToByte(friendList));
            //群组信息存入文件
            fos=new FileOutputStream(group);
            bos=new BufferedOutputStream(fos);
            bos.write(ObjectTranslate.ObjectToByte(groupList));
        }catch (Exception e){
            e.printStackTrace();
            result=false;
        }
        return result;
    }
    //用户登录成功时时先加载用户空间
    private boolean loadUserSpace(){
        //读取文件里的聊天信息、好友列表、群组列表
        // 把列表信息加入主页面
        File self=new File("src//bufferFile//self.txt");
        File chat=new File("src//bufferFile//chat.txt");
        File friend=new File("src//bufferFile//friend.txt");
        File group=new File("src//bufferFile//group.txt");
        FileInputStream fis=null;
        BufferedInputStream bis=null;
        boolean result=true;
        try {
            //个人信息存入文件
            fis=new FileInputStream(self);
            bis=new BufferedInputStream(fis);
            TransmitInfo my=(TransmitInfo)ObjectTranslate.ByteToObject(bis.readAllBytes());
            //聊天信息存入文件
            fis=new FileInputStream(self);
            bis=new BufferedInputStream(fis);
            ArrayList<ChatInfo> chatList=(ArrayList<ChatInfo>)ObjectTranslate.ByteToObject(bis.readAllBytes());
            //好友信息存入文件
            fis=new FileInputStream(self);
            bis=new BufferedInputStream(fis);
            ArrayList<Users> friendList=(ArrayList<Users>) ObjectTranslate.ByteToObject(bis.readAllBytes());
            //群组信息存入文件
            fis=new FileInputStream(self);
            bis=new BufferedInputStream(fis);
            ArrayList<Groups> groupList=(ArrayList<Groups>) ObjectTranslate.ByteToObject(bis.readAllBytes());


            //把列表里的数据写入主页面
        }catch (Exception e){
            e.printStackTrace();
            result=false;
        }
        return result;
    }

    //私聊
    private boolean privateChat(ChatInfo chat){

        boolean result=true;
        try {

                //发送私聊请求，同时传输ChatInfo对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(chat);
                Client.sendMessage(chat.getYourself(),11,"privateChat",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(chat.getYourself(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //群聊
    private boolean groupChat(ChatInfo chatGroup){

        boolean result=true;
        try {

                //发送群聊请求，同时传输UserInfo对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(chatGroup);
                Client.sendMessage(chatGroup.getYourself(),11,"groupChat",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(chatGroup.getYourself(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }

    //加好友
    private boolean addFriend(Users users){

        boolean result=true;
        try {
                //发送加好友请求，同时传输Users对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(users);
                Client.sendMessage(users.getUsername(),11,"addFriend",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(users.getUsername(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }

    //申请加群
    private boolean joinGroup(ChatInfo chatInfo){

        boolean result=true;
        try {
                //发送修改资料请求，同时传输UserInfo对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(chatInfo);
                Client.sendMessage(chatInfo.getYourself(),11,"joinGroup",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(chatInfo.getYourself(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //邀请入群
    private boolean inviteJoinGroup(ChatInfo chatInfo){
        boolean result=true;
        try {
                //发送邀请入群请求，同时传输ChatInfo对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(chatInfo);
                Client.sendMessage(chatInfo.getYourself(),11,"joinGroup",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(chatInfo.getYourself(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //同意好友请求
    private boolean agreeMakeFriend(ChatInfo chatInfo) {
        boolean result = true;
        try {

                //发送同意好友请求，同时传输UserInfo对象
                ArrayList<Object> mydata = new ArrayList<>();
                mydata.add(chatInfo);
                Client.sendMessage(chatInfo.getYourself(),11,"joinGroup",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(chatInfo.getYourself(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //同意入群请求
    private boolean agreeJoinIn(ChatInfo chatInfo){

        boolean result=true;
        try {
                //发送同意入群请求，同时传输ChatInfo对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(chatInfo);
                Client.sendMessage(chatInfo.getYourself(),11,"joinGroup",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(chatInfo.getYourself(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
    //同意入群邀请
    private boolean agreeInvite(ChatInfo chatInfo){
        boolean result=true;
        try {

                //发送同意邀请请求，同时传输ChatInfo对象
                ArrayList<Object> mydata=new ArrayList<>();
                mydata.add(chatInfo);
                Client.sendMessage(chatInfo.getYourself(),11,"joinGroup",mydata);

                //接收服务器的返回结果
                TransmitInfo serResult=Client.reveiceMessage();
                //处理返回的结果
                if(serResult.getFunctionCode()==15){
                    System.out.println("发送成功");
                    //返回登录页面

                }else if(serResult.getFunctionCode()==16){
                    System.out.println("发送失败");
                    //返回注册页面,提示信息

                }else {
                    System.out.println("服务器错误！");
                    result=false;
                }
                //向服务器发送已经收到结果，请求关闭连接
                Client.sendMessage(chatInfo.getYourself(),6,"client",mydata);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }
}

