package de.thb.dim.pizzaPronto.businessObjects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
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
			currentOrder = new OrderVO(nextId, StateOfOrderVO.STARTED, LocalDateTime.now(), customer);
			currentCustomer = customer;
			currentCustomer.setOrder(currentOrder);
		} else {
			throw new NullPointerException(" Customer must not be null");
		}
		return currentOrder;
	}

	@Override
	public void addDish(DishVO dish) throws NoOrderException, IllegalStateException {
		if (currentOrder == null) {
			throw new NoOrderException(" There is no order.");
		}
		if (currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			currentOrder.addDish(dish);
		} else {
			throw new IllegalStateException("Your order is complete, you can not add any dishes.");
		}
	}

	@Override
	public void deleteDish(DishVO dish) throws NoOrderException {
		Objects.requireNonNull(dish, "Error: There is no order.");
		if (currentOrder == null) {
			throw new NoOrderException(" There is no order.");
		}
		if (currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			currentOrder.deleteDish(dish);
		} else {
			throw new IllegalStateException("Your order is complete, you can not add any dishes.");
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
	public void confirmOrder() throws NoCustomerException, NoOrderException {
		if (currentOrder == null) {
			throw new NoOrderException("There is no order.");
		}
		if (currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			currentOrder.setState(StateOfOrderVO.CONFIRMED);
			try {
				startService();
			} catch (Exception e) {
				System.err.println("Internal error by processing an order: ");
				System.err.println(e.getMessage());
			}
			
		} else {
			throw new IllegalStateException("Your order can not be confirmed.");
		}

	}

	public void startService() throws NoOrderException, NoCustomerException, IllegalStateException {
		Objects.requireNonNull(currentOrder, " There is no order.");

		if (currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
			throw new IllegalStateException("Your order can not be processed.");
		}

		if (currentOrder.getState().equals(StateOfOrderVO.CONFIRMED)) {
			String s = kitchen.startService(currentOrder);
			System.out.println(s);
		}

		if (currentOrder.getState().equals(StateOfOrderVO.READY)) {
			String s = delivery.startService(currentOrder);
			System.out.println(s);
		}

		if (currentOrder.getState().equals(StateOfOrderVO.DELIVERED)) {
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
	public void setCurrentOrder(OrderVO currentOrder) throws NullPointerException {
		Objects.requireNonNull(currentOrder, "currentOrder must not be null");
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
	 * @throws NullPointerException
	 */
	public void setCurrentCustomer(CustomerVO currentCusomer) throws NullPointerException {
		Objects.requireNonNull(currentCusomer, "currentCusomer must not be null");
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
	public void setKitchen(IService kitchen) throws NullPointerException {
		Objects.requireNonNull(kitchen, "kitchen must not be null");
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
	public void setDelivery(IService delivery) throws NullPointerException {
		Objects.requireNonNull(delivery, "delivery must not be null");
		this.delivery = delivery;
	}

	/**
	 * @return the nextId
	 */
	public static int getNextId() {
		return nextId;
	}

	@Override
	public List<DishVO> sortShoppingBasket() throws NoOrderException {
		if (this.currentOrder == null) {
			throw new NoOrderException("There is no order.");
		}
		Collections.sort(this.currentOrder.getShoppingBasket());
		return this.currentOrder.getShoppingBasket();
	}

	@Override
	public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException {
		if (this.currentOrder == null) {
			throw new NoOrderException("There is no order.");
		}
		Comparator<DishVO> c = new Comparator<DishVO>() {
			public int compare(DishVO o1, DishVO o2) {
				Integer a = o1.getNumberOfDish();
				Integer b = o2.getNumberOfDish();
				return a.compareTo(b);
			}
		};
		Collections.sort(this.currentOrder.getShoppingBasket(), c);
		return this.currentOrder.getShoppingBasket();
	}

	@Override
	public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException {
		if (this.currentOrder == null) {
			throw new NoOrderException("There is no order.");
		}
		Collections.sort(this.currentOrder.getShoppingBasket(), Comparator.comparing(e -> e.getPrice()));
		return this.currentOrder.getShoppingBasket();
	}

}
