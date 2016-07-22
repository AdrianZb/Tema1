package pizza;

/**
 * Created by azburatura on 7/22/2016.
 */
public class PizzaFactory {

    public static Pizza getPizza(PizzaType pizzaType) {
        switch (pizzaType) {
            case DeluxePizza:
                return new DeluxePizza();

            case HamAnMushroomPizza:
                return new HamAnMushroomPizza();

            case ProsciutoPizza:
                return new ProsciutoPizza();

            default:
                return null;
        }

    }

}
