package rozenberg.chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatWindow extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JTextField textField;
	private JButton button;

	// need the IP address of the person next to you and the port
	public ChatWindow() {
		setTitle("Chat Group");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		textArea = new JTextArea();
		textField = new JTextField(15);
		button = new JButton("SEND");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(textField);
		panel.add(button);

		add(textArea, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		Server server = new Server(8080);
		server.setHandler(new ChatP2PHandler(this.textArea));
		try {
			server.start();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		// to handle the request
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 192.168.117.158
				// need to take the text field and send it to the i
				try {

					URL url = new URL("http://192.168.117.111:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(textField.getText());
					writer.flush();

					connection.getInputStream();

					// ready to read
					// since http is a request
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
	}

	public static void main(String[] args) {
		ChatWindow chatWindow = new ChatWindow();
		chatWindow.setVisible(true);
	}

}