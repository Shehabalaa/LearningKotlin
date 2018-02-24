class ExtraCheese
    :ToppingsDecorator
{
    constructor(PizzaToDecorate:BasePizza)
            :super(PizzaToDecorate)
    {
        this.myPrice=0.99
    }
}