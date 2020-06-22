package com.example.multistreamaterialplaceholdercard.listeners

import android.view.View

interface PlaceHolderViewListener {
    fun onClick(position: Int, itemView: View)
    fun onCircleClick(position: Int, itemView: View)
}