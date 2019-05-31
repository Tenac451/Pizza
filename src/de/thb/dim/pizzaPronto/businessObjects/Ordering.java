package de.thb.dim.pizzaPronto.businessObjects;
import java.time.LocalDate;
import java.time.LocalDateTime;

import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

/**
 * @author schmidt
 *
 */
public class Ordering implements IOrdering {

	private static MenuVO menu;

	private OrderVO currentOrder;
	private CustomerVO currentCustomer;
	private IService kitchen;
	private IService delivery;

	private static int nextId = 0;

	public Ordering() {

		if (menu == null)
			menu = new MenuVO();

		currentOrder = null;
		currentCustomer = null;
		kitchen = new Kitchen();
		delivery = new Delivery();

	}

	@Override
	public OrderVO startNewOrder(CustomerVO customer) {
		if (menu == null)
			menu = new MenuVO();

		if (customer != null) {
			if (nextId == 0 || nextId / 100000 < LocalDate.now().getYear()) {
				nextId = (LocalDate.now().getYear() * 100000) + 1;
			} else
				nextId++;
			currentOrder = new OrderVO(nextId, StateOfOrderVO.STARTED , LocalDateTime.now(), customer);
			currentCustomer = customer;
			currentCustomer.setOrder(currentOrder);
		}
		return currentOrder;
	}

	@Override
	public void addDish(DishVO dish) {
		if (currentOrder == null) {
			System.out.println("Error: There is no order.");
		}
		if (currentOrder != null && currentOrder.getState().equals(StateOfOrderVO.STARTED))
			currentOrder.addDish(dish);
		if (currentOrder != null && !currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			System.out.println("Your order is complete, you can not add any dishes.");
		}
	}

	@Override
	public void deleteDish(DishVO dish) {
		if (currentOrder == null) {
			System.out.println("Error: There is no order.");
		}
		if (currentOrder != null && currentOrder.getState().equals(StateOfOrderVO.STARTED))
			currentOrder.deleteDish(dish);

		if (currentOrder != null && !currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			System.out.println("Your order is complete, you can not delete any dishes.");
		}
	}

	@Override
	public float calculateTotalPrice() {
		float price = 0f;
		if (currentOrder == null) {
			System.out.println("Error: There is no order.");
		}
		if (currentOrder != null)
			price = currentOrder.calculatePriceDishes();
		return price;
	}

	@Override
	public void confirmOrder() {
		if (currentOrder == null) {
			System.out.println("Error: There is no order.");
		}
		if (currentOrder != null && currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			currentOrder.setState(StateOfOrderVO.CONFIRMED);
			startService();
		} else {
			System.out.println("Your order can not be confirmed.");
		}

	}

	public void startService() {
		if (currentOrder == null) {
			System.out.println("Error: There is no order.");
		}

		if (currentOrder != null && currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			System.out.println("Your order can not be processed.");
		}

		if (currentOrder != null && currentOrder.getState().equals(StateOfOrderVO.CONFIRMED)) {
			String s = kitchen.startService(currentOrder);
			System.out.println(s);
		}

		if (currentOrder != null && currentOrder.getState().equals(StateOfOrderVO.READY)) {
			String s = delivery.startService(currentOrder);
			System.out.println(s);
		}

		if (currentOrder != null && currentOrder.getState().equals(StateOfOrderVO.DELIVERED)) {
			currentOrder.setTimestampDeliveredOrder(LocalDateTime.now());
			currentOrder.setState(StateOfOrderVO.FINISHED);
			System.out.println("\nOrder completed: " + currentOrder.toString());
			currentCustomer.setOrder(null);

		}

	}

	/**
	 * @return the currentOrder
	 */
	public OrderVO getCurrentOrder() {
		return currentOrder;
	}

	/**
	 * @param currentOrder the currentOrder to set
	 */
	public void setCurrentOrder(OrderVO currentOrder) {
		this.currentOrder = currentOrder;
	}

	/**
	 * @return the currentCustomer
	 */
	public CustomerVO getCurrentCustomer() {
		return currentCustomer;
	}

	/**
	 * @param currentCustomer the currentCustomer to set
	 */
	public void setCurrentCustomer(CustomerVO currentCusomer) {
		this.currentCustomer = currentCusomer;
	}

	/**
	 * @return the meno
	 */
	public static MenuVO getMenu() {
		return menu;
	}

	/**
	 * @return the kitchen
	 */
	public IService getKitchen() {
		return kitchen;
	}

	/**
	 * @param kitchen the kitchen to set
	 */
	public void setKitchen(IService kitchen) {
		this.kitchen = kitchen;
	}

	/**
	 * @return the delivery
	 */
	public IService getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(IService delivery) {
		this.delivery = delivery;
	}

	/**
	 * @return the nextId
	 */
	public static int getNextId() {
		return nextId;
	}

}
