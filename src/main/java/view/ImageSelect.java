package view;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/**
 * 头像图片选择后显示预览图
 */
public class ImageSelect extends JFrame {
    private JPanel mainPanel = new JPanel();

    private JFileChooser imgFile = new JFileChooser(".");

    private JLabel look = new JLabel("", JLabel.CENTER);

    private JButton confirm=new JButton("确认");

    private JButton reSelect=new JButton("重新选择");

    public ImageSelect() {
        super();
        init();
    }

    private void init() {
        String path=getPath();
        look.setBounds(0, 0, 600, 400);
        look.setIcon(new ImageIcon(path));
        confirm.setBounds(150,400,100,30);
        reSelect.setBounds(370,400,100,30);
        JFrame that=this;
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.setVisible(false);
            }
        });

        mainPanel.add(look);
        mainPanel.add(confirm);
        mainPanel.add(reSelect);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);

        this.setContentPane(mainPanel);
        this.setBounds(100, 50, 600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getPath() {
        imgFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        imgFile.setAcceptAllFileFilterUsed(false);
        final String[][] fileENames = {{".jpg", "JPEG图片(*.jpg)"},
                {".png", "PNG图片(*.png)"}
        };
        // 显示所有文件
        imgFile.addChoosableFileFilter(new FileFilter() {
            public boolean accept(File file) {
                return true;
            }

            public String getDescription() {
                return "所有文件(*.*)";
            }

        });

// 循环添加需要显示的文件
        for (final String[] fileEName : fileENames) {
            imgFile.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(File file) {
                    if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
                        return true;
                    }
                    return false;
                }

                public String getDescription() {
                    return fileEName[1];
                }
            });
        }
        String path="";
        int result = imgFile.showDialog(null, null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //获得你选择的文件绝对路径。并输出。当然，我们获得这个路径后还可以做很多的事。
            path = imgFile.getSelectedFile().getAbsolutePath();
            System.out.println(path);
        } else {
            System.out.println("你已取消并关闭了窗口！");
        }
        return path;
    }

    public static void main(String[] args) {
        new ImageSelect();
    }
}
