package com.nammakhaata.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import com.nammakhaata.app.data.db.AppDatabase
import com.nammakhaata.app.receiver.SmsParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.provider.Telephony.SMS_RECEIVED") {
            val bundle: Bundle? = intent.extras
            try {
                if (bundle != null && context != null) {
                    val pdus = bundle.get("pdus") as Array<*>
                    for (pdu in pdus) {
                        val smsMessage = SmsMessage.createFromPdu(pdu as ByteArray)
                        val sender = smsMessage.displayOriginatingAddress
                        val messageBody = smsMessage.messageBody
                        Log.d("SmsReceiver", "SMS received from: $sender, message: $messageBody")

                        val transaction = SmsParser.parseSms(sender ?: "", messageBody)
                        if (transaction != null) {
                            val db = AppDatabase.getDatabase(context)
                            CoroutineScope(Dispatchers.IO).launch {
                                db.transactionDao().insertTransaction(transaction)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("SmsReceiver", "Exception in onReceive: ${e.message}")
            }
        }
    }
}
