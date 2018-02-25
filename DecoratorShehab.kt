// Decorator this example using kotlin variable overriding
//EX1
interface BasePizaa1{
      var price:Int
      var ingredients:String
}

interface ToppingsDecorator1:BasePizaa1{
     var BP:BasePizaa1
}

class Margerta:BasePizaa1{
    override var price: Int = 30
        set(value) { require(value>0);field=value}
    override var ingredients: String="Margrita"
}

class ExtraMashroum1(override var BP: BasePizaa1 ):ToppingsDecorator1 {
    override var price: Int = 10 + BP.price
    override var ingredients: String = BP.ingredients+" - Mashroum"
}

class ExtraCheese1(override var BP: BasePizaa1 ):ToppingsDecorator1 {
    override var price: Int = 20  + BP.price
    override var ingredients: String = BP.ingredients+" - Cheese"
}
//-----------------------------
//EX2
abstract class BasePizaa2{
    protected var price:Int=0
   open fun GetPrice():Int{
       return  this.price
   }
}

abstract class ToppingsDecorator2(var BP:BasePizaa2):BasePizaa2()   {
    override fun GetPrice(): Int {
        return this.price+ BP.GetPrice()
    }
}

class Margerta2:BasePizaa2(){
  init {
      this.price=30
  }
}

class ExtraMashroum2(var BPc: BasePizaa2 ):ToppingsDecorator2(BPc) {
    init {
        this.price=10
    }
}

class ExtraCheese2(var BPc: BasePizaa2 ):ToppingsDecorator2(BPc) {
    init {
        this.price=20
    }
}


fun main(args: Array<String>) {
    //Ex1
    println("Ex1 one using kotlin data members overriding and interfaces")
    var mg1=Margerta()
    println("${mg1.ingredients} costs ${mg1.price}")
    var mg1_Cheese=ExtraCheese1(mg1)
    println("${mg1_Cheese.ingredients} costs ${mg1_Cheese.price}")
    var mg1_Cheese_Mashroum=ExtraMashroum1( mg1_Cheese)
    println("${mg1_Cheese_Mashroum.ingredients} costs ${mg1_Cheese_Mashroum.price}")

    //Ex2
    println("\nEx2 one using lap code ")
    var mg2=Margerta2()
    println("Margerita costs ${mg2.GetPrice()}")
    var mg2_Cheese=ExtraCheese2(mg2)
    println("Margerita + Cheese costs ${mg2_Cheese.GetPrice()}")
    var mg2_Cheese_Mashroum2=ExtraMashroum2( mg2_Cheese)
    println("Margerita + Cheese + Mashroum costs ${mg2_Cheese_Mashroum2.GetPrice()}")

}

