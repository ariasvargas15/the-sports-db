package com.brayanarias.thesportsdb.presentation.commons

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel

abstract class ScopeImpl : Scope by Scope.Impl() {

    init {
        initScope()
    }

    fun destroy() {
        destroyScope()
    }
}