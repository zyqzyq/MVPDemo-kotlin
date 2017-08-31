package com.zyqzyq.mvpdemo_kotlin

/*
创建Presenter接口*/

interface IUserPresenter{
    fun saveUser(id: Int, username: String, age: Int)
    fun loadUser(id: Int)
}