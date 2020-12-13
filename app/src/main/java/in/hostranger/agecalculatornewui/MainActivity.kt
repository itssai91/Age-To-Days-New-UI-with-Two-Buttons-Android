package `in`.hostranger.agecalculatornewui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var dobToMinutes = ""
    private var atTheAgeOfMinutes =""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBtn.setOnClickListener {
            val difference = atTheAgeOfMinutes.toInt() - dobToMinutes.toInt()
            val ageToDays = difference/(60*24)
            resultTextView.text = "You are $ageToDays Days Old!"
        }

    }

    fun dobToMinutes(view: View) {

        var myCalender = Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var days = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val date = "$dayOfMonth/${month + 1}/$year"
                usrDobText.text = date

                val sdf = SimpleDateFormat("dd/mm/yy", Locale.ENGLISH)
                val dateFormat = sdf.parse(date)
                dobToMinutes = (dateFormat!!.time/60000).toString()

            },
            year,
            month,
            days
        ).show()

    }

    fun ageToDaysMinutes(view: View) {

        var myCalender = Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var days = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val date = "$dayOfMonth/${month + 1}/$year"
                atTheAgeofText.text = date

                val sdf = SimpleDateFormat("dd/mm/yy", Locale.ENGLISH)
                val dateFormat = sdf.parse(date)
                atTheAgeOfMinutes = (dateFormat!!.time / 60000).toString()
            },
            year,
            month,
            days
        ).show()

    }
}