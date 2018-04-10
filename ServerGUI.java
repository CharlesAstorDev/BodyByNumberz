package bodyByNumberz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import lab1out.ClientGUI.EventHandler;

public class ServerGUI extends JFrame {
	// Data Fields
	private JLabel stat;
	private JLabel status; // Initialized to Not Connected
	private String[] labels = { "Port #", "Timeout" };
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea log;
	private JPanel boxPanel;
	private JPanel statusPanel;
	private JPanel portPanel;
	private JPanel timeoutPanel;
	private JLabel logLabel;
	private JPanel logPanel;
	private JPanel textAreaPanel;
	private JPanel btnPanel;
	private JButton listen;
	private JButton stop;
	private JButton close;
	private JButton quit;
	private EventHandler1 eventHandler = new EventHandler1();
	private ChatServer server;
	private Boolean isStarted;
	private Database database;
	// Constructor
	public ServerGUI() {
		isStarted = false;
		database = new Database();
		server = new ChatServer();
		server.setDatabase(database);
		this.setLayout(new BorderLayout());

		statusPanel = new JPanel(new FlowLayout());
		statusPanel.add(new JLabel("Status: "));
		status = new JLabel("Not Connected");
		status.setForeground(Color.red);
		statusPanel.add(status);

		portPanel = new JPanel(new FlowLayout());
		portPanel.add(new JLabel(labels[0]));
		textFields[0] = new JTextField(labels[0].length());
		portPanel.add(textFields[0]);

		timeoutPanel = new JPanel(new FlowLayout());
		timeoutPanel.add(new JLabel(labels[1]));
		textFields[1] = new JTextField(labels[1].length());
		timeoutPanel.add(textFields[1]);

		logLabel = new JLabel("Server Log Below");
		logPanel = new JPanel(new FlowLayout());
		logPanel.add(logLabel);
		textAreaPanel = new JPanel(new FlowLayout());
		// textAreaPanel.add(logLabel, BorderLayout.CENTER);

		log = new JTextArea(15, 30);

		textAreaPanel.add(new JScrollPane(log));

		listen = new JButton("Listen");
		stop = new JButton("Stop");
		close = new JButton("Close");
		quit = new JButton("Quit");
		btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(listen);
		btnPanel.add(stop);
		btnPanel.add(close);
		btnPanel.add(quit);

		boxPanel = new JPanel();
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
		boxPanel.add(statusPanel);
		boxPanel.add(portPanel);
		boxPanel.add(timeoutPanel);
		boxPanel.add(logPanel);
		boxPanel.add(textAreaPanel);
		boxPanel.add(btnPanel);

		this.add(boxPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setSize(500, 500);

		listen.addActionListener(eventHandler);
		stop.addActionListener(eventHandler);
		close.addActionListener(eventHandler);
		quit.addActionListener(eventHandler);

	}

	// Methods

	public JTextField getTextFieldAt(int index) {
		return textFields[index];
	}

	public JLabel getStatus() {
		return status;
	}

	public JTextArea getLog() {
		return log;
	}

	public class EventHandler1 implements ActionListener {

		public EventHandler1() {

		}

		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			Object source = e.getActionCommand();
			if (source == "Listen") {
				isStarted = true;
				// status.setText("Listen Button Pressed");
				System.out.println("Listen Button Pressed");
				if (textFields[0].getText().contentEquals("") || textFields[1].getText().contentEquals("")) {
					log.setText("Port Number/timeout not entered before pressing Listen");
				} else {
					try {
						server.setPort(Integer.parseInt(textFields[0].getText()));
						server.setTimeout(Integer.parseInt(textFields[1].getText()));
						server.listen();
						server.setLog(log);
						server.setStatus(status);
						// server.serverStarted();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			} else if (source == "Close") {
				if (isStarted == false) {
					log.append("\nServer Not Currently Started");
					status.setText("Close Button Pressed");
				} else {
					try {
						server.close();
					//	server.setLog(log);
					//	server.setStatus(status);
						// server.serverClosed();
						isStarted = false;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				System.out.println("Close Button Pressed");

				// System.out.println("Client Data: " +
				// getClientArea().getText());
			} else if (source == "Stop") {
				if (isStarted == false) {
					status.setText("Stop Button Pressed");
					log.append("\nServer Not Currently Started");
				} else {
					server.stopListening();
				//	server.setLog(log);
				//	server.setStatus(status);
					// server.serverStopped();
					isStarted = false;

				}

				System.out.println("Stop Button Pressed");
			} else if (source == "Quit") {
				System.exit(0);
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerGUI();

	}
}
