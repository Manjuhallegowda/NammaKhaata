package com.nammakhaata.app.receiver

import android.util.Log
import com.nammakhaata.app.data.model.Transaction
import com.nammakhaata.app.data.model.TransactionType
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

object SmsParser {

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    fun parseSms(sender: String, message: String): Transaction? {
        try {
            // Example regex patterns for parsing SMS
            val amountRegex = Regex("(?:Rs|INR|₹)\\s?([0-9]+(?:\\.[0-9]{1,2})?)")
            val creditKeywords = listOf("credited", "received", "deposit")
            val debitKeywords = listOf("debited", "spent", "withdrawn", "paid")

            val amountMatch = amountRegex.find(message)
            val amount = amountMatch?.groups?.get(1)?.value?.toDoubleOrNull() ?: return null

            val type = when {
                creditKeywords.any { message.contains(it, ignoreCase = true) } -> TransactionType.CREDIT
                debitKeywords.any { message.contains(it, ignoreCase = true) } -> TransactionType.DEBIT
                else -> return null
            }

            val category = when {
                message.contains("food", ignoreCase = true) -> "Food"
                message.contains("travel", ignoreCase = true) -> "Travel"
                message.contains("bill", ignoreCase = true) -> "Bills"
                message.contains("shopping", ignoreCase = true) -> "Shopping"
                else -> "Others"
            }

            val date = Date() // Use current date as placeholder, can be improved to parse from SMS

            return Transaction(
                amount = amount,
                type = type,
                category = category,
                source = sender,
                date = date,
                note = message
            )
        } catch (e: Exception) {
            Log.e("SmsParser", "Error parsing SMS: ${e.message}")
            return null
        }
    }
}
