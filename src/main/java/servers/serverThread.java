package servers;

import java.net.Socket;
import java.util.ArrayList;

public class serverThread implements Runnable {
    private Socket socket;
    private int funcCode;
    private Object data;
    public serverThread(Socket socket,int funcCode,Object data){
        this.socket=socket;
        this.funcCode=funcCode;
        this.data=data;
    }
    @Override
    public void run() {
       // serverFunc.taskMangement(socket,funcCode,data);
    }
}
