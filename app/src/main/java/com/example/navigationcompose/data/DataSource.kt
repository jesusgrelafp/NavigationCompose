package com.example.navigationcompose.data

import com.example.navigationcompose.R

/**
 * Carga de datos
 * https://dummyjson.com/products?limit=30&skip=30&select=id,title,description,category,stock,price,sku,availabilityStatus,images,thumbnail
 */
object DataSource {

    val products = listOf<Product>(
        Product(
            id = 31,
            title = "Limón",
            description = "Limones con sabor intenso y ácido, versátiles para cocinar, hornear o preparar bebidas refrescantes.",
            category = "alimentación",
            stock = 31,
            price = 0.79,
            sku = "GRO-BRD-LEM-031",
            availabilityStatus = "En stock",
            image = R.drawable.lemon,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/lemon/thumbnail.webp"
        ),
        Product(
            id = 32,
            title = "Leche",
            description = "Leche fresca y nutritiva, un básico para numerosas recetas y el consumo diario.",
            category = "alimentación",
            stock = 27,
            price = 3.49,
            sku = "GRO-BRD-MIL-032",
            availabilityStatus = "En stock",
            image = R.drawable.milk,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/milk/thumbnail.webp"
        ),
        Product(
            id = 33,
            title = "Mora",
            description = "Moras dulces y jugosas, perfectas para picar o añadir a postres y cereales.",
            category = "alimentación",
            stock = 99,
            price = 4.99,
            sku = "GRO-BRD-MUL-033",
            availabilityStatus = "En stock",
            image = R.drawable.mulberry,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/mulberry/thumbnail.webp"
        ),
        Product(
            id = 34,
            title = "Café Nescafé",
            description = "Café de calidad Nescafé, disponible en varias mezclas para una taza rica y satisfactoria.",
            category = "alimentación",
            stock = 57,
            price = 7.99,
            sku = "GRO-BRD-NES-034",
            availabilityStatus = "En stock",
            image = R.drawable.nescafe,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/nescafe-coffee/thumbnail.webp"
        ),
        Product(
            id = 35,
            title = "Patatas",
            description = "Patatas versátiles y ricas en almidón, ideales para asar, hacer puré o como guarnición.",
            category = "alimentación",
            stock = 13,
            price = 2.29,
            sku = "GRO-BRD-POT-035",
            availabilityStatus = "En stock",
            image = R.drawable.potatoes,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/potatoes/thumbnail.webp"
        ),
        Product(
            id = 36,
            title = "Proteína en polvo",
            description = "Polvo proteico rico en nutrientes, ideal para complementar tu dieta con proteínas esenciales.",
            category = "alimentación",
            stock = 80,
            price = 19.99,
            sku = "GRO-BRD-PRO-036",
            availabilityStatus = "En stock",
            image = R.drawable.protein,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/protein-powder/thumbnail.webp"
        ),
        Product(
            id = 37,
            title = "Cebollas rojas",
            description = "Cebollas rojas aromáticas y sabrosas, perfectas para dar profundidad a platos salados.",
            category = "alimentación",
            stock = 82,
            price = 1.99,
            sku = "GRO-BRD-ONI-037",
            availabilityStatus = "En stock",
            image = R.drawable.onions,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/red-onions/thumbnail.webp"
        ),
        Product(
            id = 38,
            title = "Arroz",
            description = "Arroz de alta calidad, un básico en diversas cocinas y base versátil para muchos platos.",
            category = "alimentación",
            stock = 59,
            price = 5.99,
            sku = "GRO-BRD-RIC-038",
            availabilityStatus = "En stock",
            image = R.drawable.rice,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/rice/thumbnail.webp"
        ),
        Product(
            id = 39,
            title = "Refrescos",
            description = "Refrescos surtidos en varios sabores, perfectos para bebidas frescas.",
            category = "alimentación",
            stock = 53,
            price = 1.99,
            sku = "GRO-BRD-SOF-039",
            availabilityStatus = "En stock",
            image = R.drawable.coke,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/soft-drinks/thumbnail.webp"
        ),
        Product(
            id = 40,
            title = "Fresas",
            description = "Fresas dulces y jugosas, ideales para postres, batidos o comer solas.",
            category = "alimentación",
            stock = 0,
            price = 3.99,
            sku = "GRO-BRD-STR-040",
            availabilityStatus = "Agotado",
            image = R.drawable.strawberry,
            thumbnail = "https://cdn.dummyjson.com/product-images/groceries/strawberry/thumbnail.webp"
        ),
        Product(
            id = 43,
            title = "Columpio decorativo",
            description = "El columpio decorativo es un encantador añadido a la decoración del hogar, con detalles intrincados que aportan elegancia y fantasía.",
            category = "decoración del hogar",
            stock = 47,
            price = 59.99,
            sku = "HOM-BRD-DEC-043",
            availabilityStatus = "En stock",
            image = R.drawable.decoration_swing,
            thumbnail = "https://cdn.dummyjson.com/product-images/home-decoration/decoration-swing/thumbnail.webp"
        ),
        Product(
            id = 44,
            title = "Marco árbol genealógico",
            description = "El marco árbol genealógico es una forma elegante y sentimental de mostrar los recuerdos familiares, con varios espacios para fotografías.",
            category = "decoración del hogar",
            stock = 77,
            price = 29.99,
            sku = "HOM-BRD-FAM-044",
            availabilityStatus = "En stock",
            image = R.drawable.photo_frame,
            thumbnail = "https://cdn.dummyjson.com/product-images/home-decoration/family-tree-photo-frame/thumbnail.webp"
        ),
        Product(
            id = 45,
            title = "Planta decorativa",
            description = "La planta decorativa artificial aporta un toque natural al hogar sin necesidad de mantenimiento.",
            category = "decoración del hogar",
            stock = 0,
            price = 39.99,
            sku = "HOM-BRD-HOU-045",
            availabilityStatus = "Agotado",
            image = R.drawable.plant,
            thumbnail = "https://cdn.dummyjson.com/product-images/home-decoration/house-showpiece-plant/thumbnail.webp"
        ),
        Product(
            id = 46,
            title = "Maceta para plantas",
            description = "Maceta elegante para tus plantas favoritas, ideal para interior o exterior, con un diseño moderno.",
            category = "decoración del hogar",
            stock = 59,
            price = 14.99,
            sku = "HOM-BRD-PLA-046",
            availabilityStatus = "En stock",
            image = R.drawable.pot_plant,
            thumbnail = "https://cdn.dummyjson.com/product-images/home-decoration/plant-pot/thumbnail.webp"
        ),
        Product(
            id = 47,
            title = "Lámpara de mesa",
            description = "Lámpara de mesa funcional y decorativa con diseño moderno, ideal para crear ambiente o iluminación puntual.",
            category = "decoración del hogar",
            stock = 0,
            price = 49.99,
            sku = "HOM-BRD-TAB-047",
            availabilityStatus = "Agotado",
            image = R.drawable.lamp,
            thumbnail = "https://cdn.dummyjson.com/product-images/home-decoration/table-lamp/thumbnail.webp"
        )
    )





}