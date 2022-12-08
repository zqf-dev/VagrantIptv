package com.zqf.vagrantiptv.ui.launch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zqf.vagrantiptv.R
import com.zqf.vagrantiptv.databinding.LaunchActivityBinding

public class LauncherActivity : AppCompatActivity() {

    lateinit var launchActBinding: LaunchActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchActBinding = LaunchActivityBinding.inflate(layoutInflater)
        setContentView(launchActBinding.root)
    }
}