package rozenberg.contactList;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JList;
import com.google.gson.Gson;

public class ContactFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JList<String> contactList;
	private ContactList contacts;
	private String[] contactNames;

	public ContactFrame() {
		super.setTitle("ContactList");
		setSize(600, 600);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contactList = new JList<String>();
		container.add(contactList);
		Thread thread = new Thread() {
			public void run() {
				URL url;
				try {
					url = new URL("http://jsonplaceholder.typicode.com/users");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					Gson gson = new Gson();
					contacts = gson.fromJson(reader, ContactList.class);
					contactNames = new String[contacts.size()];
					for (int i = 0; i < contactNames.length; i++) {
						contactNames[i] = contacts.get(i).getName();
					}
					for (int j = 0; j < contactNames.length; j++) {
						for (int i = j + 1; i < contactNames.length; i++) {
							if (contactNames[i].compareTo(contactNames[j]) < 0) {
								String temp = contactNames[j];
								contactNames[j] = contactNames[i];
								contactNames[i] = temp;
							}
						}
					}
					contactList.setListData(contactNames);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		thread.start();

	}

	public static void main(String[] args) {
		ContactFrame frame = new ContactFrame();
		frame.setVisible(true);
	}

}
