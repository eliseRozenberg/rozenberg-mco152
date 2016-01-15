package rozenberg.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.google.gson.Gson;



public class NYPLFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Result> resultList;
	private JLabel pic;
	private NYPLapi nyplapi;
	private NYPL nypl;
	private JButton searchButton;
	private JPanel searchPanel;
	private JTextField textField;
	private JPanel mainPanel;
	private JPanel imagePanel;

	public NYPLFrame() {
		super.setTitle("NYPL Frame");
		setSize(800, 800);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		textField = new JTextField(50);
		searchPanel = new JPanel();
		searchPanel.add(textField);
		searchButton = new JButton("Search");
		searchPanel.add(searchButton);
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(searchPanel);
		
		imagePanel = new JPanel(); 
		resultList = new JList<Result>();

		pic = new JLabel();
		JScrollBar scrolBar2 = new JScrollBar(getY());
		JScrollBar scrollBar = new JScrollBar(getX());

		mainPanel = new JPanel();
		mainPanel.add(resultList, BorderLayout.WEST);
		mainPanel.add(pic, BorderLayout.CENTER);
		mainPanel.add(imagePanel, BorderLayout.NORTH);
		
		container.add(mainPanel);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				Thread thread = new Thread() {
					public void run() {
						URL url;
						try {
							url = new URL("http://api.repo.nypl.org/api/v1/items/search?q="+textField.getText()+"&publicDomainOnly=true");
							HttpURLConnection connection = (HttpURLConnection) url.openConnection();
							connection.setRequestProperty("Authorization","Token token=\"2lyc0cg2ipcj10m3\"");
							InputStream in = connection.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(in));
							Gson gson = new Gson();
							nypl = gson.fromJson(reader, NYPL.class);
							nyplapi = nypl.getNypLapi();
							Result[] results = nyplapi.getResponse().getResult();
							resultList.setListData(results);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				};
				thread.start();
			}
		});

	}
	
	public static void main(String[] args) {
		new NYPLFrame().setVisible(true);

	}
}
