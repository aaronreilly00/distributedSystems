package project;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import org.python.core.PyObject;
//import org.python.core.PyString;
//import org.python.util.PythonInterpreter;

import alarm.AlarmServiceGrpc;
import alarm.Point;
import alarm.RouteNote;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lighting.LightRequest;
import lighting.LightResponse;
import lighting.LightServiceGrpc;
//import lighting.LightingClient;
//import lighting.LightingServer;
import lighting.PowerRequest;
import lighting.PowerResponse;
import livestock.LivestockRequest;
import livestock.LivestockResponse;
//import livestock.LivestockServer;
import livestock.LivestockServiceGrpc;
import tractor.TractorServiceGrpc;
import tractor.TractorServiceGrpc.TractorServiceBlockingStub;

public class ControllerGUI1 implements ActionListener {

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

		JLabel label = new JLabel("Enter value");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		tagEntry = new JTextField("", 10);
		panel.add(tagEntry);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 1");
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

		JLabel label = new JLabel("Enter value");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		powerEntry = new JTextField("", 10);
		panel.add(powerEntry);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 2");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		powerReply = new JTextField("", 10);
		powerReply.setEditable(false);
		panel.add(powerReply);

		JLabel label2 = new JLabel("Enter value");
		panel.add(label);
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

		JLabel label = new JLabel("Enter Lat");
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		alarmLatEntry = new JTextField("", 10);
		panel.add(alarmLatEntry);
		JLabel label13 = new JLabel("Enter Long");
		panel.add(label13);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		alarmLongEntry = new JTextField("", 10);
		panel.add(alarmLongEntry);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Alarm System");
		button.addActionListener(this);
		panel.add(button);
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

		JLabel label = new JLabel("Enter value");
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

	public static void main(String[] args) {
		// ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",
		// 50051).usePlaintext().build();
		// asyncStub = LivestockServiceGrpc.newStub(channel);

		ControllerGUI1 gui = new ControllerGUI1();
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

		if (label.equals("Invoke Service 1")) {

			System.out.println("service 1 to be invoked ...");
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
		} else if (label.equals("Invoke Service 2")) {
			System.out.println("service 2 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
			LightServiceGrpc.LightServiceBlockingStub blockingStub = LightServiceGrpc.newBlockingStub(channel);

			// preparing message to send
			if (powerEntry.getText().equalsIgnoreCase("on")) {
				lighting.PowerRequest request = lighting.PowerRequest.newBuilder().setSwitch(true).build();

				// retreving reply from service
				lighting.PowerResponse response = blockingStub.switchPower(request);

				powerReply.setText(String.valueOf("Light power has been turned on! " + response.getSwitch()));

			} else if (powerEntry.getText().equalsIgnoreCase("off")) {
				lighting.PowerRequest request = lighting.PowerRequest.newBuilder().setSwitch(false).build();

				// retreving reply from service
				lighting.PowerResponse response = blockingStub.switchPower(request);

				powerReply.setText(String.valueOf("Light power has been turned off! " + response.getSwitch()));

			}

		} else if (label.equals("Change brightness")) {
			System.out.println("service 2 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
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
				requestObserver.onNext(LightRequest.newBuilder().setLight(2).build());
				System.out.println("Sent");
				requestObserver.onNext(LightRequest.newBuilder().setLight(3).build());
				System.out.println("Sent");
				requestObserver.onNext(LightRequest.newBuilder().setLight(4).build());
				System.out.println("Sent");
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
			System.out.println("Alarm System invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			asyncStub2 = AlarmServiceGrpc.newStub(channel);
			
			StreamObserver<RouteNote> responseObserver = new StreamObserver<RouteNote>() {

				@Override
				public void onNext(RouteNote value) {
					System.out.println("receiving statement to print -> " + value.getLocation() + value.getTag());
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
				//requestObserver.onNext(Point.newBuilder().setLongitude(longitude).build());
				
				alarmReply.setText("lat: " + lat + "lon: " + lon);

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
			
				
			//try(PythonInterpreter interpreter = new PythonInterpreter()){
			//interpreter.exec("print('Hello World')");
			// execute a function that takes a string and returns a string
			//PyObject someFunc = interpreter.get("funcName");
			//PyObject result = someFunc.__call__(new PyString("Test!"));
			//String realResult = (String) result.__tojava__(String.class);
			//}
		}else {

		}

	}
}
