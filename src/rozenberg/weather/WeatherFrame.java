package rozenberg.weather;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

public class WeatherFrame extends JFrame {
	private JPanel zipPanel, backgroundPanel, weatherPanel;

	private ImageIcon background;
	private ImageIcon icon;
	private Image image;
	private Button zipButton;
	private JLabel heading, beach, desert, lightning, blueSky, garden, nyc, tornado, name, zipError, zipLabel,
			imageLabel, temp, humidity, description;
	private JTextField zipField;
	private WeatherConnect weather;
	private Font font;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeatherFrame() {
		super.setTitle("Weather Display");
		setSize(800, 700);
		getContentPane().setBackground(Color.black);
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		weather = new WeatherConnect();

		heading = new JLabel("...WEATHER");
		backgroundPanel = new JPanel(new FlowLayout());

		zipPanel = new JPanel();
		zipLabel = new JLabel("ENTER ZIP: ");
		zipField = new JTextField();
		zipButton = new Button("Search");
		zipError = new JLabel();

		weatherPanel = new JPanel();
		name = new JLabel();
		temp = new JLabel();
		humidity = new JLabel();
		description = new JLabel();
		imageLabel = new JLabel();

		formatPanels();
		addPanels();
	}

	private JLabel setImage(String imageName) {
		background = new ImageIcon(imageName);
		image = background.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return new JLabel(new ImageIcon(image));
	}

	private void formatPanels() {
		font = new Font("Times New Roman", Font.ITALIC, 70);
		heading.setFont(font);
		heading.setForeground(Color.RED);
		backgroundPanel.setLayout(new FlowLayout());
		backgroundPanel.setBackground(Color.black);
		garden = setImage("garden.jpg");
		beach = setImage("Lightning.jpg");
		lightning = setImage("city-beach.jpg");
		desert = setImage("desert.jpg");
		tornado = setImage("tornado.jpg");
		nyc = setImage("nyc-skyline.jpg");
		blueSky = setImage("bluesky.jpg");

		zipPanel.setBackground(Color.black);
		font = new Font("Times New Roman", Font.PLAIN, 30);
		zipLabel.setFont(font);
		zipLabel.setForeground(Color.white);
		zipField.setFont(font);
		zipField.setColumns(5);
		zipField.setBackground(Color.black);
		zipField.setForeground(Color.white);
		zipButton.setFont(font);
		zipButton.setBackground(Color.black);
		zipButton.setForeground(Color.WHITE);
		zipError.setFont(font);
		zipError.setForeground(Color.white);

		weatherPanel.setBackground(Color.red);
		font = new Font("Arial", Font.PLAIN, 45);
		name.setFont(font);
		name.setForeground(Color.black);
		font = new Font("Arial", Font.PLAIN, 30);
		humidity.setFont(font);
		humidity.setForeground(Color.black);
		description.setFont(font);
		description.setForeground(Color.black);
		font = new Font("Arial", Font.PLAIN, 65);
		temp.setFont(font);
		temp.setForeground(Color.yellow);
	}

	private void addPanels() {
		add(heading);
		backgroundPanel.add(blueSky);
		backgroundPanel.add(beach);
		backgroundPanel.add(lightning);
		backgroundPanel.add(desert);
		backgroundPanel.add(tornado);
		backgroundPanel.add(nyc);
		backgroundPanel.add(garden);
		add(backgroundPanel);

		weatherPanel.add(imageLabel);
		weatherPanel.add(name);
		weatherPanel.add(temp);
		weatherPanel.add(humidity);
		weatherPanel.add(description);
		add(weatherPanel).setSize(400, 400);

		zipPanel.add(zipLabel);
		zipPanel.add(zipField);
		zipPanel.add(zipButton);
		zipPanel.add(zipError);
		add(zipPanel);

		zipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread = new Thread() {
					public void run() {
						String zip = zipField.getText().toString();
						Pattern pattern = Pattern.compile("^[0-9]{5}");
						if (pattern.matcher(zip).matches()) {
							zipError.setText("");
							try {
								weather.getWeatherInfo(zip);
								icon = new ImageIcon(
										new URL("http://openweathermap.org/img/w/" + weather.getIcon() + ".png"));
								image = icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
								imageLabel.setIcon(new ImageIcon(image));
								name.setText(weather.getName() + "      ");
								temp.setText(weather.getTemp() + "°F");
								humidity.setText("\nHumidity: " + weather.getHumidity() + "%     ");
								description.setText(weather.getDescription().toUpperCase());
							} catch (IOException | InvalidZipException e1) {
								zipError.setText("INVALID ZIP");
							}
						} else {
							zipError.setText("INVALID ZIP");
						}
					}
				};
				thread.start();
			}
		});

	}

	public static void main(String[] args) {
		WeatherFrame frame = new WeatherFrame();
		frame.setVisible(true);
	}

}
