package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 输入框后带有图片（可点击）的面板
 */
public class imgInputPanel extends JPanel{
    //属性
    //提示的文字
    private String tipStr="";
    //输入框内的提示文字
    private String inputTip="";
    //输入框的内容
    private String inputContent="";
    //图片的路径
    private String imgPath="";

    //面板的大小
    private int width= 200;
    private int height=150;

    //组件：一个输入提示，一个输入框，一个功能图片
    private JLabel tips=new JLabel("",JLabel.RIGHT);
    private JTextField input=new JTextField("",JTextField.CENTER);
    private JLabel imag=new JLabel("",JLabel.CENTER);

    //其他
    //点击图片的次数
    private int clickTimes=0;

    public imgInputPanel() {
        super();
    }

    public imgInputPanel(String tipStr, String inputTip, String inputContent,String imgPath, int width, int height) {
        super();
        this.tipStr = tipStr;
        this.inputTip = inputTip;
        this.inputContent = inputContent;
        this.imgPath=imgPath;
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
    private void init(){
        tips.setFont(new Font("微软雅黑",Font.PLAIN,16));
        tips.setText(tipStr);
        tips.setBounds(0,0,width/4,height);

        input.setFont(new Font("微软雅黑",Font.PLAIN,12));
        input.setText(inputTip);
        input.setBounds(width/4,height/4,width/2,height/2);

        imag.setIcon(new ImageIcon(imgPath));
        imag.setBounds(width*3/4,0,width/4,height);
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

        this.setLayout(null);
        this.setSize(width,height);
        this.add(tips);
        this.add(input);
        this.add(imag);
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
