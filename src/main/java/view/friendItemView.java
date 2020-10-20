package view;

import myutils.ObjectTranslate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
/**
 * 组件
 * 显示好友列表的元素
 *
 */
public class friendItemView extends JPanel{
    //头像的数据
    private byte[] photo = null;
    //用户名或者群名称
    private String name = "";
    //签名
    private String signure = "";


    //面板的大小
    private int width = 400;
    private int height = 40;


    //头像
    private JLabel headPhoto = new JLabel("", JLabel.CENTER);
    //用户或者群聊
    private JLabel user = new JLabel("", JLabel.LEFT);
    //消息时间
    private JLabel signShow = new JLabel("", JLabel.RIGHT);

    public friendItemView(byte[] photo, String name, String signure, int width, int height) {
        super();
        this.photo = photo;
        this.name = name;
        this.signure=signure;
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

    public void setSignure(String signure) {
        signShow.setText(signure);
    }



    private void init() {
        //设置头像
        headPhoto.setBounds(0, 0, height, height);
        headPhoto.setIcon(new ImageIcon((BufferedImage) ObjectTranslate.ByteToObject(photo)));

        //设置用户名
        user.setBounds(height, 0, width - height, height / 2);
        user.setFont(new Font("微软雅黑", Font.BOLD, 12));
        user.setText(name);

        //设置消息的时间
        signShow.setBounds(height, height / 2, width - height, height / 2);
        signShow.setFont(new Font("微软雅黑", Font.PLAIN, 10));
        signShow.setText(signure);



        this.add(headPhoto);
        this.add(user);
        this.add(signShow);
        this.setSize(width, height);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setVisible(true);
    }

    //为头像添加鼠标事件
    public void addPhotoClick(MouseListener listener){
        headPhoto.addMouseListener(listener);
    }
}
