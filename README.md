# utils
This library provides the basic utility in day to day android application development.
Some examples are ....

1.DateTimeUtils

2.MiniAnimationUtils

3.MiniDialogUtils

4.FullScreenBottomSheetDialogFragment

5.MiniColorUtils

6.MiniNetworkingUtils

7.MiniValidationUtils ... etc

How to Add in you android Project ?

Step 1. Add the JitPack repository to your build file



Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Note : Do not add in buildcripts repo

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.minielectron:utils:1.0.1'
	}
