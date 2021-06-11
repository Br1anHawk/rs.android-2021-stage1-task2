package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        //throw NotImplementedError("Not implemented")
        val chappy = Robot(blockA, blockB)
        chappy.invoke()
        return chappy.getBlockC()
    }
}

class Robot(private val blockA: Array<Any>, blockB: KClass<*>) {
    //private var blockC: Any = blockB.java.getDeclaredConstructor().newInstance()
    //private var blockC: Any = blockB.constructors.first().call(0)

    private var blockC: Any
    init {
        blockC = when (blockB) {
            Int::class ->
//                with(blockB.constructors.first()) {
//                    isAccessible = true
//                    call()
//                }
                0
            String::class -> //blockB.constructors.first().call()
                ""
            LocalDate::class ->
//                with(blockB.constructors.first()) {
//                    isAccessible = true
//                    call(0, 0, 0)
//                }
                LocalDate.now()
            else -> Any()
        }
    }


//    private var blockC: Any
//    init {
//        val constructor = blockB.java.getDeclaredConstructor()
//        constructor.isAccessible = true
//        blockC = constructor.newInstance()
//    }

    fun getBlockC(): Any {
        return when (blockC) {
            is Int, String -> blockC
            is LocalDate -> (blockC as LocalDate).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            else -> blockC
        }
    }

    fun invoke() {
        var isInitLocalDateVariable = false
        blockA.forEach {
            when (it) {
                is Int -> if (blockC is Int) blockC = (blockC as Int).plus(it)
                is String -> if (blockC is String) blockC = (blockC as String).plus(it)
                is LocalDate -> {
                    if (blockC is LocalDate) {
                        if (!isInitLocalDateVariable) {
                            blockC = it
                            isInitLocalDateVariable = true
                            return@forEach
                        }
                        if ((blockC as LocalDate) < it) {
                            blockC = it
                        }
                    }
                }
            }
        }
    }
}
