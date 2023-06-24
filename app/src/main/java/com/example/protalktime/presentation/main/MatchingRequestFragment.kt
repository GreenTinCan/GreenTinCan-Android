package com.example.protalktime.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.protalktime.R
import com.example.protalktime.data.model.meeting.MatchingCreateRequest
import com.example.protalktime.databinding.FragmentMatchingRequestBinding
import com.example.protalktime.presentation.common.BaseFragment
import com.example.protalktime.presentation.common.CustomSnackBar
import com.example.protalktime.presentation.common.NavigationUtil.navigate
import com.example.protalktime.presentation.common.NavigationUtil.navigateUp
import com.example.protalktime.presentation.main.viewmodel.MatchingViewModel
import com.example.protalktime.util.Constants
import com.example.protalktime.util.EventObserver
import com.google.android.material.chip.Chip
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber
import kotlin.math.min

class MatchingRequestFragment :
    BaseFragment<FragmentMatchingRequestBinding>(R.layout.fragment_matching_request) {

    private var firstSelectedOption = "교내"
    private var secondSelectedOption = "후생관"
    private var thirdSelectedOption = "바비든든"

    private val matchingViewModel: MatchingViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNumberPickerInit(binding.npDay, 1, 31, 1)
        setNumberPickerInit(binding.npMonth, 1, 12, 1)
        setNumberPickerInit(binding.npHour, 0, 24, 0)
        setNumberPickerInit(binding.npMinute, 0, 60, 0)

        setThirdChipGroup("후생관")
        handleCategoryOptionEvent()

        binding.ivBackButton.setOnClickListener {
            navigate(R.id.action_matchingRequestFragment_to_meetingMainFragment)
        }

        binding.tvCompleteButton.setOnClickListener {
            if(!Constants.isMatchingCreated) {
                val selectedTime = getSelectedTime()
                Timber.d("숫자를 선택했다 : ${selectedTime}")
                val requestBody = MatchingCreateRequest(
                firstSelectedOption,
                secondSelectedOption,
                thirdSelectedOption,
                binding.etFourthRequest.text.toString(),
                selectedTime,
                binding.etMoney.text.toString().toInt(),
                binding.etLastRequest.text.toString()
            )
            matchingViewModel.requestMatchingCreation(Constants.userInfo.authorization, requestBody)
            } else {
                Toast.makeText(requireActivity(), "매칭은 하나만 생성 가능해요", Toast.LENGTH_SHORT).show()
            }
        }

        matchingViewModel.createMatchingResponse.observe(viewLifecycleOwner, EventObserver {
            Constants.isMatchingCreated = true
            Constants.currentCreatedMatching = it
            val drawable = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_check_30)!!
            CustomSnackBar.make(binding.root, "요청한 매칭이 등록됐어요", drawable).show()
            navigateUp()
        })
    }

    private fun handleCategoryOptionEvent() {
        binding.cgFirstRequest.setOnCheckedStateChangeListener { group, _ ->
            val checkedChip = getCheckedChip(group.checkedChipId)
            firstSelectedOption = getCategoryOption(checkedChip)
        }

        binding.cgSecondRequest.setOnCheckedStateChangeListener { group, _ ->
            val checkedChip = getCheckedChip(group.checkedChipId)
            initCategoryOption(checkedChip)
        }

        binding.cgThirdRequest.setOnCheckedStateChangeListener { group, _ ->
            val checkedChip = getCheckedChip(group.checkedChipId)
            thirdSelectedOption = getCategoryOption(checkedChip)
        }
    }

    private fun getCheckedChip(checkedId: Int): Chip {
        return requireActivity().findViewById(checkedId) as Chip
    }

    private fun initCategoryOption(checkedChip: Chip) {
        secondSelectedOption = checkedChip.text.toString()
        setThirdChipGroup(secondSelectedOption)
    }

    private fun getCategoryOption(checkedChip: Chip): String {
        return checkedChip.text.toString()
    }

    private fun setThirdChipGroup(selectedOption: String) {
        binding.cgThirdRequest.removeAllViews()
        var targetList = listOf<String>()
        when (selectedOption) {
            "후생관" -> {
                targetList = Constants.chipSetByWhoSaengGwan
            }

            "기숙사" -> {
                targetList = Constants.chipByDomitoryRoom
            }

            "어문관" -> {
                targetList = Constants.chipByMoonGwan
            }
        }
        for (category in targetList) {
            val chip: Chip = layoutInflater.inflate(
                R.layout.chip_gray_background,
                binding.cgThirdRequest,
                false
            ) as Chip
            binding.cgThirdRequest.addView(chip.apply {
                text = category
                if (category == targetList[0]) {
                    isChecked = true
                    thirdSelectedOption = category
                }
            })
        }
    }

    private fun setNumberPickerInit(v: NumberPicker, min: Int, max: Int, initValue: Int) {
        v.minValue = min
        v.maxValue = max
        v.value = initValue
    }

    private fun getSelectedTime(): String {
        val month = getConvertedTime(binding.npMonth.value.toString())
        val day = getConvertedTime(binding.npDay.value.toString())
        val hours = getConvertedTime(binding.npHour.value.toString())
        val minutes = getConvertedTime(binding.npMinute.value.toString())
        return "2023" + "-" + month + "-" + day + "T" + hours + ":" + minutes + ":" + "00"
    }

    private fun getConvertedTime(value: String): String {
        if(value.length == 1) {
            return "0" + value
        }
        return value
    }


}