package view;

import javax.swing.*;

public abstract class BaseJframe extends JFrame {
    public BaseJframe(){
        super();
       //init();
    }
    public BaseJframe(String title){
        super(title);
       // init();
    }

    //设置组件的属性
    protected abstract void setView();
    //把组件添加到Frame中
    protected abstract void addItem();
    //为组件添加监听器
    protected abstract void addListencer();
    //设置Frame的属性
    protected abstract void setFrame();

}
