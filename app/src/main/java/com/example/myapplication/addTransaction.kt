package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class addTransaction : AppCompatActivity() {

    private lateinit var add: FloatingActionButton
    private lateinit var myTrack: TextView
    private lateinit var backButton: ImageButton
    private lateinit var saveButton: Button
    private lateinit var profileButton: ImageView
    private lateinit var categorySpinner: Spinner
    private lateinit var transactionTypeGroup: RadioGroup
    private lateinit var incomeRadio: RadioButton
    private lateinit var expenseRadio: RadioButton
    private lateinit var dateEditText: EditText

    private fun initComponents() {
        add = findViewById(R.id.add)
        myTrack = findViewById(R.id.myTrack)
        backButton = findViewById(R.id.backButton)
        saveButton = findViewById(R.id.saveButton)
        profileButton = findViewById(R.id.profileButton)
        categorySpinner = findViewById(R.id.category)
        transactionTypeGroup = findViewById(R.id.typeGroup)
        incomeRadio = findViewById(R.id.incomeRadio)
        expenseRadio = findViewById(R.id.expenseRadio)
        dateEditText = findViewById(R.id.editTextDate)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_transaction)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()

        setSpinnerItems(R.array.income_category)

        transactionTypeGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.incomeRadio -> setSpinnerItems(R.array.income_category)
                R.id.expenseRadio -> setSpinnerItems(R.array.expense_category)
            }
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }

        myTrack.setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }

        saveButton.setOnClickListener {
            startActivity(Intent(this, home::class.java))
        }

        profileButton.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }

        dateEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, { _, y, m, d ->
                val formattedDate = String.format("%02d/%02d/%04d", d, m + 1, y)
                dateEditText.setText(formattedDate)
            }, year, month, day)

            datePicker.show()
        }
    }

    private fun setSpinnerItems(arrayResId: Int) {
        val adapter = ArrayAdapter.createFromResource(
            this, arrayResId, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter
    }
}
