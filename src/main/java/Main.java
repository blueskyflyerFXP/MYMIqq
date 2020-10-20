import dao.UserInfoDao;
import dao.UsersDao;
import mybeans.UserInfo;
import mybeans.Users;
import myutils.JdbcUtils;
import myutils.validateCode;
import view.LoginView;
import view.strVerticalNav;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public  class Main{
    public static void main(String[] args)throws Exception{
      /*  String code="123456";
        String myencode= MyBase64.encode(code);
        String mydecode=MyBase64.decode(myencode);
        System.out.println(myencode);
        System.out.println(mydecode);



        users user=new users();
        user.setUsername("123");
        user.setPassword("456");
        user.setIdentCode("2");

        byte[] bytes=ObjectTranslate.ObjectToByte(user);

        users getuser=(users)ObjectTranslate.ByteToObject(bytes);
        System.out.println(getuser);*/

       // System.out.println(new validateCode().getCode().toLowerCase());

       /* JFrame mytest=new JFrame("测试");
        ArrayList<String> strtest=new ArrayList<>();
        strtest.add("我的好友");
        strtest.add("我的消息");
        strtest.add("我的群聊");
        strtest.add("我的设置");
        strtest.add("我的资料");
        strtest.add("我的好友");
        strtest.add("我的消息");
        strtest.add("我的群聊");
        strtest.add("我的设置");
        strtest.add("我的资料");
        strVerticalNav leftNav=new strVerticalNav(Color.orange,Color.WHITE,60,120,750,strtest);
        leftNav.setBounds(0,0,120,800);
       // leftNav.setLocation(0,0);
        mytest.add(leftNav);



        JPanel mainPanel=new JPanel();
        final JPanel test = new JPanel();
        test.setBackground(Color.GRAY);
        test.setBounds(0,0,20,800);
        JLabel testLabel=new JLabel("请点击",JLabel.CENTER);
        testLabel.setBackground(Color.red);
        testLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.remove(test);
                mainPanel.add(leftNav);
                leftNav.validate();
                leftNav.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        testLabel.setBounds(0,0,20,800);
        test.add(testLabel);

        mainPanel.add(test);
        mainPanel.setBackground(Color.WHITE);
        mytest.setContentPane(mainPanel);
        mytest.setLayout(null);
        mytest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mytest.setBounds(200,10,1100,700);
        mytest.setVisible(true);*/

        UsersDao usersDao=new UsersDao();
        Users user=new Users();

        /*user.setUsername("fxp");
        user.setPassword("123456");
        user.setIdentCode("fxp");
        usersDao.addUser(user);*/
        int result=usersDao.queryUser("fxp","123456","fxp");
        System.out.println(result);

    }
}