# android-test-2.0

## Exercise I - Menu Code Kata

- I created Menu model based on `Map`. The `Map` stores pairs of `Recipe` and a flag indicating if the recipe is selected.
- I assumed that a menu should not have duplicate recipes so it accepts `Set<Recipe>`
- To ensure all the functionalities, I decided to write unit tests instead of printing outputs on the console. Please find `MenuTest` ad try running it.

## Exercise II -  Recipes List View 

- Overall architecture is MVVM + Clean Architecture (only separate layers into packages since it would take time to separate them into modules) 
- Use many of the [Android Jetpack](https://developer.android.com/jetpack)
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding): Declaratively bind observable data to UI elements
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): Notify views when underlying datasource changes
  - [Navigation](https://developer.android.com/guide/navigation/): Handle everything needed for in-app navigation
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): Manage UI-related data in a lifecycle-conscious way
- Use [Koin](https://github.com/InsertKoinIO/koin) for dependency injection
- Use [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) for managing background threads with simplified code and reducing needs for callbacks
- Use [Coil](https://github.com/coil-kt/coil) for image loading
- Use [ConcatAdapter](https://developer.android.com/reference/androidx/recyclerview/widget/ConcatAdapter) to support multiple item types with a single RecyclerView
