#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_designpattern_hjq_hbg_www_com_designpattern_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
