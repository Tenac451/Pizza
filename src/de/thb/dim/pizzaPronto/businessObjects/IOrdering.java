package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public interface IOrdering {
	
	public OrderVO startNewOrder(CustomerVO customer);
	
	public void addDish(DishVO dish) ;
	
	
	public void deleteDish(DishVO dish) ;
	
	
	public float calculateTotalPrice() ;
	
	public void confirmOrder() ;

}
