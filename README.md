# CrissCross
<p align="center">
<strong>Android</strong> kit for <strong>cross animations</strong>
</p>
<p align="center">
<img src="https://raw.github.com/cesarferreira/CrissCross/master/extras/minus_cross.gif?raw=true" width="300px" />
<img src="https://raw.github.com/cesarferreira/CrissCross/master/extras/minus_cross.gif?raw=true" width="300px" />
</p>

# Usage

In your XML:
```xml
<github.cesarferreira.crisscross.CrissCross
        xmlns:crisscross="http://schemas.android.com/apk/res-auto"
        android:layout_width="300dp"
        android:layout_height="300dp"
        crisscross:cc_bar_color="#FFFFFF"
        crisscross:cc_bar_height="50dp"
        crisscross:cc_bar_width="250dp"
        crisscross:cc_circle_color="#FF0000" />
```


### Animate to coordinates

usage:

> `crissCross.animate(float angleForBarA, float angleForBarB)`

### Examples

#### Cross animation
TODO insert gif

```java
crissCross.animate(45, -45)
```


#### Plus animation
TODO insert gif

```java
crissCross.animate(90, 180)
```

Etc.

### Transform to Position
If you want to move to an angle without the animations:
> `crissCross.transform(angleOfA, angleOfB)`

## Install

Add the dependency to your `build.gradle`
```groovy
dependencies {
    compile 'com.cesarferreira.crisscross:crisscross:0.1.0'
}
```

## Contributing

1. Fork it ( https://github.com/cesarferreira/crisscross/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request
