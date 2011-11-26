import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class txtPrintImpl extends UnicastRemoteObject {
	private static final long serialVersionUID = 1L;
	public txtPrintImpl() throws RemoteException {}
	
	public void print_on_txt(String values){
		PrintWriter write=null;
		try {
			write= new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Impossibile aprire un nuovo file output.txt");
		}
		write.println(values);
	}

}
