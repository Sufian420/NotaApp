package com.example.notaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.room.Room
import com.example.notaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var db:ContactDatabase

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= Room
            .databaseBuilder(applicationContext,
                ContactDatabase::class.java,
                "contact_db")
            .allowMainThreadQueries()
            .build()

        binding.buttonSubmit.setOnClickListener{

            val contact = Contact(null,
                binding.editTextName.text.toString(),
                binding.editTextEmail.text.toString(),
                binding.editTextPhone.text.toString()
            )
            db.getContactDao().createContact(contact)
        }

        binding.getBtn.setOnClickListener{

            val contactList:List<Contact> = db.getContactDao().getAllContact()
            contactList.forEach{
                binding.showText.text="${binding.showText.text}\n\n ${it.toString()}"
            }

        }


    }


}