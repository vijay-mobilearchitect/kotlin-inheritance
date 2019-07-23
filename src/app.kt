import java.util.*

/*By default, classes in Kotlin are final. If you are familiar with Java, you know that a final class cannot be subclassed.
By using the open annotation on a class, compiler allows you to derive new classes from it.
Create Person Class and initialize with constructor
*/

open class Person(firstName: String, lastName: String, idNumber: Int) {

    // Init can be use as mentioned below
    private var firstName: String = firstName
    private var lastName: String = lastName
    private var idNumber: Int = idNumber

    //    Init can be use to initialize the as mentioned below

    //    init{
    //        this.firstName = firstName
    //        this.lastName = lastName
    //        this.idNumber = idNumber
    //    }


    // Print person data
     fun printPerson() {
        println(
            "Name: " + lastName + ", " + firstName
                    + "\nID: " + idNumber
        )
    }
}

class Student(firstName: String, lastName: String, idNumber: Int, scores: IntArray) :
    Person(firstName, lastName, idNumber) {

    private val testScore: IntArray

    private var average = 0

    init {
        this.testScore = scores
    }

    fun calculate(): Char {

        var total = 0
        for (score in testScore) {
            total += score
        }

         average = total / testScore.size


        if (average in 90..100) return 'O'
        if (average in 80..89) return 'E'
        if (average in 70..79) return 'A'
        if (average in 55..69) return 'P'
        if (average in 40..54) return 'D'
        return 'T'
    }
}

fun main() {
    val scan = Scanner(System.`in`)
    val firstName = scan.next()
    val lastName = scan.next()
    val id = scan.nextInt()
    val numScores = scan.nextInt()
    val testScores = IntArray(numScores)
    for (i in 0 until numScores) {
        testScores[i] = scan.nextInt()
    }
    scan.close()
    val s = Student(firstName, lastName, id, testScores)
    s.printPerson()
    println("Grade: " + s.calculate())
}