package com.example.protalktime

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.protalktime.databinding.ActivityMainBinding
import com.example.protalktime.presentation.common.BaseActivity
import com.example.protalktime.presentation.common.WindowUtil.setNavigationBarColor
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setNavigationBarColor(R.color.white)
//        initFirebase()
    }
//    private fun initFirebase() {
//
//
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                Log.w("alarm", "FCM 토큰 얻기에 실패하였습니다.", task.exception)
//                return@OnCompleteListener
//            }
//            // token log 남기기
//            Log.d("TAG", "token: ${task.result?:"task.result is null"}")
//            if(task.result != null){
//                uploadToken(task.result!!)
//
//                val token = task.result
//                val tokenData = TokenData(token)
//
//                notificationInterface?.setAlarmTokenResponse(tokenData)?.enqueue(object :
//                    Callback<NotificationResponse> {
//                    override fun onResponse(
//                        call: Call<NotificationResponse>,
//                        response: Response<NotificationResponse>
//                    ) {
//                        if (response.code() == 201){
//                            Log.d(TAG, "onResponse: Fcm token setting complete")
//                        }
//                    }
//
//                    override fun onFailure(call: Call<NotificationResponse>, t: Throwable) {
//                        TODO("Not yet implemented")
//                    }
//                })
//            }
//        })
//
//        createNotificationChannel(channel_id, "notice")
//    }
//
//
//    private fun createNotificationChannel(id: String, name: String) {
//        val importance = NotificationManager.IMPORTANCE_HIGH
//        val channel = NotificationChannel(id, name, importance)
//
//        val notificationManager: NotificationManager
//                = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        notificationManager.createNotificationChannel(channel)
//    }
//
//    companion object{
//        // Notification Channel ID
//        const val channel_id = "notification_channel"
//        fun uploadToken(token:String){
//            // 새로운 토큰 수신 시 서버로 전송
//            val data = TokenData(token)
//            val storeService = RetrofitClient.getClient()?.create(NotificationInterface::class.java)
//            storeService?.setAlarmTokenResponse(data)?.enqueue(object : Callback<NotificationResponse> {
//                override fun onResponse(call: Call<NotificationResponse>, response: Response<NotificationResponse>) {
//                    if(response.isSuccessful){
//                        val res = response.body()
//                        Log.d(TAG, "onResponse: $res")
//                    } else {
//                        Log.d(TAG, "onResponse: Error Code ${response.code()}")
//                    }
//                }
//                override fun onFailure(call: Call<NotificationResponse>, t: Throwable) {
//                    Log.d(TAG, t.message ?: "토큰 정보 등록 중 통신오류")
//                }
//            })
//        }
//    }

}