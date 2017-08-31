package com.zyqzyq.mvpdemo_kotlin

/*
创建Model接口
*/
interface IUserModel{
    fun setId(id: Int)
    fun setUsername(name: String)
    fun setAge(age: Int)
    fun save()
    fun load(id: Int): User
}