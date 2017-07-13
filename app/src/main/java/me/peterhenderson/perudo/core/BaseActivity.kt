package me.peterhenderson.perudo.core

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentViewFromAnnotation(this)
    }

}

@Target(AnnotationTarget.CLASS)
annotation class ContentView(@LayoutRes val value: Int)

private fun setContentViewFromAnnotation(baseActivity: BaseActivity) {
    (baseActivity::class.annotations.find { it.annotationClass == ContentView::class } as ContentView?)
            ?.let { baseActivity.setContentView(it.value) }
}
