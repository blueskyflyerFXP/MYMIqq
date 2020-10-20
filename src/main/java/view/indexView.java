package view;

import javax.swing.*;

/**
 * 主页
 */
public class indexView extends BaseJframe{

    //主面板
    private JPanel mainPanel=new JPanel();
    //标题面板
    private JPanel titlePanel=new JPanel();
    //标题
    private JLabel title=new JLabel("主界面",JLabel.CENTER);
    //侧边的功能导航栏
    private strVerticalNav funcPanel= null;
    //主体面板
    private JPanel contentPanel=new JPanel();
    //消息、好友、群组选择面板
    private JPanel selectPanel=new strHorizonalNav();
    //消息、好友、群组显示面板
    private JPanel showPanel=null;

    private JPanel infoShow=new JPanel();

    public indexView(){
        super();
        init();
    }
    public indexView(String title){
        super(title);
        init();
    }

    private void init(){
        setView();
        addItem();
        addListencer();
        setFrame();
    }
    @Override
    protected void setView() {

    }

    @Override
    protected void addItem() {

    }

    @Override
    protected void addListencer() {

    }

    @Override
    protected void setFrame() {

    }
    public static void main(String[] args){
        JFrame login=new indexView("注册界面");
    }
}
