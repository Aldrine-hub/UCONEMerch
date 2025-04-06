package com.example.sampleandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    private lateinit var cartItemsContainer: LinearLayout
    private lateinit var checkoutButton: Button
    private lateinit var totalPriceText: TextView
    private var totalPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Initialize views
        cartItemsContainer = findViewById(R.id.item_name)
        checkoutButton = findViewById(R.id.checkout_button)
        totalPriceText = findViewById(R.id.total_price)

        // Add sample items
        addItemToCart("CSS Lanyard", 200, 2)
        addItemToCart("PHP Mug", 150, 1)

        checkoutButton.setOnClickListener {
            Toast.makeText(this, "Proceeding to checkout", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addItemToCart(itemName: String, itemPrice: Int, quantity: Int) {
        val inflater = LayoutInflater.from(this)
        val cartItemView = inflater.inflate(R.layout.activity_cart, cartItemsContainer, false)

        val itemNameText = cartItemView.findViewById<TextView>(R.id.item_name)
        val itemPriceText = cartItemView.findViewById<TextView>(R.id.item_price)
        val itemQuantityText = cartItemView.findViewById<TextView>(R.id.item_quantity)
        val deleteButton = cartItemView.findViewById<ImageView>(R.id.delete_button)
        val plusButton = cartItemView.findViewById<TextView>(R.id.plus_button)
        val minusButton = cartItemView.findViewById<TextView>(R.id.minus_button)

        itemNameText.text = itemName
        itemPriceText.text = "₱$itemPrice"
        itemQuantityText.text = quantity.toString()

        var currentQuantity = quantity

        updateTotalPrice(itemPrice * currentQuantity)

        minusButton.setOnClickListener {
            if (currentQuantity > 1) {
                currentQuantity--
                itemQuantityText.text = currentQuantity.toString()
                updateTotalPrice(-itemPrice)
            }
        }

        plusButton.setOnClickListener {
            currentQuantity++
            itemQuantityText.text = currentQuantity.toString()
            updateTotalPrice(itemPrice)
        }

        deleteButton.setOnClickListener {
            cartItemsContainer.removeView(cartItemView)
            updateTotalPrice(-itemPrice * currentQuantity)
        }

        cartItemsContainer.addView(cartItemView)
    }

    private fun updateTotalPrice(amount: Int) {
        totalPrice += amount
        totalPriceText.text = "₱$totalPrice"
    }
}
