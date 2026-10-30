package com.example.build_a_grid.data

import com.example.build_a_grid.R
import com.example.build_a_grid.model.Block

class Datasource() {
    fun loadBlocks(): List<Block> {
        return listOf<Block>(
            return listOf(
                Block(R.drawable.architecture, R.string.architecture, 58),
                Block(R.drawable.automotive, R.string.automotive, 30),
                Block(R.drawable.biology, R.string.biology, 90),
                Block(R.drawable.crafts, R.string.crafts, 121),
                Block(R.drawable.business, R.string.business, 78),
                Block(R.drawable.culinary, R.string.culinary, 118),
                Block(R.drawable.design, R.string.design, 423),
                Block(R.drawable.ecology, R.string.ecology, 28),
                Block(R.drawable.engineering, R.string.engineering, 67),
                Block(R.drawable.fashion, R.string.fashion, 92),
                Block(R.drawable.finance, R.string.finance, 100),
                Block(R.drawable.film, R.string.film, 165),
                Block(R.drawable.gaming, R.string.gaming, 37),
                Block(R.drawable.geology, R.string.geology, 290),
                Block(R.drawable.drawing, R.string.drawing, 326),
                Block(R.drawable.history, R.string.history, 189),
                Block(R.drawable.journalism, R.string.journalism, 96),
                Block(R.drawable.law, R.string.law, 58),
                Block(R.drawable.lifestyle, R.string.lifestyle, 305),
                Block(R.drawable.music, R.string.music, 212),
                Block(R.drawable.painting, R.string.painting, 172),
                Block(R.drawable.photography, R.string.photography, 321),
                Block(R.drawable.physics, R.string.physics, 41),
                Block(R.drawable.tech, R.string.tech, 118)
            )
        )
    }
}