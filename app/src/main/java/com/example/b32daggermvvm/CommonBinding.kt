package com.example.b32daggermvvm

import android.widget.EditText
import androidx.databinding.BindingAdapter

class CommonBinding {

    companion object{

        @JvmStatic
        @BindingAdapter("error_text")
        fun setErrorText(editText: EditText, errorMessage: String?){
            editText.error = errorMessage
        }
    }
}