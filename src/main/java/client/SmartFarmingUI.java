package client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import alarm.AlarmServiceGrpc;
import alarm.Point;
import alarm.RouteNote;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lighting.LightRequest;
import lighting.LightResponse;
import lighting.LightServiceGrpc;
import livestock.LivestockRequest;
import livestock.LivestockResponse;
import livestock.LivestockServiceGrpc;
import tractor.TractorServiceGrpc;
import tractor.TractorServiceGrpc.TractorServiceBlockingStub;

public class SmartFarmingUI implements ActionListener {

	private JTextField tagEntry, tag, gender, dob, temperature, feedTime, latitude, longitude;
	private JTextField powerEntry, powerReply, brightnessEntry, updatedBrightness;
	private JTextField alarmLatEntry,alarmLongEntry, alarmReply;
	private JTextField brand, brandReply;
	private static LivestockServiceGrpc.LivestockServiceStub asyncStub;
	private static LightServiceGrpc.LightServiceStub asyncStub1;
	private static AlarmServiceGrpc.AlarmServiceStub asyncStub2;

	private JPanel getLivestockServiceJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Animal Tag");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		tagEntry = new JTextField("", 10);
		panel.add(tagEntry);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service Livestock");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		tag = new JTextField("", 10);
		tag.setEditable(false);
		panel.add(tag);

		gender = new JTextField("", 10);
		gender.setEditable(false);
		panel.add(gender);

		dob = new JTextField("", 10);
		dob.setEditable(false);
		panel.add(dob);

		temperature = new JTextField("", 10);
		temperature.setEditable(false);
		panel.add(temperature);

		feedTime = new JTextField("", 10);
		feedTime.setEditable(false);
		panel.add(feedTime);

		latitude = new JTextField("", 10);
		latitude.setEditable(false);
		panel.add(latitude);

		longitude = new JTextField("", 10);
		longitude.setEditable(false);
		panel.add(longitude);

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel lightingServiceJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Switch Power");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		powerEntry = new JTextField("", 10);
		panel.add(powerEntry);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Power");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		powerReply = new JTextField("", 10);
		powerReply.setEditable(false);
		panel.add(powerReply);

