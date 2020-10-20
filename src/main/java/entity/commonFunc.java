package entity;

import myutils.ObjectTranslate;

import java.io.*;

import java.net.Socket;
import java.util.Base64;

public class commonFunc {

    //发送消息，返回是否发送成功
    public  static boolean send(Socket socket,byte[] sendinfo){

        byte[] backinfo=null;
        try {
            OutputStream os=socket.getOutputStream();
            BufferedOutputStream bos=new BufferedOutputStream(os);
            bos.write(sendinfo);
            bos.flush();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                if(socket!=null){
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return true;
    }
    //接收消息返回接收的信息
    public  static byte[] receive(Socket socket){
        byte[] receinfo=null;
        try {
            InputStream is=socket.getInputStream();
            BufferedInputStream bis=new BufferedInputStream(is);
            receinfo=bis.readAllBytes();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(socket!=null){
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return receinfo;
    }

    //包装要发送的信息
    public static byte[] packMsg(ChangeInfo form, ChangeInfo to, Integer functionCode, String transmitType, Object list){
        TransmitInfo traninfo=new TransmitInfo();
        traninfo.setForm(form);
        traninfo.setTo(to);
        traninfo.setFunctionCode(functionCode);
        traninfo.setTransmitType(transmitType);
        traninfo.setTransmitContent(list);
        //转化为byte数组后Base64加密传输
        return Base64.getEncoder().encode(traninfo.ObjectToByte());
    }

    //拆装收到的信息
    public static TransmitInfo dimountMsg(byte[] msg) {
        byte[] NewMsg= null;
        try {
            //b不替换\r\n和空格在UDP传输过程中会产生编码异常
            NewMsg = new String(msg).replace("\r\n","")
                    .replace(" ","").trim().getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return (TransmitInfo) ObjectTranslate.ByteToObject(Base64.getDecoder().decode(NewMsg));
    }

    //打印提示信息
    public static String printTips(int funcode,String content){
        System.out.println("功能码:"+funcode+",详细描述:"+content);
        return String.valueOf(funcode)+":"+content;
    }
}
