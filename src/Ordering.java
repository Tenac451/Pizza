import java.time.LocalDateTime;

public class Ordering implements IOrdering {
	private static MenuVO menu;
	private static int nextId = 0;
	private OrderVO currentOrder;
	private CustomerVO currentCustomer;
	private IService kitchen;
	private IService delivery;

	public Ordering() {
		menu = new MenuVO();
		currentOrder = null;
		currentCustomer = null;
		kitchen = new Kitchen();
		delivery = new Delivery();
	}

	public OrderVO startNewOrder(CustomerVO customer) {

		// sicherstellen das menu initialisiert ist
		if (menu == null) {
			menu = new MenuVO();
		}

		// ist customer null, wird kein Objekt OrderVO erstellt, es wird Null Zur�ck
		// gegeben
		if (customer == null) {
			return null;
		}

		// wird das Obejekt currentCustoemr Zugewiesen
		currentCustomer = customer;
		// wird die neue Bestellnummer berechnet
		if ((Ordering.getNextId() == 0) || ((LocalDateTime.now().getYear() * 100000 > Ordering.getNextId()))) {
			Ordering.nextId = LocalDateTime.now().getYear() * 100000;
		}

		// eine neue bestellerung erzeugt und currentOrder zugewiesen.
		currentOrder = new OrderVO(Ordering.getNextId(), "started", LocalDateTime.now(), customer);

		// die neue Bestellung beim Kunden gesetzt und zur�ck gegeben.
		currentCustomer.setOrder(currentOrder);

		return currentOrder;
	}

	public void addDish(DishVO dish) {
		if (currentOrder == null) {
			System.out.println("Error: There is no order");
		} else {
			if ("started".equals(currentOrder.getState())) {
				currentOrder.addDish(dish);
			} else {
				System.out.println("Your order is complete, you can not add any dishes. ");
			}
		}
	}

	@Override
	public void deleteDish(DishVO dish) {
		if (currentOrder == null) {
			System.out.println("Error: There is no order");
		} else {
			if ("started".equals(currentOrder.getState())) {
				currentOrder.deleteDish(dish);
			} else {
				System.out.println("Your order is complete, you can not delete any dishes. ");
			}
		}
	}

	@Override
	public float calculateTotalPrice() {
		float price = 0.0f;
		if (currentOrder == null) {
			System.out.println("Error: There is no order");
		} else {
			price = currentOrder.calculatePriceDishes();
		}
		return price;
	}

	@Override
	public void confirmOrder() {
		if (currentOrder == null) {
			System.out.println("Error: There is no order");
		} else {
			if ("started".equals(currentOrder.getState())) {
				currentOrder.setState("confirmed");
				this.startService();
			} else {
				System.out.println("Your order can not be confrmed. ");
			}
		}

	}

	public void startService() {
		if (currentOrder == null) {
			System.out.println(" Error: There is no order. ");
		} else {
			switch (currentOrder.getState()) {
			case "started":
				System.out.println(" Your order can not be processed. ");
				break;
			case "confirmed":
				System.out.println(kitchen.startService(currentOrder));
				break;
			case "ready":
				System.out.println(delivery.startService(currentOrder));
				break;
			case "deliverd":
				currentOrder.setTimestampDeliverdOrder(LocalDateTime.now());
				currentOrder.setState("finished");
				System.out.println("Order Complete: ");
				System.out.println(currentOrder);
				currentCustomer.setOrder(null);
				break;
			default:
				break;
			}
		}
	}

	public OrderVO getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(OrderVO currentOrder) {
		this.currentOrder = currentOrder;
	}

	public CustomerVO getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(CustomerVO currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public IService getKitchen() {
		return kitchen;
	}

	public void setKitchen(IService kitchen) {
		this.kitchen = kitchen;
	}

	public IService getDelivery() {
		return delivery;
	}

	public void setDelivery(IService delivery) {
		this.delivery = delivery;
	}

	public static MenuVO getMenu() {
		return menu;
	}

	public static int getNextId() {
		Ordering.nextId = Ordering.nextId + 1;
		return nextId;
	}

}
