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
	private static int nextOrderNo = 0;
	
	private int orderNo;
	private int index;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliverdOrder;
	private CustomerVO customer;
	private PizzaVO[] shoppingBasket; 
	
	
	public OrderVO() {
		this(LocalDateTime.now(), null);
	}
	
	public OrderVO(LocalDateTime order,CustomerVO customer) {
		this.timestampStartedOrder = order;
		this.customer = customer;
		if(customer != null) {
			customer.setOrder(this);
		}
		
		this.shoppingBasket = new PizzaVO[OrderVO.MAX_DISHES];
		this.index = 0;
		
		if((OrderVO.getNextOrderNo() == 0) || 
		  ((LocalDateTime.now().getDayOfYear()) == 1))
		{
			OrderVO.nextOrderNo = LocalDateTime.now().getYear() * 100000;
		}
		
		OrderVO.nextOrderNo = OrderVO.nextOrderNo + 1;
		this.orderNo = OrderVO.getNextOrderNo();
		
	}
	
	public void addDish(PizzaVO dish) {
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
	public PizzaVO getDish(int index) {
		if(index < OrderVO.MAX_DISHES) {
			return this.shoppingBasket[index];
		}
		return null;
	}
	
	public int getNumerOfDishes() {
		return this.index;
	}
	
	public String toString() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy hh:mm");
		StringBuilder result = new StringBuilder();
		result.append( "OrderVO " + this.getOrderNo() );
		
		if(this.getTimestampStartedOrder() instanceof LocalDateTime) {
			result.append( " from " + this.getTimestampStartedOrder().format(formatter) );
		}
		if(this.timestampDeliverdOrder instanceof LocalDateTime) {
			result.append( " with delivery at " + this.timestampDeliverdOrder.format(formatter));
		}
		if (this.getCustomer() != null) {
			result.append("\nof customer:" + this.getCustomer().getFirstName() + " " + this.getCustomer().getLastName() + ", ID of customer: " + this.getCustomer().getId() + "\n");
		}
		for (PizzaVO  dish: this.shoppingBasket) {
			if(dish instanceof PizzaVO) {
				result.append("\n" + dish.toString());
			}
	    } 
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
	
	public static int getNextOrderNo() {
		return nextOrderNo;
	}
	
}
