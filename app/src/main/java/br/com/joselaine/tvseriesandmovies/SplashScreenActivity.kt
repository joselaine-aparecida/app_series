package br.com.joselaine.tvseriesandmovies

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.joselaine.tvseriesandmovies.databinding.ActivitySplashScreenBinding
import br.com.joselaine.tvseriesandmovies.databinding.HomeFragmentBinding
import br.com.joselaine.tvseriesandmovies.ui.fragments.HomeFragment
import kotlinx.coroutines.delay

class SplashScreenActivity: AppCompatActivity() {

    private val binding : ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        }, 1500L)
    }
}