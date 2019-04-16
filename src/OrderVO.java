import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderVO {
	
	protected int orderNo;
	
	private static int nextOrderNo = 0;
	private static final int MAX_DISHES = 10;
	
	protected LocalDateTime timestampStartedOrder;
	protected LocalDateTime timestampDeliverdOrder;
	protected CustomerVO customer; // darf nach der initialisierung nicht mehr null sein. #TODO 
	protected PizzaVO[] shoppingBasket; 
	int index;
	
	public OrderVO() {
		this(LocalDateTime.now(), null);
	}
	
	public OrderVO(LocalDateTime order,CustomerVO customer) {
		this.timestampStartedOrder = order;
		this.customer = customer;
		
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
		this.shoppingBasket[this.index] = dish;
		this.index++;
	}
	
	public void deleteDish() {
		if(this.index > 0) {
			this.index--;
			this.shoppingBasket[this.index] = null;
		}
	}
	public PizzaVO getDish(int index) {
		return this.shoppingBasket[index];
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
				result.append(dish.toString() + "\n");
			}
	    } 
		return result.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNo;
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
		if (orderNo != other.orderNo)
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
		this.customer = customer;
	}
	
	public static int getNextOrderNo() {
		return nextOrderNo;
	}
	
}
