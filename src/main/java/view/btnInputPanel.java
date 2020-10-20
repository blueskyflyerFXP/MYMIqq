package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 输入组件
 * 输入框后带有功能按钮
 */
public class btnInputPanel extends JPanel{
    //属性
    //提示的文字
    private String tipStr="";
    //输入框内的提示文字
    private String inputTip="";
    //按钮的内容
    private String btnName="";

    //面板的大小
    private int width= 200;
    private int height=150;

    //组件：一个输入提示，一个输入框，一个功能按钮
    private JLabel tips=new JLabel("",JLabel.RIGHT);
    private JTextField input=new JTextField("",JTextField.CENTER);
    private JButton button=new JButton("");

    //其他
    //点击图片的次数
    private int clickTimes=0;

    public btnInputPanel() {
        super();
    }

    public btnInputPanel(String tipStr, String inputTip,String btnName, int width, int height) {
        super();
        this.tipStr = tipStr;
        this.inputTip = inputTip;
        this.btnName=btnName;
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

    public void setBtnName(String btnName) {
        button.setText(btnName);
    }

    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }

    public int getClickTimes(){
        return clickTimes;
    }
    //为输入框添加焦点事件
    public void addFocus(FocusListener focusListener){
        input.addFocusListener(focusListener);
    }
    //为按钮添加点击事件
    public void addClick(ActionListener listener){
        button.addActionListener(listener);
    }
    private void init() {
        tips.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tips.setText(tipStr);
        tips.setBounds(0, 0, width / 4, height);

        input.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        input.setText(inputTip);
        input.setBounds(width / 4, height / 4, width / 2, height / 2);

        button.setText(btnName);
        button.setBounds(width * 3 / 4, height / 4, width / 8, height / 2-1);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickTimes++;
            }
        });


        this.setLayout(null);
        this.setSize(width, height);
        this.add(tips);
        this.add(input);
        this.add(button);
        this.setVisible(true);
    }
}
