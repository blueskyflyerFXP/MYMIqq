package view;

import mybeans.UserInfo;
import myutils.ImageByte;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;

/**
 * 用户资料显示面板
 */
public class userDataView extends JPanel{
    private int width=200;
    private int height=700;
    private int itemHeight=30;
    private UserInfo mydata=null;
    public userDataView(UserInfo mydata){
        this.mydata=mydata;
        init();
    }
    private JLabel photo=new JLabel("",JLabel.CENTER);
    private JLabel username=new JLabel("",JLabel.CENTER);
    private JLabel nickname=new JLabel("",JLabel.CENTER);
    private JLabel sex=new JLabel("",JLabel.CENTER);
    private JLabel signature=new JLabel("",JLabel.CENTER);
    private JLabel local=new JLabel("",JLabel.CENTER);
    private JLabel birthday=new JLabel("",JLabel.CENTER);
    private JLabel telephone=new JLabel("",JLabel.CENTER);
    private JLabel hobby=new JLabel("",JLabel.CENTER);
    private JLabel email=new JLabel("",JLabel.CENTER);
    private void init(){
        photo.setBounds(50,0,width,100);
        photo.setIcon(new ImageIcon(ImageByte.byte2image(mydata.getProtraitPicture(),"src//images//photo.jpg")));

        username.setBounds(0,100,width,itemHeight);
        username.setText("用户名："+mydata.getUsername());

        nickname.setBounds(0,100+itemHeight,width,itemHeight);
        nickname.setText("昵称："+mydata.getNickname());

        sex.setBounds(0,100+itemHeight*2,width,itemHeight);
        sex.setText("性别："+mydata.getSex());

        signature.setBounds(0,100+itemHeight*3,width,itemHeight*4);
        signature.setText("备注："+mydata.getSignature());

        local.setBounds(0,100+itemHeight*7,width,itemHeight);
        local.setText("所在地："+mydata.getLocale());

        birthday.setBounds(0,100+itemHeight*8,width,itemHeight);
        birthday.setText("生日："+mydata.getBirthday());

        telephone.setBounds(0,100+itemHeight*9,width,itemHeight);
        telephone.setText("电话："+mydata.getTelephone());

        hobby.setBounds(0,100+itemHeight*10,width,itemHeight*2);
        hobby.setText("爱好："+mydata.getHobby());

        email.setBounds(0,100+itemHeight*12,width,itemHeight);
        email.setText("邮件："+mydata.getEmail());

        this.add(photo);
        this.add(username);
        this.add(nickname);
        this.add(sex);
        this.add(signature);
        this.add(local);
        this.add(birthday);
        this.add(telephone);
        this.add(hobby);
        this.add(email);
        this.setBackground(Color.WHITE);
        this.setSize(width,height);
        this.setVisible(true);

    }
}
