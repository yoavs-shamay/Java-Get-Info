import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	public Client() {
		try {
			Socket s = new Socket("localhost",9003);
			PrintStream ps = new PrintStream(s.getOutputStream());
			Scanner sc = new Scanner(s.getInputStream());
			Scanner userInput = new Scanner(System.in);
			int id = userInput.nextInt();
			userInput.close();
			ps.println(id);
			System.out.println(sc.nextLine());
			System.out.println(sc.nextLine());
			ps.close();
			sc.close();
			s.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client();
	}

}