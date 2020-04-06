package com.simple.lesson

import com.google.gson.reflect.TypeToken
import com.simple.base.http.EntityCallback
import com.simple.base.http.HttpClient
import com.simple.base.utils.Utils
import com.simple.lesson.entity.Lesson
import java.util.*

/**
 * Created by zsg on 2020-04-05.
 * Desc:
 *
 */
class LessonPresenter {

    companion object {
        // 编译期常量（类型Java中的 static final ）
        const val LESSON_PATH = "lessons"
    }

    private val activity: LessonActivity

    constructor(activity: LessonActivity) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson>>() {

    }.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {

            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread {
                    activity.showResult(lessons)
                }
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread {
                    Utils.toast(message)
                }
            }
        })
    }

    fun showPlayback() {
        val playbackLessons = ArrayList<Lesson>()
        for (lesson in lessons) {
            if (lesson.getState() === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity.showResult(playbackLessons)
    }
}