package com.gttan.gove.data.remote.repository

import android.util.Log
import com.gttan.gove.data.mapper.CartMapper
import com.gttan.gove.domain.model.CartItem
import com.gttan.gove.domain.model.Product
import com.gttan.gove.domain.model.Rating
import com.gttan.gove.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

private val cartItemList: List<CartItem> = listOf(
    CartItem(
        Product(
            id = 1,
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            category = "men's clothing",
            image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            price = 109.95,
            rating = Rating(count = 120, rate = 3.9)
        ),
        1,
    ),
    CartItem(
        Product(
            id = 13,
            title = "Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin",
            description = "21. 5 inches Full HD (1920 x 1080) widescreen IPS display And Radeon free Sync technology. No compatibility for VESA Mount Refresh Rate: 75Hz - Using HDMI port Zero-frame design | ultra-thin | 4ms response time | IPS panel Aspect ratio - 16: 9. Color Supported - 16. 7 million colors. Brightness - 250 nit Tilt angle -5 degree to 15 degree. Horizontal viewing angle-178 degree. Vertical viewing angle-178 degree 75 hertz",
            category = "electronics",
            image = "https://fakestoreapi.com/img/81QpkIctqPL._AC_SX679_.jpg",
            price = 599.0,
            rating = Rating(count = 250, rate = 2.9)
        ),
        1,
    ),
    CartItem(
        Product(
            id = 11,
            title = "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5",
            description = "3D NAND flash are applied to deliver high transfer speeds Remarkable transfer speeds that enable faster bootup and improved overall system performance. The advanced SLC Cache Technology allows performance boost and longer lifespan 7mm slim design suitable for Ultrabooks and Ultra-slim notebooks. Supports TRIM command, Garbage Collection technology, RAID, and ECC (Error Checking & Correction) to provide the optimized performance and enhanced reliability.",
            category = "electronics",
            image = "https://fakestoreapi.com/img/71kWymZ+c+L._AC_SX679_.jpg",
            price = 109.0,
            rating = Rating(count = 319, rate = 4.8)
        ),
        2,
    ),
    CartItem(
        Product(
            id = 4,
            title = "Mens Casual Slim Fit",
            description = "The color could be slightly different between on the screen and in practice. / Please note that body builds vary by person, therefore, detailed size information should be reviewed below on the product description.",
            category = "men's clothing",
            image = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            price = 15.99,
            rating = Rating(count = 430, rate = 2.1)
        ),
        1,
    ),
)

class CartRepositoryImpl @Inject constructor(
    private val cartMapper: CartMapper,
) : CartRepository {
    override fun getCart(): Flow<List<CartItem>> {
        // TODO:
        return flowOf(cartItemList)
    }

    override fun addToCart(product: Product, amount: Int, onSuccess: () -> Unit) {
        // TODO:
        Log.d("TAG", "addToCart: $product----$amount")
    }

    override fun changeAmount(product: Product, amount: Int) {
        // TODO:
    }

    override fun clearCart() {
        // TODO:
    }

    override fun removeFromCart(product: Product) {
        // TODO:
    }
}
