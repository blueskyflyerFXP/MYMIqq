package view;
/**
 * 普通的字符串水平导航
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class strHorizonalNav extends JPanel {

    //导航条的背景颜色
    Color backgroundColor=Color.GRAY;
    //文字的颜色
    Color fontColor=Color.WHITE;
    //导航条元素的宽度
    int itemWidth=40;
    //导航条的大小
    int width=400;
    int height=40;


    //存放导航条的文字
    ArrayList<String> items=new ArrayList<>();
    //存放导航条的项目
    ArrayList<JLabel> labels=new ArrayList<>();
    //点击的元素索引
    private int clickIndex=0;

    public strHorizonalNav(){
        super();
        this.setSize(width,height);
        this.setBackground(backgroundColor);
        this.setVisible(true);
    }

    public strHorizonalNav(ArrayList<String> items) {
        this.items = items;
        init();
    }

    public strHorizonalNav(Color backgroundColor, Color fontColor, int itemWidth, int width, int height, ArrayList<String> items) {
        this.backgroundColor = backgroundColor;
        this.fontColor=fontColor;
        this.itemWidth = itemWidth;
        this.width = width;
        this.height = height;
        this.items = items;
        init();
    }
    private void init(){
        //生产导航条的列表
        int length=Math.min(items.size(),width/itemWidth);
        for(int i=0;i<length;i++){
            JLabel item=new JLabel(items.get(i),JLabel.CENTER);
            item.setFont(new Font("微软雅黑",Font.BOLD,16));
            item.setBounds(itemWidth*i,0,itemWidth,height);
            item.setForeground(fontColor);
            item.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            labels.add(item);
            this.add(this);
        }
        this.setLayout(null);
        this.setVisible(true);
    }

    public int getClickIndex() {
        return clickIndex;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.setBackground(backgroundColor);
    }

    public void setFontColor(Color fontColor) {
        int num=Math.min(items.size(),width/itemWidth);
        for(int i=0;i<num;i++){
            JLabel item=labels.get(0);
            item.setForeground(fontColor);
            item.validate();
            item.repaint();
        }
    }

    public void setItemWidth(int itemWidth) {
        int num=Math.min(items.size(),width/itemWidth);
        for(int i=0;i<num;i++){
            JLabel item=labels.get(0);
            item.setBounds(itemWidth*i,0,itemWidth,height);
            item.validate();
            item.repaint();
        }
    }


    public void setHeight(int width,int height) {
        this.setSize(width,height);
        this.validate();
        this.repaint();
    }
    //为一个元素添加鼠标事件
    public void addItemClick(MouseListener listener,int index){
        labels.get(index).addMouseListener(listener);
    }
}
