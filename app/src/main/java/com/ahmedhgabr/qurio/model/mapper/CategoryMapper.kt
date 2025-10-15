package com.ahmedhgabr.qurio.model.mapper

import com.ahmedhgabr.qurio.model.remote.dto.CategoryDTO
import com.ahmedhgabr.qurio.presenter.entity.Category

fun CategoryDTO.toCategory(): Category {
    return Category(
        id = this.id,
        name = this.name
    )
}