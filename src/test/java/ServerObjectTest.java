import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerObjectTest {

	public static void main(String args[]) throws Exception {
		ServerSocket server = new ServerSocket(8000);
		Socket s = server.accept();
		OutputStream out = s.getOutputStream();

		ObjectOutputStream ObjOut = new ObjectOutputStream(out);
		ObjOut.writeObject(new Student("李四", 30));

		ObjOut.close();
		s.close();
		server.close();

	}

}


