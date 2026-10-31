package com.example.superheroes

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperHeroesTheme {
        Greeting("Android")
    }
}


@Composable
fun HeroBlock(hero: Hero, modifier: Modifier){
    Card(modifier = modifier){
        Row(){
            Column(){
                Text(text = stringResource(hero.nameRes), style = MaterialTheme.typography.displayLarge)
                Text(text = stringResource(hero.descriptionRes), style = MaterialTheme.typography.bodyLarge)
            }
            Image(painter = painterResource(hero.imageRes), contentDescription = "")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HereBlockPreview(){
    SuperHeroesTheme {
        HeroBlock(hero = Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1), modifier = Modifier)
    }
}