		JLabel label2 = new JLabel("Brightness Level");
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		brightnessEntry = new JTextField("", 10);
		panel.add(brightnessEntry);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button1 = new JButton("Change brightness");
		button1.addActionListener(this);
		panel.add(button1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		updatedBrightness = new JTextField("", 10);
		updatedBrightness.setEditable(false);
		panel.add(updatedBrightness);
		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getAlarmJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter Latitude");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		alarmLatEntry = new JTextField("", 10);
		panel.add(alarmLatEntry);
		JLabel label13 = new JLabel(" Enter Longitude");
		panel.add(label13);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		alarmLongEntry = new JTextField("", 10);
		panel.add(alarmLongEntry);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton alarmBtn = new JButton("Alarm System");
		alarmBtn.addActionListener(this);
		panel.add(alarmBtn);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		alarmReply = new JTextField("", 10);
		alarmReply.setEditable(false);
		panel.add(alarmReply);

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getTractorDetailsJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter brand");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		brand = new JTextField("", 10);
		panel.add(brand);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Tractor Details");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		brandReply = new JTextField("", 10);
		brandReply.setEditable(false);
		panel.add(brandReply);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private static class SampleListener implements ServiceListener {
		@Override
		public void serviceAdded(ServiceEvent event) {
			
			  
			System.out.println("Service added: " + event.getInfo());
			
			
			 try {                
                 Socket s = new Socket("localhost", 9090);
                 BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 String answer = input.readLine();
                 JOptionPane.showMessageDialog(null, answer);
                 System.exit(0);
             } catch (IOException ex) {
                 Logger.getLogger(SmartFarmingUI.class.getName()).log(Level.SEVERE, null, ex);
             }
			 
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}

		@Override
		public void serviceResolved(ServiceEvent event) {
                    System.out.println("Service resolved: " + event.getInfo());

                    try {
                        ServiceInfo info = event.getInfo();
                        int port = info.getPort();
                        String address = info.getHostAddresses()[0];
                        Socket s = new Socket(address, port);
                        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        String answer = input.readLine();
                        JOptionPane.showMessageDialog(null, answer);
                        System.exit(0);
                    } catch (IOException ex) {
                        Logger.getLogger(SmartFarmingUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
	}

	public static void main(String[] args) throws InterruptedException{
	
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Add a service listener
			jmdns.addServiceListener("_smartFarming._tcp.local.", new SampleListener());

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		SmartFarmingUI gui = new SmartFarmingUI();
		gui.build();
	}

	private void build() {

		JFrame frame = new JFrame("Service Controller Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

		panel.add(getLivestockServiceJPanel());
		panel.add(lightingServiceJPanel());
		panel.add(getAlarmJPanel());
		panel.add(getTractorDetailsJPanel());

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String label = button.getActionCommand();

		if (label.equals("Invoke Service Livestock")) {

			System.out.println("Service Livestock to be invoked ...");
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			asyncStub = LivestockServiceGrpc.newStub(channel);
			LivestockRequest request = LivestockRequest.newBuilder().setTag(tagEntry.getText()).build();

			StreamObserver<LivestockResponse> responseObserver = new StreamObserver<LivestockResponse>() {

				@Override
				public void onNext(LivestockResponse value) {
					System.out.println("Tag name changed to " + value);
					tag.setText(String.valueOf(value.getTag()));
					gender.setText(String.valueOf(value.getGender()));
					dob.setText(String.valueOf(value.getDob()));
					temperature.setText(String.valueOf(value.getTemperature()));
					feedTime.setText(String.valueOf(value.getFeedTime()));
					latitude.setText(String.valueOf(value.getLatitude()));
					longitude.setText(String.valueOf(value.getLongitude()));

				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();

				}

				@Override
				public void onCompleted() {
					System.out.println("on completed ");
				}

			};

			asyncStub.livestock(request, responseObserver);

			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if (label.equals("Power")) {
			System.out.println("Lighting service to be invoked ...");

			ManagedChannel channel1 = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			LightServiceGrpc.LightServiceBlockingStub blockingStub = LightServiceGrpc.newBlockingStub(channel1);

			// preparing message to send
			if (powerEntry.getText().equalsIgnoreCase("on")) {
				lighting.PowerRequest request = lighting.PowerRequest.newBuilder().setSwitch(true).build();

				// retreving reply from service
				lighting.PowerResponse response = blockingStub.switchPower(request);

				powerReply.setText(String.valueOf("power status set to " + response.getSwitch()));

			} else if (powerEntry.getText().equalsIgnoreCase("off")) {
				lighting.PowerRequest request = lighting.PowerRequest.newBuilder().setSwitch(false).build();

				// retreving reply from service
				lighting.PowerResponse response = blockingStub.switchPower(request);

				powerReply.setText(String.valueOf("power status set to " + response.getSwitch()));

			}

		} else if (label.equals("Change brightness")) {
			System.out.println("Lighting service to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			asyncStub1 = LightServiceGrpc.newStub(channel);

			StreamObserver<LightResponse> responseObserver = new StreamObserver<LightResponse>() {

				@Override
				public void onNext(LightResponse value) {
					// Print out response
					System.out.println("Brightness has been set to level " + value.getLight());
					updatedBrightness.setText(String.valueOf(value.getLight()));
				}

				@Override
				public void onError(Throwable t) {

				}

				@Override
				public void onCompleted() {

				}
			};

			StreamObserver<LightRequest> requestObserver = asyncStub1.changeLight(responseObserver);
			try {
				String text = brightnessEntry.getText();
				int brightness = Integer.parseInt(text);
				// send a stream of requests
				requestObserver.onNext(LightRequest.newBuilder().setLight(brightness).build());
				System.out.println(brightness);
				updatedBrightness.setText(text);
				requestObserver.onNext(LightRequest.newBuilder().setLight(5).build());
				System.out.println("Sent");

				Thread.sleep(new Random().nextInt(1000) + 500);
				// catch any errors
			} catch (RuntimeException e1) {
				requestObserver.onError(e1);
				throw e1;
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}
			requestObserver.onCompleted();

		} else if (label.equals("Alarm System")) {
			System.out.println("Alarm System to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			asyncStub2 = AlarmServiceGrpc.newStub(channel);
			
			StreamObserver<RouteNote> responseObserver = new StreamObserver<RouteNote>() {

				@Override
				public void onNext(RouteNote value) {
					alarmReply.setText(value.getLocation() + value.getTag());
				}

				@Override
				public void onError(Throwable t) {

				}

				@Override
				public void onCompleted() {

				}

			};

			StreamObserver<Point> requestObserver = asyncStub2.routeTracking(responseObserver);
			try {
				String lat = alarmLatEntry.getText();
				String lon = alarmLongEntry.getText();
				double latitude = Double.parseDouble(lat);
				double longitude = Double.parseDouble(lon);
				
				requestObserver.onNext(Point.newBuilder().setLatitude(latitude).setLongitude(longitude).build());

				Thread.sleep(new Random().nextInt(1000) + 500);

			} catch (RuntimeException e2) {
				requestObserver.onError(e2);
				throw e2;
			} catch (InterruptedException e2) {

				e2.printStackTrace();
			}

			requestObserver.onCompleted();

		} else if (label.equals("Tractor Details")){
			
			ManagedChannel channel3 = ManagedChannelBuilder.forAddress("localhost", 50067).usePlaintext().build();
			TractorServiceBlockingStub blockingStub12 = TractorServiceGrpc.newBlockingStub(channel3);


				tractor.TractorRequest request = tractor.TractorRequest.newBuilder().setName(brand.getText()).build();

				// retreving reply from service
				tractor.TractorResponse response = blockingStub12.tractorDetails(request);

				brandReply.setText(String.valueOf(response.getMessage()));
			
		}else {

		}

	}
}
