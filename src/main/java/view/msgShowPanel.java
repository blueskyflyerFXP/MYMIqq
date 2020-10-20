package view;

import entity.ShowMsg;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 * 聊天消息列表（查看最近收到的消息和消息数目）面板
 */
public class msgShowPanel extends JPanel {
    private int width = 400;
    private int heigth = 1200;
    private int itemHeight = 40;
    private int clickIndex = 0;
    ArrayList<ShowMsg> msgs = new ArrayList<>();
    ArrayList<msgItemView> msgItems = new ArrayList<>();

    public msgShowPanel(int width, int heigth, int itemHeight, ArrayList<ShowMsg> msgs) {
        this.width = width;
        this.heigth = heigth;
        this.itemHeight = itemHeight;
        this.msgs = msgs;
        init();
    }

    private void init() {
        for (int i = 0; i < msgs.size(); i++) {
            ShowMsg show = msgs.get(i);
            msgItemView item = new msgItemView(show.getHeadPhoto(), show.getUser(), show.getChatDate()
                    , show.getLaterMsg(), show.getNumOfMsg(), width, itemHeight);
            item.setBounds(0, itemHeight * i, width, itemHeight);
            msgItems.add(item);
            this.add(item);
        }

    }
    //为面板添加鼠标事件
    public void addItemClick(MouseListener listener,int index){
        msgItems.get(index).addMouseListener(listener);
    }
    //为面板中的头像添加鼠标事件
    public void addPhotoClick(MouseListener listener,int index){
        msgItems.get(index).addPhotoClick(listener);
    }
}

