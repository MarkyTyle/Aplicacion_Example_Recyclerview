package com.example.aplicaciondeprueba
import Product
import ProductAdapter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: View = findViewById(R.id.toolbar)
        // Ajustar márgenes dinámicamente para evitar superposición con la barra de estado
        ViewCompat.setOnApplyWindowInsetsListener(toolbar) { view, insets ->
            val statusBarInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            view.updateLayoutParams<androidx.constraintlayout.widget.ConstraintLayout.LayoutParams> {
                topMargin = statusBarInsets.top
            }
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val products = listOf(
            Product("intel core i9 14th 14900hx", 10.99, "Procesador 14 Generación"),
            Product("Nvidia GeForce RTX 5090", 20.49, "Tarjeta Grafica"),
            Product("VENGEANCE® 32GB (2x16GB) DDR5 DRAM 6000MT", 15.75, "Tarjeta Ram")
        )
        recyclerView.adapter = ProductAdapter(products)


    }
}
