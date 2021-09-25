package com.training.liskov;

public interface CoffeeMachine {
	
	CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException;
}