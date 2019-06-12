package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public class Serializer {
	private ObjectOutputStream os;
	private ObjectInputStream is;

	public Serializer(String datei) throws FileNotFoundException, NullPointerException {

		try {
			os = new ObjectOutputStream(new FileOutputStream(datei));
		}
		/*
		 * catch (FileNotFoundException e) { e.printStackTrace(); //
		 * FileNotFoundException ist eine IOException }
		 */
		catch (IOException e) {
			System.err.println(e.getMessage());
		}

		try {
			is = new ObjectInputStream(new FileInputStream(datei));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void serializeOrder(OrderVO order) {
		Objects.requireNonNull(os, "OS does not exist.");
		try {
			os.writeObject(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeOutput() {
		Objects.requireNonNull(os, "OS does not exist.");
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public OrderVO deserializeOrder() {
		OrderVO o = null;
		Objects.requireNonNull(is, "IS does not exist.");

		try {
			o = (OrderVO) is.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return o;
	}

	public void closeInput() {
		Objects.requireNonNull(is, "IS does not exist.");
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
