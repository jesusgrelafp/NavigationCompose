package com.example.navigationcompose.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigationcompose.viewmodel.ProductViewModel
import com.example.navigationcompose.data.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  DetailScreenAdvanced(
    id : Int,
    navController: NavController,
    viewModel: ProductViewModel
) {
    val scrollState = rememberScrollState()

    val product = viewModel.getProductById(id) ?: Product(id = id, title = "Desconocido")

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Column() {
                    Text("Detalle del producto")
                    Text("SKU: ${product.sku}", fontSize = 12.sp )
                }
            },
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                }
            })
        }
    ) { contentPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Imagen principal
            Row() {
                Image(
                    painter = painterResource(product.image),
                    contentDescription = product.description
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

            // Título
            Text(
                text = product.title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Categoría
            Text(
                text = product.category.uppercase(),
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Divider(modifier = Modifier.padding(16.dp))

            // Descripción
            Text(
                text = product.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Precio + Estado + Stock
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                val disponible = if (product.availabilityStatus.equals("En stock")) true else false

                Text(
                    text = "${product.price} €",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Blue
                )

                val color = if (disponible) Color(0xFF4CAF50) else Color.Red
                Text(
                    text = " ${product.availabilityStatus}",
                    fontSize = 20.sp,
                    color = color
                )

                if (disponible) {
                    Text(
                        "${product.stock} uds.",
                        fontSize = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Volver")
            }
        }

    }
}
