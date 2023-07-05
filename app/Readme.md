_For animations: follow this link
https://stackoverflow.com/questions/18147840/slide-right-to-left-android-animations

Design using data binding approach:

Extend all activities to BaseActivity
Extend all ViewModel to BaseViewModel

Example code:
````
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
     override val layoutRes: Int
            get() = R.layout.activity_main
    
    override val viewModel: MainViewModel
        get() = ViewModelProvider(this,
            MainViewModelFactory(20))[MainViewModel::class.java]
    
    
    override fun initializeUI(
        viewModel: MainViewModel,
        binder: ActivityMainBinding,
        savedInstanceState: Bundle?
    ) {
        /* initialize all UI element from this point on */

    }
 }
````
