package package1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TCPTest1 {

	@Test
	public void client() {

		try {
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
			OutputStream os = socket.getOutputStream();
			os.write("你好，我是客户端mm".getBytes());
		} catch (IOException e) {

		}
	}

	@Test
	public void server() {

		try (ServerSocket ss = new ServerSocket(8899);
				Socket socket = ss.accept();
				InputStream is = socket.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[5];
			int len;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			System.out.println(baos.toString()); 
		} catch (IOException e) {

		}

	}

}
