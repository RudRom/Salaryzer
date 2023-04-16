package com.example.salaryzer


class DataBase (data: String) {

    class Salary (salaryInfo: String, types: String) {
        val date: Pair<Int, Int>

        val salary: ArrayList<Pair<Float, String>> = ArrayList()


        init{
            date = Pair(salaryInfo.substring(0, 2).toInt(), salaryInfo.substring(3, 7).toInt())
            val salaryDigits = salaryInfo.substring(8).split(" ")
            val salaryTypes = types.substring(11).split(" ")
            for(i in 0 until salaryDigits.size){
                salary.add(Pair(salaryDigits[i].toFloat(),salaryTypes[i]))
            }
        }

    }
    private val salaryList: ArrayList<Salary> = ArrayList()
        get() = field

    init{
        val dataLines = data.lines()
        for (i in 1..dataLines.size-1){
            salaryList.add(Salary(dataLines[i], dataLines[0]))
        }
    }

}