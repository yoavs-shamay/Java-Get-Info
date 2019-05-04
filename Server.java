import java.net.*;
import java.util.*;
import java.io.*;

public class Server {
	public Server() {
		try {
			ServerSocket ss = new ServerSocket(9003);
			Socket s = ss.accept();
			Scanner sc = new Scanner(s.getInputStream());
			PrintStream ps = new PrintStream(s.getOutputStream());
			String m = sc.nextLine();
			String[] info = MySQLConnect.getInfo(Integer.parseInt(m));
			ps.println("name: " + info[0] + "\nphone: " + info[1]);
			sc.close();
			ps.close();
			s.close();
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}

}