package com.example.snapchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import java.net.Proxy

class SnapsActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    var snapsListView: ListView? = null

    var emails: ArrayList<String> = ArrayList()

    var snaps: ArrayList<DataSnapshot> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snaps)

        snapsListView = findViewById(R.id.snapsListView)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emails)

        snapsListView?.adapter = adapter


        FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.currentUser!!.uid).child("snaps").addChildEventListener(object: ChildEventListener {

            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

                emails.add(snapshot.child("from").value as String)

                snaps.add(snapshot)

                adapter.notifyDataSetChanged()

            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onChildRemoved(snapshot: DataSnapshot) {

                for (snap: DataSnapshot in snaps) {

                    var index = 0

                    if (snap.key == snapshot.key) {

                        snaps.removeAt(index)

                        emails.removeAt(index)

                    }

                    index++

                }

                adapter.notifyDataSetChanged()

            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onCancelled(error: DatabaseError) {}

        })

        snapsListView?.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val snapshot = snaps.get(position)

            var intent = Intent(this, ViewSnapActivity::class.java)

            intent.putExtra("imageName", snapshot.child("imageName").value as String)

            intent.putExtra("message", snapshot.child("message").value as String)

            intent.putExtra("imageUrl", snapshot.child("imageUrl").value as String)

            intent.putExtra("snapKey", snapshot.key)

            startActivity(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.snaps, menu)

        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item?.itemId == R.id.createSnap) {

            val intent = Intent(this, CreateSnapActivity::class.java)

            startActivity(intent)

        } else if (item?.itemId == R.id.logout) {

            mAuth.signOut()

            finish()

        }

        return super.onOptionsItemSelected(item)

    }

    override fun onBackPressed() {

        super.onBackPressed()

        mAuth.signOut()

    }
}