package view;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * 注册面板
 */
public class registerView extends BaseJframe{
    private static int itemWidth=800;
    private static int itemHeight=60;

    //主界面
    private JPanel mainPanel=new JPanel();
    //滑动条
    private JScrollPane scrollPane=new JScrollPane();
    //欢迎注册面板
    private JPanel welcomePanel=new JPanel();
    //内容面板
    private JPanel contentPanel=new JPanel();
    //底部按钮面板
    private JPanel btnPanel=new JPanel();

    //欢迎标题
    private JLabel title=new JLabel("欢迎进入注册页面！",JLabel.CENTER);

    //用户名面板（带有提示消息）
    private msgInputPanel username=new msgInputPanel("用户名：","请输入用户名","bzd",0, Color.BLACK,itemWidth,itemHeight);
    //密码面板
    private msgInputPanel password=new msgInputPanel("密码：","","",1, Color.BLACK,itemWidth,itemHeight);
    //确认密码面板
    private msgInputPanel checkPwd=new msgInputPanel("确认密码：","","",1, Color.BLACK,itemWidth,itemHeight);
    //昵称面板
    private inputPanel nicknname=new inputPanel("昵称：","请输入昵称",0,itemWidth,itemHeight);
    //头像面板
    private btnInputPanel fileSelect=new btnInputPanel("头像：","","打开",itemWidth,itemHeight);
    //性别面板
    private JPanel sex=new JPanel();
    private JLabel sexTip=new JLabel("性别：",JLabel.RIGHT);
    private JRadioButton male=new JRadioButton("男");
    private JRadioButton female=new JRadioButton("女");
    private ButtonGroup sexGroup=new ButtonGroup();

    //用户签名
    private inputPanel signature=new inputPanel("签名：","请输入签名,长度：3-80",2,itemWidth,itemHeight*3);

    //所在地
    private inputPanel local=new inputPanel("所在地：","请输入地址",0,itemWidth,itemHeight);

    //生日
    private msgInputPanel birth=new msgInputPanel("生日：","请输入生日","形式：yyyy.mm.dd",0,Color.BLACK,itemWidth,itemHeight);

    //联系电话
    private msgInputPanel telenumber=new msgInputPanel("联系电话：","请输入联系电话","11位数字",0,Color.BLACK,itemWidth,itemHeight);

    //爱好
    private inputPanel hobby=new inputPanel("爱好：","请输入爱好，长度：3-80",2,itemWidth,itemHeight*3);

    //邮箱
    private msgInputPanel email =new msgInputPanel("邮箱：","请输入邮箱","形式：abc@efg.com",0,Color.BLACK,itemWidth,itemHeight);

    private JPanel func=new JPanel();
    //确认按钮
    private JButton regBtn=new JButton("确认");
    //取消按钮
    private JButton exitBtn=new JButton("取消");

