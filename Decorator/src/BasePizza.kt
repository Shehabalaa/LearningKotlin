abstract class BasePizza
{
    protected var myPrice:Double=0.0
    public open fun getPrice(): Double?
    {
        return this.myPrice!!
    }
}