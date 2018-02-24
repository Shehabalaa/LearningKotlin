import kotlin.math.abs
import kotlin.math.min

class RectangleImplementsShape():Shape
{
    //Adapter
    private var Adaptee:LegacyRectangle=LegacyRectangle()
    public override fun draw(x1:Int,y1:Int,x2:Int,y2:Int)
    {
        Adaptee.draw(min(x1,x2),min(y1,y2), abs(x2-x1),abs(y2-y1))
    }
}