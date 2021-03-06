package dev.ch8n.animations.material.sharedtransition

import android.os.Bundle
import android.transition.Fade
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dev.ch8n.animations.R

abstract class BaseActivity : AppCompatActivity() {

    abstract val contentLayout:Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentLayout)
        //fix for statusbar flashing file transition
        fixShareTransition()
        setup()

    }

    private fun fixShareTransition() {
        with(requireNotNull(window)) {
            val fade = Fade().apply {
                excludeTarget(this@with.decorView.findViewById<View>(R.id.action_bar_container), true)
                excludeTarget(android.R.id.statusBarBackground, true)
                excludeTarget(android.R.id.navigationBarBackground, true)
            }
            enterTransition = fade
            exitTransition = fade
        }
    }

    abstract fun setup()
}