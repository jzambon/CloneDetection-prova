
public class IllegalValueException extends Exception {
	private static final long serialVersionUID = 1L;
	private String name;
	
	IllegalValueException(String n){
		name= n;
	}
	
	public String getError(){
		return "Il valore del campo "+name+" non è accettabile per la simulazione";
	}
}
