package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 * 群组列表显示面板
 *
 */
public class groupShowView extends JPanel{
    //导航条元素的宽度
    int itemHeight=40;
    //导航条的大小
    int width=40;
    int height=400;


    //存放导航条的文字
    ArrayList<String> items=new ArrayList<>();
    //存放导航条的项目
    ArrayList<JLabel> labels=new ArrayList<>();
    //点击的元素索引
    private int clickIndex=0;

    public groupShowView(){
        super();
        this.setSize(width,height);
        this.setBackgroundColor(Color.WHITE);
        this.setVisible(true);
    }

    public groupShowView(ArrayList<String> items) {
        this.items = items;
        init();
    }

    public groupShowView(Color backgroundColor, Color fontColor, int itemHeight, int width, int height, ArrayList<String> items) {
        this.itemHeight=itemHeight;
        this.width = width;
        this.height = height;
        this.items = items;
        init();
    }
    private void init(){
        //生产导航条的列表
        int length=items.size();
        for(int i=0;i<length;i++){
            JLabel item=new JLabel(items.get(i),JLabel.CENTER);
            item.setFont(new Font("微软雅黑",Font.BOLD,16));
            item.setBounds(0,itemHeight*i,width,itemHeight);
            item.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            item.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clickIndex=items.indexOf(((JLabel)e.getSource()).getText());
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
        int num=Math.min(items.size(),height/itemHeight);
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
            item.setBounds(0,itemHeight*i,width,itemHeight);
            item.validate();
            item.repaint();
        }
    }


    public void setHeight(int width,int height) {
        this.setSize(width,height);
        this.validate();
        this.repaint();
    }
}
