package org.mkhizem.probable_giggle.ui.storefront

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size
import org.mkhizem.probable_giggle.R

class ExposedDropMenuStateHolder {

    var enabled by mutableStateOf(false)
    var value by mutableStateOf("")
    var selectedIndex by mutableStateOf(-1)
    var size by mutableStateOf(Size.Zero)
    val icon:Int
    @Composable get() = if (enabled){
        R.drawable.ic_baseline_arrow_drop_up_24
    }else{
        R.drawable.ic_baseline_arrow_drop_down_24
    }

    //todo add stock amount
    val items = (0..5).map {
        "$it"
    }

    fun onEnabled(newValue: Boolean){
        enabled = newValue
    }
    fun onSelectedIndex(newValue: Int){
        selectedIndex = newValue
        value = items[selectedIndex]
    }
    fun onSize(newValue: Size){
        size = newValue
    }
}

@Composable
fun rememberExposedMenuStateHolder() = remember {
    ExposedDropMenuStateHolder()
}