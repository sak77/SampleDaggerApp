This is the first in a series of apps which looks at DI using Dagger.

Here i look at basic principles of Dagger like how one can use 
@Inject to include a class instance to the Dagger graph. 

For classes which cannot be instantiated directly via @Inject, 
use @Module and @Component classes. 

@Provides and @Binds annotations used to define how to provide 
class and interface instance from a module. 

@Binds @Into @Map/@Set annotations can be used to create a Map/Set
of bindings. Known as Multi-binding.

Application level components and use of @Singleton to have only 
one instance of the class during the app's lifetime.

Custom scope to provide instance of app within a lifecycle of an
Activity or Fragment. 

The next project is called DaggerAndroidSample.
