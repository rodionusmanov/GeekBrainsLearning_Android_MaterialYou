package com.example.materialyou.utils

import androidx.fragment.app.Fragment
import com.example.materialyou.R
import com.example.materialyou.view.notesRecyclerView.Data
import com.example.materialyou.view.notesRecyclerView.TYPE_HEADER_PICTURE
import com.example.materialyou.view.notesRecyclerView.TYPE_STANDART
import com.example.materialyou.view.planetsViewPager.PlanetsFragment

var wikiRequest: String = ""
var descriptionHeader: String? = null
var descriptionBody: String? = null
var themeState: String = "default_theme"
var bottomNavigationViewState: Fragment = PlanetsFragment()

const val longDuration = 1000L
const val shortDuration =500L

const val startRotationPosition = 0f
const val finishRotationPositionAnimationPODFragment = -600f
const val finishRotationPositionPODFragment = -135f

const val startPositionY = 0f
const val activePositionContainerOneY = -225f
const val activePositionContainerTwoY = -130f

const val activePositionWikiContainerY = 140f
const val activePositionDescriptionContainerY = 120f

const val startAlpha = 0.0F
const val activeAlpha = 0.8F
const val finishAlpha = 1.0F

val rainbowIdColor = arrayOf(
    R.color.rainbowA,
    R.color.rainbowB,
    R.color.rainbowC,
    R.color.rainbowD,
    R.color.rainbowE,
    R.color.rainbowF,
    R.color.rainbowG,
    R.color.rainbowH,
    R.color.rainbowI,
    R.color.rainbowJ,
    R.color.rainbowK,
    R.color.rainbowL,
    R.color.rainbowM,
    R.color.rainbowN,
    R.color.rainbowO,
    R.color.rainbowP,
    R.color.rainbowQ,
    R.color.rainbowR,
    R.color.rainbowS,
    R.color.rainbowT,
    R.color.rainbowU,
    R.color.rainbowV,
    R.color.rainbowW,
    R.color.rainbowX,
    R.color.rainbowY,
    R.color.rainbowZ,
    R.color.rainbowAa,
    R.color.rainbowAb,
    R.color.rainbowAc,
    R.color.rainbowAd,
    R.color.rainbowAe,
    R.color.rainbowAf,
    R.color.rainbowAg,
    R.color.rainbowAh,
    R.color.rainbowAi,
    R.color.rainbowAj
)

val defaultData = arrayListOf(
    Data(TYPE_STANDART, "NOTE 1", "description 1", R.drawable.sun, false),
    Data(TYPE_STANDART, "NOTE 2", "description 2", R.drawable.mercury, false),
    Data(
        TYPE_HEADER_PICTURE, "NOTE 3", "description 3", R.drawable.earth, false
    ),
    Data(
        TYPE_STANDART, "NOTE 4", "description 4", R.drawable.mars, false
    )
)