# android-widgets
Clear Fashion native android SDK for the widgets

## Installation

<details>
  <summary>
    <h4>
      Using Gradle
    </h4>
  </summary>

  **Step 1.** Add the JitPack repository to your build file

  Add it in your root build.gradle at the end of repositories:

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
    implementation 'com.github.Clothparency:android-widgets:0.2.3'
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
     <version>0.2.3</version>
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

  Add it in your build.sbt at the end of resolvers:

  ```
  resolvers += "jitpack" at "https://jitpack.io"
  ```

  **Step 2.** Add the dependency
  
  ```
  libraryDependencies += "com.github.Clothparency" % "android-widgets" % "0.2.3"	
  ```
</details>
<details>
  <summary>
    <h4>
      Using Leiningen
    </h4>
  </summary>
  
  **Step 1.** Add the JitPack repository to your build file
  
  Add it in your project.clj at the end of repositories:
  
  ```
  :repositories [["jitpack" "https://jitpack.io"]]
  ```
  
  **Step 2.** Add the dependency
  
  ```
  :dependencies [[com.github.Clothparency/android-widgets "0.2.3"]]	
  ```
</details>

## Implementation

This package exposes a composable function: `ClearFashionWidget`

If your application uses [Jetpack Compose](https://developer.android.com/jetpack/compose) you can simply add it inside any composable scopes as so:

```kotlin
// ...

import com.clearfashion.sdk.widgets.ClearFashionWidget
import com.clearfashion.sdk.widgets.type.ClearFashionWidgetLanguage

// ... some code

ClearFashionWidget(
  brandId = "The id of your brand as given by Clear Fashion",
  productIdentifier = "The identifier of your product as given by Clear Fashion",
  lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
)

// ... some code
```

### Using Views

In the activity in which you want to add the widget:

```kotlin
setContent { // In here, we can call composables!
  ClearFashionWidget(
    brandId = "The id of your brand as given by Clear Fashion",
    productIdentifier = "The identifier of your product as given by Clear Fashion",
    lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
  )
}
```

### Using Fragments

In the fragment XML file where you want to put the widget, add a compose view for the widget to live in:

```xml
<androidx.compose.ui.platform.ComposeView
        android:id="@+id/compose_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

And then in the onCreateView method, add the following:

```kotlin
binding.composeView.apply {

  // Dispose of the Composition when the view's LifecycleOwner is destroyed
  setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

  setContent() {
    ClearFashionWidget(
      brandId = "The id of your brand as given by Clear Fashion",
      productIdentifier = "The identifier of your product as given by Clear Fashion",
      lang = ClearFashionWidgetLanguage.EN // The widget also supports `ClearFashionWidgetLanguage.FR` which is the default value
    )
  }
}
```

For more informations on how to integrate a composable function in your code, please read: https://developer.android.com/jetpack/compose/interop/interop-apis
