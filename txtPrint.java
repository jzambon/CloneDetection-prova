import java.rmi.Remote;
import java.rmi.RemoteException;

public interface txtPrint extends Remote{
	
	public void print_on_txt(String values) throws RemoteException;

}
