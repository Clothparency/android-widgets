<br />
<p align="center">
  <img 
      style="margin: auto; width: 5%;"
      src="https://user-images.githubusercontent.com/2159699/215896047-e6eb3ca0-b2d1-40b3-8034-c26913033008.svg" 
      alt="Logo Clear Fashion">
  </img>
</p>
<br />

<h1 align="center">Clear Fashion widgets for Android</h1>

<br />

Display your Clear Fashion widgets on your native android app.

Check the latest release here:

https://github.com/Clothparency/android-widgets/releases/latest

## Installation

<details>
  <summary>
    <h4>
      Using Gradle
    </h4>
  </summary>

  **Step 1.** Add the JitPack repository to your build file

  Add it in your root `build.gradle` at the end of repositories:

  ```groovy
  allprojects {
    repositories {
      // ...
      maven { url 'https://jitpack.io' }
    }
  }
  ```

  **Step 2.** Add the dependency

  ```groovy
  dependencies {
    implementation 'com.github.Clothparency:android-widgets:0.2.4'
  }
  ```
</details>
<details>
  <summary>
    <h4>
      Using Maven
    </h4>
  </summary>

  **Step 1.** Add the JitPack repository to your build file

  ```xml
  <repositories>
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
    </repository>
  </repositories>
  ```

  **Step 2.** Add the dependency

  ```xml
  <dependency>
     <groupId>com.github.Clothparency</groupId>
     <artifactId>android-widgets</artifactId>
     <version>0.2.4</version>
  </dependency>
  ```
</details>
<details>
  <summary>
    <h4>
      Using SBT
    </h4>
  </summary>
  
  **Step 1.** Add the JitPack repository to your build file

  Add it in your `build.sbt` at the end of resolvers:

  ```
  resolvers += "jitpack" at "https://jitpack.io"
  ```

  **Step 2.** Add the dependency
  
  ```
  libraryDependencies += "com.github.Clothparency" % "android-widgets" % "0.2.4"	
  ```
</details>
<details>
  <summary>
    <h4>
      Using Leiningen
    </h4>
  </summary>
  
  **Step 1.** Add the JitPack repository to your build file
  
  Add it in your `project.clj` at the end of repositories:
  
  ```
  :repositories [["jitpack" "https://jitpack.io"]]
  ```
  
  **Step 2.** Add the dependency
  
  ```
  :dependencies [[com.github.Clothparency/android-widgets "0.2.4"]]	
  ```
</details>

## Implementation

This package exposes a composable function: `ClearFashionWidget`

If your application uses [Jetpack Compose](https://developer.android.com/jetpack/compose) you can simply add it inside any composable scopes as so:



```kotlin
// ...

import com.clearfashion.sdk.widgets.ClearFashionWidget
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage

// ...

ClearFashionWidget(
  brandId = "The id of your brand as given by Clear Fashion",
  productId = "The identifier of your product as given by Clear Fashion",
  lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
)
```

### Using Views

If your application is view based, you can add the widget in the activity where you want it to be displayed:

```kotlin
// ...

import com.clearfashion.sdk.widgets.ClearFashionWidget
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage

// ...

ClearFashionWidget(
  activity = this,
  brandId = "The id of your brand as given by Clear Fashion",
  productId = "The identifier of your product as given by Clear Fashion",
  lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
)
```

### Using Fragments

If your application is fragment based, in the fragment XML file where you want to put the widget, add a compose view for the widget to live in:

```xml
<androidx.compose.ui.platform.ComposeView
  android:id="@+id/cf_widget_compose_view"
  android:layout_width="match_parent"
  android:layout_height="wrap_content"/>
```

And then in the `onCreateView` method, add the following:

```kotlin
// ...

import com.clearfashion.sdk.widgets.ClearFashionWidget
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage

// ...

override fun onCreate(savedInstanceState: Bundle?) {

  // ...

  ClearFashionWidget(
    composeView = binding.cfWidgetComposeView,
    brandId = "The id of your brand as given by Clear Fashion",
    productId = "The identifier of your product as given by Clear Fashion",
    lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
  )

  // ...

}
```

For more informations on how to integrate a composable function in your code, please read: https://developer.android.com/jetpack/compose/interop/interop-apis



<br />
<br />
<p align="center">
  <img 
      style="margin: auto; width: 20%;"
      src="https://user-images.githubusercontent.com/2159699/215894277-8251062e-b339-4bf6-a958-42e792059ba3.svg" 
      alt="Logo Clear Fashion">
  </img>
</p>
