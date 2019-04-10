import java.time.LocalDateTime;

public class OrderVO {
	
	protected int orderNo;
	
	private static int nextOrderNo = 0;
	
	protected LocalDateTime timestampStartedOrder;
	protected LocalDateTime timestampDeliverdOrder;
	
	
	
	public OrderVO() {
		this.orderNo = OrderVO.getNextOrderNo();
		this.timestampStartedOrder = LocalDateTime.now();
		OrderVO.nextOrderNo = OrderVO.nextOrderNo + 1;
	}
	
	public String toString() {
		return "ID:" + this.getOrderNo() + " Startdate: " + this.getTimestampStartedOrder() + " Deliverd: " + this.timestampDeliverdOrder;
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
	public static int getNextOrderNo() {
		return nextOrderNo;
	}
	
}
