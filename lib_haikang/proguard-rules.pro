# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn android.support.annotation.Keep
# 保留类内部使用@keep注解的成员变量
-keep @android.support.annotation.Keep class **{
@android.support.annotation.Keep <fields>; }
# natvie 方法不混淆 -keepclasseswithmembernames class * {
    native <methods>;
}
# 海康威视视频取流播放相关库的混淆配置
-keep class org.MediaPlayer.PlayM4.** {*;}
-keep class com.hikvision.netsdk.** {*;}
-keep class com.hikvision.audio.** {*;}
-keep class hik.common.isms.hpsclient.** {*;}
-keep class com.hikvision.open.hikvideoplayer.** {*;}