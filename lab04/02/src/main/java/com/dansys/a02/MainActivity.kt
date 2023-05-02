package com.dansys.a02

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.imageView)
            imageView.setImageBitmap(imageBitmap)
        }
       if (requestCode==1 && resultCode== RESULT_OK){
           val uri=data?.data
           if(uri!=null){
               val inputStream:InputStream?=contentResolver.openInputStream(uri)
               val bitmap:Bitmap?=BitmapFactory.decodeStream(inputStream)
               imageView.setImageBitmap(bitmap)
           }
       }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.open_image)
        button.setOnClickListener {
           val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type="image/*"
            startActivityForResult(intent,1)
        }

        val button2 = findViewById<Button>(R.id.get_foto)
        button2.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, REQUEST_CAMERA)
        }

        val button3 = findViewById<Button>(R.id.open_play)
        button3.setOnClickListener{
            val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("market://details?id=com.example.app")
            startActivity(intent)
        }
    }

    companion object {
        const val REQUEST_RETRIEVE_DATE = 1
        const val REQUEST_IMAGE_OPEN = 2
        const val REQUEST_CAMERA = 3
        const val ACTION_IMAGE_CAPTURE=4

    }
}