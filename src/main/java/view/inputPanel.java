package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * 普通的输入面板
 * type 0--普通输入框 1--密码框 2--文本域
 */
public class inputPanel extends JPanel {
    //属性
    //提示的文字
    private String tipStr="";
    //输入框内的提示文字
    private String inputTip="";
    //输入框的类型
    //0--普通输入框 1--密码框 2--文本域 3--文件域
    private int type=0;
    //面板的大小
    private int width= 200;
    private int height=150;

    //组件：一个输入提示，一个输入框或者密码框，或者文本域
    private JLabel tips=new JLabel("",JLabel.RIGHT);
    private JTextField input=new JTextField("",JTextField.CENTER);
    private JPasswordField pwd=new JPasswordField();
    private JTextArea area=new JTextArea("请输入内容",20,5);
    private JFileChooser file=new JFileChooser("");

    public inputPanel() {
        super();
    }

    public inputPanel(String tipStr, String inputTip,int type, int width, int height) {
        super();
        this.tipStr = tipStr;
        this.inputTip = inputTip;
        this.type=type;
        this.width = width;
        this.height = height;
        init();
    }

    private void init(){
        tips.setFont(new Font("微软雅黑",Font.PLAIN,16));
        tips.setText(tipStr);
        tips.setBounds(0,0,width/4,height);

        input.setFont(new Font("微软雅黑",Font.PLAIN,12));
        input.setText(inputTip);
        input.setBounds(width/4,height/4,width/2,height/2);
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
        pwd.setBounds(width/4,height/4,width/2,height/2);

        area.setFont(new Font("微软雅黑",Font.PLAIN,10));
        area.setBounds(width/4,height/8,width/2,height*3/4);
        area.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        area.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                area.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        this.setLayout(null);
        this.setSize(width,height);
        this.add(tips);
        if(type==0){
            this.add(input);
        }else if(type==1){
            this.add(pwd);
        }else {
            this.add(area);
        }
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
        }else {
            area.addFocusListener(focusListener);
        }
    }
}
