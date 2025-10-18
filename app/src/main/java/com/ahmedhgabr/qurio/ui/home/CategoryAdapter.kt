package com.ahmedhgabr.qurio.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmedhgabr.qurio.R
import com.ahmedhgabr.qurio.databinding.ItemCategoryBinding
import com.ahmedhgabr.qurio.presenter.entity.Category

class CategoryAdapter(var categories: List<Category>, private val onCategoryClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position], onCategoryClick)
    }

    override fun getItemCount() = categories.size

    class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category, onCategoryClick: (Category) -> Unit) {
            binding.categoryName.text = category.name
            binding.categoryImage.setImageResource(getImagesForCategory(category.id))
            itemView.setOnClickListener { onCategoryClick(category) }
        }

        private fun getImagesForCategory(categoryId: Int): Int {
            return when (categoryId) {
                9 -> R.drawable.knowledge // General Knowledge
                in 10..16, 29, 31, 32 -> R.drawable.food // Entertainment
                in 17..19, 30 -> R.drawable.science // Science
                20, 22, 23, 24, 25 -> R.drawable.geography // Humanities
                21, 26 -> R.drawable.sport // Sports, Celebrities
                27, 28 -> R.drawable.sport // Animals, Vehicles
                else -> R.drawable.science
            }
        }
    }
}