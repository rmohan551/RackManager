package com.example.rackmanager

    import android.app.DatePickerDialog
    import android.app.Dialog
    import android.os.Bundle
    import androidx.fragment.app.DialogFragment
    import java.util.Calendar

    class DatePicker(private val onDateSetListener: DatePickerDialog.OnDateSetListener) : DialogFragment() {

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Create a new instance of DatePickerDialog and return it
            return DatePickerDialog(requireContext(), onDateSetListener, year, month, day)
        }
    }

