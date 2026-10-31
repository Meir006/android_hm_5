package com.example.superheroes

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HerosColumn(heroes = HeroesRepository.heroes,
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Composable
fun HeroBlock(hero: Hero, modifier: Modifier){
    Card(modifier = modifier,
        elevation = CardDefaults.cardElevation(2.dp)){
        Row(modifier = Modifier.padding(16.dp).height(72.dp)){
            Column(){
                Text(text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displayLarge)

                Text(text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.width(16.dp))
            Image(painter = painterResource(hero.imageRes),
                contentDescription = "",contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.small))
        }

    }
}


@Composable
fun HerosColumn(heroes: List<Hero>,modifier: Modifier = Modifier){
    LazyColumn(){
        items(heroes.size){hero ->
            HeroBlock(hero = heroes[hero], modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        }

    }
}

@Preview
@Composable
fun HeroesColumnPreview(){
    SuperHeroesTheme {
        HerosColumn(heroes = HeroesRepository.heroes)
    }

}


@Preview(showBackground = true)
@Composable
fun HereBlockPreview(){
    SuperHeroesTheme {
        HeroBlock(hero = Hero(R.string.hero1,
            R.string.description1,
            R.drawable.android_superhero1),
            modifier = Modifier)
    }
}
