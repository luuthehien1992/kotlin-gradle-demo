package mapstruct

import org.mapstruct.*
import org.mapstruct.factory.Mappers

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ObjectMapper {
  companion object {
    @JvmStatic
    val INSTANCE: ObjectMapper = Mappers.getMapper(ObjectMapper::class.java)

    @JvmStatic
    @Named("brithYear")
    fun calculateBrithYear(age: Int): Int {
      return 2022 - age;
    }

    @JvmStatic
    @Named("teacherSchool")
    fun convertToTeacherSchool(school: StudentSchool): TeacherSchool {
      return TeacherSchool("AAAAA")
    }
  }

  fun convertToTeacher(student: Student): Teacher

  //  @Mappings(
  @Mapping(source = "name", target = "fullName")
  @Mapping(source = "age", target = "brithYear", qualifiedByName = ["brithYear"])
  @Mapping(source = "school", target = "school", qualifiedByName = ["teacherSchool"])
//  )
  fun convertToTeacherAdv(student: Student): Teacher


}