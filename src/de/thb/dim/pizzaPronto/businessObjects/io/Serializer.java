package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public class Serializer {
	private ObjectOutputStream os;
	private ObjectInputStream is;
	private String datei;

	public Serializer(String datei) throws FileNotFoundException, NullPointerException {
		this.datei = datei;
	}

	public void serializeOrder(OrderVO order) {
		try {
			FileOutputStream fileOut = new FileOutputStream(this.datei);
			try {
				os = new ObjectOutputStream(fileOut);
				os.writeObject(order);
				os.close();
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeOutput() {

	}

	public OrderVO deserializeOrder() {
		OrderVO o = null;
		try {
			FileInputStream fileIn = new FileInputStream(datei);

			try {
				is = new ObjectInputStream(fileIn);
				try {
					o = (OrderVO) is.readObject();
					is.close();
					fileIn.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return o;
	}

	public void closeInput() {

	}
}
