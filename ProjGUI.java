import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ProjGUI implements ActionListener{
	private JFrame jf= new JFrame("Clone Detection");
	private JLabel conf_lab= new JLabel("Inserire URL file di configurazione");
	private JLabel servrmi_lab= new JLabel ("Inserire URL del server RMI");
	private JTextField conf_tf= new JTextField("www.math.unipd.it/~conti/teaching/PCD1112/project_config.txt");
	private JTextField servrmi_tf= new JTextField("localhost");
	JScrollPane scrollta= new JScrollPane();
	private JTextArea resultarea= new JTextArea(30,90);
	private JButton start= new JButton("Start");
	private JButton stop= new JButton("Stop");
	private Simulation simulation;
	
	public ProjGUI() {
		//create a scrollbar for the text area
		resultarea.setLineWrap(true);
		scrollta = new JScrollPane(resultarea);
		scrollta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//the external jframe (BorderLayout) contains some jpanels (GridLayout or FlowLayout)
		//first jpanel: for the configuration file URL (label+textfield)
		JPanel conf= new JPanel();
		conf.setLayout(new GridLayout(1,1));
		conf.add(conf_lab); conf.add(conf_tf);
		//second jpanel: for the server RMI address URL (label+textfield)
		JPanel servrmi= new JPanel();
		servrmi.setLayout(new GridLayout(1,1));
		servrmi.add(servrmi_lab); servrmi.add(servrmi_tf);
		//third jpanel: for the buttons start & stop
		JPanel buttons= new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttons.add(start); buttons.add(stop);
		//fourth jpanel: for the text area that will show the results of the simulations
		JPanel area= new JPanel();
		area.setLayout(new FlowLayout(FlowLayout.CENTER));
		area.add(scrollta);
		//the cointainer for the previous four jpanels
		JPanel cont= new JPanel();
		cont.setLayout(new GridLayout(0,1));
		cont.add(conf); cont.add(servrmi); cont.add(buttons);
		//jframe Layout: cont in the center and area in the south
		jf.setLayout(new BorderLayout());
		jf.add(cont, BorderLayout.CENTER);
		jf.add(area,BorderLayout.SOUTH);
		//end layout.
		//frame behaviors
		jf.pack();
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		start.addActionListener(this);
		stop.addActionListener(this);
		stop.setEnabled(false);
	}
	
	public JTextArea getResultArea(){
		return resultarea;
	}
	public void resetInitialState(){
		start.setEnabled(true);
		stop.setEnabled(false);
	}
	public void actionPerformed(ActionEvent e) {
		String pressed=e.getActionCommand();
		if(pressed=="Start"){
			start.setEnabled(false);
			stop.setEnabled(true);
			resultarea.setText("");
			System.out.println("Inizio simulazione");
			resultarea.append("\n"+pressed);
			//let's the simulation begin
			simulation= new Simulation(conf_tf.getText(), servrmi_tf.getText(), this);
			simulation.config();
		}
		if(pressed=="Stop"){
			stop.setEnabled(false);
			//start.setEnabled(true);
			System.out.println("Fine simulazione");
			resultarea.append("\n"+pressed);
			//stop the simulation
//			simulation.interrupt();
		}
	}

	public static void main(String[] args){
		ProjGUI frame= new ProjGUI();
	}
}
