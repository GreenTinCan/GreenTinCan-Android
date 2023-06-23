package com.example.protalktime.presentation.common

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.protalktime.MainActivity
import com.example.protalktime.util.Constants

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("setImageUrl")
    fun setImage(view: ImageView, url: String?) {
        url?.let{
            Glide.with(view)
                .load(url)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("convertTextStringToInt")
    fun convertStringToIntFromTextView(view: TextView, value: Int?) {
        value?.let {
            view.text = value.toString()
        }
    }

    @JvmStatic
    @BindingAdapter("money")
    fun setMoney(view: TextView, value: Int?) {
        value?.let {
            view.text = value.toString() + "원"
        }
    }

    @JvmStatic
    @BindingAdapter("date")
    fun setDate(view: TextView, value: String?) {
        value?.let {
            view.text = it.substring(5,10) + " / " + it.substring(11, 13) + "시 " + it.substring(14,16) + "분"
        }
    }
    @JvmStatic
    @BindingAdapter("sex")
    fun setSex(view: TextView, value: String?) {
        value?.let {
           if(it=="female"){
               view.text = "여"
           }else{
               view.text= "남"
           }
        }
    }

    @JvmStatic
    @BindingAdapter("recommendCount")
    fun setRecoomendCount(view: TextView, value: Int?) {
        value?.let {
            view.text = "밥풀력 - " + value.toString()
        }
    }

    @JvmStatic
    @BindingAdapter("chipMC", "order")
    fun setCatOrder(view: TextView, value: String?, order: Int) {
        value?.let {
            view.text = Constants.matchingCategoryTitle[order] + it
        }
    }

}