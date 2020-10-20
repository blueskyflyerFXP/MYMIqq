package view;

import mybeans.ChatInfo;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * 好友消息查看和消息发送面板
 */
public class msgLookView  extends JPanel {
    private int width=800;
    private int itemHeight=80;
    private String myself="";
    private ArrayList<ChatInfo> chats=null;
    //消息显示面板
    private JScrollPane scrollPane=new JScrollPane();
    private JPanel msgList=new JPanel();

   //输入框
    private JTextArea input=new JTextArea(20,10);
    //按钮
    private JButton send=new JButton("发送");
    private JButton close=new JButton("关闭");

    private msgLookView(String myself,ArrayList<ChatInfo> chats){
        this.myself=myself;
        this.chats=chats;
        init();
    }
    private void init(){
        int num=chats.size();

        JLabel chatMsg=null;
        for (int i=0;i<num;i++){
            JPanel msgItem=new JPanel();
            msgItem.setLayout(null);
            msgItem.setBounds(0,itemHeight*i,width,itemHeight);
            String chatUser=chats.get(i).getYourself().trim();
            if(myself==chatUser){
                chatMsg=new JLabel(String.valueOf(chats.get(i).getMessage()),JLabel.RIGHT);
            }else {
                chatMsg=new JLabel(String.valueOf(chats.get(i).getMessage()),JLabel.RIGHT);
            }
            chatMsg.setBounds(0,0,width,60);
            JLabel chatTime=new JLabel(new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss").format(chats.get(i).getChatTime()),JLabel.CENTER);
            chatTime.setBounds(0,60,width,20);
            chatTime.setForeground(Color.GRAY);
            msgItem.add(chatMsg);
            msgItem.add(chatTime);
            msgList.add(msgItem);

        }
        msgList.setBackground(Color.WHITE);
        msgList.setPreferredSize(new Dimension(width,num*itemHeight));
        scrollPane.setViewportView(msgList);
        scrollPane.setBounds(0,0,width,400);
        input.setBounds(0,400,width,160);
        send.setBounds(width/4,560,40,20);
        close.setBounds(width*3/4-40,560,40,20);
        this.setLayout(null);
        this.add(scrollPane);
        this.add(input);
        this.add(send);
        this.add(close);
        this.setSize(800,600);
        this.setVisible(true);
    }
}
