import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 
 * @author Jan Münchberger
 *
 */

public class OrderVO {
	
	private static final int MAX_DISHES = 10;
	
	private int orderNo;
	private String state;
	private int index;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliverdOrder;
	private CustomerVO customer;
	private DishVO[] shoppingBasket; 

	
	public OrderVO(int orderNo, String state, LocalDateTime timestampStartedOrder,CustomerVO customer) {
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setCustomer(customer);
		this.setState(state);
		this.orderNo = orderNo;
		this.shoppingBasket = new DishVO[OrderVO.MAX_DISHES];
		this.index = 0;
		
	}
	
	public void addDish(DishVO dish) {
		if(dish != null && this.index < OrderVO.MAX_DISHES) {
			this.shoppingBasket[this.index] = dish;
			this.index++;
		}
	}
	
	public void deleteDish() {
		if(this.index > 0) {
			this.index--;
			this.shoppingBasket[this.index] = null;
		}
	}
	
	public void deleteDish(DishVO dish) {
		//#TODO delete das richtige Dish
		for (DishVO basketDish : shoppingBasket) {			 
            if(basketDish.equals(dish)) {
            	basketDish = null;
            }
        }
	}
	
	public float calculatePriceDishes () {
		float erg = 0.0f;
		for (DishVO  dish: this.shoppingBasket) {
			if(dish instanceof DishVO) {
				erg = erg + dish.getPrice();
			}
	    }
		return erg;
	}
	
	public DishVO getDish(int index) {
		if(index < OrderVO.MAX_DISHES) {
			return this.shoppingBasket[index];
		}
		return null;
	}
	
	public int getNumerOfDishes() {
		return this.index;
	}
	
	public String toString() {
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy hh:mm");
		StringBuilder result = new StringBuilder();
//		result.append( "OrderVO " + this.getOrderNo() );
//		
//		if(this.getTimestampStartedOrder() instanceof LocalDateTime) {
//			result.append( " from " + this.getTimestampStartedOrder().format(formatter) );
//		}
//		if(this.timestampDeliverdOrder instanceof LocalDateTime) {
//			result.append( " with delivery at " + this.timestampDeliverdOrder.format(formatter));
//		}
//		if (this.getCustomer() != null) {
//			result.append("\nof customer:" + this.getCustomer().getFirstName() + " " + this.getCustomer().getLastName() + ", ID of customer: " + this.getCustomer().getId() + "\n");
//		}
		for (DishVO  dish: this.shoppingBasket) {
			if(dish instanceof DishVO) {
				result.append("\n" + dish.toString());
			}
	    } 
		result.append("\n");
		result.append("Preis:" + this.calculatePriceDishes());
		result.append("\n");
		result.append("\n");
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + index;
		result = prime * result + orderNo;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + Arrays.hashCode(shoppingBasket);
		result = prime * result + ((timestampDeliverdOrder == null) ? 0 : timestampDeliverdOrder.hashCode());
		result = prime * result + ((timestampStartedOrder == null) ? 0 : timestampStartedOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVO other = (OrderVO) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (index != other.index)
			return false;
		if (orderNo != other.orderNo)
			return false;
		if (!state.equals(other.state))
			return false;
		if (!Arrays.equals(shoppingBasket, other.shoppingBasket))
			return false;
		if (timestampDeliverdOrder == null) {
			if (other.timestampDeliverdOrder != null)
				return false;
		} else if (!timestampDeliverdOrder.equals(other.timestampDeliverdOrder))
			return false;
		if (timestampStartedOrder == null) {
			if (other.timestampStartedOrder != null)
				return false;
		} else if (!timestampStartedOrder.equals(other.timestampStartedOrder))
			return false;
		return true;
	}

	public int getOrderNo() {
		return orderNo;
	}
	
	public int getIndex() {
		return index;
	}
	
	public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}
	
	public void setTimestampStartedOrder(LocalDateTime timestampStartedOrder) {
		this.timestampStartedOrder = timestampStartedOrder;
	}
	
	public LocalDateTime getTimestampDeliverdOrder() {
		return timestampDeliverdOrder;
	}
	
	public void setTimestampDeliverdOrder(LocalDateTime timestampDeliverdOrder) {
		this.timestampDeliverdOrder = timestampDeliverdOrder;
	}
	
	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		if(this.customer != null && customer != null) {
			// entfernen der Order sollte ein anderer Kunde diese bereits besitzen. 
			this.customer.setOrder(null);
		}
		this.customer = customer;
		if(customer != null) {
			customer.setOrder(this);
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
