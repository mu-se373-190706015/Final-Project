package com.example.oldpeopleappp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class TodoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)


        val comebackbutton=findViewById<Button>(R.id.comebacktodolistbutton)
        val addButton = findViewById<Button>(R.id.add_button)
        val deleteButton = findViewById<Button>(R.id.delete_button)
        val toDoList = findViewById<ListView>(R.id.to_do_list_view)
        val addItemEdit = findViewById<EditText>(R.id.add_item_edit)
        val errorMessageText = findViewById<TextView>(R.id.error_message_text)
        val listItems = arrayListOf<String>()



        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.select_dialog_multichoice, listItems)
        toDoList.adapter = arrayAdapter


        comebackbutton.setOnClickListener {
            val intent = Intent(this,AppInsideactivity::class.java)
            startActivity(intent)

        }

//        add item
        addButton.setOnClickListener {
            val itemText: String = addItemEdit.text.toString()
            if (itemText.isNotEmpty()) {
                listItems.add(itemText)
                arrayAdapter.notifyDataSetChanged()
                addItemEdit.setText("")
                errorMessageText.visibility = View.GONE
                Toast.makeText(this, itemText + " added", Toast.LENGTH_SHORT).show()
            }  else {
                errorMessageText.visibility = View.GONE
                errorMessageText.text = "Please, write something..."
                errorMessageText.visibility = View.VISIBLE
                Toast.makeText(this, "Please, fill the gap", Toast.LENGTH_SHORT).show()
            }
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }

//        delete item
        deleteButton.setOnClickListener {
            val position: SparseBooleanArray = toDoList.checkedItemPositions
            val count = toDoList.count
            for(item in count - 1 downTo 0) {
                if(position.get(item)) {
                    arrayAdapter.remove(listItems.get(item))
                }
            }
            position.clear()
            arrayAdapter.notifyDataSetChanged()
        }
    }
}