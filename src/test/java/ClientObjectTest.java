import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientObjectTest {

	public static void main(String args[]) throws IOException, SocketException, ClassNotFoundException {
		Socket client = new Socket("LocalHost", 8000);
		InputStream in = client.getInputStream();

		ObjectInputStream ObjIn = new ObjectInputStream(in);

		Student stu = (Student) ObjIn.readObject();
		System.out.println("从服务器端传来的对象是:" + stu);
		ObjIn.close();
		client.close();
	}



}
