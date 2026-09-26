package com.wallpaper.setter

import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val wallpaperManager = WallpaperManager.getInstance(this)
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.wallpaper)
            
            if (bitmap != null) {
                wallpaperManager.setBitmap(bitmap)
                Toast.makeText(this, "Fondo de pantalla cambiado ✓", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error inesperado", Toast.LENGTH_SHORT).show()
        }

        // Cierra la app automáticamente después de poner el fondo
        finish()
    }
}
