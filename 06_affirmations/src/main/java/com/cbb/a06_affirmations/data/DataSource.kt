package com.cbb.a06_affirmations.data

import com.cbb.a06_affirmations.R
import com.cbb.a06_affirmations.model.Affirmation

class DataSource {

    fun loadAffirmation():List<Affirmation>{
        return listOf(
            Affirmation(R.string.affirmation1,R.mipmap.image1),
            Affirmation(R.string.affirmation2,R.mipmap.image2),
            Affirmation(R.string.affirmation3,R.mipmap.image3),
            Affirmation(R.string.affirmation4,R.mipmap.image4),
            Affirmation(R.string.affirmation5,R.mipmap.image5),
            Affirmation(R.string.affirmation6,R.mipmap.image6),
            Affirmation(R.string.affirmation7,R.mipmap.image7),
            Affirmation(R.string.affirmation8,R.mipmap.image8),
            Affirmation(R.string.affirmation9,R.mipmap.image9),
            Affirmation(R.string.affirmation10,R.mipmap.image10)
        )
    }
}