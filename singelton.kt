// this singleton1 is safe as it uses more code to avoid calling getinstance in singelto2 by two threads in same time
//that may cause creating two instances
object singelton1{
    // note that object cannot have constructor so can't use init to validate
    var mess:String = ""
        set(value) {
            /*
            validation can be added here using require that throw exception or using if statement leaving string empty
            if condition violated
            */
            require(!value.matches(Regex(".*\\d.*"))){ "Name canot contain numbers"}
            field =value
        }

}
class singelton2 private constructor(){
    var mess:String = ""
        set(value) {
            /*
            validation can be added here using require that throw exception or using if statement leaving string empty
            if condition violated
            */
            require(!value.matches(Regex(".*\\d.*"))){ "Name canot contain numbers"}
            field =value
        }
    companion object {
        private var sin:singelton2? = null
        fun getInstance():singelton2 {
            if(sin==null){
                sin=singelton2()
                return sin as singelton2
            }
            else{
                return sin as singelton2
            }

        }
    }
}

fun main(args: Array<String>) {
    val s1=singelton1
    s1.mess="hey"
    //val s2=singelton1 --> ERROR
    println(s1.mess)

    //val s2=singelton2() --> ERROR can't created as constructor is private
    val s2=singelton2.getInstance()
    s2.mess="HELLO"
    println(s2.mess)

    val s3=singelton2.getInstance()
    println(s3.mess) // mess is same as s2 as they are same object

}

