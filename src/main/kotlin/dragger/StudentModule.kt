package dragger

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StudentModule {
  @Provides
  @Singleton
  fun provide(): Student {
    return Student("Nguyen Van A", 20)
  }
}