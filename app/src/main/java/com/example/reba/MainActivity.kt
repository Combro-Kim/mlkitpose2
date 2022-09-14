package com.example.reba

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.reba.bodycheck.BodyCheckFragment
import com.example.reba.home.HomeFragment
import com.example.reba.mypage.MyPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.pose.Pose
import com.google.mlkit.vision.pose.PoseDetection
import com.google.mlkit.vision.pose.PoseLandmark
import com.google.mlkit.vision.pose.accurate.AccuratePoseDetectorOptions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.math.atan2

//여기까지란다




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val homeFragment = HomeFragment()
        val bodyCheckFragment = BodyCheckFragment()
        val myPageFragment = MyPageFragment()
        
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        
        //replaceFragmnet(homeFragment)
        
        bottomNavigationView.setOnItemSelectedListener { 
            when (it.itemId){
                R.id.home -> replaceFragmnet(homeFragment)
                R.id.bodycheck -> replaceFragmnet(bodyCheckFragment)
                R.id.myPage -> replaceFragmnet(myPageFragment)
            }
            true
        }


    }

    private fun replaceFragmnet(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .apply { 
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }










}