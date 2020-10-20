package myutils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

/**
 * 生成验证码
 */
public class validateCode {
    //0和O以及1和l容易混淆，排除
    private static char[] codeSequence={
            'a','b','c','d','e','f','g','h','i','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z',
            '2','3','4','5','6','7','8','9',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private StringBuilder codeString=new StringBuilder("");
    public String getCode(){

        generateCode("src/images/validatecode.jpg");
        return codeString.toString();
    }

    private void generateCode(String filePath){
        //定义验证码图片的大小
        int width=80;
        int height=32;
        BufferedImage buffImg=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        //产生干扰线
        Graphics2D gd=buffImg.createGraphics();
        gd.setColor(Color.LIGHT_GRAY);
        gd.fillRect(0,0,width,height);
        gd.setColor(Color.BLACK);
        gd.drawRect(0,0,width-1,height-1);
        //随机产生16条干扰线
        Random random=new Random();
        for(int i=0;i<16;i++){
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(12);
            int y1=random.nextInt(12);
            gd.drawLine(x,y,x+x1,y+y1);
        }

        //计算字的位置坐标
        //字符个数
        int codeCount=4;
        //字体高度
        int fontHeight;
        //字符的坐标
        int codeX;
        int codeY;

        codeX=(width-4)/(codeCount+1);
        fontHeight=height-10;
        codeY=height-7;

        //创建字体
        Font font=new Font("Fixedsys",Font.PLAIN,fontHeight);
        gd.setFont(font);

        codeString=new StringBuilder("");
        //随机产生codeCount个字符的验证码
        for(int i=0;i<codeCount;i++){
            //每次拿一个随机的字母，赋予随机的颜色
            String strRan=String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            codeString.append(strRan);
            int red=random.nextInt(16);
            int green=random.nextInt(16);
            int blue=random.nextInt(16);
            gd.setColor(new Color(red,green,blue));
            gd.drawString(strRan,(i+1)*codeX,codeY);
        }
        try {
            ImageIO.write(buffImg,"jpg",new File(filePath));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
