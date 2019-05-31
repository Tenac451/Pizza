import java.time.LocalDateTime;


/**
 * The class Order contains the begin and the end, i.e. delivery, of order as a date timestamp
 * Furthermore the class provides an objectmamagement of the ordered pizzas (later dishes)
 * @author  Gabriele Schmidt
 * @version 2.0
 *
 */


class OrderVO {

	private static final int MAX_DISHES = 10;


	private int orderNo;
	private String state;
	private int index;
	private LocalDateTime  timestampStartedOrder;
	private LocalDateTime  timestampDeliveredOrder;
	private DishVO[] shoppingBasket;
	private CustomerVO customer;

	public OrderVO(int orderNo, String state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
		
		this.orderNo = orderNo;
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setCustomer(customer);
		this.setState(state);
		index = 0;
		shoppingBasket = new DishVO[MAX_DISHES];
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
		if (index < MAX_DISHES) { // wenn maximale Anzahl noch nicht erreicht ...
			shoppingBasket[index] = dish; // füge Gericht and Position index ein ...
			index++; // inkrementiere den index 
		}
	}
	
	/**
	 * Methode for deleting the last dish from the shopping baskes of OrderVO.
	 * 
	 */
	public void deleteDish() {
		if (index > 0) { 
			shoppingBasket[index - 1] = null; // set object at position index - 1 null ...
			this.index--; // decrement index den index
		}
		else if(index == 0) 
			shoppingBasket[0] = null;
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
		if (index < MAX_DISHES && shoppingBasket[index] != null) 
			return shoppingBasket[index]; 
		else
			return null;
	}
	
	/**
	 * Mehtod returns number of Pizzas Later dishes
	 * 
	 * @return - number of pizzas
	 * 
	 */
	public int getNumberOfDishes() {
		return index;
	}

	
	//Setter und Getter
	public DishVO[] getShoppingBasket() {
		return shoppingBasket;
	}

	
	public void setShoppingBasket(DishVO[] warenkorb) {
		this.shoppingBasket = warenkorb;
	}

	public int getIndex() {
		return index;
	}

	

	
	// defalut management method of  Java
		
	public String toString() {
		

		StringBuilder text = new StringBuilder(String.format("OrderVO "+ getOrderNo() + " from %1$tm/%1$td/%1$tY %1$tH:%1$tM with delivery at  %2$tm/%2$td/%2$tY %2$tH:%2$tM\n", 
				timestampStartedOrder, timestampDeliveredOrder));
				
		text.append("of customer: " + customer.getLastName() + " " +  customer.getFirstName() + ", ID of customer: " + customer.getId() + "\n");

		for (int i = 0; i < index;i++) {
			if (shoppingBasket[i] != null) {
				text.append(shoppingBasket[i].toString());
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

	public static int getMAX_DISHES() {
		return MAX_DISHES;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}	

	
}
