package com.example.exework

fun main(){
    val me = Person_("Олексій",20)

    val mom = me.setMother("Лариса",51)
    val dad = me.setFather("Андрій",52)
    val bro = me.setBrother("Михайло",31)
    val sis : Person_ = me.setSister("Ольга", 29)
    bro.setMother(mom)
    bro.setFather(dad)
    sis.setMother(mom)
    sis.setFather(dad)

    val momMother = mom.setMother("Любов",76)
    val momFather = mom.setFather("Михайло",80)

    val dadFather= dad.setFather("Леонід",80)
    val dadMother = dad.setMother("Алла",80)

    println(getMe(me).toString())
    println(getMe(mom).toString())
    println(getMe(dad).toString())
    println(getMe(bro).toString())
    println(getMe(momMother).toString())
    println(getMe(dadMother).toString())
    println(getMe(sis).toString())


}

fun getMe(obj : Person_) : Person_{
    return obj
}

class Person_(val name : String,
              val age : Int){

    var mother : Person_? = null
    var father: Person_? = null
    var brother: Person_? = null
    var sister: Person_? = null
    var sistersAndbrothers: ArrayList<Person_> = ArrayList<Person_>()

    fun isAdulthood() : Boolean{
        return age >= 18
    }

    fun setMother(name : String, age : Int) : Person_ {
        mother = Person_(name, age)
        return mother as Person_
    }

    fun setMother(mother_: Person_) : Person_ {
        mother = mother_
        return mother as Person_
    }

    fun hasMom():Boolean{
        return mother!=null
    }

    fun setFather(name : String, age : Int) : Person_{
        father = Person_(name, age)
        return father as Person_
    }

    fun setFather(father_ : Person_) : Person_{
        father = father_
        return mother as Person_
    }

    fun hasDad(): Boolean{
        return father!=null
    }

    fun setBrother(name : String, age : Int) : Person_{
        brother = Person_(name, age)
        sistersAndbrothers.add(brother!!)
        return brother as Person_
    }

    fun hasBro() : Boolean{
        return brother!=null
    }

    fun setSister(name : String, age : Int) : Person_{
        sister = Person_(name, age)
        sistersAndbrothers.add(sister!!)
        return sister as Person_
    }

    fun hasSis() : Boolean{
        return sister!= null
    }

    override fun toString(): String {
        val info: String = "Ім'я: $name \nвік: $age \nмама: ${mother?.name} \nбатько: ${father?.name} \nкількість родичів: ${numOfRelatives()} \n"
        return info
    }

    fun numOfRelatives(): Int {
        var counter: Int = 0
        if (hasMom() == true) {
            counter += 1
            counter += this.mother!!.numOfRelatives()
        }
        if (hasDad() == true) {
            counter += 1
            counter += this.father!!.numOfRelatives()
        }
        if (hasBro() == true){
            counter +1
        }
        if(hasSis() == true){
            counter +1
        }
        return counter
    }
}