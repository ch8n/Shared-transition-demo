package dev.ch8n.animations.material.circularRevel

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import dev.ch8n.animations.R
import kotlinx.android.synthetic.main.activity_circular_revel.*

class CircularRevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_revel)
        setup()
    }

    private fun setup() {
        switch_reveal.isChecked = true
        switch_reveal.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) revealFab() else hideFab()
        }
    }

    private fun hideFab() {
        val circumX = fab_circular_reveal.width / 2
        val circumY = fab_circular_reveal.height / 2

        val initRad = Math.hypot(circumX.toDouble(), circumY.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(fab_circular_reveal, circumX, circumY, initRad, 0f)
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                fab_circular_reveal.visibility = View.GONE
            }
        })
        anim.start()
    }

    fun revealFab() {
        val circumX = fab_circular_reveal.width / 2
        val circumY = fab_circular_reveal.height / 2
        val finalRad = Math.hypot(circumX.toDouble(), circumY.toDouble()).toFloat()
        val anim = ViewAnimationUtils.createCircularReveal(fab_circular_reveal, circumX, circumY, 0f, finalRad)
        fab_circular_reveal.visibility = View.VISIBLE
        anim.start()
    }

}
