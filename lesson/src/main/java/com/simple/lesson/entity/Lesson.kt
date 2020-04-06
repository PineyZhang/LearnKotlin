package com.simple.lesson.entity

/**
 * Created by zsg on 2020-04-05.
 * Desc: 枚举类
 * 被internal修饰的类，只能被模块类访问；外包访问不了
 * plus版：
 * 主构造上的参数加上var或val关键字，会自动生成成员变量
 */
internal class Lesson constructor(var date: String?, var content: String?, var state: State?){

    /**
     * 表示 public 的属性，会自动生成 getter 和 setter 方法
     */
//    var date: String? = date
//    var content: String? = content
//    var state: State? = state

    /**
     * 使用主构造 + init 代码块初始化类
     */
//    init {
//        this.date = date
//        this.content = content
//        this.state = state
//    }

    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String
    }

}