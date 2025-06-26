package com.nammakhaata.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val type: TransactionType,
    val category: String,
    val source: String,
    val date: Date,
    val note: String? = null
)

enum class TransactionType {
    CREDIT,
    DEBIT
}
