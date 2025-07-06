package com.nammakhaata.app.repository

import com.nammakhaata.app.data.db.TransactionDao
import com.nammakhaata.app.data.model.Transaction
import kotlinx.coroutines.flow.Flow
import java.util.Date

class TransactionRepository(private val transactionDao: TransactionDao) {

    val allTransactions: Flow<List<Transaction>> = transactionDao.getAllTransactions()


    fun getTransactionsBetweenDates(startDateMillis: Long, endDateMillis: Long): Flow<List<Transaction>> {
        val startDate = Date(startDateMillis)
        val endDate = Date(endDateMillis)
        return transactionDao.getTransactionsBetweenDates(startDate, endDate)
    }

    suspend fun insert(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }

    suspend fun update(transaction: Transaction) {
        transactionDao.updateTransaction(transaction)
    }

    suspend fun delete(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction)
    }

    suspend fun deleteAll() {
        transactionDao.deleteAllTransactions()
    }
}
