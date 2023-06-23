package com.example.protalktime.util

object Constants {

    val userInfo = UserInfo("1")

    // 매칭 메인 페이지 칩 그룹 관련 칩셋
    val chipSetByInUniversity = listOf(
        "후생관",
        "기숙사",
        "어문관"
    )

    val chipSetByOutside = listOf(
        "외대 사거리",
        "모현 사거리"
    )

    // 매칭 작성 페이지 칩 그룹 관련 칩셋
    val chipSetByWhoSaengGwan = listOf(
        "바비든든",
        "학생식당",
        "교직원 식당",
        "맘스터치",
        "편의점",
        "상관없음"
    )

    val chipByDomitoryRoom = listOf(
        "기숙사 식당"
    )

    val chipByMoonGwan = listOf(
        "학생식당",
        "파스타",
        "상관없음"
    )

    val matchingCategoryTitle = listOf(
        "기본 위치 - ",
        "세부 위치 - ",
        "희망하는 음식 - "
    )
}