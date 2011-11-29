
public class Node extends Thread{
	private int id;
	private Double x,y; //coordinate of the node in the Unite-Square Area
	private Float radius,prob;
	private int locations;
	private int energy, en_send, en_rec, en_sign;
	
	public Node(int cont_id, Double coor_x, Double coor_y, Float r, Float p, Integer g, Integer e,
			Integer e_send, Integer e_rec, Integer e_sign) {
		id= cont_id;		//the ID for the node
		x= coor_x;			//x coordinate of the node
		y= coor_y;			//y coordinate of the node
		radius= r;			//communication radius of the node
		prob=p;				//Probability for a neighbour node to process a location claim
		locations=g;		//number of destination location
		energy=e;			//Total energy for the node
		en_send= e_send;	//Energy spent for sending a message
		en_rec= e_rec;		//Energy spent for receiving a message
		en_sign= e_sign;	//Energy for the signature of a message
		System.out.println(x+" "+y);
	}

}
