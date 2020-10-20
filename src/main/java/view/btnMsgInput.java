package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
/**
 * 输入组件
 * 输入框下面带有消息提示
 */
public class btnMsgInput extends JPanel{
    //属性
    //提示的文字
    private String tipStr="";
    //输入框内的提示文字
    private String inputTip="";
    //输入框的内容
    private String inputContent="";
    //按钮的内容
    private String btnName="";
    //消息
    private String msg="";
    //消息的颜色
    private Color msgColor=Color.black;

    //面板的大小
    private int width= 200;
    private int height=150;

    //组件：一个输入提示，一个输入框，一个功能图片
    private JLabel tips=new JLabel("",JLabel.RIGHT);
    private JTextField input=new JTextField("",JTextField.CENTER);
    private JButton button=new JButton("");
    private JLabel message=new JLabel("",JLabel.CENTER);


    //其他
    //点击图片的次数
    private int clickTimes=0;

    public btnMsgInput() {
        super();
    }

    public btnMsgInput(String tipStr, String inputTip, String inputContent, String btnName, String msg, Color msgColor, int width, int height) {
        this.tipStr = tipStr;
        this.inputTip = inputTip;
        this.inputContent = inputContent;
        this.btnName = btnName;
        this.msg = msg;
        this.msgColor = msgColor;
        this.width = width;
        this.height = height;
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

    public void setBtnName(String btnName) {
        button.setText(btnName);
    }

    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }

    public int getClickTimes(){
        return clickTimes;
    }

    private void init() {
        tips.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tips.setText(tipStr);
        tips.setBounds(0, 0, width / 4, height / 2);

        input.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        input.setText(inputTip);
        input.setBounds(width / 4, 0, width / 2, height / 2);

        button.setText(btnName);
        button.setBounds(width * 13 / 16, width / 8, width / 8, height / 4);

        message.setText(msg);
        message.setForeground(msgColor);
        message.setFont(new Font("微软雅黑", Font.BOLD, 16));
        message.setBounds(width / 4, height / 2, width / 2, height / 2);


        this.setLayout(null);
        this.setSize(width, height);
        this.add(tips);
        this.add(input);
        this.add(button);
        this.add(message);
        this.setVisible(true);
    }
    //为输入框添加焦点事件
    public void addFocus(FocusListener focusListener){
        input.addFocusListener(focusListener);
    }
    //为按钮添加点击事件
    public void addClick(ActionListener listener){
        button.addActionListener(listener);
    }
}
