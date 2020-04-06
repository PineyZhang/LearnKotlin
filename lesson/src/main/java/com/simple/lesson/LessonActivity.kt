package com.simple.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.simple.base.BaseView
import com.simple.base.utils.CacheUtils
import com.simple.lesson.entity.Lesson
import kotlin.reflect.KProperty

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {

    /**
     * 使用委托的方式，缓存和读取token属性的值
     */
    private var token: String by Saver("token")

    class Saver(private var token: String) {
        operator fun getValue(lessonActivity: LessonActivity, property: KProperty<*>): String {
            return CacheUtils.get(token)!!
        }

        operator fun setValue(lessonActivity: LessonActivity, property: KProperty<*>, value: String) {
            CacheUtils.save(token,value)

        }
    }

//    private val lessonPresenter = LessonPresenter(this)

    private val lessonAdapter = LessonAdapter()

    // lateinit 表示稍后在初始化该变量
    private lateinit var refreshLayout: SwipeRefreshLayout

//    override fun getPresenter(): LessonPresenter {
//        return lessonPresenter
//    }

    /**
     * 使用委托
     * by lazy 创建 presenter，并且只会创建一次（在第一次调用的时候进行初始化）
     */

    override val presenter: LessonPresenter by lazy{
        LessonPresenter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)

//        val recyclerView = findViewById<RecyclerView>(R.id.list)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = lessonAdapter
//        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        findViewById<RecyclerView>(R.id.list).run {
            layoutManager = LinearLayoutManager(this@LessonActivity)
            adapter = lessonAdapter
            addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VERTICAL))
        }

        refreshLayout = findViewById(R.id.swipe_refresh_layout)
        refreshLayout.setOnRefreshListener { presenter.fetchData() }
        refreshLayout.isRefreshing = true

//        findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout).run {
//            setOnRefreshListener { presenter.fetchData() }
//            isRefreshing = true
//        }

        presenter.fetchData()

        token = "abcd1234" // 调用属性的代理方法，缓存token
    }

    internal fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }

    fun setRefreshing(refreshing: Boolean) {
        refreshLayout.isRefreshing = refreshing
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        presenter.showPlayback()
        return false
    }
}


