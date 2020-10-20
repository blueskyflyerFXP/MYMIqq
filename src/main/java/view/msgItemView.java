package view;
/**
 * 聊天消息列表的元素显示面板
 */

import myutils.ObjectTranslate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class msgItemView extends JPanel {
    //头像的数据
    private byte[] photo = null;
    //用户名或者群名称
    private String name = "";
    //时间
    private String msgTime = "";
    //消息
    private String message = "";
    //消息的条数
    private int number = 0;

    //面板的大小
    private int width = 400;
    private int height = 40;


    //头像
    private JLabel headPhoto = new JLabel("", JLabel.CENTER);
    //用户或者群聊
    private JLabel user = new JLabel("", JLabel.LEFT);
    //消息时间
    private JLabel chatTime = new JLabel("", JLabel.RIGHT);
    //消息
    private JLabel chatMsg = new JLabel("", JLabel.CENTER);
    //收到消息的数目
    private JLabel msgNum = new JLabel("", JLabel.CENTER);
    //删除按钮
    private JLabel deleteMsg = new JLabel("删除", JLabel.CENTER);

    public msgItemView(byte[] photo, String name, String msgTime, String message, int number, int width, int height) {
        super();
        this.photo = photo;
        this.name = name;
        this.msgTime = msgTime;
        this.message = message;
        this.number = number;
        this.width=width;
        this.height=height;
        init();
    }

    public void setPhoto(byte[] photo) {
        headPhoto.setIcon(new ImageIcon((BufferedImage) ObjectTranslate.ByteToObject(photo)));
    }

    @Override
    public void setName(String name) {
        user.setText(name);
    }

    public void setMsgTime(String msgTime) {
        chatTime.setText(msgTime);
    }

    public void setMessage(String message) {
        chatMsg.setText(message);
    }

    public void setNumber(int number) {
        msgNum.setText(String.valueOf(number));
    }

    public void setSize(int width, int height) {
        this.setSize(width, height);
    }

    private void init() {
        //设置头像
        headPhoto.setBounds(0, 0, height, height);
        headPhoto.setIcon(new ImageIcon((BufferedImage) ObjectTranslate.ByteToObject(photo)));

        //设置用户名
        user.setBounds(height, 0, (width - height) * 3 / 8, height / 2);
        user.setFont(new Font("微软雅黑", Font.BOLD, 12));
        user.setText(name);

        //设置消息的时间
        chatTime.setBounds(height / 8 + width * 3 / 8, height / 2, (width - height) * 3 / 8, height / 2);
        chatTime.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        chatTime.setText(msgTime);

        //设置消息
        chatMsg.setBounds(height, 0, (width - height) * 3 / 8, height / 2);
        chatMsg.setFont(new Font("微软雅黑", Font.BOLD, 12));
        chatMsg.setText(message);

        //设置数量
        msgNum.setBounds(height / 8 + width * 3 / 8, height / 2, (width - height) * 3 / 8, height / 2);
        msgNum.setFont(new Font("微软雅黑", Font.BOLD, 16));
        msgNum.setText(String.valueOf(number));

        //设置删除按钮
        deleteMsg.setBounds(width * 3 / 4 + height / 4, height / 2, (width - height) / 2, height);
        deleteMsg.setFont(new Font("微软雅黑", Font.BOLD, 16));
        deleteMsg.setBackground(Color.red);
        JPanel that = this;

        this.add(headPhoto);
        this.add(user);
        this.add(chatTime);
        this.add(chatMsg);
        this.add(msgNum);
        this.add(deleteMsg);
        this.setSize(width, height);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setVisible(true);
    }

    //为面板中的头像添加鼠标事件
    public void addPhotoClick(MouseListener listener){
        headPhoto.addMouseListener(listener);
    }
}
