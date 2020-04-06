package com.simple.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simple.base.BaseViewHolder
import com.simple.lesson.entity.Lesson
import java.util.*

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    private var list: List<Lesson> = ArrayList()

    internal fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    /**
     * 静态内部类
     */
    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {

        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false))
            }
        }

        internal fun onBind(lesson: Lesson) {
//            var date = lesson.date
//            if (date == null) {
//                date = "日期待定"
//            }
            /**
             * 简化判空代码
             */
            setText(R.id.tv_date, lesson.date?:"日期待定")
            setText(R.id.tv_content, lesson.content)

//            val state = lesson.state
//            if (state != null) {
//                setText(R.id.tv_state, state.stateName())
//                /**
//                 * Kotlin 中 when、if、和try catch 都是有返回值的
//                 */
//                var colorRes = when (state) {
//                    Lesson.State.PLAYBACK -> R.color.playback
//                    Lesson.State.LIVE -> R.color.live
//                    Lesson.State.WAIT -> R.color.wait
//                }
//                val backgroundColor = itemView.context.getColor(colorRes)
//                getView<View>(R.id.tv_state)!!.setBackgroundColor(backgroundColor)
//            }

            /**
             * 通过安全调用符，当lesson.state?不为空时，才会执行下面的代码
             */
            lesson.state?.let {
                setText(R.id.tv_state, it.stateName())
                /**
                 * Kotlin 中 when、if、和try catch 都是有返回值的
                 */
                var colorRes = when (it) {
                    Lesson.State.PLAYBACK -> R.color.playback
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state)!!.setBackgroundColor(backgroundColor)
            }
        }
    }

}
