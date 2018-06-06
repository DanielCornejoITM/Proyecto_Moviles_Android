package com.example.abims.punto_de_venta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.facebook.*
import kotlinx.android.synthetic.main.activity_main.*
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*


class MainActivity : AppCompatActivity() {
    private var callbackManager: CallbackManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired
        if(isLoggedIn== true)
            startActivity(Intent(applicationContext,Inicio::class.java))


        var btnLoginFacebook = findViewById<Button>(R.id.login_button)

        btnLoginFacebook.setOnClickListener(View.OnClickListener {
            // Login
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"))
            LoginManager.getInstance().registerCallback(callbackManager,
                    object : FacebookCallback<LoginResult> {
                        override fun onSuccess(loginResult: LoginResult) {
                            Log.d("MainActivity", "Facebook token: " + loginResult.accessToken.token)

                            if (loginResult.accessToken!=null) {
                                startActivity(Intent(applicationContext, Inicio::class.java))
                                Toast.makeText(applicationContext, "Abriendo Sesion ${loginResult.accessToken} ", Toast.LENGTH_LONG).show()
                            }


                        }

                        override fun onCancel() {
                            Log.d("MainActivity", "Facebook onCancel.")
                            Toast.makeText(applicationContext,"Cancelo",Toast.LENGTH_LONG).show()
                        }

                        override fun onError(error: FacebookException) {
                            Log.d("MainActivity", "Facebook onError.")
                            Toast.makeText(applicationContext,"Salio un Error $error",Toast.LENGTH_LONG).show()


                        }
                    })
        })




    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }
}
