package package1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


import org.junit.Test;

public class UDPTest {
	@Test
	public void sender(){
		try (DatagramSocket datagramSocket = new DatagramSocket()) {
			byte[] bytes = new String("我是UDP方式发送的导弹").getBytes();
			DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 9090);		
			datagramSocket.send(datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void receiver() {
		try (DatagramSocket datagramSocket = new DatagramSocket(9090)) {
			byte[] buffer = new byte[100];
			DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
			datagramSocket.receive(datagramPacket);
			System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
