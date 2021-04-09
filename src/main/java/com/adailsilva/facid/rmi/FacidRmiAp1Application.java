package com.adailsilva.facid.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adailsilva.facid.rmi.remoteinterface.RemoteInterface;
import com.adailsilva.facid.rmi.server.Server;

@SpringBootApplication
public class FacidRmiAp1Application {

	public static void main(String[] args) {
		SpringApplication.run(FacidRmiAp1Application.class, args);

		Server objeto = new Server();

		try {

			// Stub: (esbocoDeMetodo).
			RemoteInterface esbocoDeMetodo = (RemoteInterface) UnicastRemoteObject.exportObject(objeto, 0);

			// Vincula o stub do objeto remoto no registro:
			Registry registry = LocateRegistry.getRegistry();

			registry.bind("RemoteInterface", esbocoDeMetodo);

			System.out.println("Servidor Pronto!");

		} catch (RemoteException e) {

			System.out.println("RemoteException:");

			e.printStackTrace();

		} catch (AlreadyBoundException e) {

			System.out.println("AlreadyBoundException:");

			e.printStackTrace();
		}
	}

}
