package com.example.build_a_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.build_a_grid.R
import com.example.build_a_grid.data.Datasource
import com.example.build_a_grid.model.Block
import com.example.build_a_grid.ui.theme.BuildaGridTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildaGridTheme {
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
    BuildaGridTheme {
        Greeting("Android")
    }
}


@Composable
fun BlockCard(block: Block, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row() {
            Image(painter = painterResource(block.imageResourceId),
                contentDescription = "", modifier = Modifier.size(68.dp),
                contentScale = ContentScale.Crop
            )
            Column() {
                Text(text = stringResource( block.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium
                    ,
                    modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 8.dp))
                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "",
                        modifier = Modifier.padding(start = 16.dp).size(32.dp)
                    )
                    Text(text = block.availableCourses.toString(),
                        modifier = Modifier.padding(start = 8.dp), style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

@Composable
fun BlockGrid_2(blocks: List<Block>,modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(blocks.size){block ->
            BlockCard(block = blocks[block], modifier = Modifier.padding(8.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BlockGrid_2Preview() {
    BuildaGridTheme {
        BlockGrid_2(blocks = Datasource().loadBlocks())
    }
}

@Preview(showBackground = true)
@Composable
private fun BlockCardPreview() {
    BuildaGridTheme {
        BlockCard(Block(R.drawable.architecture, R.string.architecture, 58))
    }
}