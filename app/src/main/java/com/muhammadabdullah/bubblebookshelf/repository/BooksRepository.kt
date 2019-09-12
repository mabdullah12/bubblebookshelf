package com.muhammadabdullah.bubblebookshelf.repository

import androidx.lifecycle.LiveData
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.muhammadabdullah.bubblebookshelf.BubbleBookShelfApplication
import com.muhammadabdullah.bubblebookshelf.model.BooksModel
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class BooksRepository() {

    private var dynamoDBMapper: DynamoDBMapper? = null

     private var observableMutableList : Observable<MutableList<BooksModel>> = Observable.create(
        ObservableOnSubscribe {
            it.onNext(getBooksAWS())
            it.onComplete()
        }
    )

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

    fun getBooksAWS(): MutableList<BooksModel> {

        var pageScanList = dynamoDBMapper!!.scan(BooksModel::class.java, DynamoDBScanExpression())
        BubbleBookShelfApplication.databaseInstace.booksDao().saveBooks(pageScanList)

     //   BubbleBookShelfApplication.databaseInstace.booksDao().saveBooks(pageScanList)

        return pageScanList
    }


    /**
     * Following the principle of Single Source of Truth,
     * we have set a live data for the UI.
     */
    fun getAllBooksLive() : LiveData<MutableList<BooksModel>>{
        var liveDataBooks : LiveData<MutableList<BooksModel>> =  BubbleBookShelfApplication.databaseInstace.booksDao().getAllBooksLive()
        if (liveDataBooks.value == null || liveDataBooks.value?.size == 0){
            // network call
            observableMutableList.subscribeOn(Schedulers.io()).subscribe()
        }
        return liveDataBooks
    }




}