package view;

import javafx.scene.image.Image;
import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//主体采用边界布局BorderLayout
public class LoginView extends BaseJframe {
    //主窗体的宽度
    private  int frameWidth=800;
    //主窗体的高度
    private int frameHeight=600;
    //主面板
    private JPanel mainPanel=new JPanel();

    //标题面板，用于放置logo和标题文字
    private JPanel titlePanel = new JPanel();
    //主体面板，用于用户名、密码，验证码的输入和注册功能
    private JPanel contentPanel=new JPanel();
    //底部操作面板，用于放置登录、退出、记住密码、忘记密码等功能按钮
    private JPanel buttonPanel=new JPanel();
    //logo面板
    private JPanel logoPanel=new JPanel();
    //欢迎面板，用于显示欢迎语和登录按钮
    private JPanel welcomePanel=new JPanel();

    //显示logo图片
    private JLabel logoView=new JLabel("",JLabel.CENTER);
    //欢迎语文字
    private JLabel welcomeLang=new JLabel("欢迎进入登录页面！",JLabel.CENTER);
    //注册按钮
    private JButton regiterBtn=new JButton("注册");
    //用户名面板
    private JPanel userPanel=new JPanel();
    //用户名提示
    private JLabel userLabel=new JLabel("用户名：",JLabel.RIGHT);
    //用户名输入框
    private JTextField userField=new JTextField("请输入用户名",JTextField.CENTER);
    //提示用户名不存在
    private JLabel userExit=new JLabel("",JLabel.CENTER);

    //密码面板
    private JPanel pwdPanel=new JPanel();
    //密码提示
    private JLabel pwdLabel=new JLabel("密码：",JLabel.RIGHT);
    //密码输入框
    private JPasswordField pwdField=new JPasswordField("",JTextField.CENTER);
    //设置密码可见和不可见
    private JLabel pwdVisable = new JLabel("",JLabel.LEFT);
    //提示密码错误或其他规则
    private JLabel pwdTip=new JLabel("",JLabel.CENTER);

    //验证码面板
    private JPanel identPanel=new JPanel();
    //验证码提示
    private JLabel identLabel=new JLabel("验证码：",JLabel.RIGHT);
    //验证码输入框
    private JTextField identField=new JTextField("请输入验证码",JTextField.CENTER);
    //验证码图片
    private JLabel identImg=new JLabel("",JLabel.LEFT);
    //提示验证码错误
    private JLabel identTip=new JLabel("",JLabel.CENTER);

    //忘记密码和记住密码面板
    private JPanel rememberPanel=new JPanel();
    //记住密码单选钮组
    ButtonGroup rememberGroup=new ButtonGroup();
    //记住密码单选钮
    JRadioButton rememberPwd=new JRadioButton("记住密码");
    //忘记密码单选钮
    private JRadioButton forgetPwd=new JRadioButton("忘记密码");
    //按钮的面板
    private JPanel funcPanel=new JPanel();
    //登录按钮
    JButton loginBtn=new JButton("登录");
    //退出按钮
    JButton exitBtn=new JButton("退出");
    //找回密码按钮
    //JButton rebackBtn=new JButton("找回密码");
    public LoginView(){
        super();
        init();
    }
    public LoginView(String title){
        super(title);
        init();
    }
    private void init(){
        setView();
        addItem();
        addListencer();
        setFrame();
    }
    @Override
    protected void setView() {
        //设置标题面板
        titlePanel.setLayout(null);
        titlePanel.setBackground(Color.WHITE);
        titlePanel.setBounds(0,0,frameWidth,frameHeight/5);
        titlePanel.setVisible(true);

        //设置logo面板
        logoPanel.setBounds(0,0,frameWidth,frameHeight/10);
        //设置logo
        logoView.setBounds(0,0,frameWidth,frameHeight/10);
        logoView.setIcon(new ImageIcon("src//images//logo.jpg"));


        //设置欢迎面板
        welcomePanel.setLayout(null);
        welcomePanel.setBounds(0,frameHeight/10,frameWidth,frameHeight/10);
        welcomePanel.setBackground(Color.WHITE);

        //设置欢迎字样
        welcomeLang.setBounds(0,0,frameWidth,frameHeight/10);
        welcomeLang.setFont(new Font("微软雅黑",Font.BOLD,16));
        //设置注册按钮
        regiterBtn.setBounds(frameWidth*4/5,20,frameWidth/10,frameHeight/20);
        regiterBtn.setBackground(Color.WHITE);
        regiterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //设置输入面板
        contentPanel.setBounds(0,frameHeight/4,frameWidth,frameHeight*3/5);
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.WHITE);

        //设置用户名输入面板
        userPanel.setLayout(null);
        userPanel.setBackground(Color.WHITE);
        userPanel.setBounds(0,0,frameWidth,frameHeight*3/20);

        //设置用户名输入
        userLabel.setBounds(0,0,frameWidth/4,frameHeight*3/20);
        userLabel.setFont(new Font("微软雅黑",Font.PLAIN,12));
        userField.setBounds(frameWidth/4,frameHeight/20,frameWidth/2,frameHeight/20);
        userField.setFont(new Font("微软雅黑",Font.PLAIN,12));
        userExit.setBounds(frameWidth/4,frameHeight/10,frameWidth/2,frameHeight/20);
        userExit.setFont(new Font("微软雅黑",Font.BOLD,12));
        userExit.setForeground(Color.decode("#ee1111"));
        //设置密码输入面板
        pwdPanel.setLayout(null);
        pwdPanel.setBackground(Color.WHITE);
        pwdPanel.setBounds(0,frameHeight*3/20,frameWidth,frameHeight*3/20);

