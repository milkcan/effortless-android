# Effortless Android

Effortless Android is a curated collection of Kotlin extension functions to make Android development less painful. Currently, the project is split into three modules that contain useful extensions for the following: Android Framework, Kotlin Standard Library, and RxJava 2.

## Prerequisites

Kotlin 1.1+ -- older versions should be compatible but have not been tested.

## Contributing

All contributions are welcome. If you have any ideas for extensions to add, feel free to open an issue or pull request.

## Install

Add JCenter to your project level build.gradle file (if you are not using it already):
```
repositories {
    jcenter()
}
```

and the dependencies you want to your module level build.gradle:

Android Framework Extensions:
```
compile 'io.milkcan:effortless-android:1.0.2'
```

Kotlin Standard Library Extensions:
```
compile 'io.milkcan:effortless-android-stdlib:1.0.2'
```

RxJava 2 extensions:
```
compile 'io.milkcan:effortless-android-rx:1.0.2'
 
// NOTE: RxJava 2 and RxAndroid are required to use Effortless Android Rx
compile 'io.reactivex.rxjava2:rxjava:2.1.0'
compile 'io.reactivex.rxjava2:rxandroid:2.0.1'
```

## License

This project is licensed under Apache 2.0 -- [see the full license here.](https://github.com/bachhuberdesign/effortless-android/blob/master/LICENSE)
