package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 输入框后带有图片（可点击）且下面有消息提示的面板
 */
public class imgMsgInput extends JPanel{
    //属性
    //提示的文字
    private String tipStr="";
    //输入框内的提示文字
    private String inputTip="";
    //输入框的内容
    private String inputContent="";
    //图片的路径
    private String imgPath="";
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
    private JLabel imag=new JLabel("",JLabel.CENTER);
    private JLabel message=new JLabel("",JLabel.CENTER);

    //其他
    //点击图片的次数
    private int clickTimes=0;

    public imgMsgInput() {
        super();
    }

    public imgMsgInput(String tipStr, String inputTip, String inputContent, String imgPath, String msg, Color msgColor, int width, int height) {
        this.tipStr = tipStr;
        this.inputTip = inputTip;
        this.inputContent = inputContent;
        this.imgPath = imgPath;
        this.msg = msg;
        this.msgColor = msgColor;
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

    public void setImgPath(String imgPath) {
        imag.setIcon(new ImageIcon(imgPath));
    }

    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }

    public int getClickTimes(){
        return clickTimes;
    }

    public void setImagListener(MouseListener mouse){
        imag.addMouseListener(mouse);
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

        imag.setIcon(new ImageIcon(imgPath));
        imag.setBounds(width*3/4,0,width/4,height/2);
        imag.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickTimes++;
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

        message.setText(msg);
        message.setForeground(msgColor);
        message.setFont(new Font("微软雅黑",Font.BOLD,16));
        message.setBounds(width/4,height/2,width/2,height/2);

        this.setLayout(null);
        this.setSize(width,height);
        this.add(tips);
        this.add(input);
        this.add(imag);
        this.add(message);
        this.setVisible(true);
    }

    //获取输入框内的值
    public String getInput(){
        return input.getText().trim();
    }
    //为输入框添加焦点事件
    public void addFocus(FocusListener focusListener){
        input.addFocusListener(focusListener);
    }
    //为图片添加点击事件
    public void addClick(MouseListener mouseListener){
        imag.addMouseListener(mouseListener);
    }
}
