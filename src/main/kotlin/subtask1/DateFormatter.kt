package subtask1

import java.util.*

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        //throw NotImplementedError("Not implemented")
        val dataConverter = DataConverter(day.toInt(), month.toInt() - 1, year.toInt())
        return dataConverter.getRepresentationOfDate()
    }
}

class DataConverter(private val day: Int, private val month: Int, private val year: Int) {
    private val calendar = Calendar.getInstance()
    private var vocabularyOfMonths: Map<Int, String>
    private var vocabularyOfDaysOfWeek: Map<Int, String>

    init {
        setCalendarDate(day, month, year)

        vocabularyOfMonths = mapOf (
            0 to "января",
            1 to "февраля",
            2 to "марта",
            3 to "апреля",
            4 to "мая",
            5 to "июня",
            6 to "июля",
            7 to "августа",
            8 to "сентября",
            9 to "октября",
            10 to "ноября",
            11 to "декабря"
        )

        vocabularyOfDaysOfWeek = mapOf(
            1 to "воскресенье",
            2 to "понедельник",
            3 to "вторник",
            4 to "среда",
            5 to "четверг",
            6 to "пятница",
            7 to "суббота"
        )
    }

    private fun setCalendarDate(day: Int, month: Int, year: Int) {
        calendar.set(year, month, day)
    }

    fun getRepresentationOfDate(): String {
        if (!checkForExistingDate())
            return "Такого дня не существует"
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return "$dayOfMonth ${vocabularyOfMonths[month]}, ${vocabularyOfDaysOfWeek[dayOfWeek]}"
    }

    private fun checkForExistingDate(): Boolean {
        return day == calendar.get(Calendar.DAY_OF_MONTH) &&
                month == calendar.get(Calendar.MONTH) &&
                year == calendar.get(Calendar.YEAR)
    }
}
