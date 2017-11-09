/**
 *
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;

import javax.net.ssl.HttpsURLConnection;

/**
 * @version 1.0
 * @author bin
 * @date 2006-7-13
 * @time 15:34:47
 * 
 */
public class HttpConn_client {

	private static final int MAX_BUF = 1024 * 640;
	


	public static void main(String[] args) {

		byte[] s = get("http://www.baidu.com/abc?a=1&b=2");
		
		
		System.out.println(new String(s));
		
	}

	public static byte[] read(DataInputStream dis) {

		byte[] ret = null;

		ByteBuffer bb = ByteBuffer.allocate(MAX_BUF);
		int ch;
		try {
			while ((ch = dis.read()) != -1) {
				bb.put((byte) ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		ret = new byte[bb.position()];
		bb.flip();
		bb.get(ret);

		// System.out.println(new String(ret));
		// String(ret));

		return ret;
	}

	public static byte[] get(String uri) {

		byte[] ret = null;

		HttpURLConnection con = null;
		DataInputStream dis = null;

		try {

			con = (HttpURLConnection) (new URL(uri)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			// con.setRequestProperty("Content-Length",
			// String.valueOf(rqs.length()));

			dis = new DataInputStream(con.getInputStream());
			ret = read(dis);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
					dis = null;
				}
				con = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	
	public static byte[] post(String uri, byte[] rqs) {

		byte[] ret = null;

		HttpURLConnection con = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			con = (HttpURLConnection) (new URL(uri)).openConnection();
			con.setRequestMethod("POST");
			con.setDoInput(true);
			con.setDoOutput(true);
			// con.setRequestProperty("Content-Length",
			// String.valueOf(rqs.length()));

			// System.out.println(con.getRequestProperty("Content-Length"));

			dos = new DataOutputStream(con.getOutputStream());
			dos.write(rqs);
			dis = new DataInputStream(con.getInputStream());
			ret = read(dis);

			System.out.println(new String(rqs));
			
			System.out.println(new String(ret));

		} catch (IOException e) {
			e.printStackTrace();
			throw new NullPointerException();
		} finally {
			try {
				if (dis != null) {
					dis.close();
					dis = null;
				}
				if (dos != null) {
					dos.close();
					dos = null;
				}
				con = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
}
