package view;

import entity.ShowFriend;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 * 好友列表显示面板
 *
 */
public class friendShowPanel extends JPanel {
   private int width=400;
   private int height=1200;
   private int itemHeight=40;

   private int clickIndex=0;

    ArrayList<ShowFriend> friends=new ArrayList<>();
    ArrayList<friendItemView> shows=new ArrayList<>();

    public friendShowPanel(ArrayList<ShowFriend> friends){
        this.friends=friends;
        init();

    }

    private void init(){

        for(int i=0;i<friends.size();i++){
            ShowFriend myfriend=friends.get(i);
            friendItemView itemView=new friendItemView(myfriend.getPhoto(),myfriend.getName(),myfriend.getSignure(),width,itemHeight);
            shows.add(itemView);
            this.add(itemView);
        }
    }
    //为面板添加鼠标事件
    public void addItemClick(MouseListener listener,int index){
        shows.get(index).addMouseListener(listener);
    }
    //为面板中的头像添加鼠标事件
    public void addPhotoClick(MouseListener listener,int index){
        shows.get(index).addPhotoClick(listener);
    }

}
