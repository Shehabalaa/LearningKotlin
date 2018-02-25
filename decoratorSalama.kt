abstract class BasePizza
{
    protected var myPrice:Double=0.0
    public open fun getPrice(): Double?
    {
        return this.myPrice!!
    }
}

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


class Margherita() : BasePizza()
{
    init {
        this.myPrice=6.99
    }
}

class ExtraCheese
    :ToppingsDecorator
{
    constructor(PizzaToDecorate:BasePizza)
            :super(PizzaToDecorate)
    {
        this.myPrice=0.99
    }
}


fun main (args:Array<String>)
{

    var Pizza:Margherita=Margherita()
    println("Plain Margherita ${Pizza.getPrice()}")
    var morecheese:ExtraCheese=ExtraCheese(Pizza)
    var somemorecheese:ExtraCheese=(morecheese)
    println("Plain Margherita with double extra cheese ${somemorecheese.getPrice()}")


}