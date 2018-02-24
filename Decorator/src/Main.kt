import com.sun.org.apache.xml.internal.serializer.ToTextSAXHandler
import java.math.BigInteger

fun main (args:Array<String>)
{

    var Pizza:Margherita=Margherita()
    println("Plain Margherita ${Pizza.getPrice()}")
    var morecheese:ExtraCheese=ExtraCheese(Pizza)
    var somemorecheese:ExtraCheese=(morecheese)
    println("Plain Margherita with double extra cheese ${somemorecheese.getPrice()}")


}