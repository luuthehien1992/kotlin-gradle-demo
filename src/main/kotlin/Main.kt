import dragger.DaggerMainComponent
import mapstruct.ObjectMapper
import mapstruct.Student
import mapstruct.StudentSchool

fun main() {
  val component = DaggerMainComponent.builder().build()
  val communicator = component.getStudentCommunicator()

  println(communicator.getStudent())

  val mapper = ObjectMapper.INSTANCE
  val studentSchool = StudentSchool("KHTN")
  val student = Student("Luu The Hien", 30, studentSchool)
  val teacher = mapper.convertToTeacherAdv(student)

  println(teacher)
}