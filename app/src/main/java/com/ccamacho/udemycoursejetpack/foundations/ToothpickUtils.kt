package com.ccamacho.udemycoursejetpack.foundations

import com.ccamacho.udemycoursejetpack.notes.INoteModel
import com.ccamacho.udemycoursejetpack.notes.NoteLocalModel
import com.ccamacho.udemycoursejetpack.tasks.ITaskModel
import com.ccamacho.udemycoursejetpack.tasks.TaskLocalModel
import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope {
    val scope: Scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }
}

object ApplicationModule: Module() {
    init {
        bind(INoteModel::class.java).toInstance(NoteLocalModel())
        bind(ITaskModel::class.java).toInstance(TaskLocalModel())
    }
}