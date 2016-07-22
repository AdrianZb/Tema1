package pizza;

/**
 * Created by azburatura on 7/22/2016.
 */
public class FactoryDemo {

    public static void main(String[] args){

        Pizza deluxePizza = PizzaFactory.getPizza(PizzaType.DeluxePizza);
        Pizza hamAndMushroomPizza = PizzaFactory.getPizza(PizzaType.HamAnMushroomPizza);
        Pizza prosciutoPizza = PizzaFactory.getPizza(PizzaType.ProsciutoPizza);

        System.out.println(deluxePizza);
        System.out.println(hamAndMushroomPizza);
        System.out.println(prosciutoPizza);

    }

}
