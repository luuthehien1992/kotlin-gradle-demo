package dragger

import javax.inject.Inject

interface StudentCommunicator {
  fun getStudent(): Student
}

class StudentCommunicatorImpl @Inject internal constructor(
  private val student: Student
) : StudentCommunicator {

  override fun getStudent(): Student {
    return student
  }

}