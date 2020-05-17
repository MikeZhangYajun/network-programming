package package1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class URLTest1 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/examples/beauty.jpg?user=Tom");
			HttpURLConnection openConnection = (HttpURLConnection)url.openConnection();
			openConnection.connect();
			InputStream inputStream = openConnection.getInputStream();
			FileOutputStream fileOutputStream = new FileOutputStream("beauty3.jpg");
			byte[] buffer = new byte[1024];
			int len;
			while((len=inputStream.read(buffer))!=-1) {
				fileOutputStream.write(buffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
