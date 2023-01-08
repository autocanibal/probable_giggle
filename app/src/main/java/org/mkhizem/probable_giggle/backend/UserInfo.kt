package org.mkhizem.probable_giggle.backend

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

data class UserInfo (
    val name:String,
    val email:String,
    val phone:String,
    val password:String
)

fun UserInfoPost(
    name: String,
    email: String,
    phone: String,
    password: String,
    context: Context
){
    val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users")
    val UserInfo = UserInfo(name, email, phone, password)
    database.child(email).setValue(UserInfo).addOnSuccessListener {
        Toast.makeText(context, "Successfully Saved",Toast.LENGTH_SHORT).show()
    }.addOnFailureListener{
        Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show()
    }
}

fun UserInfoGet(
    email: String,
    password: String,
    context: Context
){
    val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users")
    database.child(email).get().addOnSuccessListener {
        if (it.exists()){
            val name = it.child("name").value
            val phone = it.child("phone").value
        }else{
            Toast.makeText(context, "User does not exist",Toast.LENGTH_SHORT).show()
        }
    }.addOnFailureListener {
        Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show()
    }
}