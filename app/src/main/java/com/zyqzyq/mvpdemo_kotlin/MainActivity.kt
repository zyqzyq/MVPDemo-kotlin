package com.zyqzyq.mvpdemo_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import android.text.SpannableStringBuilder



class MainActivity : AppCompatActivity() ,IUserView, View.OnClickListener{
    private var mUserPresenter: UserPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mUserPresenter = UserPresenter(this)
        saveButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.saveButton -> mUserPresenter?.saveUser(getID(),getUsername(),getAge())
            R.id.loadButton -> mUserPresenter?.loadUser(getID())
        }
    }

    override fun onSaveSuccess() {
        edt_id.setText("")
        edt_age.setText("")
        edt_username.setText("")
        toast("保存成功")
    }

    override fun getID(): Int {
        val id = edt_id.text.toString().trim()
        when(id.isNotEmpty()){
            true    ->   return id.toInt()
        }
        return 0
    }

    override fun getUsername(): String {
        return edt_username.text.toString()
    }

    override fun getAge(): Int {
        val age = edt_age.text.toString().trim()
        if (age.isNotEmpty())
            return age.toInt()
        return 0
    }

    override fun setUsername(username: String) {
        val editablename = SpannableStringBuilder(username)
        edt_username.text = editablename
    }

    override fun setAge(age: Int) {
        val editableage = SpannableStringBuilder(age.toString())
        edt_age.text = editableage
    }
}
