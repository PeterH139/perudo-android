package me.peterhenderson.perudo.home

import android.util.Log
import me.peterhenderson.perudo.R
import me.peterhenderson.perudo.core.BaseActivity
import me.peterhenderson.perudo.core.ContentView
import javax.inject.Inject

@ContentView(R.layout.activity_home)
class HomeActivity : BaseActivity() {
    @Inject lateinit var presenter: HomePresenter

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}

class HomePresenter @Inject constructor() {
    fun onResume() {
        Log.d("PeterH139", "HomePresenter.onResume()")
    }
}

