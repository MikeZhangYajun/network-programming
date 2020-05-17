package package1;

import java.io.ByteArrayOutputStream;
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

public class TCPTest3 {
	@Test
	public void client() {
		try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
				OutputStream outputStream = socket.getOutputStream();
				FileInputStream fileInputStream = new FileInputStream(new File("beauty.jpg"))) {
			byte[] buffer = new byte[1024];
			int len;
			while((len=fileInputStream.read(buffer))!=-1) {
				outputStream.write(buffer,0,len);
			}
			socket.shutdownOutput();
			
			InputStream inputStream = socket.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] buffer1 = new byte[20];
			int len1;
			while((len1=inputStream.read(buffer1))!=-1) {
				byteArrayOutputStream.write(buffer1);
			}
			System.out.println(byteArrayOutputStream.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void server() {
		try (Socket accept = new ServerSocket(9090).accept();
				InputStream inputStream = accept.getInputStream();
				FileOutputStream fileOutputStream = new FileOutputStream(new File("beauty2.jpg"))) {
			byte[] buffer = new byte[1024];
			int len;
			while((len=inputStream.read(buffer))!=-1) {
				fileOutputStream.write(buffer,0,len);
			}
			System.out.println("图片传输完成");
			
			OutputStream outputStream = accept.getOutputStream();
			outputStream.write("你好美女，图片我已收到，很漂亮".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
