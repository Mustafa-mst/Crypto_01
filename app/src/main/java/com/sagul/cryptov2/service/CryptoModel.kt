package com.sagul.cryptov2.service

import com.google.gson.annotations.SerializedName

data class CryptoModel(@SerializedName("currency")var currency:String,@SerializedName("price") var price:String) {
}