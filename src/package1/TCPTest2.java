package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TCPTest2 {
	@Test
	public void client() {
		try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
				OutputStream outputStream = socket.getOutputStream();
				FileInputStream fileInputStream = new FileInputStream(new File("beauty.jpg"))) {
			byte[] buffer = new byte[1024];
			int len;
			while((len=fileInputStream.read())!=-1) {
				outputStream.write(buffer, 0, len);;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void server() {
		 try (Socket accept = new ServerSocket(9090).accept();
				InputStream inputStream = accept.getInputStream();
				FileOutputStream fileOutputStream = new FileOutputStream(new File("beauty1.jpg"))) {
			byte[] buffer = new byte[1024];
			 int len;
			 while((len=inputStream.read(buffer))!=-1) {
				 fileOutputStream.write(buffer, 0, len);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
