package com.example.snapchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class ChooseUserActivity : AppCompatActivity() {

    var chooseUserListView: ListView? = null

    var emails: ArrayList<String> = ArrayList()

    var keys: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_user)

        chooseUserListView = findViewById(R.id.chooseUserListView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, emails)

        chooseUserListView?.adapter = adapter

        FirebaseDatabase.getInstance().getReference().child("users").addChildEventListener(object : ChildEventListener{

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {

                val email = p0.child("email").value as String

                emails.add(email)

                keys.add(p0.key!!)

                adapter.notifyDataSetChanged()

            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onChildRemoved(snapshot: DataSnapshot) {}

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onCancelled(error: DatabaseError) {}

        })

        chooseUserListView?.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val snapMap: Map<String, String?> = mapOf("from" to FirebaseAuth.getInstance().currentUser!!.email!!, "imageName" to intent.getStringExtra("imageName"), "imageUrl" to intent.getStringExtra("imageUrl"), "message" to intent.getStringExtra("message"))

            FirebaseDatabase.getInstance().getReference().child("users").child(keys.get(position)).child("snaps").push().setValue(snapMap)

            val intent = Intent(this, SnapsActivity::class.java)

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            startActivity(intent)

        }
    }
}