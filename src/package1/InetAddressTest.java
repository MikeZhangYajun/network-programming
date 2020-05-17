package package1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		try {
			System.out.println(InetAddress.getByName("127.0.0.1"));
			System.out.println(InetAddress.getByName("www.algonquincollege.com"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
