package dragger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
  StudentModule::class,
  StudentCommunicatorModule::class,
])
interface MainComponent {
  fun getStudentCommunicator(): StudentCommunicator
}
