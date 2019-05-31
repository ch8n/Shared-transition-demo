package dev.ch8n.animations.material.sharedtransition

import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat
import dev.ch8n.animations.R
import kotlinx.android.synthetic.main.activity_main.*




/**
 * Styles.xml is also updated
 * **/
class MainActivity : BaseActivity() {

    override val contentLayout: Int
        get() = R.layout.activity_main

    override fun setup() {

        val animPair = Pair(image_demo as View?, ViewCompat.getTransitionName(image_demo))

        image_demo.setOnClickListener {

            startActivity(
                Intent(this@MainActivity, PreviewActivity::class.java),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@MainActivity, animPair
                ).toBundle()
            )

        }
    }

}