        //设置密码输入
        pwdLabel.setBounds(0,0,frameWidth/4,frameHeight*3/20);
        pwdLabel.setFont(new Font("微软雅黑",Font.PLAIN,12));
        pwdField.setBounds(frameWidth/4,frameHeight/20,frameWidth/2,frameHeight/20);
        pwdField.setFont(new Font("微软雅黑",Font.PLAIN,12));
        pwdField.setEchoChar((char)0);
        //不可见setEchoChar('*')
        //设置密码可见和不可见图标
        pwdVisable.setBounds(frameWidth*3/4,frameHeight/5,frameWidth/4,frameHeight/5);
        pwdTip.setBounds(frameWidth/4,frameHeight/10,frameWidth/2,frameHeight/20);
        pwdTip.setFont(new Font("微软雅黑",Font.BOLD,12));
        pwdTip.setForeground(Color.decode("#ee1111"));

        //设置验证码输入面板
        identPanel.setLayout(null);
        identPanel.setBackground(Color.WHITE);
        identPanel.setBounds(0,frameHeight*3/10,frameWidth,frameHeight*3/20);

        //设置验证码输入
        identLabel.setBounds(0,0,frameWidth/4,frameHeight*3/20);
        identLabel.setFont(new Font("微软雅黑",Font.PLAIN,12));
        identField.setBounds(frameWidth/4,frameHeight/20,frameWidth/2,frameHeight/20);
        identField.setFont(new Font("微软雅黑",Font.PLAIN,12));
        //设置验证码图片
        identImg.setBounds(frameWidth*3/4,frameHeight/20,frameWidth/4,frameHeight/20);
        identImg.setIcon(new ImageIcon("src//images//validatecode.jpg"));
        //设置提示消息
        identTip.setBounds(frameWidth/4,frameHeight/10,frameWidth/2,frameHeight/20);
        identTip.setFont(new Font("微软雅黑",Font.BOLD,12));
        identTip.setForeground(Color.decode("#ee1111"));

        //设置操作按钮面板
        buttonPanel.setBounds(0,frameHeight*13/20,frameWidth,frameHeight/5);
        buttonPanel.setLayout(null);

        //设置记住密码和忘记密码
        rememberPanel.setLayout(null);
        rememberPanel.setBounds(0,frameHeight/20,frameWidth,frameHeight/20);
        rememberPwd.setBounds(frameWidth/4,0,frameWidth/4,frameHeight/20);
        rememberPwd.setBackground(Color.WHITE);
        forgetPwd.setBounds(frameWidth*3/5,0,frameWidth/4,frameHeight/20);
        forgetPwd.setBackground(Color.WHITE);
        rememberGroup.add(rememberPwd);
        rememberGroup.add(forgetPwd);

        funcPanel.setLayout(null);
        funcPanel.setVisible(true);
        funcPanel.setBounds(0,frameHeight*3/20,frameWidth,frameHeight/10);
        //设置登录和退出
        loginBtn.setBounds(frameWidth/4,0,frameWidth/10,frameHeight/20);
        exitBtn.setBounds(frameWidth*3/5,0,frameWidth/10,frameHeight/20);

        //设置主面板
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setSize(frameWidth,frameHeight);
    }

    @Override
    protected void addItem() {

        welcomePanel.add(welcomeLang);
        welcomePanel.add(regiterBtn);
        titlePanel.add(logoView);
        titlePanel.add(welcomePanel);

        userPanel.add(userLabel);
        userPanel.add(userField);
        userPanel.add(userExit);

        pwdPanel.add(pwdLabel);
        pwdPanel.add(pwdField);
        pwdPanel.add(pwdVisable);
        pwdPanel.add(pwdTip);

        identPanel.add(identLabel);
        identPanel.add(identField);
        identPanel.add(identImg);
        identPanel.add(identTip);

        contentPanel.add(userPanel);
        contentPanel.add(pwdPanel);
        contentPanel.add(identPanel);

        rememberPanel.add(rememberPwd);
        rememberPwd.setVisible(true);
        rememberPanel.add(forgetPwd);

        funcPanel.add(loginBtn);
        funcPanel.add(exitBtn);

        buttonPanel.add(rememberPanel);
        buttonPanel.add(funcPanel);



        mainPanel.add(titlePanel);
        mainPanel.add(contentPanel);
        mainPanel.add(buttonPanel);
    }

    @Override
    protected void addListencer() {
        userField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String str=userField.getText();
                int len=str.trim().replace(" ","").replace("\r\n","").length();
                if(len<3||len>20){
                    userExit.setText("输入的用户名长度必须大于3且小于20（空格无效）");
                }else {
                    userExit.setForeground(Color.GREEN);
                    userExit.setText("用户名有效");
                }
            }
        });
        identField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                identField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

    @Override
    protected void setFrame() {
        this.setLayout(null);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(300,100,frameWidth,frameHeight);

    }

    public static void main(String[] args){
        JFrame login=new LoginView("登录界面");
    }
}