    private JFileChooser imgFile = new JFileChooser(".");
    public registerView(){
        super();
        init();
    }
    public registerView(String title){
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
        title.setFont(new Font("微软雅黑",Font.BOLD,24));
        title.setBounds(0,0,itemWidth,itemHeight);
        welcomePanel.setLayout(null);
        welcomePanel.setBackground(Color.cyan);
        welcomePanel.setBounds(0,0,itemWidth,itemHeight);

        username.setBounds(0,itemHeight*2,itemWidth,itemHeight);
        username.setBackground(Color.WHITE);

        password.setBounds(0,itemHeight*3,itemWidth,itemHeight);
        password.setBackground(Color.WHITE);

        checkPwd.setBounds(0,itemHeight*4,itemWidth,itemHeight);
        checkPwd.setBackground(Color.WHITE);

        nicknname.setBounds(0,itemHeight*5,itemWidth,itemHeight);
        nicknname.setBackground(Color.WHITE);


        fileSelect.setBounds(0,itemHeight*6,itemWidth,itemHeight);
        fileSelect.setBackground(Color.WHITE);

        sex.setBounds(0,itemHeight*7,itemWidth,itemHeight);
        sex.setLayout(null);
        sex.setFont(new Font("微软雅黑",Font.BOLD,16));
        sex.setBackground(Color.WHITE);
        sexTip.setBounds(0,0,itemWidth/4,itemHeight);
        sexTip.setBackground(Color.WHITE);
        sexTip.setFont(new Font("微软雅黑",Font.PLAIN,16));
        male.setBounds(itemWidth/4,0,itemWidth/4,itemHeight);
        male.setBackground(Color.WHITE);
        male.setSelected(true);
        female.setBounds(itemWidth/2,0,itemWidth/4,itemHeight);
        female.setBackground(Color.WHITE);


        signature.setBounds(0,itemHeight*8,itemWidth,itemHeight*3);
        signature.setBackground(Color.WHITE);

        local.setBounds(0,itemHeight*11,itemWidth,itemHeight);
        local.setBackground(Color.WHITE);

        birth.setBounds(0,itemHeight*12,itemWidth,itemHeight);
        birth.setBackground(Color.WHITE);

        telenumber.setBounds(0,itemHeight*13,itemWidth,itemHeight);
        telenumber.setBackground(Color.WHITE);

        hobby.setBounds(0,itemHeight*14,itemWidth,itemHeight*3);
        hobby.setBackground(Color.WHITE);

        email.setBounds(0,itemHeight*17,itemWidth,itemHeight);
        email.setBackground(Color.WHITE);

        func.setBounds(0,itemHeight*18,itemWidth,itemHeight);
        func.setLayout(null);
        func.setBackground(Color.WHITE);
        func.setFont(new Font("微软雅黑",Font.BOLD,16));
        regBtn.setBounds(itemWidth/4,itemHeight/4,itemWidth/8,itemHeight/2);
        exitBtn.setBounds(itemWidth*3/4,itemHeight/4,itemWidth/8,itemHeight/2);

        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(0,0,800,1200);
        //scrollPane.setBounds(0,0,800,1200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        mainPanel.setPreferredSize(new Dimension(800, 1200));
        scrollPane.setSize(800,750);
        scrollPane.setViewportView(mainPanel);


    }

    @Override
    protected void addItem() {
        welcomePanel.add(title);
        sexGroup.add(male);
        sexGroup.add(female);
        sex.add(sexTip);
        sex.add(male);
        sex.add(female);
        func.add(regBtn);
        func.add(exitBtn);

        mainPanel.add(welcomePanel);
        mainPanel.add(username);
        mainPanel.add(password);
        mainPanel.add(checkPwd);
        mainPanel.add(nicknname);
        mainPanel.add(fileSelect);
        mainPanel.add(sex);
        mainPanel.add(signature);
        mainPanel.add(local);
        mainPanel.add(birth);
        mainPanel.add(telenumber);
        mainPanel.add(hobby);
        mainPanel.add(email);
        mainPanel.add(func);

    }

    @Override
    protected void addListencer() {
    fileSelect.addClick(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            fileSelect.setInputTip(getPath());
        }
    });

    }

    @Override
    protected void setFrame() {
        this.add(scrollPane);
        this.setBounds(100,20,815,770);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    //获取头像文件的绝对路径
    private String getPath() {
        imgFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        imgFile.setAcceptAllFileFilterUsed(false);
        final String[][] fileENames = {{".jpg", "JPEG图片(*.jpg)"},
                {".png", "PNG图片(*.png)"}
        };
        // 显示所有文件
        imgFile.addChoosableFileFilter(new FileFilter() {
            public boolean accept(File file) {
                return true;
            }

            public String getDescription() {
                return "所有文件(*.*)";
            }

        });

// 循环添加需要显示的文件
        for (final String[] fileEName : fileENames) {
            imgFile.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File file) {
                    if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
                        return true;
                    }
                    return false;
                }

                public String getDescription() {
                    return fileEName[1];
                }
            });
        }
        String path="";
        int result = imgFile.showDialog(null, null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //获得你选择的文件绝对路径。并输出。当然，我们获得这个路径后还可以做很多的事。
            path = imgFile.getSelectedFile().getAbsolutePath();
            System.out.println(path);
        } else {
            System.out.println("你已取消并关闭了窗口！");
        }
        return path;
    }
    public static void main(String[] args){
        JFrame login=new registerView("注册界面");
    }
}
