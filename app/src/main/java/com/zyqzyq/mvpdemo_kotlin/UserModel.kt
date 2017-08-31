package com.zyqzyq.mvpdemo_kotlin

import android.util.SparseArray

/*
创建Model实现类
*/
class UserModel: IUserModel{
    private var mId: Int = 0
    private var mUsername: String = ""
    private var mAge: Int = 0
    private var mUserArray = SparseArray<User>()

    override fun setId(id: Int) {
        mId = id
    }

    override fun setAge(age: Int) {
        mAge = age
    }

    override fun setUsername(name: String) {
        mUsername = name
    }

    override fun save() {
        mUserArray.append(mId, User(mUsername,mAge))
    }

    override fun load(id: Int): User {
        mId = id
        return mUserArray.get(mId ,User("Not found",0))
    }
}