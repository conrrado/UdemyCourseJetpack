package com.ccamacho.udemycoursejetpack.foundations

import com.ccamacho.udemycoursejetpack.create.StateModel
import com.ccamacho.udemycoursejetpack.notes.INoteModel
import com.ccamacho.udemycoursejetpack.notes.NoteLocalModel
import com.ccamacho.udemycoursejetpack.tasks.ITaskModel
import com.ccamacho.udemycoursejetpack.tasks.TaskLocalModel
import toothpick.Scope
import toothpick.Toothpick
import toothpick.config.Module
import toothpick.ktp.binding.bind

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

object CreateActivityScope {
    val scope: Scope = Toothpick.openScope(this).apply {
        installModules(CreateActivityModule)
    }
}

object CreateActivityModule: Module() {
    init {
        bind(INoteModel::class.java).to(NoteLocalModel::class.java)
        bind(ITaskModel::class.java).to(TaskLocalModel::class.java)
        bind(StateModel::class.java).toInstance(StateModel())
    }
}