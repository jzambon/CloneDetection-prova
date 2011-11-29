
public class Hypervisor {
	private String host_rmi, protocol;
	private Integer n,g,e,e_send,e_rec,e_sign;
	private Float p,r;

	public Hypervisor(String host, String prot, Integer g_in,
			Integer n_in, Integer e_in, Integer e_s, Integer e_r,
			Integer e_signat, Float p_in, Float r_in) {	//constructor from Simulation, data from ProjGUI -> Simulation
		host_rmi=host;	//host for the RMI server
		protocol=prot;	//protocol used for the simulation (LSM or RED)
		g=g_in;			//number of destination location
		n=n_in;			//number of nodes in the network
		e=e_in;			//Total energy for each nodes
		e_send=e_s;		//Energy spent for sending a message
		e_rec=e_r;		//Energy spent for receiveing  a message
		e_sign= e_signat;	//Energy for the signature of a message
		p=p_in;			//Probability for a neighbour node to process a location claim
		r=r_in;			//Communication radius of a node
	}

	public void init_usa() {
		int cont_id;
		for(cont_id=0;cont_id<n; cont_id++){	//cont_id is for the ID of a node (from 0 to n-1)
			Double x= Math.random();
			Double y= Math.random();
			Node node= new Node(cont_id,x,y, r,p,g,e,e_send,e_rec,e_sign);
			//posizionare nodo nella rete 1x1 (Math.random)
		}
		
	}

}
