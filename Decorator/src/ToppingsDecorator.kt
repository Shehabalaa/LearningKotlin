abstract class ToppingsDecorator():BasePizza() {
    private var Pizza:BasePizza?=null


    constructor(PizzaToDecorate:BasePizza) : this() {
        this.Pizza=PizzaToDecorate
    }

    public override fun getPrice(): Double
    {
        return (this!!.Pizza!!.getPrice()!! +this!!.myPrice)
    }
}