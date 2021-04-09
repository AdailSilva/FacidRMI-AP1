package com.adailsilva.facid.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.adailsilva.facid.rmi.remoteinterface.RemoteInterface;

// Um cliente simples que chama um método da interface remota:
public class Client {

	private Client() {
	}

	public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		
		System.out.println("Host: " + host);

		try {

			Registry registry = LocateRegistry.getRegistry(host);

			RemoteInterface esbocoDeMetodo = null;

			try {

				esbocoDeMetodo = (RemoteInterface) registry.lookup(host);

			} catch (NotBoundException e) {

				System.out.println("NotBoundException:");
				e.printStackTrace();
			}

			String resposta = esbocoDeMetodo.trabalhoRmiFacid();
			
			System.out.println("Resposta: " + resposta);

		} catch (RemoteException e) {

			System.out.println("RemoteException:");
			e.printStackTrace();

		}

	}

}
