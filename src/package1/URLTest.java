package package1;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/examples/beauty.jpg?user=Tom");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getFile());
			System.out.println(url.getQuery());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
