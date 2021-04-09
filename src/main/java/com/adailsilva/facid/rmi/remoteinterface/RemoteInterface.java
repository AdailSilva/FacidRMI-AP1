package com.adailsilva.facid.rmi.remoteinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Definir a interface remota:
public interface RemoteInterface extends Remote {

	String trabalhoRmiFacid() throws RemoteException;

}
