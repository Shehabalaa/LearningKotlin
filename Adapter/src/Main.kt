import com.sun.org.apache.xml.internal.serializer.ToTextSAXHandler
import java.math.BigInteger

fun main (args:Array<String>)
{
    var shape:Shape=RectangleImplementsShape()
    var x1:Int=10
    var y1:Int=20
    var x2:Int=30
    var y2:Int=60

    shape.draw(x1, y1, x2, y2)


}