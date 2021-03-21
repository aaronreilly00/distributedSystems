package project.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import ds.client.ControllerGUI;
//import ds.service1.Service1Grpc;
//import ds.service2.Service2Grpc;
//import ds.service3.Service3Grpc;
//import ds.service4.Service4Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import livestock.LivestockRequest;
import livestock.LivestockResponse;
import livestock.LivestockService;
import livestock.LivestockServiceGrpc;

public class ControllerGUI implements ActionListener{
	
	
	private JTextField entry1, reply1;
	private JTextField reply2, reply3, reply4, reply5, reply6, reply7;
	//private JTextField entry3, reply3;
	//private JTextField entry4, reply4;


	private JPanel getLivestockServiceJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1 .setEditable(false);
		panel.add(reply1 );

		reply2 = new JTextField("", 10);
		reply2 .setEditable(false);
		panel.add(reply2 );
		
		
		reply3 = new JTextField("", 10);
		reply3 .setEditable(false);
		panel.add(reply3 );
	
		reply4 = new JTextField("", 10);
		reply4 .setEditable(false);
		panel.add(reply4 );
		
		reply5 = new JTextField("", 10);
		reply5 .setEditable(false);
		panel.add(reply5 );
		
		reply6 =new JTextField("", 10);
		reply6 .setEditable(false);
		panel.add(reply6 );
		
		reply7 = new JTextField("", 10);
		reply7 .setEditable(false);
		panel.add(reply7 );
		
		panel.setLayout(boxlayout);

		return panel;

	}
	
	public static void main(String[] args) {

		ControllerGUI gui = new ControllerGUI();

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
	
		panel.add( getLivestockServiceJPanel() );
		//panel.add( getService2JPanel() );
		//panel.add( getService3JPanel() );
		//panel.add( getService4JPanel() );

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("Invoke Service 1")) {
			System.out.println("service 1 to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			LivestockServiceGrpc.LivestockServiceBlockingStub blockingStub = LivestockServiceGrpc.newBlockingStub(channel);

			//preparing message to send
			LivestockRequest request = LivestockRequest.newBuilder().setTag(entry1.getText()).build();

			//retreving reply from service
			LivestockResponse response = blockingStub.livestock(request);

			reply1.setText( String.valueOf( response.getTag()));
			reply2.setText( String.valueOf( response.getGender()));
			reply3.setText( String.valueOf( response.getDob()));
			reply4.setText( String.valueOf( response.getTemperature()));
			reply5.setText( String.valueOf( response.getFeedTime()));
			reply6.setText( String.valueOf( response.getLatitude()));
			reply7.setText( String.valueOf( response.getLongitude()) );
		}else{
			
		}
	}

}
