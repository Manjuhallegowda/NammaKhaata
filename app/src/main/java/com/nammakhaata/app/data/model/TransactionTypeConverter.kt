package com.nammakhaata.app.data.model

import androidx.room.TypeConverter

class TransactionTypeConverter {

    @TypeConverter
    fun toTransactionType(value: String): TransactionType {
        return TransactionType.valueOf(value)
    }

    @TypeConverter
    fun fromTransactionType(type: TransactionType): String {
        return type.name
    }
}
