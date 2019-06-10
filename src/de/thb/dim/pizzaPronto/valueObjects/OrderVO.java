package de.thb.dim.pizzaPronto.valueObjects;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


/**
 * The class Order contains the begin and the end, i.e. delivery, of order as a date timestamp
 * Furthermore the class provides an objectmamagement of the ordered pizzas (later dishes)
 * @author  Gabriele Schmidt
 * @version 2.0
 *
 */


public class OrderVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5659749214801355825L;
	
	private int orderNo;
	private StateOfOrderVO state;
	private LocalDateTime  timestampStartedOrder;
	private LocalDateTime  timestampDeliveredOrder;
	private List<DishVO> shoppingBasket;
	private CustomerVO customer;

	public OrderVO(int orderNo, StateOfOrderVO state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
		
		this.orderNo = orderNo;
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setCustomer(customer);
		this.setState(state);
		this.shoppingBasket = new LinkedList<DishVO>();
		
	}

	
	
	/**
	 * Methode for adding a dish to the shopping baskes of OrderVO.
	 * Object is inserted in the position index, if
	 * the maximum number yet was not reached. 
	 * 
	 * @param dish - das hinzuzufügende Gericht
	 * 
	 */
	public void addDish(DishVO dish) {
		shoppingBasket.add(dish);
	}
	
	/**
	 * Methode for deleting the last dish from the shopping baskes of OrderVO.
	 * 
	 */
	public void deleteDish(DishVO dish) {
		shoppingBasket.remove(dish);
	}
	
	/**
	 * Calculates the total price of the order.
	 * 
	 * @return - totalPrice
	 * 
	 */
	public float calculatePriceDishes() {
		float total = 0.0f; // Gesamtpreis = 0 ...

		for (DishVO currentDish : shoppingBasket ) { // f�r alle Gerichte im
													// Warenkorb ...
			if (currentDish != null)
				total += currentDish.getPrice(); // Gesamtpreis = Gesamtpreis
													// + Preis der aktuellen
													// Gericht ...
		}
		return total;
	}

	
	
	
	/**
	 * Method returns the dish at the  position of index. 
	 * 
	 * @param index - Index
	 * @return - objects of PizzaVO lates Dishes, is null if no object exists on Posisition index 
	 * 
	 */
	public DishVO  getDish(int index) {
			return shoppingBasket.get(index); 
	}
	
	/**
	 * Mehtod returns number of Pizzas Later dishes
	 * 
	 * @return - number of pizzas
	 * 
	 */
	public int getNumberOfDishes() {
		return shoppingBasket.size();
	}

	
	//Setter und Getter
	public List<DishVO> getShoppingBasket() {
		return shoppingBasket;
	}

	
	public void setShoppingBasket(List<DishVO> warenkorb) {
		this.shoppingBasket = warenkorb;
	}

	
	// defalut management method of  Java
		
	public String toString() {
		

		StringBuilder text = new StringBuilder(String.format("OrderVO "+ getOrderNo() + " from %1$tm/%1$td/%1$tY %1$tH:%1$tM with delivery at  %2$tm/%2$td/%2$tY %2$tH:%2$tM\n", 
				timestampStartedOrder, timestampDeliveredOrder));
				
		text.append("of customer: " + customer.getLastName() + " " +  customer.getFirstName() + ", ID of customer: " + customer.getId() + "\n");
		text.append(" " + this.state + " ");
		for (int i = 0; i < getNumberOfDishes();i++) {
			if (shoppingBasket.get(i) != null) {
				text.append(shoppingBasket.get(i).toString());
				text.append("\n");
			}
		}

		return text.toString();
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}

		OrderVO other = (OrderVO) obj;
		if (orderNo != other.getOrderNo()) {
			return false;
		}
		return true;
	}

	

	/* (non-Javadoc)
	* @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hc = 0;
		final int hashMultiplier = 59;
		hc = hashMultiplier * orderNo;

		return hc;
	}

	//setter und getter
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}

	public void setTimestampStartedOrder(LocalDateTime order) {
		this.timestampStartedOrder = order;
	}

	public LocalDateTime getTimestampDeliveredOrder() {
		return timestampDeliveredOrder;
	}

	public void setTimestampDeliveredOrder(LocalDateTime delivery) {
		this.timestampDeliveredOrder = delivery;
	}
	
	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}


	/**
	 * @return the state
	 */
	public StateOfOrderVO getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(StateOfOrderVO state) {
		
		this.state = state;
	}	

	
}
