package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 带有消息通知的普通输入面板
 */
public class msgInputPanel extends JPanel{
    //属性
    //提示的文字
    private String tipStr="";
    //输入框内的提示文字
    private String inputTip="";
    //输入框的类型
    private int type=0;
    //消息
    private String msg="";
    //消息的颜色
    private Color msgColor=Color.black;

    //面板的大小
    private int width= 200;
    private int height=150;

    //组件：一个输入提示，一个输入框，一个消息提示
    private JLabel tips=new JLabel("",JLabel.RIGHT);
    private JTextField input=new JTextField("",JTextField.CENTER);
    private JPasswordField pwd=new JPasswordField("",JPasswordField.CENTER);
    private JLabel message=new JLabel("",JLabel.CENTER);


    //其他
    //点击图片的次数
    private int clickTimes=0;

    public msgInputPanel() {
        super();
    }

    public msgInputPanel(String tipStr, String inputTip,String msg,int type,Color msgColor, int width, int height) {
        super();
        this.tipStr = tipStr;
        this.inputTip = inputTip;
        this.msg=msg;
        this.type=type;
        this.msgColor=msgColor;
        this.width = width;
        this.height = height;
        init();
    }

    public void setTipStr(String tipStr) {
        tips.setText(tipStr);
    }

    public void setInputTip(String inputTip) {
        input.setText(inputTip);
    }

    public String getInputContent() {
        return input.getText().trim();
    }

    //设置消息的内容和颜色
    public void setMsg(String msg,Color msgColor) {
        message.setText(msg);
        message.setForeground(msgColor);
    }

    //获取消息
    public String getMsg(){
        return message.getText().trim();
    }


    private void init(){
        tips.setFont(new Font("微软雅黑",Font.PLAIN,16));
        tips.setText(tipStr);
        tips.setBounds(0,0,width/4,height/2);

        input.setFont(new Font("微软雅黑",Font.PLAIN,12));
        input.setText(inputTip);
        input.setBounds(width/4,0,width/2,height/2);
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                input.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        pwd.setFont(new Font("微软雅黑",Font.PLAIN,12));
        pwd.setBounds(width/4,0,width/2,height/2);

        message.setText(msg);
        message.setForeground(msgColor);
        message.setFont(new Font("微软雅黑",Font.BOLD,16));
        message.setBounds(width/4,height/2,width/2,height/2);


        this.setLayout(null);
        this.setSize(width,height);
        this.add(tips);
        if(type==0){
            this.add(input);
        }else {
            this.add(pwd);
        }
        this.add(message);
        this.setVisible(true);
    }

    //获取输入框内的值
    public String getInput(){
        return input.getText().trim();
    }
    //为输入框添加事件
    public void addFocus(FocusListener focusListener){
        if(type==0){
            input.addFocusListener(focusListener);
        }else if(type==1){
            pwd.addFocusListener(focusListener);
        }
    }
}
