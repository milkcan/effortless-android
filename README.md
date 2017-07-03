# Effortless Android

Effortless Android is a curated collection of Kotlin extension functions to make Android development less painful. While some extension libraries are filled with rarely used niceties or bloat, Effortless Android has only the essentials in order to keep the footprint and method count of the library to a minimum.

## Prerequisites

Kotlin 1.1+ -- older versions should be compatible but have not been tested.

## Contributing

All contributions are welcome. If you have any ideas for extensions to add, feel free to open an issue or pull request.

## Install

Add the following repository to your project level build.gradle file:
```
maven {
   url 'https://dl.bintray.com/bachhuberdesign/maven/'
}
```

and the dependency to your module level build.gradle:
```
compile 'io.milkcan:effortless-android:1.0.1'
```

(OPTIONAL) RxJava 2 extensions:
```
compile 'io.milkcan:effortless-android-rx:1.0.1'

// Both RxJava 2 and RxAndroid are required to use Effortless Android Rx
compile 'io.reactivex.rxjava2:rxjava:2.1.0'
compile 'io.reactivex.rxjava2:rxandroid:2.0.1'
```

## License

This project is licensed under Apache 2.0 -- [see the full license here.](https://github.com/bachhuberdesign/effortless-android/blob/master/LICENSE)