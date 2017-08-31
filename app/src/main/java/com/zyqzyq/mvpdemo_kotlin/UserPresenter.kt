package com.zyqzyq.mvpdemo_kotlin

class UserPresenter(val view: IUserView): IUserPresenter{
    private val mUserModel: UserModel = UserModel()
    override fun saveUser(id: Int, username: String, age: Int) {
        mUserModel.setId(id)
        mUserModel.setUsername(username)
        mUserModel.setAge(age)
        mUserModel.save()
        view.onSaveSuccess()
    }

    override fun loadUser(id: Int) {
        val user = mUserModel.load(id)
        view.setUsername(user.userName)
        view.setAge(user.age)
    }
}