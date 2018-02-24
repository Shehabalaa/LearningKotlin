import kotlin.math.abs

//Ex1 Example in lap
class LegacyRectange(){
    fun draw(x:Int,y:Int,w:Int,h:Int) {
        println("Rectangle at x = $x , y = $y with width = $w and height = $h")
    }
}



interface Shape{
    fun draw(x1:Int,y1:Int,x2:Int,y2:Int)
}

class Rectangle():Shape{
    private val LgRec=LegacyRectange()
    override fun draw(x1:Int,y1:Int,x2:Int,y2:Int){
        LgRec.draw(minOf(x1,x2),minOf(y1,y2),abs(x2-x1), abs(y2-y1))
    }
}
//ex1 done
////------------------------\\\
//ex2 copied form website
////////////////////////////////
//EX2
interface Temperature {
    var temperature: Double
}

class CelsiusTemperature(override var temperature: Double) : Temperature

class FahrenheitTemperature(var celsiusTemperature: CelsiusTemperature) : Temperature {

    override var temperature: Double
        get() = convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        set(temperatureInF) {
            celsiusTemperature.temperature = convertFahrenheitToCelsius(temperatureInF)
        }

    private fun convertFahrenheitToCelsius(f: Double): Double = (f - 32) * 5 / 9

    private fun convertCelsiusToFahrenheit(c: Double): Double = (c * 9 / 5) + 32
}

fun main(args: Array<String>) {
    //ex1
    println("Example1 Test")
    val ShapesArray = Rectangle()
    ShapesArray.draw(2, 3, 4, 5)

    //ex2
    println("Example2 Test")
    val celsiusTemperature = CelsiusTemperature(0.0)
    val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

    celsiusTemperature.temperature = 36.6
    println("${celsiusTemperature.temperature} C -> ${fahrenheitTemperature.temperature} F")

    fahrenheitTemperature.temperature = 100.0
    println("${fahrenheitTemperature.temperature} F -> ${celsiusTemperature.temperature} C")
}

