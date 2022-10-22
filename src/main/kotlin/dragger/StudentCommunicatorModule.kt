package dragger

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface StudentCommunicatorModule {
  @Binds
  @Singleton
  fun provideProductCommunicator(communicator: StudentCommunicatorImpl): StudentCommunicator
}