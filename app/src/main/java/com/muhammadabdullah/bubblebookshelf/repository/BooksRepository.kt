package com.muhammadabdullah.bubblebookshelf.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.muhammadabdullah.bubblebookshelf.model.BooksModel
import com.muhammadabdullah.bubblebookshelf.viewmodel.Callbacks
import kotlin.concurrent.thread

class BooksRepository() {

    private var dynamoDBMapper: DynamoDBMapper? = null

    init {
        val client = AmazonDynamoDBClient(AWSMobileClient.getInstance().credentialsProvider)
        dynamoDBMapper = DynamoDBMapper.builder()
            .dynamoDBClient(client)
            .awsConfiguration(AWSMobileClient.getInstance().configuration)
            .build()
    }

    val apiRepository = ApiRepository()

    fun getBooks(): MutableList<BooksModel> {
        return apiRepository.prepareBooks()!!
    }

    fun getBooksLive(): MutableList<BooksModel> {
        var pageScanList = dynamoDBMapper!!.scan(BooksModel::class.java, DynamoDBScanExpression())
        return pageScanList
    }

}