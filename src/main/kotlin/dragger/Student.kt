package dragger

class Student(private val name: String = "", private val age: Int = 0)  {
  override fun toString(): String {
    return "Student(name='$name', age=$age)"
  }
}